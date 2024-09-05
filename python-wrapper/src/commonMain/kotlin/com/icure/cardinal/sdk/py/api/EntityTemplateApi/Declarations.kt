// auto-generated file
package com.icure.cardinal.sdk.py.api.EntityTemplateApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.EntityTemplate
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
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
private class GetEntityTemplateParams(
	public val documentTemplateId: String,
)

public fun getEntityTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEntityTemplateParams>(params)
	runBlocking {
		sdk.entityTemplate.getEntityTemplate(
			decodedParams.documentTemplateId,
		)
	}
}.toPyString(EntityTemplate.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getEntityTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEntityTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.getEntityTemplate(
				decodedParams.documentTemplateId,
			)
		}.toPyStringAsyncCallback(EntityTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateEntityTemplateParams(
	public val applicationSettings: EntityTemplate,
)

public fun createEntityTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateEntityTemplateParams>(params)
	runBlocking {
		sdk.entityTemplate.createEntityTemplate(
			decodedParams.applicationSettings,
		)
	}
}.toPyString(EntityTemplate.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createEntityTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateEntityTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.createEntityTemplate(
				decodedParams.applicationSettings,
			)
		}.toPyStringAsyncCallback(EntityTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyEntityTemplateParams(
	public val documentTemplate: EntityTemplate,
)

public fun modifyEntityTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyEntityTemplateParams>(params)
	runBlocking {
		sdk.entityTemplate.modifyEntityTemplate(
			decodedParams.documentTemplate,
		)
	}
}.toPyString(EntityTemplate.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyEntityTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyEntityTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.modifyEntityTemplate(
				decodedParams.documentTemplate,
			)
		}.toPyStringAsyncCallback(EntityTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListEntityTemplatesByParams(
	public val userId: String,
	public val type: String,
	public val searchString: String? = null,
	public val includeEntities: Boolean? = null,
)

public fun listEntityTemplatesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListEntityTemplatesByParams>(params)
	runBlocking {
		sdk.entityTemplate.listEntityTemplatesBy(
			decodedParams.userId,
			decodedParams.type,
			decodedParams.searchString,
			decodedParams.includeEntities,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listEntityTemplatesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListEntityTemplatesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.listEntityTemplatesBy(
				decodedParams.userId,
				decodedParams.type,
				decodedParams.searchString,
				decodedParams.includeEntities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EntityTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListAllEntityTemplatesByParams(
	public val type: String,
	public val searchString: String? = null,
	public val includeEntities: Boolean? = null,
)

public fun listAllEntityTemplatesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListAllEntityTemplatesByParams>(params)
	runBlocking {
		sdk.entityTemplate.listAllEntityTemplatesBy(
			decodedParams.type,
			decodedParams.searchString,
			decodedParams.includeEntities,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listAllEntityTemplatesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListAllEntityTemplatesByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.listAllEntityTemplatesBy(
				decodedParams.type,
				decodedParams.searchString,
				decodedParams.includeEntities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EntityTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListEntityTemplatesByKeywordParams(
	public val userId: String,
	public val type: String,
	public val keyword: String,
	public val includeEntities: Boolean? = null,
)

public fun listEntityTemplatesByKeywordBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListEntityTemplatesByKeywordParams>(params)
	runBlocking {
		sdk.entityTemplate.listEntityTemplatesByKeyword(
			decodedParams.userId,
			decodedParams.type,
			decodedParams.keyword,
			decodedParams.includeEntities,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listEntityTemplatesByKeywordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListEntityTemplatesByKeywordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.listEntityTemplatesByKeyword(
				decodedParams.userId,
				decodedParams.type,
				decodedParams.keyword,
				decodedParams.includeEntities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EntityTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindAllEntityTemplatesByKeywordParams(
	public val type: String,
	public val keyword: String,
	public val includeEntities: Boolean?,
)

public fun findAllEntityTemplatesByKeywordBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindAllEntityTemplatesByKeywordParams>(params)
	runBlocking {
		sdk.entityTemplate.findAllEntityTemplatesByKeyword(
			decodedParams.type,
			decodedParams.keyword,
			decodedParams.includeEntities,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findAllEntityTemplatesByKeywordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindAllEntityTemplatesByKeywordParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.findAllEntityTemplatesByKeyword(
				decodedParams.type,
				decodedParams.keyword,
				decodedParams.includeEntities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EntityTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEntityTemplatesParams(
	public val entityTemplateIds: List<String>,
)

public fun getEntityTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEntityTemplatesParams>(params)
	runBlocking {
		sdk.entityTemplate.getEntityTemplates(
			decodedParams.entityTemplateIds,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getEntityTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEntityTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.getEntityTemplates(
				decodedParams.entityTemplateIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EntityTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyEntityTemplatesParams(
	public val entityTemplates: List<EntityTemplate>,
)

public fun modifyEntityTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyEntityTemplatesParams>(params)
	runBlocking {
		sdk.entityTemplate.modifyEntityTemplates(
			decodedParams.entityTemplates,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyEntityTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyEntityTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.modifyEntityTemplates(
				decodedParams.entityTemplates,
			)
		}.toPyStringAsyncCallback(ListSerializer(EntityTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateEntityTemplatesParams(
	public val entityTemplates: List<EntityTemplate>,
)

public fun createEntityTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateEntityTemplatesParams>(params)
	runBlocking {
		sdk.entityTemplate.createEntityTemplates(
			decodedParams.entityTemplates,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun createEntityTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateEntityTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.createEntityTemplates(
				decodedParams.entityTemplates,
			)
		}.toPyStringAsyncCallback(ListSerializer(EntityTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteEntityTemplateParams(
	public val entityTemplateIds: List<String>,
)

public fun deleteEntityTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteEntityTemplateParams>(params)
	runBlocking {
		sdk.entityTemplate.deleteEntityTemplate(
			decodedParams.entityTemplateIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteEntityTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteEntityTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.deleteEntityTemplate(
				decodedParams.entityTemplateIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
