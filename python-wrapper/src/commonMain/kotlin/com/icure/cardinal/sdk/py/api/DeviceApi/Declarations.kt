// auto-generated file
package com.icure.cardinal.sdk.py.api.DeviceApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.Device
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class GetDeviceParams(
	public val deviceId: String,
)

@OptIn(InternalIcureApi::class)
public fun getDeviceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDeviceParams>(params)
	runBlocking {
		sdk.device.getDevice(
			decodedParams.deviceId,
		)
	}
}.toPyString(Device.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDeviceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDeviceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.getDevice(
				decodedParams.deviceId,
			)
		}.toPyStringAsyncCallback(Device.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDevicesParams(
	public val deviceIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getDevicesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDevicesParams>(params)
	runBlocking {
		sdk.device.getDevices(
			decodedParams.deviceIds,
		)
	}
}.toPyString(ListSerializer(Device.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDevicesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDevicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.getDevices(
				decodedParams.deviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Device.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDeviceParams(
	public val p: Device,
)

@OptIn(InternalIcureApi::class)
public fun createDeviceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDeviceParams>(params)
	runBlocking {
		sdk.device.createDevice(
			decodedParams.p,
		)
	}
}.toPyString(Device.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDeviceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDeviceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.createDevice(
				decodedParams.p,
			)
		}.toPyStringAsyncCallback(Device.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UpdateDeviceParams(
	public val device: Device,
)

@OptIn(InternalIcureApi::class)
public fun updateDeviceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateDeviceParams>(params)
	runBlocking {
		sdk.device.modifyDevice(
			decodedParams.device,
		)
	}
}.toPyString(Device.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun updateDeviceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateDeviceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.modifyDevice(
				decodedParams.device,
			)
		}.toPyStringAsyncCallback(Device.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDevicesParams(
	public val devices: List<Device>,
)

@OptIn(InternalIcureApi::class)
public fun createDevicesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDevicesParams>(params)
	runBlocking {
		sdk.device.createDevices(
			decodedParams.devices,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDevicesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDevicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.createDevices(
				decodedParams.devices,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UpdateDevicesParams(
	public val devices: List<Device>,
)

@OptIn(InternalIcureApi::class)
public fun updateDevicesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateDevicesParams>(params)
	runBlocking {
		sdk.device.modifyDevices(
			decodedParams.devices,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun updateDevicesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UpdateDevicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.modifyDevices(
				decodedParams.devices,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterDevicesByParams(
	public val filter: BaseFilterOptions<Device>,
)

@OptIn(InternalIcureApi::class)
public fun filterDevicesByBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterDevicesByParams>(params)
	runBlocking {
		sdk.device.filterDevicesBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, Device.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterDevicesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterDevicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.filterDevicesBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, Device.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterDevicesBySortedParams(
	public val filter: BaseSortableFilterOptions<Device>,
)

@OptIn(InternalIcureApi::class)
public fun filterDevicesBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterDevicesBySortedParams>(params)
	runBlocking {
		sdk.device.filterDevicesBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, Device.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterDevicesBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterDevicesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.filterDevicesBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, Device.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class MatchDevicesByParams(
	public val filter: BaseFilterOptions<Device>,
)

@OptIn(InternalIcureApi::class)
public fun matchDevicesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchDevicesByParams>(params)
	runBlocking {
		sdk.device.matchDevicesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchDevicesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchDevicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.matchDevicesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchDevicesBySortedParams(
	public val filter: BaseSortableFilterOptions<Device>,
)

@OptIn(InternalIcureApi::class)
public fun matchDevicesBySortedBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchDevicesBySortedParams>(params)
	runBlocking {
		sdk.device.matchDevicesBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchDevicesBySortedAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchDevicesBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.matchDevicesBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteDeviceParams(
	public val deviceId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteDeviceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDeviceParams>(params)
	runBlocking {
		sdk.device.deleteDevice(
			decodedParams.deviceId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteDeviceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDeviceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.deleteDevice(
				decodedParams.deviceId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteDevicesParams(
	public val deviceIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteDevicesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDevicesParams>(params)
	runBlocking {
		sdk.device.deleteDevices(
			decodedParams.deviceIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteDevicesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDevicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.deleteDevices(
				decodedParams.deviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDevicesInGroupParams(
	public val groupId: String,
	public val deviceIds: List<String>? = null,
)

@OptIn(InternalIcureApi::class)
public fun getDevicesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDevicesInGroupParams>(params)
	runBlocking {
		sdk.device.getDevicesInGroup(
			decodedParams.groupId,
			decodedParams.deviceIds,
		)
	}
}.toPyString(ListSerializer(Device.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDevicesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDevicesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.getDevicesInGroup(
				decodedParams.groupId,
				decodedParams.deviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(Device.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDeviceInGroupParams(
	public val groupId: String,
	public val device: Device,
)

@OptIn(InternalIcureApi::class)
public fun modifyDeviceInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDeviceInGroupParams>(params)
	runBlocking {
		sdk.device.modifyDeviceInGroup(
			decodedParams.groupId,
			decodedParams.device,
		)
	}
}.toPyString(Device.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyDeviceInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDeviceInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.modifyDeviceInGroup(
				decodedParams.groupId,
				decodedParams.device,
			)
		}.toPyStringAsyncCallback(Device.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDeviceInGroupParams(
	public val groupId: String,
	public val device: Device,
)

@OptIn(InternalIcureApi::class)
public fun createDeviceInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDeviceInGroupParams>(params)
	runBlocking {
		sdk.device.createDeviceInGroup(
			decodedParams.groupId,
			decodedParams.device,
		)
	}
}.toPyString(Device.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDeviceInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDeviceInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.createDeviceInGroup(
				decodedParams.groupId,
				decodedParams.device,
			)
		}.toPyStringAsyncCallback(Device.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteDevicesInGroupParams(
	public val groupId: String,
	public val deviceIds: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteDevicesInGroupBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDevicesInGroupParams>(params)
	runBlocking {
		sdk.device.deleteDevicesInGroup(
			decodedParams.groupId,
			decodedParams.deviceIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteDevicesInGroupAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDevicesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.deleteDevicesInGroup(
				decodedParams.groupId,
				decodedParams.deviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
