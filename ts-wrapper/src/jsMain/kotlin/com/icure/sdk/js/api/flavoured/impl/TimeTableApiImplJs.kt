// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.TimeTableApi
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.TimeTableShareOptions
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.TimeTableApiJs
import com.icure.sdk.js.api.flavoured.TimeTableFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.TimeTableShareOptionsJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.crypto.entities.timeTableShareOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedTimeTableJs
import com.icure.sdk.js.model.EncryptedTimeTableJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.TimeTableJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.timeTable_fromJs
import com.icure.sdk.js.model.timeTable_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.model.DecryptedTimeTable
import com.icure.sdk.model.EncryptedTimeTable
import com.icure.sdk.model.Patient
import com.icure.sdk.model.TimeTable
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
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
internal class TimeTableApiImplJs(
	private val timeTableApi: TimeTableApi,
) : TimeTableApiJs {
	override val encrypted: TimeTableFlavouredApiJs<EncryptedTimeTableJs> = object :
			TimeTableFlavouredApiJs<EncryptedTimeTableJs> {
		override fun shareWith(
			delegateId: String,
			timeTable: EncryptedTimeTableJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<EncryptedTimeTableJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val timeTableConverted: EncryptedTimeTable = timeTable_fromJs(timeTable)
				val optionsConverted: TimeTableShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: TimeTableShareOptionsJs? ->
					options?.let { nonNull1 ->
						timeTableShareOptions_fromJs(nonNull1)
					}
				}
				val result = timeTableApi.encrypted.shareWith(
					delegateIdConverted,
					timeTableConverted,
					optionsConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedTimeTable ->
						timeTable_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(timeTable: EncryptedTimeTableJs,
				delegates: Record<String, TimeTableShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedTimeTableJs>> = GlobalScope.promise {
			val timeTableConverted: EncryptedTimeTable = timeTable_fromJs(timeTable)
			val delegatesConverted: Map<String, TimeTableShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TimeTableShareOptionsJs ->
					timeTableShareOptions_fromJs(x1)
				},
			)
			val result = timeTableApi.encrypted.tryShareWithMany(
				timeTableConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedTimeTable ->
					timeTable_toJs(x1)
				},
			)
		}

		override fun shareWithMany(timeTable: EncryptedTimeTableJs,
				delegates: Record<String, TimeTableShareOptionsJs>): Promise<EncryptedTimeTableJs> =
				GlobalScope.promise {
			val timeTableConverted: EncryptedTimeTable = timeTable_fromJs(timeTable)
			val delegatesConverted: Map<String, TimeTableShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TimeTableShareOptionsJs ->
					timeTableShareOptions_fromJs(x1)
				},
			)
			val result = timeTableApi.encrypted.shareWithMany(
				timeTableConverted,
				delegatesConverted,
			)
			timeTable_toJs(result)
		}

		override fun modifyTimeTable(entity: EncryptedTimeTableJs): Promise<EncryptedTimeTableJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedTimeTable = timeTable_fromJs(entity)
			val result = timeTableApi.encrypted.modifyTimeTable(
				entityConverted,
			)
			timeTable_toJs(result)
		}

		override fun getTimeTable(entityId: String): Promise<EncryptedTimeTableJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = timeTableApi.encrypted.getTimeTable(
				entityIdConverted,
			)
			timeTable_toJs(result)
		}

		override fun getTimeTablesByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<EncryptedTimeTableJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val agendaIdConverted: String = agendaId
			val result = timeTableApi.encrypted.getTimeTablesByPeriodAndAgendaId(
				startDateConverted,
				endDateConverted,
				agendaIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedTimeTable ->
					timeTable_toJs(x1)
				},
			)
		}

		override fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<EncryptedTimeTableJs>> =
				GlobalScope.promise {
			val agendaIdConverted: String = agendaId
			val result = timeTableApi.encrypted.getTimeTablesByAgendaId(
				agendaIdConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedTimeTable ->
					timeTable_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: TimeTableFlavouredApiJs<TimeTableJs> = object :
			TimeTableFlavouredApiJs<TimeTableJs> {
		override fun shareWith(
			delegateId: String,
			timeTable: TimeTableJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<TimeTableJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
				val optionsConverted: TimeTableShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: TimeTableShareOptionsJs? ->
					options?.let { nonNull1 ->
						timeTableShareOptions_fromJs(nonNull1)
					}
				}
				val result = timeTableApi.tryAndRecover.shareWith(
					delegateIdConverted,
					timeTableConverted,
					optionsConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: TimeTable ->
						timeTable_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(timeTable: TimeTableJs,
				delegates: Record<String, TimeTableShareOptionsJs>): Promise<SimpleShareResultJs<TimeTableJs>> =
				GlobalScope.promise {
			val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
			val delegatesConverted: Map<String, TimeTableShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TimeTableShareOptionsJs ->
					timeTableShareOptions_fromJs(x1)
				},
			)
			val result = timeTableApi.tryAndRecover.tryShareWithMany(
				timeTableConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: TimeTable ->
					timeTable_toJs(x1)
				},
			)
		}

		override fun shareWithMany(timeTable: TimeTableJs,
				delegates: Record<String, TimeTableShareOptionsJs>): Promise<TimeTableJs> =
				GlobalScope.promise {
			val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
			val delegatesConverted: Map<String, TimeTableShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: TimeTableShareOptionsJs ->
					timeTableShareOptions_fromJs(x1)
				},
			)
			val result = timeTableApi.tryAndRecover.shareWithMany(
				timeTableConverted,
				delegatesConverted,
			)
			timeTable_toJs(result)
		}

		override fun modifyTimeTable(entity: TimeTableJs): Promise<TimeTableJs> = GlobalScope.promise {
			val entityConverted: TimeTable = timeTable_fromJs(entity)
			val result = timeTableApi.tryAndRecover.modifyTimeTable(
				entityConverted,
			)
			timeTable_toJs(result)
		}

		override fun getTimeTable(entityId: String): Promise<TimeTableJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = timeTableApi.tryAndRecover.getTimeTable(
				entityIdConverted,
			)
			timeTable_toJs(result)
		}

		override fun getTimeTablesByPeriodAndAgendaId(
			startDate: Double,
			endDate: Double,
			agendaId: String,
		): Promise<Array<TimeTableJs>> = GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val agendaIdConverted: String = agendaId
			val result = timeTableApi.tryAndRecover.getTimeTablesByPeriodAndAgendaId(
				startDateConverted,
				endDateConverted,
				agendaIdConverted,
			)
			listToArray(
				result,
				{ x1: TimeTable ->
					timeTable_toJs(x1)
				},
			)
		}

		override fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<TimeTableJs>> =
				GlobalScope.promise {
			val agendaIdConverted: String = agendaId
			val result = timeTableApi.tryAndRecover.getTimeTablesByAgendaId(
				agendaIdConverted,
			)
			listToArray(
				result,
				{ x1: TimeTable ->
					timeTable_toJs(x1)
				},
			)
		}
	}

	override fun createTimeTable(entity: DecryptedTimeTableJs): Promise<DecryptedTimeTableJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedTimeTable = timeTable_fromJs(entity)
		val result = timeTableApi.createTimeTable(
			entityConverted,
		)
		timeTable_toJs(result)
	}

	override fun withEncryptionMetadata(
		base: DecryptedTimeTableJs?,
		patient: PatientJs?,
		options: dynamic,
	): Promise<DecryptedTimeTableJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedTimeTable? = base?.let { nonNull1 ->
				timeTable_fromJs(nonNull1)
			}
			val patientConverted: Patient? = patient?.let { nonNull1 ->
				patient_fromJs(nonNull1)
			}
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
			val result = timeTableApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			timeTable_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(timeTable: TimeTableJs): Promise<Array<String>> =
			GlobalScope.promise {
		val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
		val result = timeTableApi.getEncryptionKeysOf(
			timeTableConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(timeTable: TimeTableJs): Promise<Boolean> = GlobalScope.promise {
		val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
		val result = timeTableApi.hasWriteAccess(
			timeTableConverted,
		)
		result
	}

	override fun decryptPatientIdOf(timeTable: TimeTableJs): Promise<Array<String>> =
			GlobalScope.promise {
		val timeTableConverted: TimeTable = timeTable_fromJs(timeTable)
		val result = timeTableApi.decryptPatientIdOf(
			timeTableConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: TimeTableJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: TimeTable = timeTable_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		timeTableApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(timeTable: EncryptedTimeTableJs): Promise<DecryptedTimeTableJs> =
			GlobalScope.promise {
		val timeTableConverted: EncryptedTimeTable = timeTable_fromJs(timeTable)
		val result = timeTableApi.decrypt(
			timeTableConverted,
		)
		timeTable_toJs(result)
	}

	override fun tryDecrypt(timeTable: EncryptedTimeTableJs): Promise<TimeTableJs> =
			GlobalScope.promise {
		val timeTableConverted: EncryptedTimeTable = timeTable_fromJs(timeTable)
		val result = timeTableApi.tryDecrypt(
			timeTableConverted,
		)
		timeTable_toJs(result)
	}

	override fun deleteTimeTable(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = timeTableApi.deleteTimeTable(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteTimeTables(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = timeTableApi.deleteTimeTables(
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
		timeTable: DecryptedTimeTableJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedTimeTableJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val timeTableConverted: DecryptedTimeTable = timeTable_fromJs(timeTable)
			val optionsConverted: TimeTableShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: TimeTableShareOptionsJs? ->
				options?.let { nonNull1 ->
					timeTableShareOptions_fromJs(nonNull1)
				}
			}
			val result = timeTableApi.shareWith(
				delegateIdConverted,
				timeTableConverted,
				optionsConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedTimeTable ->
					timeTable_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(timeTable: DecryptedTimeTableJs,
			delegates: Record<String, TimeTableShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedTimeTableJs>> = GlobalScope.promise {
		val timeTableConverted: DecryptedTimeTable = timeTable_fromJs(timeTable)
		val delegatesConverted: Map<String, TimeTableShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: TimeTableShareOptionsJs ->
				timeTableShareOptions_fromJs(x1)
			},
		)
		val result = timeTableApi.tryShareWithMany(
			timeTableConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)
	}

	override fun shareWithMany(timeTable: DecryptedTimeTableJs,
			delegates: Record<String, TimeTableShareOptionsJs>): Promise<DecryptedTimeTableJs> =
			GlobalScope.promise {
		val timeTableConverted: DecryptedTimeTable = timeTable_fromJs(timeTable)
		val delegatesConverted: Map<String, TimeTableShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: TimeTableShareOptionsJs ->
				timeTableShareOptions_fromJs(x1)
			},
		)
		val result = timeTableApi.shareWithMany(
			timeTableConverted,
			delegatesConverted,
		)
		timeTable_toJs(result)
	}

	override fun modifyTimeTable(entity: DecryptedTimeTableJs): Promise<DecryptedTimeTableJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedTimeTable = timeTable_fromJs(entity)
		val result = timeTableApi.modifyTimeTable(
			entityConverted,
		)
		timeTable_toJs(result)
	}

	override fun getTimeTable(entityId: String): Promise<DecryptedTimeTableJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = timeTableApi.getTimeTable(
			entityIdConverted,
		)
		timeTable_toJs(result)
	}

	override fun getTimeTablesByPeriodAndAgendaId(
		startDate: Double,
		endDate: Double,
		agendaId: String,
	): Promise<Array<DecryptedTimeTableJs>> = GlobalScope.promise {
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val agendaIdConverted: String = agendaId
		val result = timeTableApi.getTimeTablesByPeriodAndAgendaId(
			startDateConverted,
			endDateConverted,
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)
	}

	override fun getTimeTablesByAgendaId(agendaId: String): Promise<Array<DecryptedTimeTableJs>> =
			GlobalScope.promise {
		val agendaIdConverted: String = agendaId
		val result = timeTableApi.getTimeTablesByAgendaId(
			agendaIdConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedTimeTable ->
				timeTable_toJs(x1)
			},
		)
	}
}
