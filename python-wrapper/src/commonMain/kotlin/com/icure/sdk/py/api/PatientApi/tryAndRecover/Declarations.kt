// auto-generated file
package com.icure.sdk.py.api.PatientApi.tryAndRecover

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.PatientShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.couchdb.SortDirection
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
import kotlinx.serialization.builtins.serializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val patient: Patient,
	public val options: PatientShareOptions,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.patient,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(PatientSerializer))

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
			sdk.patient.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.patient,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val patient: Patient,
	public val delegates: Map<String, PatientShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.tryShareWithMany(
			decodedParams.patient,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(PatientSerializer))

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
			sdk.patient.tryAndRecover.tryShareWithMany(
				decodedParams.patient,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val patient: Patient,
	public val delegates: Map<String, PatientShareOptions>,
)

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.shareWithMany(
			decodedParams.patient,
			decodedParams.delegates,
		)
	}
}.toPyString(PatientSerializer)

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
			sdk.patient.tryAndRecover.shareWithMany(
				decodedParams.patient,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class InitializeConfidentialSecretIdParams(
	public val patient: Patient,
)

public fun initializeConfidentialSecretIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<InitializeConfidentialSecretIdParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.initializeConfidentialSecretId(
			decodedParams.patient,
		)
	}
}.toPyString(PatientSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun initializeConfidentialSecretIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<InitializeConfidentialSecretIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.initializeConfidentialSecretId(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsByParams(
	public val filter: FilterOptions<Patient>,
)

public fun filterPatientsByBlocking(sdk: IcureApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsByParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.filterPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, PatientSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterPatientsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.filterPatientsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, PatientSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsBySortedParams(
	public val filter: SortableFilterOptions<Patient>,
)

public fun filterPatientsBySortedBlocking(sdk: IcureApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.filterPatientsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, PatientSerializer)}

@OptIn(ExperimentalForeignApi::class)
public fun filterPatientsBySortedAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.filterPatientsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, PatientSerializer)}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientParams(
	public val entity: Patient,
)

