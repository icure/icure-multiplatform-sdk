package com.icure.sdk.api

import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.crypto.entities.SimpleDelegateShareOptions
import com.icure.sdk.crypto.entities.SimpleShareResult
import com.icure.sdk.crypto.entities.withTypeInfo
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.model.Patient
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.utils.EntityDecryptionException
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import com.icure.sdk.utils.ensureNonNull
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
class PatientApi(
	internal val rawApi: RawPatientApi,
	private val encryptionService: EntityEncryptionService
) {
	private val manifest = EncryptedFieldsManifest("Patient.", setOf("note"), emptyMap(), emptyMap(), emptyMap())

	suspend fun initialiseEncryptionMetadata(
		patient: Patient,
		delegates: Map<String, AccessLevel> = emptyMap()
		// Temporary, needs a lot more stuff to match typescript implementation
	): Patient =
		encryptionService.entityWithInitialisedEncryptedMetadata(
			patient.withTypeInfo(),
			null,
			null,
			true,
			true,
			delegates // TODO add auto delegations
		).updatedEntity

	suspend fun getAndDecrypt(patientId: String) = rawApi.getPatient(patientId).successBody().let { p ->
		encryptionService.tryDecryptEntity(p.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
	}

	suspend fun encryptAndCreate(patient: Patient) = encryptionService.encryptEntity(
		patient.withTypeInfo(),
		Patient.serializer(),
		manifest,
	) { Serialization.json.decodeFromJsonElement<Patient>(it) }.let { rawApi.createPatient(it) }.successBody().let {
		encryptionService.tryDecryptEntity(it.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
	}

	suspend fun shareWith(
		delegateId: String,
		patient: DecryptedPatient,
		shareSecretIds: Set<String>,
		shareEncryptionKeys: ShareMetadataBehaviour = ShareMetadataBehaviour.IfAvailable,
		requestedPermission: RequestedPermission = RequestedPermission.MaxWrite
	): SimpleShareResult<DecryptedPatient> =
		encryptionService.simpleShareOrUpdateEncryptedEntityMetadata(
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
					encryptionService.tryDecryptEntity(it.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
						?: throw EntityDecryptionException("Could not decrypt shared patient")
				}
			}
		}

	suspend fun getSecretIdsOf(patient: Patient): Set<String> = encryptionService.secretIdsOf(patient.withTypeInfo(), null)

	suspend fun getConfidentialSecretIdsOf(patient: Patient): Set<String> = encryptionService.getConfidentialSecretIdsOf(patient.withTypeInfo(), null)

	suspend fun initialiseConfidentialSecretId(patient: Patient): Patient {
		val updatedPatient =
			if (patient.rev != null)
				patient
			else
				ensureNonNull(encryptAndCreate(patient)) { "Could not create patient for confidential secret id initialisation" }
		return encryptionService.initialiseConfidentialSecretId(patient.withTypeInfo()) { rawApi.bulkShare(it).successBody() }
			?: updatedPatient
	}

	suspend fun getEncryptionKeysOf(patient: Patient): Set<HexString> = encryptionService.encryptionKeysOf(patient.withTypeInfo(), null)

	suspend fun tryEncryptAndUpdatePatient(patient: DecryptedPatient): DecryptedPatient {
		// TODO very bad implementation and signature, only here temporarily until we have the "flavoured" apis
		val encrypted = if (kotlin.runCatching { encryptionService.validateEncryptedEntity(patient.withTypeInfo(), DecryptedPatient.serializer(), manifest) }.isSuccess) {
			patient
		} else {
			encryptionService.encryptEntity(patient.withTypeInfo(), DecryptedPatient.serializer(), manifest) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }
		}
		return rawApi.modifyPatient(encrypted).successBody().let {
			encryptionService.tryDecryptEntity(it.withTypeInfo(), EncryptedPatient.serializer()) { Serialization.json.decodeFromJsonElement<DecryptedPatient>(it) }!!
		}
	}
}
