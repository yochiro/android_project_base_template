import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.kotlin.dsl.ScriptHandlerScope
import java.net.URI

fun RepositoryHandler.maven(repoUrl: String): MavenArtifactRepository {
    return maven { url = URI(repoUrl) }
}

fun Project.repositoriesFrom(listOfRepos: List<String>) {
    repositories.run {
        listOfRepos.forEach { repo ->
            maven(repo)
        }
    }
}

fun ScriptHandlerScope.repositoriesFrom(listOfRepos: List<String>) {
    repositories.run {
        listOfRepos.forEach { repo ->
            maven(repo)
        }
    }
}

fun ScriptHandlerScope.dependenciesFrom(listOfDeps: List<String>) {
    dependencies.run {
        listOfDeps.forEach { repo ->
            classpath(repo)
        }
    }
}
