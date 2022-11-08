import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.util.Properties

val localProperties = Properties().apply {
    load(rootProject.file("local.properties").reader())
}

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotestMultiplatform)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {
    val xcf = XCFramework()
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
    js(IR) {
        browser  {
            testTask {
                useKarma {
                    useChromeHeadless()
                    useFirefoxHeadless()
                }
            }
        }
        nodejs {  }
        binaries.executable()
    }
    android {}
    val iosSimulators = listOf(
        iosX64(),
        iosSimulatorArm64()
    )
    val iosAll = iosSimulators + iosArm64()
    iosAll.forEach { target ->
        target.binaries.framework {
            baseName = "icure-sdk"
            xcf.add(this)
        }
    }
    iosSimulators.forEach { target ->
        target.testRuns.forEach { testRun ->
            (localProperties["ios.simulator"] as? String)?.let { testRun.deviceId = it }
        }
    }

    sourceSets {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(libs.coroutines)
                implementation(libs.ktorClientCore)
                implementation(libs.ktorContentNegotiation)
                implementation(libs.ktorSerializationJson)
                implementation(libs.kotlinSerialization)
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
                implementation(libs.ktorClientEngineJs)
            }
        }
        val jsTest by getting
        val androidMain by getting {
            dependencies {
                implementation(libs.ktorClientEngineAndroid)
                implementation(libs.bouncyCastle)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(libs.kotestRunnerJunit)
            }
        }
        val iosX64Main by getting
        val iosX64Test by getting
        val iosArm64Main by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Main by getting
        val iosSimulatorArm64Test by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(libs.ktorClientEngineIos)
            }
        }
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    testOptions {
        unitTests.all {
            it.useJUnitPlatform()
        }
    }
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

tasks.named<Test>("jvmTest") {
    useJUnitPlatform()
    filter {
        isFailOnNoMatchingTests = false
    }
    testLogging {
        showExceptions = true
        showStandardStreams = true
        events = setOf(
            org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED,
            org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED
        )
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}
