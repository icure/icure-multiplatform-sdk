// auto-generated file
package com.icure.cardinal.sdk.py.api.DocumentApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.DocumentShareOptions
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.py.serialization.DocumentSerializer
import com.icure.cardinal.sdk.py.serialization.PatientSerializer
import com.icure.cardinal.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.utils.Serialization.json
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
	public val document: Document,
	public val options: DocumentShareOptions? = null,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.document.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.document,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(DocumentSerializer))

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
			sdk.document.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.document,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DocumentSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val document: Document,
	public val delegates: Map<String, DocumentShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.document.tryAndRecover.tryShareWithMany(
			decodedParams.document,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DocumentSerializer))

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
			sdk.document.tryAndRecover.tryShareWithMany(
				decodedParams.document,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DocumentSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val document: Document,
	public val delegates: Map<String, DocumentShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.document.tryAndRecover.shareWithMany(
			decodedParams.document,
			decodedParams.delegates,
		)
	}
}.toPyString(DocumentSerializer)

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
			sdk.document.tryAndRecover.shareWithMany(
				decodedParams.document,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DocumentSerializer, resultCallback)
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
		sdk.document.tryAndRecover.findDocumentsByHcPartyPatient(
			decodedParams.hcPartyId,
			decodedParams.patient,
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.descending,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DocumentSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun findDocumentsByHcPartyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDocumentsByHcPartyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.tryAndRecover.findDocumentsByHcPartyPatient(
				decodedParams.hcPartyId,
				decodedParams.patient,
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.descending,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DocumentSerializer)}
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
		sdk.document.tryAndRecover.filterDocumentsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DocumentSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterDocumentsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.tryAndRecover.filterDocumentsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DocumentSerializer)}
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
		sdk.document.tryAndRecover.filterDocumentsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DocumentSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterDocumentsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterDocumentsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.document.tryAndRecover.filterDocumentsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, DocumentSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentParams(
	public val entity: Document,
)

public fun modifyDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentParams>(params)
	runBlocking {
		sdk.document.tryAndRecover.modifyDocument(
			decodedParams.entity,
		)
	}
}.toPyString(DocumentSerializer)

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
			sdk.document.tryAndRecover.modifyDocument(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(DocumentSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentParams(
	public val entityId: String,
)

public fun getDocumentBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentParams>(params)
	runBlocking {
		sdk.document.tryAndRecover.getDocument(
			decodedParams.entityId,
		)
	}
}.toPyString(DocumentSerializer)

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
			sdk.document.tryAndRecover.getDocument(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocumentSerializer, resultCallback)
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
		sdk.document.tryAndRecover.getDocumentByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(DocumentSerializer)

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
			sdk.document.tryAndRecover.getDocumentByExternalUuid(
				decodedParams.externalUuid,
			)
		}.toPyStringAsyncCallback(DocumentSerializer, resultCallback)
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
		sdk.document.tryAndRecover.getDocumentsByExternalUuid(
			decodedParams.externalUuid,
		)
	}
}.toPyString(ListSerializer(DocumentSerializer))

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
			sdk.document.tryAndRecover.getDocumentsByExternalUuid(
				decodedParams.externalUuid,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocumentSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDocumentsParams(
	public val entityIds: List<String>,
)

public fun getDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDocumentsParams>(params)
	runBlocking {
		sdk.document.tryAndRecover.getDocuments(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocumentSerializer))

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
			sdk.document.tryAndRecover.getDocuments(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocumentSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyDocumentsParams(
	public val entities: List<Document>,
)

public fun modifyDocumentsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyDocumentsParams>(params)
	runBlocking {
		sdk.document.tryAndRecover.modifyDocuments(
			decodedParams.entities,
		)
	}
}.toPyString(ListSerializer(DocumentSerializer))

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
			sdk.document.tryAndRecover.modifyDocuments(
				decodedParams.entities,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocumentSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDocumentsByHcPartyMessageForeignKeysParams(
	public val hcPartyId: String,
	public val documentTypeCode: String?,
	public val secretMessageKeys: List<String>,
)

public fun listDocumentsByHcPartyMessageForeignKeysBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDocumentsByHcPartyMessageForeignKeysParams>(params)
	runBlocking {
		sdk.document.tryAndRecover.listDocumentsByHcPartyMessageForeignKeys(
			decodedParams.hcPartyId,
			decodedParams.documentTypeCode,
			decodedParams.secretMessageKeys,
		)
	}
}.toPyString(ListSerializer(DocumentSerializer))

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
			sdk.document.tryAndRecover.listDocumentsByHcPartyMessageForeignKeys(
				decodedParams.hcPartyId,
				decodedParams.documentTypeCode,
				decodedParams.secretMessageKeys,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocumentSerializer), resultCallback)
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
		sdk.document.tryAndRecover.findWithoutDelegation(
			decodedParams.limit,
		)
	}
}.toPyString(ListSerializer(DocumentSerializer))

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
			sdk.document.tryAndRecover.findWithoutDelegation(
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocumentSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
