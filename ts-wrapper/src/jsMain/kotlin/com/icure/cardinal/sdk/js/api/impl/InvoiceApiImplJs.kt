// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.InvoiceApi
import com.icure.cardinal.sdk.crypto.entities.InvoiceShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.InvoiceApiJs
import com.icure.cardinal.sdk.js.api.InvoiceFlavouredApiJs
import com.icure.cardinal.sdk.js.crypto.entities.InvoiceShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.invoiceShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.EncryptedInvoiceJs
import com.icure.cardinal.sdk.js.model.InvoiceJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedInvoicingCodeJs
import com.icure.cardinal.sdk.js.model.embed.invoicingCode_fromJs
import com.icure.cardinal.sdk.js.model.invoice_fromJs
import com.icure.cardinal.sdk.js.model.invoice_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedInvoice
import com.icure.cardinal.sdk.model.EncryptedInvoice
import com.icure.cardinal.sdk.model.Invoice
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.EncryptedInvoicingCode
import com.icure.cardinal.sdk.model.embed.InvoiceType
import com.icure.cardinal.sdk.model.embed.MediumType
import com.icure.cardinal.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.json.JsonElement

@OptIn(DelicateCoroutinesApi::class)
internal class InvoiceApiImplJs(
	private val invoiceApi: InvoiceApi,
) : InvoiceApiJs {
	override val encrypted: InvoiceFlavouredApiJs<EncryptedInvoiceJs> = object :
			InvoiceFlavouredApiJs<EncryptedInvoiceJs> {
		override fun shareWith(
			delegateId: String,
			invoice: EncryptedInvoiceJs,
			options: dynamic,
		): Promise<EncryptedInvoiceJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
				val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: InvoiceShareOptionsJs? ->
					options?.let { nonNull1 ->
						invoiceShareOptions_fromJs(nonNull1)
					}
				}
				val result = invoiceApi.encrypted.shareWith(
					delegateIdConverted,
					invoiceConverted,
					optionsConverted,
				)
				invoice_toJs(result)
			}
		}

		override fun shareWithMany(invoice: EncryptedInvoiceJs,
				delegates: Record<String, InvoiceShareOptionsJs>): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
			val delegatesConverted: Map<String, InvoiceShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: InvoiceShareOptionsJs ->
					invoiceShareOptions_fromJs(x1)
				},
			)
			val result = invoiceApi.encrypted.shareWithMany(
				invoiceConverted,
				delegatesConverted,
			)
			invoice_toJs(result)
		}

		override fun findInvoicesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = invoiceApi.encrypted.findInvoicesByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun modifyInvoice(entity: EncryptedInvoiceJs): Promise<EncryptedInvoiceJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedInvoice = invoice_fromJs(entity)
			val result = invoiceApi.encrypted.modifyInvoice(
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
			val result = invoiceApi.encrypted.modifyInvoices(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun getInvoice(entityId: String): Promise<EncryptedInvoiceJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = invoiceApi.encrypted.getInvoice(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					invoice_toJs(nonNull1)
				}
			)
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
			val result = invoiceApi.encrypted.getInvoices(
				entityIdsConverted,
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
			val result = invoiceApi.encrypted.reassignInvoice(
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
			val result = invoiceApi.encrypted.mergeTo(
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
			val result = invoiceApi.encrypted.validate(
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
				val result = invoiceApi.encrypted.appendCodes(
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
			val result = invoiceApi.encrypted.removeCodes(
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
				val result = invoiceApi.encrypted.findInvoicesByAuthor(
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

		override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val groupIdConverted: String = groupId
			val result = invoiceApi.encrypted.listInvoicesByHcPartyAndGroupId(
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
				val result = invoiceApi.encrypted.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
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
			val result = invoiceApi.encrypted.listInvoicesByContactIds(
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
			val result = invoiceApi.encrypted.listInvoicesByRecipientsIds(
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
			val result = invoiceApi.encrypted.listToInsurances(
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
			val result = invoiceApi.encrypted.listToInsurancesUnsent(
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
			val result = invoiceApi.encrypted.listToPatients(
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
			val result = invoiceApi.encrypted.listToPatientsUnsent(
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
			val result = invoiceApi.encrypted.listInvoicesByIds(
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
			val result = invoiceApi.encrypted.listInvoicesByHcpartySendingModeStatusDate(
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
			val result = invoiceApi.encrypted.listInvoicesByServiceIds(
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
				val result = invoiceApi.encrypted.listAllHcpsByStatus(
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

	override val tryAndRecover: InvoiceFlavouredApiJs<InvoiceJs> = object :
			InvoiceFlavouredApiJs<InvoiceJs> {
		override fun shareWith(
			delegateId: String,
			invoice: InvoiceJs,
			options: dynamic,
		): Promise<InvoiceJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val invoiceConverted: Invoice = invoice_fromJs(invoice)
				val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: InvoiceShareOptionsJs? ->
					options?.let { nonNull1 ->
						invoiceShareOptions_fromJs(nonNull1)
					}
				}
				val result = invoiceApi.tryAndRecover.shareWith(
					delegateIdConverted,
					invoiceConverted,
					optionsConverted,
				)
				invoice_toJs(result)
			}
		}

		override fun shareWithMany(invoice: InvoiceJs, delegates: Record<String, InvoiceShareOptionsJs>):
				Promise<InvoiceJs> = GlobalScope.promise {
			val invoiceConverted: Invoice = invoice_fromJs(invoice)
			val delegatesConverted: Map<String, InvoiceShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: InvoiceShareOptionsJs ->
					invoiceShareOptions_fromJs(x1)
				},
			)
			val result = invoiceApi.tryAndRecover.shareWithMany(
				invoiceConverted,
				delegatesConverted,
			)
			invoice_toJs(result)
		}

		override fun findInvoicesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
				}
				val result = invoiceApi.tryAndRecover.findInvoicesByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun modifyInvoice(entity: InvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
			val entityConverted: Invoice = invoice_fromJs(entity)
			val result = invoiceApi.tryAndRecover.modifyInvoice(
				entityConverted,
			)
			invoice_toJs(result)
		}

		override fun modifyInvoices(entities: Array<InvoiceJs>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Invoice> = arrayToList(
				entities,
				"entities",
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.tryAndRecover.modifyInvoices(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun getInvoice(entityId: String): Promise<InvoiceJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = invoiceApi.tryAndRecover.getInvoice(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					invoice_toJs(nonNull1)
				}
			)
		}

		override fun getInvoices(entityIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.getInvoices(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun reassignInvoice(invoice: InvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
			val invoiceConverted: Invoice = invoice_fromJs(invoice)
			val result = invoiceApi.tryAndRecover.reassignInvoice(
				invoiceConverted,
			)
			invoice_toJs(result)
		}

		override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<InvoiceJs> =
				GlobalScope.promise {
			val invoiceIdConverted: String = invoiceId
			val idsConverted: List<String> = arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.mergeTo(
				invoiceIdConverted,
				idsConverted,
			)
			invoice_toJs(result)
		}

		override fun validate(
			invoiceId: String,
			scheme: String,
			forcedValue: String,
		): Promise<InvoiceJs> = GlobalScope.promise {
			val invoiceIdConverted: String = invoiceId
			val schemeConverted: String = scheme
			val forcedValueConverted: String = forcedValue
			val result = invoiceApi.tryAndRecover.validate(
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
		): Promise<Array<InvoiceJs>> {
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
				val result = invoiceApi.tryAndRecover.appendCodes(
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
					{ x1: Invoice ->
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
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
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
			val result = invoiceApi.tryAndRecover.removeCodes(
				userIdConverted,
				serviceIdConverted,
				secretFKeysConverted,
				tarificationIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun findInvoicesByAuthor(hcPartyId: String, options: dynamic):
				Promise<PaginatedListJs<InvoiceJs>> {
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
				val result = invoiceApi.tryAndRecover.findInvoicesByAuthor(
					hcPartyIdConverted,
					fromDateConverted,
					toDateConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
				Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val groupIdConverted: String = groupId
			val result = invoiceApi.tryAndRecover.listInvoicesByHcPartyAndGroupId(
				hcPartyIdConverted,
				groupIdConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
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
		): Promise<Array<InvoiceJs>> {
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
				val result = invoiceApi.tryAndRecover.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
					hcPartyIdConverted,
					sentMediumTypeConverted,
					invoiceTypeConverted,
					sentConverted,
					fromConverted,
					toConverted,
				)
				listToArray(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun listInvoicesByContactIds(contactIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val contactIdsConverted: List<String> = arrayToList(
				contactIds,
				"contactIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByContactIds(
				contactIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>): Promise<Array<InvoiceJs>>
				= GlobalScope.promise {
			val recipientsIdsConverted: List<String> = arrayToList(
				recipientsIds,
				"recipientsIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByRecipientsIds(
				recipientsIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToInsurances(userIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val userIdsConverted: List<String> = arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listToInsurances(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val userIdsConverted: List<String> = arrayToList(
				userIds,
				"userIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listToInsurancesUnsent(
				userIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToPatients(hcPartyId: String): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val result = invoiceApi.tryAndRecover.listToPatients(
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val hcPartyIdConverted: String? = undefinedToNull(hcPartyId)
			val result = invoiceApi.tryAndRecover.listToPatientsUnsent(
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByIds(ids: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val idsConverted: List<String> = arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByIds(
				idsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
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
		): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sendingModeConverted: String = sendingMode
			val statusConverted: String = status
			val fromConverted: Long = numberToLong(from, "from")
			val toConverted: Long = numberToLong(to, "to")
			val result = invoiceApi.tryAndRecover.listInvoicesByHcpartySendingModeStatusDate(
				hcPartyIdConverted,
				sendingModeConverted,
				statusConverted,
				fromConverted,
				toConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listInvoicesByServiceIds(serviceIds: Array<String>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val serviceIdsConverted: List<String> = arrayToList(
				serviceIds,
				"serviceIds",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByServiceIds(
				serviceIdsConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun listAllHcpsByStatus(
			status: String,
			hcpIds: Array<String>,
			options: dynamic,
		): Promise<Array<InvoiceJs>> {
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
				val result = invoiceApi.tryAndRecover.listAllHcpsByStatus(
					statusConverted,
					fromConverted,
					toConverted,
					hcpIdsConverted,
				)
				listToArray(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}
	}

	override fun createInvoice(entity: DecryptedInvoiceJs, prefix: String?):
			Promise<DecryptedInvoiceJs> = GlobalScope.promise {
		val entityConverted: DecryptedInvoice = invoice_fromJs(entity)
		val prefixConverted: String? = undefinedToNull(prefix)
		val result = invoiceApi.createInvoice(
			entityConverted,
			prefixConverted,
		)
		invoice_toJs(result)
	}

	override fun createInvoices(entities: Array<DecryptedInvoiceJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedInvoice> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedInvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceApi.createInvoices(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun withEncryptionMetadata(
		base: DecryptedInvoiceJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedInvoiceJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedInvoice? = base?.let { nonNull1 ->
				invoice_fromJs(nonNull1)
			}
			val patientConverted: Patient? = patient?.let { nonNull1 ->
				patient_fromJs(nonNull1)
			}
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"delegates",
				emptyMap()
			) { delegates: Record<String, String> ->
				objectToMap(
					delegates,
					"delegates",
					{ x1: String ->
						x1
					},
					{ x1: String ->
						AccessLevel.valueOf(x1)
					},
				)
			}
			val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
			) { secretId: SecretIdUseOptionJs ->
				secretIdUseOption_fromJs(secretId)
			}
			val alternateRootDelegateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"alternateRootDelegateId",
				null
			) { alternateRootDelegateId: String? ->
				undefinedToNull(alternateRootDelegateId)
			}
			val result = invoiceApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDelegateIdConverted,
			)
			invoice_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(invoice: InvoiceJs): Promise<Array<String>> =
			GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		val result = invoiceApi.getEncryptionKeysOf(
			invoiceConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(invoice: InvoiceJs): Promise<Boolean> = GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		val result = invoiceApi.hasWriteAccess(
			invoiceConverted,
		)
		result
	}

	override fun decryptPatientIdOf(invoice: InvoiceJs): Promise<Array<String>> = GlobalScope.promise {
		val invoiceConverted: Invoice = invoice_fromJs(invoice)
		val result = invoiceApi.decryptPatientIdOf(
			invoiceConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: InvoiceJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Invoice = invoice_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		invoiceApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(invoice: EncryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
		val result = invoiceApi.decrypt(
			invoiceConverted,
		)
		invoice_toJs(result)
	}

	override fun tryDecrypt(invoice: EncryptedInvoiceJs): Promise<InvoiceJs> = GlobalScope.promise {
		val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
		val result = invoiceApi.tryDecrypt(
			invoiceConverted,
		)
		invoice_toJs(result)
	}

	override fun deleteInvoice(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = invoiceApi.deleteInvoice(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun getTarificationsCodesOccurrences(minOccurrence: Double):
			Promise<Array<LabelledOccurenceJs>> = GlobalScope.promise {
		val minOccurrenceConverted: Int = numberToInt(minOccurrence, "minOccurrence")
		val result = invoiceApi.getTarificationsCodesOccurrences(
			minOccurrenceConverted,
		)
		listToArray(
			result,
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		invoice: DecryptedInvoiceJs,
		options: dynamic,
	): Promise<DecryptedInvoiceJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val invoiceConverted: DecryptedInvoice = invoice_fromJs(invoice)
			val optionsConverted: InvoiceShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: InvoiceShareOptionsJs? ->
				options?.let { nonNull1 ->
					invoiceShareOptions_fromJs(nonNull1)
				}
			}
			val result = invoiceApi.shareWith(
				delegateIdConverted,
				invoiceConverted,
				optionsConverted,
			)
			invoice_toJs(result)
		}
	}

	override fun shareWithMany(invoice: DecryptedInvoiceJs,
			delegates: Record<String, InvoiceShareOptionsJs>): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceConverted: DecryptedInvoice = invoice_fromJs(invoice)
		val delegatesConverted: Map<String, InvoiceShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: InvoiceShareOptionsJs ->
				invoiceShareOptions_fromJs(x1)
			},
		)
		val result = invoiceApi.shareWithMany(
			invoiceConverted,
			delegatesConverted,
		)
		invoice_toJs(result)
	}

	override fun findInvoicesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startDate",
				null
			) { startDate: Double? ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"endDate",
				null
			) { endDate: Double? ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"descending",
				null
			) { descending: Boolean? ->
				undefinedToNull(descending)
			}
			val result = invoiceApi.findInvoicesByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun modifyInvoice(entity: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedInvoice = invoice_fromJs(entity)
		val result = invoiceApi.modifyInvoice(
			entityConverted,
		)
		invoice_toJs(result)
	}

	override fun modifyInvoices(entities: Array<DecryptedInvoiceJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedInvoice> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedInvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceApi.modifyInvoices(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun getInvoice(entityId: String): Promise<DecryptedInvoiceJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = invoiceApi.getInvoice(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				invoice_toJs(nonNull1)
			}
		)
	}

	override fun getInvoices(entityIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.getInvoices(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun reassignInvoice(invoice: DecryptedInvoiceJs): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceConverted: DecryptedInvoice = invoice_fromJs(invoice)
		val result = invoiceApi.reassignInvoice(
			invoiceConverted,
		)
		invoice_toJs(result)
	}

	override fun mergeTo(invoiceId: String, ids: Array<String>): Promise<DecryptedInvoiceJs> =
			GlobalScope.promise {
		val invoiceIdConverted: String = invoiceId
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.mergeTo(
			invoiceIdConverted,
			idsConverted,
		)
		invoice_toJs(result)
	}

	override fun validate(
		invoiceId: String,
		scheme: String,
		forcedValue: String,
	): Promise<DecryptedInvoiceJs> = GlobalScope.promise {
		val invoiceIdConverted: String = invoiceId
		val schemeConverted: String = scheme
		val forcedValueConverted: String = forcedValue
		val result = invoiceApi.validate(
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
	): Promise<Array<DecryptedInvoiceJs>> {
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
			val result = invoiceApi.appendCodes(
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
				{ x1: DecryptedInvoice ->
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
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
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
		val result = invoiceApi.removeCodes(
			userIdConverted,
			serviceIdConverted,
			secretFKeysConverted,
			tarificationIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun findInvoicesByAuthor(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedInvoiceJs>> {
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
			val result = invoiceApi.findInvoicesByAuthor(
				hcPartyIdConverted,
				fromDateConverted,
				toDateConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun listInvoicesByHcPartyAndGroupId(hcPartyId: String, groupId: String):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val groupIdConverted: String = groupId
		val result = invoiceApi.listInvoicesByHcPartyAndGroupId(
			hcPartyIdConverted,
			groupIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
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
	): Promise<Array<DecryptedInvoiceJs>> {
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
			val result = invoiceApi.listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate(
				hcPartyIdConverted,
				sentMediumTypeConverted,
				invoiceTypeConverted,
				sentConverted,
				fromConverted,
				toConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun listInvoicesByContactIds(contactIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val contactIdsConverted: List<String> = arrayToList(
			contactIds,
			"contactIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByContactIds(
			contactIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByRecipientsIds(recipientsIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val recipientsIdsConverted: List<String> = arrayToList(
			recipientsIds,
			"recipientsIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByRecipientsIds(
			recipientsIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToInsurances(userIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listToInsurances(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToInsurancesUnsent(userIds: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val userIdsConverted: List<String> = arrayToList(
			userIds,
			"userIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listToInsurancesUnsent(
			userIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToPatients(hcPartyId: String): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val result = invoiceApi.listToPatients(
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listToPatientsUnsent(hcPartyId: String?): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val hcPartyIdConverted: String? = undefinedToNull(hcPartyId)
		val result = invoiceApi.listToPatientsUnsent(
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByIds(ids: Array<String>): Promise<Array<DecryptedInvoiceJs>> =
			GlobalScope.promise {
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByIds(
			idsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
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
	): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val sendingModeConverted: String = sendingMode
		val statusConverted: String = status
		val fromConverted: Long = numberToLong(from, "from")
		val toConverted: Long = numberToLong(to, "to")
		val result = invoiceApi.listInvoicesByHcpartySendingModeStatusDate(
			hcPartyIdConverted,
			sendingModeConverted,
			statusConverted,
			fromConverted,
			toConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listInvoicesByServiceIds(serviceIds: Array<String>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val serviceIdsConverted: List<String> = arrayToList(
			serviceIds,
			"serviceIds",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByServiceIds(
			serviceIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun listAllHcpsByStatus(
		status: String,
		hcpIds: Array<String>,
		options: dynamic,
	): Promise<Array<DecryptedInvoiceJs>> {
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
			val result = invoiceApi.listAllHcpsByStatus(
				statusConverted,
				fromConverted,
				toConverted,
				hcpIdsConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}
}
