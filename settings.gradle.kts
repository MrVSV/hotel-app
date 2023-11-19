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
        mavenCentral()
    }
}

rootProject.name = "HotelTestApp"
include(":app")
include(":feature_hotel")
include(":feature_rooms")
include(":feature_booking")
include(":core")
include(":delegates")
include(":remote_api")
include(":core_ui")
