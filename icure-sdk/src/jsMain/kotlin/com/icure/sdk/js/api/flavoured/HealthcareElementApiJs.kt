// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedHealthElementJs
import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthcareElementApi")
public external interface HealthcareElementApiJs {
	public val encrypted: HealthcareElementFlavouredApiJs<EncryptedHealthElementJs>

	public val tryAndRecover: HealthcareElementFlavouredApiJs<HealthElementJs>

	public fun createHealthcareElement(entity: DecryptedHealthElementJs):
			Promise<DecryptedHealthElementJs>

	public fun createHealthcareElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>>

	public fun withEncryptionMetadata(
		base: DecryptedHealthElementJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedHealthElementJs>

	public fun matchHealthcareElementsBy(filter: AbstractFilterJs<EncryptedHealthElementJs>):
			Promise<Array<String>>

	public fun deleteHealthcareElement(entityId: String): Promise<DocIdentifierJs>

	public fun deleteHealthcareElements(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>>

	public fun shareWith(
		delegateId: String,
		healthcareElement: DecryptedHealthElementJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedHealthElementJs>>

	public fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedHealthElementJs>>
}
