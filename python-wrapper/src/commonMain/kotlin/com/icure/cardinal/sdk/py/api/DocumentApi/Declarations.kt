// auto-generated file
package com.icure.cardinal.sdk.py.api.DocumentApi

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.DecryptedDocument
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyCallbackResultHolder
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.serialization.ByteArraySerializer
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
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
import kotlinx.serialization.PolymorphicSerializer
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

@OptIn(InternalIcureApi::class)
public fun createDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDocumentParams>(params)
	runBlocking {
		sdk.document.createDocument(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDocumentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CreateDocumentParams>(params)
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
	public val message: Message?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
	public val secretId: SecretIdUseOption =
			com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent,
)

@OptIn(InternalIcureApi::class)
public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun withEncryptionMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithEncryptionMetadataParams>(params)
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
	public val document: Document,
)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndTryDecryptMainAttachmentBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndTryDecryptMainAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndTryDecryptMainAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndTryDecryptMainAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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
	public val document: Document,
)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndTryDecryptMainAttachmentAsPlainTextBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndTryDecryptMainAttachmentAsPlainTextParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndTryDecryptMainAttachmentAsPlainTextAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndTryDecryptMainAttachmentAsPlainTextParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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
	public val document: Document,
)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndTryDecryptMainAttachmentAsJsonBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndTryDecryptMainAttachmentAsJsonParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndTryDecryptMainAttachmentAsJsonAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndTryDecryptMainAttachmentAsJsonParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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
	public val document: Document,
)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndDecryptMainAttachmentBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndDecryptMainAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndDecryptMainAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndDecryptMainAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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
	public val document: Document,
	public val utis: List<String>?,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun encryptAndSetMainAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<EncryptAndSetMainAttachmentParams>(params)
	runBlocking {
		sdk.document.encryptAndSetMainAttachment(
			decodedParams.document,
			decodedParams.utis,
			decodedParams.attachment,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun encryptAndSetMainAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<EncryptAndSetMainAttachmentParams>(params)
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
	public val document: Document,
	public val key: String,
)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndDecryptSecondaryAttachmentBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndDecryptSecondaryAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getAndDecryptSecondaryAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetAndDecryptSecondaryAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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
	public val document: Document,
	public val key: String,
	public val utis: List<String>?,
	@Serializable(ByteArraySerializer::class)
	public val attachment: ByteArray,
)

@OptIn(InternalIcureApi::class)
public fun encryptAndSetSecondaryAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<EncryptAndSetSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.encryptAndSetSecondaryAttachment(
			decodedParams.document,
			decodedParams.key,
			decodedParams.utis,
			decodedParams.attachment,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun encryptAndSetSecondaryAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<EncryptAndSetSecondaryAttachmentParams>(params)
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
	public val document: Document,
)

