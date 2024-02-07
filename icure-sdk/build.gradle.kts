plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
}

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
					implementation(libs.kermit)
					implementation(project(":kryptom"))
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
					implementation(libs.ktorClientEngineJvm)
				}
			}
			val jvmTest by getting {
				dependencies {
					implementation(libs.kotestRunnerJunit)
				}
			}
			val jsMain by getting {
				dependencies {
					implementation(libs.ktorClientEngineJs)
				}
			}
			val androidMain by getting {
				dependencies {
					implementation(libs.ktorClientEngineAndroid)
				}
			}
			val androidUnitTest by getting {
				dependencies {
					implementation(libs.kotestRunnerJunit)
				}
			}
			iosMain {
				dependencies {
					implementation(libs.ktorClientEngineIos)
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
