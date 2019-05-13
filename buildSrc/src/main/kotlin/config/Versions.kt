package config

object BuildGradlePluginsVersions {
    val gradlePluginVersion = AGP.version
    // FIXME 4.2.0 fails on incremental compilation from AS 3.3.1
    const val googleServicesGradlePluginVersion = "4.1.0"
    const val kotlinVersion = "1.3.21"
}

object RxJavaVersions {
    const val rxJava2Version = "2.2.4"
    const val rxAndroidVersion = "2.1.0"
    const val rxJava2DebugVersion = "1.4.0"
}

object LibVersions {
    const val daggerVersion = "2.22.1"

    object Network {
        const val okHttpVersion = "3.12.1"
        const val retrofitVersion = "2.5.0"
        const val converterMoshiVersion = retrofitVersion
        const val moshiVersion = "1.8.0"
    }

    // Waiting for merge of https://github.com/JakeWharton/butterknife/pull/1445 to remove build warning
    const val butterKnifeVersion = "10.1.0"

    const val threetenAbpVersion = "1.1.0"

    const val glideVersion = "4.8.0"
}

object AndroidXVersions {
    object ArchComponent {
        const val androidXArchCoreVersion = "2.0.0"
        const val androidXArchLifecycleVersion = "2.0.0"
        const val androidXArchLiveDataVersion = "2.0.0"
        const val androidXArchViewModelVersion = "2.0.0"
        const val androidXArchRoomVersion = "2.0.0"
        const val androidXArchPagingVersion = "2.0.0"
    }

    const val androidXCoreVersion = "1.0.1"
    const val androidXCoreKtxVersion = "1.0.0"
    const val androidXFragmentKtxVersion = "1.0.0"
    const val androidXAppCompatVersion = "1.0.2"
    const val androidXFragmentVersion = "1.0.0"
    const val androidXMaterialVersion = "1.1.0-alpha05"

    const val androidXCardViewVersion = "1.0.1"
    const val androidXConstraintLayoutVersion = "1.1.3"
    const val androidXRecyclerViewVersion = "1.0.0"
    const val androidXBrowserVersion = "1.0.0"
    const val androidXMediaVersion = "1.0.0"
    const val androidXAnnotationVersion = "1.0.0"
    const val androidXPreferenceVersion = "1.0.0"
    const val androidXMultidexVersion = "2.0.1"
    const val androidXGridLayoutVersion = "1.0.0"
    const val androidXDrawerLayoutVersion = "1.0.0"
}

object TestingVersions {
    const val androidXTestEspressoVersion = "3.1.1"
    const val androidXTestUiAutomatorVersion = "2.2.0"
    const val androidXTestOrchestratorVersion = "1.1.1"

    const val testJUnitVersion = "4.13-beta-2"
    const val testRobolectricVersion = "4.2"
    const val testGoogleTruthVersion = "0.43"
}