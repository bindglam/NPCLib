plugins {
    kotlin("jvm") version "2.0.0"
    id("com.gradleup.shadow") version "9.0.0-beta4"
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.1.20-Beta1")

    compileOnly("io.papermc.paper:paper-api:1.21.3-R0.1-SNAPSHOT")
    compileOnly("net.citizensnpcs:citizens-main:2.0.35-SNAPSHOT") {
        exclude(group = "*", module = "*")
    }

    implementation(project(":api"))
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.shadowJar {
    archiveFileName = "NPCLib.jar"
}