import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.0"
    id("maven-publish")
}

group = "starry.bot"
version = "1.0.0"

repositories {
    mavenCentral()
}

subprojects {
    tasks.withType<KotlinCompile> {
        kotlin {
            jvmToolchain(21)
        }
    }
}

configure<PublishingExtension> {
    publications.create<MavenPublication>("maven") {
        from(components.getByName("kotlin"))
    }
}

