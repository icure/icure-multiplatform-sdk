rootProject.name = "icure-multiplatform-sdk"

include("kryptom")
include("icure-sdk")

pluginManagement {
	repositories {
		google()
		gradlePluginPortal()
		mavenCentral()
	}
}

dependencyResolutionManagement {
	repositories {
		google()
		mavenCentral()
	}
}
