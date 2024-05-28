// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.FormApi
import com.icure.sdk.js.api.flavoured.FormApiJs
import com.icure.sdk.js.api.flavoured.FormFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.DecryptedFormJs
import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.formTemplate_toJs
import com.icure.sdk.js.model.form_fromJs
import com.icure.sdk.js.model.form_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.Form
import com.icure.sdk.model.FormTemplate
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class FormApiImplJs(
	private val formApi: FormApi,
) : FormApiJs {
	override val encrypted: FormFlavouredApiJs<EncryptedFormJs> = object :
			FormFlavouredApiJs<EncryptedFormJs> {
		override fun shareWith(
			delegateId: String,
			form: EncryptedFormJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedFormJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				formApi.encrypted.shareWith(delegateId, com.icure.sdk.js.model.form_fromJs(form),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)}


		override fun findFormsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedFormJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				formApi.encrypted.findFormsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)}


		override fun modifyForm(entity: EncryptedFormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
			form_toJs(formApi.encrypted.modifyForm(com.icure.sdk.js.model.form_fromJs(entity)))}


		override fun modifyForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>> =
				GlobalScope.promise {
			listToArray(
				formApi.encrypted.modifyForms(arrayToList(
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
			form_toJs(formApi.encrypted.getForm(entityId))}


		override fun getForms(entityIds: Array<String>): Promise<Array<EncryptedFormJs>> =
				GlobalScope.promise {
			listToArray(
				formApi.encrypted.getForms(arrayToList(
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
			form_toJs(formApi.encrypted.getFormByLogicalUuid(logicalUuid))}


		override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<EncryptedFormJs>> =
				GlobalScope.promise {
			listToArray(
				formApi.encrypted.getFormsByLogicalUuid(logicalUuid),
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)}


		override fun getFormsByUniqueId(uniqueId: String): Promise<Array<EncryptedFormJs>> =
				GlobalScope.promise {
			listToArray(
				formApi.encrypted.getFormsByUniqueId(uniqueId),
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)}


		override fun getFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs> = GlobalScope.promise {
			form_toJs(formApi.encrypted.getFormByUniqueId(uniqueId))}


		override fun getChildrenForms(hcPartyId: String, parentId: String):
				Promise<Array<EncryptedFormJs>> = GlobalScope.promise {
			listToArray(
				formApi.encrypted.getChildrenForms(hcPartyId, parentId),
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
				formApi.encrypted.listFormsByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys,
						healthElementId, planOfActionId, formTemplateId),
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)}

	}

	override val tryAndRecover: FormFlavouredApiJs<FormJs> = object : FormFlavouredApiJs<FormJs> {
		override fun shareWith(
			delegateId: String,
			form: FormJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<FormJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				formApi.tryAndRecover.shareWith(delegateId, com.icure.sdk.js.model.form_fromJs(form),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: Form ->
					form_toJs(x1)
				},
			)}


		override fun findFormsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<FormJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				formApi.tryAndRecover.findFormsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: Form ->
					form_toJs(x1)
				},
			)}


		override fun modifyForm(entity: FormJs): Promise<FormJs> = GlobalScope.promise {
			form_toJs(formApi.tryAndRecover.modifyForm(com.icure.sdk.js.model.form_fromJs(entity)))}


		override fun modifyForms(entities: Array<FormJs>): Promise<Array<FormJs>> = GlobalScope.promise {
			listToArray(
				formApi.tryAndRecover.modifyForms(arrayToList(
					entities,
					"entities",
					{ x1: FormJs ->
						form_fromJs(x1)
					},
				)),
				{ x1: Form ->
					form_toJs(x1)
				},
			)}


		override fun getForm(entityId: String): Promise<FormJs> = GlobalScope.promise {
			form_toJs(formApi.tryAndRecover.getForm(entityId))}


		override fun getForms(entityIds: Array<String>): Promise<Array<FormJs>> = GlobalScope.promise {
			listToArray(
				formApi.tryAndRecover.getForms(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Form ->
					form_toJs(x1)
				},
			)}


		override fun getFormByLogicalUuid(logicalUuid: String): Promise<FormJs> = GlobalScope.promise {
			form_toJs(formApi.tryAndRecover.getFormByLogicalUuid(logicalUuid))}


		override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<FormJs>> =
				GlobalScope.promise {
			listToArray(
				formApi.tryAndRecover.getFormsByLogicalUuid(logicalUuid),
				{ x1: Form ->
					form_toJs(x1)
				},
			)}


		override fun getFormsByUniqueId(uniqueId: String): Promise<Array<FormJs>> = GlobalScope.promise {
			listToArray(
				formApi.tryAndRecover.getFormsByUniqueId(uniqueId),
				{ x1: Form ->
					form_toJs(x1)
				},
			)}


		override fun getFormByUniqueId(uniqueId: String): Promise<FormJs> = GlobalScope.promise {
			form_toJs(formApi.tryAndRecover.getFormByUniqueId(uniqueId))}


		override fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<FormJs>> =
				GlobalScope.promise {
			listToArray(
				formApi.tryAndRecover.getChildrenForms(hcPartyId, parentId),
				{ x1: Form ->
					form_toJs(x1)
				},
			)}


		override fun listFormsByHCPartyAndPatientForeignKeys(
			hcPartyId: String,
			secretFKeys: String,
			healthElementId: String?,
			planOfActionId: String?,
			formTemplateId: String?,
		): Promise<Array<FormJs>> = GlobalScope.promise {
			listToArray(
				formApi.tryAndRecover.listFormsByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys,
						healthElementId, planOfActionId, formTemplateId),
				{ x1: Form ->
					form_toJs(x1)
				},
			)}

	}

	override fun createForm(entity: DecryptedFormJs): Promise<DecryptedFormJs> = GlobalScope.promise {
		form_toJs(formApi.createForm(com.icure.sdk.js.model.form_fromJs(entity)))}


	override fun createForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formApi.createForms(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedFormJs ->
					form_fromJs(x1)
				},
			)),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun withEncryptionMetadata(
		base: DecryptedFormJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedFormJs> = GlobalScope.promise {
		form_toJs(formApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.form_fromJs(nonNull1)
		}, com.icure.sdk.js.model.patient_fromJs(patient), user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.js.model.embed.accessLevel_fromJs(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun deleteForm(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		docIdentifier_toJs(formApi.deleteForm(entityId))}


	override fun deleteForms(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			formApi.deleteForms(arrayToList(
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
		formTemplate_toJs(formApi.getFormTemplate(formTemplateId, raw))}


	override fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	): Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		listToArray(
			formApi.getFormTemplatesByGuid(formTemplateGuid, specialityCode, raw),
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)}


	override fun listFormTemplatesBySpeciality(specialityCode: String, raw: Boolean?):
			Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		listToArray(
			formApi.listFormTemplatesBySpeciality(specialityCode, raw),
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)}


	override fun getFormTemplates(loadLayout: Boolean?, raw: Boolean?): Promise<Array<FormTemplateJs>>
			= GlobalScope.promise {
		listToArray(
			formApi.getFormTemplates(loadLayout, raw),
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)}


	override fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		formTemplate_toJs(formApi.createFormTemplate(com.icure.sdk.js.model.formTemplate_fromJs(formTemplate)))}


	override fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(formApi.deleteFormTemplate(formTemplateId))}


	override fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		formTemplate_toJs(formApi.updateFormTemplate(com.icure.sdk.js.model.formTemplate_fromJs(formTemplate)))}


	override fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String> =
			GlobalScope.promise {
		formApi.setTemplateAttachment(formTemplateId, payload)}


	override fun shareWith(
		delegateId: String,
		form: DecryptedFormJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedFormJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			formApi.shareWith(delegateId, com.icure.sdk.js.model.form_fromJs(form),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedFormJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			formApi.findFormsByHcPartyPatient(hcPartyId, com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun modifyForm(entity: DecryptedFormJs): Promise<DecryptedFormJs> = GlobalScope.promise {
		form_toJs(formApi.modifyForm(com.icure.sdk.js.model.form_fromJs(entity)))}


	override fun modifyForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formApi.modifyForms(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedFormJs ->
					form_fromJs(x1)
				},
			)),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun getForm(entityId: String): Promise<DecryptedFormJs> = GlobalScope.promise {
		form_toJs(formApi.getForm(entityId))}


	override fun getForms(entityIds: Array<String>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formApi.getForms(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun getFormByLogicalUuid(logicalUuid: String): Promise<DecryptedFormJs> =
			GlobalScope.promise {
		form_toJs(formApi.getFormByLogicalUuid(logicalUuid))}


	override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formApi.getFormsByLogicalUuid(logicalUuid),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun getFormsByUniqueId(uniqueId: String): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		listToArray(
			formApi.getFormsByUniqueId(uniqueId),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun getFormByUniqueId(uniqueId: String): Promise<DecryptedFormJs> = GlobalScope.promise {
		form_toJs(formApi.getFormByUniqueId(uniqueId))}


	override fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<DecryptedFormJs>>
			= GlobalScope.promise {
		listToArray(
			formApi.getChildrenForms(hcPartyId, parentId),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}


	override fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		healthElementId: String?,
		planOfActionId: String?,
		formTemplateId: String?,
	): Promise<Array<DecryptedFormJs>> = GlobalScope.promise {
		listToArray(
			formApi.listFormsByHCPartyAndPatientForeignKeys(hcPartyId, secretFKeys, healthElementId,
					planOfActionId, formTemplateId),
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)}

}
