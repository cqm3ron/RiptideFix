group = "com.github.ricky12awesome"
version = "1.0-SNAPSHOT"

subprojects {
  repositories {
    maven("https://maven.terraformersmc.com/releases/")
    mavenCentral()
  }

  tasks {
    withType<JavaCompile> {
      options.encoding = "UTF-8"
      options.release.set(17)
      targetCompatibility = "17"
      sourceCompatibility = "17"
    }
  }
}