import Dependency.core
import Dependency.SecondScreen

plugins {
    id(Dependency.Application.library)
    id(Dependency.Kotlin.kotlinAndroid)
    id(Dependency.Kotlin.kotlinKapt)
    id(Dependency.Kotlin.kotlinAndroidJetBrains)
    id(Dependency.HiltPlugin.hiltPlugin)
}

android {
    compileSdk = AndroidConfig.compileSdk


    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    viewBinding {
        isEnabled = true
    }
}

dependencies {

    //Module
    implementation(core)
    implementation(SecondScreen)

    implementation(Dependency.androidx.coreKtx)
    implementation(Dependency.androidx.appCompat)
    implementation(Dependency.androidx.constraintLayout)
    implementation(Dependency.androidx.material)

    //retrofit
    implementation(Dependency.Retrofit.retrofit2)
    implementation(Dependency.Retrofit.converter)

    //Coroutine
    implementation(Dependency.Coroutine.coroutine)

    //Delegates viewModel
    implementation(Dependency.ViewModelDelegate.viewModel)

    //lifeCycle
    implementation(Dependency.lifeCycle.commonJava8)
    implementation(Dependency.lifeCycle.runtimeKtx)
    implementation(Dependency.lifeCycle.viewModelKtx)

    //hilt
    implementation(Dependency.Hilt.hilt)
    kapt(Dependency.Hilt.kaptHilt)


    //Coil
    implementation(Dependency.Coil.coil)

    //viewBinding delegate
    implementation(Dependency.ViewBindingDelegate.binding)

    //Navigation
    implementation(Dependency.Navigation.navigationFragmentKtx)
    implementation(Dependency.Navigation.navigationUiKtx)
}