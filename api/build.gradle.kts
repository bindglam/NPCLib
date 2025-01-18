dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.3-R0.1-SNAPSHOT")
    compileOnly("net.citizensnpcs:citizens-main:2.0.35-SNAPSHOT") {
        exclude(group = "*", module = "*")
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}