// auto-generated file
package com.icure.cardinal.sdk.py.api.HealthElementBasicApi.inGroup

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.model.EncryptedHealthElement
import com.icure.cardinal.sdk.model.GroupScoped
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
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

@Serializable
private class CreateHealthElementParams(
	public val entity: GroupScoped<EncryptedHealthElement>,
)

@OptIn(InternalIcureApi::class)
public fun createHealthElementBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.createHealthElement(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedHealthElement.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createHealthElementAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.inGroup.createHealthElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyHealthElementParams(
	public val entity: GroupScoped<EncryptedHealthElement>,
)

@OptIn(InternalIcureApi::class)
public fun modifyHealthElementBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.modifyHealthElement(
			decodedParams.entity,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedHealthElement.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyHealthElementAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.inGroup.modifyHealthElement(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetHealthElementParams(
	public val groupId: String,
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getHealthElementBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthElementParams>(params)
	runBlocking {
		sdk.healthElement.inGroup.getHealthElement(
			decodedParams.groupId,
			decodedParams.entityId,
		)
	}
}.toPyString(GroupScoped.serializer(EncryptedHealthElement.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getHealthElementAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetHealthElementParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.healthElement.inGroup.getHealthElement(
				decodedParams.groupId,
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(GroupScoped.serializer(EncryptedHealthElement.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
