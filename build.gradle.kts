import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.5"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.6")
	implementation("org.springframework.boot:spring-boot-starter-web")

	testImplementation("com.ninja-squad:springmockk:3.1.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.kotest.extensions:kotest-extensions-spring:1.1.0")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:5.1.0")
	testImplementation("io.mockk:mockk:1.12.3")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
