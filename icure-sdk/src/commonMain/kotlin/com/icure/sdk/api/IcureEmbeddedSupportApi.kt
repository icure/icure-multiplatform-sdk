package com.icure.sdk.api

import com.icure.sdk.model.Contact
import com.icure.sdk.model.HexString

data class ContactTemplateDetails(
	val contactTemplate: Contact,
	val templateId: String,
	val encryptionKeyHex: HexString
)

/**
 * API to support the creation of encrypted data from embedded devices.
 * You can get some metadata from this API which you can then send to embedded devices to support the creation of
 * encrypted medical data.
 */
interface IcureEmbeddedSupportApi {
	/**
	 * Creates a contact template which can be filled at a second moment with data from an embedded device in order to
	 * make a full contact. The contact template will initially have no services, since the services will be created by
	 * the embedded device.
	 *
	 * @param contact the base for the contact. Must have no services.
	 * @return stubs providing the encryption key and other metadata needed to create a secure delegations to allow the
	 * current data owner and optionally other delegates to access a certain encrypted entity.
	 */
	suspend fun createContactTemplate(
		contact: Contact
	): ContactTemplateDetails
}