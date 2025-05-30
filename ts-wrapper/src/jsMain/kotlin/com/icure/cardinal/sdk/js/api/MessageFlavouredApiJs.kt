// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.MessageJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageFlavouredApi")
public external interface MessageFlavouredApiJs<E : MessageJs> {
	public fun shareWith(
		delegateId: String,
		message: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(message: E, delegates: Record<String, MessageShareOptionsJs>): Promise<E>

	public fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<E>>

	public fun filterMessagesBy(filter: FilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterMessagesBySorted(filter: SortableFilterOptionsJs<MessageJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun createMessage(entity: E): Promise<E>

	public fun createMessageInTopic(entity: E): Promise<E>

	public fun undeleteMessage(message: MessageJs): Promise<MessageJs>

	public fun modifyMessage(entity: E): Promise<E>

	public fun undeleteMessageById(id: String, rev: String): Promise<E>

	public fun getMessage(entityId: String): Promise<E?>

	public fun getMessages(entityIds: Array<String>): Promise<Array<E>>

	public fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
			Promise<Array<E>>

	public fun findMessages(
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun getChildrenMessages(messageId: String): Promise<Array<E>>

	public fun getMessagesChildren(messageIds: Array<String>): Promise<Array<E>>

	public fun listMessagesByInvoices(invoiceIds: Array<String>): Promise<Array<E>>

	public fun findMessagesByTransportGuid(transportGuid: String): Promise<PaginatedListJs<E>>

	public fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Double,
		to: Double,
		options: dynamic,
	): Promise<PaginatedListJs<E>>

	public fun findMessagesByToAddress(
		toAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double): Promise<Array<E>>

	public fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String?,
	): Promise<Array<E>>
}
