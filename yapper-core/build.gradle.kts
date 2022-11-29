plugins {
    java
    kotlin("jvm")
}

dependencies {
    // Kotlin Standard Library
    compileOnly(kotlin("stdlib"))
    // Core
    implementation(project(":yapper-api"))
    // Fuel
    implementation("com.github.kittinunf.fuel:fuel:${project.extra["fuel_version"]}")
    // Kreds
    implementation("io.github.crackthecodeabhi:kreds:0.8")
    // Hoplite
    implementation("com.sksamuel.hoplite:hoplite-core:2.7.0")
}
