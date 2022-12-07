plugins {
    java
    id("fabric-loom")
    kotlin("jvm") version "1.7.20"
}

version = project.extra["mod_version"] as String
group = project.extra["maven_group"] as String

dependencies {
    // Core
    implementation(project(":yapper-api"))
    implementation(project(":yapper-core"))

    // Minecraft
    minecraft("com.mojang", "minecraft", project.extra["minecraft_version"] as String)
    mappings("net.fabricmc", "yarn", project.extra["yarn_mappings"] as String, null, "v2")
    modImplementation("net.fabricmc", "fabric-loader", project.extra["loader_version"] as String)

    // Fabric
    modImplementation("net.fabricmc.fabric-api", "fabric-api", project.extra["fabric_version"] as String)
    modImplementation("net.fabricmc", "fabric-language-kotlin", project.extra["fabric_language_kotlin_version"] as String)

    // Kyori Adventure
    modImplementation(include("net.kyori:adventure-platform-fabric:5.5.0")!!)
}

tasks {
    processResources {
        filesMatching("fabric.mod.json") { expand(mutableMapOf("version" to project.extra["mod_version"] as String, "fabricloader" to project.extra["loader_version"] as String, "fabric_api" to project.extra["fabric_version"] as String, "fabric_language_kotlin" to project.extra["fabric_language_kotlin_version"] as String, "minecraft" to project.extra["minecraft_version"] as String, "java" to project.extra["java_version"] as String)) }
        filesMatching("*.mixins.json") { expand(mutableMapOf("java" to project.extra["java_version"] as String)) }
    }
}
