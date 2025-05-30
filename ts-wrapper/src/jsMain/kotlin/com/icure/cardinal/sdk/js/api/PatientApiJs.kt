// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.crypto.entities.EntityWithTypeInfoJs
import com.icure.cardinal.sdk.js.crypto.entities.PatientShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.ShareAllPatientDataOptionsJs_ResultJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DecryptedPatientJs
import com.icure.cardinal.sdk.js.model.EncryptedPatientJs
import com.icure.cardinal.sdk.js.model.EntityReferenceInGroupJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PatientApi")
public external interface PatientApiJs {
	public val encrypted: PatientFlavouredApiJs<EncryptedPatientJs>

	public val tryAndRecover: PatientFlavouredApiJs<PatientJs>

	public val inGroup: PatientInGroupApiJs

	public fun decrypt(patients: Array<EncryptedPatientJs>): Promise<Array<DecryptedPatientJs>>

	public fun tryDecrypt(patients: Array<EncryptedPatientJs>): Promise<Array<PatientJs>>

	public fun encryptOrValidate(patients: Array<PatientJs>): Promise<Array<EncryptedPatientJs>>

	public fun getSecretIdsOf(patient: PatientJs):
			Promise<Record<String, Array<EntityReferenceInGroupJs>>>

	public fun getEncryptionKeysOf(patient: PatientJs): Promise<Array<String>>

	public fun withEncryptionMetadata(base: DecryptedPatientJs?, options: dynamic):
			Promise<DecryptedPatientJs>

	public fun hasWriteAccess(patient: PatientJs): Promise<Boolean>

	public fun createDelegationDeAnonymizationMetadata(entity: PatientJs, delegates: Array<String>):
			Promise<Unit>

	public fun shareAllDataOfPatient(patientId: String,
			delegatesWithShareType: Record<String, Array<String>>):
			Promise<ShareAllPatientDataOptionsJs_ResultJs>

	public fun getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfoJs<*>):
			Promise<String>

	public fun getConfidentialSecretIdsOf(patient: PatientJs): Promise<Array<String>>

	public fun forceInitializeExchangeDataToNewlyInvitedPatient(patientId: String): Promise<Boolean>

	public fun matchPatientsBy(filter: FilterOptionsJs<PatientJs>): Promise<Array<String>>

	public fun matchPatientsBySorted(filter: SortableFilterOptionsJs<PatientJs>):
			Promise<Array<String>>

	public fun ensureEncryptionMetadataForSelfIsInitialized(options: dynamic):
			Promise<EncryptedPatientJs>

	public fun deletePatientUnsafe(entityId: String): Promise<StoredDocumentIdentifierJs>

	public fun deletePatientsUnsafe(entityIds: Array<String>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun deletePatientById(entityId: String, rev: String): Promise<StoredDocumentIdentifierJs>

	public fun deletePatientsByIds(entityIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgePatientById(id: String, rev: String): Promise<Unit>

	public fun deletePatient(patient: PatientJs): Promise<StoredDocumentIdentifierJs>

	public fun deletePatients(patients: Array<PatientJs>): Promise<Array<StoredDocumentIdentifierJs>>

	public fun purgePatient(patient: PatientJs): Promise<Unit>

	public fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs>

	public fun countOfPatients(hcPartyId: String): Promise<Double>

	public fun shareWith(
		delegateId: String,
		patient: DecryptedPatientJs,
		options: dynamic,
	): Promise<DecryptedPatientJs>

	public fun shareWithMany(patient: DecryptedPatientJs,
			delegates: Record<String, PatientShareOptionsJs>): Promise<DecryptedPatientJs>

	public fun initializeConfidentialSecretId(patient: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun filterPatientsBy(filter: FilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<DecryptedPatientJs>>

	public fun filterPatientsBySorted(filter: SortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<DecryptedPatientJs>>

	public fun createPatient(patient: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun createPatientsMinimal(patients: Array<DecryptedPatientJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun createPatients(patients: Array<DecryptedPatientJs>): Promise<Array<DecryptedPatientJs>>

	public fun undeletePatient(patient: PatientJs): Promise<PatientJs>

	public fun modifyPatient(entity: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun undeletePatientById(id: String, rev: String): Promise<DecryptedPatientJs>

	public fun undeletePatients(ids: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DecryptedPatientJs>>

	public fun getPatient(entityId: String): Promise<DecryptedPatientJs?>

	public fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?):
			Promise<DecryptedPatientJs>

	public fun findPatientsByNameBirthSsinAuto(filterValue: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listPatientsOfHcParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listOfMergesAfter(date: Double): Promise<Array<DecryptedPatientJs>>

	public fun findPatientsModifiedAfter(date: Double, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listPatientsByHcParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findPatientsByHealthcareParty(options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findPatientsIdsByHealthcareParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<DecryptedPatientJs>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		options: dynamic,
	): Promise<Array<DecryptedPatientJs>>

	public fun findDeletedPatients(startDate: Double, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listDeletedPatientsByName(options: dynamic): Promise<Array<DecryptedPatientJs>>

	public fun getPatients(patientIds: Array<String>): Promise<Array<DecryptedPatientJs>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		options: dynamic,
	): Promise<DecryptedPatientJs>

	public fun modifyPatientsMinimal(patients: Array<DecryptedPatientJs>):
			Promise<Array<StoredDocumentIdentifierJs>>

	public fun modifyPatients(patients: Array<DecryptedPatientJs>): Promise<Array<DecryptedPatientJs>>

	public fun findDuplicatesBySsin(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findDuplicatesByName(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun mergePatients(from: PatientJs, mergedInto: DecryptedPatientJs):
			Promise<DecryptedPatientJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<PatientJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedPatientJs>>
}
