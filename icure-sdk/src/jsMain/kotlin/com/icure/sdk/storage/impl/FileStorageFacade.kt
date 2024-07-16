package com.icure.sdk.storage.impl

import com.icure.sdk.storage.StorageFacade

@Suppress("FunctionName")
actual fun FileStorageFacade(directory: String): StorageFacade {
	throw UnsupportedOperationException("File storage is not supported on JS")
}
