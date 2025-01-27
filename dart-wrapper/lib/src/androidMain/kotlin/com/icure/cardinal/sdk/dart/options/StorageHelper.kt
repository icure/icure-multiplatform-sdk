package com.icure.cardinal.sdk.dart.options

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.storage.impl.DataStorePreferenceStorage
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
object StorageHelper {
	private val Context.defaultDataStore: DataStore<Preferences> by preferencesDataStore(name = "cardinal_sdk_storage")

	fun getStorage(options: String, context: Context): StorageFacade =  when (
		Serialization.fullLanguageInteropJson.decodeFromString<DartStorageOptions>(options)
	) {
		DartStorageOptions.Default -> DataStorePreferenceStorage(context.defaultDataStore)
	}
}