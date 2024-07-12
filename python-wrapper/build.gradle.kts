plugins {
	kotlinMultiplatform()
	kotlinSerialization()
}

val version: String? by project
project.version = version ?: "0.0.0-snapshot"

val moduleName = "icure-sdk-ts"

kotlin {
	val sharedLibBaseName = "icure-sdk-native-pylib"
	configureKotlinLinux(this).forEach {
		it.binaries {
			sharedLib {
				baseName = sharedLibBaseName
			}
		}
	}
	macosArm64 {
		binaries {
			sharedLib {
				baseName = sharedLibBaseName
			}
		}
	}
	macosX64 {
		binaries {
			sharedLib {
				baseName = sharedLibBaseName
			}
		}
	}
	mingwX64 {
		binaries {
			sharedLib {
				baseName = sharedLibBaseName
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
