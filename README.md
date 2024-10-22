[![](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/requires/fabric-api_vector.svg)](https://modrinth.com/mod/fabric-api) [![](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg)](https://modrinth.com/mod/memory-check) ![](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/unsupported/forge_vector.svg)

# Memory Check

## What is this?
This is a minecraft fabric server mod that allows you to check your server's memory usage with a simple command.

## Downloads
You can download this mod on modrinth. [https://modrinth.com/mod/memory-check](https://modrinth.com/mod/memory-check)

## Usage
Just run the `/memcheck` command.

## How to compile this mod? (assuming you're on linux)
0. Make sure you have git and jdk 17 installed. If not, check these links out: [https://git-scm.com/downloads](https://git-scm.com/downloads), [https://www.oracle.com/pl/java/technologies/downloads](https://www.oracle.com/pl/java/technologies/downloads). You can also try to install these programs with your distro's package manager.
1. Clone the repo: `git clone https://github.com/Blayung/memory-check.git; cd memory-check`
2. Compile the mod: `./gradlew build`
3. Now the mod jar file should be in the `./build/libs` folder.
