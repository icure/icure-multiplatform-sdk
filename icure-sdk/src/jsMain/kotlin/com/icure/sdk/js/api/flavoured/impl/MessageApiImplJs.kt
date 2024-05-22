// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MessageApi
import com.icure.sdk.js.api.flavoured.MessageApiJs
import com.icure.sdk.js.api.flavoured.MessageFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.DecryptedMessageJs
import com.icure.sdk.js.model.EncryptedMessageJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.message_fromJs
import com.icure.sdk.js.model.message_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.Message
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
public class MessageApiImplJs private constructor(
	private val messageApi: MessageApi,
) : MessageApiJs {
	override val encrypted: MessageFlavouredApiJs<EncryptedMessageJs> = object :
			MessageFlavouredApiJs<EncryptedMessageJs> {
		override fun shareWith(
			delegateId: String,
			message: EncryptedMessageJs,
			shareSecretIds: Array<String>,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedMessageJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				messageApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.message_fromJs(message),
						com.icure.sdk.js.model.CheckedConverters.arrayToSet(
				  shareSecretIds,
				  "shareSecretIds",
				  { x1: kotlin.String ->
				    x1
				  },
				), com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)}


		override fun findMessagesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedMessageJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				messageApi.encrypted.findMessagesByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)}


		override fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			message_toJs(messageApi.encrypted.modifyMessage(com.icure.sdk.js.model.message_fromJs(entity)))}


		override fun getMessage(entityId: String): Promise<EncryptedMessageJs> = GlobalScope.promise {
			message_toJs(messageApi.encrypted.getMessage(entityId))}


		override fun getMessages(entityIds: Array<String>): Promise<Array<EncryptedMessageJs>> =
				GlobalScope.promise {
			listToArray(
				messageApi.encrypted.getMessages(arrayToList(
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
				messageApi.encrypted.filterMessagesBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
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
				messageApi.encrypted.listMessagesByTransportGuids(hcPartyId, arrayToList(
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
				messageApi.encrypted.findMessagesByHCPartyPatientForeignKeys(arrayToList(
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
				messageApi.encrypted.findMessages(com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey,
						"startKey"), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
						"limit")),
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)}


		override fun getChildrenMessages(messageId: String): Promise<Array<EncryptedMessageJs>> =
				GlobalScope.promise {
			listToArray(
				messageApi.encrypted.getChildrenMessages(messageId),
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)}


		override fun getMessagesChildren(messageIds: Array<String>): Promise<Array<EncryptedMessageJs>> =
				GlobalScope.promise {
			listToArray(
				messageApi.encrypted.getMessagesChildren(arrayToList(
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
				messageApi.encrypted.listMessagesByInvoices(arrayToList(
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
				messageApi.encrypted.findMessagesByTransportGuid(transportGuid),
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
				messageApi.encrypted.findMessagesByTransportGuidSentDate(transportGuid,
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
				messageApi.encrypted.findMessagesByToAddress(toAddress,
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
				messageApi.encrypted.findMessagesByFromAddress(fromAddress,
						com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)}


		override fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double):
				Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			listToArray(
				messageApi.encrypted.setMessagesStatusBits(arrayToList(
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
				messageApi.encrypted.setMessagesReadStatus(arrayToList(
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

	override val tryAndRecover: MessageFlavouredApiJs<MessageJs> = object :
			MessageFlavouredApiJs<MessageJs> {
		override fun shareWith(
			delegateId: String,
			message: MessageJs,
			shareSecretIds: Array<String>,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<MessageJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				messageApi.tryAndRecover.shareWith(delegateId, com.icure.sdk.js.model.message_fromJs(message),
						com.icure.sdk.js.model.CheckedConverters.arrayToSet(
				  shareSecretIds,
				  "shareSecretIds",
				  { x1: kotlin.String ->
				    x1
				  },
				), com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun findMessagesByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<MessageJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				messageApi.tryAndRecover.findMessagesByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun modifyMessage(entity: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			message_toJs(messageApi.tryAndRecover.modifyMessage(com.icure.sdk.js.model.message_fromJs(entity)))}


		override fun getMessage(entityId: String): Promise<MessageJs> = GlobalScope.promise {
			message_toJs(messageApi.tryAndRecover.getMessage(entityId))}


		override fun getMessages(entityIds: Array<String>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			listToArray(
				messageApi.tryAndRecover.getMessages(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun filterMessagesBy(
			filterChain: FilterChainJs<EncryptedMessageJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			paginatedList_toJs(
				messageApi.tryAndRecover.filterMessagesBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.EncryptedMessageJs ->
				    com.icure.sdk.js.model.message_fromJs(x1)
				  },
				), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun listMessagesByTransportGuids(hcPartyId: String, transportGuids: Array<String>):
				Promise<Array<MessageJs>> = GlobalScope.promise {
			listToArray(
				messageApi.tryAndRecover.listMessagesByTransportGuids(hcPartyId, arrayToList(
					transportGuids,
					"transportGuids",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
				Promise<Array<MessageJs>> = GlobalScope.promise {
			listToArray(
				messageApi.tryAndRecover.findMessagesByHCPartyPatientForeignKeys(arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun findMessages(
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			paginatedList_toJs(
				messageApi.tryAndRecover.findMessages(com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey,
						"startKey"), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
						"limit")),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun getChildrenMessages(messageId: String): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			listToArray(
				messageApi.tryAndRecover.getChildrenMessages(messageId),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun getMessagesChildren(messageIds: Array<String>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			listToArray(
				messageApi.tryAndRecover.getMessagesChildren(arrayToList(
					messageIds,
					"messageIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun listMessagesByInvoices(invoiceIds: Array<String>): Promise<Array<MessageJs>> =
				GlobalScope.promise {
			listToArray(
				messageApi.tryAndRecover.listMessagesByInvoices(arrayToList(
					invoiceIds,
					"invoiceIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun findMessagesByTransportGuid(transportGuid: String):
				Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			paginatedList_toJs(
				messageApi.tryAndRecover.findMessagesByTransportGuid(transportGuid),
				{ x1: Message ->
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
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			paginatedList_toJs(
				messageApi.tryAndRecover.findMessagesByTransportGuidSentDate(transportGuid,
						com.icure.sdk.js.model.CheckedConverters.numberToLong(from, "from"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(to, "to"),
						com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"), hcpId),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun findMessagesByToAddress(
			toAddress: String,
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			paginatedList_toJs(
				messageApi.tryAndRecover.findMessagesByToAddress(toAddress,
						com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun findMessagesByFromAddress(
			fromAddress: String,
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			paginatedList_toJs(
				messageApi.tryAndRecover.findMessagesByFromAddress(fromAddress,
						com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey, "startKey"),
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun setMessagesStatusBits(entityIds: Array<String>, statusBits: Double):
				Promise<Array<MessageJs>> = GlobalScope.promise {
			listToArray(
				messageApi.tryAndRecover.setMessagesStatusBits(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				), numberToInt(statusBits, "statusBits")),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}


		override fun setMessagesReadStatus(
			entityIds: Array<String>,
			time: Double?,
			readStatus: Boolean,
			userId: String,
		): Promise<Array<MessageJs>> = GlobalScope.promise {
			listToArray(
				messageApi.tryAndRecover.setMessagesReadStatus(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				), numberToLong(time, "time"), readStatus, userId),
				{ x1: Message ->
					message_toJs(x1)
				},
			)}

	}

	override fun createMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		message_toJs(messageApi.createMessage(com.icure.sdk.js.model.message_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedMessageJs?,
		patient: PatientJs?,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedMessageJs> = GlobalScope.promise {
		message_toJs(messageApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.message_fromJs(nonNull1)
		}, patient?.let { nonNull1 ->
		  com.icure.sdk.js.model.patient_fromJs(nonNull1)
		}, user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.js.model.embed.accessLevel_fromJs(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun createMessageInTopic(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		message_toJs(messageApi.createMessageInTopic(com.icure.sdk.js.model.message_fromJs(entity)))}


	override fun matchMessagesBy(filter: AbstractFilterJs<EncryptedMessageJs>): Promise<Array<String>>
			= GlobalScope.promise {
		listToArray(
			messageApi.matchMessagesBy(abstractFilter_fromJs(
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
		docIdentifier_toJs(messageApi.deleteMessage(entityId))}


	override fun deleteMessages(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			messageApi.deleteMessages(arrayToList(
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


	override fun shareWith(
		delegateId: String,
		message: DecryptedMessageJs,
		shareSecretIds: Array<String>,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedMessageJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			messageApi.shareWith(delegateId, com.icure.sdk.js.model.message_fromJs(message),
					com.icure.sdk.js.model.CheckedConverters.arrayToSet(
			  shareSecretIds,
			  "shareSecretIds",
			  { x1: kotlin.String ->
			    x1
			  },
			), com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)}


	override fun findMessagesByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedMessageJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			messageApi.findMessagesByHcPartyPatient(hcPartyId,
					com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)}

}
