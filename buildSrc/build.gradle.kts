import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories.jcenter()
    repositories.google()
    dependencies {
        classpath(kotlin("gradle-plugin"))
    }

    configurations.classpath.get().resolutionStrategy {
        eachDependency {
            if (requested.group == "org.jetbrains.kotlin") {
                useVersion(embeddedKotlinVersion)
            }
        }
    }
}

allprojects {
    tasks.withType(KotlinCompile::class.java).configureEach {
        kotlinOptions {
            freeCompilerArgs = freeCompilerArgs + listOf("-Werror")
        }
    }
}

plugins {
    id("java")
}
apply {
    plugin("kotlin")
}

repositories {
    google()
    jcenter()
}

val agpLib: String by project
dependencies {
    "compileOnly"(gradleKotlinDsl())
    "compile"(agpLib)
    "compile"(kotlin("gradle-plugin"))
    "compile"(gradleApi())
}