plugins {
    java
    id("com.diffplug.spotless") version "6.12.0"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

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
        googleJavaFormat("1.8").aosp().reflowLongStrings()
        formatAnnotations()
    }
    kotlin {
        ktlint()
    }
    kotlinGradle {
        ktlint()
    }
}
