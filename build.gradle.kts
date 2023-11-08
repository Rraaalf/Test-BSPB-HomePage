import io.qameta.allure.gradle.base.AllureExtension

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    `java-library`
    `maven-publish`
    id("io.qameta.allure") version "2.9.3"
}

repositories {
    mavenCentral()
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api("org.seleniumhq.selenium:selenium-java:4.14.1")
    api("io.github.bonigarcia:webdrivermanager:5.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("io.qameta.allure:allure-java-commons:2.24.0")
}

group = "org.example"
version = "1.0-SNAPSHOT"
description = "BSPB-HomePage"
java.sourceCompatibility = JavaVersion.VERSION_1_8

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}

tasks.test {
    testLogging {
        events ("passed", "skipped", "failed", "standardOut", "standardError")
    }
    useJUnitPlatform()
}


configure<AllureExtension> {
    version = "2.24.0"
    useJUnit5 {
        version = "2.24.0"
    }
}