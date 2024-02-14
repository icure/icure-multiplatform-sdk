package com.icure.sdk.api

import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.crypto.EncryptedFieldsManifest
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.model.Contact
import com.icure.sdk.model.Patient
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.encodeToJsonElement

@OptIn(InternalIcureApi::class)
class ContactApi(
	private val rawApi: RawContactApi,
	private val encryptionService: EntityEncryptionService
) {
	suspend fun initialiseEncryptionMetadata(
		contact: Contact,
		patient: Patient,
		// Temporary, needs a lot more stuff to match typescript implementation
	): Contact = encryptionService.entityWithInitialisedEncryptedMetadata(
		contact,
		patient.id,
		encryptionService.secretIdsOf(patient, null).first(),
		true,
		false,
		emptyMap()
	).updatedEntity

	suspend fun getAndDecrypt(contactId: String) = rawApi.getContact(contactId).successBody().let { c ->
		encryptionService.decryptEntity(c, Serialization.json.encodeToJsonElement(c),) { Serialization.json.decodeFromJsonElement<Contact>(it) }
	}

	suspend fun encryptAndCreate(contact: Contact) = encryptionService.tryEncryptEntity(
		contact,
		Serialization.json.encodeToJsonElement(contact),
		EncryptedFieldsManifest("Contact.", listOf("descr"), emptyMap(), emptyMap(), emptyMap()),
		true,
		true,
	) { Serialization.json.decodeFromJsonElement<Contact>(it) }.let { rawApi.createContact(it) }.successBody().let {
		encryptionService.decryptEntity(it, Serialization.json.encodeToJsonElement(it)) { Serialization.json.decodeFromJsonElement<Contact>(it) }
	}

	suspend fun getEncryptionKeyOf(contact: Contact) =
		encryptionService.encryptionKeysOf(contact, null).single()
}