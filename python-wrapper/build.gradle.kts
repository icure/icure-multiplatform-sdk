plugins {
	kotlinMultiplatform()
	kotlinSerialization()
}

val version: String? by project
project.version = version ?: "0.0.0-snapshot"

val moduleName = "icure-sdk-ts"

kotlin {
	configureKotlinLinux(this).forEach {
		it.binaries {
			sharedLib {
				baseName = "icure-sdk-native-pylib"
			}
		}
	}
	macosArm64 {
		binaries {
			sharedLib {
				baseName = "icure-sdk-native-pylib"
			}
		}
	}
	macosX64 {
		binaries {
			sharedLib {
				baseName = "icure-sdk-native-pylib"
			}
		}
	}

	sourceSets {
		commonMain {
			dependencies {
				implementation(project(":icure-sdk"))
				implementation(libs.coroutinesCore)
			}
		}
	}
}
