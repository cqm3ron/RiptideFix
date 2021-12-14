@file:Suppress("PropertyName")

val minecraft_version: String by rootProject.extra
val yarn: String by rootProject.extra
val fabric_loader: String by rootProject.extra
val fabric_api: String by rootProject.extra
val modmenu: String by rootProject.extra

plugins {
  id("fabric-loom") version "0.10-SNAPSHOT"
}

dependencies {
  minecraft("com.mojang:minecraft:$minecraft_version")
  mappings("net.fabricmc:yarn:$yarn:v2")

  modImplementation("net.fabricmc:fabric-loader:$fabric_loader")
  modApi("net.fabricmc.fabric-api:fabric-api:$fabric_api")

  modImplementation("com.terraformersmc:modmenu:$modmenu")
}

tasks {
  withType<ProcessResources> {
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
      expand("version" to rootProject.version)
    }
  }
}