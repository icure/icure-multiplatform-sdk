import tasks.InitializeTestEnvironment

plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
	id("com.google.devtools.ksp") version "2.0.20-Beta1-1.0.22"
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

val version = "2.0.50.alpha1"
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
				implementation(libs.okio)
				implementation(kotlin("reflect"))
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(libs.kotestAssertions)
				implementation(libs.kotestEngine)
				implementation(libs.kotestDatatest)
				implementation(libs.kotp)
				implementation(kotlin("test-common"))
				implementation(kotlin("test-annotations-common"))
			}
		}
		val jvmMain by getting {
			dependencies {
				implementation(libs.ktorClientEngineOkhttp)
				implementation(libs.bouncyCastle)
			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
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
				implementation(project(":ktor-curl"))
			}
		}
		mingwMain {
			dependencies {
				implementation(libs.ktorClientEngineWinhttp)
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

tasks.register<InitializeTestEnvironment>("initializeTestEnvironment")

tasks.named("allTests") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("iosSimulatorArm64Test") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("iosX64Test") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("jsBrowserTest") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("jsNodeTest") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("jsTest") {
	dependsOn("initializeTestEnvironment")
}
tasks.named("jvmTest") {
	dependsOn("initializeTestEnvironment")
}


tasks.named("jsNodeDevelopmentRun") { dependsOn("jsProductionExecutableCompileSync") }
tasks.named("jsNodeProductionRun") { dependsOn("jsProductionExecutableCompileSync") }