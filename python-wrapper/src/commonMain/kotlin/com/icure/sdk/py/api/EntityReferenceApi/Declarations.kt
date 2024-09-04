// auto-generated file
package com.icure.sdk.py.api.EntityReferenceApi

import com.icure.sdk.CardinalNonCryptoApis
import com.icure.sdk.model.EntityReference
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
import kotlin.Byte
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
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

public fun getLatestBlocking(sdk: CardinalNonCryptoApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetLatestParams>(params)
	runBlocking {
		sdk.entityReference.getLatest(
			decodedParams.prefix,
		)
	}
}.toPyString(EntityReference.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getLatestAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetLatestParams>(params)
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

public fun createEntityReferenceBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateEntityReferenceParams>(params)
	runBlocking {
		sdk.entityReference.createEntityReference(
			decodedParams.entityReference,
		)
	}
}.toPyString(EntityReference.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createEntityReferenceAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateEntityReferenceParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityReference.createEntityReference(
				decodedParams.entityReference,
			)
		}.toPyStringAsyncCallback(EntityReference.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
