package storage

import com.icure.cardinal.sdk.dart.options.DartStorageOptions
import com.icure.cardinal.sdk.storage.StorageFacade
import com.icure.cardinal.sdk.utils.Serialization
import com.icure.utils.InternalIcureApi

@OptIn(InternalIcureApi::class)
object StorageHelper {
	fun getStorage(options: String): StorageFacade = when (
		Serialization.fullLanguageInteropJson.decodeFromString<DartStorageOptions>(options)
	) {
		DartStorageOptions.Default -> com.icure.cardinal.sdk.storage.impl.UserDefaultStorageFacade()
	}
}