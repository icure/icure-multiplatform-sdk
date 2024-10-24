package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade

actual suspend fun ApplicationStorageFacade(context: ApplicationContext?): StorageFacade {
	throw UnsupportedOperationException("ApplicationStorage is not supported on Linux platform")
}

actual typealias ApplicationContext = Any
