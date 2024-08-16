// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.EncryptedContactJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
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

	public fun deleteContact(entityId: String): Promise<DocIdentifierJs>

	public fun deleteContacts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>>

	public fun getServiceCodesOccurrences(codeType: String, minOccurrences: Double):
			Promise<Array<LabelledOccurenceJs>>

	public fun modifyContact(entity: EncryptedContactJs): Promise<EncryptedContactJs>

	public fun modifyContacts(entities: Array<EncryptedContactJs>): Promise<Array<EncryptedContactJs>>

	public fun getContact(entityId: String): Promise<EncryptedContactJs>

	public fun getContacts(entityIds: Array<String>): Promise<Array<EncryptedContactJs>>

	public fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
			Promise<Array<EncryptedContactJs>>

	public fun listContactsByExternalId(externalId: String): Promise<Array<EncryptedContactJs>>

	public fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
			Promise<Array<EncryptedContactJs>>

	public fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
			Promise<Array<EncryptedContactJs>>

	public fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: Array<String>,
		options: dynamic,
	): Promise<Array<EncryptedContactJs>>

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
