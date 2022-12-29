plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("com.google.dagger.hilt.android") version "2.44" apply false
}

android {
    namespace = AndroidProjectConfig.applicationId
    compileSdk = AndroidProjectConfig.compileSdk

    defaultConfig {
        minSdk = AndroidProjectConfig.minSdk
        targetSdk = AndroidProjectConfig.targetSdk
        versionCode = AndroidProjectConfig.versionCode
        versionName = AndroidProjectConfig.versionName

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
    flavorDimensions += listOf("default")
    productFlavors {
        create("production") {
            dimension = "default"
            buildConfigField("String", "BASE_URL", "\"http://75.101.213.57/\"")
            buildConfigField("String", "APPLICATION_ID", "\"$AndroidProjectConfig.applicationId\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // Core
    api(Libraries.androidxCoreKtx)
    api(Libraries.androidxAppcompat)
    api(Libraries.googleAndroidMaterial)
    api(Libraries.androidxConstraintLayout)
    api(Libraries.swipeRefreshLayout)

    // Unit test
    testApi(Libraries.junit)
    androidTestApi(Libraries.androidJunit)
    androidTestApi(Libraries.espressoCore)

    // Image process
    api(Libraries.coil)

    // Coroutine
    api(Libraries.coroutineCore)
    api(Libraries.coroutineAndroid)

    // View model and lifecycle stuffs
    api(Libraries.lifecycleViewModelKtx)
    api(Libraries.lifecycleLiveDataKtx)
    api(Libraries.lifecycleRuntimeKtx)

    // Network
    api(Libraries.retrofit2)
    api(Libraries.retrofitConverterGson)
    api(Libraries.gson)

    // Storage
    api(Libraries.jetpackDatastore)
    api(Libraries.roomCompiler)
    api(Libraries.roomKtx)
    api(Libraries.roomRuntime)

    // Hilt
    api(Libraries.hiltAndroid)
    api(Libraries.hiltCompiler)

}
