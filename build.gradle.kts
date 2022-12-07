plugins {
    java
    kotlin("jvm")
    id("com.diffplug.spotless") version "6.12.0"
}

allprojects {
    // configure repositories
    repositories {
        mavenCentral()
    }

    // apply plugins
    apply(plugin = "java")
    apply(plugin = "kotlin")
    apply(plugin = "com.diffplug.spotless")

    // configure spotless
    spotless {
        ratchetFrom("origin/main")

        format("misc") {
            // define the files to apply `misc` to
            target("*.gradle", "*.md", ".gitignore")

            // define the steps to apply to those files
            trimTrailingWhitespace()
            indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
            endWithNewline()
        }
        java {
            importOrder()
            googleJavaFormat("1.15.0").aosp().reflowLongStrings()
            formatAnnotations()
        }
        kotlin {
            ktlint()
        }
        kotlinGradle {
            ktlint()
        }
    }

    tasks.build.configure {
        dependsOn.add("spotlessApply")
    }
}

subprojects {
    val javaVersion = JavaVersion.toVersion((project.extra["java_version"] as String).toInt())

    // configure java version
    tasks {
        java {
            sourceCompatibility = javaVersion
            targetCompatibility = javaVersion
            withSourcesJar()
        }
        compileJava {
            options.encoding = "UTF-8"
            sourceCompatibility = javaVersion.toString()
            targetCompatibility = javaVersion.toString()
            options.release.set(javaVersion.toString().toInt())
        }
        compileKotlin {
            kotlinOptions {
                jvmTarget = javaVersion.toString()
            }
        }
        jar { from("LICENSE") { rename { "${it}_${base.archivesName}" } } }
    }
}
