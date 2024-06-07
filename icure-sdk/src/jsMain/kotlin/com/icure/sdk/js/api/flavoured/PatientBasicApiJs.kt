// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
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

@JsName("PatientBasicApi")
public external interface PatientBasicApiJs {
	public fun matchPatientsBy(filter: AbstractFilterJs<PatientJs>): Promise<Array<String>>

	public fun deletePatient(entityId: String): Promise<DocIdentifierJs>

	public fun deletePatients(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun undeletePatient(patientIds: String): Promise<Array<DocIdentifierJs>>

	public fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs>

	public fun modifyPatient(entity: EncryptedPatientJs): Promise<EncryptedPatientJs>

	public fun getPatient(entityId: String): Promise<EncryptedPatientJs>

	public fun filterPatientsBy(filterChain: FilterChainJs<PatientJs>,
			options: PatientBasicApi_filterPatientsBy_Options?): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findPatientsByNameBirthSsinAuto(filterValue: String,
			options: PatientBasicApi_findPatientsByNameBirthSsinAuto_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listPatientsOfHcParty(hcPartyId: String,
			options: PatientBasicApi_listPatientsOfHcParty_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listOfMergesAfter(date: Double): Promise<Array<EncryptedPatientJs>>

	public fun findPatientsModifiedAfter(date: Double,
			options: PatientBasicApi_findPatientsModifiedAfter_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listPatientsByHcParty(hcPartyId: String,
			options: PatientBasicApi_listPatientsByHcParty_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<Record<String, String>>

	public fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs>

	public
			fun findPatientsByHealthcareParty(options: PatientBasicApi_findPatientsByHealthcareParty_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findPatientsIdsByHealthcareParty(hcPartyId: String,
			options: PatientBasicApi_findPatientsIdsByHealthcareParty_Options?):
			Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<EncryptedPatientJs>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		options: PatientBasicApi_fuzzySearch_Options?,
	): Promise<Array<EncryptedPatientJs>>

	public fun findDeletedPatients(startDate: Double,
			options: PatientBasicApi_findDeletedPatients_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listDeletedPatientsByName(options: PatientBasicApi_listDeletedPatientsByName_Options?):
			Promise<Array<EncryptedPatientJs>>

	public fun getPatients(patientIds: ListOfIdsJs): Promise<Array<EncryptedPatientJs>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		options: PatientBasicApi_getPatientByHealthcarePartyAndIdentifier_Options?,
	): Promise<EncryptedPatientJs>

	public fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		options: PatientBasicApi_modifyPatientReferral_Options?,
	): Promise<EncryptedPatientJs>

	public fun findDuplicatesBySsin(hcPartyId: String,
			options: PatientBasicApi_findDuplicatesBySsin_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findDuplicatesByName(hcPartyId: String,
			options: PatientBasicApi_findDuplicatesByName_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<EncryptedPatientJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<PatientJs>,
		eventFired: (EncryptedPatientJs) -> Promise<Unit>,
		options: PatientBasicApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface PatientBasicApi_filterPatientsBy_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val skip: Double?

	public val sort: String?

	public val desc: Boolean?
}

public external interface PatientBasicApi_findPatientsByNameBirthSsinAuto_Options {
	public val healthcarePartyId: String?

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientBasicApi_listPatientsOfHcParty_Options {
	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientBasicApi_findPatientsModifiedAfter_Options {
	public val startKey: Double?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientBasicApi_listPatientsByHcParty_Options {
	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientBasicApi_findPatientsByHealthcareParty_Options {
	public val hcPartyId: String?

	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientBasicApi_findPatientsIdsByHealthcareParty_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientBasicApi_fuzzySearch_Options {
	public val dateOfBirth: Double?
}

public external interface PatientBasicApi_findDeletedPatients_Options {
	public val endDate: Double?

	public val desc: Boolean?

	public val startKey: Double?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientBasicApi_listDeletedPatientsByName_Options {
	public val firstName: String?

	public val lastName: String?
}

public external interface PatientBasicApi_getPatientByHealthcarePartyAndIdentifier_Options {
	public val system: String?
}

public external interface PatientBasicApi_modifyPatientReferral_Options {
	public val start: Double?

	public val end: Double?
}

public external interface PatientBasicApi_findDuplicatesBySsin_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientBasicApi_findDuplicatesByName_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientBasicApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
