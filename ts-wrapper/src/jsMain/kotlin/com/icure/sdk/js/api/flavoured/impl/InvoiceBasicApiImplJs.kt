// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.InvoiceBasicApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.InvoiceBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.EncryptedInvoiceJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.InvoiceJs
import com.icure.sdk.js.model.PaginatedListJs
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
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.model.filter.chain.FilterChain
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.json.JsonElement

@OptIn(DelicateCoroutinesApi::class)
internal class InvoiceBasicApiImplJs(
	private val invoiceBasicApi: InvoiceBasicApi,
) : InvoiceBasicApiJs {
	override fun deleteInvoice(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = invoiceBasicApi.deleteInvoice(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: IcureStub ->
				icureStub_toJs(x1)
			},
		)
	}

	override fun getTarificationsCodesOccurrences(minOccurrence: Double):
			Promise<Array<LabelledOccurenceJs>> = GlobalScope.promise {
		val minOccurrenceConverted: Int = numberToInt(minOccurrence, "minOccurrence")
		val result = invoiceBasicApi.getTarificationsCodesOccurrences(
			minOccurrenceConverted,
		)
		listToArray(
			result,
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)
	}

	override fun modifyInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedInvoice = invoice_fromJs(entity)
		val result = invoiceBasicApi.modifyInvoice(
			entityConverted,
		)
		invoice_toJs(result)
	}

	override fun modifyInvoices(entities: Array<EncryptedInvoiceJs>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val entitiesConverted: List<EncryptedInvoice> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedInvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceBasicApi.modifyInvoices(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun getInvoice(entityId: String): Promise<EncryptedInvoiceJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = invoiceBasicApi.getInvoice(
			entityIdConverted,
		)
		invoice_toJs(result)
	}

	override fun getInvoices(entityIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.getInvoices(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun filterInvoicesBy(filterChain: FilterChainJs<InvoiceJs>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val filterChainConverted: FilterChain<Invoice> = filterChain_fromJs(
			filterChain,
			{ x1: InvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceBasicApi.filterInvoicesBy(
			filterChainConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.findInvoicesByHcPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun reassignInvoice(invoice: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
		val result = invoiceBasicApi.reassignInvoice(
			invoiceConverted,
		)
		invoice_toJs(result)
	}

	override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<EncryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceIdConverted: String = invoiceId
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.mergeTo(
			invoiceIdConverted,
			idsConverted,
		)
		invoice_toJs(result)
	}

	override fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): Promise<EncryptedInvoiceJs> = GlobalScope.promise {
		val invoiceIdConverted: String = invoiceId
		val schemeConverted: String = scheme
		val forcedValueConverted: String = forcedValue
		val result = invoiceBasicApi.validate(
			invoiceIdConverted,
			schemeConverted,
			forcedValueConverted,
		)
		invoice_toJs(result)
	}

	override fun appendCodes(
		userId: String,
		type: String,
		sentMediumType: String,
		secretFKeys: String,
		invoicingCodes: Array<EncryptedInvoicingCodeJs>,
		options: dynamic,
	): Promise<Array<EncryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val typeConverted: String = type
			val sentMediumTypeConverted: String = sentMediumType
			val secretFKeysConverted: String = secretFKeys
			val insuranceIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"insuranceId",
				null
			) { insuranceId: String? ->
				undefinedToNull(insuranceId)
			}
			val invoiceIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"invoiceId",
				null
			) { invoiceId: String? ->
				undefinedToNull(invoiceId)
			}
			val gracePeriodConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"gracePeriod",
				null
			) { gracePeriod: Double? ->
				numberToInt(gracePeriod, "gracePeriod")
			}
			val invoicingCodesConverted: List<EncryptedInvoicingCode> = arrayToList(
				invoicingCodes,
				"invoicingCodes",
				{ x1: EncryptedInvoicingCodeJs ->
					invoicingCode_fromJs(x1)
				},
			)
			val result = invoiceBasicApi.appendCodes(
				userIdConverted,
				typeConverted,
				sentMediumTypeConverted,
				secretFKeysConverted,
				insuranceIdConverted,
				invoiceIdConverted,
				gracePeriodConverted,
				invoicingCodesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun removeCodes(
		userId: String,
		serviceId: String,
		secretFKeys: String,
		tarificationIds: Array<String>,
	): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val userIdConverted: String = userId
		val serviceIdConverted: String = serviceId
		val secretFKeysConverted: String = secretFKeys
		val tarificationIdsConverted: List<String> = arrayToList(
			tarificationIds,
			"tarificationIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.removeCodes(
			userIdConverted,
			serviceIdConverted,
			secretFKeysConverted,
			tarificationIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun findInvoicesByAuthor(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val fromDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"fromDate",
				null
			) { fromDate: Double? ->
				numberToLong(fromDate, "fromDate")
			}
			val toDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"toDate",
				null
			) { toDate: Double? ->
				numberToLong(toDate, "toDate")
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: dynamic ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = invoiceBasicApi.findInvoicesByAuthor(
				hcPartyIdConverted,
				fromDateConverted,
				toDateConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.listInvoicesByHCPartyAndPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val groupIdConverted: String = groupId
		val result = invoiceBasicApi.listInvoicesByHcPartyAndGroupId(
			hcPartyIdConverted,
			groupIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
		hcPartyId: String,
		sentMediumType: String,
		invoiceType: String,
		sent: Boolean,
		options: dynamic,
	): Promise<Array<EncryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sentMediumTypeConverted: MediumType = MediumType.valueOf(sentMediumType)
			val invoiceTypeConverted: InvoiceType = InvoiceType.valueOf(invoiceType)
			val sentConverted: Boolean = sent
			val fromConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"from",
				null
			) { from: Double? ->
				numberToLong(from, "from")
			}
			val toConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"to",
				null
			) { to: Double? ->
				numberToLong(to, "to")
			}
			val result = invoiceBasicApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
				hcPartyIdConverted,
				sentMediumTypeConverted,
				invoiceTypeConverted,
				sentConverted,
				fromConverted,
				toConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun listInvoicesByContactIds(contactIds: Array<String>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val contactIdsConverted: List<String> = arrayToList(
			contactIds,
			"contactIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.listInvoicesByContactIds(
			contactIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val recipientsIdsConverted: List<String> = arrayToList(
			recipientsIds,
			"recipientsIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.listInvoicesByRecipientsIds(
			recipientsIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToInsurances(userIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.listToInsurances(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.listToInsurancesUnsent(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToPatients(hcPartyId: String): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val result = invoiceBasicApi.listToPatients(
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		val hcPartyIdConverted: String? = undefinedToNull(hcPartyId)
		val result = invoiceBasicApi.listToPatientsUnsent(
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByIds(ids: Array<String>): Promise<Array<EncryptedInvoiceJs>> =
			GlobalScope.promise {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.listInvoicesByIds(
			idsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByHcpartySendingModeStatusDate(
		hcPartyId: String,
		sendingMode: String,
		status: String,
		from: Double,
		to: Double,
	): Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val sendingModeConverted: String = sendingMode
		val statusConverted: String = status
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val result = invoiceBasicApi.listInvoicesByHcpartySendingModeStatusDate(
			hcPartyIdConverted,
			sendingModeConverted,
			statusConverted,
			fromConverted,
			toConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByServiceIds(serviceIds: Array<String>):
			Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
		val serviceIdsConverted: List<String> = arrayToList(
			serviceIds,
			"serviceIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceBasicApi.listInvoicesByServiceIds(
			serviceIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listAllHcpsByStatus(
		status: String,
		hcpIds: Array<String>,
		options: dynamic,
	): Promise<Array<EncryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val statusConverted: String = status
			val fromConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"from",
				null
			) { from: Double? ->
				numberToLong(from, "from")
			}
			val toConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"to",
				null
			) { to: Double? ->
				numberToLong(to, "to")
			}
			val hcpIdsConverted: List<String> = arrayToList(
				hcpIds,
				"hcpIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceBasicApi.listAllHcpsByStatus(
				statusConverted,
				fromConverted,
				toConverted,
				hcpIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}
}
