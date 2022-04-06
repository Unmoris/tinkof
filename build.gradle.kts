plugins {
    id("org.springframework.boot") version "2.6.4"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.spring") version "1.6.10"
}

group = "ru.tinkoff.fintech"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.6")
    implementation("org.springframework.boot:spring-boot-starter-web")

    testImplementation("io.mockk:mockk:1.12.3")

    testImplementation("com.ninja-squad:springmockk:3.1.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.2.0")
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}