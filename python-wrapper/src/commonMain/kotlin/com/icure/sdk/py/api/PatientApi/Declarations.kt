// auto-generated file
package com.icure.sdk.py.api.PatientApi

import com.icure.sdk.CardinalApis
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.PatientShareOptions
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.py.serialization.EntityWithTypeInfoAsStubDeserializer
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
import kotlin.collections.Map
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
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class GetSecretIdsOfParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun getSecretIdsOfBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetSecretIdsOfParams>(params)
	runBlocking {
		sdk.patient.getSecretIdsOf(
			decodedParams.patient,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getSecretIdsOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetSecretIdsOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getSecretIdsOf(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetEncryptionKeysOfParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun getEncryptionKeysOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetEncryptionKeysOfParams>(params)
	runBlocking {
		sdk.patient.getEncryptionKeysOf(
			decodedParams.patient,
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
			sdk.patient.getEncryptionKeysOf(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(SetSerializer(HexString.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreatePatientParams(
	public val patient: DecryptedPatient,
)

public fun createPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreatePatientParams>(params)
	runBlocking {
		sdk.patient.createPatient(
			decodedParams.patient,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreatePatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.createPatient(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class WithEncryptionMetadataParams(
	public val base: DecryptedPatient?,
	public val user: User? = null,
	public val delegates: Map<String, AccessLevel> = emptyMap(),
)

public fun withEncryptionMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<WithEncryptionMetadataParams>(params)
	runBlocking {
		sdk.patient.withEncryptionMetadata(
			decodedParams.base,
			decodedParams.user,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedPatient.serializer())

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
			sdk.patient.withEncryptionMetadata(
				decodedParams.base,
				decodedParams.user,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun hasWriteAccessBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.patient.hasWriteAccess(
			decodedParams.patient,
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
			sdk.patient.hasWriteAccess(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	@Serializable(PatientSerializer::class)
	public val entity: Patient,
	public val delegates: Set<String>,
)

public fun createDelegationDeAnonymizationMetadataBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.patient.createDelegationDeAnonymizationMetadata(
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
			sdk.patient.createDelegationDeAnonymizationMetadata(
				decodedParams.entity,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class DecryptParams(
	public val patient: EncryptedPatient,
)

public fun decryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptParams>(params)
	runBlocking {
		sdk.patient.decrypt(
			decodedParams.patient,
		)
	}
}.toPyString(DecryptedPatient.serializer())

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
			sdk.patient.decrypt(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryDecryptParams(
	public val patient: EncryptedPatient,
)

public fun tryDecryptBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryDecryptParams>(params)
	runBlocking {
		sdk.patient.tryDecrypt(
			decodedParams.patient,
		)
	}
}.toPyString(PatientSerializer)

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
			sdk.patient.tryDecrypt(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(PatientSerializer, resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreatePatientsParams(
	public val patientDtos: List<DecryptedPatient>,
)

public fun createPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreatePatientsParams>(params)
	runBlocking {
		sdk.patient.createPatients(
			decodedParams.patientDtos,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun createPatientsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreatePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.createPatients(
				decodedParams.patientDtos,
			)
		}.toPyStringAsyncCallback(ListSerializer(IdWithRev.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareAllDataOfPatientParams(
	public val patientId: String,
	public val delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>,
)

public fun shareAllDataOfPatientBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareAllDataOfPatientParams>(params)
	runBlocking {
		sdk.patient.shareAllDataOfPatient(
			decodedParams.patientId,
			decodedParams.delegatesWithShareType,
		)
	}
}.toPyString(ShareAllPatientDataOptions.Result.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun shareAllDataOfPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareAllDataOfPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.shareAllDataOfPatient(
				decodedParams.patientId,
				decodedParams.delegatesWithShareType,
			)
		}.toPyStringAsyncCallback(ShareAllPatientDataOptions.Result.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientIdOfChildDocumentForHcpAndHcpParentsParams(
	@Serializable(EntityWithTypeInfoAsStubDeserializer::class)
	public val childDocument: EntityWithTypeInfo<*>,
)

public fun getPatientIdOfChildDocumentForHcpAndHcpParentsBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<GetPatientIdOfChildDocumentForHcpAndHcpParentsParams>(params)
	runBlocking {
		sdk.patient.getPatientIdOfChildDocumentForHcpAndHcpParents(
			decodedParams.childDocument,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientIdOfChildDocumentForHcpAndHcpParentsAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<GetPatientIdOfChildDocumentForHcpAndHcpParentsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getPatientIdOfChildDocumentForHcpAndHcpParents(
				decodedParams.childDocument,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetConfidentialSecretIdsOfParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun getConfidentialSecretIdsOfBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetConfidentialSecretIdsOfParams>(params)
	runBlocking {
		sdk.patient.getConfidentialSecretIdsOf(
			decodedParams.patient,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getConfidentialSecretIdsOfAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetConfidentialSecretIdsOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getConfidentialSecretIdsOf(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ForceInitializeExchangeDataToNewlyInvitedPatientParams(
	public val patientId: String,
)

public fun forceInitializeExchangeDataToNewlyInvitedPatientBlocking(sdk: CardinalApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ForceInitializeExchangeDataToNewlyInvitedPatientParams>(params)
	runBlocking {
		sdk.patient.forceInitializeExchangeDataToNewlyInvitedPatient(
			decodedParams.patientId,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun forceInitializeExchangeDataToNewlyInvitedPatientAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ForceInitializeExchangeDataToNewlyInvitedPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.forceInitializeExchangeDataToNewlyInvitedPatient(
				decodedParams.patientId,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchPatientsByParams(
	public val filter: FilterOptions<Patient>,
)

public fun matchPatientsByBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchPatientsByParams>(params)
	runBlocking {
		sdk.patient.matchPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchPatientsByAsync(
	sdk: CardinalApis,
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
	public val filter: SortableFilterOptions<Patient>,
)

public fun matchPatientsBySortedBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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
private class DeletePatientParams(
	public val entityId: String,
)

public fun deletePatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePatientParams>(params)
	runBlocking {
		sdk.patient.deletePatient(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deletePatientAsync(
	sdk: CardinalApis,
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

public fun deletePatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePatientsParams>(params)
	runBlocking {
		sdk.patient.deletePatients(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deletePatientsAsync(
	sdk: CardinalApis,
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

public fun undeletePatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UndeletePatientsParams>(params)
	runBlocking {
		sdk.patient.undeletePatients(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun undeletePatientsAsync(
	sdk: CardinalApis,
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

public fun getDataOwnersWithAccessToBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun countOfPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CountOfPatientsParams>(params)
	runBlocking {
		sdk.patient.countOfPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(Int.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun countOfPatientsAsync(
	sdk: CardinalApis,
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
private class ShareWithParams(
	public val delegateId: String,
	public val patient: DecryptedPatient,
	public val options: PatientShareOptions,
)

public fun shareWithBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.patient.shareWith(
			decodedParams.delegateId,
			decodedParams.patient,
			decodedParams.options,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedPatient.serializer()))

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
			sdk.patient.shareWith(
				decodedParams.delegateId,
				decodedParams.patient,
				decodedParams.options,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedPatient.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class TryShareWithManyParams(
	public val patient: DecryptedPatient,
	public val delegates: Map<String, PatientShareOptions>,
)

public fun tryShareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<TryShareWithManyParams>(params)
	runBlocking {
		sdk.patient.tryShareWithMany(
			decodedParams.patient,
			decodedParams.delegates,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedPatient.serializer()))

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
			sdk.patient.tryShareWithMany(
				decodedParams.patient,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(SimpleShareResult.serializer(DecryptedPatient.serializer()),
				resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareWithManyParams(
	public val patient: DecryptedPatient,
	public val delegates: Map<String, PatientShareOptions>,
)

public fun shareWithManyBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithManyParams>(params)
	runBlocking {
		sdk.patient.shareWithMany(
			decodedParams.patient,
			decodedParams.delegates,
		)
	}
}.toPyString(DecryptedPatient.serializer())

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
			sdk.patient.shareWithMany(
				decodedParams.patient,
				decodedParams.delegates,
			)
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class InitializeConfidentialSecretIdParams(
	public val patient: DecryptedPatient,
)

public fun initializeConfidentialSecretIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<InitializeConfidentialSecretIdParams>(params)
	runBlocking {
		sdk.patient.initializeConfidentialSecretId(
			decodedParams.patient,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun initializeConfidentialSecretIdAsync(
	sdk: CardinalApis,
	params: String,
	resultCallback: CPointer<CFunction<(CValues<ByteVarOf<Byte>>?,
			CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<InitializeConfidentialSecretIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.initializeConfidentialSecretId(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsByParams(
	public val filter: FilterOptions<Patient>,
)

public fun filterPatientsByBlocking(sdk: CardinalApis, params: String): PyResult = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsByParams>(params)
	runBlocking {
		sdk.patient.filterPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedPatient.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterPatientsByAsync(
	sdk: CardinalApis,
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
			PaginatedListIteratorAndSerializer(it, DecryptedPatient.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class FilterPatientsBySortedParams(
	public val filter: SortableFilterOptions<Patient>,
)

public fun filterPatientsBySortedBlocking(sdk: CardinalApis, params: String): PyResult =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsBySortedParams>(params)
	runBlocking {
		sdk.patient.filterPatientsBySorted(
			decodedParams.filter,
		)
	}
}.toPyResult {
	PaginatedListIteratorAndSerializer(it, DecryptedPatient.serializer())}

@OptIn(ExperimentalForeignApi::class)
public fun filterPatientsBySortedAsync(
	sdk: CardinalApis,
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
			PaginatedListIteratorAndSerializer(it, DecryptedPatient.serializer())}
	}
}.failureToPyResultAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientParams(
	public val entity: DecryptedPatient,
)

public fun modifyPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientParams>(params)
	runBlocking {
		sdk.patient.modifyPatient(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientParams(
	public val entityId: String,
)

public fun getPatientBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientParams>(params)
	runBlocking {
		sdk.patient.getPatient(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientResolvingMergesParams(
	public val patientId: String,
	public val maxMergeDepth: Int?,
)

public fun getPatientResolvingMergesBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientResolvingMergesParams>(params)
	runBlocking {
		sdk.patient.getPatientResolvingMerges(
			decodedParams.patientId,
			decodedParams.maxMergeDepth,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientResolvingMergesAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
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

public fun findPatientsByNameBirthSsinAutoBlocking(sdk: CardinalApis, params: String): String =
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
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsByNameBirthSsinAutoAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
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

public fun listPatientsOfHcPartyBlocking(sdk: CardinalApis, params: String): String =
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
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listPatientsOfHcPartyAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListOfMergesAfterParams(
	public val date: Long,
)

public fun listOfMergesAfterBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListOfMergesAfterParams>(params)
	runBlocking {
		sdk.patient.listOfMergesAfter(
			decodedParams.date,
		)
	}
}.toPyString(ListSerializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listOfMergesAfterAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsModifiedAfterParams(
	public val date: Long,
	public val startKey: Long? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findPatientsModifiedAfterBlocking(sdk: CardinalApis, params: String): String =
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
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsModifiedAfterAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
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

public fun listPatientsByHcPartyBlocking(sdk: CardinalApis, params: String): String =
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
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listPatientsByHcPartyAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
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

public fun findPatientsByHealthcarePartyBlocking(sdk: CardinalApis, params: String): String =
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
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findPatientsByHealthcarePartyAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindPatientsIdsByHealthcarePartyParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findPatientsIdsByHealthcarePartyBlocking(sdk: CardinalApis, params: String): String =
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
	sdk: CardinalApis,
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

public fun getPatientByExternalIdBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByExternalIdParams>(params)
	runBlocking {
		sdk.patient.getPatientByExternalId(
			decodedParams.externalId,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientByExternalIdAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FuzzySearchParams(
	public val firstName: String,
	public val lastName: String,
	public val dateOfBirth: Int? = null,
)

public fun fuzzySearchBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FuzzySearchParams>(params)
	runBlocking {
		sdk.patient.fuzzySearch(
			decodedParams.firstName,
			decodedParams.lastName,
			decodedParams.dateOfBirth,
		)
	}
}.toPyString(ListSerializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun fuzzySearchAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedPatient.serializer()), resultCallback)
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

public fun findDeletedPatientsBlocking(sdk: CardinalApis, params: String): String =
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
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findDeletedPatientsAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ListDeletedPatientsByNameParams(
	public val firstName: String? = null,
	public val lastName: String? = null,
)

public fun listDeletedPatientsByNameBlocking(sdk: CardinalApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListDeletedPatientsByNameParams>(params)
	runBlocking {
		sdk.patient.listDeletedPatientsByName(
			decodedParams.firstName,
			decodedParams.lastName,
		)
	}
}.toPyString(ListSerializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listDeletedPatientsByNameAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientsParams(
	public val patientIds: List<String>,
)

public fun getPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientsParams>(params)
	runBlocking {
		sdk.patient.getPatients(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getPatientsAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(ListSerializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientByHealthcarePartyAndIdentifierParams(
	public val hcPartyId: String,
	public val id: String,
	public val system: String? = null,
)

public fun getPatientByHealthcarePartyAndIdentifierBlocking(sdk: CardinalApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientByHealthcarePartyAndIdentifierParams>(params)
	runBlocking {
		sdk.patient.getPatientByHealthcarePartyAndIdentifier(
			decodedParams.hcPartyId,
			decodedParams.id,
			decodedParams.system,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientByHealthcarePartyAndIdentifierAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientsParams(
	public val patientDtos: List<EncryptedPatient>,
)

public fun modifyPatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientsParams>(params)
	runBlocking {
		sdk.patient.modifyPatients(
			decodedParams.patientDtos,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientsAsync(
	sdk: CardinalApis,
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

public fun findDuplicatesBySsinBlocking(sdk: CardinalApis, params: String): String =
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
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findDuplicatesBySsinAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class FindDuplicatesByNameParams(
	public val hcPartyId: String,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
)

public fun findDuplicatesByNameBlocking(sdk: CardinalApis, params: String): String =
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
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun findDuplicatesByNameAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MergePatientsParams(
	@Serializable(PatientSerializer::class)
	public val from: Patient,
	public val mergedInto: DecryptedPatient,
)

public fun mergePatientsBlocking(sdk: CardinalApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergePatientsParams>(params)
	runBlocking {
		sdk.patient.mergePatients(
			decodedParams.from,
			decodedParams.mergedInto,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun mergePatientsAsync(
	sdk: CardinalApis,
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
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class SubscribeToEventsParams(
	public val events: Set<SubscriptionEventType>,
	public val filter: FilterOptions<Patient>,
	public val subscriptionConfig: EntitySubscriptionConfiguration? = null,
)

public fun subscribeToEventsBlocking(sdk: CardinalApis, params: String): PyResult =
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
	sdk: CardinalApis,
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
