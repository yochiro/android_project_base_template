plugins {
    `kotlin-dsl`
}

buildscript {
    repositoriesFrom(config.Repos.buildRepoUrls)
    repositories.jcenter()
    repositories.google()
    dependenciesFrom(config.Builds.basePlugins)
}
