// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.FormApi
import com.icure.sdk.crypto.entities.FormShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.FormApiJs
import com.icure.sdk.js.api.flavoured.FormApi_findFormsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.FormApi_getFormTemplate_Options
import com.icure.sdk.js.api.flavoured.FormApi_getFormTemplates_Options
import com.icure.sdk.js.api.flavoured.FormApi_listFormTemplatesBySpeciality_Options
import com.icure.sdk.js.api.flavoured.FormApi_listFormsByHCPartyAndPatientForeignKeys_Options
import com.icure.sdk.js.api.flavoured.FormApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.FormApi_withEncryptionMetadata_Options
import com.icure.sdk.js.api.flavoured.FormFlavouredApiJs
import com.icure.sdk.js.api.flavoured.FormFlavouredApi_findFormsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.FormFlavouredApi_listFormsByHCPartyAndPatientForeignKeys_Options
import com.icure.sdk.js.api.flavoured.FormFlavouredApi_shareWith_Options
import com.icure.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.formShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedFormJs
import com.icure.sdk.js.model.EncryptedFormJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.FormTemplateJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.formTemplate_fromJs
import com.icure.sdk.js.model.formTemplate_toJs
import com.icure.sdk.js.model.form_fromJs
import com.icure.sdk.js.model.form_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedForm
import com.icure.sdk.model.EncryptedForm
import com.icure.sdk.model.Form
import com.icure.sdk.model.FormTemplate
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.ByteArray
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
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
			options: FormFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<EncryptedFormJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val formConverted: EncryptedForm = form_fromJs(form)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareEncryptionKeys,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareOwningEntityIds,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
					_options.requestedPermission,
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = formApi.encrypted.shareWith(
					delegateIdConverted,
					formConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedForm ->
						form_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(form: EncryptedFormJs,
				delegates: Record<String, FormShareOptionsJs>): Promise<SimpleShareResultJs<EncryptedFormJs>> =
				GlobalScope.promise {
			val formConverted: EncryptedForm = form_fromJs(form)
			val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: FormShareOptionsJs ->
					formShareOptions_fromJs(x1)
				},
			)
			val result = formApi.encrypted.tryShareWithMany(
				formConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedForm ->
					form_toJs(x1)
				},
			)
		}

		override fun shareWithMany(form: EncryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
				Promise<EncryptedFormJs> = GlobalScope.promise {
			val formConverted: EncryptedForm = form_fromJs(form)
			val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: FormShareOptionsJs ->
					formShareOptions_fromJs(x1)
				},
			)
			val result = formApi.encrypted.shareWithMany(
				formConverted,
				delegatesConverted,
			)
			form_toJs(result)
		}

		override fun findFormsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: FormFlavouredApi_findFormsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<EncryptedFormJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefault(
					_options.startDate,
					null
				) { startDate ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefault(
					_options.endDate,
					null
				) { endDate ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefault(
					_options.descending,
					null
				) { descending ->
					descending
				}
				val result = formApi.encrypted.findFormsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedForm ->
						form_toJs(x1)
					},
				)
			}
		}

		override fun modifyForm(entity: EncryptedFormJs): Promise<EncryptedFormJs> = GlobalScope.promise {
			val entityConverted: EncryptedForm = form_fromJs(entity)
			val result = formApi.encrypted.modifyForm(
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
			val result = formApi.encrypted.modifyForms(
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
			val result = formApi.encrypted.getForm(
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
			val result = formApi.encrypted.getForms(
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
			val result = formApi.encrypted.getFormByLogicalUuid(
				logicalUuidConverted,
			)
			form_toJs(result)
		}

		override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<EncryptedFormJs>> =
				GlobalScope.promise {
			val logicalUuidConverted: String = logicalUuid
			val result = formApi.encrypted.getFormsByLogicalUuid(
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
			val result = formApi.encrypted.getFormsByUniqueId(
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
			val result = formApi.encrypted.getFormByUniqueId(
				uniqueIdConverted,
			)
			form_toJs(result)
		}

		override fun getChildrenForms(hcPartyId: String, parentId: String):
				Promise<Array<EncryptedFormJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val parentIdConverted: String = parentId
			val result = formApi.encrypted.getChildrenForms(
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
			options: FormFlavouredApi_listFormsByHCPartyAndPatientForeignKeys_Options?,
		): Promise<Array<EncryptedFormJs>> {
			val _options = options ?: js("{}")
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
				val result = formApi.encrypted.listFormsByHCPartyAndPatientForeignKeys(
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

	override val tryAndRecover: FormFlavouredApiJs<FormJs> = object : FormFlavouredApiJs<FormJs> {
		override fun shareWith(
			delegateId: String,
			form: FormJs,
			options: FormFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<FormJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val formConverted: Form = form_fromJs(form)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareEncryptionKeys,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
					_options.shareOwningEntityIds,
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
					_options.requestedPermission,
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = formApi.tryAndRecover.shareWith(
					delegateIdConverted,
					formConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Form ->
						form_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(form: FormJs, delegates: Record<String, FormShareOptionsJs>):
				Promise<SimpleShareResultJs<FormJs>> = GlobalScope.promise {
			val formConverted: Form = form_fromJs(form)
			val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: FormShareOptionsJs ->
					formShareOptions_fromJs(x1)
				},
			)
			val result = formApi.tryAndRecover.tryShareWithMany(
				formConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun shareWithMany(form: FormJs, delegates: Record<String, FormShareOptionsJs>):
				Promise<FormJs> = GlobalScope.promise {
			val formConverted: Form = form_fromJs(form)
			val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: FormShareOptionsJs ->
					formShareOptions_fromJs(x1)
				},
			)
			val result = formApi.tryAndRecover.shareWithMany(
				formConverted,
				delegatesConverted,
			)
			form_toJs(result)
		}

		override fun findFormsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: FormFlavouredApi_findFormsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<FormJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefault(
					_options.startDate,
					null
				) { startDate ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefault(
					_options.endDate,
					null
				) { endDate ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefault(
					_options.descending,
					null
				) { descending ->
					descending
				}
				val result = formApi.tryAndRecover.findFormsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: Form ->
						form_toJs(x1)
					},
				)
			}
		}

		override fun modifyForm(entity: FormJs): Promise<FormJs> = GlobalScope.promise {
			val entityConverted: Form = form_fromJs(entity)
			val result = formApi.tryAndRecover.modifyForm(
				entityConverted,
			)
			form_toJs(result)
		}

		override fun modifyForms(entities: Array<FormJs>): Promise<Array<FormJs>> = GlobalScope.promise {
			val entitiesConverted: List<Form> = arrayToList(
				entities,
				"entities",
				{ x1: FormJs ->
					form_fromJs(x1)
				},
			)
			val result = formApi.tryAndRecover.modifyForms(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun getForm(entityId: String): Promise<FormJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = formApi.tryAndRecover.getForm(
				entityIdConverted,
			)
			form_toJs(result)
		}

		override fun getForms(entityIds: Array<String>): Promise<Array<FormJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = formApi.tryAndRecover.getForms(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun getFormByLogicalUuid(logicalUuid: String): Promise<FormJs> = GlobalScope.promise {
			val logicalUuidConverted: String = logicalUuid
			val result = formApi.tryAndRecover.getFormByLogicalUuid(
				logicalUuidConverted,
			)
			form_toJs(result)
		}

		override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<FormJs>> =
				GlobalScope.promise {
			val logicalUuidConverted: String = logicalUuid
			val result = formApi.tryAndRecover.getFormsByLogicalUuid(
				logicalUuidConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun getFormsByUniqueId(uniqueId: String): Promise<Array<FormJs>> = GlobalScope.promise {
			val uniqueIdConverted: String = uniqueId
			val result = formApi.tryAndRecover.getFormsByUniqueId(
				uniqueIdConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun getFormByUniqueId(uniqueId: String): Promise<FormJs> = GlobalScope.promise {
			val uniqueIdConverted: String = uniqueId
			val result = formApi.tryAndRecover.getFormByUniqueId(
				uniqueIdConverted,
			)
			form_toJs(result)
		}

		override fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<FormJs>> =
				GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val parentIdConverted: String = parentId
			val result = formApi.tryAndRecover.getChildrenForms(
				hcPartyIdConverted,
				parentIdConverted,
			)
			listToArray(
				result,
				{ x1: Form ->
					form_toJs(x1)
				},
			)
		}

		override fun listFormsByHCPartyAndPatientForeignKeys(
			hcPartyId: String,
			secretFKeys: String,
			options: FormFlavouredApi_listFormsByHCPartyAndPatientForeignKeys_Options?,
		): Promise<Array<FormJs>> {
			val _options = options ?: js("{}")
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
				val result = formApi.tryAndRecover.listFormsByHCPartyAndPatientForeignKeys(
					hcPartyIdConverted,
					secretFKeysConverted,
					healthElementIdConverted,
					planOfActionIdConverted,
					formTemplateIdConverted,
				)
				listToArray(
					result,
					{ x1: Form ->
						form_toJs(x1)
					},
				)
			}
		}
	}

	override fun createForm(entity: DecryptedFormJs): Promise<DecryptedFormJs> = GlobalScope.promise {
		val entityConverted: DecryptedForm = form_fromJs(entity)
		val result = formApi.createForm(
			entityConverted,
		)
		form_toJs(result)
	}

	override fun createForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<DecryptedForm> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedFormJs ->
				form_fromJs(x1)
			},
		)
		val result = formApi.createForms(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun withEncryptionMetadata(
		base: DecryptedFormJs?,
		patient: PatientJs,
		options: FormApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedFormJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedForm? = base?.let { nonNull1 ->
				form_fromJs(nonNull1)
			}
			val patientConverted: Patient = patient_fromJs(patient)
			val userConverted: User? = convertingOptionOrDefault(
				_options.user,
				null
			) { user ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefault(
				_options.delegates,
				emptyMap()
			) { delegates ->
				objectToMap(
					delegates,
					"delegates",
					{ x1: String ->
						x1
					},
					{ x1: String ->
						AccessLevel.valueOf(x1)
					},
				)
			}
			val secretIdConverted: SecretIdOption = convertingOptionOrDefault(
				_options.secretId,
				com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent
			) { secretId ->
				secretIdOption_fromJs(secretId)
			}
			val result = formApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			form_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(form: FormJs): Promise<Array<String>> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formApi.getEncryptionKeysOf(
			formConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(form: FormJs): Promise<Boolean> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formApi.hasWriteAccess(
			formConverted,
		)
		result
	}

	override fun decryptPatientIdOf(form: FormJs): Promise<Array<String>> = GlobalScope.promise {
		val formConverted: Form = form_fromJs(form)
		val result = formApi.decryptPatientIdOf(
			formConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: FormJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Form = form_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		formApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun deleteForm(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = formApi.deleteForm(
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
		val result = formApi.deleteForms(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getFormTemplate(formTemplateId: String, options: FormApi_getFormTemplate_Options?):
			Promise<FormTemplateJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val formTemplateIdConverted: String = formTemplateId
			val rawConverted: Boolean? = convertingOptionOrDefault(
				_options.raw,
				null
			) { raw ->
				raw
			}
			val result = formApi.getFormTemplate(
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
		val result = formApi.getFormTemplatesByGuid(
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
			options: FormApi_listFormTemplatesBySpeciality_Options?): Promise<Array<FormTemplateJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val specialityCodeConverted: String = specialityCode
			val rawConverted: Boolean? = convertingOptionOrDefault(
				_options.raw,
				null
			) { raw ->
				raw
			}
			val result = formApi.listFormTemplatesBySpeciality(
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

	override fun getFormTemplates(options: FormApi_getFormTemplates_Options?):
			Promise<Array<FormTemplateJs>> {
		val _options = options ?: js("{}")
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
			val result = formApi.getFormTemplates(
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
		val result = formApi.createFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun deleteFormTemplate(formTemplateId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val formTemplateIdConverted: String = formTemplateId
		val result = formApi.deleteFormTemplate(
			formTemplateIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun updateFormTemplate(formTemplate: FormTemplateJs): Promise<FormTemplateJs> =
			GlobalScope.promise {
		val formTemplateConverted: FormTemplate = formTemplate_fromJs(formTemplate)
		val result = formApi.updateFormTemplate(
			formTemplateConverted,
		)
		formTemplate_toJs(result)
	}

	override fun setTemplateAttachment(formTemplateId: String, payload: ByteArray): Promise<String> =
			GlobalScope.promise {
		val formTemplateIdConverted: String = formTemplateId
		val payloadConverted: ByteArray = payload
		val result = formApi.setTemplateAttachment(
			formTemplateIdConverted,
			payloadConverted,
		)
		result
	}

	override fun shareWith(
		delegateId: String,
		form: DecryptedFormJs,
		options: FormApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedFormJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val formConverted: DecryptedForm = form_fromJs(form)
			val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
				_options.shareEncryptionKeys,
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareEncryptionKeys ->
				ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
			}
			val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefault(
				_options.shareOwningEntityIds,
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareOwningEntityIds ->
				ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
			}
			val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefault(
				_options.requestedPermission,
				com.icure.sdk.model.requests.RequestedPermission.MaxWrite
			) { requestedPermission ->
				RequestedPermission.valueOf(requestedPermission)
			}
			val result = formApi.shareWith(
				delegateIdConverted,
				formConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedForm ->
					form_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(form: DecryptedFormJs,
			delegates: Record<String, FormShareOptionsJs>): Promise<SimpleShareResultJs<DecryptedFormJs>> =
			GlobalScope.promise {
		val formConverted: DecryptedForm = form_fromJs(form)
		val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: FormShareOptionsJs ->
				formShareOptions_fromJs(x1)
			},
		)
		val result = formApi.tryShareWithMany(
			formConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun shareWithMany(form: DecryptedFormJs, delegates: Record<String, FormShareOptionsJs>):
			Promise<DecryptedFormJs> = GlobalScope.promise {
		val formConverted: DecryptedForm = form_fromJs(form)
		val delegatesConverted: Map<String, FormShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: FormShareOptionsJs ->
				formShareOptions_fromJs(x1)
			},
		)
		val result = formApi.shareWithMany(
			formConverted,
			delegatesConverted,
		)
		form_toJs(result)
	}

	override fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: FormApi_findFormsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedFormJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefault(
				_options.startDate,
				null
			) { startDate ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefault(
				_options.endDate,
				null
			) { endDate ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefault(
				_options.descending,
				null
			) { descending ->
				descending
			}
			val result = formApi.findFormsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedForm ->
					form_toJs(x1)
				},
			)
		}
	}

	override fun modifyForm(entity: DecryptedFormJs): Promise<DecryptedFormJs> = GlobalScope.promise {
		val entityConverted: DecryptedForm = form_fromJs(entity)
		val result = formApi.modifyForm(
			entityConverted,
		)
		form_toJs(result)
	}

	override fun modifyForms(entities: Array<DecryptedFormJs>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val entitiesConverted: List<DecryptedForm> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedFormJs ->
				form_fromJs(x1)
			},
		)
		val result = formApi.modifyForms(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getForm(entityId: String): Promise<DecryptedFormJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = formApi.getForm(
			entityIdConverted,
		)
		form_toJs(result)
	}

	override fun getForms(entityIds: Array<String>): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = formApi.getForms(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getFormByLogicalUuid(logicalUuid: String): Promise<DecryptedFormJs> =
			GlobalScope.promise {
		val logicalUuidConverted: String = logicalUuid
		val result = formApi.getFormByLogicalUuid(
			logicalUuidConverted,
		)
		form_toJs(result)
	}

	override fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val logicalUuidConverted: String = logicalUuid
		val result = formApi.getFormsByLogicalUuid(
			logicalUuidConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getFormsByUniqueId(uniqueId: String): Promise<Array<DecryptedFormJs>> =
			GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formApi.getFormsByUniqueId(
			uniqueIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun getFormByUniqueId(uniqueId: String): Promise<DecryptedFormJs> = GlobalScope.promise {
		val uniqueIdConverted: String = uniqueId
		val result = formApi.getFormByUniqueId(
			uniqueIdConverted,
		)
		form_toJs(result)
	}

	override fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<DecryptedFormJs>>
			= GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val parentIdConverted: String = parentId
		val result = formApi.getChildrenForms(
			hcPartyIdConverted,
			parentIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedForm ->
				form_toJs(x1)
			},
		)
	}

	override fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		options: FormApi_listFormsByHCPartyAndPatientForeignKeys_Options?,
	): Promise<Array<DecryptedFormJs>> {
		val _options = options ?: js("{}")
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
			val result = formApi.listFormsByHCPartyAndPatientForeignKeys(
				hcPartyIdConverted,
				secretFKeysConverted,
				healthElementIdConverted,
				planOfActionIdConverted,
				formTemplateIdConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedForm ->
					form_toJs(x1)
				},
			)
		}
	}
}
