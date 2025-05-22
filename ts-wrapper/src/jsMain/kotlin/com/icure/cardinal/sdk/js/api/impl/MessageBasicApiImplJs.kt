// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.MessageBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.MessageBasicApiJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedMessageJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.message_fromJs
import com.icure.cardinal.sdk.js.model.message_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedMessage
import com.icure.cardinal.sdk.model.Message
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
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
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise
import kotlinx.serialization.json.JsonElement

@OptIn(DelicateCoroutinesApi::class)
internal class MessageBasicApiImplJs(
	private val messageBasicApi: MessageBasicApi,
) : MessageBasicApiJs {
	override fun matchMessagesBy(filter: BaseFilterOptionsJs<MessageJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Message> = baseFilterOptions_fromJs(filter)
		val result = messageBasicApi.matchMessagesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMessagesBySorted(filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Message> = baseSortableFilterOptions_fromJs(filter)
		val result = messageBasicApi.matchMessagesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterMessagesBy(filter: BaseFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Message> = baseFilterOptions_fromJs(filter)
		val result = messageBasicApi.filterMessagesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun filterMessagesBySorted(filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Message> = baseSortableFilterOptions_fromJs(filter)
		val result = messageBasicApi.filterMessagesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)
	}

	override fun deleteMessageUnsafe(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageBasicApi.deleteMessageUnsafe(
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
		val result = messageBasicApi.deleteMessagesUnsafe(
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
		val result = messageBasicApi.deleteMessageById(
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
		val result = messageBasicApi.deleteMessagesByIds(
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
		messageBasicApi.purgeMessageById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteMessage(message: MessageJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageBasicApi.deleteMessage(
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
		val result = messageBasicApi.deleteMessages(
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
		messageBasicApi.purgeMessage(
			messageConverted,
		)

	}

	override fun createMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedMessage = message_fromJs(entity)
		val result = messageBasicApi.createMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun createMessageInTopic(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedMessage = message_fromJs(entity)
		val result = messageBasicApi.createMessageInTopic(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun undeleteMessage(message: MessageJs): Promise<MessageJs> = GlobalScope.promise {
		val messageConverted: Message = message_fromJs(message)
		val result = messageBasicApi.undeleteMessage(
			messageConverted,
		)
		message_toJs(result)
	}

	override fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedMessage = message_fromJs(entity)
		val result = messageBasicApi.modifyMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun undeleteMessageById(id: String, rev: String): Promise<EncryptedMessageJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = messageBasicApi.undeleteMessageById(
			idConverted,
			revConverted,
		)
		message_toJs(result)
	}

	override fun getMessage(entityId: String): Promise<EncryptedMessageJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageBasicApi.getMessage(
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
		val result = messageBasicApi.getMessages(
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
		val result = messageBasicApi.listMessagesByTransportGuids(
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
		val result = messageBasicApi.findMessages(
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
		val result = messageBasicApi.getChildrenMessages(
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
		val result = messageBasicApi.getMessagesChildren(
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
		val result = messageBasicApi.listMessagesByInvoices(
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
		val result = messageBasicApi.findMessagesByTransportGuid(
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
			val result = messageBasicApi.findMessagesByTransportGuidSentDate(
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
		val result = messageBasicApi.findMessagesByToAddress(
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
		val result = messageBasicApi.findMessagesByFromAddress(
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
		val result = messageBasicApi.setMessagesStatusBits(
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
		val result = messageBasicApi.setMessagesReadStatus(
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

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<MessageJs>,
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
			val filterConverted: BaseFilterOptions<Message> = baseFilterOptions_fromJs(filter)
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
			val result = messageBasicApi.subscribeToEvents(
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
