package tasks

import java.io.File
import java.util.concurrent.TimeUnit
import kotlin.io.path.Path

/**
 * Extracts the files embed in the compose file and creates them in the download directory
 * @param composeFile the compose file
 */
fun createConfigurationFilesFromCompose(composeFile: File) {
	val scratchDir = composeFile.parentFile.path
	composeFile.readText().split(Regex("# => "))
		.let { it.subList(1, it.size) }
		.forEach { embedFile ->
			embedFile.split(Regex("[\r\n]+# ")).let {
				val basePath = it.first().toPathFromBaseFolder(scratchDir)
				if (!File(basePath).exists()) File(basePath).mkdirs()
				Path(scratchDir, it.first()).toFile().writeText(
					it.subList(1, it.size).joinToString(separator = "\n") { line -> line }
				)
			}
		}
}

/**
 * Removes the local reference (.) and the file from a path and appends it to the base path
 * @param basePath the base path
 * @return the new path
 */
fun String.toPathFromBaseFolder(basePath: String) =
	this
		.split("/").let {
			it.subList(0, it.size - 1).filter { subPath -> subPath != "." }
		}
		.joinToString(separator = "/") { it }
		.let { "$basePath/$it" }

/**
 * Executes a command in a directory with some environment variables
 * @param command the command to execute
 * @param envVars a map containing the environment variable to value pairs
 * @param runDir the directory where to run the command
 */
fun execute(command: String, envVars: Map<String, String> = emptyMap(), runDir: String? = null) =
	ProcessBuilder("sh", "-c", command)
		.apply {
			envVars.forEach {
				this.environment()[it.key] = it.value
			}
			runDir?.let {
				this.directory(File(runDir))
			}
		}
		.start()
		.waitFor(2, TimeUnit.MINUTES)