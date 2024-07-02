// auto-generated file
package com.icure.sdk.py.api.DeviceApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.model.Device
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.Int
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class GetDeviceParams(
	public val deviceId: String,
)

public fun getDeviceBlocking(sdk: IcureNonCryptoApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDeviceParams>(params)
	runBlocking {
		sdk.device.getDevice(
			decodedParams.deviceId,
		)
	}
}.toPyString(Device.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDeviceAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDeviceParams>(params)
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

public fun getDevicesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDevicesParams>(params)
	runBlocking {
		sdk.device.getDevices(
			decodedParams.deviceIds,
		)
	}
}.toPyString(ListSerializer(Device.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getDevicesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDevicesParams>(params)
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

public fun createDeviceBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDeviceParams>(params)
	runBlocking {
		sdk.device.createDevice(
			decodedParams.p,
		)
	}
}.toPyString(Device.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDeviceAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDeviceParams>(params)
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

public fun updateDeviceBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateDeviceParams>(params)
	runBlocking {
		sdk.device.updateDevice(
			decodedParams.device,
		)
	}
}.toPyString(Device.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun updateDeviceAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateDeviceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.updateDevice(
				decodedParams.device,
			)
		}.toPyStringAsyncCallback(Device.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDevicesParams(
	public val devices: List<Device>,
)

public fun createDevicesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDevicesParams>(params)
	runBlocking {
		sdk.device.createDevices(
			decodedParams.devices,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun createDevicesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDevicesParams>(params)
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

public fun updateDevicesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateDevicesParams>(params)
	runBlocking {
		sdk.device.updateDevices(
			decodedParams.devices,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun updateDevicesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UpdateDevicesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.updateDevices(
				decodedParams.devices,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterDevicesByParams(
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val filterChain: FilterChain<Device>,
)

public fun filterDevicesByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDevicesByParams>(params)
	runBlocking {
		sdk.device.filterDevicesBy(
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.filterChain,
		)
	}
}.toPyString(PaginatedList.serializer(Device.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun filterDevicesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDevicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.filterDevicesBy(
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.filterChain,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Device.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchDevicesByParams(
	@Contextual
	public val filter: AbstractFilter<Device>,
)

public fun matchDevicesByBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchDevicesByParams>(params)
	runBlocking {
		sdk.device.matchDevicesBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchDevicesByAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchDevicesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.matchDevicesBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteDeviceParams(
	public val deviceId: String,
)

public fun deleteDeviceBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDeviceParams>(params)
	runBlocking {
		sdk.device.deleteDevice(
			decodedParams.deviceId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteDeviceAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDeviceParams>(params)
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

public fun deleteDevicesBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDevicesParams>(params)
	runBlocking {
		sdk.device.deleteDevices(
			decodedParams.deviceIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteDevicesAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDevicesParams>(params)
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

public fun getDevicesInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDevicesInGroupParams>(params)
	runBlocking {
		sdk.device.getDevicesInGroup(
			decodedParams.groupId,
			decodedParams.deviceIds,
		)
	}
}.toPyString(ListSerializer(Device.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getDevicesInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDevicesInGroupParams>(params)
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

public fun modifyDeviceInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDeviceInGroupParams>(params)
	runBlocking {
		sdk.device.modifyDeviceInGroup(
			decodedParams.groupId,
			decodedParams.device,
		)
	}
}.toPyString(Device.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyDeviceInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDeviceInGroupParams>(params)
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

public fun createDeviceInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDeviceInGroupParams>(params)
	runBlocking {
		sdk.device.createDeviceInGroup(
			decodedParams.groupId,
			decodedParams.device,
		)
	}
}.toPyString(Device.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDeviceInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDeviceInGroupParams>(params)
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

public fun deleteDevicesInGroupBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDevicesInGroupParams>(params)
	runBlocking {
		sdk.device.deleteDevicesInGroup(
			decodedParams.groupId,
			decodedParams.deviceIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteDevicesInGroupAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDevicesInGroupParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.device.deleteDevicesInGroup(
				decodedParams.groupId,
				decodedParams.deviceIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
