import org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.adarshr.test-logger") version "2.0.0"
    id("com.github.ben-manes.versions") version "0.27.0"
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.3.60"
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    testImplementation("io.mockk:mockk:1.9.3")
    testImplementation("org.assertj:assertj-core:3.14.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    val junitVersion = "5.6.0-M1"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine:$junitVersion")

    // Additional test flavors
    /*
    testCompile("com.google.truth:truth:1.0")
    testCompile("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
    testCompile("com.willowtreeapps.assertk:assertk-jvm:0.19")
    testCompile("junit:junit:4.12")

    val kotlinTestVersion = "3.4.0"
    testCompile("io.kotlintest:kotlintest-assertions:$kotlinTestVersion")
    testCompile("io.kotlintest:kotlintest-core:$kotlinTestVersion")
    testCompile("io.kotlintest:kotlintest-runner-junit5:$kotlinTestVersion")

    testImplementation("io.strikt:strikt-core:0.21.1")
    testImplementation("org.amshove.kluent:kluent:1.453")
    testImplementation("org.hamcrest:hamcrest-all:1.3")
    testImplementation("org.mockito:mockito-junit-jupiter:3.0.0")

    val kotlinDotTestVersion = "1.3.50"
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinDotTestVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinDotTestVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinDotTestVersion")

    val spekVersion = "2.0.6"
    testCompile("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntime("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    */
}

tasks.clean {
    doFirst {
        delete("out")
    }
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = FULL
        events("passed", "skipped", "failed", "standard_error", "standard_out")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
}

apply {
    from(file("detekt/detekt.gradle"))
    from(file("ktlint/ktlint.gradle"))
}