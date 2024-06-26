// auto-generated file
package com.icure.sdk.py.api.flavoured.PatientApi

import com.icure.sdk.IcureApis
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.PatientShareOptions
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.EncryptedContent
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.py.serialization.EntityWithTypeInfoAsStubDeserializer
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.utils.failureToPyStringAsyncCallback
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
import kotlin.collections.Set
import kotlinx.cinterop.ByteVarOf
import kotlinx.cinterop.CFunction
import kotlinx.cinterop.CPointer
import kotlinx.cinterop.CValues
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.SetSerializer
import kotlinx.serialization.builtins.serializer

@Serializable
private class GetSecretIdsOfParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun getSecretIdsOfBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetSecretIdsOfParams>(params)
	runBlocking {
		sdk.patient.getSecretIdsOf(
			decodedParams.patient,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getSecretIdsOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun getEncryptionKeysOfBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun createPatientBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreatePatientParams>(params)
	runBlocking {
		sdk.patient.createPatient(
			decodedParams.patient,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun withEncryptionMetadataBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class CreateDelegationsDeAnonymizationMetadataParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
	public val dataOwnerIds: Set<String>,
)

public fun createDelegationsDeAnonymizationMetadataBlocking(sdk: IcureApis, params: String): String
		= kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationsDeAnonymizationMetadataParams>(params)
	runBlocking {
		sdk.patient.createDelegationsDeAnonymizationMetadata(
			decodedParams.patient,
			decodedParams.dataOwnerIds,
		)
	}
}.toPyString(Unit.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun createDelegationsDeAnonymizationMetadataAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreateDelegationsDeAnonymizationMetadataParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.createDelegationsDeAnonymizationMetadata(
				decodedParams.patient,
				decodedParams.dataOwnerIds,
			)
		}.toPyStringAsyncCallback(Unit.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class HasWriteAccessParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun hasWriteAccessBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<HasWriteAccessParams>(params)
	runBlocking {
		sdk.patient.hasWriteAccess(
			decodedParams.patient,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun hasWriteAccessAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class DecryptPatientIdOfParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun decryptPatientIdOfBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	runBlocking {
		sdk.patient.decryptPatientIdOf(
			decodedParams.patient,
		)
	}
}.toPyString(SetSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun decryptPatientIdOfAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DecryptPatientIdOfParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.decryptPatientIdOf(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(SetSerializer(String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CreateDelegationDeAnonymizationMetadataParams(
	@Serializable(PatientSerializer::class)
	public val entity: Patient,
	public val delegates: Set<String>,
)

public fun createDelegationDeAnonymizationMetadataBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class CreatePatientsParams(
	public val patientDtos: List<DecryptedPatient>,
)

public fun createPatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CreatePatientsParams>(params)
	runBlocking {
		sdk.patient.createPatients(
			decodedParams.patientDtos,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun createPatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class RegisterPatientParams(
	public val hcPartyId: String,
	public val groupId: String,
	public val token: String?,
	public val useShortToken: Boolean?,
	public val createAutoDelegation: Boolean,
	public val patient: DecryptedPatient,
)

public fun registerPatientBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RegisterPatientParams>(params)
	runBlocking {
		sdk.patient.registerPatient(
			decodedParams.hcPartyId,
			decodedParams.groupId,
			decodedParams.token,
			decodedParams.useShortToken,
			decodedParams.createAutoDelegation,
			decodedParams.patient,
		)
	}
}.toPyString(DataOwnerRegistrationSuccess.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun registerPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<RegisterPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.registerPatient(
				decodedParams.hcPartyId,
				decodedParams.groupId,
				decodedParams.token,
				decodedParams.useShortToken,
				decodedParams.createAutoDelegation,
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(DataOwnerRegistrationSuccess.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ShareAllDataOfPatientParams(
	public val user: User,
	public val patientId: String,
	public val dataOwnerId: String,
	public val delegatesWithShareType: Map<String, Set<ShareAllPatientDataOptions.Tag>>,
)

public fun shareAllDataOfPatientBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareAllDataOfPatientParams>(params)
	runBlocking {
		sdk.patient.shareAllDataOfPatient(
			decodedParams.user,
			decodedParams.patientId,
			decodedParams.dataOwnerId,
			decodedParams.delegatesWithShareType,
		)
	}
}.toPyString(ShareAllPatientDataOptions.Result.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun shareAllDataOfPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareAllDataOfPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.shareAllDataOfPatient(
				decodedParams.user,
				decodedParams.patientId,
				decodedParams.dataOwnerId,
				decodedParams.delegatesWithShareType,
			)
		}.toPyStringAsyncCallback(ShareAllPatientDataOptions.Result.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetPatientIdOfChildDocumentForHcpAndHcpParentsParams(
	@Serializable(EntityWithTypeInfoAsStubDeserializer::class)
	public val childDocument: EntityWithTypeInfo<*>,
	public val healthcarePartyId: String,
)

public fun getPatientIdOfChildDocumentForHcpAndHcpParentsBlocking(sdk: IcureApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<GetPatientIdOfChildDocumentForHcpAndHcpParentsParams>(params)
	runBlocking {
		sdk.patient.getPatientIdOfChildDocumentForHcpAndHcpParents(
			decodedParams.childDocument,
			decodedParams.healthcarePartyId,
		)
	}
}.toPyString(String.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientIdOfChildDocumentForHcpAndHcpParentsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<GetPatientIdOfChildDocumentForHcpAndHcpParentsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getPatientIdOfChildDocumentForHcpAndHcpParents(
				decodedParams.childDocument,
				decodedParams.healthcarePartyId,
			)
		}.toPyStringAsyncCallback(String.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class GetConfidentialSecretIdsOfParams(
	@Serializable(PatientSerializer::class)
	public val patient: Patient,
)

public fun getConfidentialSecretIdsOfBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class ForceInitialiseExchangeDataToNewlyInvitedPatientParams(
	public val patientId: String,
)

public fun forceInitialiseExchangeDataToNewlyInvitedPatientBlocking(sdk: IcureApis, params: String):
		String = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ForceInitialiseExchangeDataToNewlyInvitedPatientParams>(params)
	runBlocking {
		sdk.patient.forceInitialiseExchangeDataToNewlyInvitedPatient(
			decodedParams.patientId,
		)
	}
}.toPyString(Boolean.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun forceInitialiseExchangeDataToNewlyInvitedPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ForceInitialiseExchangeDataToNewlyInvitedPatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.forceInitialiseExchangeDataToNewlyInvitedPatient(
				decodedParams.patientId,
			)
		}.toPyStringAsyncCallback(Boolean.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class MatchPatientsByParams(
	public val filter: AbstractFilter<Patient>,
)

public fun matchPatientsByBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MatchPatientsByParams>(params)
	runBlocking {
		sdk.patient.matchPatientsBy(
			decodedParams.filter,
		)
	}
}.toPyString(ListSerializer(String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun matchPatientsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class DeletePatientParams(
	public val entityId: String,
)

public fun deletePatientBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePatientParams>(params)
	runBlocking {
		sdk.patient.deletePatient(
			decodedParams.entityId,
		)
	}
}.toPyString(DocIdentifier.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun deletePatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun deletePatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<DeletePatientsParams>(params)
	runBlocking {
		sdk.patient.deletePatients(
			decodedParams.entityIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun deletePatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class UndeletePatientParams(
	public val patientIds: String,
)

public fun undeletePatientBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UndeletePatientParams>(params)
	runBlocking {
		sdk.patient.undeletePatient(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(DocIdentifier.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun undeletePatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<UndeletePatientParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.undeletePatient(
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

public fun getDataOwnersWithAccessToBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class ShareWithParams(
	public val delegateId: String,
	public val patient: DecryptedPatient,
	public val shareSecretIds: Set<String>,
	public val shareEncryptionKeys: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val shareOwningEntityIds: ShareMetadataBehaviour =
			com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable,
	public val requestedPermission: RequestedPermission =
			com.icure.sdk.model.requests.RequestedPermission.MaxWrite,
)

public fun shareWithBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	runBlocking {
		sdk.patient.shareWith(
			decodedParams.delegateId,
			decodedParams.patient,
			decodedParams.shareSecretIds,
			decodedParams.shareEncryptionKeys,
			decodedParams.shareOwningEntityIds,
			decodedParams.requestedPermission,
		)
	}
}.toPyString(SimpleShareResult.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun shareWithAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ShareWithParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.shareWith(
				decodedParams.delegateId,
				decodedParams.patient,
				decodedParams.shareSecretIds,
				decodedParams.shareEncryptionKeys,
				decodedParams.shareOwningEntityIds,
				decodedParams.requestedPermission,
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

public fun tryShareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun shareWithManyBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class InitialiseConfidentialSecretIdParams(
	public val patient: DecryptedPatient,
)

public fun initialiseConfidentialSecretIdBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<InitialiseConfidentialSecretIdParams>(params)
	runBlocking {
		sdk.patient.initialiseConfidentialSecretId(
			decodedParams.patient,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun initialiseConfidentialSecretIdAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<InitialiseConfidentialSecretIdParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.initialiseConfidentialSecretId(
				decodedParams.patient,
			)
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class ModifyPatientParams(
	public val entity: DecryptedPatient,
)

public fun modifyPatientBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientParams>(params)
	runBlocking {
		sdk.patient.modifyPatient(
			decodedParams.entity,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun getPatientBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientParams>(params)
	runBlocking {
		sdk.patient.getPatient(
			decodedParams.entityId,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun getPatientAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class FilterPatientsByParams(
	public val filterChain: FilterChain<Patient>,
	public val startKey: String? = null,
	public val startDocumentId: String? = null,
	public val limit: Int? = null,
	public val skip: Int? = null,
	public val sort: String? = null,
	public val desc: Boolean? = null,
)

public fun filterPatientsByBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsByParams>(params)
	runBlocking {
		sdk.patient.filterPatientsBy(
			decodedParams.filterChain,
			decodedParams.startKey,
			decodedParams.startDocumentId,
			decodedParams.limit,
			decodedParams.skip,
			decodedParams.sort,
			decodedParams.desc,
		)
	}
}.toPyString(PaginatedList.serializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun filterPatientsByAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FilterPatientsByParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.filterPatientsBy(
				decodedParams.filterChain,
				decodedParams.startKey,
				decodedParams.startDocumentId,
				decodedParams.limit,
				decodedParams.skip,
				decodedParams.sort,
				decodedParams.desc,
			)
		}.toPyStringAsyncCallback(PaginatedList.serializer(DecryptedPatient.serializer()), resultCallback)
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun listPatientsOfHcPartyBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun listOfMergesAfterBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ListOfMergesAfterParams>(params)
	runBlocking {
		sdk.patient.listOfMergesAfter(
			decodedParams.date,
		)
	}
}.toPyString(ListSerializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun listOfMergesAfterAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun findPatientsModifiedAfterBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun listPatientsByHcPartyBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class GetPatientHcPartyKeysForDelegateParams(
	public val patientId: String,
)

public fun getPatientHcPartyKeysForDelegateBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientHcPartyKeysForDelegateParams>(params)
	runBlocking {
		sdk.patient.getPatientHcPartyKeysForDelegate(
			decodedParams.patientId,
		)
	}
}.toPyString(MapSerializer(String.serializer(), String.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getPatientHcPartyKeysForDelegateAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientHcPartyKeysForDelegateParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.getPatientHcPartyKeysForDelegate(
				decodedParams.patientId,
			)
		}.toPyStringAsyncCallback(MapSerializer(String.serializer(), String.serializer()), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)

@Serializable
private class CountOfPatientsParams(
	public val hcPartyId: String,
)

public fun countOfPatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CountOfPatientsParams>(params)
	runBlocking {
		sdk.patient.countOfPatients(
			decodedParams.hcPartyId,
		)
	}
}.toPyString(EncryptedContent.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun countOfPatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<CountOfPatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.countOfPatients(
				decodedParams.hcPartyId,
			)
		}.toPyStringAsyncCallback(EncryptedContent.serializer(), resultCallback)
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun findPatientsIdsByHealthcarePartyBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun getPatientByExternalIdBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun fuzzySearchBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun findDeletedPatientsBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun listDeletedPatientsByNameBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
	public val patientIds: ListOfIds,
)

public fun getPatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<GetPatientsParams>(params)
	runBlocking {
		sdk.patient.getPatients(
			decodedParams.patientIds,
		)
	}
}.toPyString(ListSerializer(DecryptedPatient.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun getPatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun getPatientByHealthcarePartyAndIdentifierBlocking(sdk: IcureApis, params: String): String
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun modifyPatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientsParams>(params)
	runBlocking {
		sdk.patient.modifyPatients(
			decodedParams.patientDtos,
		)
	}
}.toPyString(ListSerializer(IdWithRev.serializer()))

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
private class ModifyPatientReferralParams(
	public val patientId: String,
	public val referralId: String,
	public val start: Long? = null,
	public val end: Long? = null,
)

public fun modifyPatientReferralBlocking(sdk: IcureApis, params: String): String =
		kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientReferralParams>(params)
	runBlocking {
		sdk.patient.modifyPatientReferral(
			decodedParams.patientId,
			decodedParams.referralId,
			decodedParams.start,
			decodedParams.end,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun modifyPatientReferralAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ModifyPatientReferralParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.modifyPatientReferral(
				decodedParams.patientId,
				decodedParams.referralId,
				decodedParams.start,
				decodedParams.end,
			)
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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

public fun findDuplicatesByNameBlocking(sdk: IcureApis, params: String): String =
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
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
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
	public val intoId: String,
	public val fromId: String,
	public val expectedFromRev: String,
	public val updatedInto: EncryptedPatient,
)

public fun mergePatientsBlocking(sdk: IcureApis, params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergePatientsParams>(params)
	runBlocking {
		sdk.patient.mergePatients(
			decodedParams.intoId,
			decodedParams.fromId,
			decodedParams.expectedFromRev,
			decodedParams.updatedInto,
		)
	}
}.toPyString(DecryptedPatient.serializer())

@OptIn(ExperimentalForeignApi::class)
public fun mergePatientsAsync(
	sdk: IcureApis,
	params: String,
	resultCallback: CPointer<CFunction<CValues<ByteVarOf<Byte>>?.(CValues<ByteVarOf<Byte>>?) -> Unit>>,
): Unit = kotlin.runCatching {
	val decodedParams = json.decodeFromString<MergePatientsParams>(params)
	GlobalScope.launch {
		kotlin.runCatching {
			sdk.patient.mergePatients(
				decodedParams.intoId,
				decodedParams.fromId,
				decodedParams.expectedFromRev,
				decodedParams.updatedInto,
			)
		}.toPyStringAsyncCallback(DecryptedPatient.serializer(), resultCallback)
	}
}.failureToPyStringAsyncCallback(resultCallback)
