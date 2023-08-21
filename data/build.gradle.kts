
plugins {
    id(libs.plugins.agp.library.get().pluginId)
    id(libs.plugins.kotlin.kotlin.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
}

android {
    namespace = "com.example.data"
    compileSdk = config.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.targetSdk.get().toInt()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    // Impl project
    implementation(project(":domain"))
    // UI
    implementation(libs.uiComponents.androidCore)
    testImplementation(libs.uiComponents.junit)
    androidTestImplementation(libs.uiComponents.androidTestJunit)
    // koin
    implementation(libs.bundles.koin)
    // Paging
    implementation(libs.paging.pagingRuntime)
    // Retrofit
    implementation(libs.bundles.retrofit)
    // okHttp
    implementation(libs.bundles.okHttp)
    // Room
    implementation(libs.bundles.room)
    kapt(libs.room.roomCompiler)
    // Coroutines
    implementation(libs.bundles.coroutines)
}