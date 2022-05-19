plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "co.ravn.ravn_navigation"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf(
            "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi",
            "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi",
            "-Xopt-in=androidx.compose.material.ExperimentalMaterialApi",
            "-Xopt-in=androidx.compose.ui.ExperimentalComposeUiApi",
            "-Xopt-in=androidx.paging.ExperimentalPagingApi",
            "-Xopt-in=kotlin.contracts.ExperimentalContracts",
            "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-Xopt-in=kotlinx.coroutines.InternalCoroutinesApi", // todo remove when break from 1.6.0-RC2 is resolved (https://github.com/Kotlin/kotlinx.coroutines/issues/3078)
            "-Xopt-in=kotlinx.coroutines.FlowPreview",
            "-Xopt-in=kotlin.RequiresOptIn",
        )
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }

    packagingOptions {
        exclude("META-INF/DEPENDENCIES")
    }
}

dependencies {

    // Kotlin
    implementation(libs.kotlin.coroutines.android)
    implementation(kotlin("reflect"))

    // Android
    coreLibraryDesugaring(libs.android.desugar)
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout.constraintlayout)
    implementation(libs.androidx.core)
    implementation(libs.androidx.cardview)
    implementation(libs.androidx.datastorePrefs)
    implementation(libs.androidx.dynamicAnimation)
    implementation(libs.androidx.exifInterface)
    implementation(libs.androidx.fragment)
    implementation(libs.androidx.preference)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.startup)
    implementation(libs.google.flexBox)
    implementation(libs.google.material)

    // Android Architecture Components
    implementation(libs.androidx.lifecycle.common.java8)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    implementation(libs.androidx.lifecycle.livedata)
    implementation(libs.androidx.paging.common)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.work.runtime)
    implementation(libs.workmanagerTools)

    // Compose
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.paging.compose) {
        exclude(group = "androidx.paging", module = "paging-common")
    }
    implementation(libs.compose.material.material)
    implementation(libs.compose.material.iconsExt)
//    debugImplementation(libs.compose.ui.tooling)
//    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.ui.tooling)
    implementation(libs.compose.ui.ui)

    // Database
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.paging)
    kapt(libs.androidx.room.compiler)
    implementation(libs.dbtools.room)
    implementation(libs.dbtools.roomSqlite)

    // Navigation
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    // Store
    implementation(libs.nytimes.cache3) // needed for store
    implementation(libs.store.store4)
    implementation(libs.store.multicast)

    // Injection
    implementation(libs.dagger.hilt.android)
    kapt(libs.dagger.hilt.compiler)
    implementation(libs.androidx.hilt.compose)
    implementation(libs.androidx.hilt.work)
    kapt(libs.androidx.hilt.compiler)

    // Google Services
    implementation(libs.google.places)
    implementation(libs.google.play.castFramework)
    testImplementation(libs.google.play.gcm)
    testImplementation(libs.google.play.location)

    // Google Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.config)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.messaging)
    implementation(libs.firebase.storage)

    // Analytics
    implementation(libs.adobe.analytics)
    implementation(libs.adobe.sdkCore)
    implementation(libs.adobe.userProfile)

    // UI
    implementation(libs.accompanist.flowlayout)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.swiperefresh)
    implementation(libs.coil)
    implementation(libs.coil.compose)
    implementation(libs.compose.reorderable)
    implementation(libs.html.text)
    implementation(libs.lottie)
    implementation(libs.lottie.compose)
    implementation(libs.photoView)
    implementation(libs.viewPagerDotsIndicator)

    // Network
    implementation(platform(libs.okhttp.bom))
    implementation(libs.grpc.okhttp) // prevent crash on Android 11 https://stackoverflow.com/a/68231205
    implementation(libs.okhttp)
    implementation(libs.okhttp.loggingInterceptor)
    implementation(libs.kotlin.serialization.json)
    implementation(libs.retrofit)
    implementation(libs.jsoup)

    // Debugging
    implementation(libs.timber)
    implementation(libs.okhttp.loggingInterceptor)

    // Test (Unit)
    testImplementation(libs.dbtools.roomJdbcTest)
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.dataProvider)
    testImplementation(libs.kotlin.coroutines.test)
    testImplementation(libs.mockito.core)
    testImplementation(libs.mockito.kotlin)
    testImplementation(libs.xerial.sqlite)

    // Test (Android X)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.test.runner)
    testImplementation(libs.androidx.test.rules)
    testImplementation(libs.androidx.test.junit)
    testImplementation(libs.androidx.test.coreTesting)
//    kaptTest(libs.dagger.compiler)
}

