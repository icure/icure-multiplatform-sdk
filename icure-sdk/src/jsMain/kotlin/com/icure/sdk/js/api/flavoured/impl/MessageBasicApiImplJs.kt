// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MessageBasicApi
import com.icure.sdk.js.api.flavoured.MessageBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.EncryptedMessageJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.message_fromJs
import com.icure.sdk.js.model.message_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.couchdb.DocIdentifier
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
public class MessageBasicApiImplJs private constructor(
	private val messageBasicApi: MessageBasicApi,
) : MessageBasicApiJs {
	override fun matchMessagesBy(filter: AbstractFilterJs<EncryptedMessageJs>): Promise<Array<String>>
			= GlobalScope.promise {
		listToArray(
			messageBasicApi.matchMessagesBy(abstractFilter_fromJs(
				filter,
				{ x1: EncryptedMessageJs ->
					message_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun deleteMessage(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(messageBasicApi.deleteMessage(entityId))}


	override fun deleteMessages(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			messageBasicApi.deleteMessages(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
			GlobalScope.promise {
		message_toJs(messageBasicApi.modifyMessage(com.icure.sdk.js.model.message_fromJs(entity)))}


	override fun getMessage(entityId: String): Promise<EncryptedMessageJs> = GlobalScope.promise {
		message_toJs(messageBasicApi.getMessage(entityId))}


	override fun getMessages(entityIds: Array<String>): Promise<Array<EncryptedMessageJs>> =
			GlobalScope.promise {
		listToArray(
			messageBasicApi.getMessages(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun filterMessagesBy(
		filterChain: FilterChainJs<EncryptedMessageJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
		paginatedList_toJs(
			messageBasicApi.filterMessagesBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.EncryptedMessageJs ->
			    com.icure.sdk.js.model.message_fromJs(x1)
			  },
			), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
			Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
		listToArray(
			messageBasicApi.listMessagesByTransportGuids(hcPartyId, arrayToList(
				transportGuids,
				"transportGuids",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
			Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
		listToArray(
			messageBasicApi.findMessagesByHCPartyPatientForeignKeys(arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun findMessages(
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
		paginatedList_toJs(
			messageBasicApi.findMessages(com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey,
					"startKey"), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
					"limit")),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun getChildrenMessages(messageId: String): Promise<Array<EncryptedMessageJs>> =
			GlobalScope.promise {
		listToArray(
			messageBasicApi.getChildrenMessages(messageId),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun getMessagesChildren(messageIds: Array<String>): Promise<Array<EncryptedMessageJs>> =
			GlobalScope.promise {
		listToArray(
			messageBasicApi.getMessagesChildren(arrayToList(
				messageIds,
				"messageIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun listMessagesByInvoices(invoiceIds: Array<String>): Promise<Array<EncryptedMessageJs>>
			= GlobalScope.promise {
		listToArray(
			messageBasicApi.listMessagesByInvoices(arrayToList(
				invoiceIds,
				"invoiceIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun findMessagesByTransportGuid(transportGuid: String):
			Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
		paginatedList_toJs(
			messageBasicApi.findMessagesByTransportGuid(transportGuid),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Double,
		to: Double,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
		hcpId: String?,
	): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
		paginatedList_toJs(
			messageBasicApi.findMessagesByTransportGuidSentDate(transportGuid,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(from, "from"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(to, "to"),
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"), hcpId),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun findMessagesByToAddress(
		toAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
		paginatedList_toJs(
			messageBasicApi.findMessagesByToAddress(toAddress,
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>> = GlobalScope.promise {
		paginatedList_toJs(
			messageBasicApi.findMessagesByFromAddress(fromAddress,
					com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double):
			Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
		listToArray(
			messageBasicApi.setMessagesStatusBits(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			), numberToInt(statusBits, "statusBits")),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String,
	): Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
		listToArray(
			messageBasicApi.setMessagesReadStatus(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			), numberToLong(time, "time"), readStatus, userId),
			{ x1: EncryptedMessage ->
				message_toJs(x1)
			},
		)}

}
