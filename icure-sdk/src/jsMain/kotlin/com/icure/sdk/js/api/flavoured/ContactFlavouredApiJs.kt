// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.ContactShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactFlavouredApi")
public external interface ContactFlavouredApiJs<E : ContactJs, S : ServiceJs> {
	public fun shareWith(
		delegateId: String,
		contact: E,
		options: ContactFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(contact: E, delegates: Record<String, ContactShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(contact: E, delegates: Record<String, ContactShareOptionsJs>): Promise<E>

	public fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: ContactFlavouredApi_findContactsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun modifyContact(entity: E): Promise<E>

	public fun modifyContacts(entities: Array<E>): Promise<Array<E>>

	public fun getContact(entityId: String): Promise<E>

	public fun getContacts(entityIds: Array<String>): Promise<Array<E>>

	public fun filterContactsBy(
		filterChain: FilterChainJs<ContactJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String): Promise<Array<E>>

	public fun listContactsByExternalId(externalId: String): Promise<Array<E>>

	public fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String): Promise<Array<E>>

	public fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
			Promise<Array<E>>

	public fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: Array<String>,
		options: ContactFlavouredApi_listContactsByHCPartyAndPatientSecretFKeys_Options?,
	): Promise<Array<E>>

	public fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: Array<String>):
			Promise<Array<E>>

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
		options: ContactFlavouredApi_findContactsByOpeningDate_Options?,
	): Promise<PaginatedListJs<E>>

	public fun filterServicesBy(
		filterChain: FilterChainJs<ServiceJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<S>>

	public fun subscribeToServiceEvents(
		events: Array<String>,
		filter: AbstractFilterJs<ServiceJs>,
		eventFired: (S) -> Promise<Unit>,
		options: ContactFlavouredApi_subscribeToServiceEvents_Options?,
	): Promise<ConnectionJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<ContactJs>,
		eventFired: (E) -> Promise<Unit>,
		options: ContactFlavouredApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface ContactFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface ContactFlavouredApi_findContactsByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}

public external interface ContactFlavouredApi_listContactsByHCPartyAndPatientSecretFKeys_Options {
	public val planOfActionsIds: String?

	public val skipClosedContacts: Boolean?
}

public external interface ContactFlavouredApi_findContactsByOpeningDate_Options {
	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface ContactFlavouredApi_subscribeToServiceEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}

public external interface ContactFlavouredApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