@OptIn(InternalIcureApi::class)
public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.document.getEncryptionKeysOf(
			decodedParams.document,
		)
	}
}.toPyString(SetSerializer(HexString.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getEncryptionKeysOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetEncryptionKeysOfParams>(params)
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
	public val document: Document,
)

@OptIn(InternalIcureApi::class)
public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.document.hasWriteAccess(
			decodedParams.document,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun hasWriteAccessAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<HasWriteAccessParams>(params)
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
	public val document: Document,
)

@OptIn(InternalIcureApi::class)
public fun decryptPatientIdOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.document.decryptPatientIdOf(
			decodedParams.document,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptPatientIdOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptPatientIdOfParams>(params)
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
	public val entity: Document,
	public val delegates: Set<String>,
)

@OptIn(InternalIcureApi::class)
public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.document.createDelegationDeAnonymizationMetadata(
			decodedParams.entity,
			decodedParams.delegates,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun createDelegationDeAnonymizationMetadataAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.document.decrypt(
			decodedParams.document,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun decryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DecryptParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.document.tryDecrypt(
			decodedParams.document,
		)
	}
}.toPyString(PolymorphicSerializer(Document::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryDecryptAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.tryDecrypt(
				decodedParams.document,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Document::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptAttachmentParams(
	public val document: Document,
	@Serializable(ByteArraySerializer::class)
	public val encryptedAttachment: ByteArray,
)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryDecryptAttachmentBlocking(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryDecryptAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	decryptedAttachmentValidator: CPointer<CFunction<(COpaquePointer,
			CValues<ByteVarOf<Byte>>) -> Unit>>?,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryDecryptAttachmentParams>(params)
	val decryptedAttachmentValidatorConverted: (suspend (ByteArray) -> Boolean)? = if (decryptedAttachmentValidator != null) {
		{ x0 ->
			val jsonParams = JsonArray(listOf(
				fullLanguageInteropJson.encodeToJsonElement(ByteArraySerializer, x0),
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

@OptIn(InternalIcureApi::class)
public fun matchDocumentsByBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchDocumentsByParams>(params)
	runBlocking {
		sdk.document.matchDocumentsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchDocumentsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchDocumentsByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun matchDocumentsBySortedBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchDocumentsBySortedParams>(params)
	runBlocking {
		sdk.document.matchDocumentsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchDocumentsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchDocumentsBySortedParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDocumentParams>(params)
	runBlocking {
		sdk.document.deleteDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteDocumentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDocumentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDocumentsParams>(params)
	runBlocking {
		sdk.document.deleteDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteDocumentsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteDocumentsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getRawMainAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRawMainAttachmentParams>(params)
	runBlocking {
		sdk.document.getRawMainAttachment(
			decodedParams.documentId,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRawMainAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetRawMainAttachmentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getMainAttachmentAsPlainTextBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetMainAttachmentAsPlainTextParams>(params)
	runBlocking {
		sdk.document.getMainAttachmentAsPlainText(
			decodedParams.documentId,
		)
	}
}.toPyString(String.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMainAttachmentAsPlainTextAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetMainAttachmentAsPlainTextParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getMainAttachmentAsJsonBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMainAttachmentAsJsonParams>(params)
	runBlocking {
		sdk.document.getMainAttachmentAsJson(
			decodedParams.documentId,
		)
	}
}.toPyString(JsonElement.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getMainAttachmentAsJsonAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetMainAttachmentAsJsonParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getRawSecondaryAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetRawSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.getRawSecondaryAttachment(
			decodedParams.documentId,
			decodedParams.key,
		)
	}
}.toPyString(ByteArraySerializer)

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getRawSecondaryAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetRawSecondaryAttachmentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun setRawMainAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetRawMainAttachmentParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setRawMainAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SetRawMainAttachmentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun setRawSecondaryAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SetRawSecondaryAttachmentParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun setRawSecondaryAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<SetRawSecondaryAttachmentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteMainAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMainAttachmentParams>(params)
	runBlocking {
		sdk.document.deleteMainAttachment(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteMainAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeleteMainAttachmentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun deleteSecondaryAttachmentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteSecondaryAttachmentParams>(params)
	runBlocking {
		sdk.document.deleteSecondaryAttachment(
			decodedParams.documentId,
			decodedParams.key,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deleteSecondaryAttachmentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<DeleteSecondaryAttachmentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.document.shareWith(
			decodedParams.delegateId,
			decodedParams.document,
			decodedParams.options,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.shareWith(
				decodedParams.delegateId,
				decodedParams.document,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(DecryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val document: DecryptedDocument,
	public val delegates: Map<String, DocumentShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.document.shareWithMany(
			decodedParams.document,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun shareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
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
	public val patient: Patient,
	public val startDate: Long? = null,
	public val endDate: Long? = null,
	public val descending: Boolean? = null,
)

@OptIn(InternalIcureApi::class)
public fun findDocumentsByHcPartyPatientBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindDocumentsByHcPartyPatientParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findDocumentsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindDocumentsByHcPartyPatientParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun filterDocumentsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterDocumentsByParams>(params)
	runBlocking {
		sdk.document.filterDocumentsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedDocument.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterDocumentsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterDocumentsByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun filterDocumentsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterDocumentsBySortedParams>(params)
	runBlocking {
		sdk.document.filterDocumentsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedDocument.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterDocumentsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterDocumentsBySortedParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDocumentParams>(params)
	runBlocking {
		sdk.document.modifyDocument(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyDocumentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDocumentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDocumentParams>(params)
	runBlocking {
		sdk.document.getDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDocumentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDocumentParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getDocumentByExternalUuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDocumentByExternalUuidParams>(params)
	runBlocking {
		sdk.document.getDocumentByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(DecryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDocumentByExternalUuidAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDocumentByExternalUuidParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getDocumentsByExternalUuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDocumentsByExternalUuidParams>(params)
	runBlocking {
		sdk.document.getDocumentsByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDocumentsByExternalUuidAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDocumentsByExternalUuidParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDocumentsParams>(params)
	runBlocking {
		sdk.document.getDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDocumentsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetDocumentsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDocumentsParams>(params)
	runBlocking {
		sdk.document.modifyDocuments(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyDocumentsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDocumentsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listDocumentsByHcPartyMessageForeignKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentsByHcPartyMessageForeignKeysParams>(params)
	runBlocking {
		sdk.document.listDocumentsByHcPartyMessageForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.documentTypeCode,
			decodedParams.secretMessageKeys,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listDocumentsByHcPartyMessageForeignKeysAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentsByHcPartyMessageForeignKeysParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findWithoutDelegationBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindWithoutDelegationParams>(params)
	runBlocking {
		sdk.document.findWithoutDelegation(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(DecryptedDocument.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findWithoutDelegationAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindWithoutDelegationParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.findWithoutDelegation(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(DecryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
