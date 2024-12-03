// auto-generated file
package com.icure.cardinal.sdk.py.api.EntityTemplateApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.EntityTemplate
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
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
private class GetEntityTemplateParams(
	public val documentTemplateId: String,
)

@OptIn(InternalIcureApi::class)
public fun getEntityTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEntityTemplateParams>(params)
	runBlocking {
		sdk.entityTemplate.getEntityTemplate(
			decodedParams.documentTemplateId,
		)
	}
}.toPyString(EntityTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getEntityTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEntityTemplateParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createEntityTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateEntityTemplateParams>(params)
	runBlocking {
		sdk.entityTemplate.createEntityTemplate(
			decodedParams.applicationSettings,
		)
	}
}.toPyString(EntityTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createEntityTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateEntityTemplateParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyEntityTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyEntityTemplateParams>(params)
	runBlocking {
		sdk.entityTemplate.modifyEntityTemplate(
			decodedParams.documentTemplate,
		)
	}
}.toPyString(EntityTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyEntityTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyEntityTemplateParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listEntityTemplatesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListEntityTemplatesByParams>(params)
	runBlocking {
		sdk.entityTemplate.listEntityTemplatesBy(
			decodedParams.userId,
			decodedParams.type,
			decodedParams.searchString,
			decodedParams.includeEntities,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listEntityTemplatesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListEntityTemplatesByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listAllEntityTemplatesByBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListAllEntityTemplatesByParams>(params)
	runBlocking {
		sdk.entityTemplate.listAllEntityTemplatesBy(
			decodedParams.type,
			decodedParams.searchString,
			decodedParams.includeEntities,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listAllEntityTemplatesByAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListAllEntityTemplatesByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listEntityTemplatesByKeywordBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListEntityTemplatesByKeywordParams>(params)
	runBlocking {
		sdk.entityTemplate.listEntityTemplatesByKeyword(
			decodedParams.userId,
			decodedParams.type,
			decodedParams.keyword,
			decodedParams.includeEntities,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listEntityTemplatesByKeywordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListEntityTemplatesByKeywordParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findAllEntityTemplatesByKeywordBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAllEntityTemplatesByKeywordParams>(params)
	runBlocking {
		sdk.entityTemplate.findAllEntityTemplatesByKeyword(
			decodedParams.type,
			decodedParams.keyword,
			decodedParams.includeEntities,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findAllEntityTemplatesByKeywordAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAllEntityTemplatesByKeywordParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getEntityTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEntityTemplatesParams>(params)
	runBlocking {
		sdk.entityTemplate.getEntityTemplates(
			decodedParams.entityTemplateIds,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getEntityTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEntityTemplatesParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyEntityTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyEntityTemplatesParams>(params)
	runBlocking {
		sdk.entityTemplate.modifyEntityTemplates(
			decodedParams.entityTemplates,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyEntityTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyEntityTemplatesParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun createEntityTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateEntityTemplatesParams>(params)
	runBlocking {
		sdk.entityTemplate.createEntityTemplates(
			decodedParams.entityTemplates,
		)
	}
}.toPyString(ListSerializer(EntityTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createEntityTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateEntityTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.createEntityTemplates(
				decodedParams.entityTemplates,
			)
		}.toPyStringAsyncCallback(ListSerializer(EntityTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteEntityTemplatesParams(
	public val entityTemplateIds: List<IdWithMandatoryRev>,
)

@OptIn(InternalIcureApi::class)
public fun deleteEntityTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteEntityTemplatesParams>(params)
	runBlocking {
		sdk.entityTemplate.deleteEntityTemplates(
			decodedParams.entityTemplateIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteEntityTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): COpaquePointer? = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteEntityTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.entityTemplate.deleteEntityTemplates(
				decodedParams.entityTemplateIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
