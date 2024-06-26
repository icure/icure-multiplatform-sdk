// auto-generated file
package com.icure.sdk.py.api.KeywordApi

import com.icure.sdk.IcureNonCryptoApis
import com.icure.sdk.model.Keyword
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.couchdb.DocIdentifier
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
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer

@Serializable
private class GetKeywordParams(
	public val frontEndMigrationId: String,
)

public fun getKeywordBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetKeywordParams>(params)
	runBlocking {
		sdk.keyword.getKeyword(
			decodedParams.frontEndMigrationId,
		)
	}
}.toPyString(Keyword.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getKeywordAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetKeywordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.getKeyword(
				decodedParams.frontEndMigrationId,
			)
		}.toPyStringAsyncCallback(Keyword.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateKeywordParams(
	public val frontEndMigration: Keyword,
)

public fun createKeywordBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateKeywordParams>(params)
	runBlocking {
		sdk.keyword.createKeyword(
			decodedParams.frontEndMigration,
		)
	}
}.toPyString(Keyword.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createKeywordAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateKeywordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.createKeyword(
				decodedParams.frontEndMigration,
			)
		}.toPyStringAsyncCallback(Keyword.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetKeywordsParams(
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun getKeywordsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetKeywordsParams>(params)
	runBlocking {
		sdk.keyword.getKeywords(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Keyword.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getKeywordsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetKeywordsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.getKeywords(
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(Keyword.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyKeywordParams(
	public val keyword: Keyword,
)

public fun modifyKeywordBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyKeywordParams>(params)
	runBlocking {
		sdk.keyword.modifyKeyword(
			decodedParams.keyword,
		)
	}
}.toPyString(Keyword.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyKeywordAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyKeywordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.modifyKeyword(
				decodedParams.keyword,
			)
		}.toPyStringAsyncCallback(Keyword.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetKeywordsByUserParams(
	public val userId: String,
)

public fun getKeywordsByUserBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetKeywordsByUserParams>(params)
	runBlocking {
		sdk.keyword.getKeywordsByUser(
			decodedParams.userId,
		)
	}
}.toPyString(ListSerializer(Keyword.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getKeywordsByUserAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetKeywordsByUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.getKeywordsByUser(
				decodedParams.userId,
			)
		}.toPyStringAsyncCallback(ListSerializer(Keyword.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteKeywordsParams(
	public val keywordIds: List<String>,
)

public fun deleteKeywordsBlocking(sdk: IcureNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteKeywordsParams>(params)
	runBlocking {
		sdk.keyword.deleteKeywords(
			decodedParams.keywordIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteKeywordsAsync(
	sdk: IcureNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteKeywordsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.deleteKeywords(
				decodedParams.keywordIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
