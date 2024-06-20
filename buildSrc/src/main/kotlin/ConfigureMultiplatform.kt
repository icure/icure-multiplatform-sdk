
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.kotlin.dsl.get
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.util.Properties

fun Project.configureKotlinJs(
	kotlinMultiplatformExtension: KotlinMultiplatformExtension,
	overrideModuleName: String? = null
) = with(kotlinMultiplatformExtension) {
	js(IR) {
		moduleName = overrideModuleName ?: project.name
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
		useEsModules()
	}
}

fun Project.configureKotlinLinux(
	kotlinMultiplatformExtension: KotlinMultiplatformExtension
) = with(kotlinMultiplatformExtension) {
	val localProperties = getLocalProperties()
//	val linuxArm64Target = linuxArm64() currently have to disable since we have no good ktor engine implementation
	val linuxX64Target = linuxX64()
	listOf(
//		linuxArm64Target,
		linuxX64Target
	).onEach { target ->
		target.binaries {
			all {
				freeCompilerArgs += listOf("-linker-option", "--allow-shlib-undefined")
				localProperties["cinteropsLibsDir"]?.also {
					linkerOpts.add(0, "-L$it")
				}
			}
		}
	}
}

/**
 * Configures targets and source sets for multiplatform modules.
 */
fun Project.configureMultiplatform(
	kotlinMultiplatformExtension: KotlinMultiplatformExtension
) = with(kotlinMultiplatformExtension) {
	val localProperties = getLocalProperties()
	val frameworkName = project.name.replaceFirstChar { it.uppercase() }
	val xcf = XCFramework(frameworkName)
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "1.8"
		}
	}
	configureKotlinJs(this)
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
	iosSimulators.forEach { target ->
		target.testRuns.forEach { testRun ->
			(localProperties["ios.simulator"] as? String)?.let { testRun.deviceId = it }
		}
	}
	configureKotlinLinux(kotlinMultiplatformExtension)

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

private fun Project.getLocalProperties() =
	Properties().apply {
		kotlin.runCatching {
			load(rootProject.file("local.properties").reader())
		}
	}
