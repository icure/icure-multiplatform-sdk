// auto-generated file
package com.icure.cardinal.sdk.py.api.PatientApi.tryAndRecover

import com.icure.cardinal.sdk.CardinalApis
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.SimpleShareResult
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.couchdb.SortDirection
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
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class ShareWithParams(
	public val delegateId: String,
	public val patient: Patient,
	public val options: PatientShareOptions,
)

@OptIn(InternalIcureApi::class)
public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.shareWith(
			decodedParams.delegateId,
			decodedParams.patient,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(PolymorphicSerializer(Patient::class)))

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
			sdk.patient.tryAndRecover.shareWith(
				decodedParams.delegateId,
				decodedParams.patient,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val patient: Patient,
	public val delegates: Map<String, PatientShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.tryShareWithMany(
			decodedParams.patient,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun tryShareWithManyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<TryShareWithManyParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.tryShareWithMany(
				decodedParams.patient,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val patient: Patient,
	public val delegates: Map<String, PatientShareOptions>,
)

@OptIn(InternalIcureApi::class)
public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.shareWithMany(
			decodedParams.patient,
			decodedParams.delegates,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

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
			sdk.patient.tryAndRecover.shareWithMany(
				decodedParams.patient,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class InitializeConfidentialSecretIdParams(
	public val patient: Patient,
)

@OptIn(InternalIcureApi::class)
public fun initializeConfidentialSecretIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<InitializeConfidentialSecretIdParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.initializeConfidentialSecretId(
			decodedParams.patient,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun initializeConfidentialSecretIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<InitializeConfidentialSecretIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.initializeConfidentialSecretId(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsByParams(
	public val filter: FilterOptions<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun filterPatientsByBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsByParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.filterPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Patient::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterPatientsByAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.filterPatientsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Patient::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsBySortedParams(
	public val filter: SortableFilterOptions<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun filterPatientsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.filterPatientsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Patient::class))}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterPatientsBySortedAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.filterPatientsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorAndSerializer(it, PolymorphicSerializer(Patient::class))}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientParams(
	public val entity: Patient,
)

@OptIn(InternalIcureApi::class)
public fun modifyPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.modifyPatient(
			decodedParams.entity,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.modifyPatient(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatient(
			decodedParams.entityId,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatient(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientResolvingMergesParams(
	public val patientId: String,
	public val maxMergeDepth: Int?,
)

@OptIn(InternalIcureApi::class)
public fun getPatientResolvingMergesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientResolvingMergesParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatientResolvingMerges(
			decodedParams.patientId,
			decodedParams.maxMergeDepth,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientResolvingMergesAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientResolvingMergesParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatientResolvingMerges(
				decodedParams.patientId,
				decodedParams.maxMergeDepth,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsByNameBirthSsinAutoParams(
	public val healthcarePartyId: String? = null,
	public val filterValue: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val sortDirection: SortDirection = com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc,
)

@OptIn(InternalIcureApi::class)
public fun findPatientsByNameBirthSsinAutoBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsByNameBirthSsinAutoParams>(params)
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
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findPatientsByNameBirthSsinAutoAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsByNameBirthSsinAutoParams>(params)
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListPatientsOfHcPartyParams(
	public val hcPartyId: String,
	public val sortField: String = "name",
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val sortDirection: SortDirection = com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc,
)

@OptIn(InternalIcureApi::class)
public fun listPatientsOfHcPartyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListPatientsOfHcPartyParams>(params)
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
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listPatientsOfHcPartyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListPatientsOfHcPartyParams>(params)
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListOfMergesAfterParams(
	public val date: Long,
)

@OptIn(InternalIcureApi::class)
public fun listOfMergesAfterBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListOfMergesAfterParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.listOfMergesAfter(
			decodedParams.date,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listOfMergesAfterAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListOfMergesAfterParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.listOfMergesAfter(
				decodedParams.date,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Patient::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsModifiedAfterParams(
	public val date: Long,
	public val startKey: Long? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findPatientsModifiedAfterBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsModifiedAfterParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findPatientsModifiedAfter(
			decodedParams.date,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findPatientsModifiedAfterAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsModifiedAfterParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findPatientsModifiedAfter(
				decodedParams.date,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListPatientsByHcPartyParams(
	public val hcPartyId: String,
	public val sortField: String = "name",
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val sortDirection: SortDirection = com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc,
)

@OptIn(InternalIcureApi::class)
public fun listPatientsByHcPartyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListPatientsByHcPartyParams>(params)
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
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listPatientsByHcPartyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListPatientsByHcPartyParams>(params)
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsByHealthcarePartyParams(
	public val hcPartyId: String? = null,
	public val sortField: String = "name",
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val sortDirection: SortDirection = com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc,
)

@OptIn(InternalIcureApi::class)
public fun findPatientsByHealthcarePartyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsByHealthcarePartyParams>(params)
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
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findPatientsByHealthcarePartyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsByHealthcarePartyParams>(params)
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsIdsByHealthcarePartyParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findPatientsIdsByHealthcarePartyBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsIdsByHealthcarePartyParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findPatientsIdsByHealthcareParty(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findPatientsIdsByHealthcarePartyAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsIdsByHealthcarePartyParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getPatientByExternalIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientByExternalIdParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatientByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientByExternalIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientByExternalIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatientByExternalId(
				decodedParams.externalId,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FuzzySearchParams(
	public val firstName: String,
	public val lastName: String,
	public val dateOfBirth: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun fuzzySearchBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FuzzySearchParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.fuzzySearch(
			decodedParams.firstName,
			decodedParams.lastName,
			decodedParams.dateOfBirth,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun fuzzySearchAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FuzzySearchParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.fuzzySearch(
				decodedParams.firstName,
				decodedParams.lastName,
				decodedParams.dateOfBirth,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Patient::class)), resultCallback)
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

@OptIn(InternalIcureApi::class)
public fun findDeletedPatientsBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDeletedPatientsParams>(params)
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
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findDeletedPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDeletedPatientsParams>(params)
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDeletedPatientsByNameParams(
	public val firstName: String? = null,
	public val lastName: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun listDeletedPatientsByNameBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDeletedPatientsByNameParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.listDeletedPatientsByName(
			decodedParams.firstName,
			decodedParams.lastName,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listDeletedPatientsByNameAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDeletedPatientsByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.listDeletedPatientsByName(
				decodedParams.firstName,
				decodedParams.lastName,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Patient::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientsParams(
	public val patientIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun getPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientsParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatients(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatients(
				decodedParams.patientIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(PolymorphicSerializer(Patient::class)), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientByHealthcarePartyAndIdentifierParams(
	public val hcPartyId: String,
	public val id: String,
	public val system: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun getPatientByHealthcarePartyAndIdentifierBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.getPatientByHealthcarePartyAndIdentifier(
			decodedParams.hcPartyId,
			decodedParams.id,
			decodedParams.system,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientByHealthcarePartyAndIdentifierAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.getPatientByHealthcarePartyAndIdentifier(
				decodedParams.hcPartyId,
				decodedParams.id,
				decodedParams.system,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientsParams(
	public val patientDtos: List<EncryptedPatient>,
)

@OptIn(InternalIcureApi::class)
public fun modifyPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientsParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.modifyPatients(
			decodedParams.patientDtos,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findDuplicatesBySsinBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDuplicatesBySsinParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findDuplicatesBySsin(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findDuplicatesBySsinAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDuplicatesBySsinParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findDuplicatesBySsin(
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindDuplicatesByNameParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

@OptIn(InternalIcureApi::class)
public fun findDuplicatesByNameBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDuplicatesByNameParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.findDuplicatesByName(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(PolymorphicSerializer(Patient::class)))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findDuplicatesByNameAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDuplicatesByNameParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.findDuplicatesByName(
				decodedParams.hcPartyId,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(PolymorphicSerializer(Patient::class)),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MergePatientsParams(
	public val from: Patient,
	public val mergedInto: Patient,
)

@OptIn(InternalIcureApi::class)
public fun mergePatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MergePatientsParams>(params)
	runBlocking {
		sdk.patient.tryAndRecover.mergePatients(
			decodedParams.from,
			decodedParams.mergedInto,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun mergePatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MergePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.tryAndRecover.mergePatients(
				decodedParams.from,
				decodedParams.mergedInto,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
