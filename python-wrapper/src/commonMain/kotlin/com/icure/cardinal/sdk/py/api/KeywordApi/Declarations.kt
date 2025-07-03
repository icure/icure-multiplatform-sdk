// auto-generated file
package com.icure.cardinal.sdk.py.api.KeywordApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.Keyword
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.Int
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

@Serializable
private class GetKeywordParams(
	public val keywordId: String,
)

@OptIn(InternalIcureApi::class)
public fun getKeywordBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetKeywordParams>(params)
	runBlocking {
		sdk.keyword.getKeyword(
			decodedParams.keywordId,
		)
	}
}.toPyString(Keyword.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getKeywordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetKeywordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.getKeyword(
				decodedParams.keywordId,
			)
		}.toPyStringAsyncCallback(Keyword.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateKeywordParams(
	public val keyword: Keyword,
)

@OptIn(InternalIcureApi::class)
public fun createKeywordBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateKeywordParams>(params)
	runBlocking {
		sdk.keyword.createKeyword(
			decodedParams.keyword,
		)
	}
}.toPyString(Keyword.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createKeywordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateKeywordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.createKeyword(
				decodedParams.keyword,
			)
		}.toPyStringAsyncCallback(Keyword.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetKeywordsParams(
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun getKeywordsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetKeywordsParams>(params)
	runBlocking {
		sdk.keyword.getKeywords(
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(Keyword.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getKeywordsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetKeywordsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyKeywordBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyKeywordParams>(params)
	runBlocking {
		sdk.keyword.modifyKeyword(
			decodedParams.keyword,
		)
	}
}.toPyString(Keyword.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyKeywordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyKeywordParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getKeywordsByUserBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetKeywordsByUserParams>(params)
	runBlocking {
		sdk.keyword.getKeywordsByUser(
			decodedParams.userId,
		)
	}
}.toPyString(ListSerializer(Keyword.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getKeywordsByUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetKeywordsByUserParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteKeywordsBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteKeywordsParams>(params)
	runBlocking {
		sdk.keyword.deleteKeywords(
			decodedParams.keywordIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteKeywordsAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteKeywordsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.keyword.deleteKeywords(
				decodedParams.keywordIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
