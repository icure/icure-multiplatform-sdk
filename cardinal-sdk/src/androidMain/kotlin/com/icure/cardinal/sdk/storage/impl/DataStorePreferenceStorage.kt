package com.icure.cardinal.sdk.storage.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.icure.cardinal.sdk.storage.StorageFacade
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

/**
 * DataStorePreferenceStorage is an implementation of StorageFacade that uses AndroidX DataStore to store key-value pairs.
 *
 * @param context The Android context to use for DataStore.
 * @param dataStoreName The name of the DataStore to use. (https://developer.android.com/topic/libraries/architecture/datastore#preferences-create)
 *
 * @see StorageFacade
 */
class DataStorePreferenceStorage(
	private val dataStore: DataStore<Preferences>
): StorageFacade {
	override suspend fun getItem(key: String): String? {
		return dataStore.data.map { prefs ->
			prefs[key.toPreferencesKey()]
		}.first()
	}

	override suspend fun setItem(key: String, value: String) {
		dataStore.edit { prefs ->
			prefs[key.toPreferencesKey()] = value
		}
	}

	override suspend fun removeItem(key: String) {
		dataStore.edit { prefs ->
			prefs.remove(key.toPreferencesKey())
		}
	}

	private fun String.toPreferencesKey() = stringPreferencesKey(this)
}
