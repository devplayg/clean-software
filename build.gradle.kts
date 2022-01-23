plugins {
    kotlin("jvm") version "1.5.10"
}

group = "clean.sw"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("org.jetbrains.kotlin", "kotlin-test-junit5", "1.5.10")
}

tasks.test {
    useJUnitPlatform()
}