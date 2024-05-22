rootProject.name = "icure-multiplatform-sdk"

include("icure-sdk")
include("sdk-codegen")

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
include("sdk-codegen:ksp-json-processor")
include("sdk-codegen:sdk-codegen")

findProject(":sdk-codegen:ksp-json-processor")?.name = "ksp-json-processor"
findProject(":sdk-codegen:sdk-codegen")?.name = "sdk-codegen"
