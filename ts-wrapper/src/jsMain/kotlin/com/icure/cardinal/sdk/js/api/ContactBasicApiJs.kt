// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.EncryptedContactJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.embed.EncryptedServiceJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactBasicApi")
public external interface ContactBasicApiJs {
	public fun matchContactsBy(filter: BaseFilterOptionsJs<ContactJs>): Promise<Array<String>>

	public fun matchServicesBy(filter: BaseFilterOptionsJs<ServiceJs>): Promise<Array<String>>

	public fun matchContactsBySorted(filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<Array<String>>

	public fun matchServicesBySorted(filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<Array<String>>

	public fun filterContactsBy(filter: BaseFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<EncryptedContactJs>>

	public fun filterServicesBy(filter: BaseFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<EncryptedServiceJs>>

	public fun filterContactsBySorted(filter: BaseSortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<EncryptedContactJs>>

	public fun filterServicesBySorted(filter: BaseSortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<EncryptedServiceJs>>

	public fun subscribeToServiceCreateOrUpdateEvents(filter: BaseFilterOptionsJs<ServiceJs>,
			options: dynamic): Promise<EntitySubscriptionJs<EncryptedServiceJs>>

	public fun deleteContactUnsafe(entityId: String): Promise<DocIdentifierJs>

	public fun deleteContactsUnsafe(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun deleteContactById(entityId: String, rev: String): Promise<DocIdentifierJs>

	public fun deleteContactsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>>

	public fun purgeContactById(id: String, rev: String): Promise<Unit>

	public fun deleteContact(contact: ContactJs): Promise<DocIdentifierJs>

	public fun deleteContacts(contacts: Array<ContactJs>): Promise<Array<DocIdentifierJs>>

	public fun purgeContact(contact: ContactJs): Promise<Unit>

	public fun getServiceCodesOccurrences(codeType: String, minOccurrences: Double):
			Promise<Array<LabelledOccurenceJs>>

	public fun createContact(entity: EncryptedContactJs): Promise<EncryptedContactJs>

	public fun createContacts(entities: Array<EncryptedContactJs>): Promise<Array<EncryptedContactJs>>

	public fun undeleteContactById(id: String, rev: String): Promise<EncryptedContactJs>

	public fun undeleteContact(contact: ContactJs): Promise<EncryptedContactJs>

	public fun modifyContact(entity: EncryptedContactJs): Promise<EncryptedContactJs>

	public fun modifyContacts(entities: Array<EncryptedContactJs>): Promise<Array<EncryptedContactJs>>

	public fun getContact(entityId: String): Promise<EncryptedContactJs?>

	public fun getContacts(entityIds: Array<String>): Promise<Array<EncryptedContactJs>>

	public fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
			Promise<Array<EncryptedContactJs>>

	public fun listContactsByExternalId(externalId: String): Promise<Array<EncryptedContactJs>>

	public fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
			Promise<Array<EncryptedContactJs>>

	public fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
			Promise<Array<EncryptedContactJs>>

	public fun getService(serviceId: String): Promise<EncryptedServiceJs>

	public fun getServices(entityIds: Array<String>): Promise<Array<EncryptedServiceJs>>

	public fun getServicesLinkedTo(linkType: String, ids: Array<String>):
			Promise<Array<EncryptedServiceJs>>

	public fun listServicesByAssociationId(associationId: String): Promise<Array<EncryptedServiceJs>>

	public fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
			Promise<Array<EncryptedServiceJs>>

	public fun findContactsByOpeningDate(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
		options: dynamic,
	): Promise<PaginatedListJs<EncryptedContactJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<ContactJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedContactJs>>
}
