// auto-generated file
package com.icure.sdk.py.api.FrontEndMigrationApi

import com.icure.sdk.CardinalNonCryptoApis
import com.icure.sdk.model.FrontEndMigration
import com.icure.sdk.model.couchdb.DocIdentifier
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
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class GetFrontEndMigrationParams(
	public val frontEndMigrationId: String,
)

public fun getFrontEndMigrationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFrontEndMigrationParams>(params)
	runBlocking {
		sdk.frontEndMigration.getFrontEndMigration(
			decodedParams.frontEndMigrationId,
		)
	}
}.toPyString(FrontEndMigration.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getFrontEndMigrationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFrontEndMigrationParams>(params)
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

public fun createFrontEndMigrationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFrontEndMigrationParams>(params)
	runBlocking {
		sdk.frontEndMigration.createFrontEndMigration(
			decodedParams.frontEndMigration,
		)
	}
}.toPyString(FrontEndMigration.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createFrontEndMigrationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateFrontEndMigrationParams>(params)
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
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
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

public fun deleteFrontEndMigrationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFrontEndMigrationParams>(params)
	runBlocking {
		sdk.frontEndMigration.deleteFrontEndMigration(
			decodedParams.frontEndMigrationId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteFrontEndMigrationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteFrontEndMigrationParams>(params)
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

public fun getFrontEndMigrationByNameBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFrontEndMigrationByNameParams>(params)
	runBlocking {
		sdk.frontEndMigration.getFrontEndMigrationByName(
			decodedParams.frontEndMigrationName,
		)
	}
}.toPyString(ListSerializer(FrontEndMigration.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getFrontEndMigrationByNameAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetFrontEndMigrationByNameParams>(params)
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

public fun modifyFrontEndMigrationBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFrontEndMigrationParams>(params)
	runBlocking {
		sdk.frontEndMigration.modifyFrontEndMigration(
			decodedParams.frontEndMigration,
		)
	}
}.toPyString(FrontEndMigration.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyFrontEndMigrationAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyFrontEndMigrationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.frontEndMigration.modifyFrontEndMigration(
				decodedParams.frontEndMigration,
			)
		}.toPyStringAsyncCallback(FrontEndMigration.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
