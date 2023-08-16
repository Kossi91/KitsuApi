plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    // Javax Inject
    api("javax.inject:javax.inject:1")
    // Kotlin
    // Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")

    api("androidx.paging:paging-common-ktx:3.2.0")

    api ("io.insert-koin:koin-core:3.4.0")

    //Retrofit 2
    api("com.squareup.retrofit2:retrofit:2.9.0")
    //Gson
    api("com.squareup.retrofit2:converter-gson:2.9.0")
}