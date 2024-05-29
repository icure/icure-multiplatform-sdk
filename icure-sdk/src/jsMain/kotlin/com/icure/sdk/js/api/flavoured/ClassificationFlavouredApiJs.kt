// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.ClassificationJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ClassificationFlavouredApi")
public external interface ClassificationFlavouredApiJs<E : ClassificationJs> {
	public fun shareWith(
		delegateId: String,
		classification: E,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(classification: E, delegates: dynamic): Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(classification: E, delegates: dynamic): Promise<E>

	public fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun modifyClassification(entity: E): Promise<E>

	public fun getClassification(entityId: String): Promise<E>

	public fun getClassifications(entityIds: Array<String>): Promise<Array<E>>
}
