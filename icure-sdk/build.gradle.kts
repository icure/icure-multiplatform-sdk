plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
	id("com.google.devtools.ksp") version "1.9.24-1.0.20"
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

val version: String? by project
project.version = version ?: "0.0.0-snapshot"

kotlin {
	configureMultiplatform(this)

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(libs.ktorClientCore)
				implementation(libs.ktorContentNegotiation)
				implementation(libs.ktorSerializationJson)
				implementation(libs.ktorClientWebsocket)
				api(libs.kotlinSerialization)
				api(libs.kotlinDateTime)
				implementation(libs.kermit)
				api(libs.kryptom)
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
				implementation(libs.mockk)
				implementation(libs.bundles.ktorServer)
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
		appleMain {
			dependencies {
				implementation(libs.ktorClientEngineDarwin)
			}
		}
		linuxMain {
			dependencies {
				implementation(libs.ktorClientEngineCurl)
				implementation(libs.ktorClientEngineCio)
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

tasks.named("jsNodeDevelopmentRun") { dependsOn("jsProductionExecutableCompileSync") }
tasks.named("jsNodeProductionRun") { dependsOn("jsProductionExecutableCompileSync") }