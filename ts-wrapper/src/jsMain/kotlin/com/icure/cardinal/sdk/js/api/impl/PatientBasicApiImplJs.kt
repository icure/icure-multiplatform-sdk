// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.PatientBasicApi
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.PatientBasicApiJs
import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.baseFilterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.baseSortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.EncryptedPatientJs
import com.icure.cardinal.sdk.js.model.IdWithRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.idWithRev_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.patient_toJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.SortDirection
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PatientBasicApiImplJs(
	private val patientBasicApi: PatientBasicApi,
) : PatientBasicApiJs {
	override fun matchPatientsBy(filter: BaseFilterOptionsJs<PatientJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Patient> = baseFilterOptions_fromJs(filter)
		val result = patientBasicApi.matchPatientsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchPatientsBySorted(filter: BaseSortableFilterOptionsJs<PatientJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Patient> = baseSortableFilterOptions_fromJs(filter)
		val result = patientBasicApi.matchPatientsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun filterPatientsBy(filter: BaseFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<EncryptedPatientJs>> = GlobalScope.promise {
		val filterConverted: BaseFilterOptions<Patient> = baseFilterOptions_fromJs(filter)
		val result = patientBasicApi.filterPatientsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun filterPatientsBySorted(filter: BaseSortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<EncryptedPatientJs>> = GlobalScope.promise {
		val filterConverted: BaseSortableFilterOptions<Patient> = baseSortableFilterOptions_fromJs(filter)
		val result = patientBasicApi.filterPatientsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun deletePatient(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = patientBasicApi.deletePatient(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deletePatients(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = patientBasicApi.deletePatients(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun undeletePatients(patientIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val patientIdsConverted: List<String> = arrayToList(
			patientIds,
			"patientIds",
			{ x1: String ->
				x1
			},
		)
		val result = patientBasicApi.undeletePatients(
			patientIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs> =
			GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientBasicApi.getDataOwnersWithAccessTo(
			patientConverted,
		)
		entityAccessInformation_toJs(result)
	}

	override fun countOfPatients(hcPartyId: String): Promise<Double> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val result = patientBasicApi.countOfPatients(
			hcPartyIdConverted,
		)
		intToNumber(result)
	}

	override fun modifyPatient(entity: EncryptedPatientJs): Promise<EncryptedPatientJs> =
			GlobalScope.promise {
		val entityConverted: EncryptedPatient = patient_fromJs(entity)
		val result = patientBasicApi.modifyPatient(
			entityConverted,
		)
		patient_toJs(result)
	}

	override fun getPatient(entityId: String): Promise<EncryptedPatientJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = patientBasicApi.getPatient(
			entityIdConverted,
		)
		patient_toJs(result)
	}

	override fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?):
			Promise<EncryptedPatientJs> = GlobalScope.promise {
		val patientIdConverted: String = patientId
		val maxMergeDepthConverted: Int? = numberToInt(maxMergeDepth, "maxMergeDepth")
		val result = patientBasicApi.getPatientResolvingMerges(
			patientIdConverted,
			maxMergeDepthConverted,
		)
		patient_toJs(result)
	}

	override fun findPatientsByNameBirthSsinAuto(filterValue: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val healthcarePartyIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"healthcarePartyId",
				null
			) { healthcarePartyId: String? ->
				undefinedToNull(healthcarePartyId)
			}
			val filterValueConverted: String = filterValue
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val sortDirectionConverted: SortDirection = convertingOptionOrDefaultNonNull(
				_options,
				"sortDirection",
				com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc
			) { sortDirection: String ->
				SortDirection.valueOf(sortDirection)
			}
			val result = patientBasicApi.findPatientsByNameBirthSsinAuto(
				healthcarePartyIdConverted,
				filterValueConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				sortDirectionConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun listPatientsOfHcParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sortFieldConverted: String = convertingOptionOrDefaultNonNull(
				_options,
				"sortField",
				"name"
			) { sortField: String ->
				sortField
			}
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val sortDirectionConverted: SortDirection = convertingOptionOrDefaultNonNull(
				_options,
				"sortDirection",
				com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc
			) { sortDirection: String ->
				SortDirection.valueOf(sortDirection)
			}
			val result = patientBasicApi.listPatientsOfHcParty(
				hcPartyIdConverted,
				sortFieldConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				sortDirectionConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun listOfMergesAfter(date: Double): Promise<Array<EncryptedPatientJs>> =
			GlobalScope.promise {
		val dateConverted: Long = numberToLong(date, "date")
		val result = patientBasicApi.listOfMergesAfter(
			dateConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun findPatientsModifiedAfter(date: Double, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val dateConverted: Long = numberToLong(date, "date")
			val startKeyConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: Double? ->
				numberToLong(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = patientBasicApi.findPatientsModifiedAfter(
				dateConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun listPatientsByHcParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sortFieldConverted: String = convertingOptionOrDefaultNonNull(
				_options,
				"sortField",
				"name"
			) { sortField: String ->
				sortField
			}
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val sortDirectionConverted: SortDirection = convertingOptionOrDefaultNonNull(
				_options,
				"sortDirection",
				com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc
			) { sortDirection: String ->
				SortDirection.valueOf(sortDirection)
			}
			val result = patientBasicApi.listPatientsByHcParty(
				hcPartyIdConverted,
				sortFieldConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				sortDirectionConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun findPatientsByHealthcareParty(options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"hcPartyId",
				null
			) { hcPartyId: String? ->
				undefinedToNull(hcPartyId)
			}
			val sortFieldConverted: String = convertingOptionOrDefaultNonNull(
				_options,
				"sortField",
				"name"
			) { sortField: String ->
				sortField
			}
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val sortDirectionConverted: SortDirection = convertingOptionOrDefaultNonNull(
				_options,
				"sortDirection",
				com.icure.cardinal.sdk.model.couchdb.SortDirection.Asc
			) { sortDirection: String ->
				SortDirection.valueOf(sortDirection)
			}
			val result = patientBasicApi.findPatientsByHealthcareParty(
				hcPartyIdConverted,
				sortFieldConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				sortDirectionConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun findPatientsIdsByHealthcareParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<String>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = patientBasicApi.findPatientsIdsByHealthcareParty(
				hcPartyIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: String ->
					x1
				},
			)
		}
	}

	override fun getPatientByExternalId(externalId: String): Promise<EncryptedPatientJs> =
			GlobalScope.promise {
		val externalIdConverted: String = externalId
		val result = patientBasicApi.getPatientByExternalId(
			externalIdConverted,
		)
		patient_toJs(result)
	}

	override fun fuzzySearch(
		firstName: String,
		lastName: String,
		options: dynamic,
	): Promise<Array<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val firstNameConverted: String = firstName
			val lastNameConverted: String = lastName
			val dateOfBirthConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"dateOfBirth",
				null
			) { dateOfBirth: Double? ->
				numberToInt(dateOfBirth, "dateOfBirth")
			}
			val result = patientBasicApi.fuzzySearch(
				firstNameConverted,
				lastNameConverted,
				dateOfBirthConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun findDeletedPatients(startDate: Double, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"endDate",
				null
			) { endDate: Double? ->
				numberToLong(endDate, "endDate")
			}
			val descConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"desc",
				null
			) { desc: Boolean? ->
				undefinedToNull(desc)
			}
			val startKeyConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: Double? ->
				numberToLong(startKey, "startKey")
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = patientBasicApi.findDeletedPatients(
				startDateConverted,
				endDateConverted,
				descConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun listDeletedPatientsByName(options: dynamic): Promise<Array<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val firstNameConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"firstName",
				null
			) { firstName: String? ->
				undefinedToNull(firstName)
			}
			val lastNameConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"lastName",
				null
			) { lastName: String? ->
				undefinedToNull(lastName)
			}
			val result = patientBasicApi.listDeletedPatientsByName(
				firstNameConverted,
				lastNameConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun getPatients(patientIds: Array<String>): Promise<Array<EncryptedPatientJs>> =
			GlobalScope.promise {
		val patientIdsConverted: List<String> = arrayToList(
			patientIds,
			"patientIds",
			{ x1: String ->
				x1
			},
		)
		val result = patientBasicApi.getPatients(
			patientIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		options: dynamic,
	): Promise<EncryptedPatientJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val idConverted: String = id
			val systemConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"system",
				null
			) { system: String? ->
				undefinedToNull(system)
			}
			val result = patientBasicApi.getPatientByHealthcarePartyAndIdentifier(
				hcPartyIdConverted,
				idConverted,
				systemConverted,
			)
			patient_toJs(result)
		}
	}

	override fun modifyPatients(patientDtos: Array<EncryptedPatientJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		val patientDtosConverted: List<EncryptedPatient> = arrayToList(
			patientDtos,
			"patientDtos",
			{ x1: EncryptedPatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = patientBasicApi.modifyPatients(
			patientDtosConverted,
		)
		listToArray(
			result,
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)
	}

	override fun findDuplicatesBySsin(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = patientBasicApi.findDuplicatesBySsin(
				hcPartyIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun findDuplicatesByName(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val startKeyConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startKey",
				null
			) { startKey: String? ->
				undefinedToNull(startKey)
			}
			val startDocumentIdConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"startDocumentId",
				null
			) { startDocumentId: String? ->
				undefinedToNull(startDocumentId)
			}
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = patientBasicApi.findDuplicatesByName(
				hcPartyIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun mergePatients(from: PatientJs, mergedInto: EncryptedPatientJs):
			Promise<EncryptedPatientJs> = GlobalScope.promise {
		val fromConverted: Patient = patient_fromJs(from)
		val mergedIntoConverted: EncryptedPatient = patient_fromJs(mergedInto)
		val result = patientBasicApi.mergePatients(
			fromConverted,
			mergedIntoConverted,
		)
		patient_toJs(result)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: BaseFilterOptionsJs<PatientJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: BaseFilterOptions<Patient> = baseFilterOptions_fromJs(filter)
			val subscriptionConfigConverted: EntitySubscriptionConfiguration? =
					convertingOptionOrDefaultNullable(
				_options,
				"subscriptionConfig",
				null
			) { subscriptionConfig: EntitySubscriptionConfigurationJs? ->
				subscriptionConfig?.let { nonNull1 ->
					entitySubscriptionConfiguration_fromJs(nonNull1)
				}
			}
			val result = patientBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}
}
