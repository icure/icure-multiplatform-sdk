// auto-generated file
package com.icure.cardinal.sdk.py.api.DocumentApi.encrypted

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.EncryptedDocument
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
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
private class ShareWithParams(
	public val delegateId: String,
	public val document: EncryptedDocument,
	public val options: DocumentShareOptions? = null,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.document.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.document,
			decodedParams.options,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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
			sdk.document.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.document,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val document: EncryptedDocument,
	public val delegates: Map<String, DocumentShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.document.encrypted.shareWithMany(
			decodedParams.document,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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
			sdk.document.encrypted.shareWithMany(
				decodedParams.document,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
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
		sdk.document.encrypted.findDocumentsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedDocument.serializer())}

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
			sdk.document.encrypted.findDocumentsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedDocument.serializer())}
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
		sdk.document.encrypted.filterDocumentsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedDocument.serializer())}

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
			sdk.document.encrypted.filterDocumentsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedDocument.serializer())}
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
		sdk.document.encrypted.filterDocumentsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedDocument.serializer())}

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
			sdk.document.encrypted.filterDocumentsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedDocument.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class UndeleteDocumentByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeleteDocumentByIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteDocumentByIdParams>(params)
	runBlocking {
		sdk.document.encrypted.undeleteDocumentById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteDocumentByIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteDocumentByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.encrypted.undeleteDocumentById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeleteDocumentParams(
	public val document: Document,
)

@OptIn(InternalIcureApi::class)
public fun undeleteDocumentBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteDocumentParams>(params)
	runBlocking {
		sdk.document.encrypted.undeleteDocument(
			decodedParams.document,
		)
	}
}.toPyString(EncryptedDocument.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeleteDocumentAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeleteDocumentParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.encrypted.undeleteDocument(
				decodedParams.document,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentParams(
	public val entity: EncryptedDocument,
)

@OptIn(InternalIcureApi::class)
public fun modifyDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDocumentParams>(params)
	runBlocking {
		sdk.document.encrypted.modifyDocument(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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
			sdk.document.encrypted.modifyDocument(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
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
		sdk.document.encrypted.getDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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
			sdk.document.encrypted.getDocument(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
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
		sdk.document.encrypted.getDocumentByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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
			sdk.document.encrypted.getDocumentByExternalUuid(
				decodedParams.externalUuid,
			)
		}.toPyStringAsyncCallback(EncryptedDocument.serializer(), resultCallback)
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
		sdk.document.encrypted.getDocumentsByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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
			sdk.document.encrypted.getDocumentsByExternalUuid(
				decodedParams.externalUuid,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
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
		sdk.document.encrypted.getDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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
			sdk.document.encrypted.getDocuments(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentsParams(
	public val entities: List<EncryptedDocument>,
)

@OptIn(InternalIcureApi::class)
public fun modifyDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyDocumentsParams>(params)
	runBlocking {
		sdk.document.encrypted.modifyDocuments(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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
			sdk.document.encrypted.modifyDocuments(
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

@OptIn(InternalIcureApi::class)
public fun listDocumentsByHcPartyMessageForeignKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDocumentsByHcPartyMessageForeignKeysParams>(params)
	runBlocking {
		sdk.document.encrypted.listDocumentsByHcPartyMessageForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.documentTypeCode,
			decodedParams.secretMessageKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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
			sdk.document.encrypted.listDocumentsByHcPartyMessageForeignKeys(
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

@OptIn(InternalIcureApi::class)
public fun findWithoutDelegationBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindWithoutDelegationParams>(params)
	runBlocking {
		sdk.document.encrypted.findWithoutDelegation(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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
			sdk.document.encrypted.findWithoutDelegation(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
