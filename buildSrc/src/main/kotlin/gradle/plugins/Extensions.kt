package gradle.plugins

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

inline fun <reified T : BaseExtension> Project.proguardFiles(buildType: String, vararg files: Any): Project {
    val extension = project.extensions.getByType(T::class.java)
    extension.apply {
        buildTypes { buildTypes ->
            buildTypes.getByName(buildType).apply {
                proguardFiles(*files)
            }
        }
    }
    return this
}

inline fun <reified T : BaseExtension> Project.consumerProguardFiles(buildType: String, vararg files: Any): Project {
    val extension = project.extensions.getByType(T::class.java)
    extension.apply {
        buildTypes { buildTypes ->
            buildTypes.getByName(buildType).apply {
                consumerProguardFiles(*files)
            }
        }
    }
    return this
}


// Custom plugin extensions

fun BaseExtension.configureLintOptions() {
    lintOptions.apply {
        warning("InvalidPackage", "NewApi", "MissingRegistered", "AppLinksAutoVerifyError", "RequiredSize")
        disable = setOf("UnsupportedChromeOsHardware", "PermissionImpliesUnsupportedChromeOsHardware")
        isCheckAllWarnings = true
        isCheckReleaseBuilds = true
        isCheckDependencies = true
    }
}

fun BaseExtension.configureCommonBase() {

    compileSdkVersion(config.AndroidCompileOptions.compileSdkVersion)

    packagingOptions.apply {
        excludes = setOf(
            "META-INF/LICENSE",
            "META-INF/NOTICE",
            "META-INF/LICENSE.txt",
            "META-INF/NOTICE.txt",
            "META-INF/MANIFEST.MF",
            "LICENSE.txt"
        )
    }
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
}


// Android plugin extensions

fun LibraryExtension.configureLibrary() {
    buildTypes { buildTypes ->
        buildTypes.getByName("release") {
            it.isMinifyEnabled = true
            it.consumerProguardFile("proguard-rules.pro")
        }
    }
}
