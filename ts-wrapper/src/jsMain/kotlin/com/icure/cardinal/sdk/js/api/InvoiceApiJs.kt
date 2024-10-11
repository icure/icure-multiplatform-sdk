// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.InvoiceShareOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.EncryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.IcureStubJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InvoiceApi")
public external interface InvoiceApiJs {
	public val encrypted: InvoiceFlavouredApiJs<EncryptedInvoiceJs>

	public val tryAndRecover: InvoiceFlavouredApiJs<InvoiceJs>

	public fun createInvoice(entity: DecryptedInvoiceJs, prefix: String?): Promise<DecryptedInvoiceJs>

	public fun createInvoices(entities: Array<DecryptedInvoiceJs>): Promise<Array<DecryptedInvoiceJs>>

	public fun withEncryptionMetadata(
		base: DecryptedInvoiceJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedInvoiceJs>

	public fun getEncryptionKeysOf(invoice: InvoiceJs): Promise<Array<String>>

	public fun hasWriteAccess(invoice: InvoiceJs): Promise<Boolean>

	public fun decryptPatientIdOf(invoice: InvoiceJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: InvoiceJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(invoice: EncryptedInvoiceJs): Promise<DecryptedInvoiceJs>

	public fun tryDecrypt(invoice: EncryptedInvoiceJs): Promise<InvoiceJs>

	public fun deleteInvoice(entityId: String): Promise<DocIdentifierJs>

	public fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>>

	public fun getTarificationsCodesOccurrences(minOccurrence: Double):
			Promise<Array<LabelledOccurenceJs>>

	public fun shareWith(
		delegateId: String,
		invoice: DecryptedInvoiceJs,
		options: dynamic,
	): Promise<DecryptedInvoiceJs>

	public fun shareWithMany(invoice: DecryptedInvoiceJs,
			delegates: Record<String, InvoiceShareOptionsJs>): Promise<DecryptedInvoiceJs>

	public fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedInvoiceJs>>

	public fun modifyInvoice(entity: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs>

	public fun modifyInvoices(entities: Array<DecryptedInvoiceJs>): Promise<Array<DecryptedInvoiceJs>>

	public fun getInvoice(entityId: String): Promise<DecryptedInvoiceJs>

	public fun getInvoices(entityIds: Array<String>): Promise<Array<DecryptedInvoiceJs>>

	public fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedInvoiceJs>>

	public fun reassignInvoice(invoice: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs>

	public fun mergeTo(invoiceId: String, ids: Array<String>): Promise<DecryptedInvoiceJs>

	public fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): Promise<DecryptedInvoiceJs>

	public fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		invoicingCodes: Array<EncryptedInvoicingCodeJs>,
		options: dynamic,
	): Promise<Array<DecryptedInvoiceJs>>

	public fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: Array<String>,
	): Promise<Array<DecryptedInvoiceJs>>

	public fun findInvoicesByAuthor(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedInvoiceJs>>

	public fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedInvoiceJs>>

	public fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
			Promise<Array<DecryptedInvoiceJs>>

	public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: String,
		invoiceType: String,
		sent: Boolean,
		options: dynamic,
	): Promise<Array<DecryptedInvoiceJs>>

	public fun listInvoicesByContactIds(contactIds: Array<String>): Promise<Array<DecryptedInvoiceJs>>

	public fun listInvoicesByRecipientsIds(recipientsIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>>

	public fun listToInsurances(userIds: Array<String>): Promise<Array<DecryptedInvoiceJs>>

	public fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<DecryptedInvoiceJs>>

	public fun listToPatients(hcPartyId: String): Promise<Array<DecryptedInvoiceJs>>

	public fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<DecryptedInvoiceJs>>

	public fun listInvoicesByIds(ids: Array<String>): Promise<Array<DecryptedInvoiceJs>>

	public fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Double,
		to: Double,
	): Promise<Array<DecryptedInvoiceJs>>

	public fun listInvoicesByServiceIds(serviceIds: Array<String>): Promise<Array<DecryptedInvoiceJs>>

	public fun listAllHcpsByStatus(
		status: String,
		hcpIds: Array<String>,
		options: dynamic,
	): Promise<Array<DecryptedInvoiceJs>>
}
