plugins {
    java
    `java-library`
}

dependencies {
    // Kyori Adventure
    implementation("net.kyori:adventure-api:4.12.0")
    // Lombok
    compileOnly("org.projectlombok:lombok:${project.extra["lombok_version"]}")
    annotationProcessor("org.projectlombok:lombok:${project.extra["lombok_version"]}")
    // Jetbrains Annotations
    compileOnly("org.jetbrains:annotations:${project.extra["jetbrains_annotations_version"]}")
    annotationProcessor("org.jetbrains:annotations:${project.extra["jetbrains_annotations_version"]}")
}
