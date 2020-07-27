plugins {
    kotlin("jvm") version "1.3.72"
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

group = "com.engine.project"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()

    maven("https://jitpack.io/")
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.SaiintBrisson.command-framework:bukkit:-SNAPSHOT")

    compileOnly("com.destroystokyo.paper:paper-api:1.12.2-R0.1-SNAPSHOT")
    compileOnly("com.github.azbh111:craftbukkit-1.8.8:R")

    testCompileOnly("com.destroystokyo.paper:paper-api:1.12.2-R0.1-SNAPSHOT")
    testCompileOnly("com.github.azbh111:craftbukkit-1.8.8:R")
}
