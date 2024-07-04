package com.icure.sdk.storage.impl

import com.icure.sdk.storage.StorageFacade
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okio.FileSystem
import okio.Path.Companion.toPath

class NativeFileStorageFacade(
	directory: String
) : StorageFacade {

	private val filePath = "$directory/icure.store".toPath()
	private val storageMutex = Mutex()

	init {
		if(!FileSystem.SYSTEM.exists(directory.toPath())) {
			FileSystem.SYSTEM.createDirectories(directory.toPath())
		}
		if(!FileSystem.SYSTEM.exists(filePath)) {
			FileSystem.SYSTEM.write(filePath) {
				writeUtf8(Json.encodeToString(emptyMap<String, String>()))
			}
		}
	}

	private fun retrieveData() =
		Json.decodeFromString<Map<String, String>>(FileSystem.SYSTEM.read(filePath) { readUtf8() })

	private fun writeData(items: Map<String, String>) =
		FileSystem.SYSTEM.write(filePath) { writeUtf8(Json.encodeToString(items)) }

	override suspend fun getItem(key: String): String? = storageMutex.withLock { retrieveData()[key] }

	override suspend fun setItem(key: String, value: String) {
		storageMutex.withLock {
			val currentData = retrieveData()
			writeData(currentData + (key to value))
		}
	}

	override suspend fun removeItem(key: String) {
		storageMutex.withLock {
			val currentData = retrieveData()
			writeData(currentData - key)
		}
	}
}


@Suppress("FunctionName")
actual fun FileStorageFacade(directory: String): StorageFacade = NativeFileStorageFacade(directory)
