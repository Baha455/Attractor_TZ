import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

object AndroidConfig {
    const val compileSdk = 32
    const val minSdk = 26
    const val targetSdk = 32
}

object Dependency {

    object Application {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val kotlinAndroidJetBrains = "org.jetbrains.kotlin.android"
        const val kotlinAndroid = "kotlin-android"
        const val kotlinKapt = "kotlin-kapt"
    }

    object HiltPlugin{
        const val hiltPlugin = "com.google.dagger.hilt.android"
    }

    object Coroutine {
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2"
        const val coroutineConvert = "com.squareup.retrofit2:retrofit:2.9.0"
    }

    object lifeCycle {
        private const val version = "2.4.0"

        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val commonJava8 = "androidx.lifecycle:lifecycle-common-java8:$version"
    }

    object androidx {
        const val appCompat = "androidx.appcompat:appcompat:1.3.1"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.1"
        const val material = "com.google.android.material:material:1.3.0"
    }

    object Navigation {
        const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.5.1"
        const val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:2.5.1"
    }

    object ViewModelDelegate{
        const val viewModel = "androidx.fragment:fragment-ktx:1.5.2"
    }


    object Coil {
        const val coil = "io.coil-kt:coil:2.2.0"
    }

    object Retrofit {
        const val retrofit2 = "com.squareup.retrofit2:retrofit:2.9.0"
        const val converter = "com.squareup.retrofit2:converter-gson:2.9.0"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:2.43.2"
        const val kaptHilt = "com.google.dagger:hilt-compiler:2.43.2"
    }

    object ViewBindingDelegate{
        const val binding = "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6"
    }

    inline val DependencyHandler.core get() = project(":core")
    inline val DependencyHandler.FirstScreen get() = project(":FirstScreen")
    inline val DependencyHandler.SecondScreen get() = project(":SecondScreen")


}