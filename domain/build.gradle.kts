plugins {
    id(libs.plugins.javaLibrary.get().pluginId)
    id(libs.plugins.kotlin.jvm.get().pluginId)
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(libs.coroutines.core)
    implementation(libs.paging.pagingCommon)
    implementation(libs.retrofit.retrofit)
    implementation(libs.koin.koinCore)
}