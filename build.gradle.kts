subprojects {
    apply(plugin = "java-library")

    group = "io.github.bindglam"
    version = "1.0-SNAPSHOT"

    repositories {
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://maven.citizensnpcs.co/repo")
        mavenCentral()
    }
}