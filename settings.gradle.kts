rootProject.name = "icure-multiplatform-sdk"

include("cardinal-sdk")
include("ts-wrapper")
include("python-wrapper")
include("sdk-codegen")
include("ktor-curl")

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
		mavenLocal()
	}
}
include("sdk-codegen:ksp-json-processor")
include("sdk-codegen:sdk-codegen")
include("sdk-codegen:python-poet")

findProject(":sdk-codegen:ksp-json-processor")?.name = "ksp-json-processor"
findProject(":sdk-codegen:sdk-codegen")?.name = "sdk-codegen"
