plugins {
    kotlin("jvm") version "2.4.0"
    application
}

group = "org.ruslan.omalaev"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("ProgramKt")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(25)
}

tasks.test {
    useJUnitPlatform()
}