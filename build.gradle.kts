plugins {
    java
    kotlin("jvm")
    id("com.diffplug.spotless") version "6.12.0"
}

allprojects {
    repositories {
        mavenCentral()
    }

    apply(plugin = "kotlin")
    apply(plugin = "com.diffplug.spotless")
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
