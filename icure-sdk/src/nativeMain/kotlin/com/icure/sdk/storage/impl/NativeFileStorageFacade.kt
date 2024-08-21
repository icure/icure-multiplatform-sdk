package com.icure.sdk.storage.impl

import com.icure.sdk.storage.StorageFacade
import okio.FileSystem
import okio.IOException
import okio.Path.Companion.toPath

class NativeFileStorageFacade(
	private val directory: String
) : StorageFacade {

	init {
		if(!FileSystem.SYSTEM.exists(directory.toPath())) {
			try {
				FileSystem.SYSTEM.createDirectories(directory.toPath())
			} catch(e: IOException) {
				throw IllegalStateException("Unable to create iCure local storage directory: $directory", e)
			}
		}
	}

	private fun toFilePath(filename: String) = "$directory/$filename".toPath()

	override suspend fun getItem(key: String): String? = runCatching {
		FileSystem.SYSTEM.read(toFilePath(key)) { readUtf8() }
	}.getOrNull()

	override suspend fun setItem(key: String, value: String) {
		try {
			FileSystem.SYSTEM.write(toFilePath(key)) { writeUtf8(value) }
		} catch(e: IOException) {
			throw IllegalStateException("Unable to write iCure storage file $directory/$key", e)
		}
	}

	override suspend fun removeItem(key: String) {
		try {
			if(FileSystem.SYSTEM.exists(toFilePath(key))) {
				FileSystem.SYSTEM.delete(toFilePath(key))
			}
		} catch(e: IOException) {
			throw IllegalStateException("Unable to delete iCure storage file $directory/$key", e)
		}
	}
}


@Suppress("FunctionName")
actual suspend fun FileStorageFacade(directory: String): StorageFacade = NativeFileStorageFacade(directory)
