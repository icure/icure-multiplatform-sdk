// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.PatientApi
import com.icure.sdk.js.api.flavoured.PatientApiJs
import com.icure.sdk.js.api.flavoured.PatientFlavouredApiJs
import com.icure.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.sdk.js.crypto.entities.EntityWithTypeInfoJs
import com.icure.sdk.js.crypto.entities.ShareAllPatientDataOptionsJs_ResultJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.sdk.js.crypto.entities.shareAllPatientDataOptions_Result_toJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.anyEntityWithTypeInfoToKt
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.sdk.js.model.DecryptedPatientJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.dataOwnerRegistrationSuccess_toJs
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
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.Patient
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PatientApiImplJs(
	private val patientApi: PatientApi,
) : PatientApiJs {
	override val encrypted: PatientFlavouredApiJs<EncryptedPatientJs> = object :
			PatientFlavouredApiJs<EncryptedPatientJs> {
		override fun shareWith(
			delegateId: String,
			patient: EncryptedPatientJs,
			shareSecretIds: Array<String>,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedPatientJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				patientApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.arrayToSet(
				  shareSecretIds,
				  "shareSecretIds",
				  { x1: kotlin.String ->
				    x1
				  },
				), com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)}


		override fun tryShareWithMany(patient: EncryptedPatientJs, delegates: dynamic):
				Promise<SimpleShareResultJs<EncryptedPatientJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				patientApi.encrypted.tryShareWithMany(com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.PatientShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.patientShareOptions_fromJs(x1)
				  },
				)),
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)}


		override fun shareWithMany(patient: EncryptedPatientJs, delegates: dynamic):
				Promise<EncryptedPatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.encrypted.shareWithMany(com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.PatientShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.patientShareOptions_fromJs(x1)
			  },
			)))}


		override fun initialiseConfidentialSecretId(patient: EncryptedPatientJs):
				Promise<EncryptedPatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.encrypted.initialiseConfidentialSecretId(com.icure.sdk.js.model.patient_fromJs(patient)))}


		override fun modifyPatient(entity: EncryptedPatientJs): Promise<EncryptedPatientJs> =
				GlobalScope.promise {
			patient_toJs(patientApi.encrypted.modifyPatient(com.icure.sdk.js.model.patient_fromJs(entity)))}


		override fun getPatient(entityId: String): Promise<EncryptedPatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.encrypted.getPatient(entityId))}


		override fun filterPatientsBy(
			filterChain: FilterChainJs<PatientJs>,
			startKey: String?,
			startDocumentId: String?,
			limit: Double?,
			skip: Double?,
			sort: String?,
			desc: Boolean?,
		): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.encrypted.filterPatientsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.PatientJs ->
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
				patientApi.encrypted.findPatientsByNameBirthSsinAuto(healthcarePartyId, filterValue, startKey,
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
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
				patientApi.encrypted.listPatientsOfHcParty(hcPartyId, sortField, startKey, startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)}


		override fun listOfMergesAfter(date: Double): Promise<Array<EncryptedPatientJs>> =
				GlobalScope.promise {
			listToArray(
				patientApi.encrypted.listOfMergesAfter(numberToLong(date, "date")),
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
				patientApi.encrypted.findPatientsModifiedAfter(com.icure.sdk.js.model.CheckedConverters.numberToLong(date,
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
				patientApi.encrypted.listPatientsByHcParty(hcPartyId, sortField, startKey, startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)}


		override fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<dynamic> =
				GlobalScope.promise {
			mapToObject<_, _, String>(
				patientApi.encrypted.getPatientHcPartyKeysForDelegate(patientId),
				{ x1: String ->
					x1
				},
				{ x1: String ->
					x1
				},
			)}


		override fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs> =
				GlobalScope.promise {
			content_toJs(patientApi.encrypted.countOfPatients(hcPartyId))}


		override fun findPatientsByHealthcareParty(
			hcPartyId: String?,
			sortField: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double?,
			sortDirection: String,
		): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.encrypted.findPatientsByHealthcareParty(hcPartyId, sortField, startKey,
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
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
				patientApi.encrypted.findPatientsIdsByHealthcareParty(hcPartyId, startKey, startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: String ->
					x1
				},
			)}


		override fun getPatientByExternalId(externalId: String): Promise<EncryptedPatientJs> =
				GlobalScope.promise {
			patient_toJs(patientApi.encrypted.getPatientByExternalId(externalId))}


		override fun fuzzySearch(
			firstName: String,
			lastName: String,
			dateOfBirth: Double?,
		): Promise<Array<EncryptedPatientJs>> = GlobalScope.promise {
			listToArray(
				patientApi.encrypted.fuzzySearch(firstName, lastName, numberToInt(dateOfBirth, "dateOfBirth")),
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
				patientApi.encrypted.findDeletedPatients(com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate,
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
				patientApi.encrypted.listDeletedPatientsByName(firstName, lastName),
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)}


		override fun getPatients(patientIds: ListOfIdsJs): Promise<Array<EncryptedPatientJs>> =
				GlobalScope.promise {
			listToArray(
				patientApi.encrypted.getPatients(listOfIds_fromJs(patientIds)),
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)}


		override fun getPatientByHealthcarePartyAndIdentifier(
			hcPartyId: String,
			id: String,
			system: String?,
		): Promise<EncryptedPatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.encrypted.getPatientByHealthcarePartyAndIdentifier(hcPartyId, id,
					system))}


		override fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>> =
				GlobalScope.promise {
			listToArray(
				patientApi.encrypted.modifyPatients(arrayToList(
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
			patient_toJs(patientApi.encrypted.modifyPatientReferral(patientId, referralId,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(start, "start"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(end, "end")))}


		override fun findDuplicatesBySsin(
			hcPartyId: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedPatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.encrypted.findDuplicatesBySsin(hcPartyId, startKey, startDocumentId,
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
				patientApi.encrypted.findDuplicatesByName(hcPartyId, startKey, startDocumentId,
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
			patient_toJs(patientApi.encrypted.mergePatients(intoId, fromId, expectedFromRev,
					com.icure.sdk.js.model.patient_fromJs(updatedInto)))}

	}

	override val tryAndRecover: PatientFlavouredApiJs<PatientJs> = object :
			PatientFlavouredApiJs<PatientJs> {
		override fun shareWith(
			delegateId: String,
			patient: PatientJs,
			shareSecretIds: Array<String>,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<PatientJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				patientApi.tryAndRecover.shareWith(delegateId, com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.arrayToSet(
				  shareSecretIds,
				  "shareSecretIds",
				  { x1: kotlin.String ->
				    x1
				  },
				), com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun tryShareWithMany(patient: PatientJs, delegates: dynamic):
				Promise<SimpleShareResultJs<PatientJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				patientApi.tryAndRecover.tryShareWithMany(com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.PatientShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.patientShareOptions_fromJs(x1)
				  },
				)),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun shareWithMany(patient: PatientJs, delegates: dynamic): Promise<PatientJs> =
				GlobalScope.promise {
			patient_toJs(patientApi.tryAndRecover.shareWithMany(com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.PatientShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.patientShareOptions_fromJs(x1)
			  },
			)))}


		override fun initialiseConfidentialSecretId(patient: PatientJs): Promise<PatientJs> =
				GlobalScope.promise {
			patient_toJs(patientApi.tryAndRecover.initialiseConfidentialSecretId(com.icure.sdk.js.model.patient_fromJs(patient)))}


		override fun modifyPatient(entity: PatientJs): Promise<PatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.tryAndRecover.modifyPatient(com.icure.sdk.js.model.patient_fromJs(entity)))}


		override fun getPatient(entityId: String): Promise<PatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.tryAndRecover.getPatient(entityId))}


		override fun filterPatientsBy(
			filterChain: FilterChainJs<PatientJs>,
			startKey: String?,
			startDocumentId: String?,
			limit: Double?,
			skip: Double?,
			sort: String?,
			desc: Boolean?,
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.filterPatientsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.PatientJs ->
				    com.icure.sdk.js.model.patient_fromJs(x1)
				  },
				), startKey, startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
						"limit"), com.icure.sdk.js.model.CheckedConverters.numberToInt(skip, "skip"), sort, desc),
				{ x1: Patient ->
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
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.findPatientsByNameBirthSsinAuto(healthcarePartyId, filterValue,
						startKey, startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
						"limit"), com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
				{ x1: Patient ->
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
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.listPatientsOfHcParty(hcPartyId, sortField, startKey, startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun listOfMergesAfter(date: Double): Promise<Array<PatientJs>> = GlobalScope.promise {
			listToArray(
				patientApi.tryAndRecover.listOfMergesAfter(numberToLong(date, "date")),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun findPatientsModifiedAfter(
			date: Double,
			startKey: Double?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.findPatientsModifiedAfter(com.icure.sdk.js.model.CheckedConverters.numberToLong(date,
						"date"), com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"),
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Patient ->
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
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.listPatientsByHcParty(hcPartyId, sortField, startKey, startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<dynamic> =
				GlobalScope.promise {
			mapToObject<_, _, String>(
				patientApi.tryAndRecover.getPatientHcPartyKeysForDelegate(patientId),
				{ x1: String ->
					x1
				},
				{ x1: String ->
					x1
				},
			)}


		override fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs> =
				GlobalScope.promise {
			content_toJs(patientApi.tryAndRecover.countOfPatients(hcPartyId))}


		override fun findPatientsByHealthcareParty(
			hcPartyId: String?,
			sortField: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double?,
			sortDirection: String,
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.findPatientsByHealthcareParty(hcPartyId, sortField, startKey,
						startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
				{ x1: Patient ->
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
				patientApi.tryAndRecover.findPatientsIdsByHealthcareParty(hcPartyId, startKey, startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: String ->
					x1
				},
			)}


		override fun getPatientByExternalId(externalId: String): Promise<PatientJs> =
				GlobalScope.promise {
			patient_toJs(patientApi.tryAndRecover.getPatientByExternalId(externalId))}


		override fun fuzzySearch(
			firstName: String,
			lastName: String,
			dateOfBirth: Double?,
		): Promise<Array<PatientJs>> = GlobalScope.promise {
			listToArray(
				patientApi.tryAndRecover.fuzzySearch(firstName, lastName, numberToInt(dateOfBirth,
						"dateOfBirth")),
				{ x1: Patient ->
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
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.findDeletedPatients(com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate,
						"startDate"), com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), desc,
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"), startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun listDeletedPatientsByName(firstName: String?, lastName: String?):
				Promise<Array<PatientJs>> = GlobalScope.promise {
			listToArray(
				patientApi.tryAndRecover.listDeletedPatientsByName(firstName, lastName),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun getPatients(patientIds: ListOfIdsJs): Promise<Array<PatientJs>> =
				GlobalScope.promise {
			listToArray(
				patientApi.tryAndRecover.getPatients(listOfIds_fromJs(patientIds)),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun getPatientByHealthcarePartyAndIdentifier(
			hcPartyId: String,
			id: String,
			system: String?,
		): Promise<PatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.tryAndRecover.getPatientByHealthcarePartyAndIdentifier(hcPartyId, id,
					system))}


		override fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>> =
				GlobalScope.promise {
			listToArray(
				patientApi.tryAndRecover.modifyPatients(arrayToList(
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
		): Promise<PatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.tryAndRecover.modifyPatientReferral(patientId, referralId,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(start, "start"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(end, "end")))}


		override fun findDuplicatesBySsin(
			hcPartyId: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.findDuplicatesBySsin(hcPartyId, startKey, startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun findDuplicatesByName(
			hcPartyId: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<PatientJs>> = GlobalScope.promise {
			paginatedList_toJs(
				patientApi.tryAndRecover.findDuplicatesByName(hcPartyId, startKey, startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)}


		override fun mergePatients(
			intoId: String,
			fromId: String,
			expectedFromRev: String,
			updatedInto: EncryptedPatientJs,
		): Promise<PatientJs> = GlobalScope.promise {
			patient_toJs(patientApi.tryAndRecover.mergePatients(intoId, fromId, expectedFromRev,
					com.icure.sdk.js.model.patient_fromJs(updatedInto)))}

	}

	override fun getSecretIdsOf(patient: PatientJs): Promise<Array<String>> = GlobalScope.promise {
		setToArray(
			patientApi.getSecretIdsOf(patient_fromJs(patient)),
			{ x1: String ->
				x1
			},
		)}


	override fun getEncryptionKeysOf(patient: PatientJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			patientApi.getEncryptionKeysOf(patient_fromJs(patient)),
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)}


	override fun createPatient(patient: DecryptedPatientJs): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		patient_toJs(patientApi.createPatient(com.icure.sdk.js.model.patient_fromJs(patient)))}


	override fun withEncryptionMetadata(
		base: DecryptedPatientJs?,
		user: UserJs?,
		delegates: dynamic,
	): Promise<DecryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.patient_fromJs(nonNull1)
		}, user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.model.embed.AccessLevel.valueOf(x1)
		  },
		)))}


	override fun createDelegationsDeAnonymizationMetadata(patient: PatientJs,
			dataOwnerIds: Array<String>): Promise<Unit> = GlobalScope.promise {
		patientApi.createDelegationsDeAnonymizationMetadata(patient_fromJs(patient), arrayToSet(
			dataOwnerIds,
			"dataOwnerIds",
			{ x1: String ->
				x1
			},
		))}


	override fun hasWriteAccess(patient: PatientJs): Promise<Boolean> = GlobalScope.promise {
		patientApi.hasWriteAccess(patient_fromJs(patient))}


	override fun decryptPatientIdOf(patient: PatientJs): Promise<Array<String>> = GlobalScope.promise {
		setToArray(
			patientApi.decryptPatientIdOf(patient_fromJs(patient)),
			{ x1: String ->
				x1
			},
		)}


	override fun createDelegationDeAnonymizationMetadata(entity: PatientJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		patientApi.createDelegationDeAnonymizationMetadata(patient_fromJs(entity), arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		))}


	override fun createPatients(patientDtos: Array<DecryptedPatientJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			patientApi.createPatients(arrayToList(
				patientDtos,
				"patientDtos",
				{ x1: DecryptedPatientJs ->
					patient_fromJs(x1)
				},
			)),
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)}


	override fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String?,
		useShortToken: Boolean?,
		createAutoDelegation: Boolean,
		patient: DecryptedPatientJs,
	): Promise<DataOwnerRegistrationSuccessJs> = GlobalScope.promise {
		dataOwnerRegistrationSuccess_toJs(patientApi.registerPatient(hcPartyId, groupId, token,
				useShortToken, createAutoDelegation, com.icure.sdk.js.model.patient_fromJs(patient)))}


	override fun shareAllDataOfPatient(
		user: UserJs,
		patientId: String,
		dataOwnerId: String,
		delegatesWithShareType: dynamic,
	): Promise<ShareAllPatientDataOptionsJs_ResultJs> = GlobalScope.promise {
		shareAllPatientDataOptions_Result_toJs(patientApi.shareAllDataOfPatient(com.icure.sdk.js.model.user_fromJs(user),
				patientId, dataOwnerId, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegatesWithShareType,
		  "delegatesWithShareType",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.Array<kotlin.String> ->
		    com.icure.sdk.js.model.CheckedConverters.arrayToSet(
		      x1,
		      "x1",
		      { x2: kotlin.String ->
		        com.icure.sdk.crypto.entities.ShareAllPatientDataOptions.Tag.valueOf(x2)
		      },
		    )
		  },
		)))}


	override fun getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfoJs<*>,
			healthcarePartyId: String): Promise<String> = GlobalScope.promise {
		patientApi.getPatientIdOfChildDocumentForHcpAndHcpParents(anyEntityWithTypeInfoToKt(childDocument),
				healthcarePartyId)}


	override fun getConfidentialSecretIdsOf(patient: PatientJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			patientApi.getConfidentialSecretIdsOf(patient_fromJs(patient)),
			{ x1: String ->
				x1
			},
		)}


	override fun forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: String): Promise<Boolean>
			= GlobalScope.promise {
		patientApi.forceInitialiseExchangeDataToNewlyInvitedPatient(patientId)}


	override fun matchPatientsBy(filter: AbstractFilterJs<PatientJs>): Promise<Array<String>> =
			GlobalScope.promise {
		listToArray(
			patientApi.matchPatientsBy(abstractFilter_fromJs(
				filter,
				{ x1: PatientJs ->
					patient_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun deletePatient(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(patientApi.deletePatient(entityId))}


	override fun deletePatients(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			patientApi.deletePatients(arrayToList(
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
			patientApi.undeletePatient(patientIds),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs> =
			GlobalScope.promise {
		entityAccessInformation_toJs(patientApi.getDataOwnersWithAccessTo(com.icure.sdk.js.model.patient_fromJs(patient)))}


	override fun shareWith(
		delegateId: String,
		patient: DecryptedPatientJs,
		shareSecretIds: Array<String>,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedPatientJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			patientApi.shareWith(delegateId, com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.arrayToSet(
			  shareSecretIds,
			  "shareSecretIds",
			  { x1: kotlin.String ->
			    x1
			  },
			), com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
					com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun tryShareWithMany(patient: DecryptedPatientJs, delegates: dynamic):
			Promise<SimpleShareResultJs<DecryptedPatientJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			patientApi.tryShareWithMany(com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.PatientShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.patientShareOptions_fromJs(x1)
			  },
			)),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun shareWithMany(patient: DecryptedPatientJs, delegates: dynamic):
			Promise<DecryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientApi.shareWithMany(com.icure.sdk.js.model.patient_fromJs(patient),
				com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: com.icure.sdk.js.crypto.entities.PatientShareOptionsJs ->
		    com.icure.sdk.js.crypto.entities.patientShareOptions_fromJs(x1)
		  },
		)))}


	override fun initialiseConfidentialSecretId(patient: DecryptedPatientJs):
			Promise<DecryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientApi.initialiseConfidentialSecretId(com.icure.sdk.js.model.patient_fromJs(patient)))}


	override fun modifyPatient(entity: DecryptedPatientJs): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		patient_toJs(patientApi.modifyPatient(com.icure.sdk.js.model.patient_fromJs(entity)))}


	override fun getPatient(entityId: String): Promise<DecryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientApi.getPatient(entityId))}


	override fun filterPatientsBy(
		filterChain: FilterChainJs<PatientJs>,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		skip: Double?,
		sort: String?,
		desc: Boolean?,
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.filterPatientsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.PatientJs ->
			    com.icure.sdk.js.model.patient_fromJs(x1)
			  },
			), startKey, startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit,
					"limit"), com.icure.sdk.js.model.CheckedConverters.numberToInt(skip, "skip"), sort, desc),
			{ x1: DecryptedPatient ->
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
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.findPatientsByNameBirthSsinAuto(healthcarePartyId, filterValue, startKey,
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
			{ x1: DecryptedPatient ->
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
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.listPatientsOfHcParty(hcPartyId, sortField, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun listOfMergesAfter(date: Double): Promise<Array<DecryptedPatientJs>> =
			GlobalScope.promise {
		listToArray(
			patientApi.listOfMergesAfter(numberToLong(date, "date")),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun findPatientsModifiedAfter(
		date: Double,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.findPatientsModifiedAfter(com.icure.sdk.js.model.CheckedConverters.numberToLong(date,
					"date"), com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"),
					startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedPatient ->
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
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.listPatientsByHcParty(hcPartyId, sortField, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<dynamic> =
			GlobalScope.promise {
		mapToObject<_, _, String>(
			patientApi.getPatientHcPartyKeysForDelegate(patientId),
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)}


	override fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs> =
			GlobalScope.promise {
		content_toJs(patientApi.countOfPatients(hcPartyId))}


	override fun findPatientsByHealthcareParty(
		hcPartyId: String?,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.findPatientsByHealthcareParty(hcPartyId, sortField, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.model.couchdb.SortDirection.valueOf(sortDirection)),
			{ x1: DecryptedPatient ->
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
			patientApi.findPatientsIdsByHealthcareParty(hcPartyId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: String ->
				x1
			},
		)}


	override fun getPatientByExternalId(externalId: String): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		patient_toJs(patientApi.getPatientByExternalId(externalId))}


	override fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Double?,
	): Promise<Array<DecryptedPatientJs>> = GlobalScope.promise {
		listToArray(
			patientApi.fuzzySearch(firstName, lastName, numberToInt(dateOfBirth, "dateOfBirth")),
			{ x1: DecryptedPatient ->
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
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.findDeletedPatients(com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate,
					"startDate"), com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), desc,
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startKey, "startKey"), startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun listDeletedPatientsByName(firstName: String?, lastName: String?):
			Promise<Array<DecryptedPatientJs>> = GlobalScope.promise {
		listToArray(
			patientApi.listDeletedPatientsByName(firstName, lastName),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun getPatients(patientIds: ListOfIdsJs): Promise<Array<DecryptedPatientJs>> =
			GlobalScope.promise {
		listToArray(
			patientApi.getPatients(listOfIds_fromJs(patientIds)),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	): Promise<DecryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientApi.getPatientByHealthcarePartyAndIdentifier(hcPartyId, id, system))}


	override fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		listToArray(
			patientApi.modifyPatients(arrayToList(
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
	): Promise<DecryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientApi.modifyPatientReferral(patientId, referralId,
				com.icure.sdk.js.model.CheckedConverters.numberToLong(start, "start"),
				com.icure.sdk.js.model.CheckedConverters.numberToLong(end, "end")))}


	override fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.findDuplicatesBySsin(hcPartyId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedPatientJs>> = GlobalScope.promise {
		paginatedList_toJs(
			patientApi.findDuplicatesByName(hcPartyId, startKey, startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)}


	override fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<DecryptedPatientJs> = GlobalScope.promise {
		patient_toJs(patientApi.mergePatients(intoId, fromId, expectedFromRev,
				com.icure.sdk.js.model.patient_fromJs(updatedInto)))}

}
