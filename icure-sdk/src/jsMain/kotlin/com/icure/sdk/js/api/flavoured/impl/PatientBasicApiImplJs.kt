// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.PatientBasicApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.PatientBasicApiJs
import com.icure.sdk.js.api.flavoured.PatientBasicApi_filterPatientsBy_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_findDeletedPatients_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_findDuplicatesByName_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_findDuplicatesBySsin_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_findPatientsByHealthcareParty_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_findPatientsByNameBirthSsinAuto_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_findPatientsIdsByHealthcareParty_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_findPatientsModifiedAfter_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_fuzzySearch_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_getPatientByHealthcarePartyAndIdentifier_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_listDeletedPatientsByName_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_listPatientsByHcParty_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_listPatientsOfHcParty_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_modifyPatientReferral_Options
import com.icure.sdk.js.api.flavoured.PatientBasicApi_subscribeToEvents_Options
import com.icure.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToDuration
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.embed.EncryptedContentJs
import com.icure.sdk.js.model.embed.content_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.idWithRev_toJs
import com.icure.sdk.js.model.listOfIds_fromJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.patient_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.Set
import kotlin.js.Promise
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class PatientBasicApiImplJs(
	private val patientBasicApi: PatientBasicApi,
) : PatientBasicApiJs {
	override fun matchPatientsBy(filter: AbstractFilterJs<PatientJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Patient> = abstractFilter_fromJs(
			filter,
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
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

	override fun undeletePatient(patientIds: String): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val patientIdsConverted: String = patientIds
		val result = patientBasicApi.undeletePatient(
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

	override fun filterPatientsBy(filterChain: FilterChainJs<PatientJs>,
			options: PatientBasicApi_filterPatientsBy_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val filterChainConverted: FilterChain<Patient> = filterChain_fromJs(
				filterChain,
				{ x1: PatientJs ->
					patient_fromJs(x1)
				},
			)
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
			val skipConverted: Int? = convertingOptionOrDefault(
				_options.skip,
				null
			) { skip ->
				numberToInt(skip, "skip")
			}
			val sortConverted: String? = convertingOptionOrDefault(
				_options.sort,
				null
			) { sort ->
				sort
			}
			val descConverted: Boolean? = convertingOptionOrDefault(
				_options.desc,
				null
			) { desc ->
				desc
			}
			val result = patientBasicApi.filterPatientsBy(
				filterChainConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				skipConverted,
				sortConverted,
				descConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun findPatientsByNameBirthSsinAuto(filterValue: String,
			options: PatientBasicApi_findPatientsByNameBirthSsinAuto_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val healthcarePartyIdConverted: String? = convertingOptionOrDefault(
				_options.healthcarePartyId,
				null
			) { healthcarePartyId ->
				healthcarePartyId
			}
			val filterValueConverted: String = filterValue
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
			val sortDirectionConverted: SortDirection = convertingOptionOrDefault(
				_options.sortDirection,
				com.icure.sdk.model.couchdb.SortDirection.Asc
			) { sortDirection ->
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

	override fun listPatientsOfHcParty(hcPartyId: String,
			options: PatientBasicApi_listPatientsOfHcParty_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sortFieldConverted: String = convertingOptionOrDefault(
				_options.sortField,
				"name"
			) { sortField ->
				sortField
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
			val sortDirectionConverted: SortDirection = convertingOptionOrDefault(
				_options.sortDirection,
				com.icure.sdk.model.couchdb.SortDirection.Asc
			) { sortDirection ->
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

	override fun findPatientsModifiedAfter(date: Double,
			options: PatientBasicApi_findPatientsModifiedAfter_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val dateConverted: Long = numberToLong(date, "date")
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

	override fun listPatientsByHcParty(hcPartyId: String,
			options: PatientBasicApi_listPatientsByHcParty_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val sortFieldConverted: String = convertingOptionOrDefault(
				_options.sortField,
				"name"
			) { sortField ->
				sortField
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
			val sortDirectionConverted: SortDirection = convertingOptionOrDefault(
				_options.sortDirection,
				com.icure.sdk.model.couchdb.SortDirection.Asc
			) { sortDirection ->
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

	override fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<Record<String, String>> =
			GlobalScope.promise {
		val patientIdConverted: String = patientId
		val result = patientBasicApi.getPatientHcPartyKeysForDelegate(
			patientIdConverted,
		)
		mapToObject(
			result,
			{ x1: String ->
				x1
			},
			{ x1: String ->
				x1
			},
		)
	}

	override fun countOfPatients(hcPartyId: String): Promise<EncryptedContentJs> =
			GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val result = patientBasicApi.countOfPatients(
			hcPartyIdConverted,
		)
		content_toJs(result)
	}

	override
			fun findPatientsByHealthcareParty(options: PatientBasicApi_findPatientsByHealthcareParty_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String? = convertingOptionOrDefault(
				_options.hcPartyId,
				null
			) { hcPartyId ->
				hcPartyId
			}
			val sortFieldConverted: String = convertingOptionOrDefault(
				_options.sortField,
				"name"
			) { sortField ->
				sortField
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
			val sortDirectionConverted: SortDirection = convertingOptionOrDefault(
				_options.sortDirection,
				com.icure.sdk.model.couchdb.SortDirection.Asc
			) { sortDirection ->
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

	override fun findPatientsIdsByHealthcareParty(hcPartyId: String,
			options: PatientBasicApi_findPatientsIdsByHealthcareParty_Options?):
			Promise<PaginatedListJs<String>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
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
		options: PatientBasicApi_fuzzySearch_Options?,
	): Promise<Array<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val firstNameConverted: String = firstName
			val lastNameConverted: String = lastName
			val dateOfBirthConverted: Int? = convertingOptionOrDefault(
				_options.dateOfBirth,
				null
			) { dateOfBirth ->
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

	override fun findDeletedPatients(startDate: Double,
			options: PatientBasicApi_findDeletedPatients_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long? = convertingOptionOrDefault(
				_options.endDate,
				null
			) { endDate ->
				numberToLong(endDate, "endDate")
			}
			val descConverted: Boolean? = convertingOptionOrDefault(
				_options.desc,
				null
			) { desc ->
				desc
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

	override
			fun listDeletedPatientsByName(options: PatientBasicApi_listDeletedPatientsByName_Options?):
			Promise<Array<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val firstNameConverted: String? = convertingOptionOrDefault(
				_options.firstName,
				null
			) { firstName ->
				firstName
			}
			val lastNameConverted: String? = convertingOptionOrDefault(
				_options.lastName,
				null
			) { lastName ->
				lastName
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

	override fun getPatients(patientIds: ListOfIdsJs): Promise<Array<EncryptedPatientJs>> =
			GlobalScope.promise {
		val patientIdsConverted: ListOfIds = listOfIds_fromJs(patientIds)
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
		options: PatientBasicApi_getPatientByHealthcarePartyAndIdentifier_Options?,
	): Promise<EncryptedPatientJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val idConverted: String = id
			val systemConverted: String? = convertingOptionOrDefault(
				_options.system,
				null
			) { system ->
				system
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

	override fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		options: PatientBasicApi_modifyPatientReferral_Options?,
	): Promise<EncryptedPatientJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val patientIdConverted: String = patientId
			val referralIdConverted: String = referralId
			val startConverted: Long? = convertingOptionOrDefault(
				_options.start,
				null
			) { start ->
				numberToLong(start, "start")
			}
			val endConverted: Long? = convertingOptionOrDefault(
				_options.end,
				null
			) { end ->
				numberToLong(end, "end")
			}
			val result = patientBasicApi.modifyPatientReferral(
				patientIdConverted,
				referralIdConverted,
				startConverted,
				endConverted,
			)
			patient_toJs(result)
		}
	}

	override fun findDuplicatesBySsin(hcPartyId: String,
			options: PatientBasicApi_findDuplicatesBySsin_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
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

	override fun findDuplicatesByName(hcPartyId: String,
			options: PatientBasicApi_findDuplicatesByName_Options?):
			Promise<PaginatedListJs<EncryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
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

	override fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<EncryptedPatientJs> = GlobalScope.promise {
		val intoIdConverted: String = intoId
		val fromIdConverted: String = fromId
		val expectedFromRevConverted: String = expectedFromRev
		val updatedIntoConverted: EncryptedPatient = patient_fromJs(updatedInto)
		val result = patientBasicApi.mergePatients(
			intoIdConverted,
			fromIdConverted,
			expectedFromRevConverted,
			updatedIntoConverted,
		)
		patient_toJs(result)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<PatientJs>,
		eventFired: (EncryptedPatientJs) -> Promise<Unit>,
		options: PatientBasicApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: AbstractFilter<Patient> = abstractFilter_fromJs(
				filter,
				{ x1: PatientJs ->
					patient_fromJs(x1)
				},
			)
			val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefault(
				_options.onConnected,
				{}
			) { onConnected ->
				{  ->
					onConnected().await()
				}
			}
			val channelCapacityConverted: Int = convertingOptionOrDefault(
				_options.channelCapacity,
				kotlinx.coroutines.channels.Channel.BUFFERED
			) { channelCapacity ->
				numberToInt(channelCapacity, "channelCapacity")
			}
			val retryDelayConverted: Duration = convertingOptionOrDefault(
				_options.retryDelay,
				2.seconds
			) { retryDelay ->
				numberToDuration(retryDelay, "retryDelay")
			}
			val retryDelayExponentFactorConverted: Double = convertingOptionOrDefault(
				_options.retryDelayExponentFactor,
				2.0
			) { retryDelayExponentFactor ->
				retryDelayExponentFactor
			}
			val maxRetriesConverted: Int = convertingOptionOrDefault(
				_options.maxRetries,
				5
			) { maxRetries ->
				numberToInt(maxRetries, "maxRetries")
			}
			val eventFiredConverted: suspend (EncryptedPatient) -> Unit = { arg0 ->
				eventFired(
					patient_toJs(arg0),
				).await()
			}
			val result = patientBasicApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				onConnectedConverted,
				channelCapacityConverted,
				retryDelayConverted,
				retryDelayExponentFactorConverted,
				maxRetriesConverted,
				eventFiredConverted,
			)
			connection_toJs(result)
		}
	}
}
