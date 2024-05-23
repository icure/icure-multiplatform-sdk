// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.embed.EncryptedContentJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PatientFlavouredApi")
public external interface PatientFlavouredApiJs<E : PatientJs> {
	public fun shareWith(
		delegateId: String,
		patient: E,
		shareSecretIds: Array<String>,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<E>>

	public fun initialiseConfidentialSecretId(patient: E): Promise<E>

	public fun modifyPatient(entity: E): Promise<E>

	public fun getPatient(entityId: String): Promise<E>

	public fun filterPatientsBy(
		filterChain: FilterChainJs<EncryptedPatientJs>,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		skip: Double?,
		sort: String?,
		desc: Boolean?,
	): Promise<PaginatedListJs<E>>

	public fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String?,
		filterValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<E>>

	public fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<E>>

	public fun listOfMergesAfter(date: Double): Promise<Array<E>>

	public fun findPatientsModifiedAfter(
		date: Double,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<E>>

	public fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<dynamic>

	public fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs>

	public fun findPatientsByHealthcareParty(
		hcPartyId: String?,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<E>>

	public fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<E>

	public fun findPatientsByAccessLogUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Double?,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Double?,
	): Promise<Array<E>>

	public fun findDeletedPatients(
		startDate: Double,
		endDate: Double?,
		desc: Boolean?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun listDeletedPatientsByName(firstName: String?, lastName: String?): Promise<Array<E>>

	public fun getPatients(patientIds: ListOfIdsJs): Promise<Array<E>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	): Promise<E>

	public fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Double?,
		end: Double?,
	): Promise<E>

	public fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<E>
}
