plugins {
    id(Dependency.Application.library)
    id(Dependency.Kotlin.kotlinAndroidJetBrains)
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
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
        jvmTarget = "1.8"
    }
    viewBinding {
        isEnabled = true
    }
}

dependencies {

    implementation(Dependency.androidx.coreKtx)
    implementation(Dependency.androidx.appCompat)
    implementation(Dependency.androidx.material)

    implementation(Dependency.lifeCycle.commonJava8)
    implementation(Dependency.lifeCycle.runtimeKtx)

    //Navigation
    implementation(Dependency.Navigation.navigationUiKtx)
    implementation(Dependency.Navigation.navigationFragmentKtx)
}