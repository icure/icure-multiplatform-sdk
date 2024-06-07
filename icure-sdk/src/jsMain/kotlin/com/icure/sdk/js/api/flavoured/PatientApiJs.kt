// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.sdk.js.crypto.entities.EntityWithTypeInfoJs
import com.icure.sdk.js.crypto.entities.PatientShareOptionsJs
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

@JsName("PatientApi")
public external interface PatientApiJs {
	public val encrypted: PatientFlavouredApiJs<EncryptedPatientJs>

	public val tryAndRecover: PatientFlavouredApiJs<PatientJs>

	public fun getSecretIdsOf(patient: PatientJs): Promise<Array<String>>

	public fun getEncryptionKeysOf(patient: PatientJs): Promise<Array<String>>

	public fun createPatient(patient: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun withEncryptionMetadata(base: DecryptedPatientJs?,
			options: PatientApi_withEncryptionMetadata_Options?): Promise<DecryptedPatientJs>

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
		delegatesWithShareType: Record<String, Array<String>>,
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
		options: PatientApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedPatientJs>>

	public fun tryShareWithMany(patient: DecryptedPatientJs,
			delegates: Record<String, PatientShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedPatientJs>>

	public fun shareWithMany(patient: DecryptedPatientJs,
			delegates: Record<String, PatientShareOptionsJs>): Promise<DecryptedPatientJs>

	public fun initialiseConfidentialSecretId(patient: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun modifyPatient(entity: DecryptedPatientJs): Promise<DecryptedPatientJs>

	public fun getPatient(entityId: String): Promise<DecryptedPatientJs>

	public fun filterPatientsBy(filterChain: FilterChainJs<PatientJs>,
			options: PatientApi_filterPatientsBy_Options?): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findPatientsByNameBirthSsinAuto(filterValue: String,
			options: PatientApi_findPatientsByNameBirthSsinAuto_Options?):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listPatientsOfHcParty(hcPartyId: String,
			options: PatientApi_listPatientsOfHcParty_Options?): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listOfMergesAfter(date: Double): Promise<Array<DecryptedPatientJs>>

	public fun findPatientsModifiedAfter(date: Double,
			options: PatientApi_findPatientsModifiedAfter_Options?):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listPatientsByHcParty(hcPartyId: String,
			options: PatientApi_listPatientsByHcParty_Options?): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<Record<String, String>>

	public fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs>

	public
			fun findPatientsByHealthcareParty(options: PatientApi_findPatientsByHealthcareParty_Options?):
			Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findPatientsIdsByHealthcareParty(hcPartyId: String,
			options: PatientApi_findPatientsIdsByHealthcareParty_Options?): Promise<PaginatedListJs<String>>

	public fun getPatientByExternalId(externalId: String): Promise<DecryptedPatientJs>

	public fun fuzzySearch(
		firstName: String,
		lastName: String,
		options: PatientApi_fuzzySearch_Options?,
	): Promise<Array<DecryptedPatientJs>>

	public fun findDeletedPatients(startDate: Double,
			options: PatientApi_findDeletedPatients_Options?): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun listDeletedPatientsByName(options: PatientApi_listDeletedPatientsByName_Options?):
			Promise<Array<DecryptedPatientJs>>

	public fun getPatients(patientIds: ListOfIdsJs): Promise<Array<DecryptedPatientJs>>

	public fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		options: PatientApi_getPatientByHealthcarePartyAndIdentifier_Options?,
	): Promise<DecryptedPatientJs>

	public fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		options: PatientApi_modifyPatientReferral_Options?,
	): Promise<DecryptedPatientJs>

	public fun findDuplicatesBySsin(hcPartyId: String,
			options: PatientApi_findDuplicatesBySsin_Options?): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun findDuplicatesByName(hcPartyId: String,
			options: PatientApi_findDuplicatesByName_Options?): Promise<PaginatedListJs<DecryptedPatientJs>>

	public fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<DecryptedPatientJs>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<PatientJs>,
		eventFired: (DecryptedPatientJs) -> Promise<Unit>,
		options: PatientApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface PatientApi_withEncryptionMetadata_Options {
	public val user: UserJs?

	public val delegates: Record<String, String>
}

public external interface PatientApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface PatientApi_filterPatientsBy_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val skip: Double?

	public val sort: String?

	public val desc: Boolean?
}

public external interface PatientApi_findPatientsByNameBirthSsinAuto_Options {
	public val healthcarePartyId: String?

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientApi_listPatientsOfHcParty_Options {
	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientApi_findPatientsModifiedAfter_Options {
	public val startKey: Double?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientApi_listPatientsByHcParty_Options {
	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientApi_findPatientsByHealthcareParty_Options {
	public val hcPartyId: String?

	public val sortField: String

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val sortDirection: String
}

public external interface PatientApi_findPatientsIdsByHealthcareParty_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientApi_fuzzySearch_Options {
	public val dateOfBirth: Double?
}

public external interface PatientApi_findDeletedPatients_Options {
	public val endDate: Double?

	public val desc: Boolean?

	public val startKey: Double?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientApi_listDeletedPatientsByName_Options {
	public val firstName: String?

	public val lastName: String?
}

public external interface PatientApi_getPatientByHealthcarePartyAndIdentifier_Options {
	public val system: String?
}

public external interface PatientApi_modifyPatientReferral_Options {
	public val start: Double?

	public val end: Double?
}

public external interface PatientApi_findDuplicatesBySsin_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientApi_findDuplicatesByName_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface PatientApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
