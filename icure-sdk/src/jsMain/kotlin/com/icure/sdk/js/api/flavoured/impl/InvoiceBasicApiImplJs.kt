// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.InvoiceBasicApi
import com.icure.sdk.js.api.flavoured.InvoiceBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.EncryptedInvoiceJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.InvoiceJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.sdk.js.model.embed.invoiceType_fromJs
import com.icure.sdk.js.model.embed.invoicingCode_fromJs
import com.icure.sdk.js.model.embed.mediumType_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.invoice_fromJs
import com.icure.sdk.js.model.invoice_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.`data`.LabelledOccurence
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class InvoiceBasicApiImplJs(
	private val invoiceBasicApi: InvoiceBasicApi,
) : InvoiceBasicApiJs {
	override fun deleteInvoice(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(invoiceBasicApi.deleteInvoice(entityId))}


	override fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: IcureStub ->
				icureStub_toJs(x1)
			},
		)}


	override fun getTarificationsCodesOccurrences(minOccurrence: Double):
			Promise<Array<LabelledOccurenceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.getTarificationsCodesOccurrences(numberToInt(minOccurrence, "minOccurrence")),
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)}


	override fun modifyInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
			GlobalScope.promise {
		invoice_toJs(invoiceBasicApi.modifyInvoice(com.icure.sdk.js.model.invoice_fromJs(entity)))}


	override fun modifyInvoices(entities: Array<EncryptedInvoiceJs>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.modifyInvoices(arrayToList(
				entities,
				"entities",
				{ x1: EncryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun getInvoice(entityId: String): Promise<EncryptedInvoiceJs> = GlobalScope.promise {
		invoice_toJs(invoiceBasicApi.getInvoice(entityId))}


	override fun getInvoices(entityIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceBasicApi.getInvoices(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun filterInvoicesBy(filterChain: FilterChainJs<InvoiceJs>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.filterInvoicesBy(filterChain_fromJs(
				filterChain,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.findInvoicesByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun reassignInvoice(invoice: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
			GlobalScope.promise {
		invoice_toJs(invoiceBasicApi.reassignInvoice(com.icure.sdk.js.model.invoice_fromJs(invoice)))}


	override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<EncryptedInvoiceJs> =
			GlobalScope.promise {
		invoice_toJs(invoiceBasicApi.mergeTo(invoiceId,
				com.icure.sdk.js.model.CheckedConverters.arrayToList(
		  ids,
		  "ids",
		  { x1: kotlin.String ->
		    x1
		  },
		)))}


	override fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): Promise<EncryptedInvoiceJs> = GlobalScope.promise {
		invoice_toJs(invoiceBasicApi.validate(invoiceId, scheme, forcedValue))}


	override fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String?,
		invoiceId: String?,
		gracePeriod: Double?,
		invoicingCodes: Array<EncryptedInvoicingCodeJs>,
	): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.appendCodes(userId, type, sentMediumType, secretFKeys, insuranceId, invoiceId,
					numberToInt(gracePeriod, "gracePeriod"), arrayToList(
				invoicingCodes,
				"invoicingCodes",
				{ x1: EncryptedInvoicingCodeJs ->
					invoicingCode_fromJs(x1)
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: Array<String>,
	): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.removeCodes(userId, serviceId, secretFKeys, arrayToList(
				tarificationIds,
				"tarificationIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun findInvoicesByAuthor(
		hcPartyId: String,
		fromDate: Double?,
		toDate: Double?,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedInvoiceJs>> = GlobalScope.promise {
		paginatedList_toJs(
			invoiceBasicApi.findInvoicesByAuthor(hcPartyId,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(fromDate, "fromDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(toDate, "toDate"),
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: String,
		invoiceType: String,
		sent: Boolean,
		from: Double?,
		to: Double?,
	): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(hcPartyId,
					mediumType_fromJs(sentMediumType), invoiceType_fromJs(invoiceType), sent, numberToLong(from,
					"from"), numberToLong(to, "to")),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByContactIds(contactIds: Array<String>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listInvoicesByContactIds(arrayToList(
				contactIds,
				"contactIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listInvoicesByRecipientsIds(arrayToList(
				recipientsIds,
				"recipientsIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listToInsurances(userIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listToInsurances(arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listToInsurancesUnsent(arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listToPatients(hcPartyId: String): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listToPatients(hcPartyId),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listToPatientsUnsent(hcPartyId),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByIds(ids: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listInvoicesByIds(arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Double,
		to: Double,
	): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode, status,
					numberToLong(from, "from"), numberToLong(to, "to")),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByServiceIds(serviceIds: Array<String>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listInvoicesByServiceIds(arrayToList(
				serviceIds,
				"serviceIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listAllHcpsByStatus(
		status: String,
		from: Double?,
		to: Double?,
		hcpIds: Array<String>,
	): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceBasicApi.listAllHcpsByStatus(status, numberToLong(from, "from"), numberToLong(to, "to"),
					arrayToList(
				hcpIds,
				"hcpIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)}

}
