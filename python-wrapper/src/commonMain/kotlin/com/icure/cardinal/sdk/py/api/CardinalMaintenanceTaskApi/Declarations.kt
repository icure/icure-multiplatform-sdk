// auto-generated file
package com.icure.cardinal.sdk.py.api.CardinalMaintenanceTaskApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.model.DataOwnerType
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.cardinal.sdk.model.specializations.SpkiHexString
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
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

@OptIn(InternalIcureApi::class)
public fun applyKeyPairUpdateBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ApplyKeyPairUpdateParams>(params)
	runBlocking {
		sdk.cardinalMaintenanceTask.applyKeyPairUpdate(
			decodedParams.updateRequest,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun applyKeyPairUpdateAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ApplyKeyPairUpdateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.cardinalMaintenanceTask.applyKeyPairUpdate(
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

@OptIn(InternalIcureApi::class)
public fun createKeyPairUpdateNotificationsToAllDelegationCounterpartsBlocking(sdk: CardinalApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateKeyPairUpdateNotificationsToAllDelegationCounterpartsParams>(params)
	runBlocking {
		sdk.cardinalMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
			decodedParams.key,
			decodedParams.requestToOwnerTypes,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createKeyPairUpdateNotificationsToAllDelegationCounterpartsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateKeyPairUpdateNotificationsToAllDelegationCounterpartsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.cardinalMaintenanceTask.createKeyPairUpdateNotificationsToAllDelegationCounterparts(
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

@OptIn(InternalIcureApi::class)
public fun createKeyPairUpdateNotificationToBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateKeyPairUpdateNotificationToParams>(params)
	runBlocking {
		sdk.cardinalMaintenanceTask.createKeyPairUpdateNotificationTo(
			decodedParams.dataOwnerId,
			decodedParams.key,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createKeyPairUpdateNotificationToAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateKeyPairUpdateNotificationToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.cardinalMaintenanceTask.createKeyPairUpdateNotificationTo(
				decodedParams.dataOwnerId,
				decodedParams.key,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
