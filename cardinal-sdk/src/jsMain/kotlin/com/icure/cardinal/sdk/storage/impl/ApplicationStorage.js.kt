package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.CardinalPlatform
import com.icure.cardinal.sdk.utils.currentPlatform

actual suspend fun ApplicationStorageFacade(context: ApplicationContext?): StorageFacade {
	if (currentPlatform == CardinalPlatform.Browser) {
		return LocalStorageStorageFacade()
	} else throw UnsupportedOperationException("Application storage is not supported on Node")
}


actual typealias ApplicationContext = Any
