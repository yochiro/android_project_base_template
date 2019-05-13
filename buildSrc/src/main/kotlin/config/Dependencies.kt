// Requires package to allow nested object access in build.gradle
// https://github.com/handstandsam/AndroidDependencyManagement/issues/4
package config

object Builds {
    private val androidGradlePlugin = AGP.lib
    private const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildGradlePluginsVersions.kotlinVersion}"
    private const val butterknifeGradlePlugin =
        "com.jakewharton:butterknife-gradle-plugin:${LibVersions.butterKnifeVersion}"

    const val googleServicesPlugin =
        "com.google.gms:google-services:${BuildGradlePluginsVersions.googleServicesGradlePluginVersion}"

    val basePlugins = listOf(
        androidGradlePlugin,
        kotlinGradlePlugin
    )
}

object Libs {

    object Dagger {

        object Kapt {
            const val daggerCompiler =
                "com.google.dagger:dagger-compiler:${LibVersions.daggerVersion}"
            const val daggerProcessor =
                "com.google.dagger:dagger-android-processor:${LibVersions.daggerVersion}"
        }

        const val dagger = "com.google.dagger:dagger:${LibVersions.daggerVersion}"
        const val daggerAndroid = "com.google.dagger:dagger-android:${LibVersions.daggerVersion}"
        const val daggerAndroidX =
            "com.google.dagger:dagger-android-support:${LibVersions.daggerVersion}"
    }

    object Butterknife {

        object Kapt {
            const val compiler =
                "com.jakewharton:butterknife-compiler:${LibVersions.butterKnifeVersion}"
        }

        const val core = "com.jakewharton:butterknife:${LibVersions.butterKnifeVersion}"
    }

    object OkHttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:${LibVersions.Network.okHttpVersion}"
        const val okhttpUrlConnection =
            "com.squareup.okhttp3:okhttp-urlconnection:${LibVersions.Network.okHttpVersion}"
        const val okhttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${LibVersions.Network.okHttpVersion}"
    }

    object Retrofit {
        const val moshi = "com.squareup.moshi:moshi:${LibVersions.Network.moshiVersion}"
        const val moshiAdapters =
            "com.squareup.moshi:moshi-adapters:${LibVersions.Network.moshiVersion}"
        const val retrofit =
            "com.squareup.retrofit2:retrofit:${LibVersions.Network.retrofitVersion}"
        const val moshiConverter =
            "com.squareup.retrofit2:converter-moshi:${LibVersions.Network.converterMoshiVersion}"
        const val rxJava2Adapter =
            "com.squareup.retrofit2:adapter-rxjava2:${LibVersions.Network.retrofitVersion}"
    }

    object RxJava2 {
        const val rxJava2 = "io.reactivex.rxjava2:rxjava:${RxJavaVersions.rxJava2Version}"
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${RxJavaVersions.rxAndroidVersion}"
        const val debug = "com.akaita.java:rxjava2-debug:${RxJavaVersions.rxJava2DebugVersion}"
    }

    object Glide {

        object Kapt {
            const val compiler = "com.github.bumptech.glide:compiler:${LibVersions.glideVersion}"
        }

        const val glide = "com.github.bumptech.glide:glide:${LibVersions.glideVersion}"
        const val webpdecoder = "com.zlc.glide:webpdecoder:1.2.${LibVersions.glideVersion}"
        const val annotations = "com.github.bumptech.glide:annotations:${LibVersions.glideVersion}"
    }

    object AndroidX {

        object Arch {
            const val core =
                "androidx.arch.core:core-common:${AndroidXVersions.ArchComponent.androidXArchCoreVersion}"

            object Lifecycle {

                object Kapt {
                    const val compiler =
                        "androidx.lifecycle:lifecycle-compiler:${AndroidXVersions.ArchComponent.androidXArchLifecycleVersion}"
                }

                const val common =
                    "androidx.lifecycle:lifecycle-common-java8:${AndroidXVersions.ArchComponent.androidXArchLifecycleVersion}"
                const val runtime =
                    "androidx.lifecycle:lifecycle-runtime:${AndroidXVersions.ArchComponent.androidXArchLifecycleVersion}"
                const val extensions =
                    "androidx.lifecycle:lifecycle-extensions:${AndroidXVersions.ArchComponent.androidXArchLifecycleVersion}"

                // Livedata
                const val livedataCore =
                    "androidx.lifecycle:lifecycle-livedata-core:${AndroidXVersions.ArchComponent.androidXArchLiveDataVersion}"
                const val livedata =
                    "androidx.lifecycle:lifecycle-livedata:${AndroidXVersions.ArchComponent.androidXArchLiveDataVersion}"

                const val viewmodel =
                    "androidx.lifecycle:lifecycle-viewmodel:${AndroidXVersions.ArchComponent.androidXArchViewModelVersion}"
                // RxJava support for LiveData
                const val reactivestreams =
                    "androidx.lifecycle:lifecycle-reactivestreams:${AndroidXVersions.ArchComponent.androidXArchLifecycleVersion}"
            }

            object Room {

                object Kapt {
                    const val compiler =
                        "androidx.room:room-compiler:${AndroidXVersions.ArchComponent.androidXArchRoomVersion}"
                }

                const val common =
                    "androidx.room:room-common:${AndroidXVersions.ArchComponent.androidXArchRoomVersion}"
                const val runtime =
                    "androidx.room:room-runtime:${AndroidXVersions.ArchComponent.androidXArchRoomVersion}"
                const val rxjava2 =
                    "androidx.room:room-rxjava2:${AndroidXVersions.ArchComponent.androidXArchRoomVersion}"
            }

            object Paging {
                const val common =
                    "androidx.paging:paging-common:${AndroidXVersions.ArchComponent.androidXArchPagingVersion}"
                const val runtime =
                    "androidx.paging:paging-runtime:${AndroidXVersions.ArchComponent.androidXArchPagingVersion}"
            }
        }

        const val core = "androidx.core:core:${AndroidXVersions.androidXCoreVersion}"
        const val coreKtx = "androidx.core:core-ktx:${AndroidXVersions.androidXCoreKtxVersion}"
        const val fragmentKtx =
            "androidx.fragment:fragment-ktx:${AndroidXVersions.androidXFragmentKtxVersion}"
        const val material =
            "com.google.android.material:material:${AndroidXVersions.androidXMaterialVersion}"
        const val fragment =
            "androidx.fragment:fragment:${AndroidXVersions.androidXFragmentVersion}"
        const val appcompat =
            "androidx.appcompat:appcompat:${AndroidXVersions.androidXAppCompatVersion}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${AndroidXVersions.androidXRecyclerViewVersion}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:${AndroidXVersions.androidXConstraintLayoutVersion}"
        const val preference =
            "androidx.preference:preference:${AndroidXVersions.androidXPreferenceVersion}"
        const val gridlayout =
            "androidx.gridlayout:gridlayout:${AndroidXVersions.androidXGridLayoutVersion}"
        const val cardview =
            "androidx.cardview:cardview:${AndroidXVersions.androidXCardViewVersion}"
        const val browser = "androidx.browser:browser:${AndroidXVersions.androidXBrowserVersion}"
        const val drawerlayout =
            "androidx.drawerlayout:drawerlayout:${AndroidXVersions.androidXDrawerLayoutVersion}"
        const val media = "androidx.media:media:${AndroidXVersions.androidXMediaVersion}"
        const val annotation =
            "androidx.annotation:annotation:${AndroidXVersions.androidXAnnotationVersion}"
        const val multidex =
            "androidx.multidex:multidex:${AndroidXVersions.androidXMultidexVersion}"
    }

    const val kotlin =
        "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${BuildGradlePluginsVersions.kotlinVersion}"
    const val threetenabp =
        "com.jakewharton.threetenabp:threetenabp:${LibVersions.threetenAbpVersion}"
}

