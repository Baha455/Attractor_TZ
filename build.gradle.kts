

buildscript {
    repositories {
        google()
        maven ( url= "https://jitpack.io" )
        mavenCentral()

    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
    }
}

allprojects {
    repositories {
        google()
        maven ( url= "https://jitpack.io" )
        mavenCentral()
    }
}


