// Requires package to allow nested object access in build.gradle
// https://github.com/handstandsam/AndroidDependencyManagement/issues/4
package config

import org.gradle.api.JavaVersion

object AndroidCompileOptions {

    const val compileSdkVersion = 28
    const val minSdkVersion = 21
    const val targetSdkVersion = 28
    val javaVersion = JavaVersion.VERSION_1_8
}