import Dependency.core
import Dependency.FirstScreen

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


    implementation(Dependency.androidx.coreKtx)
    implementation(Dependency.androidx.appCompat)
    implementation(Dependency.androidx.constraintLayout)
    implementation(Dependency.androidx.material)

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