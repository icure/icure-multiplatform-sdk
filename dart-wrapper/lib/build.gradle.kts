import com.vanniktech.maven.publish.SonatypeHost

plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
	signing
	id("com.vanniktech.maven.publish") version "0.28.0"
	id("com.google.devtools.ksp") version "2.0.21-1.0.25"
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

group = "com.icure"

val version = "1.0.0-RC.3"
project.version = version

kotlin {
	configureMultiplatform(
		this,
		jvm = false,
		android = true,
		ios = true,
		macos = false,
		mingw = false,
		linux = false,
		js = false,
		xcFrameworkName = "CardinalDartSdkSupportLib"
	)

	sourceSets {
		val commonMain by getting {
			dependencies {
				api("com.icure:cardinal-sdk:1.0.0")
				implementation(libs.coroutinesCore)
				implementation(libs.kotlinSerialization)
			}
		}
		val commonTest by getting {
			dependencies {
				implementation(libs.kotestAssertions)
				implementation(libs.kotestEngine)
			}
		}
		val androidMain by getting {
			dependencies {
				implementation(libs.androidx.datastore)
			}
		}
		val androidUnitTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
			}
		}
		iosMain {
			dependencies {
			}
		}
	}
}

android {
	namespace = "com.icure.cardinal.sdk.dart"
	configureAndroidLibrary()
}

fun projectHasSignatureProperties() =
	project.hasProperty("signing.keyId") && project.hasProperty("signing.secretKeyRingFile") && project.hasProperty("signing.password")

if (projectHasSignatureProperties()) {
	signing {
		useInMemoryPgpKeys(
			file(project.property("signing.secretKeyRingFile") as String).readText(),
			project.property("signing.password") as String
		)
		sign(publishing.publications)
	}
}

mavenPublishing {
	coordinates("com.icure", "cardinal-dart-sdk-support-lib", project.version as String)

	pom {
		name = "CardinalDartSdkSupportLib"
		url.set("https://github.com/icure/icure-multiplatform-sdk")
		description = "Internal use library for the dart sdk on android"

		licenses {
			license {
				name.set("MIT License")
				url.set("https://choosealicense.com/licenses/mit/")
				distribution.set("https://choosealicense.com/licenses/mit/")
			}
		}
		developers {
			developer {
				id.set("icure")
				name.set("iCure")
				url.set("https://github.com/iCure/")
			}
		}
		scm {
			url.set("https://github.com/icure/icure-multiplatform-sdk")
			connection.set("scm:git:git://github.com/icure/icure-multiplatform-sdk.git")
			developerConnection.set("scm:git:ssh://git@github.com:icure/icure-multiplatform-sdk.git")
		}
	}

	publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL, automaticRelease = true)

	if (projectHasSignatureProperties()) {
		signAllPublications()
	}
}

// Configure all publishing tasks
if (!projectHasSignatureProperties()) {
	tasks.withType<PublishToMavenRepository> {
		doFirst {
			throw IllegalStateException("Cannot publish to Maven Central without signing properties")
		}
	}
}
