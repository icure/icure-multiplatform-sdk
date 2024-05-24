// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ContactBasicApi
import com.icure.sdk.js.api.flavoured.ContactBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
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
import com.icure.sdk.js.model.embed.service_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.EncryptedContact
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.`data`.LabelledOccurence
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.EncryptedService
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
internal class ContactBasicApiImplJs(
	private val contactBasicApi: ContactBasicApi,
) : ContactBasicApiJs {
	override fun matchContactsBy(filter: AbstractFilterJs<EncryptedContactJs>): Promise<Array<String>>
			= GlobalScope.promise {
		listToArray(
			contactBasicApi.matchContactsBy(abstractFilter_fromJs(
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
		docIdentifier_toJs(contactBasicApi.deleteContact(entityId))}


	override fun deleteContacts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			contactBasicApi.deleteContacts(arrayToList(
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
			contactBasicApi.findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
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
			contactBasicApi.getServiceCodesOccurrences(codeType, numberToLong(minOccurrences,
					"minOccurrences")),
			{ x1: LabelledOccurence ->
				labelledOccurence_toJs(x1)
			},
		)}


	override fun modifyContact(entity: EncryptedContactJs): Promise<EncryptedContactJs> =
			GlobalScope.promise {
		contact_toJs(contactBasicApi.modifyContact(com.icure.sdk.js.model.contact_fromJs(entity)))}


	override fun modifyContacts(entities: Array<EncryptedContactJs>):
			Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactBasicApi.modifyContacts(arrayToList(
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
		contact_toJs(contactBasicApi.getContact(entityId))}


	override fun getContacts(entityIds: Array<String>): Promise<Array<EncryptedContactJs>> =
			GlobalScope.promise {
		listToArray(
			contactBasicApi.getContacts(arrayToList(
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
			contactBasicApi.filterContactsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
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
			contactBasicApi.listContactByHCPartyServiceId(hcPartyId, serviceId),
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun listContactsByExternalId(externalId: String): Promise<Array<EncryptedContactJs>> =
			GlobalScope.promise {
		listToArray(
			contactBasicApi.listContactsByExternalId(externalId),
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
			Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactBasicApi.listContactsByHCPartyAndFormId(hcPartyId, formId),
			{ x1: EncryptedContact ->
				contact_toJs(x1)
			},
		)}


	override fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
			Promise<Array<EncryptedContactJs>> = GlobalScope.promise {
		listToArray(
			contactBasicApi.listContactsByHCPartyAndFormIds(hcPartyId, arrayToList(
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
			contactBasicApi.listContactsByHCPartyAndPatientSecretFKeys(hcPartyId, arrayToList(
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
			contactBasicApi.closeForHCPartyPatientForeignKeys(hcPartyId, arrayToList(
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
		service_toJs(contactBasicApi.getService(serviceId))}


	override fun getServices(entityIds: Array<String>): Promise<Array<EncryptedServiceJs>> =
			GlobalScope.promise {
		listToArray(
			contactBasicApi.getServices(arrayToList(
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
			contactBasicApi.getServicesLinkedTo(linkType, arrayToList(
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


	override fun listServicesByAssociationId(associationId: String): Promise<Array<EncryptedServiceJs>>
			= GlobalScope.promise {
		listToArray(
			contactBasicApi.listServicesByAssociationId(associationId),
			{ x1: EncryptedService ->
				service_toJs(x1)
			},
		)}


	override fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
			Promise<Array<EncryptedServiceJs>> = GlobalScope.promise {
		listToArray(
			contactBasicApi.listServicesByHealthElementId(hcPartyId, healthElementId),
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
			contactBasicApi.findContactsByOpeningDate(com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate,
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
			contactBasicApi.filterServicesBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
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
