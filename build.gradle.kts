
val config = the<org.gradle.accessors.dm.LibrariesForConfig>()
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.agp.application) apply false
    alias(libs.plugins.agp.library) apply false
    alias(libs.plugins.jetBrains.kotlin.gradle) apply false
    alias(libs.plugins.jetBrains.kotlin.jvm) apply false
    alias(libs.plugins.jetBrains.dokka)
}
buildscript {
    dependencies {
        classpath(libs.jetBrains.dokka.gradle)
        classpath(libs.jetBrains.dokka.android.documentation)
        classpath(libs.jetBrains.dokka.android.gradle)
    }
}