import java.io.File
import java.util.*

object AGP {

    val version: String
        get() = props.getProperty("agpVersion")

    val lib: String
        get() = props.getProperty("agpLib")


    private val props = gradleProperties()

    private fun gradleProperties(): Properties {
        val props = Properties()
        props.load(File("buildSrc/gradle.properties").inputStream())
        return props
    }
}