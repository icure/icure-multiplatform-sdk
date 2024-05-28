import java.io.FileWriter

plugins {
	kotlinMultiplatform()
	kotlinSerialization()
	kotestMultiplatform()
	androidLibrary()
	id("maven-publish")
	id("com.taktik.gradle.git-version") version "2.0.8-gb47b2d0e35"
	id("com.google.devtools.ksp") version "1.9.24-1.0.20"
}

val repoUsername: String by project
val repoPassword: String by project
val mavenReleasesRepository: String by project

val gitVersion: String? by project
project.version = gitVersion ?: "0.0.1"

kotlin {
	configureMultiplatform(this)

	sourceSets {
		val commonMain by getting {
			dependencies {
				implementation(libs.ktorClientCore)
				implementation(libs.ktorContentNegotiation)
				implementation(libs.ktorSerializationJson)
				implementation(libs.kotlinSerialization)
				implementation(libs.kotlinDateTime)
				implementation(libs.kermit)
				implementation(libs.kryptom)
				implementation(libs.coroutinesCore)
				implementation(kotlin("reflect"))
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
				implementation(libs.ktorClientEngineOkhttp)
			}
		}
		val jvmTest by getting {
			dependencies {
				implementation(libs.kotestRunnerJunit)
				implementation("io.icure:icure-e2e-test-setup:0.0.24-gc854bb2431")
				implementation(libs.ktorClientEngineCio) // Currently needed by test setup, remove later
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
		iosMain {
			dependencies {
				implementation(libs.ktorClientEngineDarwin)
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

val ktJsCompiledPackage = projectDir.resolve("build/dist/js/productionLibrary")
val tsSources = projectDir.resolve("src/jsMain/typescript")
val mergedTsProject = projectDir.resolve("build/tsSourcesProject")
val tsCompiledSources = projectDir.resolve("build/tsCompiledSources")
val tsPackage = projectDir.resolve("build/tsPackage")

sealed interface Import {
	data class Default(
		val importedName: String,
		val from: String
	) : Import
	data class Module(
		val importedName: String,
		val from: String
	) : Import
}
data class Replacement(
	val of: String,
	val with: String
)
fun copyJsPatching(
	from: File,
	into: File,
	importing: List<Import> = emptyList(),
	replacing: List<Replacement> = emptyList()
) {
	FileWriter(into).use { fw ->
		importing.forEach {
			when (it) {
				is Import.Default -> fw.write("import ${it.importedName} from '${it.from}'\n")
				is Import.Module -> fw.write("import * as ${it.importedName} from '${it.from}'\n")
				else -> throw IllegalArgumentException("Unsupported import type: $it")
			}
		}
		replacing.fold(from.readText()) { acc, replacement ->
			acc.replace(replacement.of, replacement.with)
		}.let {
			fw.write(it)
		}
	}
}

fun copyAddingDependenciesToTsPackages(
	from: File,
	into: File
) {
	copyJsPatching(
		from = from,
		into = into,
		importing = tsSources.listFiles()!!.filter { it.isDirectory }.map {
			Import.Module(it.name, "./${it.name}.mjs")
		}
	)
}

val prepareTypescriptSourceCompilation = tasks.register("prepareTypescriptSourceCompilation") {
	dependsOn("jsNodeProductionLibraryDistribution")
	inputs.dir(tsSources)
	outputs.dir(mergedTsProject)
	fun generateIndexForDirAndSubdirs(currFile: File) {
		val (directories, files) = currFile.listFiles()!!.partition { it.isDirectory }
		FileWriter(currFile.resolve("index.ts")).use { fw ->
			directories.forEach {
				fw.write("export * from './${it.name}'\n")
			}
			files.forEach {
				val nameWithoutSuffix = it.name.removeSuffix(".mts").removeSuffix(".d")
				fw.write("export * from './$nameWithoutSuffix.mjs'\n")
			}
		}
		directories.forEach { generateIndexForDirAndSubdirs(it) }
	}
	doLast {
		delete(mergedTsProject)
		copy {
			from(tsSources)
			into(mergedTsProject)
		}
		copyAddingDependenciesToTsPackages(
			from = ktJsCompiledPackage.resolve("icure-sdk.d.ts"),
			into = mergedTsProject.resolve("icure-sdk.d.mts")
		)
		// Generate index files for main packages and for export
		val tsPackages = tsSources.listFiles()!!.filter { it.isDirectory }
		tsPackages.forEach { tsPackage ->
			FileWriter(mergedTsProject.resolve("${tsPackage.name}.mts")).use { fw ->
				tsPackage.walkTopDown().filter {
					!it.isDirectory && it.name.endsWith(".mts")
				}.forEach { currFile ->
					val currFilePath = currFile.relativeTo(tsSources).path.removeSuffix(".mts")
					fw.write("export * from './$currFilePath.mjs'\n")
				}
			}
		}
		FileWriter(mergedTsProject.resolve("index.mts")).use { fw ->
			tsPackages.forEach { tsPackage ->
				fw.write("export * from './${tsPackage.name}.mjs'\n")
			}
			fw.write("export * from './icure-sdk.mjs'\n")
		}
	}
}

val compileTypescriptSources = tasks.register("compileTypescriptSources") {
	// Note: requires tsc in path
	// Typescript configuration from tsconfig
	dependsOn(prepareTypescriptSourceCompilation)
	inputs.dir(projectDir.resolve(mergedTsProject))
	inputs.file(projectDir.resolve("tsconfig.json"))
	outputs.dir(projectDir.resolve(projectDir.resolve(tsCompiledSources)))
	doLast {
		delete(tsCompiledSources)
		exec {
			commandLine("tsc", "--project", projectDir.path)
		}
	}
}

tasks.register("prepareDistributionPackage") {
	dependsOn(compileTypescriptSources)
	val filesNeedingPatch = setOf(
		"icure-sdk.mjs",
		"icure-sdk.d.mts",
		"ktor-ktor-client-core.mjs",
		"ktor-ktor-utils.mjs"
	)
	doLast {
		copy {
			from(tsCompiledSources)
			into(tsPackage)
		}
		copy {
			from(ktJsCompiledPackage)
			into(tsPackage)
			exclude {
				it.name in filesNeedingPatch
			}
		}
		copyAddingDependenciesToTsPackages(
			from = ktJsCompiledPackage.resolve("icure-sdk.d.ts"),
			into = tsPackage.resolve("icure-sdk.d.mts")
		)
		copyAddingDependenciesToTsPackages(
			from = ktJsCompiledPackage.resolve("icure-sdk.mjs"),
			into = tsPackage.resolve("icure-sdk.mjs")
		)
		copyJsPatching(
			from = ktJsCompiledPackage.resolve("ktor-ktor-client-core.mjs"),
			into = tsPackage.resolve("ktor-ktor-client-core.mjs"),
			importing = listOf(
				Import.Default("nodeWs_imported", from = "ws"),
				Import.Default("nodeFetch_imported", from = "node-fetch"),
			),
			replacing = listOf(
				Replacement("eval('require')('ws')", with = "nodeWs_imported"),
				Replacement("eval('require')('node-fetch')", with = "nodeFetch_imported"),
				Replacement("eval('require')('abort-controller')", with = "AbortController")
			)
		)
		copyJsPatching(
			from = ktJsCompiledPackage.resolve("ktor-ktor-utils.mjs"),
			into = tsPackage.resolve("ktor-ktor-utils.mjs"),
			replacing = listOf(
				Replacement("eval('require')('crypto')", with = "crypto")
			)
		)
	}
}
