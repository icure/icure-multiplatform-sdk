// auto-generated file
package com.icure.sdk.py.api.flavoured.DocumentBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.serialization.ByteArraySerializer
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
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
import kotlinx.serialization.json.JsonElement

@Serializable
private class DeleteDocumentParams(
	public val entityId: String,
)

public fun deleteDocumentBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDocumentParams>(params)
	runBlocking {
		sdk.document.deleteDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteDocumentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDocumentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.deleteDocument(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteDocumentsParams(
	public val entityIds: List<String>,
)

public fun deleteDocumentsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDocumentsParams>(params)
	runBlocking {
		sdk.document.deleteDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteDocumentsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDocumentsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.deleteDocuments(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRawMainAttachmentParams(
	public val documentId: String,
)

public fun getRawMainAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawMainAttachmentParams>(params)
	runBlocking {
		sdk.document.getRawMainAttachment(
			decodedParams.documentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getRawMainAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawMainAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getRawMainAttachment(
				decodedParams.documentId,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMainAttachmentAsPlainTextParams(
	public val documentId: String,
)

public fun getMainAttachmentAsPlainTextBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMainAttachmentAsPlainTextParams>(params)
	runBlocking {
		sdk.document.getMainAttachmentAsPlainText(
			decodedParams.documentId,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMainAttachmentAsPlainTextAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMainAttachmentAsPlainTextParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getMainAttachmentAsPlainText(
				decodedParams.documentId,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMainAttachmentAsJsonParams(
	public val documentId: String,
)

public fun getMainAttachmentAsJsonBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMainAttachmentAsJsonParams>(params)
	runBlocking {
		sdk.document.getMainAttachmentAsJson(
			decodedParams.documentId,
		)
	}
}.toPyString(JsonElement.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMainAttachmentAsJsonAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMainAttachmentAsJsonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getMainAttachmentAsJson(
				decodedParams.documentId,
			)
		}.toPyStringAsyncCallback(JsonElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRawSecondaryAttachmentParams(
	public val documentId: String,
	public val key: String,
)

public fun getRawSecondaryAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.getRawSecondaryAttachment(
			decodedParams.documentId,
			decodedParams.key,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getRawSecondaryAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawSecondaryAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getRawSecondaryAttachment(
				decodedParams.documentId,
				decodedParams.key,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentParams(
	public val entity: EncryptedDocument,
)

public fun modifyDocumentBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentParams>(params)
	runBlocking {
		sdk.document.modifyDocument(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyDocumentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.modifyDocument(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentParams(
	public val entityId: String,
)

public fun getDocumentBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentParams>(params)
	runBlocking {
		sdk.document.getDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getDocument(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentByExternalUuidParams(
	public val externalUuid: String,
)

public fun getDocumentByExternalUuidBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentByExternalUuidParams>(params)
	runBlocking {
		sdk.document.getDocumentByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentByExternalUuidAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentByExternalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getDocumentByExternalUuid(
				decodedParams.externalUuid,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentsByExternalUuidParams(
	public val externalUuid: String,
)

public fun getDocumentsByExternalUuidBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsByExternalUuidParams>(params)
	runBlocking {
		sdk.document.getDocumentsByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentsByExternalUuidAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsByExternalUuidParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getDocumentsByExternalUuid(
				decodedParams.externalUuid,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentsParams(
	public val entityIds: List<String>,
)

public fun getDocumentsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsParams>(params)
	runBlocking {
		sdk.document.getDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getDocuments(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentsParams(
	public val entities: List<EncryptedDocument>,
)

public fun modifyDocumentsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentsParams>(params)
	runBlocking {
		sdk.document.modifyDocuments(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyDocumentsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.modifyDocuments(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDocumentsByHcPartyMessageForeignKeysParams(
	public val hcPartyId: String,
	public val documentTypeCode: String?,
	public val secretMessageKeys: List<String>,
)

public fun listDocumentsByHcPartyMessageForeignKeysBlocking(sdk: IcureBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDocumentsByHcPartyMessageForeignKeysParams>(params)
	runBlocking {
		sdk.document.listDocumentsByHcPartyMessageForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.documentTypeCode,
			decodedParams.secretMessageKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listDocumentsByHcPartyMessageForeignKeysAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDocumentsByHcPartyMessageForeignKeysParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.listDocumentsByHcPartyMessageForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.documentTypeCode,
				decodedParams.secretMessageKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindWithoutDelegationParams(
	public val limit: Int?,
)

public fun findWithoutDelegationBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindWithoutDelegationParams>(params)
	runBlocking {
		sdk.document.findWithoutDelegation(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findWithoutDelegationAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindWithoutDelegationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.findWithoutDelegation(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetRawMainAttachmentParams(
	public val documentId: String,
	public val rev: String,
	public val utis: List<String>,
	public val blobType: String,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
	public val encrypted: Boolean,
)

public fun setRawMainAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetRawMainAttachmentParams>(params)
	runBlocking {
		sdk.document.setRawMainAttachment(
			decodedParams.documentId,
			decodedParams.rev,
			decodedParams.utis,
			decodedParams.blobType,
			decodedParams.attachment,
			decodedParams.encrypted,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun setRawMainAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetRawMainAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.setRawMainAttachment(
				decodedParams.documentId,
				decodedParams.rev,
				decodedParams.utis,
				decodedParams.blobType,
				decodedParams.attachment,
				decodedParams.encrypted,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SetRawSecondaryAttachmentParams(
	public val documentId: String,
	public val key: String,
	public val rev: String,
	public val utis: List<String>,
	public val blobType: String,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
	public val encrypted: Boolean,
)

public fun setRawSecondaryAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetRawSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.setRawSecondaryAttachment(
			decodedParams.documentId,
			decodedParams.key,
			decodedParams.rev,
			decodedParams.utis,
			decodedParams.blobType,
			decodedParams.attachment,
			decodedParams.encrypted,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun setRawSecondaryAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetRawSecondaryAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.setRawSecondaryAttachment(
				decodedParams.documentId,
				decodedParams.key,
				decodedParams.rev,
				decodedParams.utis,
				decodedParams.blobType,
				decodedParams.attachment,
				decodedParams.encrypted,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteMainAttachmentParams(
	public val entityId: String,
	public val rev: String,
)

public fun deleteMainAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMainAttachmentParams>(params)
	runBlocking {
		sdk.document.deleteMainAttachment(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteMainAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMainAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.deleteMainAttachment(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteSecondaryAttachmentParams(
	public val documentId: String,
	public val key: String,
	public val rev: String,
)

public fun deleteSecondaryAttachmentBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.deleteSecondaryAttachment(
			decodedParams.documentId,
			decodedParams.key,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteSecondaryAttachmentAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteSecondaryAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.deleteSecondaryAttachment(
				decodedParams.documentId,
				decodedParams.key,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
