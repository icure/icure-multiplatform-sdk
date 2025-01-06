import java.util.Properties

rootProject.name = "cardinal-multiplatform-sdk"

include("cardinal-sdk")
include("ts-wrapper")
include("python-wrapper")
include("ktor-curl")
include("dart-wrapper:lib")
include("dart-wrapper:cardinal_sdk")
include("dart-wrapper")

includeBuild("ksp-json-processor") {
	dependencySubstitution {
		substitute(module("com.icure:ksp-json-processor"))
			.using(project(":library"))
	}
}

val localPropertiesFile = file("local.properties")
val properties = Properties()

if (localPropertiesFile.exists()) {
	localPropertiesFile.inputStream().use { properties.load(it) }
}

// Now you can read the properties
val githubUsername = properties.getProperty("githubUsername")
val githubPassword = properties.getProperty("githubPassword")

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
		maven {
			url = uri("https://maven.pkg.github.com/icure/charix")
			credentials {
				username = githubUsername
				password = githubPassword
			}
		}
		mavenLocal()
	}
}
