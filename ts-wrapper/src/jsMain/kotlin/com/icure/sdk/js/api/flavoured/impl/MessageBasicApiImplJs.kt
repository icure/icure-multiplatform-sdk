// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MessageBasicApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.MessageBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.EncryptedMessageJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.message_fromJs
import com.icure.sdk.js.model.message_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.sdk.js.subscription.entitySubscription_toJs
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.Message
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
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
	override fun matchMessagesBy(filter: AbstractFilterJs<MessageJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Message> = abstractFilter_fromJs(
			filter,
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
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

	override fun deleteMessage(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageBasicApi.deleteMessage(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMessages(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = messageBasicApi.deleteMessages(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MessageJs>,
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
			val filterConverted: AbstractFilter<Message> = abstractFilter_fromJs(
				filter,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
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

	override fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedMessage = message_fromJs(entity)
		val result = messageBasicApi.modifyMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun getMessage(entityId: String): Promise<EncryptedMessageJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageBasicApi.getMessage(
			entityIdConverted,
		)
		message_toJs(result)
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

	override fun filterMessagesBy(
		filterChain: FilterChainJs<MessageJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
		val filterChainConverted: FilterChain<Message> = filterChain_fromJs(
			filterChain,
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = messageBasicApi.filterMessagesBy(
			filterChainConverted,
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

	override fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
			Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = messageBasicApi.findMessagesByHCPartyPatientForeignKeys(
			secretPatientKeysConverted,
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
		userId: String,
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
		val userIdConverted: String = userId
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
}
