// auto-generated file
package com.icure.cardinal.sdk.py.api.DocumentTemplateApi

import com.icure.cardinal.sdk.CardinalNonCryptoApis
import com.icure.cardinal.sdk.model.DocumentTemplate
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Byte
import kotlin.ByteArray
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
import kotlinx.serialization.builtins.serializer

@Serializable
private class GetDocumentTemplateParams(
	public val documentTemplateId: String,
)

@OptIn(InternalIcureApi::class)
public fun getDocumentTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDocumentTemplateParams>(params)
	runBlocking {
		sdk.documentTemplate.getDocumentTemplate(
			decodedParams.documentTemplateId,
		)
	}
}.toPyString(DocumentTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDocumentTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDocumentTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.getDocumentTemplate(
				decodedParams.documentTemplateId,
			)
		}.toPyStringAsyncCallback(DocumentTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDocumentTemplateParams(
	public val documentTemplate: DocumentTemplate,
)

@OptIn(InternalIcureApi::class)
public fun createDocumentTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDocumentTemplateParams>(params)
	runBlocking {
		sdk.documentTemplate.createDocumentTemplate(
			decodedParams.documentTemplate,
		)
	}
}.toPyString(DocumentTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDocumentTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDocumentTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.createDocumentTemplate(
				decodedParams.documentTemplate,
			)
		}.toPyStringAsyncCallback(DocumentTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentTemplateParams(
	public val documentTemplate: DocumentTemplate,
)

@OptIn(InternalIcureApi::class)
public fun modifyDocumentTemplateBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDocumentTemplateParams>(params)
	runBlocking {
		sdk.documentTemplate.modifyDocumentTemplate(
			decodedParams.documentTemplate,
		)
	}
}.toPyString(DocumentTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyDocumentTemplateAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDocumentTemplateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.modifyDocumentTemplate(
				decodedParams.documentTemplate,
			)
		}.toPyStringAsyncCallback(DocumentTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteDocumentTemplatesParams(
	public val documentTemplateIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deleteDocumentTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDocumentTemplatesParams>(params)
	runBlocking {
		sdk.documentTemplate.deleteDocumentTemplates(
			decodedParams.documentTemplateIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteDocumentTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDocumentTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.deleteDocumentTemplates(
				decodedParams.documentTemplateIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDocumentTemplatesBySpecialityParams(
	public val specialityCode: String,
)

@OptIn(InternalIcureApi::class)
public fun listDocumentTemplatesBySpecialityBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentTemplatesBySpecialityParams>(params)
	runBlocking {
		sdk.documentTemplate.listDocumentTemplatesBySpeciality(
			decodedParams.specialityCode,
		)
	}
}.toPyString(ListSerializer(DocumentTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listDocumentTemplatesBySpecialityAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentTemplatesBySpecialityParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.listDocumentTemplatesBySpeciality(
				decodedParams.specialityCode,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocumentTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDocumentTemplatesByDocumentTypeParams(
	public val documentTypeCode: String,
)

@OptIn(InternalIcureApi::class)
public fun listDocumentTemplatesByDocumentTypeBlocking(sdk: CardinalNonCryptoApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentTemplatesByDocumentTypeParams>(params)
	runBlocking {
		sdk.documentTemplate.listDocumentTemplatesByDocumentType(
			decodedParams.documentTypeCode,
		)
	}
}.toPyString(ListSerializer(DocumentTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listDocumentTemplatesByDocumentTypeAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentTemplatesByDocumentTypeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.listDocumentTemplatesByDocumentType(
				decodedParams.documentTypeCode,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocumentTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDocumentTemplatesByDocumentTypeForCurrentUserParams(
	public val documentTypeCode: String,
)

@OptIn(InternalIcureApi::class)
public fun listDocumentTemplatesByDocumentTypeForCurrentUserBlocking(sdk: CardinalNonCryptoApis,
		params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentTemplatesByDocumentTypeForCurrentUserParams>(params)
	runBlocking {
		sdk.documentTemplate.listDocumentTemplatesByDocumentTypeForCurrentUser(
			decodedParams.documentTypeCode,
		)
	}
}.toPyString(ListSerializer(DocumentTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listDocumentTemplatesByDocumentTypeForCurrentUserAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentTemplatesByDocumentTypeForCurrentUserParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.listDocumentTemplatesByDocumentTypeForCurrentUser(
				decodedParams.documentTypeCode,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocumentTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

public fun listDocumentTemplatesBlocking(sdk: CardinalNonCryptoApis): String = kotlin.runCatching {
	runBlocking {
		sdk.documentTemplate.listDocumentTemplates()
	}
}.toPyString(ListSerializer(DocumentTemplate.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listDocumentTemplatesAsync(sdk: CardinalNonCryptoApis,
		resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
		CValues<ByteVarOf<Byte>>?) -> Unit>>): Unit = kotlin.runCatching {
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.listDocumentTemplates()
		}.toPyStringAsyncCallback(ListSerializer(DocumentTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindAllDocumentTemplatesParams(
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findAllDocumentTemplatesBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAllDocumentTemplatesParams>(params)
	runBlocking {
		sdk.documentTemplate.findAllDocumentTemplates(
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(DocumentTemplate.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findAllDocumentTemplatesAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindAllDocumentTemplatesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.findAllDocumentTemplates(
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DocumentTemplate.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentTemplateAttachmentParams(
	public val documentTemplateId: String,
	public val attachmentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getDocumentTemplateAttachmentBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDocumentTemplateAttachmentParams>(params)
	runBlocking {
		sdk.documentTemplate.getDocumentTemplateAttachment(
			decodedParams.documentTemplateId,
			decodedParams.attachmentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDocumentTemplateAttachmentAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDocumentTemplateAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.getDocumentTemplateAttachment(
				decodedParams.documentTemplateId,
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAttachmentTextParams(
	public val documentTemplateId: String,
	public val attachmentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getAttachmentTextBlocking(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAttachmentTextParams>(params)
	runBlocking {
		sdk.documentTemplate.getAttachmentText(
			decodedParams.documentTemplateId,
			decodedParams.attachmentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAttachmentTextAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAttachmentTextParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.getAttachmentText(
				decodedParams.documentTemplateId,
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetDocumentTemplateAttachmentParams(
	public val documentTemplateId: String,
	@Serializable(ByteArraySerializer::class)
	public val payload: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun setDocumentTemplateAttachmentBlocking(sdk: CardinalNonCryptoApis, params: String): String
		= kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SetDocumentTemplateAttachmentParams>(params)
	runBlocking {
		sdk.documentTemplate.setDocumentTemplateAttachment(
			decodedParams.documentTemplateId,
			decodedParams.payload,
		)
	}
}.toPyString(DocumentTemplate.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setDocumentTemplateAttachmentAsync(
	sdk: CardinalNonCryptoApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SetDocumentTemplateAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.documentTemplate.setDocumentTemplateAttachment(
				decodedParams.documentTemplateId,
				decodedParams.payload,
			)
		}.toPyStringAsyncCallback(DocumentTemplate.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAttachmentUrlParams(
	public val documentId: String,
	public val attachmentId: String,
)

@OptIn(InternalIcureApi::class)
public fun getAttachmentUrl(sdk: CardinalNonCryptoApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetAttachmentUrlParams>(params)
	sdk.documentTemplate.getAttachmentUrl(
		decodedParams.documentId,
		decodedParams.attachmentId,
	)
}.toPyString(String.serializer())
