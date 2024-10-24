package com.icure.cardinal.sdk.storage.impl

import android.content.Context
import android.content.SharedPreferences
import com.icure.cardinal.sdk.storage.StorageFacade

actual typealias ApplicationContext = Context

@Suppress("FunctionName")
actual suspend fun ApplicationStorageFacade(context: ApplicationContext?): StorageFacade {
	requireNotNull(context) { "Android application context is required" }
	return SharedPreferenceStorage(context.getSharedPreferences(SharedPreferenceStorage.SHARED_PREFERENCE_REFERENCE, Context.MODE_PRIVATE))
}

class SharedPreferenceStorage(private val sharedPreferences: SharedPreferences): StorageFacade {
	private val editor
		get() = sharedPreferences.edit()

	companion object {
		const val SHARED_PREFERENCE_REFERENCE = "cardinal_sdk_storage"
	}
	override suspend fun getItem(key: String): String? {
		return sharedPreferences.getString(key, null)
	}

	override suspend fun setItem(key: String, value: String) {
		editor.putString(key, value)
		editor.commit()
	}

	override suspend fun removeItem(key: String) {
		editor.remove(key)
		editor.commit()
	}

}
