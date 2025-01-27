// auto-generated file
package com.icure.cardinal.sdk.py.api.FrontEndMigrationApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.FrontEndMigration
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class GetFrontEndMigrationParams(
	public val frontEndMigrationId: String,
)

@OptIn(InternalIcureApi::class)
public fun getFrontEndMigrationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFrontEndMigrationParams>(params)
	runBlocking {
		sdk.frontEndMigration.getFrontEndMigration(
			decodedParams.frontEndMigrationId,
		)
	}
}.toPyString(FrontEndMigration.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFrontEndMigrationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetFrontEndMigrationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.frontEndMigration.getFrontEndMigration(
				decodedParams.frontEndMigrationId,
			)
		}.toPyStringAsyncCallback(FrontEndMigration.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateFrontEndMigrationParams(
	public val frontEndMigration: FrontEndMigration,
)

@OptIn(InternalIcureApi::class)
public fun createFrontEndMigrationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFrontEndMigrationParams>(params)
	runBlocking {
		sdk.frontEndMigration.createFrontEndMigration(
			decodedParams.frontEndMigration,
		)
	}
}.toPyString(FrontEndMigration.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createFrontEndMigrationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateFrontEndMigrationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.frontEndMigration.createFrontEndMigration(
				decodedParams.frontEndMigration,
			)
		}.toPyStringAsyncCallback(FrontEndMigration.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun getFrontEndMigrationsBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.frontEndMigration.getFrontEndMigrations()
	}
}.toPyString(ListSerializer(FrontEndMigration.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFrontEndMigrationsAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): COpaquePointer? = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.frontEndMigration.getFrontEndMigrations()
		}.toPyStringAsyncCallback(ListSerializer(FrontEndMigration.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteFrontEndMigrationParams(
	public val frontEndMigrationId: String,
)

@OptIn(InternalIcureApi::class)
public fun deleteFrontEndMigrationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFrontEndMigrationParams>(params)
	runBlocking {
		sdk.frontEndMigration.deleteFrontEndMigration(
			decodedParams.frontEndMigrationId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteFrontEndMigrationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteFrontEndMigrationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.frontEndMigration.deleteFrontEndMigration(
				decodedParams.frontEndMigrationId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetFrontEndMigrationByNameParams(
	public val frontEndMigrationName: String,
)

@OptIn(InternalIcureApi::class)
public fun getFrontEndMigrationByNameBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetFrontEndMigrationByNameParams>(params)
	runBlocking {
		sdk.frontEndMigration.getFrontEndMigrationByName(
			decodedParams.frontEndMigrationName,
		)
	}
}.toPyString(ListSerializer(FrontEndMigration.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getFrontEndMigrationByNameAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetFrontEndMigrationByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.frontEndMigration.getFrontEndMigrationByName(
				decodedParams.frontEndMigrationName,
			)
		}.toPyStringAsyncCallback(ListSerializer(FrontEndMigration.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyFrontEndMigrationParams(
	public val frontEndMigration: FrontEndMigration,
)

@OptIn(InternalIcureApi::class)
public fun modifyFrontEndMigrationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFrontEndMigrationParams>(params)
	runBlocking {
		sdk.frontEndMigration.modifyFrontEndMigration(
			decodedParams.frontEndMigration,
		)
	}
}.toPyString(FrontEndMigration.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyFrontEndMigrationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyFrontEndMigrationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.frontEndMigration.modifyFrontEndMigration(
				decodedParams.frontEndMigration,
			)
		}.toPyStringAsyncCallback(FrontEndMigration.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
