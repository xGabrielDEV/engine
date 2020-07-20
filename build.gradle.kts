plugins {
    kotlin("jvm") version "1.3.72"
}

group = "com.gabriel.engine.project"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()

    jcenter()

    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    compileOnly("com.destroystokyo.paper:paper-api:1.12.2-R0.1-SNAPSHOT")
    compileOnly("com.github.azbh111:craftbukkit-1.8.8:R")

    implementation("org.koin:koin-core:2.1.6")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}