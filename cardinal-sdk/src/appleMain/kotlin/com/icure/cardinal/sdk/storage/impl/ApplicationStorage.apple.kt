package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade
import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject

actual suspend fun ApplicationStorageFacade(context: ApplicationContext?): StorageFacade = UserDefaultStorageFacade()

class UserDefaultStorageFacade: StorageFacade {

	override suspend fun getItem(key: String): String? {
		return NSUserDefaults.standardUserDefaults.stringForKey(key)
	}

	override suspend fun setItem(key: String, value: String) {
		NSUserDefaults.standardUserDefaults.setObject(value, key)
	}

	override suspend fun removeItem(key: String) {
		NSUserDefaults.standardUserDefaults.removeObjectForKey(key)
	}

}

actual typealias ApplicationContext = NSObject
