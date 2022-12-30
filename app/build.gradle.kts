plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-android")
    id("kotlin-kapt")
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
            buildConfigField("String", "BASE_URL", "\"https://api.rawg.io/api/\"")
            buildConfigField ("String", "API_KEY", "\"a6698efdae6d40f0bbca1b728b1873a9\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    // Core
    api(Libraries.androidxCoreKtx)
    api(Libraries.androidxAppcompat)
    api(Libraries.googleAndroidMaterial)
    api(Libraries.androidxConstraintLayout)
    api(Libraries.swipeRefreshLayout)
    api(Libraries.activityX)

    // Unit test
    testImplementation(Libraries.junit)
    testImplementation(Libraries.mockito)
    testImplementation(Libraries.mockitoKotlin)
    androidTestImplementation(Libraries.androidJunit)
    androidTestImplementation(Libraries.espressoCore)
    androidTestImplementation(Libraries.mockWebServer)
    androidTestImplementation(Libraries.mockitoInline)
    testImplementation(Libraries.coroutineTest)
    testImplementation(Libraries.coreTesting)

    // Image process
    api(Libraries.coil)

    // Coroutine
    api(Libraries.coroutineCore)
    api(Libraries.coroutineAndroid)

    // View model and lifecycle stuffs
    api(Libraries.lifecycleViewModelKtx)
    api(Libraries.lifecycleLiveDataKtx)
    api(Libraries.lifecycleRuntimeKtx)

    // Hilt
    api(Libraries.hiltAndroid)
    kapt(Libraries.hiltCompiler)

    // Storage
    api(Libraries.roomKtx)
    kapt(Libraries.roomCompiler)
    api(Libraries.roomRuntime)
    api(Libraries.dataStore)

    // Network
    api(Libraries.retrofit2)
    api(Libraries.retrofitConverterGson)
    api(Libraries.gson)

    // Log
    api(Libraries.timber)

    // Chucker
    debugImplementation(Libraries.chucker)
    releaseImplementation(Libraries.chuckerNoOp)
}
