// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.AccessLogApi
import com.icure.sdk.crypto.entities.AccessLogShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.AccessLogApiJs
import com.icure.sdk.js.api.flavoured.AccessLogApi_findAccessLogsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.AccessLogApi_findAccessLogsByUserAfterDate_Options
import com.icure.sdk.js.api.flavoured.AccessLogApi_findAccessLogsInGroup_Options
import com.icure.sdk.js.api.flavoured.AccessLogApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.AccessLogApi_withEncryptionMetadata_Options
import com.icure.sdk.js.api.flavoured.AccessLogFlavouredApiJs
import com.icure.sdk.js.api.flavoured.AccessLogFlavouredApi_findAccessLogsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.AccessLogFlavouredApi_findAccessLogsByUserAfterDate_Options
import com.icure.sdk.js.api.flavoured.AccessLogFlavouredApi_findAccessLogsInGroup_Options
import com.icure.sdk.js.api.flavoured.AccessLogFlavouredApi_shareWith_Options
import com.icure.sdk.js.crypto.entities.AccessLogShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.accessLogShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.AccessLogJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedAccessLogJs
import com.icure.sdk.js.model.EncryptedAccessLogJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.accessLog_fromJs
import com.icure.sdk.js.model.accessLog_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.AccessLog
import com.icure.sdk.model.DecryptedAccessLog
import com.icure.sdk.model.EncryptedAccessLog
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.requests.RequestedPermission
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
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
internal class AccessLogApiImplJs(
	private val accessLogApi: AccessLogApi,
) : AccessLogApiJs {
	override val encrypted: AccessLogFlavouredApiJs<EncryptedAccessLogJs> = object :
			AccessLogFlavouredApiJs<EncryptedAccessLogJs> {
		override fun shareWith(
			delegateId: String,
			accessLog: EncryptedAccessLogJs,
			options: AccessLogFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<EncryptedAccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val accessLogConverted: EncryptedAccessLog = accessLog_fromJs(accessLog)
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
				val result = accessLogApi.encrypted.shareWith(
					delegateIdConverted,
					accessLogConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(accessLog: EncryptedAccessLogJs,
				delegates: Record<String, AccessLogShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val accessLogConverted: EncryptedAccessLog = accessLog_fromJs(accessLog)
			val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: AccessLogShareOptionsJs ->
					accessLogShareOptions_fromJs(x1)
				},
			)
			val result = accessLogApi.encrypted.tryShareWithMany(
				accessLogConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun shareWithMany(accessLog: EncryptedAccessLogJs,
				delegates: Record<String, AccessLogShareOptionsJs>): Promise<EncryptedAccessLogJs> =
				GlobalScope.promise {
			val accessLogConverted: EncryptedAccessLog = accessLog_fromJs(accessLog)
			val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: AccessLogShareOptionsJs ->
					accessLogShareOptions_fromJs(x1)
				},
			)
			val result = accessLogApi.encrypted.shareWithMany(
				accessLogConverted,
				delegatesConverted,
			)
			accessLog_toJs(result)
		}

		override fun findAccessLogsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: AccessLogFlavouredApi_findAccessLogsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<EncryptedAccessLogJs>> {
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
				val result = accessLogApi.encrypted.findAccessLogsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun modifyAccessLog(entity: EncryptedAccessLogJs): Promise<EncryptedAccessLogJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedAccessLog = accessLog_fromJs(entity)
			val result = accessLogApi.encrypted.modifyAccessLog(
				entityConverted,
			)
			accessLog_toJs(result)
		}

		override fun getAccessLog(entityId: String): Promise<EncryptedAccessLogJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = accessLogApi.encrypted.getAccessLog(
				entityIdConverted,
			)
			accessLog_toJs(result)
		}

		override fun getAccessLogs(entityIds: Array<String>): Promise<Array<EncryptedAccessLogJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = accessLogApi.encrypted.getAccessLogs(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun findAccessLogsBy(
			fromEpoch: Double?,
			toEpoch: Double?,
			startKey: Double?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedAccessLogJs>> = GlobalScope.promise {
			val fromEpochConverted: Long? = numberToLong(fromEpoch, "fromEpoch")
			val toEpochConverted: Long? = numberToLong(toEpoch, "toEpoch")
			val startKeyConverted: Long? = numberToLong(startKey, "startKey")
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = accessLogApi.encrypted.findAccessLogsBy(
				fromEpochConverted,
				toEpochConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun findAccessLogsByUserAfterDate(userId: String,
				options: AccessLogFlavouredApi_findAccessLogsByUserAfterDate_Options?):
				Promise<PaginatedListJs<EncryptedAccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdConverted: String = userId
				val accessTypeConverted: String? = convertingOptionOrDefault(
					_options.accessType,
					null
				) { accessType ->
					accessType
				}
				val startDateConverted: Long? = convertingOptionOrDefault(
					_options.startDate,
					null
				) { startDate ->
					numberToLong(startDate, "startDate")
				}
				val startKeyConverted: String? = convertingOptionOrDefault(
					_options.startKey,
					null
				) { startKey ->
					startKey
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefault(
					_options.startDocumentId,
					null
				) { startDocumentId ->
					startDocumentId
				}
				val limitConverted: Int? = convertingOptionOrDefault(
					_options.limit,
					null
				) { limit ->
					numberToInt(limit, "limit")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefault(
					_options.descending,
					null
				) { descending ->
					descending
				}
				val result = accessLogApi.encrypted.findAccessLogsByUserAfterDate(
					userIdConverted,
					accessTypeConverted,
					startDateConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					descendingConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun findAccessLogsInGroup(groupId: String,
				options: AccessLogFlavouredApi_findAccessLogsInGroup_Options?):
				Promise<PaginatedListJs<EncryptedAccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val groupIdConverted: String = groupId
				val fromEpochConverted: Long? = convertingOptionOrDefault(
					_options.fromEpoch,
					null
				) { fromEpoch ->
					numberToLong(fromEpoch, "fromEpoch")
				}
				val toEpochConverted: Long? = convertingOptionOrDefault(
					_options.toEpoch,
					null
				) { toEpoch ->
					numberToLong(toEpoch, "toEpoch")
				}
				val startKeyConverted: Long? = convertingOptionOrDefault(
					_options.startKey,
					null
				) { startKey ->
					numberToLong(startKey, "startKey")
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefault(
					_options.startDocumentId,
					null
				) { startDocumentId ->
					startDocumentId
				}
				val limitConverted: Int? = convertingOptionOrDefault(
					_options.limit,
					null
				) { limit ->
					numberToInt(limit, "limit")
				}
				val result = accessLogApi.encrypted.findAccessLogsInGroup(
					groupIdConverted,
					fromEpochConverted,
					toEpochConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: EncryptedAccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}
	}

	override val tryAndRecover: AccessLogFlavouredApiJs<AccessLogJs> = object :
			AccessLogFlavouredApiJs<AccessLogJs> {
		override fun shareWith(
			delegateId: String,
			accessLog: AccessLogJs,
			options: AccessLogFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<AccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
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
				val result = accessLogApi.tryAndRecover.shareWith(
					delegateIdConverted,
					accessLogConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(accessLog: AccessLogJs,
				delegates: Record<String, AccessLogShareOptionsJs>): Promise<SimpleShareResultJs<AccessLogJs>> =
				GlobalScope.promise {
			val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
			val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: AccessLogShareOptionsJs ->
					accessLogShareOptions_fromJs(x1)
				},
			)
			val result = accessLogApi.tryAndRecover.tryShareWithMany(
				accessLogConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun shareWithMany(accessLog: AccessLogJs,
				delegates: Record<String, AccessLogShareOptionsJs>): Promise<AccessLogJs> =
				GlobalScope.promise {
			val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
			val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: AccessLogShareOptionsJs ->
					accessLogShareOptions_fromJs(x1)
				},
			)
			val result = accessLogApi.tryAndRecover.shareWithMany(
				accessLogConverted,
				delegatesConverted,
			)
			accessLog_toJs(result)
		}

		override fun findAccessLogsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: AccessLogFlavouredApi_findAccessLogsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<AccessLogJs>> {
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
				val result = accessLogApi.tryAndRecover.findAccessLogsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun modifyAccessLog(entity: AccessLogJs): Promise<AccessLogJs> = GlobalScope.promise {
			val entityConverted: AccessLog = accessLog_fromJs(entity)
			val result = accessLogApi.tryAndRecover.modifyAccessLog(
				entityConverted,
			)
			accessLog_toJs(result)
		}

		override fun getAccessLog(entityId: String): Promise<AccessLogJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = accessLogApi.tryAndRecover.getAccessLog(
				entityIdConverted,
			)
			accessLog_toJs(result)
		}

		override fun getAccessLogs(entityIds: Array<String>): Promise<Array<AccessLogJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = accessLogApi.tryAndRecover.getAccessLogs(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun findAccessLogsBy(
			fromEpoch: Double?,
			toEpoch: Double?,
			startKey: Double?,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<AccessLogJs>> = GlobalScope.promise {
			val fromEpochConverted: Long? = numberToLong(fromEpoch, "fromEpoch")
			val toEpochConverted: Long? = numberToLong(toEpoch, "toEpoch")
			val startKeyConverted: Long? = numberToLong(startKey, "startKey")
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = accessLogApi.tryAndRecover.findAccessLogsBy(
				fromEpochConverted,
				toEpochConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: AccessLog ->
					accessLog_toJs(x1)
				},
			)
		}

		override fun findAccessLogsByUserAfterDate(userId: String,
				options: AccessLogFlavouredApi_findAccessLogsByUserAfterDate_Options?):
				Promise<PaginatedListJs<AccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val userIdConverted: String = userId
				val accessTypeConverted: String? = convertingOptionOrDefault(
					_options.accessType,
					null
				) { accessType ->
					accessType
				}
				val startDateConverted: Long? = convertingOptionOrDefault(
					_options.startDate,
					null
				) { startDate ->
					numberToLong(startDate, "startDate")
				}
				val startKeyConverted: String? = convertingOptionOrDefault(
					_options.startKey,
					null
				) { startKey ->
					startKey
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefault(
					_options.startDocumentId,
					null
				) { startDocumentId ->
					startDocumentId
				}
				val limitConverted: Int? = convertingOptionOrDefault(
					_options.limit,
					null
				) { limit ->
					numberToInt(limit, "limit")
				}
				val descendingConverted: Boolean? = convertingOptionOrDefault(
					_options.descending,
					null
				) { descending ->
					descending
				}
				val result = accessLogApi.tryAndRecover.findAccessLogsByUserAfterDate(
					userIdConverted,
					accessTypeConverted,
					startDateConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					descendingConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}

		override fun findAccessLogsInGroup(groupId: String,
				options: AccessLogFlavouredApi_findAccessLogsInGroup_Options?):
				Promise<PaginatedListJs<AccessLogJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val groupIdConverted: String = groupId
				val fromEpochConverted: Long? = convertingOptionOrDefault(
					_options.fromEpoch,
					null
				) { fromEpoch ->
					numberToLong(fromEpoch, "fromEpoch")
				}
				val toEpochConverted: Long? = convertingOptionOrDefault(
					_options.toEpoch,
					null
				) { toEpoch ->
					numberToLong(toEpoch, "toEpoch")
				}
				val startKeyConverted: Long? = convertingOptionOrDefault(
					_options.startKey,
					null
				) { startKey ->
					numberToLong(startKey, "startKey")
				}
				val startDocumentIdConverted: String? = convertingOptionOrDefault(
					_options.startDocumentId,
					null
				) { startDocumentId ->
					startDocumentId
				}
				val limitConverted: Int? = convertingOptionOrDefault(
					_options.limit,
					null
				) { limit ->
					numberToInt(limit, "limit")
				}
				val result = accessLogApi.tryAndRecover.findAccessLogsInGroup(
					groupIdConverted,
					fromEpochConverted,
					toEpochConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: AccessLog ->
						accessLog_toJs(x1)
					},
				)
			}
		}
	}

	override fun createAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedAccessLog = accessLog_fromJs(entity)
		val result = accessLogApi.createAccessLog(
			entityConverted,
		)
		accessLog_toJs(result)
	}

	override fun withEncryptionMetadata(
		base: DecryptedAccessLogJs?,
		patient: PatientJs,
		options: AccessLogApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedAccessLogJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedAccessLog? = base?.let { nonNull1 ->
				accessLog_fromJs(nonNull1)
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
			val result = accessLogApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			accessLog_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(accessLog: AccessLogJs): Promise<Array<String>> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.getEncryptionKeysOf(
			accessLogConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(accessLog: AccessLogJs): Promise<Boolean> = GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.hasWriteAccess(
			accessLogConverted,
		)
		result
	}

	override fun decryptPatientIdOf(accessLog: AccessLogJs): Promise<Array<String>> =
			GlobalScope.promise {
		val accessLogConverted: AccessLog = accessLog_fromJs(accessLog)
		val result = accessLogApi.decryptPatientIdOf(
			accessLogConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: AccessLogJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: AccessLog = accessLog_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		accessLogApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun deleteAccessLog(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = accessLogApi.deleteAccessLog(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteAccessLogs(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = accessLogApi.deleteAccessLogs(
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
		accessLog: DecryptedAccessLogJs,
		options: AccessLogApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedAccessLogJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val accessLogConverted: DecryptedAccessLog = accessLog_fromJs(accessLog)
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
			val result = accessLogApi.shareWith(
				delegateIdConverted,
				accessLogConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(accessLog: DecryptedAccessLogJs,
			delegates: Record<String, AccessLogShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedAccessLogJs>> = GlobalScope.promise {
		val accessLogConverted: DecryptedAccessLog = accessLog_fromJs(accessLog)
		val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: AccessLogShareOptionsJs ->
				accessLogShareOptions_fromJs(x1)
			},
		)
		val result = accessLogApi.tryShareWithMany(
			accessLogConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun shareWithMany(accessLog: DecryptedAccessLogJs,
			delegates: Record<String, AccessLogShareOptionsJs>): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val accessLogConverted: DecryptedAccessLog = accessLog_fromJs(accessLog)
		val delegatesConverted: Map<String, AccessLogShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: AccessLogShareOptionsJs ->
				accessLogShareOptions_fromJs(x1)
			},
		)
		val result = accessLogApi.shareWithMany(
			accessLogConverted,
			delegatesConverted,
		)
		accessLog_toJs(result)
	}

	override fun findAccessLogsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: AccessLogApi_findAccessLogsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedAccessLogJs>> {
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
			val result = accessLogApi.findAccessLogsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}

	override fun modifyAccessLog(entity: DecryptedAccessLogJs): Promise<DecryptedAccessLogJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedAccessLog = accessLog_fromJs(entity)
		val result = accessLogApi.modifyAccessLog(
			entityConverted,
		)
		accessLog_toJs(result)
	}

	override fun getAccessLog(entityId: String): Promise<DecryptedAccessLogJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = accessLogApi.getAccessLog(
			entityIdConverted,
		)
		accessLog_toJs(result)
	}

	override fun getAccessLogs(entityIds: Array<String>): Promise<Array<DecryptedAccessLogJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = accessLogApi.getAccessLogs(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun findAccessLogsBy(
		fromEpoch: Double?,
		toEpoch: Double?,
		startKey: Double?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedAccessLogJs>> = GlobalScope.promise {
		val fromEpochConverted: Long? = numberToLong(fromEpoch, "fromEpoch")
		val toEpochConverted: Long? = numberToLong(toEpoch, "toEpoch")
		val startKeyConverted: Long? = numberToLong(startKey, "startKey")
		val startDocumentIdConverted: String? = startDocumentId
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = accessLogApi.findAccessLogsBy(
			fromEpochConverted,
			toEpochConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedAccessLog ->
				accessLog_toJs(x1)
			},
		)
	}

	override fun findAccessLogsByUserAfterDate(userId: String,
			options: AccessLogApi_findAccessLogsByUserAfterDate_Options?):
			Promise<PaginatedListJs<DecryptedAccessLogJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val accessTypeConverted: String? = convertingOptionOrDefault(
				_options.accessType,
				null
			) { accessType ->
				accessType
			}
			val startDateConverted: Long? = convertingOptionOrDefault(
				_options.startDate,
				null
			) { startDate ->
				numberToLong(startDate, "startDate")
			}
			val startKeyConverted: String? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				startKey
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val descendingConverted: Boolean? = convertingOptionOrDefault(
				_options.descending,
				null
			) { descending ->
				descending
			}
			val result = accessLogApi.findAccessLogsByUserAfterDate(
				userIdConverted,
				accessTypeConverted,
				startDateConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				descendingConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}

	override fun findAccessLogsInGroup(groupId: String,
			options: AccessLogApi_findAccessLogsInGroup_Options?):
			Promise<PaginatedListJs<DecryptedAccessLogJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val fromEpochConverted: Long? = convertingOptionOrDefault(
				_options.fromEpoch,
				null
			) { fromEpoch ->
				numberToLong(fromEpoch, "fromEpoch")
			}
			val toEpochConverted: Long? = convertingOptionOrDefault(
				_options.toEpoch,
				null
			) { toEpoch ->
				numberToLong(toEpoch, "toEpoch")
			}
			val startKeyConverted: Long? = convertingOptionOrDefault(
				_options.startKey,
				null
			) { startKey ->
				numberToLong(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefault(
				_options.startDocumentId,
				null
			) { startDocumentId ->
				startDocumentId
			}
			val limitConverted: Int? = convertingOptionOrDefault(
				_options.limit,
				null
			) { limit ->
				numberToInt(limit, "limit")
			}
			val result = accessLogApi.findAccessLogsInGroup(
				groupIdConverted,
				fromEpochConverted,
				toEpochConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedAccessLog ->
					accessLog_toJs(x1)
				},
			)
		}
	}
}
