// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.MessageApi
import com.icure.cardinal.sdk.crypto.entities.MessageShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.MessageApiJs
import com.icure.cardinal.sdk.js.api.MessageFlavouredApiJs
import com.icure.cardinal.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.messageShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
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
import com.icure.cardinal.sdk.js.model.DecryptedMessageJs
import com.icure.cardinal.sdk.js.model.EncryptedMessageJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.message_fromJs
import com.icure.cardinal.sdk.js.model.message_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedMessage
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
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
internal class MessageApiImplJs(
	private val messageApi: MessageApi,
) : MessageApiJs {
	override val encrypted: MessageFlavouredApiJs<EncryptedMessageJs> = object :
			MessageFlavouredApiJs<EncryptedMessageJs> {
		override fun shareWith(
			delegateId: String,
			message: EncryptedMessageJs,
			options: dynamic,
		): Promise<EncryptedMessageJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val messageConverted: EncryptedMessage = message_fromJs(message)
				val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MessageShareOptionsJs? ->
					options?.let { nonNull1 ->
						messageShareOptions_fromJs(nonNull1)
					}
				}
				val result = messageApi.encrypted.shareWith(
					delegateIdConverted,
					messageConverted,
					optionsConverted,
				)
				message_toJs(result)
			}
		}

		override fun shareWithMany(message: EncryptedMessageJs,
				delegates: Record<String, MessageShareOptionsJs>): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val messageConverted: EncryptedMessage = message_fromJs(message)
			val delegatesConverted: Map<String, MessageShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MessageShareOptionsJs ->
					messageShareOptions_fromJs(x1)
				},
			)
			val result = messageApi.encrypted.shareWithMany(
				messageConverted,
				delegatesConverted,
			)
			message_toJs(result)
		}

		override fun findMessagesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedMessageJs>> {
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
				val result = messageApi.encrypted.findMessagesByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedMessage ->
						message_toJs(x1)
					},
				)
			}
		}

		override fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
			val result = messageApi.encrypted.filterMessagesBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
			val result = messageApi.encrypted.filterMessagesBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun createMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedMessage = message_fromJs(entity)
			val result = messageApi.encrypted.createMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun createMessageInTopic(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedMessage = message_fromJs(entity)
			val result = messageApi.encrypted.createMessageInTopic(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessage(message: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val messageConverted: Message = message_fromJs(message)
			val result = messageApi.encrypted.undeleteMessage(
				messageConverted,
			)
			message_toJs(result)
		}

		override fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedMessage = message_fromJs(entity)
			val result = messageApi.encrypted.modifyMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessageById(id: String, rev: String): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = messageApi.encrypted.undeleteMessageById(
				idConverted,
				revConverted,
			)
			message_toJs(result)
		}

		override fun getMessage(entityId: String): Promise<EncryptedMessageJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = messageApi.encrypted.getMessage(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					message_toJs(nonNull1)
				}
			)
		}

		override fun getMessages(entityIds: Array<String>): Promise<Array<EncryptedMessageJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.encrypted.getMessages(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
				Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val transportGuidsConverted: List<String> = arrayToList(
				transportGuids,
				"transportGuids",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.encrypted.listMessagesByTransportGuids(
				hcPartyIdConverted,
				transportGuidsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun findMessages(
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
			val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = messageApi.encrypted.findMessages(
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun getChildrenMessages(messageId: String): Promise<Array<EncryptedMessageJs>> =
				GlobalScope.promise {
			val messageIdConverted: String = messageId
			val result = messageApi.encrypted.getChildrenMessages(
				messageIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun getMessagesChildren(messageIds: Array<String>): Promise<Array<EncryptedMessageJs>> =
				GlobalScope.promise {
			val messageIdsConverted: List<String> = arrayToList(
				messageIds,
				"messageIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.encrypted.getMessagesChildren(
				messageIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun listMessagesByInvoices(invoiceIds: Array<String>): Promise<Array<EncryptedMessageJs>>
				= GlobalScope.promise {
			val invoiceIdsConverted: List<String> = arrayToList(
				invoiceIds,
				"invoiceIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.encrypted.listMessagesByInvoices(
				invoiceIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun findMessagesByTransportGuid(transportGuid: String):
				Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
			val transportGuidConverted: String = transportGuid
			val result = messageApi.encrypted.findMessagesByTransportGuid(
				transportGuidConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun findMessagesByTransportGuidSentDate(
			transportGuid: String,
			from: Double,
			to: Double,
			options: dynamic,
		): Promise<PaginatedListJs<EncryptedMessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val transportGuidConverted: String = transportGuid
				val fromConverted: Long = numberToLong(from, "from")
				val toConverted: Long = numberToLong(to, "to")
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
				val hcpIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"hcpId",
					null
				) { hcpId: String? ->
					undefinedToNull(hcpId)
				}
				val result = messageApi.encrypted.findMessagesByTransportGuidSentDate(
					transportGuidConverted,
					fromConverted,
					toConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					hcpIdConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: EncryptedMessage ->
						message_toJs(x1)
					},
				)
			}
		}

		override fun findMessagesByToAddress(
			toAddress: String,
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
			val toAddressConverted: String = toAddress
			val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = messageApi.encrypted.findMessagesByToAddress(
				toAddressConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun findMessagesByFromAddress(
			fromAddress: String,
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
			val fromAddressConverted: String = fromAddress
			val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = messageApi.encrypted.findMessagesByFromAddress(
				fromAddressConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double):
				Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val statusBitsConverted: Int = numberToInt(statusBits, "statusBits")
			val result = messageApi.encrypted.setMessagesStatusBits(
				entityIdsConverted,
				statusBitsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}

		override fun setMessagesReadStatus(
			entityIds: Array<String>,
			time: Double?,
			readStatus: Boolean,
			userId: String?,
		): Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val timeConverted: Long? = numberToLong(time, "time")
			val readStatusConverted: Boolean = readStatus
			val userIdConverted: String? = undefinedToNull(userId)
			val result = messageApi.encrypted.setMessagesReadStatus(
				entityIdsConverted,
				timeConverted,
				readStatusConverted,
				userIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: MessageFlavouredApiJs<MessageJs> = object :
			MessageFlavouredApiJs<MessageJs> {
		override fun shareWith(
			delegateId: String,
			message: MessageJs,
			options: dynamic,
		): Promise<MessageJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val messageConverted: Message = message_fromJs(message)
				val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MessageShareOptionsJs? ->
					options?.let { nonNull1 ->
						messageShareOptions_fromJs(nonNull1)
					}
				}
				val result = messageApi.tryAndRecover.shareWith(
					delegateIdConverted,
					messageConverted,
					optionsConverted,
				)
				message_toJs(result)
			}
		}

		override fun shareWithMany(message: MessageJs, delegates: Record<String, MessageShareOptionsJs>):
				Promise<MessageJs> = GlobalScope.promise {
			val messageConverted: Message = message_fromJs(message)
			val delegatesConverted: Map<String, MessageShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MessageShareOptionsJs ->
					messageShareOptions_fromJs(x1)
				},
			)
			val result = messageApi.tryAndRecover.shareWithMany(
				messageConverted,
				delegatesConverted,
			)
			message_toJs(result)
		}

		override fun findMessagesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<MessageJs>> {
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
				val result = messageApi.tryAndRecover.findMessagesByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: Message ->
						message_toJs(x1)
					},
				)
			}
		}

		override fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<MessageJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
			val result = messageApi.tryAndRecover.filterMessagesBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
				Promise<PaginatedListIteratorJs<MessageJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
			val result = messageApi.tryAndRecover.filterMessagesBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun createMessage(entity: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val entityConverted: Message = message_fromJs(entity)
			val result = messageApi.tryAndRecover.createMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun createMessageInTopic(entity: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val entityConverted: Message = message_fromJs(entity)
			val result = messageApi.tryAndRecover.createMessageInTopic(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessage(message: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val messageConverted: Message = message_fromJs(message)
			val result = messageApi.tryAndRecover.undeleteMessage(
				messageConverted,
			)
			message_toJs(result)
		}

		override fun modifyMessage(entity: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val entityConverted: Message = message_fromJs(entity)
			val result = messageApi.tryAndRecover.modifyMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun undeleteMessageById(id: String, rev: String): Promise<MessageJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = messageApi.tryAndRecover.undeleteMessageById(
				idConverted,
				revConverted,
			)
			message_toJs(result)
		}

		override fun getMessage(entityId: String): Promise<MessageJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = messageApi.tryAndRecover.getMessage(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					message_toJs(nonNull1)
				}
			)
		}

		override fun getMessages(entityIds: Array<String>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.tryAndRecover.getMessages(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
				Promise<Array<MessageJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val transportGuidsConverted: List<String> = arrayToList(
				transportGuids,
				"transportGuids",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.tryAndRecover.listMessagesByTransportGuids(
				hcPartyIdConverted,
				transportGuidsConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun findMessages(
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = messageApi.tryAndRecover.findMessages(
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun getChildrenMessages(messageId: String): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			val messageIdConverted: String = messageId
			val result = messageApi.tryAndRecover.getChildrenMessages(
				messageIdConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun getMessagesChildren(messageIds: Array<String>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			val messageIdsConverted: List<String> = arrayToList(
				messageIds,
				"messageIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.tryAndRecover.getMessagesChildren(
				messageIdsConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun listMessagesByInvoices(invoiceIds: Array<String>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			val invoiceIdsConverted: List<String> = arrayToList(
				invoiceIds,
				"invoiceIds",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.tryAndRecover.listMessagesByInvoices(
				invoiceIdsConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun findMessagesByTransportGuid(transportGuid: String):
				Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			val transportGuidConverted: String = transportGuid
			val result = messageApi.tryAndRecover.findMessagesByTransportGuid(
				transportGuidConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun findMessagesByTransportGuidSentDate(
			transportGuid: String,
			from: Double,
			to: Double,
			options: dynamic,
		): Promise<PaginatedListJs<MessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val transportGuidConverted: String = transportGuid
				val fromConverted: Long = numberToLong(from, "from")
				val toConverted: Long = numberToLong(to, "to")
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
				val hcpIdConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"hcpId",
					null
				) { hcpId: String? ->
					undefinedToNull(hcpId)
				}
				val result = messageApi.tryAndRecover.findMessagesByTransportGuidSentDate(
					transportGuidConverted,
					fromConverted,
					toConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					hcpIdConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Message ->
						message_toJs(x1)
					},
				)
			}
		}

		override fun findMessagesByToAddress(
			toAddress: String,
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			val toAddressConverted: String = toAddress
			val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = messageApi.tryAndRecover.findMessagesByToAddress(
				toAddressConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun findMessagesByFromAddress(
			fromAddress: String,
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			val fromAddressConverted: String = fromAddress
			val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
			val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = messageApi.tryAndRecover.findMessagesByFromAddress(
				fromAddressConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double):
				Promise<Array<MessageJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val statusBitsConverted: Int = numberToInt(statusBits, "statusBits")
			val result = messageApi.tryAndRecover.setMessagesStatusBits(
				entityIdsConverted,
				statusBitsConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}

		override fun setMessagesReadStatus(
			entityIds: Array<String>,
			time: Double?,
			readStatus: Boolean,
			userId: String?,
		): Promise<Array<MessageJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val timeConverted: Long? = numberToLong(time, "time")
			val readStatusConverted: Boolean = readStatus
			val userIdConverted: String? = undefinedToNull(userId)
			val result = messageApi.tryAndRecover.setMessagesReadStatus(
				entityIdsConverted,
				timeConverted,
				readStatusConverted,
				userIdConverted,
			)
			listToArray(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
		}
	}

	override fun withEncryptionMetadata(
		base: DecryptedMessageJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedMessageJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedMessage? = base?.let { nonNull1 ->
				message_fromJs(nonNull1)
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
			val result = messageApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			message_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(message: MessageJs): Promise<Array<String>> =
			GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.getEncryptionKeysOf(
			messageConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(message: MessageJs): Promise<Boolean> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.hasWriteAccess(
			messageConverted,
		)
		result
	}

	override fun decryptPatientIdOf(message: MessageJs): Promise<Array<String>> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.decryptPatientIdOf(
			messageConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: MessageJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Message = message_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		messageApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(message: EncryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val messageConverted: EncryptedMessage = message_fromJs(message)
		val result = messageApi.decrypt(
			messageConverted,
		)
		message_toJs(result)
	}

	override fun tryDecrypt(message: EncryptedMessageJs): Promise<MessageJs> = GlobalScope.promise {
		val messageConverted: EncryptedMessage = message_fromJs(message)
		val result = messageApi.tryDecrypt(
			messageConverted,
		)
		message_toJs(result)
	}

	override fun matchMessagesBy(filter: FilterOptionsJs<MessageJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
		val result = messageApi.matchMessagesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
		val result = messageApi.matchMessagesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteMessageUnsafe(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageApi.deleteMessageUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMessagesUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = messageApi.deleteMessagesUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteMessageById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = messageApi.deleteMessageById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMessagesByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = messageApi.deleteMessagesByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeMessageById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		messageApi.purgeMessageById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteMessage(message: MessageJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.deleteMessage(
			messageConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMessages(messages: Array<MessageJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val messagesConverted: List<Message> = arrayToList(
			messages,
			"messages",
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val result = messageApi.deleteMessages(
			messagesConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeMessage(message: MessageJs): Promise<Unit> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		messageApi.purgeMessage(
			messageConverted,
		)

	}

	override fun shareWith(
		delegateId: String,
		message: DecryptedMessageJs,
		options: dynamic,
	): Promise<DecryptedMessageJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val messageConverted: DecryptedMessage = message_fromJs(message)
			val optionsConverted: MessageShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: MessageShareOptionsJs? ->
				options?.let { nonNull1 ->
					messageShareOptions_fromJs(nonNull1)
				}
			}
			val result = messageApi.shareWith(
				delegateIdConverted,
				messageConverted,
				optionsConverted,
			)
			message_toJs(result)
		}
	}

	override fun shareWithMany(message: DecryptedMessageJs,
			delegates: Record<String, MessageShareOptionsJs>): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val messageConverted: DecryptedMessage = message_fromJs(message)
		val delegatesConverted: Map<String, MessageShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: MessageShareOptionsJs ->
				messageShareOptions_fromJs(x1)
			},
		)
		val result = messageApi.shareWithMany(
			messageConverted,
			delegatesConverted,
		)
		message_toJs(result)
	}

	override fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedMessageJs>> {
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
			val result = messageApi.findMessagesByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedMessage ->
					message_toJs(x1)
				},
			)
		}
	}

	override fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<DecryptedMessageJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
		val result = messageApi.filterMessagesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<DecryptedMessageJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Message> = sortableFilterOptions_fromJs(filter)
		val result = messageApi.filterMessagesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun createMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.createMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun createMessageInTopic(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.createMessageInTopic(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun undeleteMessage(message: MessageJs): Promise<MessageJs> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageApi.undeleteMessage(
			messageConverted,
		)
		message_toJs(result)
	}

	override fun modifyMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.modifyMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun undeleteMessageById(id: String, rev: String): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = messageApi.undeleteMessageById(
			idConverted,
			revConverted,
		)
		message_toJs(result)
	}

	override fun getMessage(entityId: String): Promise<DecryptedMessageJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageApi.getMessage(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				message_toJs(nonNull1)
			}
		)
	}

	override fun getMessages(entityIds: Array<String>): Promise<Array<DecryptedMessageJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = messageApi.getMessages(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
			Promise<Array<DecryptedMessageJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val transportGuidsConverted: List<String> = arrayToList(
			transportGuids,
			"transportGuids",
			{ x1: String ->
				x1
			},
		)
		val result = messageApi.listMessagesByTransportGuids(
			hcPartyIdConverted,
			transportGuidsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun findMessages(
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedMessageJs>> = GlobalScope.promise {
		val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = messageApi.findMessages(
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun getChildrenMessages(messageId: String): Promise<Array<DecryptedMessageJs>> =
			GlobalScope.promise {
		val messageIdConverted: String = messageId
		val result = messageApi.getChildrenMessages(
			messageIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun getMessagesChildren(messageIds: Array<String>): Promise<Array<DecryptedMessageJs>> =
			GlobalScope.promise {
		val messageIdsConverted: List<String> = arrayToList(
			messageIds,
			"messageIds",
			{ x1: String ->
				x1
			},
		)
		val result = messageApi.getMessagesChildren(
			messageIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun listMessagesByInvoices(invoiceIds: Array<String>): Promise<Array<DecryptedMessageJs>>
			= GlobalScope.promise {
		val invoiceIdsConverted: List<String> = arrayToList(
			invoiceIds,
			"invoiceIds",
			{ x1: String ->
				x1
			},
		)
		val result = messageApi.listMessagesByInvoices(
			invoiceIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun findMessagesByTransportGuid(transportGuid: String):
			Promise<PaginatedListJs<DecryptedMessageJs>> = GlobalScope.promise {
		val transportGuidConverted: String = transportGuid
		val result = messageApi.findMessagesByTransportGuid(
			transportGuidConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Double,
		to: Double,
		options: dynamic,
	): Promise<PaginatedListJs<DecryptedMessageJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val transportGuidConverted: String = transportGuid
			val fromConverted: Long = numberToLong(from, "from")
			val toConverted: Long = numberToLong(to, "to")
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
			val hcpIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"hcpId",
				null
			) { hcpId: String? ->
				undefinedToNull(hcpId)
			}
			val result = messageApi.findMessagesByTransportGuidSentDate(
				transportGuidConverted,
				fromConverted,
				toConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				hcpIdConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedMessage ->
					message_toJs(x1)
				},
			)
		}
	}

	override fun findMessagesByToAddress(
		toAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedMessageJs>> = GlobalScope.promise {
		val toAddressConverted: String = toAddress
		val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = messageApi.findMessagesByToAddress(
			toAddressConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedMessageJs>> = GlobalScope.promise {
		val fromAddressConverted: String = fromAddress
		val startKeyConverted: JsonElement? = dynamicToJsonNullsafe(startKey, "startKey")
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = messageApi.findMessagesByFromAddress(
			fromAddressConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double):
			Promise<Array<DecryptedMessageJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val statusBitsConverted: Int = numberToInt(statusBits, "statusBits")
		val result = messageApi.setMessagesStatusBits(
			entityIdsConverted,
			statusBitsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String?,
	): Promise<Array<DecryptedMessageJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val timeConverted: Long? = numberToLong(time, "time")
		val readStatusConverted: Boolean = readStatus
		val userIdConverted: String? = undefinedToNull(userId)
		val result = messageApi.setMessagesReadStatus(
			entityIdsConverted,
			timeConverted,
			readStatusConverted,
			userIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<MessageJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMessageJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<Message> = filterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = messageApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
		}
	}
}
