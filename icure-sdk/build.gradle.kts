import com.icure.task.CompileTypescriptTask

plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
	id("com.taktik.gradle.git-version") version "2.0.8-gb47b2d0e35"
	id("com.google.devtools.ksp") version "1.9.24-1.0.20"
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

val gitVersion: String? by project
project.version = gitVersion ?: "0.0.1"

kotlin {
	configureMultiplatform(this)

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(libs.ktorClientCore)
				implementation(libs.ktorContentNegotiation)
				implementation(libs.ktorSerializationJson)
				implementation(libs.kotlinSerialization)
				implementation(libs.kotlinDateTime)
				implementation(libs.kermit)
				implementation(libs.kryptom)
				implementation(libs.coroutinesCore)
				implementation(kotlin("reflect"))
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
				implementation(libs.ktorClientEngineOkhttp)
			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
				implementation("io.icure:icure-e2e-test-setup:0.0.24-gc854bb2431")
				implementation(libs.ktorClientEngineCio) // Currently needed by test setup, remove later
			}
		}
		val jsMain by getting {
			dependencies {
				implementation(libs.ktorClientEngineJs)
			}
		}
		val androidMain by getting {
			dependencies {
				implementation(libs.ktorClientEngineOkhttp)
			}
		}
		val androidUnitTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
			}
		}
		iosMain {
			dependencies {
				implementation(libs.ktorClientEngineDarwin)
			}
		}
	}
}

android {
	namespace = "com.icure.sdk"
	configureAndroidLibrary()
}

configureJvmTest()

dependencies {
	add("kspJvm", project(":sdk-codegen:ksp-json-processor"))
}

val compileTypeScript = tasks.register<CompileTypescriptTask>("compileTypeScript")

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
	}
}
