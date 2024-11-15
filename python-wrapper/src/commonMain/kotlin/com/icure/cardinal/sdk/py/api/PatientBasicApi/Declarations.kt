// auto-generated file
package com.icure.cardinal.sdk.py.api.PatientBasicApi

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.entities.EntityAccessInformation
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.SortDirection
import com.icure.cardinal.sdk.serialization.EntitySubscriptionWithSerializer
import com.icure.cardinal.sdk.serialization.PaginatedListIteratorWithSerializer
import com.icure.cardinal.sdk.py.utils.PyResult
import com.icure.cardinal.sdk.py.utils.failureToPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.failureToPyStringAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyResult
import com.icure.cardinal.sdk.py.utils.toPyResultAsyncCallback
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.py.utils.toPyStringAsyncCallback
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
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
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class MatchPatientsByParams(
	public val filter: BaseFilterOptions<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun matchPatientsByBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchPatientsByParams>(params)
	runBlocking {
		sdk.patient.matchPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchPatientsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchPatientsByParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun matchPatientsBySortedBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.matchPatientsBySorted(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun matchPatientsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MatchPatientsBySortedParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun filterPatientsByBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsByParams>(params)
	runBlocking {
		sdk.patient.filterPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedPatient.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterPatientsByAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.filterPatientsBy(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedPatient.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsBySortedParams(
	public val filter: BaseSortableFilterOptions<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun filterPatientsBySortedBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.filterPatientsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorWithSerializer(it, EncryptedPatient.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun filterPatientsBySortedAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FilterPatientsBySortedParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.filterPatientsBySorted(
				decodedParams.filter,
			)
		}.toPyResultAsyncCallback(resultCallback) {
			PaginatedListIteratorWithSerializer(it, EncryptedPatient.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class DeletePatientUnsafeParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun deletePatientUnsafeBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientUnsafeParams>(params)
	runBlocking {
		sdk.patient.deletePatientUnsafe(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePatientUnsafeAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.deletePatientUnsafe(
				decodedParams.entityId,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePatientsUnsafeParams(
	public val entityIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun deletePatientsUnsafeBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientsUnsafeParams>(params)
	runBlocking {
		sdk.patient.deletePatientsUnsafe(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePatientsUnsafeAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientsUnsafeParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.deletePatientsUnsafe(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePatientByIdParams(
	public val entityId: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun deletePatientByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientByIdParams>(params)
	runBlocking {
		sdk.patient.deletePatientById(
			decodedParams.entityId,
			decodedParams.rev,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePatientByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.deletePatientById(
				decodedParams.entityId,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePatientsByIdsParams(
	public val entityIds: List<IdWithMandatoryRev>,
)

@OptIn(InternalIcureApi::class)
public fun deletePatientsByIdsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientsByIdsParams>(params)
	runBlocking {
		sdk.patient.deletePatientsByIds(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePatientsByIdsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientsByIdsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.deletePatientsByIds(
				decodedParams.entityIds,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgePatientByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun purgePatientByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePatientByIdParams>(params)
	runBlocking {
		sdk.patient.purgePatientById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgePatientByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePatientByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.purgePatientById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePatientParams(
	public val patient: Patient,
)

@OptIn(InternalIcureApi::class)
public fun deletePatientBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientParams>(params)
	runBlocking {
		sdk.patient.deletePatient(
			decodedParams.patient,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePatientAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.deletePatient(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(DocIdentifier.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DeletePatientsParams(
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun deletePatientsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientsParams>(params)
	runBlocking {
		sdk.patient.deletePatients(
			decodedParams.patients,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun deletePatientsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<DeletePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.deletePatients(
				decodedParams.patients,
			)
		}.toPyStringAsyncCallback(ListSerializer(DocIdentifier.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class PurgePatientParams(
	public val patient: Patient,
)

@OptIn(InternalIcureApi::class)
public fun purgePatientBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePatientParams>(params)
	runBlocking {
		sdk.patient.purgePatient(
			decodedParams.patient,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun purgePatientAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<PurgePatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.purgePatient(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetDataOwnersWithAccessToParams(
	public val patient: Patient,
)

@OptIn(InternalIcureApi::class)
public fun getDataOwnersWithAccessToBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDataOwnersWithAccessToParams>(params)
	runBlocking {
		sdk.patient.getDataOwnersWithAccessTo(
			decodedParams.patient,
		)
	}
}.toPyString(EntityAccessInformation.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getDataOwnersWithAccessToAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetDataOwnersWithAccessToParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun countOfPatientsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CountOfPatientsParams>(params)
	runBlocking {
		sdk.patient.countOfPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun countOfPatientsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<CountOfPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.countOfPatients(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(Int.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeletePatientParams(
	public val patient: Patient,
)

@OptIn(InternalIcureApi::class)
public fun undeletePatientBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePatientParams>(params)
	runBlocking {
		sdk.patient.undeletePatient(
			decodedParams.patient,
		)
	}
}.toPyString(PolymorphicSerializer(Patient::class))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeletePatientAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.undeletePatient(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(PolymorphicSerializer(Patient::class), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientParams(
	public val entity: EncryptedPatient,
)

@OptIn(InternalIcureApi::class)
public fun modifyPatientBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientParams>(params)
	runBlocking {
		sdk.patient.modifyPatient(
			decodedParams.entity,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPatientAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.modifyPatient(
				decodedParams.entity,
			)
		}.toPyStringAsyncCallback(EncryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeletePatientByIdParams(
	public val id: String,
	public val rev: String,
)

@OptIn(InternalIcureApi::class)
public fun undeletePatientByIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePatientByIdParams>(params)
	runBlocking {
		sdk.patient.undeletePatientById(
			decodedParams.id,
			decodedParams.rev,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeletePatientByIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePatientByIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.undeletePatientById(
				decodedParams.id,
				decodedParams.rev,
			)
		}.toPyStringAsyncCallback(EncryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class UndeletePatientsParams(
	public val ids: List<IdWithMandatoryRev>,
)

@OptIn(InternalIcureApi::class)
public fun undeletePatientsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePatientsParams>(params)
	runBlocking {
		sdk.patient.undeletePatients(
			decodedParams.ids,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun undeletePatientsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<UndeletePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.undeletePatients(
				decodedParams.ids,
			)
		}.toPyStringAsyncCallback(ListSerializer(EncryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientParams(
	public val entityId: String,
)

@OptIn(InternalIcureApi::class)
public fun getPatientBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientParams>(params)
	runBlocking {
		sdk.patient.getPatient(
			decodedParams.entityId,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getPatientResolvingMergesBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientResolvingMergesParams>(params)
	runBlocking {
		sdk.patient.getPatientResolvingMerges(
			decodedParams.patientId,
			decodedParams.maxMergeDepth,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientResolvingMergesAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientResolvingMergesParams>(params)
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
	public val sortDirection: SortDirection = com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc,
)

@OptIn(InternalIcureApi::class)
public fun findPatientsByNameBirthSsinAutoBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsByNameBirthSsinAutoParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findPatientsByNameBirthSsinAutoAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsByNameBirthSsinAutoParams>(params)
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
	public val sortDirection: SortDirection = com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc,
)

@OptIn(InternalIcureApi::class)
public fun listPatientsOfHcPartyBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListPatientsOfHcPartyParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listPatientsOfHcPartyAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListPatientsOfHcPartyParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listOfMergesAfterBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListOfMergesAfterParams>(params)
	runBlocking {
		sdk.patient.listOfMergesAfter(
			decodedParams.date,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listOfMergesAfterAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListOfMergesAfterParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findPatientsModifiedAfterBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsModifiedAfterParams>(params)
	runBlocking {
		sdk.patient.findPatientsModifiedAfter(
			decodedParams.date,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findPatientsModifiedAfterAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsModifiedAfterParams>(params)
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
	public val sortDirection: SortDirection = com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc,
)

@OptIn(InternalIcureApi::class)
public fun listPatientsByHcPartyBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListPatientsByHcPartyParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listPatientsByHcPartyAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ListPatientsByHcPartyParams>(params)
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
	public val sortDirection: SortDirection = com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc,
)

@OptIn(InternalIcureApi::class)
public fun findPatientsByHealthcarePartyBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsByHealthcarePartyParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findPatientsByHealthcarePartyAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsByHealthcarePartyParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findPatientsIdsByHealthcarePartyBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsIdsByHealthcarePartyParams>(params)
	runBlocking {
		sdk.patient.findPatientsIdsByHealthcareParty(
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
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<FindPatientsIdsByHealthcarePartyParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getPatientByExternalIdBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientByExternalIdParams>(params)
	runBlocking {
		sdk.patient.getPatientByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientByExternalIdAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientByExternalIdParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun fuzzySearchBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FuzzySearchParams>(params)
	runBlocking {
		sdk.patient.fuzzySearch(
			decodedParams.firstName,
			decodedParams.lastName,
			decodedParams.dateOfBirth,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun fuzzySearchAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FuzzySearchParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findDeletedPatientsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDeletedPatientsParams>(params)
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

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findDeletedPatientsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDeletedPatientsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun listDeletedPatientsByNameBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDeletedPatientsByNameParams>(params)
	runBlocking {
		sdk.patient.listDeletedPatientsByName(
			decodedParams.firstName,
			decodedParams.lastName,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun listDeletedPatientsByNameAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ListDeletedPatientsByNameParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getPatientsBlocking(sdk: CardinalBaseApis, params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientsParams>(params)
	runBlocking {
		sdk.patient.getPatients(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(EncryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<GetPatientsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun getPatientByHealthcarePartyAndIdentifierBlocking(sdk: CardinalBaseApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
	runBlocking {
		sdk.patient.getPatientByHealthcarePartyAndIdentifier(
			decodedParams.hcPartyId,
			decodedParams.id,
			decodedParams.system,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun getPatientByHealthcarePartyAndIdentifierAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun modifyPatientsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientsParams>(params)
	runBlocking {
		sdk.patient.modifyPatients(
			decodedParams.patientDtos,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun modifyPatientsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ModifyPatientsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findDuplicatesBySsinBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDuplicatesBySsinParams>(params)
	runBlocking {
		sdk.patient.findDuplicatesBySsin(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findDuplicatesBySsinAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDuplicatesBySsinParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun findDuplicatesByNameBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDuplicatesByNameParams>(params)
	runBlocking {
		sdk.patient.findDuplicatesByName(
			decodedParams.hcPartyId,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
		)
	}
}.toPyString(PaginatedList.serializer(EncryptedPatient.serializer()))

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun findDuplicatesByNameAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<FindDuplicatesByNameParams>(params)
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
	public val from: Patient,
	public val mergedInto: EncryptedPatient,
)

@OptIn(InternalIcureApi::class)
public fun mergePatientsBlocking(sdk: CardinalBaseApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MergePatientsParams>(params)
	runBlocking {
		sdk.patient.mergePatients(
			decodedParams.from,
			decodedParams.mergedInto,
		)
	}
}.toPyString(EncryptedPatient.serializer())

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun mergePatientsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<MergePatientsParams>(params)
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

@OptIn(InternalIcureApi::class)
public fun subscribeToEventsBlocking(sdk: CardinalBaseApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
	runBlocking {
		sdk.patient.subscribeToEvents(
			decodedParams.events,
			decodedParams.filter,
			decodedParams.subscriptionConfig,
		)
	}
}.toPyResult {
	EntitySubscriptionWithSerializer(it, EncryptedPatient.serializer())}

@OptIn(
	ExperimentalForeignApi::class,
	InternalIcureApi::class,
)
public fun subscribeToEventsAsync(
	sdk: CardinalBaseApis,
	params: String,
	resultCallback: CPointer<CFunction<(COpaquePointer?, CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<SubscribeToEventsParams>(params)
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
