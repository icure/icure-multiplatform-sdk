// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.PatientShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.embed.EncryptedContentJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PatientFlavouredApi")
public external interface PatientFlavouredApiJs<E : PatientJs> {
	public fun shareWith(
		delegateId: String,
		patient: E,
		shareSecretIds: Array<String>,
		options: PatientFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(patient: E, delegates: Record<String, PatientShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(patient: E, delegates: Record<String, PatientShareOptionsJs>): Promise<E>

	public fun initialiseConfidentialSecretId(patient: E): Promise<E>

	public fun modifyPatient(entity: E): Promise<E>

	public fun getPatient(entityId: String): Promise<E>

	public fun filterPatientsBy(filterChain: FilterChainJs<PatientJs>,
			options: PatientFlavouredApi_filterPatientsBy_Options?): Promise<PaginatedListJs<E>>

	public fun findPatientsByNameBirthSsinAuto(filterValue: String,
			options: PatientFlavouredApi_findPatientsByNameBirthSsinAuto_Options?):
			Promise<PaginatedListJs<E>>

	public fun listPatientsOfHcParty(hcPartyId: String,
			options: PatientFlavouredApi_listPatientsOfHcParty_Options?): Promise<PaginatedListJs<E>>

	public fun listOfMergesAfter(date: Double): Promise<Array<E>>

	public fun findPatientsModifiedAfter(date: Double,
			options: PatientFlavouredApi_findPatientsModifiedAfter_Options?): Promise<PaginatedListJs<E>>

	public fun listPatientsByHcParty(hcPartyId: String,
			options: PatientFlavouredApi_listPatientsByHcParty_Options?): Promise<PaginatedListJs<E>>

	public fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<Record<String, String>>

	public fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs>

	public
			fun findPatientsByHealthcareParty(options: PatientFlavouredApi_findPatientsByHealthcareParty_Options?):
			Promise<PaginatedListJs<E>>

	public fun findPatientsIdsByHealthcareParty(hcPartyId: String,
			options: PatientFlavouredApi_findPatientsIdsByHealthcareParty_Options?):
			Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<E>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		options: PatientFlavouredApi_fuzzySearch_Options?,
	): Promise<Array<E>>

	public fun findDeletedPatients(startDate: Double,
			options: PatientFlavouredApi_findDeletedPatients_Options?): Promise<PaginatedListJs<E>>

	public
			fun listDeletedPatientsByName(options: PatientFlavouredApi_listDeletedPatientsByName_Options?):
			Promise<Array<E>>

	public fun getPatients(patientIds: ListOfIdsJs): Promise<Array<E>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		options: PatientFlavouredApi_getPatientByHealthcarePartyAndIdentifier_Options?,
	): Promise<E>

	public fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		options: PatientFlavouredApi_modifyPatientReferral_Options?,
	): Promise<E>

	public fun findDuplicatesBySsin(hcPartyId: String,
			options: PatientFlavouredApi_findDuplicatesBySsin_Options?): Promise<PaginatedListJs<E>>

	public fun findDuplicatesByName(hcPartyId: String,
			options: PatientFlavouredApi_findDuplicatesByName_Options?): Promise<PaginatedListJs<E>>

	public fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<E>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<PatientJs>,
		eventFired: (E) -> Promise<Unit>,
		options: PatientFlavouredApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface PatientFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface PatientFlavouredApi_filterPatientsBy_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val skip: Double?

	public val sort: String?

	public val desc: Boolean?
}

public external interface PatientFlavouredApi_findPatientsByNameBirthSsinAuto_Options {
	public val healthcarePartyId: String?

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientFlavouredApi_listPatientsOfHcParty_Options {
	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientFlavouredApi_findPatientsModifiedAfter_Options {
	public val startKey: Double?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientFlavouredApi_listPatientsByHcParty_Options {
	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientFlavouredApi_findPatientsByHealthcareParty_Options {
	public val hcPartyId: String?

	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientFlavouredApi_findPatientsIdsByHealthcareParty_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientFlavouredApi_fuzzySearch_Options {
	public val dateOfBirth: Double?
}

public external interface PatientFlavouredApi_findDeletedPatients_Options {
	public val endDate: Double?

	public val desc: Boolean?

	public val startKey: Double?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientFlavouredApi_listDeletedPatientsByName_Options {
	public val firstName: String?

	public val lastName: String?
}

public external interface PatientFlavouredApi_getPatientByHealthcarePartyAndIdentifier_Options {
	public val system: String?
}

public external interface PatientFlavouredApi_modifyPatientReferral_Options {
	public val start: Double?

	public val end: Double?
}

public external interface PatientFlavouredApi_findDuplicatesBySsin_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientFlavouredApi_findDuplicatesByName_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientFlavouredApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
