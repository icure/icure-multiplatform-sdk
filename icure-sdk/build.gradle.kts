plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
}

project.version = "0.0.2"

kotlin {
	configureMultiplatform(this)

	sourceSets {

		sourceSets {
			val commonMain by getting {
				dependencies {
					implementation(libs.ktorClientCore)
					implementation(libs.ktorContentNegotiation)
					implementation(libs.ktorSerializationJson)
					implementation(libs.kotlinSerialization)
					implementation(libs.kotlinDateTime)
					implementation(libs.kermit)
					implementation(libs.coroutinesCore)
					implementation(project(":kryptom"))
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
					implementation(libs.bouncyCastle) // TODO Why do I need this? in common test it was working perfectly...
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
}

android {
	namespace = "com.icure.sdk"
	configureAndroidLibrary()
}

configureJvmTest()

publishing {
	repositories {
		mavenLocal()
	}
}
