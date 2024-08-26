// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.crypto.entities.PatientShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.filters.FilterOptionsJs
import com.icure.sdk.js.filters.SortableFilterOptionsJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
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
		options: PatientShareOptionsJs,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(patient: E, delegates: Record<String, PatientShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(patient: E, delegates: Record<String, PatientShareOptionsJs>): Promise<E>

	public fun initializeConfidentialSecretId(patient: E): Promise<E>

	public fun filterPatientsBy(filter: FilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun filterPatientsBySorted(filter: SortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun modifyPatient(entity: E): Promise<E>

	public fun getPatient(entityId: String): Promise<E>

	public fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?): Promise<E>

	public fun findPatientsByNameBirthSsinAuto(filterValue: String, options: dynamic):
			Promise<PaginatedListJs<E>>

	public fun listPatientsOfHcParty(hcPartyId: String, options: dynamic): Promise<PaginatedListJs<E>>

	public fun listOfMergesAfter(date: Double): Promise<Array<E>>

	public fun findPatientsModifiedAfter(date: Double, options: dynamic): Promise<PaginatedListJs<E>>

	public fun listPatientsByHcParty(hcPartyId: String, options: dynamic): Promise<PaginatedListJs<E>>

	public fun findPatientsByHealthcareParty(options: dynamic): Promise<PaginatedListJs<E>>

	public fun findPatientsIdsByHealthcareParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<E>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		options: dynamic,
	): Promise<Array<E>>

	public fun findDeletedPatients(startDate: Double, options: dynamic): Promise<PaginatedListJs<E>>

	public fun listDeletedPatientsByName(options: dynamic): Promise<Array<E>>

	public fun getPatients(patientIds: Array<String>): Promise<Array<E>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		options: dynamic,
	): Promise<E>

	public fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun findDuplicatesBySsin(hcPartyId: String, options: dynamic): Promise<PaginatedListJs<E>>

	public fun findDuplicatesByName(hcPartyId: String, options: dynamic): Promise<PaginatedListJs<E>>

	public fun mergePatients(from: PatientJs, mergedInto: E): Promise<E>
}
