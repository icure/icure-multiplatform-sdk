// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.FormBasicApi
import com.icure.sdk.js.api.flavoured.FormBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.formTemplate_toJs
import com.icure.sdk.js.model.form_fromJs
import com.icure.sdk.js.model.form_toJs
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.FormTemplate
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class FormBasicApiImplJs private constructor(
	private val formBasicApi: FormBasicApi,
) : FormBasicApiJs {
	override fun deleteForm(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(formBasicApi.deleteForm(entityId))}


	override fun deleteForms(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			formBasicApi.deleteForms(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun getFormTemplate(formTemplateId: String, raw: Boolean?): Promise<FormTemplateJs> =
			GlobalScope.promise {
		formTemplate_toJs(formBasicApi.getFormTemplate(formTemplateId, raw))}


	override fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	): Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		listToArray(
			formBasicApi.getFormTemplatesByGuid(formTemplateGuid, specialityCode, raw),
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)}


	override fun listFormTemplatesBySpeciality(specialityCode: String, raw: Boolean?):
			Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		listToArray(
			formBasicApi.listFormTemplatesBySpeciality(specialityCode, raw),
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)}


	override fun getFormTemplates(loadLayout: Boolean?, raw: Boolean?): Promise<Array<FormTemplateJs>>
			= GlobalScope.promise {
		listToArray(
			formBasicApi.getFormTemplates(loadLayout, raw),
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)}


	override fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		formTemplate_toJs(formBasicApi.createFormTemplate(com.icure.sdk.js.model.formTemplate_fromJs(formTemplate)))}


	override fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(formBasicApi.deleteFormTemplate(formTemplateId))}


	override fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		formTemplate_toJs(formBasicApi.updateFormTemplate(com.icure.sdk.js.model.formTemplate_fromJs(formTemplate)))}


	override fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String> =
			GlobalScope.promise {
		formBasicApi.setTemplateAttachment(formTemplateId, payload)}


	override fun modifyForm(entity: EncryptedFormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
		form_toJs(formBasicApi.modifyForm(com.icure.sdk.js.model.form_fromJs(entity)))}


	override fun modifyForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formBasicApi.modifyForms(arrayToList(
				entities,
				"entities",
				{ x1: EncryptedFormJs ->
					form_fromJs(x1)
				},
			)),
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun getForm(entityId: String): Promise<EncryptedFormJs> = GlobalScope.promise {
		form_toJs(formBasicApi.getForm(entityId))}


	override fun getForms(entityIds: Array<String>): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formBasicApi.getForms(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun getFormByLogicalUuid(logicalUuid: String): Promise<EncryptedFormJs> =
			GlobalScope.promise {
		form_toJs(formBasicApi.getFormByLogicalUuid(logicalUuid))}


	override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formBasicApi.getFormsByLogicalUuid(logicalUuid),
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun getFormsByUniqueId(uniqueId: String): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formBasicApi.getFormsByUniqueId(uniqueId),
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun getFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs> = GlobalScope.promise {
		form_toJs(formBasicApi.getFormByUniqueId(uniqueId))}


	override fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<EncryptedFormJs>>
			= GlobalScope.promise {
		listToArray(
			formBasicApi.getChildrenForms(hcPartyId, parentId),
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		healthElementId: String?,
		planOfActionId: String?,
		formTemplateId: String?,
	): Promise<Array<EncryptedFormJs>> = GlobalScope.promise {
		listToArray(
			formBasicApi.listFormsByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys, healthElementId,
					planOfActionId, formTemplateId),
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)}

}
