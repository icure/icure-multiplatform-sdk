package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.storage.StorageFacade
import platform.Foundation.NSUserDefaults

/**
 * Storage facade implementation for iOS, iPadOS, macOS & watchOS using NSUserDefaults.
 *
 * @param suiteName The domain identifier of the search list. [Documentation](https://developer.apple.com/documentation/foundation/nsuserdefaults/1409957-initwithsuitename)
 *
 * @see StorageFacade
 */
class UserDefaultStorageFacade(suiteName: String? = null): StorageFacade {
	private val userDefaults: NSUserDefaults = suiteName?.let { NSUserDefaults(suiteName = it) } ?: NSUserDefaults.standardUserDefaults

	override suspend fun getItem(key: String): String? {
		return userDefaults.stringForKey(key)
	}

	override suspend fun setItem(key: String, value: String) {
		userDefaults.setObject(value, key)
	}

	override suspend fun removeItem(key: String) {
		userDefaults.removeObjectForKey(key)
	}
}
