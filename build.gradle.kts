import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    `kotlin-dsl`
}

idea {
    module {
        name = project.path.substring(1).split(':').joinToString("-")
    }
}

buildscript {
    repositoriesFrom(config.Repos.buildRepoUrls)
    repositories.jcenter()
    repositories.google()
    dependenciesFrom(config.Builds.basePlugins)
}

subprojects {
    buildscript {
        repositories.jcenter()
        repositories.google()
        repositoriesFrom(config.Repos.buildRepoUrls)
    }
    repositories.jcenter()
    repositories.google()
    repositoriesFrom(config.Repos.dependenciesRepoUrls)
}

repositories {
    jcenter()
}

val scriptFiles by extra { ScriptFiles(file("build_scripts")) }

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-module-name=${project.path.substring(1).replace(':', '.')}")
    }
}
