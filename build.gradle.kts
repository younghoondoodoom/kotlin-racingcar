plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation ("org.junit.jupiter:junit-jupiter-api")
    testImplementation ("org.junit.jupiter:junit-jupiter-params")
    testImplementation("io.kotest:kotest-runner-junit5-jvm:4.4.3")
    testImplementation("io.kotest:kotest-assertions-core-jvm:4.4.3")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}
