package com.icure.cardinal.sdk.dart.options

import android.content.Context
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
object StorageHelper {
	fun getStorage(options: String, context: Context): StorageFacade =  when (
		Serialization.fullLanguageInteropJson.decodeFromString<DartStorageOptions>(options)
	) {
		DartStorageOptions.Default -> com.icure.cardinal.sdk.storage.impl.DataStorePreferenceStorage(context)
	}
}