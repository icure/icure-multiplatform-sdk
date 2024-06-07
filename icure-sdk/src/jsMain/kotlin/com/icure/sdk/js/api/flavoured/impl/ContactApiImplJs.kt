// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ContactApi
import com.icure.sdk.crypto.entities.ContactShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.ContactApiJs
import com.icure.sdk.js.api.flavoured.ContactApi_findContactsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.ContactApi_findContactsByOpeningDate_Options
import com.icure.sdk.js.api.flavoured.ContactApi_listContactsByHCPartyAndPatientSecretFKeys_Options
import com.icure.sdk.js.api.flavoured.ContactApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.ContactApi_subscribeToEvents_Options
import com.icure.sdk.js.api.flavoured.ContactApi_subscribeToServiceEvents_Options
import com.icure.sdk.js.api.flavoured.ContactApi_withEncryptionMetadata_Options
import com.icure.sdk.js.api.flavoured.ContactFlavouredApiJs
import com.icure.sdk.js.api.flavoured.ContactFlavouredApi_findContactsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.ContactFlavouredApi_findContactsByOpeningDate_Options
import com.icure.sdk.js.api.flavoured.ContactFlavouredApi_listContactsByHCPartyAndPatientSecretFKeys_Options
import com.icure.sdk.js.api.flavoured.ContactFlavouredApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.ContactFlavouredApi_subscribeToEvents_Options
import com.icure.sdk.js.api.flavoured.ContactFlavouredApi_subscribeToServiceEvents_Options
import com.icure.sdk.js.crypto.entities.ContactShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.contactShareOptions_fromJs
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
import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.DecryptedContactJs
import com.icure.sdk.js.model.EncryptedContactJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.sdk.js.model.contact_fromJs
import com.icure.sdk.js.model.contact_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.embed.DecryptedServiceJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.embed.service_fromJs
import com.icure.sdk.js.model.embed.service_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
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
internal class ContactApiImplJs(
	private val contactApi: ContactApi,
) : ContactApiJs {
	override val encrypted: ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs> = object :
			ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs> {
		override fun shareWith(
			delegateId: String,
			contact: EncryptedContactJs,
			options: ContactFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<EncryptedContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val contactConverted: EncryptedContact = contact_fromJs(contact)
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
				val result = contactApi.encrypted.shareWith(
					delegateIdConverted,
					contactConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedContact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(contact: EncryptedContactJs,
				delegates: Record<String, ContactShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedContactJs>> = GlobalScope.promise {
			val contactConverted: EncryptedContact = contact_fromJs(contact)
			val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ContactShareOptionsJs ->
					contactShareOptions_fromJs(x1)
				},
			)
			val result = contactApi.encrypted.tryShareWithMany(
				contactConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun shareWithMany(contact: EncryptedContactJs,
				delegates: Record<String, ContactShareOptionsJs>): Promise<EncryptedContactJs> =
				GlobalScope.promise {
			val contactConverted: EncryptedContact = contact_fromJs(contact)
			val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ContactShareOptionsJs ->
					contactShareOptions_fromJs(x1)
				},
			)
			val result = contactApi.encrypted.shareWithMany(
				contactConverted,
				delegatesConverted,
			)
			contact_toJs(result)
		}

		override fun findContactsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: ContactFlavouredApi_findContactsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<EncryptedContactJs>> {
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
				val result = contactApi.encrypted.findContactsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedContact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun modifyContact(entity: EncryptedContactJs): Promise<EncryptedContactJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedContact = contact_fromJs(entity)
			val result = contactApi.encrypted.modifyContact(
				entityConverted,
			)
			contact_toJs(result)
		}

		override fun modifyContacts(entities: Array<EncryptedContactJs>):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedContact> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.encrypted.modifyContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun getContact(entityId: String): Promise<EncryptedContactJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = contactApi.encrypted.getContact(
				entityIdConverted,
			)
			contact_toJs(result)
		}

		override fun getContacts(entityIds: Array<String>): Promise<Array<EncryptedContactJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.encrypted.getContacts(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterContactsBy(
			filterChain: FilterChainJs<ContactJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedContactJs>> = GlobalScope.promise {
			val filterChainConverted: FilterChain<Contact> = filterChain_fromJs(
				filterChain,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = contactApi.encrypted.filterContactsBy(
				filterChainConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val serviceIdConverted: String = serviceId
			val result = contactApi.encrypted.listContactByHCPartyServiceId(
				hcPartyIdConverted,
				serviceIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactsByExternalId(externalId: String): Promise<Array<EncryptedContactJs>> =
				GlobalScope.promise {
			val externalIdConverted: String = externalId
			val result = contactApi.encrypted.listContactsByExternalId(
				externalIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val formIdConverted: String = formId
			val result = contactApi.encrypted.listContactsByHCPartyAndFormId(
				hcPartyIdConverted,
				formIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val formIdsConverted: List<String> = arrayToList(
				formIds,
				"formIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.encrypted.listContactsByHCPartyAndFormIds(
				hcPartyIdConverted,
				formIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactsByHCPartyAndPatientSecretFKeys(
			hcPartyId: String,
			secretPatientKeys: Array<String>,
			options: ContactFlavouredApi_listContactsByHCPartyAndPatientSecretFKeys_Options?,
		): Promise<Array<EncryptedContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val secretPatientKeysConverted: List<String> = arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)
				val planOfActionsIdsConverted: String? = convertingOptionOrDefault(
					_options.planOfActionsIds,
					null
				) { planOfActionsIds ->
					planOfActionsIds
				}
				val skipClosedContactsConverted: Boolean? = convertingOptionOrDefault(
					_options.skipClosedContacts,
					null
				) { skipClosedContacts ->
					skipClosedContacts
				}
				val result = contactApi.encrypted.listContactsByHCPartyAndPatientSecretFKeys(
					hcPartyIdConverted,
					secretPatientKeysConverted,
					planOfActionsIdsConverted,
					skipClosedContactsConverted,
				)
				listToArray(
					result,
					{ x1: EncryptedContact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun closeForHCPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.encrypted.closeForHCPartyPatientForeignKeys(
				hcPartyIdConverted,
				secretPatientKeysConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun getService(serviceId: String): Promise<EncryptedServiceJs> = GlobalScope.promise {
			val serviceIdConverted: String = serviceId
			val result = contactApi.encrypted.getService(
				serviceIdConverted,
			)
			service_toJs(result)
		}

		override fun getServices(entityIds: Array<String>): Promise<Array<EncryptedServiceJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.encrypted.getServices(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun getServicesLinkedTo(linkType: String, ids: Array<String>):
				Promise<Array<EncryptedServiceJs>> = GlobalScope.promise {
			val linkTypeConverted: String = linkType
			val idsConverted: List<String> = arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.encrypted.getServicesLinkedTo(
				linkTypeConverted,
				idsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun listServicesByAssociationId(associationId: String):
				Promise<Array<EncryptedServiceJs>> = GlobalScope.promise {
			val associationIdConverted: String = associationId
			val result = contactApi.encrypted.listServicesByAssociationId(
				associationIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
				Promise<Array<EncryptedServiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val healthElementIdConverted: String = healthElementId
			val result = contactApi.encrypted.listServicesByHealthElementId(
				hcPartyIdConverted,
				healthElementIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun findContactsByOpeningDate(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
			options: ContactFlavouredApi_findContactsByOpeningDate_Options?,
		): Promise<PaginatedListJs<EncryptedContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val startDateConverted: Long = numberToLong(startDate, "startDate")
				val endDateConverted: Long = numberToLong(endDate, "endDate")
				val hcPartyIdConverted: String = hcPartyId
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
				val result = contactApi.encrypted.findContactsByOpeningDate(
					startDateConverted,
					endDateConverted,
					hcPartyIdConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: EncryptedContact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun filterServicesBy(
			filterChain: FilterChainJs<ServiceJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedServiceJs>> = GlobalScope.promise {
			val filterChainConverted: FilterChain<Service> = filterChain_fromJs(
				filterChain,
				{ x1: ServiceJs ->
					service_fromJs(x1)
				},
			)
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = contactApi.encrypted.filterServicesBy(
				filterChainConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun subscribeToServiceEvents(
			events: Array<String>,
			filter: AbstractFilterJs<ServiceJs>,
			eventFired: (EncryptedServiceJs) -> Promise<Unit>,
			options: ContactFlavouredApi_subscribeToServiceEvents_Options?,
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
				val filterConverted: AbstractFilter<Service> = abstractFilter_fromJs(
					filter,
					{ x1: ServiceJs ->
						service_fromJs(x1)
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
				val eventFiredConverted: suspend (EncryptedService) -> Unit = { arg0 ->
					eventFired(
						service_toJs(arg0),
					).await()
				}
				val result = contactApi.encrypted.subscribeToServiceEvents(
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

		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<ContactJs>,
			eventFired: (EncryptedContactJs) -> Promise<Unit>,
			options: ContactFlavouredApi_subscribeToEvents_Options?,
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
				val filterConverted: AbstractFilter<Contact> = abstractFilter_fromJs(
					filter,
					{ x1: ContactJs ->
						contact_fromJs(x1)
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
				val eventFiredConverted: suspend (EncryptedContact) -> Unit = { arg0 ->
					eventFired(
						contact_toJs(arg0),
					).await()
				}
				val result = contactApi.encrypted.subscribeToEvents(
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

	override val tryAndRecover: ContactFlavouredApiJs<ContactJs, ServiceJs> = object :
			ContactFlavouredApiJs<ContactJs, ServiceJs> {
		override fun shareWith(
			delegateId: String,
			contact: ContactJs,
			options: ContactFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<ContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val contactConverted: Contact = contact_fromJs(contact)
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
				val result = contactApi.tryAndRecover.shareWith(
					delegateIdConverted,
					contactConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(contact: ContactJs,
				delegates: Record<String, ContactShareOptionsJs>): Promise<SimpleShareResultJs<ContactJs>> =
				GlobalScope.promise {
			val contactConverted: Contact = contact_fromJs(contact)
			val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ContactShareOptionsJs ->
					contactShareOptions_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.tryShareWithMany(
				contactConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun shareWithMany(contact: ContactJs, delegates: Record<String, ContactShareOptionsJs>):
				Promise<ContactJs> = GlobalScope.promise {
			val contactConverted: Contact = contact_fromJs(contact)
			val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ContactShareOptionsJs ->
					contactShareOptions_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.shareWithMany(
				contactConverted,
				delegatesConverted,
			)
			contact_toJs(result)
		}

		override fun findContactsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: ContactFlavouredApi_findContactsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<ContactJs>> {
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
				val result = contactApi.tryAndRecover.findContactsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun modifyContact(entity: ContactJs): Promise<ContactJs> = GlobalScope.promise {
			val entityConverted: Contact = contact_fromJs(entity)
			val result = contactApi.tryAndRecover.modifyContact(
				entityConverted,
			)
			contact_toJs(result)
		}

		override fun modifyContacts(entities: Array<ContactJs>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Contact> = arrayToList(
				entities,
				"entities",
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.modifyContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun getContact(entityId: String): Promise<ContactJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = contactApi.tryAndRecover.getContact(
				entityIdConverted,
			)
			contact_toJs(result)
		}

		override fun getContacts(entityIds: Array<String>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.tryAndRecover.getContacts(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterContactsBy(
			filterChain: FilterChainJs<ContactJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<ContactJs>> = GlobalScope.promise {
			val filterChainConverted: FilterChain<Contact> = filterChain_fromJs(
				filterChain,
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = contactApi.tryAndRecover.filterContactsBy(
				filterChainConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
				Promise<Array<ContactJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val serviceIdConverted: String = serviceId
			val result = contactApi.tryAndRecover.listContactByHCPartyServiceId(
				hcPartyIdConverted,
				serviceIdConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactsByExternalId(externalId: String): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			val externalIdConverted: String = externalId
			val result = contactApi.tryAndRecover.listContactsByExternalId(
				externalIdConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
				Promise<Array<ContactJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val formIdConverted: String = formId
			val result = contactApi.tryAndRecover.listContactsByHCPartyAndFormId(
				hcPartyIdConverted,
				formIdConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
				Promise<Array<ContactJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val formIdsConverted: List<String> = arrayToList(
				formIds,
				"formIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.tryAndRecover.listContactsByHCPartyAndFormIds(
				hcPartyIdConverted,
				formIdsConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun listContactsByHCPartyAndPatientSecretFKeys(
			hcPartyId: String,
			secretPatientKeys: Array<String>,
			options: ContactFlavouredApi_listContactsByHCPartyAndPatientSecretFKeys_Options?,
		): Promise<Array<ContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val secretPatientKeysConverted: List<String> = arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)
				val planOfActionsIdsConverted: String? = convertingOptionOrDefault(
					_options.planOfActionsIds,
					null
				) { planOfActionsIds ->
					planOfActionsIds
				}
				val skipClosedContactsConverted: Boolean? = convertingOptionOrDefault(
					_options.skipClosedContacts,
					null
				) { skipClosedContacts ->
					skipClosedContacts
				}
				val result = contactApi.tryAndRecover.listContactsByHCPartyAndPatientSecretFKeys(
					hcPartyIdConverted,
					secretPatientKeysConverted,
					planOfActionsIdsConverted,
					skipClosedContactsConverted,
				)
				listToArray(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun closeForHCPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<ContactJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.tryAndRecover.closeForHCPartyPatientForeignKeys(
				hcPartyIdConverted,
				secretPatientKeysConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun getService(serviceId: String): Promise<ServiceJs> = GlobalScope.promise {
			val serviceIdConverted: String = serviceId
			val result = contactApi.tryAndRecover.getService(
				serviceIdConverted,
			)
			service_toJs(result)
		}

		override fun getServices(entityIds: Array<String>): Promise<Array<ServiceJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.tryAndRecover.getServices(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun getServicesLinkedTo(linkType: String, ids: Array<String>): Promise<Array<ServiceJs>>
				= GlobalScope.promise {
			val linkTypeConverted: String = linkType
			val idsConverted: List<String> = arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)
			val result = contactApi.tryAndRecover.getServicesLinkedTo(
				linkTypeConverted,
				idsConverted,
			)
			listToArray(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun listServicesByAssociationId(associationId: String): Promise<Array<ServiceJs>> =
				GlobalScope.promise {
			val associationIdConverted: String = associationId
			val result = contactApi.tryAndRecover.listServicesByAssociationId(
				associationIdConverted,
			)
			listToArray(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
				Promise<Array<ServiceJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val healthElementIdConverted: String = healthElementId
			val result = contactApi.tryAndRecover.listServicesByHealthElementId(
				hcPartyIdConverted,
				healthElementIdConverted,
			)
			listToArray(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun findContactsByOpeningDate(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
			options: ContactFlavouredApi_findContactsByOpeningDate_Options?,
		): Promise<PaginatedListJs<ContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val startDateConverted: Long = numberToLong(startDate, "startDate")
				val endDateConverted: Long = numberToLong(endDate, "endDate")
				val hcPartyIdConverted: String = hcPartyId
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
				val result = contactApi.tryAndRecover.findContactsByOpeningDate(
					startDateConverted,
					endDateConverted,
					hcPartyIdConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Contact ->
						contact_toJs(x1)
					},
				)
			}
		}

		override fun filterServicesBy(
			filterChain: FilterChainJs<ServiceJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<ServiceJs>> = GlobalScope.promise {
			val filterChainConverted: FilterChain<Service> = filterChain_fromJs(
				filterChain,
				{ x1: ServiceJs ->
					service_fromJs(x1)
				},
			)
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = contactApi.tryAndRecover.filterServicesBy(
				filterChainConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun subscribeToServiceEvents(
			events: Array<String>,
			filter: AbstractFilterJs<ServiceJs>,
			eventFired: (ServiceJs) -> Promise<Unit>,
			options: ContactFlavouredApi_subscribeToServiceEvents_Options?,
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
				val filterConverted: AbstractFilter<Service> = abstractFilter_fromJs(
					filter,
					{ x1: ServiceJs ->
						service_fromJs(x1)
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
				val eventFiredConverted: suspend (Service) -> Unit = { arg0 ->
					eventFired(
						service_toJs(arg0),
					).await()
				}
				val result = contactApi.tryAndRecover.subscribeToServiceEvents(
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

		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<ContactJs>,
			eventFired: (ContactJs) -> Promise<Unit>,
			options: ContactFlavouredApi_subscribeToEvents_Options?,
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
				val filterConverted: AbstractFilter<Contact> = abstractFilter_fromJs(
					filter,
					{ x1: ContactJs ->
						contact_fromJs(x1)
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
				val eventFiredConverted: suspend (Contact) -> Unit = { arg0 ->
					eventFired(
						contact_toJs(arg0),
					).await()
				}
				val result = contactApi.tryAndRecover.subscribeToEvents(
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

	override fun createContact(entity: DecryptedContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedContact = contact_fromJs(entity)
		val result = contactApi.createContact(
			entityConverted,
		)
		contact_toJs(result)
	}

	override fun createContacts(entities: Array<DecryptedContactJs>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedContact> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactApi.createContacts(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun withEncryptionMetadata(
		base: DecryptedContactJs?,
		patient: PatientJs,
		options: ContactApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedContactJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedContact? = base?.let { nonNull1 ->
				contact_fromJs(nonNull1)
			}
			val patientConverted: Patient = patient_fromJs(patient)
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
			val result = contactApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			contact_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(contact: ContactJs): Promise<Array<String>> =
			GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.getEncryptionKeysOf(
			contactConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(contact: ContactJs): Promise<Boolean> = GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.hasWriteAccess(
			contactConverted,
		)
		result
	}

	override fun decryptPatientIdOf(contact: ContactJs): Promise<Array<String>> = GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.decryptPatientIdOf(
			contactConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: ContactJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Contact = contact_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		contactApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun matchContactsBy(filter: AbstractFilterJs<ContactJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Contact> = abstractFilter_fromJs(
			filter,
			{ x1: ContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactApi.matchContactsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchServicesBy(filter: AbstractFilterJs<ServiceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Service> = abstractFilter_fromJs(
			filter,
			{ x1: ServiceJs ->
				service_fromJs(x1)
			},
		)
		val result = contactApi.matchServicesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteContact(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = contactApi.deleteContact(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteContacts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.deleteContacts(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.findContactsDelegationsStubsByHcPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: IcureStub ->
				icureStub_toJs(x1)
			},
		)
	}

	override fun getServiceCodesOccurrences(codeType: String, minOccurrences: Double):
			Promise<Array<LabelledOccurenceJs>> = GlobalScope.promise {
		val codeTypeConverted: String = codeType
		val minOccurrencesConverted: Long = numberToLong(minOccurrences, "minOccurrences")
		val result = contactApi.getServiceCodesOccurrences(
			codeTypeConverted,
			minOccurrencesConverted,
		)
		listToArray(
			result,
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		contact: DecryptedContactJs,
		options: ContactApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedContactJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val contactConverted: DecryptedContact = contact_fromJs(contact)
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
			val result = contactApi.shareWith(
				delegateIdConverted,
				contactConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(contact: DecryptedContactJs,
			delegates: Record<String, ContactShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedContactJs>> = GlobalScope.promise {
		val contactConverted: DecryptedContact = contact_fromJs(contact)
		val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ContactShareOptionsJs ->
				contactShareOptions_fromJs(x1)
			},
		)
		val result = contactApi.tryShareWithMany(
			contactConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun shareWithMany(contact: DecryptedContactJs,
			delegates: Record<String, ContactShareOptionsJs>): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val contactConverted: DecryptedContact = contact_fromJs(contact)
		val delegatesConverted: Map<String, ContactShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ContactShareOptionsJs ->
				contactShareOptions_fromJs(x1)
			},
		)
		val result = contactApi.shareWithMany(
			contactConverted,
			delegatesConverted,
		)
		contact_toJs(result)
	}

	override fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: ContactApi_findContactsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedContactJs>> {
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
			val result = contactApi.findContactsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}
	}

	override fun modifyContact(entity: DecryptedContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedContact = contact_fromJs(entity)
		val result = contactApi.modifyContact(
			entityConverted,
		)
		contact_toJs(result)
	}

	override fun modifyContacts(entities: Array<DecryptedContactJs>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedContact> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactApi.modifyContacts(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun getContact(entityId: String): Promise<DecryptedContactJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = contactApi.getContact(
			entityIdConverted,
		)
		contact_toJs(result)
	}

	override fun getContacts(entityIds: Array<String>): Promise<Array<DecryptedContactJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.getContacts(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterContactsBy(
		filterChain: FilterChainJs<ContactJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedContactJs>> = GlobalScope.promise {
		val filterChainConverted: FilterChain<Contact> = filterChain_fromJs(
			filterChain,
			{ x1: ContactJs ->
				contact_fromJs(x1)
			},
		)
		val startDocumentIdConverted: String? = startDocumentId
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = contactApi.filterContactsBy(
			filterChainConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val serviceIdConverted: String = serviceId
		val result = contactApi.listContactByHCPartyServiceId(
			hcPartyIdConverted,
			serviceIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun listContactsByExternalId(externalId: String): Promise<Array<DecryptedContactJs>> =
			GlobalScope.promise {
		val externalIdConverted: String = externalId
		val result = contactApi.listContactsByExternalId(
			externalIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val formIdConverted: String = formId
		val result = contactApi.listContactsByHCPartyAndFormId(
			hcPartyIdConverted,
			formIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val formIdsConverted: List<String> = arrayToList(
			formIds,
			"formIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.listContactsByHCPartyAndFormIds(
			hcPartyIdConverted,
			formIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: Array<String>,
		options: ContactApi_listContactsByHCPartyAndPatientSecretFKeys_Options?,
	): Promise<Array<DecryptedContactJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val planOfActionsIdsConverted: String? = convertingOptionOrDefault(
				_options.planOfActionsIds,
				null
			) { planOfActionsIds ->
				planOfActionsIds
			}
			val skipClosedContactsConverted: Boolean? = convertingOptionOrDefault(
				_options.skipClosedContacts,
				null
			) { skipClosedContacts ->
				skipClosedContacts
			}
			val result = contactApi.listContactsByHCPartyAndPatientSecretFKeys(
				hcPartyIdConverted,
				secretPatientKeysConverted,
				planOfActionsIdsConverted,
				skipClosedContactsConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}
	}

	override fun closeForHCPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.closeForHCPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun getService(serviceId: String): Promise<DecryptedServiceJs> = GlobalScope.promise {
		val serviceIdConverted: String = serviceId
		val result = contactApi.getService(
			serviceIdConverted,
		)
		service_toJs(result)
	}

	override fun getServices(entityIds: Array<String>): Promise<Array<DecryptedServiceJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.getServices(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun getServicesLinkedTo(linkType: String, ids: Array<String>):
			Promise<Array<DecryptedServiceJs>> = GlobalScope.promise {
		val linkTypeConverted: String = linkType
		val idsConverted: List<String> = arrayToList(
			ids,
			"ids",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.getServicesLinkedTo(
			linkTypeConverted,
			idsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun listServicesByAssociationId(associationId: String): Promise<Array<DecryptedServiceJs>>
			= GlobalScope.promise {
		val associationIdConverted: String = associationId
		val result = contactApi.listServicesByAssociationId(
			associationIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
			Promise<Array<DecryptedServiceJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val healthElementIdConverted: String = healthElementId
		val result = contactApi.listServicesByHealthElementId(
			hcPartyIdConverted,
			healthElementIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun findContactsByOpeningDate(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
		options: ContactApi_findContactsByOpeningDate_Options?,
	): Promise<PaginatedListJs<DecryptedContactJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val hcPartyIdConverted: String = hcPartyId
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
			val result = contactApi.findContactsByOpeningDate(
				startDateConverted,
				endDateConverted,
				hcPartyIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedContact ->
					contact_toJs(x1)
				},
			)
		}
	}

	override fun filterServicesBy(
		filterChain: FilterChainJs<ServiceJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedServiceJs>> = GlobalScope.promise {
		val filterChainConverted: FilterChain<Service> = filterChain_fromJs(
			filterChain,
			{ x1: ServiceJs ->
				service_fromJs(x1)
			},
		)
		val startDocumentIdConverted: String? = startDocumentId
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = contactApi.filterServicesBy(
			filterChainConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun subscribeToServiceEvents(
		events: Array<String>,
		filter: AbstractFilterJs<ServiceJs>,
		eventFired: (DecryptedServiceJs) -> Promise<Unit>,
		options: ContactApi_subscribeToServiceEvents_Options?,
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
			val filterConverted: AbstractFilter<Service> = abstractFilter_fromJs(
				filter,
				{ x1: ServiceJs ->
					service_fromJs(x1)
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
			val eventFiredConverted: suspend (DecryptedService) -> Unit = { arg0 ->
				eventFired(
					service_toJs(arg0),
				).await()
			}
			val result = contactApi.subscribeToServiceEvents(
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

	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<ContactJs>,
		eventFired: (DecryptedContactJs) -> Promise<Unit>,
		options: ContactApi_subscribeToEvents_Options?,
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
			val filterConverted: AbstractFilter<Contact> = abstractFilter_fromJs(
				filter,
				{ x1: ContactJs ->
					contact_fromJs(x1)
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
			val eventFiredConverted: suspend (DecryptedContact) -> Unit = { arg0 ->
				eventFired(
					contact_toJs(arg0),
				).await()
			}
			val result = contactApi.subscribeToEvents(
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
