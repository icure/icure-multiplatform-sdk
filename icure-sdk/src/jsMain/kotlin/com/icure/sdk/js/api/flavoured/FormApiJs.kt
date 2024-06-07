// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedFormJs
import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.String
import kotlin.Unit
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
		options: FormApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedFormJs>

	public fun getEncryptionKeysOf(form: FormJs): Promise<Array<String>>

	public fun hasWriteAccess(form: FormJs): Promise<Boolean>

	public fun decryptPatientIdOf(form: FormJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: FormJs, delegates: Array<String>):
			Promise<Unit>

	public fun deleteForm(entityId: String): Promise<DocIdentifierJs>

	public fun deleteForms(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun getFormTemplate(formTemplateId: String, options: FormApi_getFormTemplate_Options?):
			Promise<FormTemplateJs>

	public fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	): Promise<Array<FormTemplateJs>>

	public fun listFormTemplatesBySpeciality(specialityCode: String,
			options: FormApi_listFormTemplatesBySpeciality_Options?): Promise<Array<FormTemplateJs>>

	public fun getFormTemplates(options: FormApi_getFormTemplates_Options?):
			Promise<Array<FormTemplateJs>>

	public fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs>

	public fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs>

	public fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String>

	public fun shareWith(
		delegateId: String,
		form: DecryptedFormJs,
		options: FormApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedFormJs>>

	public fun tryShareWithMany(form: DecryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedFormJs>>

	public fun shareWithMany(form: DecryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
			Promise<DecryptedFormJs>

	public fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: FormApi_findFormsByHcPartyPatient_Options?,
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
		options: FormApi_listFormsByHCPartyAndPatientForeignKeys_Options?,
	): Promise<Array<DecryptedFormJs>>
}

public external interface FormApi_withEncryptionMetadata_Options {
	public val user: UserJs?

	public val delegates: Record<String, String>

	public val secretId: SecretIdOptionJs
}

public external interface FormApi_getFormTemplate_Options {
	public val raw: Boolean?
}

public external interface FormApi_listFormTemplatesBySpeciality_Options {
	public val raw: Boolean?
}

public external interface FormApi_getFormTemplates_Options {
	public val loadLayout: Boolean?

	public val raw: Boolean?
}

public external interface FormApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface FormApi_findFormsByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}

public external interface FormApi_listFormsByHCPartyAndPatientForeignKeys_Options {
	public val healthElementId: String?

	public val planOfActionId: String?

	public val formTemplateId: String?
}
