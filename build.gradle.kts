@Suppress("PropertyName")

val minecraft_version: String by rootProject.extra

group = "com.github.ricky12awesome"
version = "2.0"

plugins {
  java
}

subprojects {
  apply<JavaPlugin>()

  repositories {
    maven("https://maven.terraformersmc.com/releases/")
    mavenCentral()
  }

  java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
  }

  tasks {
    jar {
      archiveBaseName.set("riptide_fix")
      archiveAppendix.set(minecraft_version)
      archiveVersion.set(rootProject.version.toString())

      manifest {
        attributes(
          "Specification-Title" to "riptide_fix",
          "Specification-Vendor" to "Ricky12Awesome",
          "Specification-Version" to "1",
          "Implementation-Title" to rootProject.name,
          "Implementation-Version" to rootProject.version,
          "Implementation-Vendor" to "Ricky12Awesome",
        )
      }

      destinationDirectory.set(rootProject.file("jars"))
    }

    withType<JavaCompile> {
      options.encoding = "UTF-8"
      options.release.set(17)
      targetCompatibility = "17"
      sourceCompatibility = "17"
    }
  }
}