// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.FormBasicApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.FormBasicApiJs
import com.icure.sdk.js.filters.BaseFilterOptionsJs
import com.icure.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.formTemplate_fromJs
import com.icure.sdk.js.model.formTemplate_toJs
import com.icure.sdk.js.model.form_fromJs
import com.icure.sdk.js.model.form_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.Form
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
	override fun matchFormsBy(filter: BaseFilterOptionsJs<FormJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Form> = baseFilterOptions_fromJs(filter)
		val result = formBasicApi.matchFormsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchFormsBySorted(filter: BaseSortableFilterOptionsJs<FormJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Form> = baseSortableFilterOptions_fromJs(filter)
		val result = formBasicApi.matchFormsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterFormsBy(filter: BaseFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<EncryptedFormJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Form> = baseFilterOptions_fromJs(filter)
		val result = formBasicApi.filterFormsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun filterFormsBySorted(filter: BaseSortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<EncryptedFormJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Form> = baseSortableFilterOptions_fromJs(filter)
		val result = formBasicApi.filterFormsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedForm ->
				form_toJs(x1)
			},
		)
	}

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

	override fun getFormTemplate(formTemplateId: String, options: dynamic): Promise<FormTemplateJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val formTemplateIdConverted: String = formTemplateId
			val rawConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"raw",
				null
			) { raw: Boolean? ->
				undefinedToNull(raw)
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
		val rawConverted: Boolean? = undefinedToNull(raw)
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

	override fun listFormTemplatesBySpeciality(specialityCode: String, options: dynamic):
			Promise<Array<FormTemplateJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val specialityCodeConverted: String = specialityCode
			val rawConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"raw",
				null
			) { raw: Boolean? ->
				undefinedToNull(raw)
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

	override fun getFormTemplates(options: dynamic): Promise<Array<FormTemplateJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val loadLayoutConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"loadLayout",
				null
			) { loadLayout: Boolean? ->
				undefinedToNull(loadLayout)
			}
			val rawConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"raw",
				null
			) { raw: Boolean? ->
				undefinedToNull(raw)
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

	override fun getLatestFormByLogicalUuid(logicalUuid: String): Promise<EncryptedFormJs> =
			GlobalScope.promise {
		val logicalUuidConverted: String = logicalUuid
		val result = formBasicApi.getLatestFormByLogicalUuid(
			logicalUuidConverted,
		)
		form_toJs(result)
	}

	override fun getLatestFormByUniqueId(uniqueId: String): Promise<EncryptedFormJs> =
			GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formBasicApi.getLatestFormByUniqueId(
			uniqueIdConverted,
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
		options: dynamic,
	): Promise<Array<EncryptedFormJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretFKeysConverted: String = secretFKeys
			val healthElementIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"healthElementId",
				null
			) { healthElementId: String? ->
				undefinedToNull(healthElementId)
			}
			val planOfActionIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"planOfActionId",
				null
			) { planOfActionId: String? ->
				undefinedToNull(planOfActionId)
			}
			val formTemplateIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"formTemplateId",
				null
			) { formTemplateId: String? ->
				undefinedToNull(formTemplateId)
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
