
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
	kotlinMultiplatform()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
//	id("com.taktik.gradle.git-version") version "2.0.8-gb47b2d0e35"
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

//val gitVersion: String? by project

project.version = "0.2.0"

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
	configureMultiplatform(this)

	compilerOptions {
		freeCompilerArgs.add("-Xexpect-actual-classes")
	}

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(libs.ktorUtils)
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(libs.kotestAssertions)
				implementation(libs.kotestEngine)
				implementation(libs.kotestDatatest)
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
		val jvmMain by getting {
			dependencies {
				implementation(libs.bouncyCastle)
			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
			}
		}
		val jsMain by getting {
			languageSettings {
				optIn("kotlin.js.ExperimentalJsExport")
			}
			dependencies {
			}
		}
		val androidMain by getting {
			dependencies {
				implementation(libs.bouncyCastle)
			}
		}
		val androidUnitTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
			}
		}
		optInIos("kotlinx.cinterop.ExperimentalForeignApi", "kotlinx.cinterop.BetaInteropApi")
	}
}

android {
	namespace = "com.icure.kryptom"
	configureAndroidLibrary()
}

configureJvmTest()

publishing {
	repositories {
		mavenLocal()
		maven {
			name = "Taktik"
			url = uri(mavenReleasesRepository)
			credentials {
				username = repoUsername
				password = repoPassword
			}
		}

		mavenCentral {
			name = "MavenCentral"
			credentials {
				username = properties["mavenCentralUsername"]?.let { it as String } ?: ""
				password = properties["mavenCentralPassword"]?.let { it as String } ?: ""
			}
		}
	}
}
