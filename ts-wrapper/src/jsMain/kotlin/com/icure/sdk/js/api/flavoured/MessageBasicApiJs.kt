// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedMessageJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageBasicApi")
public external interface MessageBasicApiJs {
	public fun matchMessagesBy(filter: AbstractFilterJs<MessageJs>): Promise<Array<String>>

	public fun deleteMessage(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMessages(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs>

	public fun getMessage(entityId: String): Promise<EncryptedMessageJs>

	public fun getMessages(entityIds: Array<String>): Promise<Array<EncryptedMessageJs>>

	public fun filterMessagesBy(
		filterChain: FilterChainJs<MessageJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>>

	public fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
			Promise<Array<EncryptedMessageJs>>

	public fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
			Promise<Array<EncryptedMessageJs>>

	public fun findMessages(
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>>

	public fun getChildrenMessages(messageId: String): Promise<Array<EncryptedMessageJs>>

	public fun getMessagesChildren(messageIds: Array<String>): Promise<Array<EncryptedMessageJs>>

	public fun listMessagesByInvoices(invoiceIds: Array<String>): Promise<Array<EncryptedMessageJs>>

	public fun findMessagesByTransportGuid(transportGuid: String):
			Promise<PaginatedListJs<EncryptedMessageJs>>

	public fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Double,
		to: Double,
		options: MessageBasicApi_findMessagesByTransportGuidSentDate_Options?,
	): Promise<PaginatedListJs<EncryptedMessageJs>>

	public fun findMessagesByToAddress(
		toAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>>

	public fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedMessageJs>>

	public fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double):
			Promise<Array<EncryptedMessageJs>>

	public fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String,
	): Promise<Array<EncryptedMessageJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MessageJs>,
		eventFired: (EncryptedMessageJs) -> Promise<Unit>,
		options: MessageBasicApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface MessageBasicApi_findMessagesByTransportGuidSentDate_Options {
	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?

	public val hcpId: String?
}

public external interface MessageBasicApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
