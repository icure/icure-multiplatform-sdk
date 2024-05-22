// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.sdk.js.model.DecryptedPatientJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.Boolean
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

	public fun createPatients(patientDtos: Array<DecryptedPatientJs>): Promise<Array<IdWithRevJs>>

	public fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String?,
		useShortToken: Boolean?,
		createAutoDelegation: Boolean,
		patient: DecryptedPatientJs,
	): Promise<DataOwnerRegistrationSuccessJs>

	public fun getConfidentialSecretIdsOf(patient: PatientJs): Promise<Array<String>>

	public fun forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: String): Promise<Boolean>

	public fun matchPatientsBy(filter: AbstractFilterJs<EncryptedPatientJs>): Promise<Array<String>>

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

	public fun initialiseConfidentialSecretId(patient: DecryptedPatientJs): Promise<DecryptedPatientJs>
}
