// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.DecryptedContactJs
import com.icure.sdk.js.model.EncryptedContactJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("ContactApi")
public external interface ContactApiJs {
	public val encrypted: ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs>

	public val tryAndRecover: ContactFlavouredApiJs<ContactJs, ServiceJs>

	public fun createContact(entity: DecryptedContactJs): Promise<DecryptedContactJs>

	public fun createContacts(entities: Array<DecryptedContactJs>): Promise<Array<DecryptedContactJs>>

	public fun withEncryptionMetadata(
		base: DecryptedContactJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedContactJs>

	public fun matchContactsBy(filter: AbstractFilterJs<EncryptedContactJs>): Promise<Array<String>>

	public fun deleteContact(entityId: String): Promise<DocIdentifierJs>

	public fun deleteContacts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>>

	public fun getServiceCodesOccurrences(codeType: String, minOccurrences: Double):
			Promise<Array<LabelledOccurenceJs>>

	public fun shareWith(
		delegateId: String,
		contact: DecryptedContactJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedContactJs>>

	public fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedContactJs>>
}
