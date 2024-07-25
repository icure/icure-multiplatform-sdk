// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.ContactShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.ContactJs
import com.icure.sdk.js.model.DecryptedContactJs
import com.icure.sdk.js.model.EncryptedContactJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.`data`.LabelledOccurenceJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.embed.DecryptedServiceJs
import com.icure.sdk.js.model.embed.EncryptedServiceJs
import com.icure.sdk.js.model.embed.ServiceJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ContactApi")
public external interface ContactApiJs {
	public val encrypted: ContactFlavouredApiJs<EncryptedContactJs, EncryptedServiceJs>

	public val tryAndRecover: ContactFlavouredApiJs<ContactJs, ServiceJs>

	public fun createContact(entity: DecryptedContactJs): Promise<DecryptedContactJs>

	public fun createContacts(entities: Array<DecryptedContactJs>): Promise<Array<DecryptedContactJs>>

	public fun withEncryptionMetadata(
		base: DecryptedContactJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedContactJs>

	public fun getEncryptionKeysOf(contact: ContactJs): Promise<Array<String>>

	public fun hasWriteAccess(contact: ContactJs): Promise<Boolean>

	public fun decryptPatientIdOf(contact: ContactJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: ContactJs, delegates: Array<String>):
			Promise<Unit>

	public fun matchContactsBy(filter: AbstractFilterJs<ContactJs>): Promise<Array<String>>

	public fun matchServicesBy(filter: AbstractFilterJs<ServiceJs>): Promise<Array<String>>

	public fun deleteContact(entityId: String): Promise<DocIdentifierJs>

	public fun deleteContacts(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun findContactsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>>

	public fun getServiceCodesOccurrences(codeType: String, minOccurrences: Double):
			Promise<Array<LabelledOccurenceJs>>

	public fun subscribeToServiceEvents(
		events: Array<String>,
		filter: AbstractFilterJs<ServiceJs>,
		subscriptionConfig: EntitySubscriptionConfigurationJs,
	): Promise<EntitySubscriptionJs<EncryptedServiceJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<ContactJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedContactJs>>

	public fun shareWith(
		delegateId: String,
		contact: DecryptedContactJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedContactJs>>

	public fun tryShareWithMany(contact: DecryptedContactJs,
			delegates: Record<String, ContactShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedContactJs>>

	public fun shareWithMany(contact: DecryptedContactJs,
			delegates: Record<String, ContactShareOptionsJs>): Promise<DecryptedContactJs>

	public fun findContactsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedContactJs>>

	public fun modifyContact(entity: DecryptedContactJs): Promise<DecryptedContactJs>

	public fun modifyContacts(entities: Array<DecryptedContactJs>): Promise<Array<DecryptedContactJs>>

	public fun getContact(entityId: String): Promise<DecryptedContactJs>

	public fun getContacts(entityIds: Array<String>): Promise<Array<DecryptedContactJs>>

	public fun filterContactsBy(
		filterChain: FilterChainJs<ContactJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedContactJs>>

	public fun listContactByHCPartyServiceId(hcPartyId: String, serviceId: String):
			Promise<Array<DecryptedContactJs>>

	public fun listContactsByExternalId(externalId: String): Promise<Array<DecryptedContactJs>>

	public fun listContactsByHCPartyAndFormId(hcPartyId: String, formId: String):
			Promise<Array<DecryptedContactJs>>

	public fun listContactsByHCPartyAndFormIds(hcPartyId: String, formIds: Array<String>):
			Promise<Array<DecryptedContactJs>>

	public fun listContactsByHCPartyAndPatientSecretFKeys(
		hcPartyId: String,
		secretPatientKeys: Array<String>,
		options: dynamic,
	): Promise<Array<DecryptedContactJs>>

	public fun closeForHCPartyPatientForeignKeys(hcPartyId: String, secretPatientKeys: Array<String>):
			Promise<Array<DecryptedContactJs>>

	public fun getService(serviceId: String): Promise<DecryptedServiceJs>

	public fun getServices(entityIds: Array<String>): Promise<Array<DecryptedServiceJs>>

	public fun getServicesLinkedTo(linkType: String, ids: Array<String>):
			Promise<Array<DecryptedServiceJs>>

	public fun listServicesByAssociationId(associationId: String): Promise<Array<DecryptedServiceJs>>

	public fun listServicesByHealthElementId(hcPartyId: String, healthElementId: String):
			Promise<Array<DecryptedServiceJs>>

	public fun findContactsByOpeningDate(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
		options: dynamic,
	): Promise<PaginatedListJs<DecryptedContactJs>>

	public fun filterServicesBy(
		filterChain: FilterChainJs<ServiceJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedServiceJs>>
}
