// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.ContactBasicApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.js.api.ContactBasicApiJs
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.EncryptedContactJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.sdk.js.model.contact_fromJs
import com.icure.sdk.js.model.contact_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.embed.service_toJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.sdk.js.subscription.entitySubscription_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.Contact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
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
internal class ContactBasicApiImplJs(
	private val contactBasicApi: ContactBasicApi,
) : ContactBasicApiJs {
	override fun matchContactsBy(filter: BaseFilterOptionsJs<ContactJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Contact> = baseFilterOptions_fromJs(filter)
		val result = contactBasicApi.matchContactsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchServicesBy(filter: BaseFilterOptionsJs<ServiceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Service> = baseFilterOptions_fromJs(filter)
		val result = contactBasicApi.matchServicesBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchContactsBySorted(filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Contact> = baseSortableFilterOptions_fromJs(filter)
		val result = contactBasicApi.matchContactsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchServicesBySorted(filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Service> = baseSortableFilterOptions_fromJs(filter)
		val result = contactBasicApi.matchServicesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterContactsBy(filter: BaseFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Contact> = baseFilterOptions_fromJs(filter)
		val result = contactBasicApi.filterContactsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterServicesBy(filter: BaseFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<EncryptedServiceJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Service> = baseFilterOptions_fromJs(filter)
		val result = contactBasicApi.filterServicesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun filterContactsBySorted(filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Contact> = baseSortableFilterOptions_fromJs(filter)
		val result = contactBasicApi.filterContactsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterServicesBySorted(filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<EncryptedServiceJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Service> = baseSortableFilterOptions_fromJs(filter)
		val result = contactBasicApi.filterServicesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun subscribeToServiceCreateOrUpdateEvents(filter: BaseFilterOptionsJs<ServiceJs>,
			options: dynamic): Promise<EntitySubscriptionJs<EncryptedServiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val filterConverted: BaseFilterOptions<Service> = baseFilterOptions_fromJs(filter)
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
			val result = contactBasicApi.subscribeToServiceCreateOrUpdateEvents(
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}
	}

	override fun deleteContact(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = contactBasicApi.deleteContact(
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
		val result = contactBasicApi.deleteContacts(
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
		val result = contactBasicApi.findContactsDelegationsStubsByHcPartyPatientForeignKeys(
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
		val result = contactBasicApi.getServiceCodesOccurrences(
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

	override fun modifyContact(entity: EncryptedContactJs): Promise<EncryptedContactJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedContact = contact_fromJs(entity)
		val result = contactBasicApi.modifyContact(
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
		val result = contactBasicApi.modifyContacts(
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
		val result = contactBasicApi.getContact(
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
		val result = contactBasicApi.getContacts(
			entityIdsConverted,
		)
		listToArray(
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
		val result = contactBasicApi.listContactByHCPartyServiceId(
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
		val result = contactBasicApi.listContactsByExternalId(
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
		val result = contactBasicApi.listContactsByHCPartyAndFormId(
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
		val result = contactBasicApi.listContactsByHCPartyAndFormIds(
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
		options: dynamic,
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
			val planOfActionsIdsConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"planOfActionsIds",
				null
			) { planOfActionsIds: String? ->
				undefinedToNull(planOfActionsIds)
			}
			val skipClosedContactsConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"skipClosedContacts",
				null
			) { skipClosedContacts: Boolean? ->
				undefinedToNull(skipClosedContacts)
			}
			val result = contactBasicApi.listContactsByHCPartyAndPatientSecretFKeys(
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

	override fun getService(serviceId: String): Promise<EncryptedServiceJs> = GlobalScope.promise {
		val serviceIdConverted: String = serviceId
		val result = contactBasicApi.getService(
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
		val result = contactBasicApi.getServices(
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
		val result = contactBasicApi.getServicesLinkedTo(
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

	override fun listServicesByAssociationId(associationId: String): Promise<Array<EncryptedServiceJs>>
			= GlobalScope.promise {
		val associationIdConverted: String = associationId
		val result = contactBasicApi.listServicesByAssociationId(
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
		val result = contactBasicApi.listServicesByHealthElementId(
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
		options: dynamic,
	): Promise<PaginatedListJs<EncryptedContactJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val hcPartyIdConverted: String = hcPartyId
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
			val result = contactBasicApi.findContactsByOpeningDate(
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

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<ContactJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedContactJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<Contact> = baseFilterOptions_fromJs(filter)
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
			val result = contactBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}
	}
}
