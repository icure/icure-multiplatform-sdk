// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.ContactApi
import com.icure.cardinal.sdk.crypto.entities.ContactShareOptions
import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.ContactApiJs
import com.icure.cardinal.sdk.js.api.ContactFlavouredApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.crypto.entities.ContactShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs
import com.icure.cardinal.sdk.js.crypto.entities.contactShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.secretIdUseOption_fromJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.DecryptedContactJs
import com.icure.cardinal.sdk.js.model.EncryptedContactJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.cardinal.sdk.js.model.contact_fromJs
import com.icure.cardinal.sdk.js.model.contact_toJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.embed.DecryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.model.embed.service_fromJs
import com.icure.cardinal.sdk.js.model.embed.service_toJs
import com.icure.cardinal.sdk.js.model.entityReferenceInGroup_fromJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.storedDocumentIdentifier_fromJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.Contact
import com.icure.cardinal.sdk.model.DecryptedContact
import com.icure.cardinal.sdk.model.EncryptedContact
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.`data`.LabelledOccurence
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.embed.DecryptedService
import com.icure.cardinal.sdk.model.embed.EncryptedService
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
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
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
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
			options: dynamic,
		): Promise<EncryptedContactJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val contactConverted: EncryptedContact = contact_fromJs(contact)
				val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ContactShareOptionsJs? ->
					options?.let { nonNull1 ->
						contactShareOptions_fromJs(nonNull1)
					}
				}
				val result = contactApi.encrypted.shareWith(
					delegateIdConverted,
					contactConverted,
					optionsConverted,
				)
				contact_toJs(result)
			}
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
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
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

		override fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
			val result = contactApi.encrypted.filterContactsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<EncryptedServiceJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
			val result = contactApi.encrypted.filterServicesBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.encrypted.filterContactsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<EncryptedServiceJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.encrypted.filterServicesBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)
		}

		override fun createContact(entity: EncryptedContactJs): Promise<EncryptedContactJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedContact = contact_fromJs(entity)
			val result = contactApi.encrypted.createContact(
				entityConverted,
			)
			contact_toJs(result)
		}

		override fun createContacts(entities: Array<EncryptedContactJs>):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedContact> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.encrypted.createContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)
		}

		override fun undeleteContactById(id: String, rev: String): Promise<EncryptedContactJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = contactApi.encrypted.undeleteContactById(
				idConverted,
				revConverted,
			)
			contact_toJs(result)
		}

		override fun undeleteContact(contact: ContactJs): Promise<EncryptedContactJs> =
				GlobalScope.promise {
			val contactConverted: Contact = contact_fromJs(contact)
			val result = contactApi.encrypted.undeleteContact(
				contactConverted,
			)
			contact_toJs(result)
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

		override fun getContact(entityId: String): Promise<EncryptedContactJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = contactApi.encrypted.getContact(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					contact_toJs(nonNull1)
				}
			)
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
	}

	override val tryAndRecover: ContactFlavouredApiJs<ContactJs, ServiceJs> = object :
			ContactFlavouredApiJs<ContactJs, ServiceJs> {
		override fun shareWith(
			delegateId: String,
			contact: ContactJs,
			options: dynamic,
		): Promise<ContactJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val contactConverted: Contact = contact_fromJs(contact)
				val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: ContactShareOptionsJs? ->
					options?.let { nonNull1 ->
						contactShareOptions_fromJs(nonNull1)
					}
				}
				val result = contactApi.tryAndRecover.shareWith(
					delegateIdConverted,
					contactConverted,
					optionsConverted,
				)
				contact_toJs(result)
			}
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
			options: dynamic,
		): Promise<PaginatedListIteratorJs<ContactJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					undefinedToNull(descending)
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

		override fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<ContactJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
			val result = contactApi.tryAndRecover.filterContactsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<ServiceJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
			val result = contactApi.tryAndRecover.filterServicesBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
				Promise<PaginatedListIteratorJs<ContactJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.tryAndRecover.filterContactsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
				Promise<PaginatedListIteratorJs<ServiceJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
			val result = contactApi.tryAndRecover.filterServicesBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Service ->
					service_toJs(x1)
				},
			)
		}

		override fun createContact(entity: ContactJs): Promise<ContactJs> = GlobalScope.promise {
			val entityConverted: Contact = contact_fromJs(entity)
			val result = contactApi.tryAndRecover.createContact(
				entityConverted,
			)
			contact_toJs(result)
		}

		override fun createContacts(entities: Array<ContactJs>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			val entitiesConverted: List<Contact> = arrayToList(
				entities,
				"entities",
				{ x1: ContactJs ->
					contact_fromJs(x1)
				},
			)
			val result = contactApi.tryAndRecover.createContacts(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)
		}

		override fun undeleteContactById(id: String, rev: String): Promise<ContactJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = contactApi.tryAndRecover.undeleteContactById(
				idConverted,
				revConverted,
			)
			contact_toJs(result)
		}

		override fun undeleteContact(contact: ContactJs): Promise<ContactJs> = GlobalScope.promise {
			val contactConverted: Contact = contact_fromJs(contact)
			val result = contactApi.tryAndRecover.undeleteContact(
				contactConverted,
			)
			contact_toJs(result)
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

		override fun getContact(entityId: String): Promise<ContactJs?> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = contactApi.tryAndRecover.getContact(
				entityIdConverted,
			)
			nullToUndefined(
				result?.let { nonNull1 ->
					contact_toJs(nonNull1)
				}
			)
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
			options: dynamic,
		): Promise<PaginatedListJs<ContactJs>> {
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
	}

	override fun matchContactsBy(filter: FilterOptionsJs<ContactJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
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

	override fun matchServicesBy(filter: FilterOptionsJs<ServiceJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
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

	override fun matchContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
		val result = contactApi.matchContactsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
		val result = contactApi.matchServicesBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun withEncryptionMetadata(
		base: DecryptedContactJs?,
		patient: PatientJs,
		alternateRootDataOwnerReference: EntityReferenceInGroupJs?,
		options: dynamic,
	): Promise<DecryptedContactJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedContact? = base?.let { nonNull1 ->
				contact_fromJs(nonNull1)
			}
			val patientConverted: Patient = patient_fromJs(patient)
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"delegates",
				emptyMap()
			) { delegates: Record<String, String> ->
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
			val secretIdConverted: SecretIdUseOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent
			) { secretId: SecretIdUseOptionJs ->
				secretIdUseOption_fromJs(secretId)
			}
			val alternateRootDataOwnerReferenceConverted: EntityReferenceInGroup? =
					alternateRootDataOwnerReference?.let { nonNull1 ->
				entityReferenceInGroup_fromJs(nonNull1)
			}
			val result = contactApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
				alternateRootDataOwnerReferenceConverted,
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

	override fun decrypt(contact: EncryptedContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val contactConverted: EncryptedContact = contact_fromJs(contact)
		val result = contactApi.decrypt(
			contactConverted,
		)
		contact_toJs(result)
	}

	override fun tryDecrypt(contact: EncryptedContactJs): Promise<ContactJs> = GlobalScope.promise {
		val contactConverted: EncryptedContact = contact_fromJs(contact)
		val result = contactApi.tryDecrypt(
			contactConverted,
		)
		contact_toJs(result)
	}

	override fun decryptService(service: EncryptedServiceJs): Promise<DecryptedServiceJs> =
			GlobalScope.promise {
		val serviceConverted: EncryptedService = service_fromJs(service)
		val result = contactApi.decryptService(
			serviceConverted,
		)
		service_toJs(result)
	}

	override fun tryDecryptService(service: EncryptedServiceJs): Promise<ServiceJs> =
			GlobalScope.promise {
		val serviceConverted: EncryptedService = service_fromJs(service)
		val result = contactApi.tryDecryptService(
			serviceConverted,
		)
		service_toJs(result)
	}

	override fun subscribeToServiceCreateOrUpdateEvents(filter: FilterOptionsJs<ServiceJs>,
			options: dynamic): Promise<EntitySubscriptionJs<EncryptedServiceJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
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
			val result = contactApi.subscribeToServiceCreateOrUpdateEvents(
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

	override fun deleteContactUnsafe(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = contactApi.deleteContactUnsafe(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteContactsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = contactApi.deleteContactsUnsafe(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deleteContactById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = contactApi.deleteContactById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<StoredDocumentIdentifier> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: StoredDocumentIdentifierJs ->
				storedDocumentIdentifier_fromJs(x1)
			},
		)
		val result = contactApi.deleteContactsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeContactById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		contactApi.purgeContactById(
			idConverted,
			revConverted,
		)

	}

	override fun deleteContact(contact: ContactJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.deleteContact(
			contactConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteContacts(contacts: Array<ContactJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val contactsConverted: List<Contact> = arrayToList(
			contacts,
			"contacts",
			{ x1: ContactJs ->
				contact_fromJs(x1)
			},
		)
		val result = contactApi.deleteContacts(
			contactsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgeContact(contact: ContactJs): Promise<Unit> = GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		contactApi.purgeContact(
			contactConverted,
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
		options: dynamic,
	): Promise<DecryptedContactJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val contactConverted: DecryptedContact = contact_fromJs(contact)
			val optionsConverted: ContactShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: ContactShareOptionsJs? ->
				options?.let { nonNull1 ->
					contactShareOptions_fromJs(nonNull1)
				}
			}
			val result = contactApi.shareWith(
				delegateIdConverted,
				contactConverted,
				optionsConverted,
			)
			contact_toJs(result)
		}
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
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedContactJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startDate",
				null
			) { startDate: Double? ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"endDate",
				null
			) { endDate: Double? ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"descending",
				null
			) { descending: Boolean? ->
				undefinedToNull(descending)
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

	override fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<DecryptedContactJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
		val result = contactApi.filterContactsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<DecryptedServiceJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Service> = filterOptions_fromJs(filter)
		val result = contactApi.filterServicesBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
	}

	override fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<DecryptedContactJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Contact> = sortableFilterOptions_fromJs(filter)
		val result = contactApi.filterContactsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)
	}

	override fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<DecryptedServiceJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Service> = sortableFilterOptions_fromJs(filter)
		val result = contactApi.filterServicesBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)
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

	override fun undeleteContactById(id: String, rev: String): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = contactApi.undeleteContactById(
			idConverted,
			revConverted,
		)
		contact_toJs(result)
	}

	override fun undeleteContact(contact: ContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		val contactConverted: Contact = contact_fromJs(contact)
		val result = contactApi.undeleteContact(
			contactConverted,
		)
		contact_toJs(result)
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

	override fun getContact(entityId: String): Promise<DecryptedContactJs?> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = contactApi.getContact(
			entityIdConverted,
		)
		nullToUndefined(
			result?.let { nonNull1 ->
				contact_toJs(nonNull1)
			}
		)
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
		options: dynamic,
	): Promise<PaginatedListJs<DecryptedContactJs>> {
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

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<ContactJs>,
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
			val filterConverted: FilterOptions<Contact> = filterOptions_fromJs(filter)
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
			val result = contactApi.subscribeToEvents(
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
