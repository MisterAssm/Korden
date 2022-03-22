import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
}

group = "fr.misterassm.korden"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(platform(Kotlin.stdlib.jdk8))
        implementation(KotlinX.serialization.json)
        implementation(KotlinX.coroutines.core)
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-module-name",
                project.path.replace(":", ""),
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xjsr305=strict")
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
    }
}
