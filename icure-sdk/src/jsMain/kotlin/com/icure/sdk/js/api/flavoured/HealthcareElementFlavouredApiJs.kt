// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("HealthcareElementFlavouredApi")
public external interface HealthcareElementFlavouredApiJs<E : HealthElementJs> {
	public fun shareWith(
		delegateId: String,
		healthcareElement: E,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<E>>

	public fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun modifyHealthcareElement(entity: E): Promise<E>

	public fun modifyHealthcareElements(entities: Array<E>): Promise<Array<E>>

	public fun getHealthcareElement(entityId: String): Promise<E>

	public fun getHealthcareElements(entityIds: Array<String>): Promise<Array<E>>

	public fun filterHealthcareElementsBy(
		filterChain: FilterChainJs<EncryptedHealthElementJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<E>>

	public fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<E>>
}
