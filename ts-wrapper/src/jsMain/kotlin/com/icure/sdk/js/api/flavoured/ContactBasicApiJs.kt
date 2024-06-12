// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.EncryptedContactJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactBasicApi")
public external interface ContactBasicApiJs {
	public fun matchContactsBy(filter: AbstractFilterJs<ContactJs>): Promise<Array<String>>

	public fun matchServicesBy(filter: AbstractFilterJs<ServiceJs>): Promise<Array<String>>

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

	public fun filterContactsBy(
		filterChain: FilterChainJs<ContactJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedContactJs>>

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
		options: ContactBasicApi_listContactsByHCPartyAndPatientSecretFKeys_Options?,
	): Promise<Array<EncryptedContactJs>>

	public fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: Array<String>):
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
		options: ContactBasicApi_findContactsByOpeningDate_Options?,
	): Promise<PaginatedListJs<EncryptedContactJs>>

	public fun filterServicesBy(
		filterChain: FilterChainJs<ServiceJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedServiceJs>>

	public fun subscribeToServiceEvents(
		events: Array<String>,
		filter: AbstractFilterJs<ServiceJs>,
		eventFired: (EncryptedServiceJs) -> Promise<Unit>,
		options: ContactBasicApi_subscribeToServiceEvents_Options?,
	): Promise<ConnectionJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<ContactJs>,
		eventFired: (EncryptedContactJs) -> Promise<Unit>,
		options: ContactBasicApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface ContactBasicApi_listContactsByHCPartyAndPatientSecretFKeys_Options {
	public val planOfActionsIds: String?

	public val skipClosedContacts: Boolean?
}

public external interface ContactBasicApi_findContactsByOpeningDate_Options {
	public val startKey: dynamic

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface ContactBasicApi_subscribeToServiceEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}

public external interface ContactBasicApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
