pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    versionCatalogs {
        create("config") {
            from(files("gradle/config.versions.toml"))
        }
    }
}

rootProject.name = "KitsuApi"
include(":app")
include(":data")
include(":domain")
