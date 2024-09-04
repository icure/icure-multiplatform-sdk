package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade

@Suppress("FunctionName")
actual suspend fun FileStorageFacade(directory: String): StorageFacade {
	throw UnsupportedOperationException("File storage is not supported on Android")
}
