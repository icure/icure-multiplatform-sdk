// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.ContactShareOptionsJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.ContactJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.embed.ServiceJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactFlavouredApi")
public external interface ContactFlavouredApiJs<E : ContactJs, S : ServiceJs> {
	public fun shareWith(
		delegateId: String,
		contact: E,
		options: dynamic,
	): Promise<E>

	public fun shareWithMany(contact: E, delegates: Record<String, ContactShareOptionsJs>): Promise<E>

	public fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<E>>

	public fun filterContactsBy(filter: FilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterServicesBy(filter: FilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<S>>

	public fun filterContactsBySorted(filter: SortableFilterOptionsJs<ContactJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterServicesBySorted(filter: SortableFilterOptionsJs<ServiceJs>):
			Promise<PaginatedListIteratorJs<S>>

	public fun undeleteContactById(id: String, rev: String): Promise<E>

	public fun undeleteContact(contact: ContactJs): Promise<E>

	public fun modifyContact(entity: E): Promise<E>

	public fun modifyContacts(entities: Array<E>): Promise<Array<E>>

	public fun getContact(entityId: String): Promise<E>

	public fun getContacts(entityIds: Array<String>): Promise<Array<E>>

	public fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): Promise<Array<E>>

	public fun listContactsByExternalId(externalId: String): Promise<Array<E>>

	public fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): Promise<Array<E>>

	public fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
			Promise<Array<E>>

	public fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: Array<String>,
		options: dynamic,
	): Promise<Array<E>>

	public fun getService(serviceId: String): Promise<S>

	public fun getServices(entityIds: Array<String>): Promise<Array<S>>

	public fun getServicesLinkedTo(linkType: String, ids: Array<String>): Promise<Array<S>>

	public fun listServicesByAssociationId(associationId: String): Promise<Array<S>>

	public fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
			Promise<Array<S>>

	public fun findContactsByOpeningDate(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
		options: dynamic,
	): Promise<PaginatedListJs<E>>
}
