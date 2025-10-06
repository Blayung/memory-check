package com.blay.memcheck;

import net.fabricmc.api.DedicatedServerModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.text.StringCharacterIterator;

public class MemoryCheck implements DedicatedServerModInitializer {
    private String humanReadableBytes(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        StringCharacterIterator ci = new StringCharacterIterator("kMGT");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }
 
    private void sendLabeledResponseBytesOutOfLimit(ServerCommandSource cmdSource, String label, long bytes, long memoryLimit) {
        cmdSource.sendMessage(Text.literal(String.format("%s: %s (%.1f%%)", label, humanReadableBytes(bytes), (float) bytes / memoryLimit * 100)));
    }

    @Override
    public void onInitializeServer() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
            CommandManager.literal("memcheck").executes(context -> {
                ServerCommandSource cmdSource = context.getSource();

                cmdSource.sendMessage(Text.literal(" Memory Usage"));
                cmdSource.sendMessage(Text.literal("=============="));
    
                Runtime runtime = Runtime.getRuntime();

                long memoryLimit = runtime.maxMemory();

                cmdSource.sendMessage(Text.literal("Limit: " + humanReadableBytes(memoryLimit)));

                long allocatedMemory = runtime.totalMemory();

                sendLabeledResponseBytesOutOfLimit(cmdSource, "Allocated", allocatedMemory, memoryLimit);
                sendLabeledResponseBytesOutOfLimit(cmdSource, "Used", allocatedMemory - runtime.freeMemory(), memoryLimit);

                return 1;
            })
        ));
    }
}