public fun modifyPatientBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.modifyPatient(
			decodedParams.entity,
		)
	}
}.toPyString(PatientSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.modifyPatient(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientParams(
	public val entityId: String,
)

public fun getPatientBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatient(
			decodedParams.entityId,
		)
	}
}.toPyString(PatientSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatient(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientResolvingMergesParams(
	public val patientId: String,
	public val maxMergeDepth: Int?,
)

public fun getPatientResolvingMergesBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientResolvingMergesParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatientResolvingMerges(
			decodedParams.patientId,
			decodedParams.maxMergeDepth,
		)
	}
}.toPyString(PatientSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getPatientResolvingMergesAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientResolvingMergesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatientResolvingMerges(
				decodedParams.patientId,
				decodedParams.maxMergeDepth,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsByNameBirthSsinAutoParams(
	public val healthcarePartyId: String? = null,
	public val filterValue: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val sortDirection: SortDirection = com.icure.sdk.model.couchdb.SortDirection.Asc,
)

public fun findPatientsByNameBirthSsinAutoBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsByNameBirthSsinAutoParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findPatientsByNameBirthSsinAuto(
			decodedParams.healthcarePartyId,
			decodedParams.filterValue,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.sortDirection,
		)
	}
}.toPyString(PaginatedList.serializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsByNameBirthSsinAutoAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsByNameBirthSsinAutoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findPatientsByNameBirthSsinAuto(
				decodedParams.healthcarePartyId,
				decodedParams.filterValue,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.sortDirection,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListPatientsOfHcPartyParams(
	public val hcPartyId: String,
	public val sortField: String = "name",
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val sortDirection: SortDirection = com.icure.sdk.model.couchdb.SortDirection.Asc,
)

public fun listPatientsOfHcPartyBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListPatientsOfHcPartyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.listPatientsOfHcParty(
			decodedParams.hcPartyId,
			decodedParams.sortField,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.sortDirection,
		)
	}
}.toPyString(PaginatedList.serializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listPatientsOfHcPartyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListPatientsOfHcPartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.listPatientsOfHcParty(
				decodedParams.hcPartyId,
				decodedParams.sortField,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.sortDirection,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListOfMergesAfterParams(
	public val date: Long,
)

public fun listOfMergesAfterBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListOfMergesAfterParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.listOfMergesAfter(
			decodedParams.date,
		)
	}
}.toPyString(ListSerializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listOfMergesAfterAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListOfMergesAfterParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.listOfMergesAfter(
				decodedParams.date,
			)
		}.toPyStringAsyncCallback(ListSerializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsModifiedAfterParams(
	public val date: Long,
	public val startKey: Long? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findPatientsModifiedAfterBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsModifiedAfterParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findPatientsModifiedAfter(
			decodedParams.date,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsModifiedAfterAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsModifiedAfterParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findPatientsModifiedAfter(
				decodedParams.date,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListPatientsByHcPartyParams(
	public val hcPartyId: String,
	public val sortField: String = "name",
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val sortDirection: SortDirection = com.icure.sdk.model.couchdb.SortDirection.Asc,
)

public fun listPatientsByHcPartyBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListPatientsByHcPartyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.listPatientsByHcParty(
			decodedParams.hcPartyId,
			decodedParams.sortField,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.sortDirection,
		)
	}
}.toPyString(PaginatedList.serializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listPatientsByHcPartyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListPatientsByHcPartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.listPatientsByHcParty(
				decodedParams.hcPartyId,
				decodedParams.sortField,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.sortDirection,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsByHealthcarePartyParams(
	public val hcPartyId: String? = null,
	public val sortField: String = "name",
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val sortDirection: SortDirection = com.icure.sdk.model.couchdb.SortDirection.Asc,
)

public fun findPatientsByHealthcarePartyBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsByHealthcarePartyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findPatientsByHealthcareParty(
			decodedParams.hcPartyId,
			decodedParams.sortField,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.sortDirection,
		)
	}
}.toPyString(PaginatedList.serializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsByHealthcarePartyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsByHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findPatientsByHealthcareParty(
				decodedParams.hcPartyId,
				decodedParams.sortField,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.sortDirection,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsIdsByHealthcarePartyParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findPatientsIdsByHealthcarePartyBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsIdsByHealthcarePartyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findPatientsIdsByHealthcareParty(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsIdsByHealthcarePartyAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsIdsByHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findPatientsIdsByHealthcareParty(
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientByExternalIdParams(
	public val externalId: String,
)

public fun getPatientByExternalIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByExternalIdParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatientByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(PatientSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getPatientByExternalIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByExternalIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatientByExternalId(
				decodedParams.externalId,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FuzzySearchParams(
	public val firstName: String,
	public val lastName: String,
	public val dateOfBirth: Int? = null,
)

public fun fuzzySearchBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FuzzySearchParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.fuzzySearch(
			decodedParams.firstName,
			decodedParams.lastName,
			decodedParams.dateOfBirth,
		)
	}
}.toPyString(ListSerializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun fuzzySearchAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FuzzySearchParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.fuzzySearch(
				decodedParams.firstName,
				decodedParams.lastName,
				decodedParams.dateOfBirth,
			)
		}.toPyStringAsyncCallback(ListSerializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindDeletedPatientsParams(
	public val startDate: Long,
	public val endDate: Long? = null,
	public val desc: Boolean? = null,
	public val startKey: Long? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findDeletedPatientsBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDeletedPatientsParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findDeletedPatients(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.desc,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findDeletedPatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDeletedPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findDeletedPatients(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.desc,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDeletedPatientsByNameParams(
	public val firstName: String? = null,
	public val lastName: String? = null,
)

public fun listDeletedPatientsByNameBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDeletedPatientsByNameParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.listDeletedPatientsByName(
			decodedParams.firstName,
			decodedParams.lastName,
		)
	}
}.toPyString(ListSerializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun listDeletedPatientsByNameAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDeletedPatientsByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.listDeletedPatientsByName(
				decodedParams.firstName,
				decodedParams.lastName,
			)
		}.toPyStringAsyncCallback(ListSerializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientsParams(
	public val patientIds: List<String>,
)

public fun getPatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientsParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatients(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun getPatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatients(
				decodedParams.patientIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientByHealthcarePartyAndIdentifierParams(
	public val hcPartyId: String,
	public val id: String,
	public val system: String? = null,
)

public fun getPatientByHealthcarePartyAndIdentifierBlocking(sdk: IcureApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatientByHealthcarePartyAndIdentifier(
			decodedParams.hcPartyId,
			decodedParams.id,
			decodedParams.system,
		)
	}
}.toPyString(PatientSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun getPatientByHealthcarePartyAndIdentifierAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatientByHealthcarePartyAndIdentifier(
				decodedParams.hcPartyId,
				decodedParams.id,
				decodedParams.system,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientsParams(
	public val patientDtos: List<EncryptedPatient>,
)

public fun modifyPatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientsParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.modifyPatients(
			decodedParams.patientDtos,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.modifyPatients(
				decodedParams.patientDtos,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindDuplicatesBySsinParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findDuplicatesBySsinBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDuplicatesBySsinParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findDuplicatesBySsin(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findDuplicatesBySsinAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDuplicatesBySsinParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findDuplicatesBySsin(
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindDuplicatesByNameParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findDuplicatesByNameBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDuplicatesByNameParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findDuplicatesByName(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PatientSerializer))

@OptIn(ExperimentalForeignApi::class)
public fun findDuplicatesByNameAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDuplicatesByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findDuplicatesByName(
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PatientSerializer), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MergePatientsParams(
	@Serializable(PatientSerializer::class)
	public val from: Patient,
	public val mergedInto: Patient,
)

public fun mergePatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergePatientsParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.mergePatients(
			decodedParams.from,
			decodedParams.mergedInto,
		)
	}
}.toPyString(PatientSerializer)

@OptIn(ExperimentalForeignApi::class)
public fun mergePatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.mergePatients(
				decodedParams.from,
				decodedParams.mergedInto,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)