package plugins

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.kotlin.dsl.buildscript
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import repositoriesFrom

fun JavaPluginConvention.configureJava() {
    sourceCompatibility = config.AndroidCompileOptions.javaVersion
    targetCompatibility = config.AndroidCompileOptions.javaVersion
}


// Gradle Project extensions

fun Project.useKotlin(): Project =
    this.also { project ->
        project.apply {
            it.plugin("kotlin-android")
            it.plugin("kotlin-android-extensions")
            it.plugin("kotlin-kapt")
        }

        tasks.withType<KotlinCompile>().configureEach {
            it.kotlinOptions {
                freeCompilerArgs = freeCompilerArgs + listOf(
                    "-module-name",
                    project.path.substring(1).replace(':', '.')
                )
            }
        }
    }

fun Project.configureBasicDeps(): Project =
    this.also {
        it.buildscript {
            repositories.jcenter()
            repositories.google()
            repositoriesFrom(config.Repos.buildRepoUrls)
        }
        it.repositories.jcenter()
        it.repositories.google()
        it.repositoriesFrom(config.Repos.dependenciesRepoUrls)
    }


// Custom plugin extensions

fun BaseExtension.configureCommonBase() {

    compileSdkVersion(config.AndroidCompileOptions.compileSdkVersion)

    defaultConfig.apply {
        minSdkVersion(config.AndroidCompileOptions.minSdkVersion)
        targetSdkVersion(config.AndroidCompileOptions.targetSdkVersion)

        javaCompileOptions.apply {
            annotationProcessorOptions.includeCompileClasspath = true
        }
    }

    compileOptions.apply {
        sourceCompatibility = config.AndroidCompileOptions.javaVersion
        targetCompatibility = config.AndroidCompileOptions.javaVersion
    }

    lintOptions.apply {
        disable =
            setOf("UnsupportedChromeOsHardware", "PermissionImpliesUnsupportedChromeOsHardware")
        isCheckAllWarnings = true
        isCheckReleaseBuilds = true
    }
}


// Android plugin extensions

fun LibraryExtension.configureLibrary() {
    buildTypes { buildTypes ->
        buildTypes.getByName("release") {
            it.isMinifyEnabled = true
        }
    }
}