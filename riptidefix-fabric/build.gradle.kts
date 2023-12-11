@file:Suppress("PropertyName")

val minecraft_version: String by rootProject.extra
val yarn: String by rootProject.extra
val fabric_loader: String by rootProject.extra
val fabric_api: String by rootProject.extra
val modmenu: String by rootProject.extra

plugins {
  id("fabric-loom") version "1.4-SNAPSHOT"
}

dependencies {
  minecraft("com.mojang:minecraft:$minecraft_version")
  mappings("net.fabricmc:yarn:$yarn:v2")

  modImplementation("net.fabricmc:fabric-loader:$fabric_loader")
  modApi("net.fabricmc.fabric-api:fabric-api:$fabric_api")

  modImplementation("com.terraformersmc:modmenu:$modmenu")
}

tasks {
  remapJar {
    val jar = jar.get();

    archiveBaseName.set(jar.archiveBaseName)
    archiveAppendix.set(jar.archiveAppendix)
    archiveVersion.set(jar.archiveVersion)
    archiveClassifier.set("fabric")

    destinationDirectory.set(jar.destinationDirectory)
  }

  jar {
    archiveClassifier.set("fabric-dev")
  }

  withType<ProcessResources> {
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
      expand("version" to rootProject.version)
    }
  }
}
