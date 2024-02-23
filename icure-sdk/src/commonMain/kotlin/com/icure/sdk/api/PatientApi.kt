package com.icure.sdk.api

import com.icure.sdk.api.raw.RawPatientApi
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.model.Patient
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
class PatientApi(
	private val rawApi: RawPatientApi,
	private val encryptionService: EntityEncryptionService
) {
	suspend fun initialiseEncryptionMetadata(
		patient: Patient,
		// Temporary, needs a lot more stuff to match typescript implementation
	): Patient = encryptionService.entityWithInitialisedEncryptedMetadata(
		patient,
		null,
		null,
		true,
		true,
		emptyMap()
	).updatedEntity

	suspend fun getAndDecrypt(contactId: String) = rawApi.getPatient(contactId).successBody().let { p ->
		encryptionService.tryDecryptEntity(p, Patient.serializer()) { Serialization.json.decodeFromJsonElement<Patient>(it) }
	}

	suspend fun encryptAndCreate(patient: Patient) = encryptionService.encryptEntity(
		patient,
		Patient.serializer(),
		EncryptedFieldsManifest("Patient.", setOf("note"), emptyMap(), emptyMap(), emptyMap()),
	) { Serialization.json.decodeFromJsonElement<Patient>(it) }.let { rawApi.createPatient(it) }.successBody().let {
		encryptionService.tryDecryptEntity(it, Patient.serializer()) { Serialization.json.decodeFromJsonElement<Patient>(it) }
	}
}