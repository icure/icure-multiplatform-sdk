plugins {
	kotlinMultiplatform()
	kotlinSerialization()
}

val version: String? by project
project.version = version ?: "0.0.0-snapshot"

val moduleName = "icure-ktor-curl"

kotlin {
	configureKotlinLinux(this).forEach { target ->
		target.compilations.getByName("main") {
			cinterops {
				val libcrypto by creating {
					defFile = project.file("interop/libcurl.def")
//					localProperties["cinteropsIncludeDir"]?.also {+
//						compilerOpts += "-I$it"
//					}
				}
			}
		}
	}

	sourceSets {
		commonMain {
			dependencies {
				api(libs.ktorHttpCio)
				api(libs.ktorClientCore)
				implementation(libs.kotlinIo)
			}
		}
	}
}
