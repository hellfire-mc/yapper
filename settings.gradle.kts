rootProject.name = "yapper"

include(
    "yapper-api",
    "yapper-core",
    "yapper-paper",
    "yapper-fabric"
)

// Fabric Repository Management
pluginManagement {
    repositories {
        maven("https://maven.fabricmc.net") { name = "Fabric" }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("fabric-loom").version(settings.extra["loom_version"] as String)
        kotlin("jvm").version(settings.extra["kotlin_version"] as String)
    }
}
