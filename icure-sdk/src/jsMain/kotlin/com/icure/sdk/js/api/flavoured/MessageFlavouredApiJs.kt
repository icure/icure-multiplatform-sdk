// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MessageFlavouredApi")
public external interface MessageFlavouredApiJs<E : MessageJs> {
	public fun shareWith(
		delegateId: String,
		message: E,
		shareSecretIds: Array<String>,
		options: MessageFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(message: E, delegates: Record<String, MessageShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(message: E, delegates: Record<String, MessageShareOptionsJs>): Promise<E>

	public fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: MessageFlavouredApi_findMessagesByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun modifyMessage(entity: E): Promise<E>

	public fun getMessage(entityId: String): Promise<E>

	public fun getMessages(entityIds: Array<String>): Promise<Array<E>>

	public fun filterMessagesBy(
		filterChain: FilterChainJs<MessageJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
			Promise<Array<E>>

	public fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
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
		options: MessageFlavouredApi_findMessagesByTransportGuidSentDate_Options?,
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
		userId: String,
	): Promise<Array<E>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MessageJs>,
		eventFired: (E) -> Promise<Unit>,
		options: MessageFlavouredApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface MessageFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface MessageFlavouredApi_findMessagesByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}

public external interface MessageFlavouredApi_findMessagesByTransportGuidSentDate_Options {
	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?

	public val hcpId: String?
}

public external interface MessageFlavouredApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
