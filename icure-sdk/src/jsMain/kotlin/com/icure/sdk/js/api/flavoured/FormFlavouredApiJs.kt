// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("FormFlavouredApi")
public external interface FormFlavouredApiJs<E : FormJs> {
	public fun shareWith(
		delegateId: String,
		form: E,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<E>>

	public fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun modifyForm(entity: E): Promise<E>

	public fun modifyForms(entities: Array<E>): Promise<Array<E>>

	public fun getForm(entityId: String): Promise<E>

	public fun getForms(entityIds: Array<String>): Promise<Array<E>>

	public fun getFormByLogicalUuid(logicalUuid: String): Promise<E>

	public fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<E>>

	public fun getFormsByUniqueId(uniqueId: String): Promise<Array<E>>

	public fun getFormByUniqueId(uniqueId: String): Promise<E>

	public fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<E>>

	public fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		healthElementId: String?,
		planOfActionId: String?,
		formTemplateId: String?,
	): Promise<Array<E>>
}
