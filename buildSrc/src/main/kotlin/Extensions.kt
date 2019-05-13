import com.sun.org.apache.bcel.internal.Repository
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.api.artifacts.repositories.MavenArtifactRepository
import org.gradle.kotlin.dsl.ScriptHandlerScope
import java.net.URI

fun RepositoryHandler.maven(repoUrl: String): MavenArtifactRepository {
    return maven { it.url = URI(repoUrl) }
}

fun Project.repositoriesFrom(listOfRepos: List<String>): Project =
    also {

        repositories.run {
            listOfRepos.forEach { repo ->
                maven(repo)
            }
        }
    }

fun Project.implementationDependenciesFrom(listOfDeps: List<String>): Project =
    also {
        dependencies.run {
            listOfDeps.forEach { dep ->
                implementation(dep)
            }
        }
    }

fun Project.annotationProcessors(listOfDeps: List<String>): Project =
    also {
        dependencies.run {
            listOfDeps.forEach { dep ->
                kapt(dep)
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

fun DependencyHandler.implementation(dependency: Any) {
    add("implementation", dependency)
}

fun DependencyHandler.androidTestImplementation(dependency: Any) {
    add("androidTestImplementation", dependency)
}

fun DependencyHandler.testImplementation(dependency: Any) {
    add("testImplementation", dependency)
}

fun DependencyHandler.kapt(dependency: Any) {
    add("kapt", dependency)
}

fun DependencyHandler.kaptTest(dependency: Any) {
    add("kaptTest", dependency)
}

fun DependencyHandler.kaptAndroidTest(dependency: Any) {
    add("kaptAndroidTest", dependency)
}
