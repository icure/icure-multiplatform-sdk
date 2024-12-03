// TODO should become task type
tasks.register("clearAutoGenerated") {
	doLast {
		listOf(
			"lib/src",
			"cardinal_sdk/lib",
			"cardinal_sdk/ios/Classes",
			"cardinal_sdk/android/src",
		).forEach { sourceDir ->
			projectDir.resolve(sourceDir).walkBottomUp().forEach {
				if (it.isFile && it.readLines().firstOrNull()?.startsWith("// auto-generated file") == true) {
					it.delete()
				} else if (it.isDirectory && it.listFiles()!!.isEmpty()) {
					it.delete()
				}
			}
		}
	}
}

fun File.mergeInto(other: File) {
	check(isDirectory && other.isDirectory) { "Can only merge a directory into another directory - ${this.absolutePath} -> ${other.absolutePath}" }
	val otherFiles = other.listFiles()!!.groupBy { it.name }.mapValues {
		check (it.value.size == 1) { "Duplicate file names" }
		it.value.first()
	}
	listFiles()!!.forEach { curr ->
		if (otherFiles.containsKey(curr.name)) {
			val otherCurr = otherFiles.getValue(curr.name)
			check (curr.isDirectory == otherCurr.isDirectory) {
				"Generated isDirectory != existing isDirectory - ${curr.absolutePath} -> ${otherCurr.absolutePath}"
			}
			if (curr.isDirectory) {
				curr.mergeInto(otherCurr)
			} else {
				curr.copyTo(otherCurr, overwrite = true)
			}
		} else {
			curr.copyRecursively(other.resolve(curr.name))
		}
	}
}

// TODO should become task type
tasks.register("updateAutoGenerated") {
	doLast {
		rootDir.resolve("cardinal-sdk/build/generated/ksp/jvm/jvmMain/resources/dartSupportLib").mergeInto(
			projectDir.resolve("lib/src/commonMain/kotlin")
		)
		rootDir.resolve("cardinal-sdk/build/generated/ksp/jvm/jvmMain/resources/swiftMessageInterface").mergeInto(
			projectDir.resolve("cardinal_sdk/ios/Classes")
		)
		rootDir.resolve("cardinal-sdk/build/generated/ksp/jvm/jvmMain/resources/androidMessageInterface").mergeInto(
			projectDir.resolve("cardinal_sdk/android/src/main/kotlin")
		)
		rootDir.resolve("cardinal-sdk/build/generated/ksp/jvm/jvmMain/resources/dart").mergeInto(
			projectDir.resolve("cardinal_sdk/lib")
		)
	}
}