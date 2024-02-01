import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

plugins {
	kotlinMultiplatform()
	kotestMultiplatform()
	androidLibrary()
}

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
