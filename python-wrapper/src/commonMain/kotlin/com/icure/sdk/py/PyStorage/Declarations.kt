package com.icure.sdk.py.PyStorage

import com.icure.sdk.py.utils.withResultHolder
import com.icure.sdk.storage.StorageFacade
import kotlinx.cinterop.ByteVar
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.cstr
import kotlinx.cinterop.invoke
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.nullable
import kotlinx.serialization.builtins.serializer

/**
 * Options for the creation of storage capabilities.
 * Currently, we only support storage of keys as encoded pkcs8/spki strings on python.
 * In future when we support more KeyStorageOptions by default we may want to introduce them also in python, as key
 * "encoding" options or something like that.
 */
@Serializable
internal sealed interface StorageFacadeOptions {
	@Serializable
	data class File(val directory: String): StorageFacadeOptions
	@Serializable
	data object Custom: StorageFacadeOptions
}

@OptIn(ExperimentalForeignApi::class)
fun createCustomStorageFacade(
	pyGetItem: CPointer<CFunction<(resultHolder: COpaquePointer, key: CValues<ByteVar>) -> Unit>>,
	pySetItem: CPointer<CFunction<(key: CValues<ByteVar>, value: CValues<ByteVar>) -> Unit>>,
	pyRemoveItem: CPointer<CFunction<(key: CValues<ByteVar>) -> Unit>>,
): COpaquePointer {
	val storageFacade: StorageFacade = object : StorageFacade {
		override suspend fun getItem(key: String): String? =
			withResultHolder(String.serializer().nullable) { resultHolderPtr ->
				pyGetItem(
					resultHolderPtr,
					key.cstr
				)
			}

		override suspend fun setItem(key: String, value: String) {
			pySetItem(key.cstr, value.cstr)
		}

		override suspend fun removeItem(key: String) {
			pyRemoveItem(key.cstr)
		}
	}
	return StableRef.create(storageFacade).asCPointer()
}