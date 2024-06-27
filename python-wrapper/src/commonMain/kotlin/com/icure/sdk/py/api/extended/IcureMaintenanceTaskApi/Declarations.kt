// auto-generated file
package com.icure.sdk.py.api.extended.IcureMaintenanceTaskApi

import com.icure.sdk.IcureApis
import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.Set
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer

@Serializable
private class ApplyKeyPairUpdateParams(
	public val updateRequest: KeyPairUpdateNotification,
)

public fun applyKeyPairUpdateBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ApplyKeyPairUpdateParams>(params)
	runBlocking {
		sdk.icureMaintenanceTask.applyKeyPairUpdate(
			decodedParams.updateRequest,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun applyKeyPairUpdateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ApplyKeyPairUpdateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.icureMaintenanceTask.applyKeyPairUpdate(
				decodedParams.updateRequest,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateKeyPairUpdateNotificationsToAllDelegationCounterpartsParams(
	public val key: SpkiHexString,
	public val requestToOwnerTypes: Set<DataOwnerType>? = null,
)

public fun createKeyPairUpdateNotificationsToAllDelegationCounterpartsBlocking(sdk: IcureApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<CreateKeyPairUpdateNotificationsToAllDelegationCounterpartsParams>(params)
	runBlocking {
		sdk.icureMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
			decodedParams.key,
			decodedParams.requestToOwnerTypes,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createKeyPairUpdateNotificationsToAllDelegationCounterpartsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<CreateKeyPairUpdateNotificationsToAllDelegationCounterpartsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.icureMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
				decodedParams.key,
				decodedParams.requestToOwnerTypes,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateKeyPairUpdateNotificationToParams(
	public val dataOwnerId: String,
	public val key: SpkiHexString,
)

public fun createKeyPairUpdateNotificationToBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateKeyPairUpdateNotificationToParams>(params)
	runBlocking {
		sdk.icureMaintenanceTask.createKeyPairUpdateNotificationTo(
			decodedParams.dataOwnerId,
			decodedParams.key,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createKeyPairUpdateNotificationToAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateKeyPairUpdateNotificationToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.icureMaintenanceTask.createKeyPairUpdateNotificationTo(
				decodedParams.dataOwnerId,
				decodedParams.key,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
