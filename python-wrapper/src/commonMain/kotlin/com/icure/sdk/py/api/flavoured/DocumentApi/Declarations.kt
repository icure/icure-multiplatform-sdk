// auto-generated file
package com.icure.sdk.py.api.flavoured.DocumentApi

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.DocumentShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.py.serialization.DocumentSerializer
import com.icure.sdk.py.serialization.MessageSerializer
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyCallbackResultHolder
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.serialization.ByteArraySerializer
import com.icure.sdk.utils.Serialization.fullJson
import com.icure.sdk.utils.Serialization.json
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.COpaquePointer
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.StableRef
import kotlinx.cinterop.cstr
import kotlinx.cinterop.invoke
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement

@Serializable
private class CreateDocumentParams(
	public val entity: DecryptedDocument,
)

public fun createDocumentBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDocumentParams>(params)
	runBlocking {
		sdk.document.createDocument(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDocumentAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDocumentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.createDocument(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedDocument?,
	@Serializable(MessageSerializer::class)
	public val message: Message?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val secretId: SecretIdOption =
			com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent,
)

public fun withEncryptionMetadataBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.document.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.message,
			decodedParams.user,
			decodedParams.delegates,
			decodedParams.secretId,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun withEncryptionMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.message,
				decodedParams.user,
				decodedParams.delegates,
				decodedParams.secretId,
			)
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndTryDecryptMainAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val attachmentId: String,
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentBlocking(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndTryDecryptMainAttachment(
			decodedParams.document,
			decodedParams.attachmentId,
			decryptedDocumentValidatorConverted,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsync(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndTryDecryptMainAttachment(
				decodedParams.document,
				decodedParams.attachmentId,
				decryptedDocumentValidatorConverted,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndTryDecryptMainAttachmentAsPlainTextParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val attachmentId: String,
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsPlainTextBlocking(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentAsPlainTextParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndTryDecryptMainAttachmentAsPlainText(
			decodedParams.document,
			decodedParams.attachmentId,
			decryptedDocumentValidatorConverted,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsPlainTextAsync(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentAsPlainTextParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndTryDecryptMainAttachmentAsPlainText(
				decodedParams.document,
				decodedParams.attachmentId,
				decryptedDocumentValidatorConverted,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndTryDecryptMainAttachmentAsJsonParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val attachmentId: String,
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsJsonBlocking(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentAsJsonParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndTryDecryptMainAttachmentAsJson(
			decodedParams.document,
			decodedParams.attachmentId,
			decryptedDocumentValidatorConverted,
		)
	}
}.toPyString(JsonElement.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsJsonAsync(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentAsJsonParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndTryDecryptMainAttachmentAsJson(
				decodedParams.document,
				decodedParams.attachmentId,
				decryptedDocumentValidatorConverted,
			)
		}.toPyStringAsyncCallback(JsonElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndDecryptMainAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val attachmentId: String,
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndDecryptMainAttachmentBlocking(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndDecryptMainAttachmentParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndDecryptMainAttachment(
			decodedParams.document,
			decodedParams.attachmentId,
			decryptedDocumentValidatorConverted,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getAndDecryptMainAttachmentAsync(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndDecryptMainAttachmentParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndDecryptMainAttachment(
				decodedParams.document,
				decodedParams.attachmentId,
				decryptedDocumentValidatorConverted,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptAndSetMainAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val utis: List<String>,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
)

public fun encryptAndSetMainAttachmentBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<EncryptAndSetMainAttachmentParams>(params)
	runBlocking {
		sdk.document.encryptAndSetMainAttachment(
			decodedParams.document,
			decodedParams.utis,
			decodedParams.attachment,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun encryptAndSetMainAttachmentAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<EncryptAndSetMainAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.encryptAndSetMainAttachment(
				decodedParams.document,
				decodedParams.utis,
				decodedParams.attachment,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndDecryptSecondaryAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val key: String,
	public val attachmentId: String,
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndDecryptSecondaryAttachmentBlocking(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndDecryptSecondaryAttachmentParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndDecryptSecondaryAttachment(
			decodedParams.document,
			decodedParams.key,
			decodedParams.attachmentId,
			decryptedDocumentValidatorConverted,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getAndDecryptSecondaryAttachmentAsync(
	sdk: IcureApis,
	params: String,
	decryptedDocumentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndDecryptSecondaryAttachmentParams>(params)
	val decryptedDocumentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedDocumentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedDocumentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndDecryptSecondaryAttachment(
				decodedParams.document,
				decodedParams.key,
				decodedParams.attachmentId,
				decryptedDocumentValidatorConverted,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptAndSetSecondaryAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val key: String,
	public val utis: List<String>,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
)

public fun encryptAndSetSecondaryAttachmentBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<EncryptAndSetSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.encryptAndSetSecondaryAttachment(
			decodedParams.document,
			decodedParams.key,
			decodedParams.utis,
			decodedParams.attachment,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun encryptAndSetSecondaryAttachmentAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<EncryptAndSetSecondaryAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.encryptAndSetSecondaryAttachment(
				decodedParams.document,
				decodedParams.key,
				decodedParams.utis,
				decodedParams.attachment,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
)

public fun getEncryptionKeysOfBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.document.getEncryptionKeysOf(
			decodedParams.document,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getEncryptionKeysOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getEncryptionKeysOf(
				decodedParams.document,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
)

public fun hasWriteAccessBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.document.hasWriteAccess(
			decodedParams.document,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun hasWriteAccessAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.hasWriteAccess(
				decodedParams.document,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptPatientIdOfParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
)

public fun decryptPatientIdOfBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.document.decryptPatientIdOf(
			decodedParams.document,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun decryptPatientIdOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.decryptPatientIdOf(
				decodedParams.document,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	@Serializable(DocumentSerializer::class)
	public val entity: Document,
	public val delegates: Set<String>,
)

public fun createDelegationDeAnonymizationMetadataBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.document.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteDocumentParams(
	public val entityId: String,
)

public fun deleteDocumentBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDocumentParams>(params)
	runBlocking {
		sdk.document.deleteDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteDocumentAsync(
	sdk: IcureApis,
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

public fun deleteDocumentsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDocumentsParams>(params)
	runBlocking {
		sdk.document.deleteDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteDocumentsAsync(
	sdk: IcureApis,
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
	public val attachmentId: String,
)

public fun getRawMainAttachmentBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawMainAttachmentParams>(params)
	runBlocking {
		sdk.document.getRawMainAttachment(
			decodedParams.documentId,
			decodedParams.attachmentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getRawMainAttachmentAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawMainAttachmentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getRawMainAttachment(
				decodedParams.documentId,
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMainAttachmentAsPlainTextParams(
	public val documentId: String,
	public val attachmentId: String,
)

public fun getMainAttachmentAsPlainTextBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMainAttachmentAsPlainTextParams>(params)
	runBlocking {
		sdk.document.getMainAttachmentAsPlainText(
			decodedParams.documentId,
			decodedParams.attachmentId,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMainAttachmentAsPlainTextAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMainAttachmentAsPlainTextParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getMainAttachmentAsPlainText(
				decodedParams.documentId,
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetMainAttachmentAsJsonParams(
	public val documentId: String,
	public val attachmentId: String,
)

public fun getMainAttachmentAsJsonBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMainAttachmentAsJsonParams>(params)
	runBlocking {
		sdk.document.getMainAttachmentAsJson(
			decodedParams.documentId,
			decodedParams.attachmentId,
		)
	}
}.toPyString(JsonElement.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getMainAttachmentAsJsonAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetMainAttachmentAsJsonParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getMainAttachmentAsJson(
				decodedParams.documentId,
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(JsonElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetRawSecondaryAttachmentParams(
	public val documentId: String,
	public val key: String,
	public val attachmentId: String,
)

public fun getRawSecondaryAttachmentBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetRawSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.getRawSecondaryAttachment(
			decodedParams.documentId,
			decodedParams.key,
			decodedParams.attachmentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getRawSecondaryAttachmentAsync(
	sdk: IcureApis,
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
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val document: DecryptedDocument,
	public val shareEncryptionKeys: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val shareOwningEntityIds: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val requestedPermission: RequestedPermission =
			com.icure.sdk.model.requests.RequestedPermission.MaxWrite,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.document.shareWith(
			decodedParams.delegateId,
			decodedParams.document,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.shareWith(
				decodedParams.delegateId,
				decodedParams.document,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedDocument.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val document: DecryptedDocument,
	public val delegates: Map<String, DocumentShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.document.tryShareWithMany(
			decodedParams.document,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun tryShareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.tryShareWithMany(
				decodedParams.document,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedDocument.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val document: DecryptedDocument,
	public val delegates: Map<String, DocumentShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.document.shareWithMany(
			decodedParams.document,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun shareWithManyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.shareWithMany(
				decodedParams.document,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindDocumentsByHcPartyPatientParams(
	public val hcPartyId: String,
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

public fun findDocumentsByHcPartyPatientBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDocumentsByHcPartyPatientParams>(params)
	runBlocking {
		sdk.document.findDocumentsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedDocument.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun findDocumentsByHcPartyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDocumentsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.findDocumentsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedDocument.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentParams(
	public val entity: DecryptedDocument,
)

public fun modifyDocumentBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentParams>(params)
	runBlocking {
		sdk.document.modifyDocument(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyDocumentAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentParams(
	public val entityId: String,
)

public fun getDocumentBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentParams>(params)
	runBlocking {
		sdk.document.getDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentByExternalUuidParams(
	public val externalUuid: String,
)

public fun getDocumentByExternalUuidBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentByExternalUuidParams>(params)
	runBlocking {
		sdk.document.getDocumentByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentByExternalUuidAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentsByExternalUuidParams(
	public val externalUuid: String,
)

public fun getDocumentsByExternalUuidBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsByExternalUuidParams>(params)
	runBlocking {
		sdk.document.getDocumentsByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentsByExternalUuidAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentsParams(
	public val entityIds: List<String>,
)

public fun getDocumentsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsParams>(params)
	runBlocking {
		sdk.document.getDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentsAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentsParams(
	public val entities: List<DecryptedDocument>,
)

public fun modifyDocumentsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentsParams>(params)
	runBlocking {
		sdk.document.modifyDocuments(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyDocumentsAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDocumentsByHcPartyMessageForeignKeysParams(
	public val hcPartyId: String,
	public val documentTypeCode: String?,
	public val secretMessageKeys: List<String>,
)

public fun listDocumentsByHcPartyMessageForeignKeysBlocking(sdk: IcureApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDocumentsByHcPartyMessageForeignKeysParams>(params)
	runBlocking {
		sdk.document.listDocumentsByHcPartyMessageForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.documentTypeCode,
			decodedParams.secretMessageKeys,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listDocumentsByHcPartyMessageForeignKeysAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindWithoutDelegationParams(
	public val limit: Int?,
)

public fun findWithoutDelegationBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindWithoutDelegationParams>(params)
	runBlocking {
		sdk.document.findWithoutDelegation(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findWithoutDelegationAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedDocument.serializer()), resultCallback)
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

public fun setRawMainAttachmentBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
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

public fun setRawSecondaryAttachmentBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
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

public fun deleteMainAttachmentBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteMainAttachmentParams>(params)
	runBlocking {
		sdk.document.deleteMainAttachment(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteMainAttachmentAsync(
	sdk: IcureApis,
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
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteSecondaryAttachmentParams(
	public val documentId: String,
	public val key: String,
	public val attachmentId: String,
)

public fun deleteSecondaryAttachmentBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.deleteSecondaryAttachment(
			decodedParams.documentId,
			decodedParams.key,
			decodedParams.attachmentId,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteSecondaryAttachmentAsync(
	sdk: IcureApis,
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
				decodedParams.attachmentId,
			)
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
