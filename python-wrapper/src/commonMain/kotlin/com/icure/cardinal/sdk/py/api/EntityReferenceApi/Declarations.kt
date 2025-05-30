// auto-generated file
package com.icure.cardinal.sdk.py.api.EntityReferenceApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.EntityReference
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
private class GetLatestParams(
	public val prefix: String,
)

@OptIn(InternalIcureApi::class)
public fun getLatestBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetLatestParams>(params)
	runBlocking {
		sdk.entityReference.getLatest(
			decodedParams.prefix,
		)
	}
}.toPyString(EntityReference.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getLatestAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetLatestParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityReference.getLatest(
				decodedParams.prefix,
			)
		}.toPyStringAsyncCallback(EntityReference.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateEntityReferenceParams(
	public val entityReference: EntityReference,
)

@OptIn(InternalIcureApi::class)
public fun createEntityReferenceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateEntityReferenceParams>(params)
	runBlocking {
		sdk.entityReference.createEntityReference(
			decodedParams.entityReference,
		)
	}
}.toPyString(EntityReference.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createEntityReferenceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateEntityReferenceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityReference.createEntityReference(
				decodedParams.entityReference,
			)
		}.toPyStringAsyncCallback(EntityReference.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
