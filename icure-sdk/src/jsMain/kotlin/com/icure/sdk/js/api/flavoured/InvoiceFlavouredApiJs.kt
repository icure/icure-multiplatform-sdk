// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.InvoiceJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InvoiceFlavouredApi")
public external interface InvoiceFlavouredApiJs<E : InvoiceJs> {
	public fun shareWith(
		delegateId: String,
		invoice: E,
		options: InvoiceFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(invoice: E, delegates: Record<String, InvoiceShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(invoice: E, delegates: Record<String, InvoiceShareOptionsJs>): Promise<E>

	public fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: InvoiceFlavouredApi_findInvoicesByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun modifyInvoice(entity: E): Promise<E>

	public fun modifyInvoices(entities: Array<E>): Promise<Array<E>>

	public fun getInvoice(entityId: String): Promise<E>

	public fun getInvoices(entityIds: Array<String>): Promise<Array<E>>

	public fun filterInvoicesBy(filterChain: FilterChainJs<InvoiceJs>): Promise<Array<E>>

	public fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<E>>

	public fun reassignInvoice(invoice: E): Promise<E>

	public fun mergeTo(invoiceId: String, ids: Array<String>): Promise<E>

	public fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): Promise<E>

	public fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		invoicingCodes: Array<EncryptedInvoicingCodeJs>,
		options: InvoiceFlavouredApi_appendCodes_Options?,
	): Promise<Array<E>>

	public fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: Array<String>,
	): Promise<Array<E>>

	public fun findInvoicesByAuthor(hcPartyId: String,
			options: InvoiceFlavouredApi_findInvoicesByAuthor_Options?): Promise<PaginatedListJs<E>>

	public fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<E>>

	public fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String): Promise<Array<E>>

	public fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: String,
		invoiceType: String,
		sent: Boolean,
		options: InvoiceFlavouredApi_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate_Options?,
	): Promise<Array<E>>

	public fun listInvoicesByContactIds(contactIds: Array<String>): Promise<Array<E>>

	public fun listInvoicesByRecipientsIds(recipientsIds: Array<String>): Promise<Array<E>>

	public fun listToInsurances(userIds: Array<String>): Promise<Array<E>>

	public fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<E>>

	public fun listToPatients(hcPartyId: String): Promise<Array<E>>

	public fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<E>>

	public fun listInvoicesByIds(ids: Array<String>): Promise<Array<E>>

	public fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Double,
		to: Double,
	): Promise<Array<E>>

	public fun listInvoicesByServiceIds(serviceIds: Array<String>): Promise<Array<E>>

	public fun listAllHcpsByStatus(
		status: String,
		hcpIds: Array<String>,
		options: InvoiceFlavouredApi_listAllHcpsByStatus_Options?,
	): Promise<Array<E>>
}

public external interface InvoiceFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface InvoiceFlavouredApi_findInvoicesByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}

public external interface InvoiceFlavouredApi_appendCodes_Options {
	public val insuranceId: String?

	public val invoiceId: String?

	public val gracePeriod: Double?
}

public external interface InvoiceFlavouredApi_findInvoicesByAuthor_Options {
	public val fromDate: Double?

	public val toDate: Double?

	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface
		InvoiceFlavouredApi_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate_Options {
	public val from: Double?

	public val to: Double?
}

public external interface InvoiceFlavouredApi_listAllHcpsByStatus_Options {
	public val from: Double?

	public val to: Double?
}
