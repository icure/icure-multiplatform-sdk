// auto-generated file
package com.icure.sdk.py.api.DocumentApi

import com.icure.sdk.CardinalApis
import com.icure.sdk.crypto.entities.DocumentShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.DecryptedDocument
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
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
import kotlin.Boolean
import kotlin.Byte
import kotlin.ByteArray
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
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

public fun createDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDocumentParams>(params)
	runBlocking {
		sdk.document.createDocument(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDocumentAsync(
	sdk: CardinalApis,
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

public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndTryDecryptMainAttachment(
			decodedParams.document,
			decryptedAttachmentValidatorConverted,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndTryDecryptMainAttachment(
				decodedParams.document,
				decryptedAttachmentValidatorConverted,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndTryDecryptMainAttachmentAsPlainTextParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsPlainTextBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentAsPlainTextParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndTryDecryptMainAttachmentAsPlainText(
			decodedParams.document,
			decryptedAttachmentValidatorConverted,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsPlainTextAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentAsPlainTextParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndTryDecryptMainAttachmentAsPlainText(
				decodedParams.document,
				decryptedAttachmentValidatorConverted,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndTryDecryptMainAttachmentAsJsonParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsJsonBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentAsJsonParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndTryDecryptMainAttachmentAsJson(
			decodedParams.document,
			decryptedAttachmentValidatorConverted,
		)
	}
}.toPyString(JsonElement.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getAndTryDecryptMainAttachmentAsJsonAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndTryDecryptMainAttachmentAsJsonParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndTryDecryptMainAttachmentAsJson(
				decodedParams.document,
				decryptedAttachmentValidatorConverted,
			)
		}.toPyStringAsyncCallback(JsonElement.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetAndDecryptMainAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndDecryptMainAttachmentBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndDecryptMainAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndDecryptMainAttachment(
			decodedParams.document,
			decryptedAttachmentValidatorConverted,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getAndDecryptMainAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndDecryptMainAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndDecryptMainAttachment(
				decodedParams.document,
				decryptedAttachmentValidatorConverted,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptAndSetMainAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val utis: List<String>?,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
)

public fun encryptAndSetMainAttachmentBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
)

@OptIn(ExperimentalForeignApi::class)
public fun getAndDecryptSecondaryAttachmentBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndDecryptSecondaryAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.getAndDecryptSecondaryAttachment(
			decodedParams.document,
			decodedParams.key,
			decryptedAttachmentValidatorConverted,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getAndDecryptSecondaryAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetAndDecryptSecondaryAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.getAndDecryptSecondaryAttachment(
				decodedParams.document,
				decodedParams.key,
				decryptedAttachmentValidatorConverted,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class EncryptAndSetSecondaryAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	public val key: String,
	public val utis: List<String>?,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
)

public fun encryptAndSetSecondaryAttachmentBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.document.hasWriteAccess(
			decodedParams.document,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun hasWriteAccessAsync(
	sdk: CardinalApis,
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

public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.document.decryptPatientIdOf(
			decodedParams.document,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun decryptPatientIdOfAsync(
	sdk: CardinalApis,
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

public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
private class DecryptParams(
	public val document: EncryptedDocument,
)

public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.document.decrypt(
			decodedParams.document,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun decryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.decrypt(
				decodedParams.document,
			)
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val document: EncryptedDocument,
)

public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.document.tryDecrypt(
			decodedParams.document,
		)
	}
}.toPyString(DocumentSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun tryDecryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.tryDecrypt(
				decodedParams.document,
			)
		}.toPyStringAsyncCallback(DocumentSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptAttachmentParams(
	@Serializable(DocumentSerializer::class)
	public val document: Document,
	@Serializable(ByteArraySerializer::class)
	public val encryptedAttachment: ByteArray,
)

@OptIn(ExperimentalForeignApi::class)
public fun tryDecryptAttachmentBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	runBlocking {
		sdk.document.tryDecryptAttachment(
			decodedParams.document,
			decodedParams.encryptedAttachment,
			decryptedAttachmentValidatorConverted,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(ExperimentalForeignApi::class)
public fun tryDecryptAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullJson.encodeToJsonElement(ByteArraySerializer, x0),
			))
			val resultHolder = PyCallbackResultHolder(Boolean.serializer())
			val resultHolderRef = StableRef.create(resultHolder)
			decryptedAttachmentValidator.invoke(resultHolderRef.asCPointer(), jsonParams.toString().cstr)
			resultHolderRef.dispose()
			resultHolder.getOrThrow()
		}
	} else null
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.tryDecryptAttachment(
				decodedParams.document,
				decodedParams.encryptedAttachment,
				decryptedAttachmentValidatorConverted,
			)
		}.toPyStringAsyncCallback(ByteArraySerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchDocumentsByParams(
	public val filter: FilterOptions<Document>,
)

public fun matchDocumentsByBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchDocumentsByParams>(params)
	runBlocking {
		sdk.document.matchDocumentsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchDocumentsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchDocumentsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.matchDocumentsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchDocumentsBySortedParams(
	public val filter: SortableFilterOptions<Document>,
)

public fun matchDocumentsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchDocumentsBySortedParams>(params)
	runBlocking {
		sdk.document.matchDocumentsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchDocumentsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchDocumentsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.matchDocumentsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeleteDocumentParams(
	public val entityId: String,
)

public fun deleteDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDocumentParams>(params)
	runBlocking {
		sdk.document.deleteDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deleteDocumentAsync(
	sdk: CardinalApis,
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

public fun deleteDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeleteDocumentsParams>(params)
	runBlocking {
		sdk.document.deleteDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deleteDocumentsAsync(
	sdk: CardinalApis,
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

public fun getRawMainAttachmentBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun getMainAttachmentAsPlainTextBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun getMainAttachmentAsJsonBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun getRawSecondaryAttachmentBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
private class SetRawMainAttachmentParams(
	public val documentId: String,
	public val rev: String,
	public val utis: List<String>?,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
	public val encrypted: Boolean,
)

public fun setRawMainAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetRawMainAttachmentParams>(params)
	runBlocking {
		sdk.document.setRawMainAttachment(
			decodedParams.documentId,
			decodedParams.rev,
			decodedParams.utis,
			decodedParams.attachment,
			decodedParams.encrypted,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun setRawMainAttachmentAsync(
	sdk: CardinalApis,
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
	public val utis: List<String>?,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
	public val encrypted: Boolean,
)

public fun setRawSecondaryAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SetRawSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.setRawSecondaryAttachment(
			decodedParams.documentId,
			decodedParams.key,
			decodedParams.rev,
			decodedParams.utis,
			decodedParams.attachment,
			decodedParams.encrypted,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun setRawSecondaryAttachmentAsync(
	sdk: CardinalApis,
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

public fun deleteMainAttachmentBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun deleteSecondaryAttachmentBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val document: DecryptedDocument,
	public val options: DocumentShareOptions? = null,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.document.shareWith(
			decodedParams.delegateId,
			decodedParams.document,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: CardinalApis,
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
				decodedParams.options,
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

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
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
	sdk: CardinalApis,
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

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
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
	sdk: CardinalApis,
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

public fun findDocumentsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
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
	sdk: CardinalApis,
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
private class FilterDocumentsByParams(
	public val filter: FilterOptions<Document>,
)

public fun filterDocumentsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsByParams>(params)
	runBlocking {
		sdk.document.filterDocumentsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedDocument.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterDocumentsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.filterDocumentsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedDocument.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterDocumentsBySortedParams(
	public val filter: SortableFilterOptions<Document>,
)

public fun filterDocumentsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsBySortedParams>(params)
	runBlocking {
		sdk.document.filterDocumentsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedDocument.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterDocumentsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.filterDocumentsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DecryptedDocument.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentParams(
	public val entity: DecryptedDocument,
)

public fun modifyDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentParams>(params)
	runBlocking {
		sdk.document.modifyDocument(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyDocumentAsync(
	sdk: CardinalApis,
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

public fun getDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentParams>(params)
	runBlocking {
		sdk.document.getDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentAsync(
	sdk: CardinalApis,
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

public fun getDocumentByExternalUuidBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun getDocumentsByExternalUuidBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun getDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsParams>(params)
	runBlocking {
		sdk.document.getDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getDocumentsAsync(
	sdk: CardinalApis,
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

public fun modifyDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentsParams>(params)
	runBlocking {
		sdk.document.modifyDocuments(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyDocumentsAsync(
	sdk: CardinalApis,
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

public fun listDocumentsByHcPartyMessageForeignKeysBlocking(sdk: CardinalApis, params: String): String
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
	sdk: CardinalApis,
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

public fun findWithoutDelegationBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
