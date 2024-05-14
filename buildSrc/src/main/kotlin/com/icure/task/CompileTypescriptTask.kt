package com.icure.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class CompileTypescriptTask : DefaultTask() {

	@TaskAction
	fun compile() {
		val wd = File("/Users/vincenzoclaudiopierro/Documents/GitHub/icure-multiplatform-sdk/icure-sdk/src/jsMain/typescript")
		val compileBuilder = ProcessBuilder("bash", "-c", "tsc -d -m es6 --outDir compiled *.ts")
		compileBuilder.directory(wd)
		val compileProcess = compileBuilder.start()
		val result = compileProcess.waitFor()
		if (result != 0) {
			throw IllegalStateException("Ts compilation failed: ${String(compileProcess.errorStream.readAllBytes())}")
		}


	}

}