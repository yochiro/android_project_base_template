import java.io.File

enum class ModuleType(val suffix: String) { APP("app"), LIBRARY("lib"), FEATURE("feature") }

class ScriptFiles(private val baseBuildScriptPath: File, private val useKTS: Boolean = false) {
    private fun buildScriptPath(moduleType: ModuleType) =
        File(baseBuildScriptPath, "build_${moduleType.suffix}.$fileExt")
    private fun buildScriptPath(filename: String) = File(baseBuildScriptPath, "$filename.$fileExt")
    private val fileExt = "gradle${if (useKTS) ".kts" else ""}"

    val baseBuildScriptFile = buildScriptPath("base_build")
    val appBuildScriptFile = buildScriptPath(ModuleType.APP)
    val libModuleBuildScriptFile = buildScriptPath(ModuleType.LIBRARY)
    val featureModuleBuildScriptFile = buildScriptPath(ModuleType.FEATURE)
    val daggerBuildScriptFile = buildScriptPath("dagger")
    val archComponentsBuildScriptFile = buildScriptPath("arch")
}