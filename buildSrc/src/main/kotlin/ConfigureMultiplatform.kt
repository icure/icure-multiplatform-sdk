import org.gradle.api.Project
import org.gradle.kotlin.dsl.all
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.jvm
import org.gradle.kotlin.dsl.kotlin
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.util.Properties

/**
 * Configures targets and source sets for multiplatform modules.
 */
fun Project.configureMultiplatform(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension
) = with (kotlinMultiplatformExtension) {
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
    androidTarget {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }
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
    val localProperties = Properties().apply {
        load(rootProject.file("local.properties").reader())
    }
    iosSimulators.forEach { target ->
        target.testRuns.forEach { testRun ->
            (localProperties["ios.simulator"] as? String)?.let { testRun.deviceId = it }
        }
    }

    applyDefaultHierarchyTemplate()

    with(sourceSets) {
        all {
            languageSettings.apply {
                optIn("kotlin.js.ExperimentalJsExport")
                optIn("kotlinx.cinterop.ExperimentalForeignApi")
            }
        }
        val commonMain = get("commonMain")
        val jvmAndAndroidMain = create("jvmAndAndroidMain").apply {
            dependsOn(commonMain)
        }
        get("jvmMain").dependsOn(jvmAndAndroidMain)
        get("androidMain").dependsOn(jvmAndAndroidMain)
    }
}