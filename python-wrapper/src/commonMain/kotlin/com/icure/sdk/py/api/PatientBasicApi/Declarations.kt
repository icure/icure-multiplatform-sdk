// auto-generated file
package com.icure.sdk.py.api.PatientBasicApi

import com.icure.sdk.IcureBaseApis
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.subscription.EntitySubscription.EntitySubscriptionWithSerializer
import com.icure.sdk.py.utils.PaginatedListIterator.PaginatedListIteratorAndSerializer
import com.icure.sdk.py.utils.PyResult
import com.icure.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.sdk.py.utils.toPyResult
import com.icure.sdk.py.utils.toPyResultAsyncCallback
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.py.utils.toPyStringAsyncCallback
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Byte
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
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
private class MatchPatientsByParams(
	public val filter: BaseFilterOptions<Patient>,
)

public fun matchPatientsByBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchPatientsByParams>(params)
	runBlocking {
		sdk.patient.matchPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchPatientsByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchPatientsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.matchPatientsBy(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchPatientsBySortedParams(
	public val filter: BaseSortableFilterOptions<Patient>,
)

public fun matchPatientsBySortedBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.matchPatientsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchPatientsBySortedAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchPatientsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.matchPatientsBySorted(
				decodedParams.filter,
			)
		}.toPyStringAsyncCallback(ListSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsByParams(
	public val filter: BaseFilterOptions<Patient>,
)

public fun filterPatientsByBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsByParams>(params)
	runBlocking {
		sdk.patient.filterPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedPatient.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterPatientsByAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.filterPatientsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedPatient.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsBySortedParams(
	public val filter: BaseSortableFilterOptions<Patient>,
)

public fun filterPatientsBySortedBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.filterPatientsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, EncryptedPatient.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterPatientsBySortedAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.filterPatientsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, EncryptedPatient.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeletePatientParams(
	public val entityId: String,
)

public fun deletePatientBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePatientParams>(params)
	runBlocking {
		sdk.patient.deletePatient(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deletePatientAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.deletePatient(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePatientsParams(
	public val entityIds: List<String>,
)

public fun deletePatientsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePatientsParams>(params)
	runBlocking {
		sdk.patient.deletePatients(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deletePatientsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.deletePatients(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeletePatientsParams(
	public val patientIds: List<String>,
)

public fun undeletePatientsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<UndeletePatientsParams>(params)
	runBlocking {
		sdk.patient.undeletePatients(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun undeletePatientsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UndeletePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.undeletePatients(
				decodedParams.patientIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDataOwnersWithAccessToParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun getDataOwnersWithAccessToBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDataOwnersWithAccessToParams>(params)
	runBlocking {
		sdk.patient.getDataOwnersWithAccessTo(
			decodedParams.patient,
		)
	}
}.toPyString(EntityAccessInformation.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getDataOwnersWithAccessToAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetDataOwnersWithAccessToParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getDataOwnersWithAccessTo(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(EntityAccessInformation.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CountOfPatientsParams(
	public val hcPartyId: String,
)

public fun countOfPatientsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CountOfPatientsParams>(params)
	runBlocking {
		sdk.patient.countOfPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun countOfPatientsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CountOfPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.countOfPatients(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(Int.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientParams(
	public val entity: EncryptedPatient,
)

public fun modifyPatientBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientParams>(params)
	runBlocking {
		sdk.patient.modifyPatient(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.modifyPatient(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientParams(
	public val entityId: String,
)

public fun getPatientBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientParams>(params)
	runBlocking {
		sdk.patient.getPatient(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getPatient(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(EncryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientResolvingMergesParams(
	public val patientId: String,
	public val maxMergeDepth: Int?,
)

public fun getPatientResolvingMergesBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientResolvingMergesParams>(params)
	runBlocking {
		sdk.patient.getPatientResolvingMerges(
			decodedParams.patientId,
			decodedParams.maxMergeDepth,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientResolvingMergesAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientResolvingMergesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getPatientResolvingMerges(
				decodedParams.patientId,
				decodedParams.maxMergeDepth,
			)
		}.toPyStringAsyncCallback(EncryptedPatient.serializer(), resultCallback)
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

public fun findPatientsByNameBirthSsinAutoBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsByNameBirthSsinAutoParams>(params)
	runBlocking {
		sdk.patient.findPatientsByNameBirthSsinAuto(
			decodedParams.healthcarePartyId,
			decodedParams.filterValue,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.sortDirection,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsByNameBirthSsinAutoAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsByNameBirthSsinAutoParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.findPatientsByNameBirthSsinAuto(
				decodedParams.healthcarePartyId,
				decodedParams.filterValue,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.sortDirection,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedPatient.serializer()), resultCallback)
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

public fun listPatientsOfHcPartyBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListPatientsOfHcPartyParams>(params)
	runBlocking {
		sdk.patient.listPatientsOfHcParty(
			decodedParams.hcPartyId,
			decodedParams.sortField,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.sortDirection,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listPatientsOfHcPartyAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListPatientsOfHcPartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.listPatientsOfHcParty(
				decodedParams.hcPartyId,
				decodedParams.sortField,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.sortDirection,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListOfMergesAfterParams(
	public val date: Long,
)

public fun listOfMergesAfterBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListOfMergesAfterParams>(params)
	runBlocking {
		sdk.patient.listOfMergesAfter(
			decodedParams.date,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listOfMergesAfterAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListOfMergesAfterParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.listOfMergesAfter(
				decodedParams.date,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsModifiedAfterParams(
	public val date: Long,
	public val startKey: Long? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findPatientsModifiedAfterBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsModifiedAfterParams>(params)
	runBlocking {
		sdk.patient.findPatientsModifiedAfter(
			decodedParams.date,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsModifiedAfterAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsModifiedAfterParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.findPatientsModifiedAfter(
				decodedParams.date,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedPatient.serializer()), resultCallback)
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

public fun listPatientsByHcPartyBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListPatientsByHcPartyParams>(params)
	runBlocking {
		sdk.patient.listPatientsByHcParty(
			decodedParams.hcPartyId,
			decodedParams.sortField,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.sortDirection,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listPatientsByHcPartyAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListPatientsByHcPartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.listPatientsByHcParty(
				decodedParams.hcPartyId,
				decodedParams.sortField,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.sortDirection,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedPatient.serializer()), resultCallback)
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

public fun findPatientsByHealthcarePartyBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsByHealthcarePartyParams>(params)
	runBlocking {
		sdk.patient.findPatientsByHealthcareParty(
			decodedParams.hcPartyId,
			decodedParams.sortField,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.sortDirection,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsByHealthcarePartyAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsByHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.findPatientsByHealthcareParty(
				decodedParams.hcPartyId,
				decodedParams.sortField,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.sortDirection,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsIdsByHealthcarePartyParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findPatientsIdsByHealthcarePartyBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsIdsByHealthcarePartyParams>(params)
	runBlocking {
		sdk.patient.findPatientsIdsByHealthcareParty(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsIdsByHealthcarePartyAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindPatientsIdsByHealthcarePartyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.findPatientsIdsByHealthcareParty(
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

public fun getPatientByExternalIdBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByExternalIdParams>(params)
	runBlocking {
		sdk.patient.getPatientByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientByExternalIdAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByExternalIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getPatientByExternalId(
				decodedParams.externalId,
			)
		}.toPyStringAsyncCallback(EncryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FuzzySearchParams(
	public val firstName: String,
	public val lastName: String,
	public val dateOfBirth: Int? = null,
)

public fun fuzzySearchBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FuzzySearchParams>(params)
	runBlocking {
		sdk.patient.fuzzySearch(
			decodedParams.firstName,
			decodedParams.lastName,
			decodedParams.dateOfBirth,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun fuzzySearchAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FuzzySearchParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.fuzzySearch(
				decodedParams.firstName,
				decodedParams.lastName,
				decodedParams.dateOfBirth,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedPatient.serializer()), resultCallback)
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

public fun findDeletedPatientsBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDeletedPatientsParams>(params)
	runBlocking {
		sdk.patient.findDeletedPatients(
			decodedParams.startDate,
			decodedParams.endDate,
			decodedParams.desc,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findDeletedPatientsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDeletedPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.findDeletedPatients(
				decodedParams.startDate,
				decodedParams.endDate,
				decodedParams.desc,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDeletedPatientsByNameParams(
	public val firstName: String? = null,
	public val lastName: String? = null,
)

public fun listDeletedPatientsByNameBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDeletedPatientsByNameParams>(params)
	runBlocking {
		sdk.patient.listDeletedPatientsByName(
			decodedParams.firstName,
			decodedParams.lastName,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listDeletedPatientsByNameAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDeletedPatientsByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.listDeletedPatientsByName(
				decodedParams.firstName,
				decodedParams.lastName,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientsParams(
	public val patientIds: List<String>,
)

public fun getPatientsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientsParams>(params)
	runBlocking {
		sdk.patient.getPatients(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getPatientsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getPatients(
				decodedParams.patientIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientByHealthcarePartyAndIdentifierParams(
	public val hcPartyId: String,
	public val id: String,
	public val system: String? = null,
)

public fun getPatientByHealthcarePartyAndIdentifierBlocking(sdk: IcureBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
	runBlocking {
		sdk.patient.getPatientByHealthcarePartyAndIdentifier(
			decodedParams.hcPartyId,
			decodedParams.id,
			decodedParams.system,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientByHealthcarePartyAndIdentifierAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getPatientByHealthcarePartyAndIdentifier(
				decodedParams.hcPartyId,
				decodedParams.id,
				decodedParams.system,
			)
		}.toPyStringAsyncCallback(EncryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientsParams(
	public val patientDtos: List<EncryptedPatient>,
)

public fun modifyPatientsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientsParams>(params)
	runBlocking {
		sdk.patient.modifyPatients(
			decodedParams.patientDtos,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.modifyPatients(
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

public fun findDuplicatesBySsinBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDuplicatesBySsinParams>(params)
	runBlocking {
		sdk.patient.findDuplicatesBySsin(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findDuplicatesBySsinAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDuplicatesBySsinParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.findDuplicatesBySsin(
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindDuplicatesByNameParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findDuplicatesByNameBlocking(sdk: IcureBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDuplicatesByNameParams>(params)
	runBlocking {
		sdk.patient.findDuplicatesByName(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findDuplicatesByNameAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FindDuplicatesByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.findDuplicatesByName(
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MergePatientsParams(
	@Serializable(PatientSerializer::class)
	public val from: Patient,
	public val mergedInto: EncryptedPatient,
)

public fun mergePatientsBlocking(sdk: IcureBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergePatientsParams>(params)
	runBlocking {
		sdk.patient.mergePatients(
			decodedParams.from,
			decodedParams.mergedInto,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun mergePatientsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.mergePatients(
				decodedParams.from,
				decodedParams.mergedInto,
			)
		}.toPyStringAsyncCallback(EncryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: BaseFilterOptions<Patient>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: IcureBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.patient.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedPatient.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun subscribeToEventsAsync(
	sdk: IcureBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<SubscribeToEventsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.subscribeToEvents(
				decodedParams.events,
				decodedParams.filter,
				decodedParams.subscriptionConfig,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			EntitySubscriptionWithSerializer(it, EncryptedPatient.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)
