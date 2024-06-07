// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.InvoiceApi
import com.icure.sdk.crypto.entities.InvoiceShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.InvoiceApiJs
import com.icure.sdk.js.api.flavoured.InvoiceApi_appendCodes_Options
import com.icure.sdk.js.api.flavoured.InvoiceApi_findInvoicesByAuthor_Options
import com.icure.sdk.js.api.flavoured.InvoiceApi_findInvoicesByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.InvoiceApi_listAllHcpsByStatus_Options
import com.icure.sdk.js.api.flavoured.InvoiceApi_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate_Options
import com.icure.sdk.js.api.flavoured.InvoiceApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.InvoiceApi_withEncryptionMetadata_Options
import com.icure.sdk.js.api.flavoured.InvoiceFlavouredApiJs
import com.icure.sdk.js.api.flavoured.InvoiceFlavouredApi_appendCodes_Options
import com.icure.sdk.js.api.flavoured.InvoiceFlavouredApi_findInvoicesByAuthor_Options
import com.icure.sdk.js.api.flavoured.InvoiceFlavouredApi_findInvoicesByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.InvoiceFlavouredApi_listAllHcpsByStatus_Options
import com.icure.sdk.js.api.flavoured.InvoiceFlavouredApi_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate_Options
import com.icure.sdk.js.api.flavoured.InvoiceFlavouredApi_shareWith_Options
import com.icure.sdk.js.crypto.entities.InvoiceShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.invoiceShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedInvoiceJs
import com.icure.sdk.js.model.EncryptedInvoiceJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.InvoiceJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
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
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedInvoice
import com.icure.sdk.model.EncryptedInvoice
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.Invoice
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.EncryptedInvoicingCode
import com.icure.sdk.model.embed.InvoiceType
import com.icure.sdk.model.embed.MediumType
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
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
			options: InvoiceFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val invoiceConverted: EncryptedInvoice = invoice_fromJs(invoice)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareEncryptionKeys,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareOwningEntityIds,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
					_options.requestedPermission,
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = invoiceApi.encrypted.shareWith(
					delegateIdConverted,
					invoiceConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedInvoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(invoice: EncryptedInvoiceJs,
				delegates: Record<String, InvoiceShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedInvoiceJs>> = GlobalScope.promise {
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
			val result = invoiceApi.encrypted.tryShareWithMany(
				invoiceConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedInvoice ->
					invoice_toJs(x1)
				},
			)
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
			options: InvoiceFlavouredApi_findInvoicesByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefault(
					_options.startDate,
					null
				) { startDate ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefault(
					_options.endDate,
					null
				) { endDate ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefault(
					_options.descending,
					null
				) { descending ->
					descending
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

		override fun getInvoice(entityId: String): Promise<EncryptedInvoiceJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = invoiceApi.encrypted.getInvoice(
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

		override fun filterInvoicesBy(filterChain: FilterChainJs<InvoiceJs>):
				Promise<Array<EncryptedInvoiceJs>> = GlobalScope.promise {
			val filterChainConverted: FilterChain<Invoice> = filterChain_fromJs(
				filterChain,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.encrypted.filterInvoicesBy(
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
			val result = invoiceApi.encrypted.findInvoicesByHcPartyPatientForeignKeys(
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
			options: InvoiceFlavouredApi_appendCodes_Options?,
		): Promise<Array<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdConverted: String = userId
				val typeConverted: String = type
				val sentMediumTypeConverted: String = sentMediumType
				val secretFKeysConverted: String = secretFKeys
				val insuranceIdConverted: String? = convertingOptionOrDefault(
					_options.insuranceId,
					null
				) { insuranceId ->
					insuranceId
				}
				val invoiceIdConverted: String? = convertingOptionOrDefault(
					_options.invoiceId,
					null
				) { invoiceId ->
					invoiceId
				}
				val gracePeriodConverted: Int? = convertingOptionOrDefault(
					_options.gracePeriod,
					null
				) { gracePeriod ->
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

		override fun findInvoicesByAuthor(hcPartyId: String,
				options: InvoiceFlavouredApi_findInvoicesByAuthor_Options?):
				Promise<PaginatedListJs<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val fromDateConverted: Long? = convertingOptionOrDefault(
					_options.fromDate,
					null
				) { fromDate ->
					numberToLong(fromDate, "fromDate")
				}
				val toDateConverted: Long? = convertingOptionOrDefault(
					_options.toDate,
					null
				) { toDate ->
					numberToLong(toDate, "toDate")
				}
				val startKeyConverted: JsonElement? = convertingOptionOrDefault(
					_options.startKey,
					null
				) { startKey ->
					dynamicToJsonNullsafe(startKey, "startKey")
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefault(
					_options.startDocumentId,
					null
				) { startDocumentId ->
					startDocumentId
				}
				val limitConverted: Int? = convertingOptionOrDefault(
					_options.limit,
					null
				) { limit ->
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
			val result = invoiceApi.encrypted.listInvoicesByHCPartyAndPatientForeignKeys(
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
			options: InvoiceFlavouredApi_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate_Options?,
		): Promise<Array<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val sentMediumTypeConverted: MediumType = MediumType.valueOf(sentMediumType)
				val invoiceTypeConverted: InvoiceType = InvoiceType.valueOf(invoiceType)
				val sentConverted: Boolean = sent
				val fromConverted: Long? = convertingOptionOrDefault(
					_options.from,
					null
				) { from ->
					numberToLong(from, "from")
				}
				val toConverted: Long? = convertingOptionOrDefault(
					_options.to,
					null
				) { to ->
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
			val hcPartyIdConverted: String? = hcPartyId
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
			options: InvoiceFlavouredApi_listAllHcpsByStatus_Options?,
		): Promise<Array<EncryptedInvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val statusConverted: String = status
				val fromConverted: Long? = convertingOptionOrDefault(
					_options.from,
					null
				) { from ->
					numberToLong(from, "from")
				}
				val toConverted: Long? = convertingOptionOrDefault(
					_options.to,
					null
				) { to ->
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
			options: InvoiceFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val invoiceConverted: Invoice = invoice_fromJs(invoice)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareEncryptionKeys,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareOwningEntityIds,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
					_options.requestedPermission,
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = invoiceApi.tryAndRecover.shareWith(
					delegateIdConverted,
					invoiceConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Invoice ->
						invoice_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(invoice: InvoiceJs,
				delegates: Record<String, InvoiceShareOptionsJs>): Promise<SimpleShareResultJs<InvoiceJs>> =
				GlobalScope.promise {
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
			val result = invoiceApi.tryAndRecover.tryShareWithMany(
				invoiceConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
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
			options: InvoiceFlavouredApi_findInvoicesByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefault(
					_options.startDate,
					null
				) { startDate ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefault(
					_options.endDate,
					null
				) { endDate ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefault(
					_options.descending,
					null
				) { descending ->
					descending
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

		override fun getInvoice(entityId: String): Promise<InvoiceJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = invoiceApi.tryAndRecover.getInvoice(
				entityIdConverted,
			)
			invoice_toJs(result)
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

		override fun filterInvoicesBy(filterChain: FilterChainJs<InvoiceJs>): Promise<Array<InvoiceJs>> =
				GlobalScope.promise {
			val filterChainConverted: FilterChain<Invoice> = filterChain_fromJs(
				filterChain,
				{ x1: InvoiceJs ->
					invoice_fromJs(x1)
				},
			)
			val result = invoiceApi.tryAndRecover.filterInvoicesBy(
				filterChainConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
		}

		override fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.findInvoicesByHcPartyPatientForeignKeys(
				hcPartyIdConverted,
				secretPatientKeysConverted,
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
			options: InvoiceFlavouredApi_appendCodes_Options?,
		): Promise<Array<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdConverted: String = userId
				val typeConverted: String = type
				val sentMediumTypeConverted: String = sentMediumType
				val secretFKeysConverted: String = secretFKeys
				val insuranceIdConverted: String? = convertingOptionOrDefault(
					_options.insuranceId,
					null
				) { insuranceId ->
					insuranceId
				}
				val invoiceIdConverted: String? = convertingOptionOrDefault(
					_options.invoiceId,
					null
				) { invoiceId ->
					invoiceId
				}
				val gracePeriodConverted: Int? = convertingOptionOrDefault(
					_options.gracePeriod,
					null
				) { gracePeriod ->
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

		override fun findInvoicesByAuthor(hcPartyId: String,
				options: InvoiceFlavouredApi_findInvoicesByAuthor_Options?):
				Promise<PaginatedListJs<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val fromDateConverted: Long? = convertingOptionOrDefault(
					_options.fromDate,
					null
				) { fromDate ->
					numberToLong(fromDate, "fromDate")
				}
				val toDateConverted: Long? = convertingOptionOrDefault(
					_options.toDate,
					null
				) { toDate ->
					numberToLong(toDate, "toDate")
				}
				val startKeyConverted: JsonElement? = convertingOptionOrDefault(
					_options.startKey,
					null
				) { startKey ->
					dynamicToJsonNullsafe(startKey, "startKey")
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefault(
					_options.startDocumentId,
					null
				) { startDocumentId ->
					startDocumentId
				}
				val limitConverted: Int? = convertingOptionOrDefault(
					_options.limit,
					null
				) { limit ->
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

		override fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<InvoiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val result = invoiceApi.tryAndRecover.listInvoicesByHCPartyAndPatientForeignKeys(
				hcPartyIdConverted,
				secretPatientKeysConverted,
			)
			listToArray(
				result,
				{ x1: Invoice ->
					invoice_toJs(x1)
				},
			)
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
			options: InvoiceFlavouredApi_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate_Options?,
		): Promise<Array<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val sentMediumTypeConverted: MediumType = MediumType.valueOf(sentMediumType)
				val invoiceTypeConverted: InvoiceType = InvoiceType.valueOf(invoiceType)
				val sentConverted: Boolean = sent
				val fromConverted: Long? = convertingOptionOrDefault(
					_options.from,
					null
				) { from ->
					numberToLong(from, "from")
				}
				val toConverted: Long? = convertingOptionOrDefault(
					_options.to,
					null
				) { to ->
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
			val hcPartyIdConverted: String? = hcPartyId
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
			options: InvoiceFlavouredApi_listAllHcpsByStatus_Options?,
		): Promise<Array<InvoiceJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val statusConverted: String = status
				val fromConverted: Long? = convertingOptionOrDefault(
					_options.from,
					null
				) { from ->
					numberToLong(from, "from")
				}
				val toConverted: Long? = convertingOptionOrDefault(
					_options.to,
					null
				) { to ->
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
		val prefixConverted: String? = prefix
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
		options: InvoiceApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedInvoiceJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedInvoice? = base?.let { nonNull1 ->
				invoice_fromJs(nonNull1)
			}
			val patientConverted: Patient? = patient?.let { nonNull1 ->
				patient_fromJs(nonNull1)
			}
			val userConverted: User? = convertingOptionOrDefault(
				_options.user,
				null
			) { user ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefault(
				_options.delegates,
				emptyMap()
			) { delegates ->
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
			val secretIdConverted: SecretIdOption = convertingOptionOrDefault(
				_options.secretId,
				com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent
			) { secretId ->
				secretIdOption_fromJs(secretId)
			}
			val result = invoiceApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
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

	override fun deleteInvoice(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = invoiceApi.deleteInvoice(
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
		val result = invoiceApi.findInvoicesDelegationsStubsByHcPartyPatientForeignKeys(
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
		options: InvoiceApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val invoiceConverted: DecryptedInvoice = invoice_fromJs(invoice)
			val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
				_options.shareEncryptionKeys,
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareEncryptionKeys ->
				ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
			}
			val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
				_options.shareOwningEntityIds,
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareOwningEntityIds ->
				ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
			}
			val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
				_options.requestedPermission,
				com.icure.sdk.model.requests.RequestedPermission.MaxWrite
			) { requestedPermission ->
				RequestedPermission.valueOf(requestedPermission)
			}
			val result = invoiceApi.shareWith(
				delegateIdConverted,
				invoiceConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedInvoice ->
					invoice_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(invoice: DecryptedInvoiceJs,
			delegates: Record<String, InvoiceShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedInvoiceJs>> = GlobalScope.promise {
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
		val result = invoiceApi.tryShareWithMany(
			invoiceConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
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
		options: InvoiceApi_findInvoicesByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefault(
				_options.startDate,
				null
			) { startDate ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefault(
				_options.endDate,
				null
			) { endDate ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefault(
				_options.descending,
				null
			) { descending ->
				descending
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

	override fun getInvoice(entityId: String): Promise<DecryptedInvoiceJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = invoiceApi.getInvoice(
			entityIdConverted,
		)
		invoice_toJs(result)
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

	override fun filterInvoicesBy(filterChain: FilterChainJs<InvoiceJs>):
			Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val filterChainConverted: FilterChain<Invoice> = filterChain_fromJs(
			filterChain,
			{ x1: InvoiceJs ->
				invoice_fromJs(x1)
			},
		)
		val result = invoiceApi.filterInvoicesBy(
			filterChainConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
	}

	override fun findInvoicesByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.findInvoicesByHcPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
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
		options: InvoiceApi_appendCodes_Options?,
	): Promise<Array<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val typeConverted: String = type
			val sentMediumTypeConverted: String = sentMediumType
			val secretFKeysConverted: String = secretFKeys
			val insuranceIdConverted: String? = convertingOptionOrDefault(
				_options.insuranceId,
				null
			) { insuranceId ->
				insuranceId
			}
			val invoiceIdConverted: String? = convertingOptionOrDefault(
				_options.invoiceId,
				null
			) { invoiceId ->
				invoiceId
			}
			val gracePeriodConverted: Int? = convertingOptionOrDefault(
				_options.gracePeriod,
				null
			) { gracePeriod ->
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

	override fun findInvoicesByAuthor(hcPartyId: String,
			options: InvoiceApi_findInvoicesByAuthor_Options?):
			Promise<PaginatedListJs<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val fromDateConverted: Long? = convertingOptionOrDefault(
				_options.fromDate,
				null
			) { fromDate ->
				numberToLong(fromDate, "fromDate")
			}
			val toDateConverted: Long? = convertingOptionOrDefault(
				_options.toDate,
				null
			) { toDate ->
				numberToLong(toDate, "toDate")
			}
			val startKeyConverted: JsonElement? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
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

	override fun listInvoicesByHCPartyAndPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedInvoiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = invoiceApi.listInvoicesByHCPartyAndPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedInvoice ->
				invoice_toJs(x1)
			},
		)
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
		options: InvoiceApi_listInvoicesByHcPartySentMediumTypeInvoiceTypeSentDate_Options?,
	): Promise<Array<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sentMediumTypeConverted: MediumType = MediumType.valueOf(sentMediumType)
			val invoiceTypeConverted: InvoiceType = InvoiceType.valueOf(invoiceType)
			val sentConverted: Boolean = sent
			val fromConverted: Long? = convertingOptionOrDefault(
				_options.from,
				null
			) { from ->
				numberToLong(from, "from")
			}
			val toConverted: Long? = convertingOptionOrDefault(
				_options.to,
				null
			) { to ->
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
		val hcPartyIdConverted: String? = hcPartyId
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
		options: InvoiceApi_listAllHcpsByStatus_Options?,
	): Promise<Array<DecryptedInvoiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val statusConverted: String = status
			val fromConverted: Long? = convertingOptionOrDefault(
				_options.from,
				null
			) { from ->
				numberToLong(from, "from")
			}
			val toConverted: Long? = convertingOptionOrDefault(
				_options.to,
				null
			) { to ->
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
