package com.icure.cardinal.sdk.storage.impl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
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

class DataStorePreferenceStorage(private val context: Context, dataStoreName: String = "cardinal_sdk_storage"): StorageFacade {
	private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = dataStoreName)

	override suspend fun getItem(key: String): String? {
		return context.dataStore.data.map { prefs ->
			prefs[key.toPreferencesKey()]
		}.first()
	}

	override suspend fun setItem(key: String, value: String) {
		context.dataStore.edit { prefs ->
			prefs[key.toPreferencesKey()] = value
		}
	}

	override suspend fun removeItem(key: String) {
		context.dataStore.edit { prefs ->
			prefs.remove(key.toPreferencesKey())
		}
	}

	private fun String.toPreferencesKey() = stringPreferencesKey(this)
}
