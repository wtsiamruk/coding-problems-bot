import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.4.20"
//    id("com.github.johnrengelman.shadow").version("6.1.0")

    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven central for resolving dependencies.
    mavenCentral()
    jcenter() // deprecated jcenter for koin
}

val jacksonVersion = "2.12.1"
val koinVersion = "2.2.2"
val xCoroutinesVersion = "1.4.2"
val logbackVersion = "1.2.3"
val slf4jVersion = "1.7.30"
val junitVersion = "5.7.1"
val tgbotapiVersion = "0.32.5"
val selenideVersion = "5.18.1"
val flexmarkVersion = "0.62.2"
val progressbarVersion = "0.9.0"

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    //jackson support
    implementation(platform("com.fasterxml.jackson:jackson-bom:$jacksonVersion"))
    implementation("com.fasterxml.jackson.core:jackson-databind")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // DI library
    implementation("org.koin:koin-core:$koinVersion")

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Coroutines support
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$xCoroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$xCoroutinesVersion")

    // Logging framework
    implementation("ch.qos.logback:logback-core:$logbackVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("org.slf4j:slf4j-api:$slf4jVersion")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:29.0-jre")
    implementation("dev.inmo:tgbotapi:$tgbotapiVersion")
    implementation("com.codeborne:selenide:$selenideVersion")
    implementation("com.vladsch.flexmark:flexmark-all:$flexmarkVersion")
    implementation("me.tongfei:progressbar:$progressbarVersion")

    // Use JUnit 5 for testing.
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testRuntimeOnly(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    // DI testing
    testImplementation("org.koin:koin-test:$koinVersion")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
    }
    test {
        useJUnitPlatform()
    }
}

application {
    // Define the main class for the application.
    mainClass.set("by.jprof.coding.problems.bot.AppKt")
}
