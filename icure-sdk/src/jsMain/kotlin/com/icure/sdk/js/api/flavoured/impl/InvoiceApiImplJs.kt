// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.InvoiceApi
import com.icure.sdk.js.api.flavoured.InvoiceApiJs
import com.icure.sdk.js.api.flavoured.InvoiceFlavouredApiJs
import com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedInvoiceJs
import com.icure.sdk.js.model.EncryptedInvoiceJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.InvoiceJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.sdk.js.model.embed.invoicingCode_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.invoice_fromJs
import com.icure.sdk.js.model.invoice_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedInvoice
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class InvoiceApiImplJs(
	private val invoiceApi: InvoiceApi,
) : InvoiceApiJs {
	override val encrypted: InvoiceFlavouredApiJs<EncryptedInvoiceJs> = object :
			InvoiceFlavouredApiJs<EncryptedInvoiceJs> {
		override fun shareWith(
			delegateId: String,
			invoice: EncryptedInvoiceJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedInvoiceJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				invoiceApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.invoice_fromJs(invoice),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)}


		override fun tryShareWithMany(invoice: EncryptedInvoiceJs,
				delegates: Record<String, InvoiceShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedInvoiceJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				invoiceApi.encrypted.tryShareWithMany(com.icure.sdk.js.model.invoice_fromJs(invoice),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.invoiceShareOptions_fromJs(x1)
				  },
				)),
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)}


		override fun shareWithMany(invoice: EncryptedInvoiceJs,
				delegates: Record<String, InvoiceShareOptionsJs>): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			invoice_toJs(invoiceApi.encrypted.shareWithMany(com.icure.sdk.js.model.invoice_fromJs(invoice),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.invoiceShareOptions_fromJs(x1)
			  },
			)))}


		override fun findInvoicesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedInvoiceJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				invoiceApi.encrypted.findInvoicesByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)}


		override fun modifyInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			invoice_toJs(invoiceApi.encrypted.modifyInvoice(com.icure.sdk.js.model.invoice_fromJs(entity)))}


		override fun modifyInvoices(entities: Array<EncryptedInvoiceJs>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.encrypted.modifyInvoices(arrayToList(
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
			invoice_toJs(invoiceApi.encrypted.getInvoice(entityId))}


		override fun getInvoices(entityIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.encrypted.getInvoices(arrayToList(
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
				invoiceApi.encrypted.filterInvoicesBy(filterChain_fromJs(
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
				invoiceApi.encrypted.findInvoicesByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
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
			invoice_toJs(invoiceApi.encrypted.reassignInvoice(com.icure.sdk.js.model.invoice_fromJs(invoice)))}


		override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			invoice_toJs(invoiceApi.encrypted.mergeTo(invoiceId,
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
			invoice_toJs(invoiceApi.encrypted.validate(invoiceId, scheme, forcedValue))}


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
				invoiceApi.encrypted.appendCodes(userId, type, sentMediumType, secretFKeys, insuranceId,
						invoiceId, numberToInt(gracePeriod, "gracePeriod"), arrayToList(
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
				invoiceApi.encrypted.removeCodes(userId, serviceId, secretFKeys, arrayToList(
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
				invoiceApi.encrypted.findInvoicesByAuthor(hcPartyId,
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
				invoiceApi.encrypted.listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId, arrayToList(
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
				invoiceApi.encrypted.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId),
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
				invoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(hcPartyId,
						MediumType.valueOf(sentMediumType), InvoiceType.valueOf(invoiceType), sent, numberToLong(from,
						"from"), numberToLong(to, "to")),
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByContactIds(contactIds: Array<String>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.encrypted.listInvoicesByContactIds(arrayToList(
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
				invoiceApi.encrypted.listInvoicesByRecipientsIds(arrayToList(
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
				invoiceApi.encrypted.listToInsurances(arrayToList(
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
				invoiceApi.encrypted.listToInsurancesUnsent(arrayToList(
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
				invoiceApi.encrypted.listToPatients(hcPartyId),
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.encrypted.listToPatientsUnsent(hcPartyId),
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByIds(ids: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.encrypted.listInvoicesByIds(arrayToList(
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
				invoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode, status,
						numberToLong(from, "from"), numberToLong(to, "to")),
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByServiceIds(serviceIds: Array<String>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.encrypted.listInvoicesByServiceIds(arrayToList(
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
				invoiceApi.encrypted.listAllHcpsByStatus(status, numberToLong(from, "from"), numberToLong(to,
						"to"), arrayToList(
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

	override val tryAndRecover: InvoiceFlavouredApiJs<InvoiceJs> = object :
			InvoiceFlavouredApiJs<InvoiceJs> {
		override fun shareWith(
			delegateId: String,
			invoice: InvoiceJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<InvoiceJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				invoiceApi.tryAndRecover.shareWith(delegateId, com.icure.sdk.js.model.invoice_fromJs(invoice),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun tryShareWithMany(invoice: InvoiceJs,
				delegates: Record<String, InvoiceShareOptionsJs>): Promise<SimpleShareResultJs<InvoiceJs>> =
				GlobalScope.promise {
			simpleShareResult_toJs(
				invoiceApi.tryAndRecover.tryShareWithMany(com.icure.sdk.js.model.invoice_fromJs(invoice),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.invoiceShareOptions_fromJs(x1)
				  },
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun shareWithMany(invoice: InvoiceJs, delegates: Record<String, InvoiceShareOptionsJs>):
				Promise<InvoiceJs> = GlobalScope.promise {
			invoice_toJs(invoiceApi.tryAndRecover.shareWithMany(com.icure.sdk.js.model.invoice_fromJs(invoice),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.invoiceShareOptions_fromJs(x1)
			  },
			)))}


		override fun findInvoicesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<InvoiceJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				invoiceApi.tryAndRecover.findInvoicesByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun modifyInvoice(entity: InvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
			invoice_toJs(invoiceApi.tryAndRecover.modifyInvoice(com.icure.sdk.js.model.invoice_fromJs(entity)))}


		override fun modifyInvoices(entities: Array<InvoiceJs>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.modifyInvoices(arrayToList(
					entities,
					"entities",
					{ x1: InvoiceJs ->
						invoice_fromJs(x1)
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun getInvoice(entityId: String): Promise<InvoiceJs> = GlobalScope.promise {
			invoice_toJs(invoiceApi.tryAndRecover.getInvoice(entityId))}


		override fun getInvoices(entityIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.getInvoices(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun filterInvoicesBy(filterChain: FilterChainJs<InvoiceJs>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.filterInvoicesBy(filterChain_fromJs(
					filterChain,
					{ x1: InvoiceJs ->
						invoice_fromJs(x1)
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.findInvoicesByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun reassignInvoice(invoice: InvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
			invoice_toJs(invoiceApi.tryAndRecover.reassignInvoice(com.icure.sdk.js.model.invoice_fromJs(invoice)))}


		override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<InvoiceJs> =
				GlobalScope.promise {
			invoice_toJs(invoiceApi.tryAndRecover.mergeTo(invoiceId,
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
		): Promise<InvoiceJs> = GlobalScope.promise {
			invoice_toJs(invoiceApi.tryAndRecover.validate(invoiceId, scheme, forcedValue))}


		override fun appendCodes(
			userId: String,
			type: String,
			sentMediumType: String,
			secretFKeys: String,
			insuranceId: String?,
			invoiceId: String?,
			gracePeriod: Double?,
			invoicingCodes: Array<EncryptedInvoicingCodeJs>,
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.appendCodes(userId, type, sentMediumType, secretFKeys, insuranceId,
						invoiceId, numberToInt(gracePeriod, "gracePeriod"), arrayToList(
					invoicingCodes,
					"invoicingCodes",
					{ x1: EncryptedInvoicingCodeJs ->
						invoicingCode_fromJs(x1)
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun removeCodes(
			userId: String,
			serviceId: String,
			secretFKeys: String,
			tarificationIds: Array<String>,
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.removeCodes(userId, serviceId, secretFKeys, arrayToList(
					tarificationIds,
					"tarificationIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
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
		): Promise<PaginatedListJs<InvoiceJs>> = GlobalScope.promise {
			paginatedList_toJs(
				invoiceApi.tryAndRecover.findInvoicesByAuthor(hcPartyId,
						com.icure.sdk.js.model.CheckedConverters.numberToLong(fromDate, "fromDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(toDate, "toDate"),
						com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId, arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
				Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId),
				{ x1: Invoice ->
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
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(hcPartyId,
						MediumType.valueOf(sentMediumType), InvoiceType.valueOf(invoiceType), sent, numberToLong(from,
						"from"), numberToLong(to, "to")),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByContactIds(contactIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listInvoicesByContactIds(arrayToList(
					contactIds,
					"contactIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>): Promise<Array<InvoiceJs>>
				= GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listInvoicesByRecipientsIds(arrayToList(
					recipientsIds,
					"recipientsIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listToInsurances(userIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listToInsurances(arrayToList(
					userIds,
					"userIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listToInsurancesUnsent(arrayToList(
					userIds,
					"userIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listToPatients(hcPartyId: String): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listToPatients(hcPartyId),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listToPatientsUnsent(hcPartyId),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByIds(ids: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listInvoicesByIds(arrayToList(
					ids,
					"ids",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByHcpartySendingModeStatusDate(
			hcPartyId: String,
			sendingMode: String,
			status: String,
			from: Double,
			to: Double,
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode,
						status, numberToLong(from, "from"), numberToLong(to, "to")),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listInvoicesByServiceIds(serviceIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listInvoicesByServiceIds(arrayToList(
					serviceIds,
					"serviceIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}


		override fun listAllHcpsByStatus(
			status: String,
			from: Double?,
			to: Double?,
			hcpIds: Array<String>,
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			listToArray(
				invoiceApi.tryAndRecover.listAllHcpsByStatus(status, numberToLong(from, "from"),
						numberToLong(to, "to"), arrayToList(
					hcpIds,
					"hcpIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)}

	}

	override fun createInvoice(entity: DecryptedInvoiceJs, prefix: String?):
			Promise<DecryptedInvoiceJs> = GlobalScope.promise {
		invoice_toJs(invoiceApi.createInvoice(com.icure.sdk.js.model.invoice_fromJs(entity), prefix))}


	override fun createInvoices(entities: Array<DecryptedInvoiceJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.createInvoices(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun withEncryptionMetadata(
		base: DecryptedInvoiceJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: Record<String, String>,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedInvoiceJs> = GlobalScope.promise {
		invoice_toJs(invoiceApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.invoice_fromJs(nonNull1)
		}, patient?.let { nonNull1 ->
		  com.icure.sdk.js.model.patient_fromJs(nonNull1)
		}, user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.model.embed.AccessLevel.valueOf(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun getEncryptionKeysOf(invoice: InvoiceJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			invoiceApi.getEncryptionKeysOf(invoice_fromJs(invoice)),
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)}


	override fun hasWriteAccess(invoice: InvoiceJs): Promise<Boolean> = GlobalScope.promise {
		invoiceApi.hasWriteAccess(invoice_fromJs(invoice))}


	override fun decryptPatientIdOf(invoice: InvoiceJs): Promise<Array<String>> = GlobalScope.promise {
		setToArray(
			invoiceApi.decryptPatientIdOf(invoice_fromJs(invoice)),
			{ x1: String ->
				x1
			},
		)}


	override fun createDelegationDeAnonymizationMetadata(entity: InvoiceJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		invoiceApi.createDelegationDeAnonymizationMetadata(invoice_fromJs(entity), arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		))}


	override fun deleteInvoice(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(invoiceApi.deleteInvoice(entityId))}


	override fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
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
			invoiceApi.getTarificationsCodesOccurrences(numberToInt(minOccurrence, "minOccurrence")),
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)}


	override fun shareWith(
		delegateId: String,
		invoice: DecryptedInvoiceJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedInvoiceJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			invoiceApi.shareWith(delegateId, com.icure.sdk.js.model.invoice_fromJs(invoice),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
					com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun tryShareWithMany(invoice: DecryptedInvoiceJs,
			delegates: Record<String, InvoiceShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedInvoiceJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			invoiceApi.tryShareWithMany(com.icure.sdk.js.model.invoice_fromJs(invoice),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.invoiceShareOptions_fromJs(x1)
			  },
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun shareWithMany(invoice: DecryptedInvoiceJs,
			delegates: Record<String, InvoiceShareOptionsJs>): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		invoice_toJs(invoiceApi.shareWithMany(com.icure.sdk.js.model.invoice_fromJs(invoice),
				com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs ->
		    com.icure.sdk.js.crypto.entities.invoiceShareOptions_fromJs(x1)
		  },
		)))}


	override fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedInvoiceJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			invoiceApi.findInvoicesByHcPartyPatient(hcPartyId,
					com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun modifyInvoice(entity: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		invoice_toJs(invoiceApi.modifyInvoice(com.icure.sdk.js.model.invoice_fromJs(entity)))}


	override fun modifyInvoices(entities: Array<DecryptedInvoiceJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.modifyInvoices(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedInvoiceJs ->
					invoice_fromJs(x1)
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun getInvoice(entityId: String): Promise<DecryptedInvoiceJs> = GlobalScope.promise {
		invoice_toJs(invoiceApi.getInvoice(entityId))}


	override fun getInvoices(entityIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceApi.getInvoices(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun filterInvoicesBy(filterChain: FilterChainJs<InvoiceJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.filterInvoicesBy(filterChain_fromJs(
				filterChain,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.findInvoicesByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun reassignInvoice(invoice: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		invoice_toJs(invoiceApi.reassignInvoice(com.icure.sdk.js.model.invoice_fromJs(invoice)))}


	override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		invoice_toJs(invoiceApi.mergeTo(invoiceId, com.icure.sdk.js.model.CheckedConverters.arrayToList(
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
	): Promise<DecryptedInvoiceJs> = GlobalScope.promise {
		invoice_toJs(invoiceApi.validate(invoiceId, scheme, forcedValue))}


	override fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		insuranceId: String?,
		invoiceId: String?,
		gracePeriod: Double?,
		invoicingCodes: Array<EncryptedInvoicingCodeJs>,
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.appendCodes(userId, type, sentMediumType, secretFKeys, insuranceId, invoiceId,
					numberToInt(gracePeriod, "gracePeriod"), arrayToList(
				invoicingCodes,
				"invoicingCodes",
				{ x1: EncryptedInvoicingCodeJs ->
					invoicingCode_fromJs(x1)
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: Array<String>,
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.removeCodes(userId, serviceId, secretFKeys, arrayToList(
				tarificationIds,
				"tarificationIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
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
	): Promise<PaginatedListJs<DecryptedInvoiceJs>> = GlobalScope.promise {
		paginatedList_toJs(
			invoiceApi.findInvoicesByAuthor(hcPartyId,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(fromDate, "fromDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(toDate, "toDate"),
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.listInvoicesByHcPartyAndGroupId(hcPartyId, groupId),
			{ x1: DecryptedInvoice ->
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
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(hcPartyId,
					MediumType.valueOf(sentMediumType), InvoiceType.valueOf(invoiceType), sent, numberToLong(from,
					"from"), numberToLong(to, "to")),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByContactIds(contactIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.listInvoicesByContactIds(arrayToList(
				contactIds,
				"contactIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.listInvoicesByRecipientsIds(arrayToList(
				recipientsIds,
				"recipientsIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listToInsurances(userIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceApi.listToInsurances(arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceApi.listToInsurancesUnsent(arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listToPatients(hcPartyId: String): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceApi.listToPatients(hcPartyId),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceApi.listToPatientsUnsent(hcPartyId),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByIds(ids: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		listToArray(
			invoiceApi.listInvoicesByIds(arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Double,
		to: Double,
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.listInvoicesByHcpartySendingModeStatusDate(hcPartyId, sendingMode, status,
					numberToLong(from, "from"), numberToLong(to, "to")),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listInvoicesByServiceIds(serviceIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.listInvoicesByServiceIds(arrayToList(
				serviceIds,
				"serviceIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}


	override fun listAllHcpsByStatus(
		status: String,
		from: Double?,
		to: Double?,
		hcpIds: Array<String>,
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		listToArray(
			invoiceApi.listAllHcpsByStatus(status, numberToLong(from, "from"), numberToLong(to, "to"),
					arrayToList(
				hcpIds,
				"hcpIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)}

}
