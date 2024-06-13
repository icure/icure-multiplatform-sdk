// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ClassificationApi
import com.icure.sdk.crypto.entities.ClassificationShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.ClassificationApiJs
import com.icure.sdk.js.api.flavoured.ClassificationFlavouredApiJs
import com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.classificationShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.ClassificationJs
import com.icure.sdk.js.model.DecryptedClassificationJs
import com.icure.sdk.js.model.EncryptedClassificationJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.classification_fromJs
import com.icure.sdk.js.model.classification_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.Classification
import com.icure.sdk.model.DecryptedClassification
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
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
internal class ClassificationApiImplJs(
	private val classificationApi: ClassificationApi,
) : ClassificationApiJs {
	override val encrypted: ClassificationFlavouredApiJs<EncryptedClassificationJs> = object :
			ClassificationFlavouredApiJs<EncryptedClassificationJs> {
		override fun shareWith(
			delegateId: String,
			classification: EncryptedClassificationJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<EncryptedClassificationJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val classificationConverted: EncryptedClassification = classification_fromJs(classification)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareEncryptionKeys",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys: String ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareOwningEntityIds",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds: String ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
					_options,
					"requestedPermission",
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission: String ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = classificationApi.encrypted.shareWith(
					delegateIdConverted,
					classificationConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedClassification ->
						classification_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(classification: EncryptedClassificationJs,
				delegates: Record<String, ClassificationShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedClassificationJs>> = GlobalScope.promise {
			val classificationConverted: EncryptedClassification = classification_fromJs(classification)
			val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ClassificationShareOptionsJs ->
					classificationShareOptions_fromJs(x1)
				},
			)
			val result = classificationApi.encrypted.tryShareWithMany(
				classificationConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedClassification ->
					classification_toJs(x1)
				},
			)
		}

		override fun shareWithMany(classification: EncryptedClassificationJs,
				delegates: Record<String, ClassificationShareOptionsJs>): Promise<EncryptedClassificationJs> =
				GlobalScope.promise {
			val classificationConverted: EncryptedClassification = classification_fromJs(classification)
			val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ClassificationShareOptionsJs ->
					classificationShareOptions_fromJs(x1)
				},
			)
			val result = classificationApi.encrypted.shareWithMany(
				classificationConverted,
				delegatesConverted,
			)
			classification_toJs(result)
		}

		override fun findClassificationsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<EncryptedClassificationJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					descending
				}
				val result = classificationApi.encrypted.findClassificationsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedClassification ->
						classification_toJs(x1)
					},
				)
			}
		}

		override fun modifyClassification(entity: EncryptedClassificationJs):
				Promise<EncryptedClassificationJs> = GlobalScope.promise {
			val entityConverted: EncryptedClassification = classification_fromJs(entity)
			val result = classificationApi.encrypted.modifyClassification(
				entityConverted,
			)
			classification_toJs(result)
		}

		override fun getClassification(entityId: String): Promise<EncryptedClassificationJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = classificationApi.encrypted.getClassification(
				entityIdConverted,
			)
			classification_toJs(result)
		}

		override fun getClassifications(entityIds: Array<String>):
				Promise<Array<EncryptedClassificationJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = classificationApi.encrypted.getClassifications(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedClassification ->
					classification_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: ClassificationFlavouredApiJs<ClassificationJs> = object :
			ClassificationFlavouredApiJs<ClassificationJs> {
		override fun shareWith(
			delegateId: String,
			classification: ClassificationJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<ClassificationJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val classificationConverted: Classification = classification_fromJs(classification)
				val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareEncryptionKeys",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareEncryptionKeys: String ->
					ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
				}
				val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
					_options,
					"shareOwningEntityIds",
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
				) { shareOwningEntityIds: String ->
					ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
				}
				val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
					_options,
					"requestedPermission",
					com.icure.sdk.model.requests.RequestedPermission.MaxWrite
				) { requestedPermission: String ->
					RequestedPermission.valueOf(requestedPermission)
				}
				val result = classificationApi.tryAndRecover.shareWith(
					delegateIdConverted,
					classificationConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Classification ->
						classification_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(classification: ClassificationJs,
				delegates: Record<String, ClassificationShareOptionsJs>):
				Promise<SimpleShareResultJs<ClassificationJs>> = GlobalScope.promise {
			val classificationConverted: Classification = classification_fromJs(classification)
			val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ClassificationShareOptionsJs ->
					classificationShareOptions_fromJs(x1)
				},
			)
			val result = classificationApi.tryAndRecover.tryShareWithMany(
				classificationConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)
		}

		override fun shareWithMany(classification: ClassificationJs,
				delegates: Record<String, ClassificationShareOptionsJs>): Promise<ClassificationJs> =
				GlobalScope.promise {
			val classificationConverted: Classification = classification_fromJs(classification)
			val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: ClassificationShareOptionsJs ->
					classificationShareOptions_fromJs(x1)
				},
			)
			val result = classificationApi.tryAndRecover.shareWithMany(
				classificationConverted,
				delegatesConverted,
			)
			classification_toJs(result)
		}

		override fun findClassificationsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PaginatedListIteratorJs<ClassificationJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val hcPartyIdConverted: String = hcPartyId
				val patientConverted: Patient = patient_fromJs(patient)
				val startDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"startDate",
					null
				) { startDate: Double? ->
					numberToLong(startDate, "startDate")
				}
				val endDateConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"endDate",
					null
				) { endDate: Double? ->
					numberToLong(endDate, "endDate")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"descending",
					null
				) { descending: Boolean? ->
					descending
				}
				val result = classificationApi.tryAndRecover.findClassificationsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: Classification ->
						classification_toJs(x1)
					},
				)
			}
		}

		override fun modifyClassification(entity: ClassificationJs): Promise<ClassificationJs> =
				GlobalScope.promise {
			val entityConverted: Classification = classification_fromJs(entity)
			val result = classificationApi.tryAndRecover.modifyClassification(
				entityConverted,
			)
			classification_toJs(result)
		}

		override fun getClassification(entityId: String): Promise<ClassificationJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = classificationApi.tryAndRecover.getClassification(
				entityIdConverted,
			)
			classification_toJs(result)
		}

		override fun getClassifications(entityIds: Array<String>): Promise<Array<ClassificationJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = classificationApi.tryAndRecover.getClassifications(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)
		}
	}

	override fun createClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs> = GlobalScope.promise {
		val entityConverted: DecryptedClassification = classification_fromJs(entity)
		val result = classificationApi.createClassification(
			entityConverted,
		)
		classification_toJs(result)
	}

	override fun withEncryptionMetadata(
		base: DecryptedClassificationJs?,
		patient: PatientJs,
		options: dynamic,
	): Promise<DecryptedClassificationJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedClassification? = base?.let { nonNull1 ->
				classification_fromJs(nonNull1)
			}
			val patientConverted: Patient = patient_fromJs(patient)
			val userConverted: User? = convertingOptionOrDefaultNullable(
				_options,
				"user",
				null
			) { user: UserJs? ->
				user?.let { nonNull1 ->
					user_fromJs(nonNull1)
				}
			}
			val delegatesConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"delegates",
				emptyMap()
			) { delegates: Record<String, String> ->
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
			val secretIdConverted: SecretIdOption = convertingOptionOrDefaultNonNull(
				_options,
				"secretId",
				com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent
			) { secretId: SecretIdOptionJs ->
				secretIdOption_fromJs(secretId)
			}
			val result = classificationApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			classification_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(classification: ClassificationJs): Promise<Array<String>> =
			GlobalScope.promise {
		val classificationConverted: Classification = classification_fromJs(classification)
		val result = classificationApi.getEncryptionKeysOf(
			classificationConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(classification: ClassificationJs): Promise<Boolean> =
			GlobalScope.promise {
		val classificationConverted: Classification = classification_fromJs(classification)
		val result = classificationApi.hasWriteAccess(
			classificationConverted,
		)
		result
	}

	override fun decryptPatientIdOf(classification: ClassificationJs): Promise<Array<String>> =
			GlobalScope.promise {
		val classificationConverted: Classification = classification_fromJs(classification)
		val result = classificationApi.decryptPatientIdOf(
			classificationConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: ClassificationJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: Classification = classification_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		classificationApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun deleteClassification(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = classificationApi.deleteClassification(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = classificationApi.deleteClassifications(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		classification: DecryptedClassificationJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedClassificationJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val classificationConverted: DecryptedClassification = classification_fromJs(classification)
			val shareEncryptionKeysConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
				_options,
				"shareEncryptionKeys",
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareEncryptionKeys: String ->
				ShareMetadataBehaviour.valueOf(shareEncryptionKeys)
			}
			val shareOwningEntityIdsConverted: ShareMetadataBehaviour = convertingOptionOrDefaultNonNull(
				_options,
				"shareOwningEntityIds",
				com.icure.sdk.crypto.entities.ShareMetadataBehaviour.IfAvailable
			) { shareOwningEntityIds: String ->
				ShareMetadataBehaviour.valueOf(shareOwningEntityIds)
			}
			val requestedPermissionConverted: RequestedPermission = convertingOptionOrDefaultNonNull(
				_options,
				"requestedPermission",
				com.icure.sdk.model.requests.RequestedPermission.MaxWrite
			) { requestedPermission: String ->
				RequestedPermission.valueOf(requestedPermission)
			}
			val result = classificationApi.shareWith(
				delegateIdConverted,
				classificationConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedClassification ->
					classification_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(classification: DecryptedClassificationJs,
			delegates: Record<String, ClassificationShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedClassificationJs>> = GlobalScope.promise {
		val classificationConverted: DecryptedClassification = classification_fromJs(classification)
		val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ClassificationShareOptionsJs ->
				classificationShareOptions_fromJs(x1)
			},
		)
		val result = classificationApi.tryShareWithMany(
			classificationConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)
	}

	override fun shareWithMany(classification: DecryptedClassificationJs,
			delegates: Record<String, ClassificationShareOptionsJs>): Promise<DecryptedClassificationJs> =
			GlobalScope.promise {
		val classificationConverted: DecryptedClassification = classification_fromJs(classification)
		val delegatesConverted: Map<String, ClassificationShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: ClassificationShareOptionsJs ->
				classificationShareOptions_fromJs(x1)
			},
		)
		val result = classificationApi.shareWithMany(
			classificationConverted,
			delegatesConverted,
		)
		classification_toJs(result)
	}

	override fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<DecryptedClassificationJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val patientConverted: Patient = patient_fromJs(patient)
			val startDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startDate",
				null
			) { startDate: Double? ->
				numberToLong(startDate, "startDate")
			}
			val endDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"endDate",
				null
			) { endDate: Double? ->
				numberToLong(endDate, "endDate")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"descending",
				null
			) { descending: Boolean? ->
				descending
			}
			val result = classificationApi.findClassificationsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedClassification ->
					classification_toJs(x1)
				},
			)
		}
	}

	override fun modifyClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs> = GlobalScope.promise {
		val entityConverted: DecryptedClassification = classification_fromJs(entity)
		val result = classificationApi.modifyClassification(
			entityConverted,
		)
		classification_toJs(result)
	}

	override fun getClassification(entityId: String): Promise<DecryptedClassificationJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = classificationApi.getClassification(
			entityIdConverted,
		)
		classification_toJs(result)
	}

	override fun getClassifications(entityIds: Array<String>):
			Promise<Array<DecryptedClassificationJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = classificationApi.getClassifications(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)
	}
}
