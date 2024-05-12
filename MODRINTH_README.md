[![](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/requires/fabric-api_vector.svg)](https://modrinth.com/mod/fabric-api) [![](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/github_vector.svg)](https://github.com/Blayung/memory-check) ![](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/unsupported/forge_vector.svg)

# Memory Check

## What is this mod?
This mod allows you to check your server's memory usage with a simple command.  
  
**This mod currently supports all minecraft versions from 1.19.2 to 1.20.6.**

## Usage
Just run the `/memcheck` command.

## How to compile this mod? (assuming you're on linux, probably only technical people interested)
0. Make sure you have git and jdk 21 installed. If not, check these links out: [https://git-scm.com/downloads](https://git-scm.com/downloads), [https://www.oracle.com/pl/java/technologies/downloads](https://www.oracle.com/pl/java/technologies/downloads). You can also try to install these programs with your distro's package manager.
1. Clone the repo: `git clone https://github.com/Blayung/memory-check.git; cd memory-check`
2. Compile the mod: `./gradlew build`
3. Now the mod jar file should be here: `./build/libs/memory-check-1.0.jar`
