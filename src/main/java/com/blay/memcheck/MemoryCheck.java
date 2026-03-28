package com.blay.memcheck;

import net.fabricmc.api.DedicatedServerModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

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
 
    private void sendLabeledResponseBytesAndLimit(CommandSourceStack commandSource, String label, long bytes, long byteLimit) {
        commandSource.sendSystemMessage(Component.literal(String.format("%s: %s (%.1f%%)", label, humanReadableBytes(bytes), (float) bytes / byteLimit * 100)));
    }

    @Override
    public void onInitializeServer() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
            Commands.literal("memcheck").executes(context -> {
                CommandSourceStack commandSource = context.getSource();

                commandSource.sendSystemMessage(Component.literal(" Memory Usage"));
                commandSource.sendSystemMessage(Component.literal("=============="));
    
                Runtime runtime = Runtime.getRuntime();

                long memoryLimit = runtime.maxMemory();

                commandSource.sendSystemMessage(Component.literal("Limit: " + humanReadableBytes(memoryLimit)));

                long allocatedMemory = runtime.totalMemory();

                sendLabeledResponseBytesAndLimit(commandSource, "Allocated", allocatedMemory, memoryLimit);
                sendLabeledResponseBytesAndLimit(commandSource, "Used", allocatedMemory - runtime.freeMemory(), memoryLimit);

                return 1;
            })
        ));
    }
}
