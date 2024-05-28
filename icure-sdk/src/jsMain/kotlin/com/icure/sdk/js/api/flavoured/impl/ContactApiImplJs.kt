// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ContactApi
import com.icure.sdk.js.api.flavoured.ContactApiJs
import com.icure.sdk.js.api.flavoured.ContactFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.DecryptedContactJs
import com.icure.sdk.js.model.EncryptedContactJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.`data`.labelledOccurence_toJs
import com.icure.sdk.js.model.contact_fromJs
import com.icure.sdk.js.model.contact_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.embed.DecryptedServiceJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.embed.service_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.Contact
import com.icure.sdk.model.DecryptedContact
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.DecryptedService
import com.icure.sdk.model.embed.EncryptedService
import com.icure.sdk.model.embed.Service
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
internal class ContactApiImplJs(
	private val contactApi: ContactApi,
) : ContactApiJs {
	override val encrypted: ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs> = object :
			ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs> {
		override fun shareWith(
			delegateId: String,
			contact: EncryptedContactJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedContactJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				contactApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.contact_fromJs(contact),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun findContactsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedContactJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				contactApi.encrypted.findContactsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun modifyContact(entity: EncryptedContactJs): Promise<EncryptedContactJs> =
				GlobalScope.promise {
			contact_toJs(contactApi.encrypted.modifyContact(com.icure.sdk.js.model.contact_fromJs(entity)))}


		override fun modifyContacts(entities: Array<EncryptedContactJs>):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.modifyContacts(arrayToList(
					entities,
					"entities",
					{ x1: EncryptedContactJs ->
						contact_fromJs(x1)
					},
				)),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun getContact(entityId: String): Promise<EncryptedContactJs> = GlobalScope.promise {
			contact_toJs(contactApi.encrypted.getContact(entityId))}


		override fun getContacts(entityIds: Array<String>): Promise<Array<EncryptedContactJs>> =
				GlobalScope.promise {
			listToArray(
				contactApi.encrypted.getContacts(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun filterContactsBy(
			filterChain: FilterChainJs<EncryptedContactJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedContactJs>> = GlobalScope.promise {
			paginatedList_toJs(
				contactApi.encrypted.filterContactsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.EncryptedContactJs ->
				    com.icure.sdk.js.model.contact_fromJs(x1)
				  },
				), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.listContactByHCPartyServiceId(hcPartyId, serviceId),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactsByExternalId(externalId: String): Promise<Array<EncryptedContactJs>> =
				GlobalScope.promise {
			listToArray(
				contactApi.encrypted.listContactsByExternalId(externalId),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.listContactsByHCPartyAndFormId(hcPartyId, formId),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
				Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.listContactsByHCPartyAndFormIds(hcPartyId, arrayToList(
					formIds,
					"formIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactsByHCPartyAndPatientSecretFKeys(
			hcPartyId: String,
			secretPatientKeys: Array<String>,
			planOfActionsIds: String?,
			skipClosedContacts: Boolean?,
		): Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.listContactsByHCPartyAndPatientSecretFKeys(hcPartyId, arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				), planOfActionsIds, skipClosedContacts),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun closeForHCPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.closeForHCPartyPatientForeignKeys(hcPartyId, arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun getService(serviceId: String): Promise<EncryptedServiceJs> = GlobalScope.promise {
			service_toJs(contactApi.encrypted.getService(serviceId))}


		override fun getServices(entityIds: Array<String>): Promise<Array<EncryptedServiceJs>> =
				GlobalScope.promise {
			listToArray(
				contactApi.encrypted.getServices(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)}


		override fun getServicesLinkedTo(linkType: String, ids: Array<String>):
				Promise<Array<EncryptedServiceJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.getServicesLinkedTo(linkType, arrayToList(
					ids,
					"ids",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)}


		override fun listServicesByAssociationId(associationId: String):
				Promise<Array<EncryptedServiceJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.listServicesByAssociationId(associationId),
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)}


		override fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
				Promise<Array<EncryptedServiceJs>> = GlobalScope.promise {
			listToArray(
				contactApi.encrypted.listServicesByHealthElementId(hcPartyId, healthElementId),
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)}


		override fun findContactsByOpeningDate(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedContactJs>> = GlobalScope.promise {
			paginatedList_toJs(
				contactApi.encrypted.findContactsByOpeningDate(com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate,
						"startDate"), com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"),
						hcPartyId, com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey,
						"startKey"), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
						"limit")),
				{ x1: EncryptedContact ->
					contact_toJs(x1)
				},
			)}


		override fun filterServicesBy(
			filterChain: FilterChainJs<EncryptedServiceJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedServiceJs>> = GlobalScope.promise {
			paginatedList_toJs(
				contactApi.encrypted.filterServicesBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.embed.EncryptedServiceJs ->
				    com.icure.sdk.js.model.embed.service_fromJs(x1)
				  },
				), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: EncryptedService ->
					service_toJs(x1)
				},
			)}

	}

	override val tryAndRecover: ContactFlavouredApiJs<ContactJs, ServiceJs> = object :
			ContactFlavouredApiJs<ContactJs, ServiceJs> {
		override fun shareWith(
			delegateId: String,
			contact: ContactJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<ContactJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				contactApi.tryAndRecover.shareWith(delegateId, com.icure.sdk.js.model.contact_fromJs(contact),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun findContactsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<ContactJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				contactApi.tryAndRecover.findContactsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun modifyContact(entity: ContactJs): Promise<ContactJs> = GlobalScope.promise {
			contact_toJs(contactApi.tryAndRecover.modifyContact(com.icure.sdk.js.model.contact_fromJs(entity)))}


		override fun modifyContacts(entities: Array<ContactJs>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.modifyContacts(arrayToList(
					entities,
					"entities",
					{ x1: ContactJs ->
						contact_fromJs(x1)
					},
				)),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun getContact(entityId: String): Promise<ContactJs> = GlobalScope.promise {
			contact_toJs(contactApi.tryAndRecover.getContact(entityId))}


		override fun getContacts(entityIds: Array<String>): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.getContacts(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun filterContactsBy(
			filterChain: FilterChainJs<EncryptedContactJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<ContactJs>> = GlobalScope.promise {
			paginatedList_toJs(
				contactApi.tryAndRecover.filterContactsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.EncryptedContactJs ->
				    com.icure.sdk.js.model.contact_fromJs(x1)
				  },
				), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
				Promise<Array<ContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.listContactByHCPartyServiceId(hcPartyId, serviceId),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactsByExternalId(externalId: String): Promise<Array<ContactJs>> =
				GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.listContactsByExternalId(externalId),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
				Promise<Array<ContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.listContactsByHCPartyAndFormId(hcPartyId, formId),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
				Promise<Array<ContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.listContactsByHCPartyAndFormIds(hcPartyId, arrayToList(
					formIds,
					"formIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun listContactsByHCPartyAndPatientSecretFKeys(
			hcPartyId: String,
			secretPatientKeys: Array<String>,
			planOfActionsIds: String?,
			skipClosedContacts: Boolean?,
		): Promise<Array<ContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.listContactsByHCPartyAndPatientSecretFKeys(hcPartyId, arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				), planOfActionsIds, skipClosedContacts),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun closeForHCPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<ContactJs>> = GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.closeForHCPartyPatientForeignKeys(hcPartyId, arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun getService(serviceId: String): Promise<ServiceJs> = GlobalScope.promise {
			service_toJs(contactApi.tryAndRecover.getService(serviceId))}


		override fun getServices(entityIds: Array<String>): Promise<Array<ServiceJs>> =
				GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.getServices(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Service ->
					service_toJs(x1)
				},
			)}


		override fun getServicesLinkedTo(linkType: String, ids: Array<String>): Promise<Array<ServiceJs>>
				= GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.getServicesLinkedTo(linkType, arrayToList(
					ids,
					"ids",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Service ->
					service_toJs(x1)
				},
			)}


		override fun listServicesByAssociationId(associationId: String): Promise<Array<ServiceJs>> =
				GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.listServicesByAssociationId(associationId),
				{ x1: Service ->
					service_toJs(x1)
				},
			)}


		override fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
				Promise<Array<ServiceJs>> = GlobalScope.promise {
			listToArray(
				contactApi.tryAndRecover.listServicesByHealthElementId(hcPartyId, healthElementId),
				{ x1: Service ->
					service_toJs(x1)
				},
			)}


		override fun findContactsByOpeningDate(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
			startKey: dynamic,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<ContactJs>> = GlobalScope.promise {
			paginatedList_toJs(
				contactApi.tryAndRecover.findContactsByOpeningDate(com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate,
						"startDate"), com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"),
						hcPartyId, com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey,
						"startKey"), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
						"limit")),
				{ x1: Contact ->
					contact_toJs(x1)
				},
			)}


		override fun filterServicesBy(
			filterChain: FilterChainJs<EncryptedServiceJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<ServiceJs>> = GlobalScope.promise {
			paginatedList_toJs(
				contactApi.tryAndRecover.filterServicesBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.embed.EncryptedServiceJs ->
				    com.icure.sdk.js.model.embed.service_fromJs(x1)
				  },
				), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Service ->
					service_toJs(x1)
				},
			)}

	}

	override fun createContact(entity: DecryptedContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		contact_toJs(contactApi.createContact(com.icure.sdk.js.model.contact_fromJs(entity)))}


	override fun createContacts(entities: Array<DecryptedContactJs>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactApi.createContacts(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedContactJs ->
					contact_fromJs(x1)
				},
			)),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun withEncryptionMetadata(
		base: DecryptedContactJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedContactJs> = GlobalScope.promise {
		contact_toJs(contactApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.contact_fromJs(nonNull1)
		}, com.icure.sdk.js.model.patient_fromJs(patient), user?.let { nonNull1 ->
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


	override fun matchContactsBy(filter: AbstractFilterJs<EncryptedContactJs>): Promise<Array<String>>
			= GlobalScope.promise {
		listToArray(
			contactApi.matchContactsBy(abstractFilter_fromJs(
				filter,
				{ x1: EncryptedContactJs ->
					contact_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun deleteContact(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(contactApi.deleteContact(entityId))}


	override fun deleteContacts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			contactApi.deleteContacts(arrayToList(
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


	override fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		listToArray(
			contactApi.findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: IcureStub ->
				icureStub_toJs(x1)
			},
		)}


	override fun getServiceCodesOccurrences(codeType: String, minOccurrences: Double):
			Promise<Array<LabelledOccurenceJs>> = GlobalScope.promise {
		listToArray(
			contactApi.getServiceCodesOccurrences(codeType, numberToLong(minOccurrences, "minOccurrences")),
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)}


	override fun shareWith(
		delegateId: String,
		contact: DecryptedContactJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedContactJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			contactApi.shareWith(delegateId, com.icure.sdk.js.model.contact_fromJs(contact),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedContactJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			contactApi.findContactsByHcPartyPatient(hcPartyId,
					com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun modifyContact(entity: DecryptedContactJs): Promise<DecryptedContactJs> =
			GlobalScope.promise {
		contact_toJs(contactApi.modifyContact(com.icure.sdk.js.model.contact_fromJs(entity)))}


	override fun modifyContacts(entities: Array<DecryptedContactJs>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactApi.modifyContacts(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedContactJs ->
					contact_fromJs(x1)
				},
			)),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun getContact(entityId: String): Promise<DecryptedContactJs> = GlobalScope.promise {
		contact_toJs(contactApi.getContact(entityId))}


	override fun getContacts(entityIds: Array<String>): Promise<Array<DecryptedContactJs>> =
			GlobalScope.promise {
		listToArray(
			contactApi.getContacts(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun filterContactsBy(
		filterChain: FilterChainJs<EncryptedContactJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedContactJs>> = GlobalScope.promise {
		paginatedList_toJs(
			contactApi.filterContactsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.EncryptedContactJs ->
			    com.icure.sdk.js.model.contact_fromJs(x1)
			  },
			), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactApi.listContactByHCPartyServiceId(hcPartyId, serviceId),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun listContactsByExternalId(externalId: String): Promise<Array<DecryptedContactJs>> =
			GlobalScope.promise {
		listToArray(
			contactApi.listContactsByExternalId(externalId),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactApi.listContactsByHCPartyAndFormId(hcPartyId, formId),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
			Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactApi.listContactsByHCPartyAndFormIds(hcPartyId, arrayToList(
				formIds,
				"formIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: Array<String>,
		planOfActionsIds: String?,
		skipClosedContacts: Boolean?,
	): Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactApi.listContactsByHCPartyAndPatientSecretFKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			), planOfActionsIds, skipClosedContacts),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun closeForHCPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactApi.closeForHCPartyPatientForeignKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun getService(serviceId: String): Promise<DecryptedServiceJs> = GlobalScope.promise {
		service_toJs(contactApi.getService(serviceId))}


	override fun getServices(entityIds: Array<String>): Promise<Array<DecryptedServiceJs>> =
			GlobalScope.promise {
		listToArray(
			contactApi.getServices(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)}


	override fun getServicesLinkedTo(linkType: String, ids: Array<String>):
			Promise<Array<DecryptedServiceJs>> = GlobalScope.promise {
		listToArray(
			contactApi.getServicesLinkedTo(linkType, arrayToList(
				ids,
				"ids",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)}


	override fun listServicesByAssociationId(associationId: String): Promise<Array<DecryptedServiceJs>>
			= GlobalScope.promise {
		listToArray(
			contactApi.listServicesByAssociationId(associationId),
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)}


	override fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
			Promise<Array<DecryptedServiceJs>> = GlobalScope.promise {
		listToArray(
			contactApi.listServicesByHealthElementId(hcPartyId, healthElementId),
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)}


	override fun findContactsByOpeningDate(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
		startKey: dynamic,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedContactJs>> = GlobalScope.promise {
		paginatedList_toJs(
			contactApi.findContactsByOpeningDate(com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate,
					"startDate"), com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"),
					hcPartyId, com.icure.sdk.js.model.CheckedConverters.dynamicToJsonNullsafe(startKey,
					"startKey"), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
					"limit")),
			{ x1: DecryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun filterServicesBy(
		filterChain: FilterChainJs<EncryptedServiceJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedServiceJs>> = GlobalScope.promise {
		paginatedList_toJs(
			contactApi.filterServicesBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.embed.EncryptedServiceJs ->
			    com.icure.sdk.js.model.embed.service_fromJs(x1)
			  },
			), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedService ->
				service_toJs(x1)
			},
		)}

}
