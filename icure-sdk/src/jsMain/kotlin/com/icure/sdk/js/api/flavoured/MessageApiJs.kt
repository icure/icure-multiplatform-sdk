// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedMessageJs
import com.icure.sdk.js.model.EncryptedMessageJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
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

@JsName("MessageApi")
public external interface MessageApiJs {
	public val encrypted: MessageFlavouredApiJs<EncryptedMessageJs>

	public val tryAndRecover: MessageFlavouredApiJs<MessageJs>

	public fun createMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs>

	public fun withEncryptionMetadata(
		base: DecryptedMessageJs?,
		patient: PatientJs?,
		options: MessageApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedMessageJs>

	public fun getEncryptionKeysOf(message: MessageJs): Promise<Array<String>>

	public fun hasWriteAccess(message: MessageJs): Promise<Boolean>

	public fun decryptPatientIdOf(message: MessageJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: MessageJs, delegates: Array<String>):
			Promise<Unit>

	public fun createMessageInTopic(entity: DecryptedMessageJs): Promise<DecryptedMessageJs>

	public fun matchMessagesBy(filter: AbstractFilterJs<MessageJs>): Promise<Array<String>>

	public fun deleteMessage(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMessages(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		message: DecryptedMessageJs,
		shareSecretIds: Array<String>,
		options: MessageApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedMessageJs>>

	public fun tryShareWithMany(message: DecryptedMessageJs,
			delegates: Record<String, MessageShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedMessageJs>>

	public fun shareWithMany(message: DecryptedMessageJs,
			delegates: Record<String, MessageShareOptionsJs>): Promise<DecryptedMessageJs>

	public fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: MessageApi_findMessagesByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedMessageJs>>

	public fun modifyMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs>

	public fun getMessage(entityId: String): Promise<DecryptedMessageJs>

	public fun getMessages(entityIds: Array<String>): Promise<Array<DecryptedMessageJs>>

	public fun filterMessagesBy(
		filterChain: FilterChainJs<MessageJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedMessageJs>>

	public fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
			Promise<Array<DecryptedMessageJs>>

	public fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
			Promise<Array<DecryptedMessageJs>>

	public fun findMessages(
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedMessageJs>>

	public fun getChildrenMessages(messageId: String): Promise<Array<DecryptedMessageJs>>

	public fun getMessagesChildren(messageIds: Array<String>): Promise<Array<DecryptedMessageJs>>

	public fun listMessagesByInvoices(invoiceIds: Array<String>): Promise<Array<DecryptedMessageJs>>

	public fun findMessagesByTransportGuid(transportGuid: String):
			Promise<PaginatedListJs<DecryptedMessageJs>>

	public fun findMessagesByTransportGuidSentDate(
		transportGuid: String,
		from: Double,
		to: Double,
		options: MessageApi_findMessagesByTransportGuidSentDate_Options?,
	): Promise<PaginatedListJs<DecryptedMessageJs>>

	public fun findMessagesByToAddress(
		toAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedMessageJs>>

	public fun findMessagesByFromAddress(
		fromAddress: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedMessageJs>>

	public fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double):
			Promise<Array<DecryptedMessageJs>>

	public fun setMessagesReadStatus(
		entityIds: Array<String>,
		time: Double?,
		readStatus: Boolean,
		userId: String,
	): Promise<Array<DecryptedMessageJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MessageJs>,
		eventFired: (DecryptedMessageJs) -> Promise<Unit>,
		options: MessageApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface MessageApi_withEncryptionMetadata_Options {
	public val user: UserJs?

	public val delegates: Record<String, String>

	public val secretId: SecretIdOptionJs
}

public external interface MessageApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface MessageApi_findMessagesByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}

public external interface MessageApi_findMessagesByTransportGuidSentDate_Options {
	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?

	public val hcpId: String?
}

public external interface MessageApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
