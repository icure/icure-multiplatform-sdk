// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.HealthElementShareOptionsJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedHealthElementJs
import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
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
		options: HealthcareElementApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedHealthElementJs>

	public fun getEncryptionKeysOf(healthElement: HealthElementJs): Promise<Array<String>>

	public fun hasWriteAccess(healthElement: HealthElementJs): Promise<Boolean>

	public fun decryptPatientIdOf(healthElement: HealthElementJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: HealthElementJs,
			delegates: Array<String>): Promise<Unit>

	public fun matchHealthcareElementsBy(filter: AbstractFilterJs<HealthElementJs>):
			Promise<Array<String>>

	public fun deleteHealthcareElement(entityId: String): Promise<DocIdentifierJs>

	public fun deleteHealthcareElements(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>>

	public fun shareWith(
		delegateId: String,
		healthcareElement: DecryptedHealthElementJs,
		options: HealthcareElementApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedHealthElementJs>>

	public fun tryShareWithMany(healthElement: DecryptedHealthElementJs,
			delegates: Record<String, HealthElementShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedHealthElementJs>>

	public fun shareWithMany(healthElement: DecryptedHealthElementJs,
			delegates: Record<String, HealthElementShareOptionsJs>): Promise<DecryptedHealthElementJs>

	public fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: HealthcareElementApi_findHealthcareElementsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedHealthElementJs>>

	public fun modifyHealthcareElement(entity: DecryptedHealthElementJs):
			Promise<DecryptedHealthElementJs>

	public fun modifyHealthcareElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>>

	public fun getHealthcareElement(entityId: String): Promise<DecryptedHealthElementJs>

	public fun getHealthcareElements(entityIds: Array<String>):
			Promise<Array<DecryptedHealthElementJs>>

	public fun filterHealthcareElementsBy(
		filterChain: FilterChainJs<HealthElementJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedHealthElementJs>>

	public fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedHealthElementJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<HealthElementJs>,
		eventFired: (DecryptedHealthElementJs) -> Promise<Unit>,
		options: HealthcareElementApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface HealthcareElementApi_withEncryptionMetadata_Options {
	public val user: UserJs?

	public val delegates: Record<String, String>

	public val secretId: SecretIdOptionJs
}

public external interface HealthcareElementApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface HealthcareElementApi_findHealthcareElementsByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}

public external interface HealthcareElementApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
