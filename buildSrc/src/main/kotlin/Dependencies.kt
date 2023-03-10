/**
 * Written with joy and smile by Ruang Aldo on 29/12/22.
 * Github: https://github.com/reinaldoriant
 */

object AndroidProjectConfig {
    const val minSdk = 21
    const val compileSdk = 33
    const val targetSdk = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val applicationId = "com.ruangaldo.ruanggame"
}

object Libraries {

    object Versions {
        const val coreKtx = "1.9.0"
        const val appcompat = "1.5.1"
        const val constraintLayout = "2.1.4"
        const val lifecycle = "2.5.0"
        const val googleMaterial = "1.7.0"
        const val gson = "2.9.0"
        const val coroutine = "1.6.1"
        const val retrofit = "2.9.0"
        const val chucker = "3.5.2"
        const val room = "2.4.3"
        const val junit = "4.13.2"
        const val mockito = "4.8.1"
        const val mockitoKotlin = "2.2.0"
        const val mockitoInline = "2.13.0"
        const val mockWebServer = "4.10.0"
        const val androidTestJunit = "1.1.3"
        const val coreTesting = "2.1.0"
        const val coroutineTest = "1.3.8"
        const val espresso = "3.4.0"
        const val jetpackDatastore = "1.0.0"
        const val coil = "2.1.0"
        const val swipeRefreshLayout = "1.1.0"
        const val hilt = "2.44.2"
        const val activityX = "1.6.1"
        const val timber = "5.0.1"
    }

    const val androidxCoreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val androidxAppcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val androidxConstraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModelKtx =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLiveDataKtx =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val googleAndroidMaterial =
        "com.google.android.material:material:${Versions.googleMaterial}"
    const val activityX =
        "androidx.activity:activity-ktx:${Versions.activityX}"

    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"

    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.gson}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
    const val chuckerNoOp = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    const val junit = "junit:junit:${Versions.junit}"
    const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Versions.mockitoKotlin}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    const val androidJunit = "androidx.test.ext:junit:${Versions.androidTestJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val coreTesting = "androidx.arch.core:core-testing:${Versions.coreTesting}"
    const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutineTest}"

    const val coil = "io.coil-kt:coil:${Versions.coil}"
    const val swipeRefreshLayout =
        "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.swipeRefreshLayout}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val dataStore =
        "androidx.datastore:datastore-preferences:${Versions.jetpackDatastore}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
}
