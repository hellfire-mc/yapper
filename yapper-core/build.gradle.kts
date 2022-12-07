plugins {
    java
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.7.21"
}

dependencies {
    // Kotlin Standard Library
    compileOnly(kotlin("stdlib"))
    // API
    implementation(project(":yapper-api"))
    // HTTP and Serialization
    implementation("com.github.kittinunf.fuel:fuel:${project.extra["fuel_version"]}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    // Kreds
    implementation("io.github.crackthecodeabhi:kreds:0.8")
    // Hoplite
    implementation("com.sksamuel.hoplite:hoplite-core:2.7.0")
    implementation("com.sksamuel.hoplite:hoplite-toml:2.7.0")
}
