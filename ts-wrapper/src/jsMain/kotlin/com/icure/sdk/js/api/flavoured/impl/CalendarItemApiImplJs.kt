// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.CalendarItemApi
import com.icure.sdk.crypto.entities.CalendarItemShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.CalendarItemApiJs
import com.icure.sdk.js.api.flavoured.CalendarItemApi_findCalendarItemsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.CalendarItemApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.CalendarItemApi_withEncryptionMetadata_Options
import com.icure.sdk.js.api.flavoured.CalendarItemFlavouredApiJs
import com.icure.sdk.js.api.flavoured.CalendarItemFlavouredApi_findCalendarItemsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.CalendarItemFlavouredApi_shareWith_Options
import com.icure.sdk.js.crypto.entities.CalendarItemShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.calendarItemShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CalendarItemJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedCalendarItemJs
import com.icure.sdk.js.model.EncryptedCalendarItemJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.calendarItem_fromJs
import com.icure.sdk.js.model.calendarItem_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.CalendarItem
import com.icure.sdk.model.DecryptedCalendarItem
import com.icure.sdk.model.EncryptedCalendarItem
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
internal class CalendarItemApiImplJs(
	private val calendarItemApi: CalendarItemApi,
) : CalendarItemApiJs {
	override val encrypted: CalendarItemFlavouredApiJs<EncryptedCalendarItemJs> = object :
			CalendarItemFlavouredApiJs<EncryptedCalendarItemJs> {
		override fun shareWith(
			delegateId: String,
			calendarItem: EncryptedCalendarItemJs,
			options: CalendarItemFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<EncryptedCalendarItemJs>> {
			val _options: CalendarItemFlavouredApi_shareWith_Options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val calendarItemConverted: EncryptedCalendarItem = calendarItem_fromJs(calendarItem)
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
				val result = calendarItemApi.encrypted.shareWith(
					delegateIdConverted,
					calendarItemConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedCalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(calendarItem: EncryptedCalendarItemJs,
				delegates: Record<String, CalendarItemShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val calendarItemConverted: EncryptedCalendarItem = calendarItem_fromJs(calendarItem)
			val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CalendarItemShareOptionsJs ->
					calendarItemShareOptions_fromJs(x1)
				},
			)
			val result = calendarItemApi.encrypted.tryShareWithMany(
				calendarItemConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun shareWithMany(calendarItem: EncryptedCalendarItemJs,
				delegates: Record<String, CalendarItemShareOptionsJs>): Promise<EncryptedCalendarItemJs> =
				GlobalScope.promise {
			val calendarItemConverted: EncryptedCalendarItem = calendarItem_fromJs(calendarItem)
			val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CalendarItemShareOptionsJs ->
					calendarItemShareOptions_fromJs(x1)
				},
			)
			val result = calendarItemApi.encrypted.shareWithMany(
				calendarItemConverted,
				delegatesConverted,
			)
			calendarItem_toJs(result)
		}

		override fun findCalendarItemsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: CalendarItemFlavouredApi_findCalendarItemsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<EncryptedCalendarItemJs>> {
			val _options: CalendarItemFlavouredApi_findCalendarItemsByHcPartyPatient_Options = options ?:
					js("{}")
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
				val result = calendarItemApi.encrypted.findCalendarItemsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedCalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}
		}

		override fun linkToPatient(
			calendarItem: CalendarItemJs,
			patient: PatientJs,
			shareLinkWithDelegates: Array<String>,
		): Promise<EncryptedCalendarItemJs> = GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val patientConverted: Patient = patient_fromJs(patient)
			val shareLinkWithDelegatesConverted: Set<String> = arrayToSet(
				shareLinkWithDelegates,
				"shareLinkWithDelegates",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.encrypted.linkToPatient(
				calendarItemConverted,
				patientConverted,
				shareLinkWithDelegatesConverted,
			)
			calendarItem_toJs(result)
		}

		override fun modifyCalendarItem(entity: EncryptedCalendarItemJs): Promise<EncryptedCalendarItemJs>
				= GlobalScope.promise {
			val entityConverted: EncryptedCalendarItem = calendarItem_fromJs(entity)
			val result = calendarItemApi.encrypted.modifyCalendarItem(
				entityConverted,
			)
			calendarItem_toJs(result)
		}

		override fun getCalendarItem(entityId: String): Promise<EncryptedCalendarItemJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = calendarItemApi.encrypted.getCalendarItem(
				entityIdConverted,
			)
			calendarItem_toJs(result)
		}

		override fun getCalendarItems(entityIds: Array<String>): Promise<Array<EncryptedCalendarItemJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.encrypted.getCalendarItems(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarItemsByPeriodAndHcPartyId(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
		): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val hcPartyIdConverted: String = hcPartyId
			val result = calendarItemApi.encrypted.getCalendarItemsByPeriodAndHcPartyId(
				startDateConverted,
				endDateConverted,
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarsByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val agendaIdConverted: String = agendaId
			val result = calendarItemApi.encrypted.getCalendarsByPeriodAndAgendaId(
				startDateConverted,
				endDateConverted,
				agendaIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarItemsWithIds(entityIds: Array<String>):
				Promise<Array<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.encrypted.getCalendarItemsWithIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun findCalendarItemsByRecurrenceId(
			recurrenceId: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double,
		): Promise<PaginatedListJs<EncryptedCalendarItemJs>> = GlobalScope.promise {
			val recurrenceIdConverted: String = recurrenceId
			val startKeyConverted: String? = startKey
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int = numberToInt(limit, "limit")
			val result = calendarItemApi.encrypted.findCalendarItemsByRecurrenceId(
				recurrenceIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: CalendarItemFlavouredApiJs<CalendarItemJs> = object :
			CalendarItemFlavouredApiJs<CalendarItemJs> {
		override fun shareWith(
			delegateId: String,
			calendarItem: CalendarItemJs,
			options: CalendarItemFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<CalendarItemJs>> {
			val _options: CalendarItemFlavouredApi_shareWith_Options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
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
				val result = calendarItemApi.tryAndRecover.shareWith(
					delegateIdConverted,
					calendarItemConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: CalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(calendarItem: CalendarItemJs,
				delegates: Record<String, CalendarItemShareOptionsJs>):
				Promise<SimpleShareResultJs<CalendarItemJs>> = GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CalendarItemShareOptionsJs ->
					calendarItemShareOptions_fromJs(x1)
				},
			)
			val result = calendarItemApi.tryAndRecover.tryShareWithMany(
				calendarItemConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun shareWithMany(calendarItem: CalendarItemJs,
				delegates: Record<String, CalendarItemShareOptionsJs>): Promise<CalendarItemJs> =
				GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: CalendarItemShareOptionsJs ->
					calendarItemShareOptions_fromJs(x1)
				},
			)
			val result = calendarItemApi.tryAndRecover.shareWithMany(
				calendarItemConverted,
				delegatesConverted,
			)
			calendarItem_toJs(result)
		}

		override fun findCalendarItemsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: CalendarItemFlavouredApi_findCalendarItemsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<CalendarItemJs>> {
			val _options: CalendarItemFlavouredApi_findCalendarItemsByHcPartyPatient_Options = options ?:
					js("{}")
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
				val result = calendarItemApi.tryAndRecover.findCalendarItemsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: CalendarItem ->
						calendarItem_toJs(x1)
					},
				)
			}
		}

		override fun linkToPatient(
			calendarItem: CalendarItemJs,
			patient: PatientJs,
			shareLinkWithDelegates: Array<String>,
		): Promise<CalendarItemJs> = GlobalScope.promise {
			val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
			val patientConverted: Patient = patient_fromJs(patient)
			val shareLinkWithDelegatesConverted: Set<String> = arrayToSet(
				shareLinkWithDelegates,
				"shareLinkWithDelegates",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.tryAndRecover.linkToPatient(
				calendarItemConverted,
				patientConverted,
				shareLinkWithDelegatesConverted,
			)
			calendarItem_toJs(result)
		}

		override fun modifyCalendarItem(entity: CalendarItemJs): Promise<CalendarItemJs> =
				GlobalScope.promise {
			val entityConverted: CalendarItem = calendarItem_fromJs(entity)
			val result = calendarItemApi.tryAndRecover.modifyCalendarItem(
				entityConverted,
			)
			calendarItem_toJs(result)
		}

		override fun getCalendarItem(entityId: String): Promise<CalendarItemJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = calendarItemApi.tryAndRecover.getCalendarItem(
				entityIdConverted,
			)
			calendarItem_toJs(result)
		}

		override fun getCalendarItems(entityIds: Array<String>): Promise<Array<CalendarItemJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.tryAndRecover.getCalendarItems(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarItemsByPeriodAndHcPartyId(
			startDate: Double,
			endDate: Double,
			hcPartyId: String,
		): Promise<Array<CalendarItemJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val hcPartyIdConverted: String = hcPartyId
			val result = calendarItemApi.tryAndRecover.getCalendarItemsByPeriodAndHcPartyId(
				startDateConverted,
				endDateConverted,
				hcPartyIdConverted,
			)
			listToArray(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarsByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<CalendarItemJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val agendaIdConverted: String = agendaId
			val result = calendarItemApi.tryAndRecover.getCalendarsByPeriodAndAgendaId(
				startDateConverted,
				endDateConverted,
				agendaIdConverted,
			)
			listToArray(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun getCalendarItemsWithIds(entityIds: Array<String>): Promise<Array<CalendarItemJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = calendarItemApi.tryAndRecover.getCalendarItemsWithIds(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}

		override fun findCalendarItemsByRecurrenceId(
			recurrenceId: String,
			startKey: String?,
			startDocumentId: String?,
			limit: Double,
		): Promise<PaginatedListJs<CalendarItemJs>> = GlobalScope.promise {
			val recurrenceIdConverted: String = recurrenceId
			val startKeyConverted: String? = startKey
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int = numberToInt(limit, "limit")
			val result = calendarItemApi.tryAndRecover.findCalendarItemsByRecurrenceId(
				recurrenceIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: CalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}

	override fun createCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>
			= GlobalScope.promise {
		val entityConverted: DecryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemApi.createCalendarItem(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun withEncryptionMetadata(
		base: DecryptedCalendarItemJs?,
		patient: PatientJs,
		options: CalendarItemApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedCalendarItemJs> {
		val _options: CalendarItemApi_withEncryptionMetadata_Options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedCalendarItem? = base?.let { nonNull1 ->
				calendarItem_fromJs(nonNull1)
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
			val result = calendarItemApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			calendarItem_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(calendarItem: CalendarItemJs): Promise<Array<String>> =
			GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemApi.getEncryptionKeysOf(
			calendarItemConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(calendarItem: CalendarItemJs): Promise<Boolean> = GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemApi.hasWriteAccess(
			calendarItemConverted,
		)
		result
	}

	override fun decryptPatientIdOf(calendarItem: CalendarItemJs): Promise<Array<String>> =
			GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val result = calendarItemApi.decryptPatientIdOf(
			calendarItemConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: CalendarItemJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: CalendarItem = calendarItem_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		calendarItemApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun deleteCalendarItem(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = calendarItemApi.deleteCalendarItem(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteCalendarItems(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemApi.deleteCalendarItems(
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
		calendarItem: DecryptedCalendarItemJs,
		options: CalendarItemApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedCalendarItemJs>> {
		val _options: CalendarItemApi_shareWith_Options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val calendarItemConverted: DecryptedCalendarItem = calendarItem_fromJs(calendarItem)
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
			val result = calendarItemApi.shareWith(
				delegateIdConverted,
				calendarItemConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(calendarItem: DecryptedCalendarItemJs,
			delegates: Record<String, CalendarItemShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val calendarItemConverted: DecryptedCalendarItem = calendarItem_fromJs(calendarItem)
		val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: CalendarItemShareOptionsJs ->
				calendarItemShareOptions_fromJs(x1)
			},
		)
		val result = calendarItemApi.tryShareWithMany(
			calendarItemConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun shareWithMany(calendarItem: DecryptedCalendarItemJs,
			delegates: Record<String, CalendarItemShareOptionsJs>): Promise<DecryptedCalendarItemJs> =
			GlobalScope.promise {
		val calendarItemConverted: DecryptedCalendarItem = calendarItem_fromJs(calendarItem)
		val delegatesConverted: Map<String, CalendarItemShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: CalendarItemShareOptionsJs ->
				calendarItemShareOptions_fromJs(x1)
			},
		)
		val result = calendarItemApi.shareWithMany(
			calendarItemConverted,
			delegatesConverted,
		)
		calendarItem_toJs(result)
	}

	override fun findCalendarItemsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: CalendarItemApi_findCalendarItemsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedCalendarItemJs>> {
		val _options: CalendarItemApi_findCalendarItemsByHcPartyPatient_Options = options ?: js("{}")
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
			val result = calendarItemApi.findCalendarItemsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedCalendarItem ->
					calendarItem_toJs(x1)
				},
			)
		}
	}

	override fun linkToPatient(
		calendarItem: CalendarItemJs,
		patient: PatientJs,
		shareLinkWithDelegates: Array<String>,
	): Promise<DecryptedCalendarItemJs> = GlobalScope.promise {
		val calendarItemConverted: CalendarItem = calendarItem_fromJs(calendarItem)
		val patientConverted: Patient = patient_fromJs(patient)
		val shareLinkWithDelegatesConverted: Set<String> = arrayToSet(
			shareLinkWithDelegates,
			"shareLinkWithDelegates",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemApi.linkToPatient(
			calendarItemConverted,
			patientConverted,
			shareLinkWithDelegatesConverted,
		)
		calendarItem_toJs(result)
	}

	override fun modifyCalendarItem(entity: DecryptedCalendarItemJs): Promise<DecryptedCalendarItemJs>
			= GlobalScope.promise {
		val entityConverted: DecryptedCalendarItem = calendarItem_fromJs(entity)
		val result = calendarItemApi.modifyCalendarItem(
			entityConverted,
		)
		calendarItem_toJs(result)
	}

	override fun getCalendarItem(entityId: String): Promise<DecryptedCalendarItemJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = calendarItemApi.getCalendarItem(
			entityIdConverted,
		)
		calendarItem_toJs(result)
	}

	override fun getCalendarItems(entityIds: Array<String>): Promise<Array<DecryptedCalendarItemJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemApi.getCalendarItems(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarItemsByPeriodAndHcPartyId(
		startDate: Double,
		endDate: Double,
		hcPartyId: String,
	): Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val hcPartyIdConverted: String = hcPartyId
		val result = calendarItemApi.getCalendarItemsByPeriodAndHcPartyId(
			startDateConverted,
			endDateConverted,
			hcPartyIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarsByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val agendaIdConverted: String = agendaId
		val result = calendarItemApi.getCalendarsByPeriodAndAgendaId(
			startDateConverted,
			endDateConverted,
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun getCalendarItemsWithIds(entityIds: Array<String>):
			Promise<Array<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = calendarItemApi.getCalendarItemsWithIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}

	override fun findCalendarItemsByRecurrenceId(
		recurrenceId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double,
	): Promise<PaginatedListJs<DecryptedCalendarItemJs>> = GlobalScope.promise {
		val recurrenceIdConverted: String = recurrenceId
		val startKeyConverted: String? = startKey
		val startDocumentIdConverted: String? = startDocumentId
		val limitConverted: Int = numberToInt(limit, "limit")
		val result = calendarItemApi.findCalendarItemsByRecurrenceId(
			recurrenceIdConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedCalendarItem ->
				calendarItem_toJs(x1)
			},
		)
	}
}
