// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.sdk.js.crypto.entities.EntityWithTypeInfoJs
import com.icure.sdk.js.crypto.entities.ShareAllPatientDataOptionsJs_ResultJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.sdk.js.model.DecryptedPatientJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.embed.EncryptedContentJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
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

	public fun getSecretIdsOf(patient: PatientJs): Promise<Array<String>>

	public fun getEncryptionKeysOf(patient: PatientJs): Promise<Array<String>>

	public fun createPatient(patient: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun withEncryptionMetadata(
		base: DecryptedPatientJs?,
		user: UserJs?,
		delegates: dynamic,
	): Promise<DecryptedPatientJs>

	public fun createDelegationsDeAnonymizationMetadata(patient: PatientJs,
			dataOwnerIds: Array<String>): Promise<Unit>

	public fun hasWriteAccess(patient: PatientJs): Promise<Boolean>

	public fun decryptPatientIdOf(patient: PatientJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: PatientJs, delegates: Array<String>):
			Promise<Unit>

	public fun createPatients(patientDtos: Array<DecryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String?,
		useShortToken: Boolean?,
		createAutoDelegation: Boolean,
		patient: DecryptedPatientJs,
	): Promise<DataOwnerRegistrationSuccessJs>

	public fun shareAllDataOfPatient(
		user: UserJs,
		patientId: String,
		dataOwnerId: String,
		delegatesWithShareType: dynamic,
	): Promise<ShareAllPatientDataOptionsJs_ResultJs>

	public fun getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfoJs<*>,
			healthcarePartyId: String): Promise<String>

	public fun getConfidentialSecretIdsOf(patient: PatientJs): Promise<Array<String>>

	public fun forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: String): Promise<Boolean>

	public fun matchPatientsBy(filter: AbstractFilterJs<PatientJs>): Promise<Array<String>>

	public fun deletePatient(entityId: String): Promise<DocIdentifierJs>

	public fun deletePatients(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun undeletePatient(patientIds: String): Promise<Array<DocIdentifierJs>>

	public fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs>

	public fun shareWith(
		delegateId: String,
		patient: DecryptedPatientJs,
		shareSecretIds: Array<String>,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedPatientJs>>

	public fun tryShareWithMany(patient: DecryptedPatientJs, delegates: dynamic):
			Promise<SimpleShareResultJs<DecryptedPatientJs>>

	public fun shareWithMany(patient: DecryptedPatientJs, delegates: dynamic):
			Promise<DecryptedPatientJs>

	public fun initialiseConfidentialSecretId(patient: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun modifyPatient(entity: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun getPatient(entityId: String): Promise<DecryptedPatientJs>

	public fun filterPatientsBy(
		filterChain: FilterChainJs<PatientJs>,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		skip: Double?,
		sort: String?,
		desc: Boolean?,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findPatientsByNameBirthSsinAuto(
		healthcarePartyId: String?,
		filterValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listPatientsOfHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listOfMergesAfter(date: Double): Promise<Array<DecryptedPatientJs>>

	public fun findPatientsModifiedAfter(
		date: Double,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listPatientsByHcParty(
		hcPartyId: String,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<dynamic>

	public fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs>

	public fun findPatientsByHealthcareParty(
		hcPartyId: String?,
		sortField: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
		sortDirection: String,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findPatientsIdsByHealthcareParty(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<DecryptedPatientJs>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		dateOfBirth: Double?,
	): Promise<Array<DecryptedPatientJs>>

	public fun findDeletedPatients(
		startDate: Double,
		endDate: Double?,
		desc: Boolean?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listDeletedPatientsByName(firstName: String?, lastName: String?):
			Promise<Array<DecryptedPatientJs>>

	public fun getPatients(patientIds: ListOfIdsJs): Promise<Array<DecryptedPatientJs>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		system: String?,
	): Promise<DecryptedPatientJs>

	public fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		start: Double?,
		end: Double?,
	): Promise<DecryptedPatientJs>

	public fun findDuplicatesBySsin(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findDuplicatesByName(
		hcPartyId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<DecryptedPatientJs>
}
