// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MessageApi
import com.icure.sdk.crypto.entities.MessageShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.MessageApiJs
import com.icure.sdk.js.api.flavoured.MessageApi_findMessagesByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.MessageApi_findMessagesByTransportGuidSentDate_Options
import com.icure.sdk.js.api.flavoured.MessageApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.MessageApi_subscribeToEvents_Options
import com.icure.sdk.js.api.flavoured.MessageApi_withEncryptionMetadata_Options
import com.icure.sdk.js.api.flavoured.MessageFlavouredApiJs
import com.icure.sdk.js.api.flavoured.MessageFlavouredApi_findMessagesByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.MessageFlavouredApi_findMessagesByTransportGuidSentDate_Options
import com.icure.sdk.js.api.flavoured.MessageFlavouredApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.MessageFlavouredApi_subscribeToEvents_Options
import com.icure.sdk.js.crypto.entities.MessageShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.messageShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToDuration
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedMessageJs
import com.icure.sdk.js.model.EncryptedMessageJs
import com.icure.sdk.js.model.MessageJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.message_fromJs
import com.icure.sdk.js.model.message_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.DecryptedMessage
import com.icure.sdk.model.EncryptedMessage
import com.icure.sdk.model.Message
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
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
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
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
			shareSecretIds: Array<String>,
			options: MessageFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<EncryptedMessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val messageConverted: EncryptedMessage = message_fromJs(message)
				val shareSecretIdsConverted: Set<String> = arrayToSet(
					shareSecretIds,
					"shareSecretIds",
					{ x1: String ->
						x1
					},
				)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareEncryptionKeys,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareOwningEntityIds,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
					_options.requestedPermission,
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = messageApi.encrypted.shareWith(
					delegateIdConverted,
					messageConverted,
					shareSecretIdsConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedMessage ->
						message_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(message: EncryptedMessageJs,
				delegates: Record<String, MessageShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedMessageJs>> = GlobalScope.promise {
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
			val result = messageApi.encrypted.tryShareWithMany(
				messageConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedMessage ->
					message_toJs(x1)
				},
			)
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
			options: MessageFlavouredApi_findMessagesByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<EncryptedMessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefault(
					_options.startDate,
					null
				) { startDate ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefault(
					_options.endDate,
					null
				) { endDate ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefault(
					_options.descending,
					null
				) { descending ->
					descending
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

		override fun modifyMessage(entity: EncryptedMessageJs): Promise<EncryptedMessageJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedMessage = message_fromJs(entity)
			val result = messageApi.encrypted.modifyMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun getMessage(entityId: String): Promise<EncryptedMessageJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = messageApi.encrypted.getMessage(
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
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = messageApi.encrypted.filterMessagesBy(
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

		override fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
				Promise<Array<EncryptedMessageJs>> = GlobalScope.promise {
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.encrypted.findMessagesByHCPartyPatientForeignKeys(
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
			val startDocumentIdConverted: String? = startDocumentId
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
			options: MessageFlavouredApi_findMessagesByTransportGuidSentDate_Options?,
		): Promise<PaginatedListJs<EncryptedMessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val transportGuidConverted: String = transportGuid
				val fromConverted: Long = numberToLong(from, "from")
				val toConverted: Long = numberToLong(to, "to")
				val startKeyConverted: JsonElement? = convertingOptionOrDefault(
					_options.startKey,
					null
				) { startKey ->
					dynamicToJsonNullsafe(startKey, "startKey")
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefault(
					_options.startDocumentId,
					null
				) { startDocumentId ->
					startDocumentId
				}
				val limitConverted: Int? = convertingOptionOrDefault(
					_options.limit,
					null
				) { limit ->
					numberToInt(limit, "limit")
				}
				val hcpIdConverted: String? = convertingOptionOrDefault(
					_options.hcpId,
					null
				) { hcpId ->
					hcpId
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
			val startDocumentIdConverted: String? = startDocumentId
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
			val startDocumentIdConverted: String? = startDocumentId
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

		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<MessageJs>,
			eventFired: (EncryptedMessageJs) -> Promise<Unit>,
			options: MessageFlavouredApi_subscribeToEvents_Options?,
		): Promise<ConnectionJs> {
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
				val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefault(
					_options.onConnected,
					{}
				) { onConnected ->
					{  ->
						onConnected().await()
					}
				}
				val channelCapacityConverted: Int = convertingOptionOrDefault(
					_options.channelCapacity,
					kotlinx.coroutines.channels.Channel.BUFFERED
				) { channelCapacity ->
					numberToInt(channelCapacity, "channelCapacity")
				}
				val retryDelayConverted: Duration = convertingOptionOrDefault(
					_options.retryDelay,
					2.seconds
				) { retryDelay ->
					numberToDuration(retryDelay, "retryDelay")
				}
				val retryDelayExponentFactorConverted: Double = convertingOptionOrDefault(
					_options.retryDelayExponentFactor,
					2.0
				) { retryDelayExponentFactor ->
					retryDelayExponentFactor
				}
				val maxRetriesConverted: Int = convertingOptionOrDefault(
					_options.maxRetries,
					5
				) { maxRetries ->
					numberToInt(maxRetries, "maxRetries")
				}
				val eventFiredConverted: suspend (EncryptedMessage) -> Unit = { arg0 ->
					eventFired(
						message_toJs(arg0),
					).await()
				}
				val result = messageApi.encrypted.subscribeToEvents(
					eventsConverted,
					filterConverted,
					onConnectedConverted,
					channelCapacityConverted,
					retryDelayConverted,
					retryDelayExponentFactorConverted,
					maxRetriesConverted,
					eventFiredConverted,
				)
				connection_toJs(result)
			}
		}
	}

	override val tryAndRecover: MessageFlavouredApiJs<MessageJs> = object :
			MessageFlavouredApiJs<MessageJs> {
		override fun shareWith(
			delegateId: String,
			message: MessageJs,
			shareSecretIds: Array<String>,
			options: MessageFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<MessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val messageConverted: Message = message_fromJs(message)
				val shareSecretIdsConverted: Set<String> = arrayToSet(
					shareSecretIds,
					"shareSecretIds",
					{ x1: String ->
						x1
					},
				)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareEncryptionKeys,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareOwningEntityIds,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
					_options.requestedPermission,
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = messageApi.tryAndRecover.shareWith(
					delegateIdConverted,
					messageConverted,
					shareSecretIdsConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Message ->
						message_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(message: MessageJs,
				delegates: Record<String, MessageShareOptionsJs>): Promise<SimpleShareResultJs<MessageJs>> =
				GlobalScope.promise {
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
			val result = messageApi.tryAndRecover.tryShareWithMany(
				messageConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Message ->
					message_toJs(x1)
				},
			)
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
			options: MessageFlavouredApi_findMessagesByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<MessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefault(
					_options.startDate,
					null
				) { startDate ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefault(
					_options.endDate,
					null
				) { endDate ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefault(
					_options.descending,
					null
				) { descending ->
					descending
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

		override fun modifyMessage(entity: MessageJs): Promise<MessageJs> = GlobalScope.promise {
			val entityConverted: Message = message_fromJs(entity)
			val result = messageApi.tryAndRecover.modifyMessage(
				entityConverted,
			)
			message_toJs(result)
		}

		override fun getMessage(entityId: String): Promise<MessageJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = messageApi.tryAndRecover.getMessage(
				entityIdConverted,
			)
			message_toJs(result)
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

		override fun filterMessagesBy(
			filterChain: FilterChainJs<MessageJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<MessageJs>> = GlobalScope.promise {
			val filterChainConverted: FilterChain<Message> = filterChain_fromJs(
				filterChain,
				{ x1: MessageJs ->
					message_fromJs(x1)
				},
			)
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = messageApi.tryAndRecover.filterMessagesBy(
				filterChainConverted,
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

		override fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
				Promise<Array<MessageJs>> = GlobalScope.promise {
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val result = messageApi.tryAndRecover.findMessagesByHCPartyPatientForeignKeys(
				secretPatientKeysConverted,
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
			val startDocumentIdConverted: String? = startDocumentId
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
			options: MessageFlavouredApi_findMessagesByTransportGuidSentDate_Options?,
		): Promise<PaginatedListJs<MessageJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val transportGuidConverted: String = transportGuid
				val fromConverted: Long = numberToLong(from, "from")
				val toConverted: Long = numberToLong(to, "to")
				val startKeyConverted: JsonElement? = convertingOptionOrDefault(
					_options.startKey,
					null
				) { startKey ->
					dynamicToJsonNullsafe(startKey, "startKey")
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefault(
					_options.startDocumentId,
					null
				) { startDocumentId ->
					startDocumentId
				}
				val limitConverted: Int? = convertingOptionOrDefault(
					_options.limit,
					null
				) { limit ->
					numberToInt(limit, "limit")
				}
				val hcpIdConverted: String? = convertingOptionOrDefault(
					_options.hcpId,
					null
				) { hcpId ->
					hcpId
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
			val startDocumentIdConverted: String? = startDocumentId
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
			val startDocumentIdConverted: String? = startDocumentId
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
			userId: String,
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
			val userIdConverted: String = userId
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

		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<MessageJs>,
			eventFired: (MessageJs) -> Promise<Unit>,
			options: MessageFlavouredApi_subscribeToEvents_Options?,
		): Promise<ConnectionJs> {
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
				val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefault(
					_options.onConnected,
					{}
				) { onConnected ->
					{  ->
						onConnected().await()
					}
				}
				val channelCapacityConverted: Int = convertingOptionOrDefault(
					_options.channelCapacity,
					kotlinx.coroutines.channels.Channel.BUFFERED
				) { channelCapacity ->
					numberToInt(channelCapacity, "channelCapacity")
				}
				val retryDelayConverted: Duration = convertingOptionOrDefault(
					_options.retryDelay,
					2.seconds
				) { retryDelay ->
					numberToDuration(retryDelay, "retryDelay")
				}
				val retryDelayExponentFactorConverted: Double = convertingOptionOrDefault(
					_options.retryDelayExponentFactor,
					2.0
				) { retryDelayExponentFactor ->
					retryDelayExponentFactor
				}
				val maxRetriesConverted: Int = convertingOptionOrDefault(
					_options.maxRetries,
					5
				) { maxRetries ->
					numberToInt(maxRetries, "maxRetries")
				}
				val eventFiredConverted: suspend (Message) -> Unit = { arg0 ->
					eventFired(
						message_toJs(arg0),
					).await()
				}
				val result = messageApi.tryAndRecover.subscribeToEvents(
					eventsConverted,
					filterConverted,
					onConnectedConverted,
					channelCapacityConverted,
					retryDelayConverted,
					retryDelayExponentFactorConverted,
					maxRetriesConverted,
					eventFiredConverted,
				)
				connection_toJs(result)
			}
		}
	}

	override fun createMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.createMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun withEncryptionMetadata(
		base: DecryptedMessageJs?,
		patient: PatientJs?,
		options: MessageApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedMessageJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedMessage? = base?.let { nonNull1 ->
				message_fromJs(nonNull1)
			}
			val patientConverted: Patient? = patient?.let { nonNull1 ->
				patient_fromJs(nonNull1)
			}
			val userConverted: User? = convertingOptionOrDefault(
				_options.user,
				null
			) { user ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefault(
				_options.delegates,
				emptyMap()
			) { delegates ->
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
			val secretIdConverted: SecretIdOption = convertingOptionOrDefault(
				_options.secretId,
				com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent
			) { secretId ->
				secretIdOption_fromJs(secretId)
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

	override fun createMessageInTopic(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.createMessageInTopic(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun matchMessagesBy(filter: AbstractFilterJs<MessageJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Message> = abstractFilter_fromJs(
			filter,
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
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

	override fun deleteMessage(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageApi.deleteMessage(
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
		val result = messageApi.deleteMessages(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		message: DecryptedMessageJs,
		shareSecretIds: Array<String>,
		options: MessageApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedMessageJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val messageConverted: DecryptedMessage = message_fromJs(message)
			val shareSecretIdsConverted: Set<String> = arrayToSet(
				shareSecretIds,
				"shareSecretIds",
				{ x1: String ->
					x1
				},
			)
			val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
				_options.shareEncryptionKeys,
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareEncryptionKeys ->
				ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
			}
			val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
				_options.shareOwningEntityIds,
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareOwningEntityIds ->
				ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
			}
			val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
				_options.requestedPermission,
				com.icure.sdk.model.requests.RequestedPermission.MaxWrite
			) { requestedPermission ->
				RequestedPermission.valueOf(requestedPermission)
			}
			val result = messageApi.shareWith(
				delegateIdConverted,
				messageConverted,
				shareSecretIdsConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedMessage ->
					message_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(message: DecryptedMessageJs,
			delegates: Record<String, MessageShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedMessageJs>> = GlobalScope.promise {
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
		val result = messageApi.tryShareWithMany(
			messageConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedMessage ->
				message_toJs(x1)
			},
		)
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
		options: MessageApi_findMessagesByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedMessageJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefault(
				_options.startDate,
				null
			) { startDate ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefault(
				_options.endDate,
				null
			) { endDate ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefault(
				_options.descending,
				null
			) { descending ->
				descending
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

	override fun modifyMessage(entity: DecryptedMessageJs): Promise<DecryptedMessageJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedMessage = message_fromJs(entity)
		val result = messageApi.modifyMessage(
			entityConverted,
		)
		message_toJs(result)
	}

	override fun getMessage(entityId: String): Promise<DecryptedMessageJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = messageApi.getMessage(
			entityIdConverted,
		)
		message_toJs(result)
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

	override fun filterMessagesBy(
		filterChain: FilterChainJs<MessageJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedMessageJs>> = GlobalScope.promise {
		val filterChainConverted: FilterChain<Message> = filterChain_fromJs(
			filterChain,
			{ x1: MessageJs ->
				message_fromJs(x1)
			},
		)
		val startDocumentIdConverted: String? = startDocumentId
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = messageApi.filterMessagesBy(
			filterChainConverted,
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

	override fun findMessagesByHCPartyPatientForeignKeys(secretPatientKeys: Array<String>):
			Promise<Array<DecryptedMessageJs>> = GlobalScope.promise {
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = messageApi.findMessagesByHCPartyPatientForeignKeys(
			secretPatientKeysConverted,
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
		val startDocumentIdConverted: String? = startDocumentId
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
		options: MessageApi_findMessagesByTransportGuidSentDate_Options?,
	): Promise<PaginatedListJs<DecryptedMessageJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val transportGuidConverted: String = transportGuid
			val fromConverted: Long = numberToLong(from, "from")
			val toConverted: Long = numberToLong(to, "to")
			val startKeyConverted: JsonElement? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				dynamicToJsonNullsafe(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val hcpIdConverted: String? = convertingOptionOrDefault(
				_options.hcpId,
				null
			) { hcpId ->
				hcpId
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
		val startDocumentIdConverted: String? = startDocumentId
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
		val startDocumentIdConverted: String? = startDocumentId
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
		userId: String,
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
		val userIdConverted: String = userId
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
		filter: AbstractFilterJs<MessageJs>,
		eventFired: (DecryptedMessageJs) -> Promise<Unit>,
		options: MessageApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs> {
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
			val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefault(
				_options.onConnected,
				{}
			) { onConnected ->
				{  ->
					onConnected().await()
				}
			}
			val channelCapacityConverted: Int = convertingOptionOrDefault(
				_options.channelCapacity,
				kotlinx.coroutines.channels.Channel.BUFFERED
			) { channelCapacity ->
				numberToInt(channelCapacity, "channelCapacity")
			}
			val retryDelayConverted: Duration = convertingOptionOrDefault(
				_options.retryDelay,
				2.seconds
			) { retryDelay ->
				numberToDuration(retryDelay, "retryDelay")
			}
			val retryDelayExponentFactorConverted: Double = convertingOptionOrDefault(
				_options.retryDelayExponentFactor,
				2.0
			) { retryDelayExponentFactor ->
				retryDelayExponentFactor
			}
			val maxRetriesConverted: Int = convertingOptionOrDefault(
				_options.maxRetries,
				5
			) { maxRetries ->
				numberToInt(maxRetries, "maxRetries")
			}
			val eventFiredConverted: suspend (DecryptedMessage) -> Unit = { arg0 ->
				eventFired(
					message_toJs(arg0),
				).await()
			}
			val result = messageApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				onConnectedConverted,
				channelCapacityConverted,
				retryDelayConverted,
				retryDelayExponentFactorConverted,
				maxRetriesConverted,
				eventFiredConverted,
			)
			connection_toJs(result)
		}
	}
}
