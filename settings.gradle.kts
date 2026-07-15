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

rootProject.name = "FashionAI"
include(":app")
include(":core:camera")
include(":core:ai")
include(":core:database")
include(":core:utils")
include(":data:repository")
include(":domain:model")
include(":domain:usecase")
include(":feature:home")
include(":feature:scanner")
include(":feature:wardrobe")
include(":feature:settings")
