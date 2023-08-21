plugins {
    id(libs.plugins.agp.application.get().pluginId)
    id(libs.plugins.kotlin.kotlin.get().pluginId)
    id(libs.plugins.kotlin.kapt.get().pluginId)
}


android {
    namespace = "com.example.kitsuapi"
    compileSdk = config.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.example.kitsuapi"
        minSdk = config.versions.minSdk.get().toInt()
        targetSdk = config.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

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
    buildFeatures.viewBinding = true
}

dependencies {
    // Implementation project
    implementation(project(":domain"))
    implementation(project(":data"))
    //UIComponents
    implementation(libs.bundles.uiComponents)
    testImplementation(libs.uiComponents.junit)
    androidTestImplementation(libs.uiComponents.androidTestJunit)
    androidTestImplementation(libs.uiComponents.androidTestEspresso)

    // Navigation component
    implementation(libs.bundles.navigationComponent)
    // Room
    implementation(libs.bundles.room)
    kapt(libs.room.roomCompiler)
    // Lifecycle
    implementation(libs.bundles.lifecycle)
    // Coroutines
    implementation(libs.bundles.coroutines)
    // Koin
    implementation(libs.bundles.koin)
    testImplementation(libs.koin.koinTest)
    // Paging
    implementation(libs.paging.pagingRuntime)
    // Glide
    implementation(libs.glide.glide)
    kapt(libs.glide.glideCompiler)
    // ViewBindingDelegate
    implementation(libs.viewBindingDelegate.viewBinding)
    // Retrofit
    implementation(libs.bundles.retrofit)
    // okHttp
    implementation(libs.bundles.okHttp)
    // Coil
    implementation(libs.coil.coil)
}