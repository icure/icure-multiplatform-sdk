rootProject.name = "icure-multiplatform-sdk"

include("icure-sdk")

pluginManagement {
	repositories {
		google()
		gradlePluginPortal()
		mavenCentral()
		maven { url = uri("https://maven.taktik.be/content/groups/public") }
	}
}

dependencyResolutionManagement {
	repositories {
		google()
		mavenCentral()
		maven { url = uri("https://maven.taktik.be/content/groups/public") }
	}
}
