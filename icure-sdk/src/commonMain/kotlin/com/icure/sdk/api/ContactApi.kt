package com.icure.sdk.api

import com.icure.sdk.api.raw.RawContactApi
import com.icure.sdk.crypto.entities.EncryptedFieldsManifest
import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.Contact
import com.icure.sdk.model.Patient
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.Serialization
import kotlinx.serialization.json.decodeFromJsonElement

@OptIn(InternalIcureApi::class)
class ContactApi(
	private val rawApi: RawContactApi,
	private val encryptionService: EntityEncryptionService
) {
	suspend fun initialiseEncryptionMetadata(
		contact: Contact,
		patient: Patient,
		delegates: Map<String, AccessLevel> = emptyMap(),
		secretId: SecretIdOption = SecretIdOption.UseAnySharedWithParent
		// Temporary, needs a lot more stuff to match typescript implementation
	): Contact =
		encryptionService.entityWithInitialisedEncryptedMetadata(
			contact,
			patient.id,
			encryptionService.resolveSecretIdOption(patient, secretId),
			true,
			false,
			delegates // TODO auto delegations
		).updatedEntity

	suspend fun getAndDecrypt(contactId: String) = rawApi.getContact(contactId).successBody().let { c ->
		encryptionService.tryDecryptEntity(c, Contact.serializer()) { Serialization.json.decodeFromJsonElement<Contact>(it) }
	}

	// TODO need to handle services...
	suspend fun encryptAndCreate(contact: Contact) = encryptionService.encryptEntity(
		contact,
		Contact.serializer(),
		EncryptedFieldsManifest("Contact.", setOf("descr"), emptyMap(), emptyMap(), emptyMap()),
	) { Serialization.json.decodeFromJsonElement<Contact>(it) }.let { rawApi.createContact(it) }.successBody().let {
		encryptionService.tryDecryptEntity(it, Contact.serializer()) { Serialization.json.decodeFromJsonElement<Contact>(it) }
	}

	suspend fun getEncryptionKeyOf(contact: Contact) =
		encryptionService.encryptionKeysOf(contact, null).single()
}