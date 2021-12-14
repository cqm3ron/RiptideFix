rootProject.name = "riptidefix"

include(":riptidefix-forge", ":riptidefix-fabric")

pluginManagement {
  repositories {
    gradlePluginPortal()
    maven("https://maven.fabricmc.net/")
    maven("https://files.minecraftforge.net/maven")
    maven("https://repo.spongepowered.org/repository/maven-public/")
    mavenCentral()
  }

  resolutionStrategy {
    eachPlugin {
      if (requested.id.id == "net.minecraftforge.gradle") {
        useModule("net.minecraftforge.gradle:ForgeGradle:${requested.version}")
      }

      if (requested.id.id == "org.spongepowered.mixin") {
        useModule("org.spongepowered:mixingradle:${requested.version}")
      }
    }
  }
}