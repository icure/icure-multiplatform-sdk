package com.icure.sdk.api

import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.crypto.InternalCryptoServices
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.entities.EntityAccessInformation
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.extensions.autoDelegationsFor
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.utils.EntityEncryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.ensureNonNull
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
class PatientApi(
	internal val rawApi: RawPatientApi,
	private val crypto: InternalCryptoServices
) {
	private val manifest = EncryptedFieldsManifest("Patient.", setOf("note"), emptyMap(), emptyMap(), emptyMap())

	suspend fun initialiseEncryptionMetadata(
		patient: DecryptedPatient,
		delegates: Map<String, AccessLevel> = emptyMap(),
		user: User? = null
		// Temporary, needs a lot more stuff to match typescript implementation
	): DecryptedPatient =
		crypto.entity.entityWithInitialisedEncryptedMetadata(
			patient.withTypeInfo(),
			null,
			null,
			true,
			true,
			delegates + user?.autoDelegationsFor(DelegationTag.MedicalInformation).orEmpty()
		).updatedEntity

	suspend fun getAndDecrypt(patientId: String) = rawApi.getPatient(patientId).successBody().let { p ->
		crypto.entity.tryDecryptEntity(p.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
	}

	suspend fun encryptAndCreate(patient: DecryptedPatient) = crypto.entity.encryptEntity(
		patient.withTypeInfo(),
		DecryptedPatient.serializer(),
		manifest,
	) { Serialization.json.decodeFromJsonElement<EncryptedPatient>(it) }.let { rawApi.createPatient(it) }.successBody().let {
		crypto.entity.tryDecryptEntity(it.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
	}

	suspend fun shareWith(
		delegateId: String,
		patient: DecryptedPatient,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite
	): SimpleShareResult<DecryptedPatient> =
		crypto.entity.simpleShareOrUpdateEncryptedEntityMetadata(
			patient.withTypeInfo(),
			false,
			mapOf(
				delegateId to SimpleDelegateShareOptions(
					shareSecretIds = shareSecretIds,
					shareEncryptionKeys = shareEncryptionKeys,
					shareOwningEntityIds = ShareMetadataBehaviour.Never,
					requestedPermissions = requestedPermission
				)
			)
		) { shareParams ->
			rawApi.bulkShare(shareParams).successBody().map { r ->
				r.map {
					crypto.entity.tryDecryptEntity(it.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
						?: throw EntityEncryptionException("Could not decrypt shared patient")
				}
			}
		}

	suspend fun getSecretIdsOf(patient: Patient): Set<String> = crypto.entity.secretIdsOf(patient.withTypeInfo(), null)

	suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String> = crypto.entity.getConfidentialSecretIdsOf(patient.withTypeInfo(), null)

	suspend fun initialiseConfidentialSecretId(patient: DecryptedPatient): DecryptedPatient {
		val updatedPatient: DecryptedPatient  =
			if (patient.rev != null)
				patient
			else
				ensureNonNull(encryptAndCreate(patient)) { "Could not create patient for confidential secret id initialisation" }
		val withTypeInfo: EntityWithTypeInfo<DecryptedPatient> = updatedPatient.withTypeInfo()
		return crypto.entity.initialiseConfidentialSecretId(withTypeInfo) {
			rawApi.bulkShare(it).successBody().map { r ->
				r.map {
					crypto.entity.tryDecryptEntity(it.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
						?: throw EntityEncryptionException("Could not decrypt shared patient")
				}
			}
		} ?: updatedPatient
	}

	suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString> = crypto.entity.encryptionKeysOf(patient.withTypeInfo(), null)

//	suspend fun tryEncryptAndUpdatePatient(patient: DecryptedPatient): DecryptedPatient {
//		// TODO very bad implementation and signature, only here temporarily until we have the "flavoured" apis
//		val encrypted = if (kotlin.runCatching { encryptionService.validateEncryptedEntity(patient.withTypeInfo(), DecryptedPatient.serializer(), manifest) }.isSuccess) {
//			patient
//		} else {
//			encryptionService.encryptEntity(patient.withTypeInfo(), DecryptedPatient.serializer(), manifest) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
//		}
//		return rawApi.modifyPatient(encrypted).successBody().let {
//			encryptionService.tryDecryptEntity(it.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }!!
//		}
//	}

	suspend fun getDataOwnersWithAccessTo(patient: Patient): EntityAccessInformation =
		crypto.delegationsDeAnonymization.getDataOwnersWithAccessTo(patient.withTypeInfo())

	suspend fun createDelegationsDeAnonymizationMetadata(patient: Patient, dataOwnerIds: Set<String>) =
		crypto.delegationsDeAnonymization.createOrUpdateDeAnonymizationInfo(patient.withTypeInfo(), dataOwnerIds)
}
