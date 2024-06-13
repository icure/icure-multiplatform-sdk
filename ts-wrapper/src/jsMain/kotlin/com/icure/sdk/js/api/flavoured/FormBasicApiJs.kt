// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormBasicApi")
public external interface FormBasicApiJs {
	public fun deleteForm(entityId: String): Promise<DocIdentifierJs>

	public fun deleteForms(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getFormTemplate(formTemplateId: String, options: dynamic): Promise<FormTemplateJs>

	public fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	): Promise<Array<FormTemplateJs>>

	public fun listFormTemplatesBySpeciality(specialityCode: String, options: dynamic):
			Promise<Array<FormTemplateJs>>

	public fun getFormTemplates(options: dynamic): Promise<Array<FormTemplateJs>>

	public fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs>

	public fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String>

	public fun modifyForm(entity: EncryptedFormJs): Promise<EncryptedFormJs>

	public fun modifyForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>>

	public fun getForm(entityId: String): Promise<EncryptedFormJs>

	public fun getForms(entityIds: Array<String>): Promise<Array<EncryptedFormJs>>

	public fun getFormByLogicalUuid(logicalUuid: String): Promise<EncryptedFormJs>

	public fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<EncryptedFormJs>>

	public fun getFormsByUniqueId(uniqueId: String): Promise<Array<EncryptedFormJs>>

	public fun getFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs>

	public fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<EncryptedFormJs>>

	public fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		options: dynamic,
	): Promise<Array<EncryptedFormJs>>
}
