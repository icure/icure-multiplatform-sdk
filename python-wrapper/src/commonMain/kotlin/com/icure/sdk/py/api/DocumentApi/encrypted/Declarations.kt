// auto-generated file
package com.icure.sdk.py.api.DocumentApi.encrypted

import com.icure.sdk.CardinalApis
import com.icure.sdk.crypto.entities.DocumentShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Document
import com.icure.sdk.model.EncryptedDocument
import com.icure.sdk.model.Patient
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.utils.Serialization.json
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

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.document.encrypted.shareWith(
			decodedParams.delegateId,
			decodedParams.document,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedDocument.serializer()))

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
			sdk.document.encrypted.shareWith(
				decodedParams.delegateId,
				decodedParams.document,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedDocument.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val document: EncryptedDocument,
	public val delegates: Map<String, DocumentShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.document.encrypted.tryShareWithMany(
			decodedParams.document,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(EncryptedDocument.serializer()))

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
			sdk.document.encrypted.tryShareWithMany(
				decodedParams.document,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(EncryptedDocument.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val document: EncryptedDocument,
	public val delegates: Map<String, DocumentShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.document.encrypted.shareWithMany(
			decodedParams.document,
			decodedParams.delegates,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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

@OptIn(ExperimentalForeignApi::class)
public fun findDocumentsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDocumentsByHcPartyPatientParams>(params)
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

public fun filterDocumentsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsByParams>(params)
	runBlocking {
		sdk.document.encrypted.filterDocumentsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedDocument.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterDocumentsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsByParams>(params)
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

public fun filterDocumentsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsBySortedParams>(params)
	runBlocking {
		sdk.document.encrypted.filterDocumentsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedDocument.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterDocumentsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsBySortedParams>(params)
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
private class ModifyDocumentParams(
	public val entity: EncryptedDocument,
)

public fun modifyDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentParams>(params)
	runBlocking {
		sdk.document.encrypted.modifyDocument(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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

public fun getDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentParams>(params)
	runBlocking {
		sdk.document.encrypted.getDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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

public fun getDocumentByExternalUuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentByExternalUuidParams>(params)
	runBlocking {
		sdk.document.encrypted.getDocumentByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(EncryptedDocument.serializer())

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

public fun getDocumentsByExternalUuidBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsByExternalUuidParams>(params)
	runBlocking {
		sdk.document.encrypted.getDocumentsByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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

public fun getDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsParams>(params)
	runBlocking {
		sdk.document.encrypted.getDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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

public fun modifyDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentsParams>(params)
	runBlocking {
		sdk.document.encrypted.modifyDocuments(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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

public fun listDocumentsByHcPartyMessageForeignKeysBlocking(sdk: CardinalApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDocumentsByHcPartyMessageForeignKeysParams>(params)
	runBlocking {
		sdk.document.encrypted.listDocumentsByHcPartyMessageForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.documentTypeCode,
			decodedParams.secretMessageKeys,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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

public fun findWithoutDelegationBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindWithoutDelegationParams>(params)
	runBlocking {
		sdk.document.encrypted.findWithoutDelegation(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(EncryptedDocument.serializer()))

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
			sdk.document.encrypted.findWithoutDelegation(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedDocument.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
