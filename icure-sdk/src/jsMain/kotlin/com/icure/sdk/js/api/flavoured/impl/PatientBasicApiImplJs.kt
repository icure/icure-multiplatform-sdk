// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.PatientBasicApi
import com.icure.sdk.js.api.flavoured.PatientBasicApiJs
import com.icure.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.embed.EncryptedContentJs
import com.icure.sdk.js.model.embed.content_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.model.listOfIds_fromJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.patient_toJs
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PatientBasicApiImplJs(
	private val patientBasicApi: PatientBasicApi,
) : PatientBasicApiJs {
	override fun matchPatientsBy(filter: AbstractFilterJs<EncryptedPatientJs>): Promise<Array<String>>
			= GlobalScope.promise {
		listToArray(
			patientBasicApi.matchPatientsBy(abstractFilter_fromJs(
				filter,
				{ x1: EncryptedPatientJs ->
					patient_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun deletePatient(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(patientBasicApi.deletePatient(entityId))}


	override fun deletePatients(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			patientBasicApi.deletePatients(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun undeletePatient(patientIds: String): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			patientBasicApi.undeletePatient(patientIds),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs> =
			GlobalScope.promise {
		entityAccessInformation_toJs(patientBasicApi.getDataOwnersWithAccessTo(com.icure.sdk.js.model.patient_fromJs(patient)))}


	override fun modifyPatient(entity: EncryptedPatientJs): Promise<EncryptedPatientJs> =
			GlobalScope.promise {
		patient_toJs(patientBasicApi.modifyPatient(com.icure.sdk.js.model.patient_fromJs(entity)))}


	override fun getPatient(entityId: String): Promise<EncryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientBasicApi.getPatient(entityId))}


	override fun filterPatientsBy(
		filterChain: FilterChainJs<EncryptedPatientJs>,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		skip: Double?,
		sort: String?,
		desc: Boolean?,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.filterPatientsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.EncryptedPatientJs ->
			    com.icure.sdk.js.model.patient_fromJs(x1)
			  },
			), startKey, startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
					"limit"), com.icure.sdk.js.model.CheckedConverters.numberToInt(skip, "skip"), sort, desc),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String?,
		filterValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.findPatientsByNameBirthSsinAuto(healthcarePartyId, filterValue, startKey,
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.couchdb.sortDirection_fromJs(sortDirection)),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.listPatientsOfHcParty(hcPartyId, sortField, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.couchdb.sortDirection_fromJs(sortDirection)),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun listOfMergesAfter(date: Double): Promise<Array<EncryptedPatientJs>> =
			GlobalScope.promise {
		listToArray(
			patientBasicApi.listOfMergesAfter(numberToLong(date, "date")),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun findPatientsModifiedAfter(
		date: Double,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.findPatientsModifiedAfter(com.icure.sdk.js.model.CheckedConverters.numberToLong(date,
					"date"), com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.listPatientsByHcParty(hcPartyId, sortField, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.couchdb.sortDirection_fromJs(sortDirection)),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<dynamic> =
			GlobalScope.promise {
		mapToObject<_, _, String>(
			patientBasicApi.getPatientHcPartyKeysForDelegate(patientId),
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)}


	override fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs> =
			GlobalScope.promise {
		content_toJs(patientBasicApi.countOfPatients(hcPartyId))}


	override fun findPatientsByHealthcareParty(
		hcPartyId: String?,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.findPatientsByHealthcareParty(hcPartyId, sortField, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.couchdb.sortDirection_fromJs(sortDirection)),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<String>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.findPatientsIdsByHealthcareParty(hcPartyId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: String ->
				x1
			},
		)}


	override fun getPatientByExternalId(externalId: String): Promise<EncryptedPatientJs> =
			GlobalScope.promise {
		patient_toJs(patientBasicApi.getPatientByExternalId(externalId))}


	override fun findPatientsByAccessLogUserAfterDate(
		userId: String,
		accessType: String?,
		startDate: Double?,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.findPatientsByAccessLogUserAfterDate(userId, accessType,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"), startKey,
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Double?,
	): Promise<Array<EncryptedPatientJs>> = GlobalScope.promise {
		listToArray(
			patientBasicApi.fuzzySearch(firstName, lastName, numberToInt(dateOfBirth, "dateOfBirth")),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun findDeletedPatients(
		startDate: Double,
		endDate: Double?,
		desc: Boolean?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.findDeletedPatients(com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate,
					"startDate"), com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), desc,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"), startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun listDeletedPatientsByName(firstName: String?, lastName: String?):
			Promise<Array<EncryptedPatientJs>> = GlobalScope.promise {
		listToArray(
			patientBasicApi.listDeletedPatientsByName(firstName, lastName),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun getPatients(patientIds: ListOfIdsJs): Promise<Array<EncryptedPatientJs>> =
			GlobalScope.promise {
		listToArray(
			patientBasicApi.getPatients(listOfIds_fromJs(patientIds)),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	): Promise<EncryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientBasicApi.getPatientByHealthcarePartyAndIdentifier(hcPartyId, id, system))}


	override fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			patientBasicApi.modifyPatients(arrayToList(
				patientDtos,
				"patientDtos",
				{ x1: EncryptedPatientJs ->
					patient_fromJs(x1)
				},
			)),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Double?,
		end: Double?,
	): Promise<EncryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientBasicApi.modifyPatientReferral(patientId, referralId,
				com.icure.sdk.js.model.CheckedConverters.numberToLong(start, "start"),
				com.icure.sdk.js.model.CheckedConverters.numberToLong(end, "end")))}


	override fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.findDuplicatesBySsin(hcPartyId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientBasicApi.findDuplicatesByName(hcPartyId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<EncryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientBasicApi.mergePatients(intoId, fromId, expectedFromRev,
				com.icure.sdk.js.model.patient_fromJs(updatedInto)))}

}
