// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.FormBasicApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.FormBasicApiJs
import com.icure.sdk.js.api.flavoured.FormBasicApi_getFormTemplate_Options
import com.icure.sdk.js.api.flavoured.FormBasicApi_getFormTemplates_Options
import com.icure.sdk.js.api.flavoured.FormBasicApi_listFormTemplatesBySpeciality_Options
import com.icure.sdk.js.api.flavoured.FormBasicApi_listFormsByHCPartyAndPatientForeignKeys_Options
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.formTemplate_fromJs
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
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class FormBasicApiImplJs(
	private val formBasicApi: FormBasicApi,
) : FormBasicApiJs {
	override fun deleteForm(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = formBasicApi.deleteForm(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteForms(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = formBasicApi.deleteForms(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getFormTemplate(formTemplateId: String,
			options: FormBasicApi_getFormTemplate_Options?): Promise<FormTemplateJs> {
		val _options: FormBasicApi_getFormTemplate_Options = options ?: js("{}")
		return GlobalScope.promise {
			val formTemplateIdConverted: String = formTemplateId
			val rawConverted: Boolean? = convertingOptionOrDefault(
				_options.raw,
				null
			) { raw ->
				raw
			}
			val result = formBasicApi.getFormTemplate(
				formTemplateIdConverted,
				rawConverted,
			)
			formTemplate_toJs(result)
		}
	}

	override fun getFormTemplatesByGuid(
		formTemplateGuid: String,
		specialityCode: String,
		raw: Boolean?,
	): Promise<Array<FormTemplateJs>> = GlobalScope.promise {
		val formTemplateGuidConverted: String = formTemplateGuid
		val specialityCodeConverted: String = specialityCode
		val rawConverted: Boolean? = raw
		val result = formBasicApi.getFormTemplatesByGuid(
			formTemplateGuidConverted,
			specialityCodeConverted,
			rawConverted,
		)
		listToArray(
			result,
			{ x1: FormTemplate ->
				formTemplate_toJs(x1)
			},
		)
	}

	override fun listFormTemplatesBySpeciality(specialityCode: String,
			options: FormBasicApi_listFormTemplatesBySpeciality_Options?): Promise<Array<FormTemplateJs>> {
		val _options: FormBasicApi_listFormTemplatesBySpeciality_Options = options ?: js("{}")
		return GlobalScope.promise {
			val specialityCodeConverted: String = specialityCode
			val rawConverted: Boolean? = convertingOptionOrDefault(
				_options.raw,
				null
			) { raw ->
				raw
			}
			val result = formBasicApi.listFormTemplatesBySpeciality(
				specialityCodeConverted,
				rawConverted,
			)
			listToArray(
				result,
				{ x1: FormTemplate ->
					formTemplate_toJs(x1)
				},
			)
		}
	}

	override fun getFormTemplates(options: FormBasicApi_getFormTemplates_Options?):
			Promise<Array<FormTemplateJs>> {
		val _options: FormBasicApi_getFormTemplates_Options = options ?: js("{}")
		return GlobalScope.promise {
			val loadLayoutConverted: Boolean? = convertingOptionOrDefault(
				_options.loadLayout,
				null
			) { loadLayout ->
				loadLayout
			}
			val rawConverted: Boolean? = convertingOptionOrDefault(
				_options.raw,
				null
			) { raw ->
				raw
			}
			val result = formBasicApi.getFormTemplates(
				loadLayoutConverted,
				rawConverted,
			)
			listToArray(
				result,
				{ x1: FormTemplate ->
					formTemplate_toJs(x1)
				},
			)
		}
	}

	override fun createFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formBasicApi.createFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val formTemplateIdConverted: String = formTemplateId
		val result = formBasicApi.deleteFormTemplate(
			formTemplateIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formBasicApi.updateFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String> =
			GlobalScope.promise {
		val formTemplateIdConverted: String = formTemplateId
		val payloadConverted: ByteArray = payload
		val result = formBasicApi.setTemplateAttachment(
			formTemplateIdConverted,
			payloadConverted,
		)
		result
	}

	override fun modifyForm(entity: EncryptedFormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
		val entityConverted: EncryptedForm = form_fromJs(entity)
		val result = formBasicApi.modifyForm(
			entityConverted,
		)
		form_toJs(result)
	}

	override fun modifyForms(entities: Array<EncryptedFormJs>): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<EncryptedForm> = arrayToList(
			entities,
			"entities",
			{ x1: EncryptedFormJs ->
				form_fromJs(x1)
			},
		)
		val result = formBasicApi.modifyForms(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getForm(entityId: String): Promise<EncryptedFormJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = formBasicApi.getForm(
			entityIdConverted,
		)
		form_toJs(result)
	}

	override fun getForms(entityIds: Array<String>): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = formBasicApi.getForms(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getFormByLogicalUuid(logicalUuid: String): Promise<EncryptedFormJs> =
			GlobalScope.promise {
		val logicalUuidConverted: String = logicalUuid
		val result = formBasicApi.getFormByLogicalUuid(
			logicalUuidConverted,
		)
		form_toJs(result)
	}

	override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val logicalUuidConverted: String = logicalUuid
		val result = formBasicApi.getFormsByLogicalUuid(
			logicalUuidConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getFormsByUniqueId(uniqueId: String): Promise<Array<EncryptedFormJs>> =
			GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formBasicApi.getFormsByUniqueId(
			uniqueIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs> = GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formBasicApi.getFormByUniqueId(
			uniqueIdConverted,
		)
		form_toJs(result)
	}

	override fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<EncryptedFormJs>>
			= GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val parentIdConverted: String = parentId
		val result = formBasicApi.getChildrenForms(
			hcPartyIdConverted,
			parentIdConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		options: FormBasicApi_listFormsByHCPartyAndPatientForeignKeys_Options?,
	): Promise<Array<EncryptedFormJs>> {
		val _options: FormBasicApi_listFormsByHCPartyAndPatientForeignKeys_Options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretFKeysConverted: String = secretFKeys
			val healthElementIdConverted: String? = convertingOptionOrDefault(
				_options.healthElementId,
				null
			) { healthElementId ->
				healthElementId
			}
			val planOfActionIdConverted: String? = convertingOptionOrDefault(
				_options.planOfActionId,
				null
			) { planOfActionId ->
				planOfActionId
			}
			val formTemplateIdConverted: String? = convertingOptionOrDefault(
				_options.formTemplateId,
				null
			) { formTemplateId ->
				formTemplateId
			}
			val result = formBasicApi.listFormsByHCPartyAndPatientForeignKeys(
				hcPartyIdConverted,
				secretFKeysConverted,
				healthElementIdConverted,
				planOfActionIdConverted,
				formTemplateIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)
		}
	}
}
