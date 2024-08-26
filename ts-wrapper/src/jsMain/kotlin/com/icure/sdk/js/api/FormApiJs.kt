// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.filters.FilterOptionsJs
import com.icure.sdk.js.filters.SortableFilterOptionsJs
import com.icure.sdk.js.model.DecryptedFormJs
import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
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
		options: dynamic,
	): Promise<DecryptedFormJs>

	public fun getEncryptionKeysOf(form: FormJs): Promise<Array<String>>

	public fun hasWriteAccess(form: FormJs): Promise<Boolean>

	public fun decryptPatientIdOf(form: FormJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: FormJs, delegates: Array<String>):
			Promise<Unit>

	public fun decrypt(form: EncryptedFormJs): Promise<DecryptedFormJs>

	public fun tryDecrypt(form: EncryptedFormJs): Promise<FormJs>

	public fun matchFormsBy(filter: FilterOptionsJs<FormJs>): Promise<Array<String>>

	public fun matchFormsBySorted(filter: SortableFilterOptionsJs<FormJs>): Promise<Array<String>>

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

	public fun shareWith(
		delegateId: String,
		form: DecryptedFormJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedFormJs>>

	public fun tryShareWithMany(form: DecryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedFormJs>>

	public fun shareWithMany(form: DecryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
			Promise<DecryptedFormJs>

	public fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedFormJs>>

	public fun filterFormsBy(filter: FilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<DecryptedFormJs>>

	public fun filterFormsBySorted(filter: SortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<DecryptedFormJs>>

	public fun modifyForm(entity: DecryptedFormJs): Promise<DecryptedFormJs>

	public fun modifyForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>>

	public fun getForm(entityId: String): Promise<DecryptedFormJs>

	public fun getForms(entityIds: Array<String>): Promise<Array<DecryptedFormJs>>

	public fun getLatestFormByLogicalUuid(logicalUuid: String): Promise<DecryptedFormJs>

	public fun getLatestFormByUniqueId(uniqueId: String): Promise<DecryptedFormJs>

	public fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<DecryptedFormJs>>

	public fun getFormsByUniqueId(uniqueId: String): Promise<Array<DecryptedFormJs>>

	public fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<DecryptedFormJs>>

	public fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		options: dynamic,
	): Promise<Array<DecryptedFormJs>>
}
