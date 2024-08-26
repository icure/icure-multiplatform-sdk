// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.model.EncryptedMessageJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageBasicApi")
public external interface MessageBasicApiJs {
	public fun matchMessagesBy(filter: BaseFilterOptionsJs<MessageJs>): Promise<Array<String>>

	public fun matchMessagesBySorted(filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<Array<String>>

	public fun filterMessagesBy(filter: BaseFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<EncryptedMessageJs>>

	public fun filterMessagesBySorted(filter: BaseSortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<EncryptedMessageJs>>

	public fun deleteMessage(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMessages(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs>

	public fun getMessage(entityId: String): Promise<EncryptedMessageJs>

	public fun getMessages(entityIds: Array<String>): Promise<Array<EncryptedMessageJs>>

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
		options: dynamic,
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
		userId: String?,
	): Promise<Array<EncryptedMessageJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<MessageJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMessageJs>>
}
