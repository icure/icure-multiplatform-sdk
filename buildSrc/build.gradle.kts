import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
	`kotlin-dsl`
}

repositories {
	mavenCentral()
	gradlePluginPortal()
	google()
}

dependencies {
	implementation(libs.kotlinMultiplatformPlugin)
	implementation(libs.kotlinSerializationPlugin)
	implementation(libs.kotestMultiplatformPlugin)
	implementation(libs.androidLibraryPlugin)
}