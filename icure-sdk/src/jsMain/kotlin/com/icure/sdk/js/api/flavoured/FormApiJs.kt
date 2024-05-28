// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedFormJs
import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormApi")
public external interface FormApiJs {
	public val encrypted: FormFlavouredApiJs<EncryptedFormJs>

	public val tryAndRecover: FormFlavouredApiJs<FormJs>

	public fun createForm(entity: DecryptedFormJs): Promise<DecryptedFormJs>

	public fun createForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>>

	public fun withEncryptionMetadata(
		base: DecryptedFormJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedFormJs>

	public fun deleteForm(entityId: String): Promise<DocIdentifierJs>

	public fun deleteForms(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getFormTemplate(formTemplateId: String, raw: Boolean?): Promise<FormTemplateJs>

	public fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	): Promise<Array<FormTemplateJs>>

	public fun listFormTemplatesBySpeciality(specialityCode: String, raw: Boolean?):
			Promise<Array<FormTemplateJs>>

	public fun getFormTemplates(loadLayout: Boolean?, raw: Boolean?): Promise<Array<FormTemplateJs>>

	public fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs>

	public fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String>

	public fun shareWith(
		delegateId: String,
		form: DecryptedFormJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedFormJs>>

	public fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedFormJs>>

	public fun modifyForm(entity: DecryptedFormJs): Promise<DecryptedFormJs>

	public fun modifyForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>>

	public fun getForm(entityId: String): Promise<DecryptedFormJs>

	public fun getForms(entityIds: Array<String>): Promise<Array<DecryptedFormJs>>

	public fun getFormByLogicalUuid(logicalUuid: String): Promise<DecryptedFormJs>

	public fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<DecryptedFormJs>>

	public fun getFormsByUniqueId(uniqueId: String): Promise<Array<DecryptedFormJs>>

	public fun getFormByUniqueId(uniqueId: String): Promise<DecryptedFormJs>

	public fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<DecryptedFormJs>>

	public fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		healthElementId: String?,
		planOfActionId: String?,
		formTemplateId: String?,
	): Promise<Array<DecryptedFormJs>>
}
