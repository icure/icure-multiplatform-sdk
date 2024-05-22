// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedInvoiceJs
import com.icure.sdk.js.model.EncryptedInvoiceJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.InvoiceJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("InvoiceApi")
public external interface InvoiceApiJs {
	public val encrypted: InvoiceFlavouredApiJs<EncryptedInvoiceJs>

	public val tryAndRecover: InvoiceFlavouredApiJs<InvoiceJs>

	public fun createInvoice(entity: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs>

	public fun createInvoices(entities: Array<DecryptedInvoiceJs>): Promise<Array<DecryptedInvoiceJs>>

	public fun withEncryptionMetadata(
		base: DecryptedInvoiceJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedInvoiceJs>

	public fun deleteInvoice(entityId: String): Promise<DocIdentifierJs>

	public fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>>

	public fun getTarificationsCodesOccurrences(minOccurrence: Double):
			Promise<Array<LabelledOccurenceJs>>

	public fun shareWith(
		delegateId: String,
		invoice: DecryptedInvoiceJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedInvoiceJs>>

	public fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedInvoiceJs>>
}
