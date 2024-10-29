plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
	signing
	id("com.vanniktech.maven.publish") version "0.28.0"
	id("com.google.devtools.ksp") version "2.0.21-RC-1.0.25"
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

group = "com.icure"

val version = "1.0.0-RC.1"
project.version = version

kotlin {
	configureMultiplatform(
		this,
		jvm = false,
		android = true,
		ios = true,
		macos = false,
		mingw = false,
		linux = false,
		js = false,
		xcFrameworkName = "CardinalDartSdkSupportLib"
	)

	sourceSets {
		val commonMain by getting {
			dependencies {
				api("com.icure:cardinal-sdk:1.0.0-RC.3")
				implementation(libs.coroutinesCore)
				implementation(libs.kotlinSerialization)
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(libs.kotestAssertions)
				implementation(libs.kotestEngine)
			}
		}
		val androidMain by getting {
			dependencies {
			}
		}
		val androidUnitTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
			}
		}
		iosMain {
			dependencies {
			}
		}
	}
}

android {
	namespace = "com.icure.cardinal.sdk.dart"
	configureAndroidLibrary()
}

mavenPublishing {
	coordinates("com.icure", "cardinal-dart-sdk-support-lib", project.version as String)

	pom {
		name = "CardinalDartSdkSupportLib"
		description = "Internal use library for the dart sdk on android"
	}
}
