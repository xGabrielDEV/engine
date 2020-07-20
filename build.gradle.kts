plugins {
    kotlin("jvm") version "1.3.72"
}

group = "com.engine.project"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    compileOnly("com.github.SaiintBrisson:command-framework:00b3bf0775")
    compileOnly("com.destroystokyo.paper:paper-api:1.12.2-R0.1-SNAPSHOT")
    compileOnly("com.github.azbh111:craftbukkit-1.8.8:R")

    testCompileOnly("com.destroystokyo.paper:paper-api:1.12.2-R0.1-SNAPSHOT")
    testCompileOnly("com.github.azbh111:craftbukkit-1.8.8:R")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}