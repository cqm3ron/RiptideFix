@file:Suppress("PropertyName")

val minecraft_version: String by rootProject.extra
val forge_version: String by rootProject.extra
val forge_mappings: String by rootProject.extra
val forge_mixin: String by rootProject.extra

plugins {
  id("net.minecraftforge.gradle") version "5.1.26"
  id("org.spongepowered.mixin") version "0.7-SNAPSHOT"
}

minecraft {
  mappings("official", forge_mappings)

  runs {
    create("client") {
      workingDirectory(rootProject.file("run"))

      property("forge.logging.markers", "REGISTRIES")
      property("forge.logging.console.level", "debug")

      arg("-mixin.config=riptide_fix_forge.mixins.json")

      mods {
        create("riptide_fix") {
          source(sourceSets["main"])
        }
      }
    }
  }
}

mixin {
  add(sourceSets["main"], "riptide_fix_forge.refmap.json")
}

sourceSets["main"].resources.srcDir("src/generated/resources")

dependencies {
  minecraft("net.minecraftforge:forge:$minecraft_version-$forge_version")

  annotationProcessor("org.spongepowered:mixin:$forge_mixin:processor")
}

tasks.jar {
  archiveClassifier.set("forge")

  manifest {
    attributes("MixinConfigs" to "riptide_fix_forge.mixins.json")
  }

  finalizedBy("reobfJar")
}
