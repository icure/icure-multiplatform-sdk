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
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
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

	public fun filterPatientsBy(
		filterChain: FilterChainJs<PatientJs>,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		skip: Double?,
		sort: String?,
		desc: Boolean?,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String?,
		filterValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listOfMergesAfter(date: Double): Promise<Array<EncryptedPatientJs>>

	public fun findPatientsModifiedAfter(
		date: Double,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<dynamic>

	public fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs>

	public fun findPatientsByHealthcareParty(
		hcPartyId: String?,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<EncryptedPatientJs>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Double?,
	): Promise<Array<EncryptedPatientJs>>

	public fun findDeletedPatients(
		startDate: Double,
		endDate: Double?,
		desc: Boolean?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun listDeletedPatientsByName(firstName: String?, lastName: String?):
			Promise<Array<EncryptedPatientJs>>

	public fun getPatients(patientIds: ListOfIdsJs): Promise<Array<EncryptedPatientJs>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	): Promise<EncryptedPatientJs>

	public fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Double?,
		end: Double?,
	): Promise<EncryptedPatientJs>

	public fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>>

	public fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<EncryptedPatientJs>
}