object TestingLibs {
    object AndroidX {
        const val core = "androidx.test:core:1.1.0"
        const val runner = "androidx.test:runner:1.1.1"
        const val rules = "androidx.test:rules:1.1.1"

        // Assertions
        const val extJUnit = "androidx.test.ext:junit:1.1.0"
        const val extTruth = "androidx.test.ext:truth:1.1.0"

        const val uiAutomator =
            "androidx.test.uiautomator:uiautomator:${TestingVersions.androidXTestUiAutomatorVersion}"

        const val orchestrator =
            "androidx.test:orchestrator:${TestingVersions.androidXTestOrchestratorVersion}"

        object Espresso {
            const val core =
                "androidx.test.espresso:espresso-core:${TestingVersions.androidXTestEspressoVersion}"
            const val contrib =
                "androidx.test.espresso:espresso-contrib:${TestingVersions.androidXTestEspressoVersion}"
            const val intents =
                "androidx.test.espresso:espresso-intents:${TestingVersions.androidXTestEspressoVersion}"
            const val web =
                "androidx.test.espresso:espresso-web:${TestingVersions.androidXTestEspressoVersion}"
            const val idlingResource =
                "androidx.test.espresso:espresso-idling-resource:${TestingVersions.androidXTestEspressoVersion}"
            const val concurrent =
                "androidx.test.espresso.idling:idling-concurrent:${TestingVersions.androidXTestEspressoVersion}"
        }
    }

    const val junit = "junit:junit:${TestingVersions.testJUnitVersion}"
    const val truth = "com.google.truth:truth:${TestingVersions.testGoogleTruthVersion}"
    const val robolectric = "org.robolectric:robolectric:${TestingVersions.testRobolectricVersion}"
}

