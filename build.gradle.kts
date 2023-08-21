import org.gradle.accessors.dm.LibrariesForConfig
import org.jetbrains.dokka.DokkaConfiguration.Visibility
import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import java.time.Year

val config = the<LibrariesForConfig>()
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

allprojects {
    apply(plugin = rootProject.project.libs.plugins.jetBrains.dokka.get().pluginId)

    tasks.withType<DokkaTaskPartial>().configureEach {
        suppressInheritedMembers.set(true)
        dokkaSourceSets.configureEach {
            documentedVisibilities.set(
                Visibility.values().toSet()
            )
        }

        pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
            footerMessage =
                config.versions.documentationCommonFooterMessage.get() + "© ${Year.now().value} Copyright."
        }
    }

}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.dokkaHtmlMultiModule {
    moduleName.set("")
    moduleVersion.set(config.versions.versionName.get())

    pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
        customAssets = listOf(file("$projectDir/geek-studio.svg"))
        footerMessage =
            config.versions.documentationCommonFooterMessage.get() + "© ${Year.now().value} Copyright."
        customStyleSheets =
            listOf(file("$projectDir/logo-style.css"), file("$projectDir/logo-styles.css"))
    }
}
