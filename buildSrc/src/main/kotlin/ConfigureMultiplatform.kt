
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.util.Properties

/**
 * Configures targets and source sets for multiplatform modules.
 */
fun Project.configureMultiplatform(
	kotlinMultiplatformExtension: KotlinMultiplatformExtension
) = with(kotlinMultiplatformExtension) {
	val frameworkName = project.name.replaceFirstChar { it.uppercase() }
	val xcf = XCFramework(frameworkName)
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "1.8"
		}
	}
	js(IR) {
		browser {
			testTask {
				useKarma {
					useChromeHeadless()
					useFirefoxHeadless()
				}
			}
		}
		nodejs { }
		binaries.library()
		generateTypeScriptDefinitions()
	}
	androidTarget {
		compilations.all {
			kotlinOptions.jvmTarget = "1.8"
		}
		// Important: otherwise android will use the jvm library and it will not work...
		publishLibraryVariants("release", "debug")
	}
	val iosSimulators = listOf(
		iosX64(),
		iosSimulatorArm64()
	)
	val iosAll = iosSimulators + iosArm64()
	iosAll.forEach { target ->
		target.binaries.framework {
			baseName = frameworkName
			xcf.add(this)
		}
	}
	val localProperties = Properties().apply {
		kotlin.runCatching {
			load(rootProject.file("local.properties").reader())
		}
	}
	iosSimulators.forEach { target ->
		target.testRuns.forEach { testRun ->
			(localProperties["ios.simulator"] as? String)?.let { testRun.deviceId = it }
		}
	}

	applyDefaultHierarchyTemplate()

	with(sourceSets) {
		val commonMain = get("commonMain")
		val jvmAndAndroidMain = create("jvmAndAndroidMain").apply {
			dependsOn(commonMain)
		}
		get("jvmMain").dependsOn(jvmAndAndroidMain)
		get("androidMain").dependsOn(jvmAndAndroidMain)
	}
}

fun NamedDomainObjectContainer<KotlinSourceSet>.optInIos(vararg optIns: String) {
	listOf(
		get("iosMain"),
		get("iosArm64Main"),
		get("iosX64Main"),
		get("iosSimulatorArm64Main"),
	).forEach { sourceSet ->
		optIns.forEach { optIn ->
			sourceSet.languageSettings.optIn(optIn)
		}
	}
}
