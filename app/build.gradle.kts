plugins {
    // application
    id("com.android.application")
    // kotlin-android
    id("kotlin-android")
    // sage args
//    id("androidx.navigation.safeargs.kotlin")
//     hilt android
    id("dagger.hilt.android.plugin")
    //kapt
    id("kotlin-kapt")
}

android {
    namespace = "com.example.kitsuapi"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.kitsuapi"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    // View Binding
    buildFeatures.viewBinding = true
}

dependencies {


    implementation(project(":domain"))
    implementation(project(":data"))

    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // glide
    implementation("com.github.bumptech.glide:glide:4.15.0")
    // Hilt
    implementation("com.google.dagger:hilt-android:2.46.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    kapt("com.google.dagger:hilt-android-compiler:2.46.1")

    // hilt navigation
    implementation("androidx.hilt:hilt-navigation-fragment:1.0.0")
    // Kotlin
    implementation("androidx.activity:activity-ktx:1.7.2")

    val fragmentVersion = "1.3.6"
    implementation("androidx.fragment:fragment-ktx:1.6.1")

    // Navigation
    val navVersion = "2.6.0"
    //   implementation
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navVersion")

    //Room
    val roomVersion = "2.5.2"
    implementation("androidx.room:room-ktx:$roomVersion")
    // To use Kotlin annotation processing tool (kapt)
    kapt("androidx.room:room-compiler:$roomVersion")

    // Paging 3
    val pagingVersion = "3.0.1"
    //noinspection GradleDependency
    implementation("androidx.paging:paging-runtime-ktx:$pagingVersion")

    // ViewBinding Property Delegate
    val viewBindingPropertyDelegate = "1.5.8"
    // To use only without reflection variants of viewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:$viewBindingPropertyDelegate")

    val version = "2.6.1"
    // | for Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$version")

    // coordinatorLayout
    implementation("androidx.coordinatorlayout:coordinatorlayout:1.2.0")

    // Material Design Components
    implementation("com.google.android.material:material:1.9.0")

    // lifecycle runtime
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // CircleImageView
    implementation("de.hdodenhof:circleimageview:3.1.0")

}