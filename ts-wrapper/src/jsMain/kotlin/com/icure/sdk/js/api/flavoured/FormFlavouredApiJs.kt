// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormFlavouredApi")
public external interface FormFlavouredApiJs<E : FormJs> {
	public fun shareWith(
		delegateId: String,
		form: E,
		options: FormFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(form: E, delegates: Record<String, FormShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(form: E, delegates: Record<String, FormShareOptionsJs>): Promise<E>

	public fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: FormFlavouredApi_findFormsByHcPartyPatient_Options?,
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
		options: FormFlavouredApi_listFormsByHCPartyAndPatientForeignKeys_Options?,
	): Promise<Array<E>>
}

public external interface FormFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface FormFlavouredApi_findFormsByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}

public external interface FormFlavouredApi_listFormsByHCPartyAndPatientForeignKeys_Options {
	public val healthElementId: String?

	public val planOfActionId: String?

	public val formTemplateId: String?
}
