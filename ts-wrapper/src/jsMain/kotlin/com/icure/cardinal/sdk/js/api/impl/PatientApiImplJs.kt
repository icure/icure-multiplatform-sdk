// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.PatientApi
import com.icure.cardinal.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.cardinal.sdk.crypto.entities.PatientShareOptions
import com.icure.cardinal.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.api.PatientApiJs
import com.icure.cardinal.sdk.js.api.PatientFlavouredApiJs
import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.crypto.entities.EntityWithTypeInfoJs
import com.icure.cardinal.sdk.js.crypto.entities.PatientShareOptionsJs
import com.icure.cardinal.sdk.js.crypto.entities.ShareAllPatientDataOptionsJs_ResultJs
import com.icure.cardinal.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.cardinal.sdk.js.crypto.entities.patientShareOptions_fromJs
import com.icure.cardinal.sdk.js.crypto.entities.shareAllPatientDataOptions_Result_toJs
import com.icure.cardinal.sdk.js.filters.FilterOptionsJs
import com.icure.cardinal.sdk.js.filters.SortableFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.filterOptions_fromJs
import com.icure.cardinal.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.anyEntityWithTypeInfoToKt
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.intToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.DecryptedPatientJs
import com.icure.cardinal.sdk.js.model.EncryptedPatientJs
import com.icure.cardinal.sdk.js.model.IdWithMandatoryRevJs
import com.icure.cardinal.sdk.js.model.IdWithRevJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.UserJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.cardinal.sdk.js.model.idWithMandatoryRev_fromJs
import com.icure.cardinal.sdk.js.model.idWithRev_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.patient_fromJs
import com.icure.cardinal.sdk.js.model.patient_toJs
import com.icure.cardinal.sdk.js.model.specializations.hexString_toJs
import com.icure.cardinal.sdk.js.model.user_fromJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.cardinal.sdk.js.subscription.EntitySubscriptionJs
import com.icure.cardinal.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.cardinal.sdk.js.subscription.entitySubscription_toJs
import com.icure.cardinal.sdk.js.utils.Record
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.cardinal.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.cardinal.sdk.model.DecryptedPatient
import com.icure.cardinal.sdk.model.EncryptedPatient
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.IdWithRev
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.model.couchdb.SortDirection
import com.icure.cardinal.sdk.model.embed.AccessLevel
import com.icure.cardinal.sdk.model.specializations.HexString
import com.icure.cardinal.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.cardinal.sdk.subscription.SubscriptionEventType
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
internal class PatientApiImplJs(
	private val patientApi: PatientApi,
) : PatientApiJs {
	override val encrypted: PatientFlavouredApiJs<EncryptedPatientJs> = object :
			PatientFlavouredApiJs<EncryptedPatientJs> {
		override fun shareWith(
			delegateId: String,
			patient: EncryptedPatientJs,
			options: dynamic,
		): Promise<EncryptedPatientJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val patientConverted: EncryptedPatient = patient_fromJs(patient)
				val optionsConverted: PatientShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: PatientShareOptionsJs? ->
					options?.let { nonNull1 ->
						patientShareOptions_fromJs(nonNull1)
					}
				}
				val result = patientApi.encrypted.shareWith(
					delegateIdConverted,
					patientConverted,
					optionsConverted,
				)
				patient_toJs(result)
			}
		}

		override fun shareWithMany(patient: EncryptedPatientJs,
				delegates: Record<String, PatientShareOptionsJs>): Promise<EncryptedPatientJs> =
				GlobalScope.promise {
			val patientConverted: EncryptedPatient = patient_fromJs(patient)
			val delegatesConverted: Map<String, PatientShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: PatientShareOptionsJs ->
					patientShareOptions_fromJs(x1)
				},
			)
			val result = patientApi.encrypted.shareWithMany(
				patientConverted,
				delegatesConverted,
			)
			patient_toJs(result)
		}

		override fun initializeConfidentialSecretId(patient: EncryptedPatientJs):
				Promise<EncryptedPatientJs> = GlobalScope.promise {
			val patientConverted: EncryptedPatient = patient_fromJs(patient)
			val result = patientApi.encrypted.initializeConfidentialSecretId(
				patientConverted,
			)
			patient_toJs(result)
		}

		override fun filterPatientsBy(filter: FilterOptionsJs<PatientJs>):
				Promise<PaginatedListIteratorJs<EncryptedPatientJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Patient> = filterOptions_fromJs(filter)
			val result = patientApi.encrypted.filterPatientsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}

		override fun filterPatientsBySorted(filter: SortableFilterOptionsJs<PatientJs>):
				Promise<PaginatedListIteratorJs<EncryptedPatientJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Patient> = sortableFilterOptions_fromJs(filter)
			val result = patientApi.encrypted.filterPatientsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}

		override fun undeletePatient(patient: PatientJs): Promise<PatientJs> = GlobalScope.promise {
			val patientConverted: Patient = patient_fromJs(patient)
			val result = patientApi.encrypted.undeletePatient(
				patientConverted,
			)
			patient_toJs(result)
		}

		override fun modifyPatient(entity: EncryptedPatientJs): Promise<EncryptedPatientJs> =
				GlobalScope.promise {
			val entityConverted: EncryptedPatient = patient_fromJs(entity)
			val result = patientApi.encrypted.modifyPatient(
				entityConverted,
			)
			patient_toJs(result)
		}

		override fun undeletePatientById(id: String, rev: String): Promise<EncryptedPatientJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = patientApi.encrypted.undeletePatientById(
				idConverted,
				revConverted,
			)
			patient_toJs(result)
		}

		override fun undeletePatients(ids: Array<IdWithMandatoryRevJs>):
				Promise<Array<EncryptedPatientJs>> = GlobalScope.promise {
			val idsConverted: List<IdWithMandatoryRev> = arrayToList(
				ids,
				"ids",
				{ x1: IdWithMandatoryRevJs ->
					idWithMandatoryRev_fromJs(x1)
				},
			)
			val result = patientApi.encrypted.undeletePatients(
				idsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
		}

		override fun getPatient(entityId: String): Promise<EncryptedPatientJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = patientApi.encrypted.getPatient(
				entityIdConverted,
			)
			patient_toJs(result)
		}

		override fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?):
				Promise<EncryptedPatientJs> = GlobalScope.promise {
			val patientIdConverted: String = patientId
			val maxMergeDepthConverted: Int? = numberToInt(maxMergeDepth, "maxMergeDepth")
			val result = patientApi.encrypted.getPatientResolvingMerges(
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
				val result = patientApi.encrypted.findPatientsByNameBirthSsinAuto(
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
				val result = patientApi.encrypted.listPatientsOfHcParty(
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
			val result = patientApi.encrypted.listOfMergesAfter(
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
				val result = patientApi.encrypted.findPatientsModifiedAfter(
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
				val result = patientApi.encrypted.listPatientsByHcParty(
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
				val result = patientApi.encrypted.findPatientsByHealthcareParty(
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
				val result = patientApi.encrypted.findPatientsIdsByHealthcareParty(
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
			val result = patientApi.encrypted.getPatientByExternalId(
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
				val result = patientApi.encrypted.fuzzySearch(
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
				val result = patientApi.encrypted.findDeletedPatients(
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
				val result = patientApi.encrypted.listDeletedPatientsByName(
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
			val result = patientApi.encrypted.getPatients(
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
				val result = patientApi.encrypted.getPatientByHealthcarePartyAndIdentifier(
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
			val result = patientApi.encrypted.modifyPatients(
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
				val result = patientApi.encrypted.findDuplicatesBySsin(
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
				val result = patientApi.encrypted.findDuplicatesByName(
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
			val result = patientApi.encrypted.mergePatients(
				fromConverted,
				mergedIntoConverted,
			)
			patient_toJs(result)
		}
	}

	override val tryAndRecover: PatientFlavouredApiJs<PatientJs> = object :
			PatientFlavouredApiJs<PatientJs> {
		override fun shareWith(
			delegateId: String,
			patient: PatientJs,
			options: dynamic,
		): Promise<PatientJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val patientConverted: Patient = patient_fromJs(patient)
				val optionsConverted: PatientShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: PatientShareOptionsJs? ->
					options?.let { nonNull1 ->
						patientShareOptions_fromJs(nonNull1)
					}
				}
				val result = patientApi.tryAndRecover.shareWith(
					delegateIdConverted,
					patientConverted,
					optionsConverted,
				)
				patient_toJs(result)
			}
		}

		override fun shareWithMany(patient: PatientJs, delegates: Record<String, PatientShareOptionsJs>):
				Promise<PatientJs> = GlobalScope.promise {
			val patientConverted: Patient = patient_fromJs(patient)
			val delegatesConverted: Map<String, PatientShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: PatientShareOptionsJs ->
					patientShareOptions_fromJs(x1)
				},
			)
			val result = patientApi.tryAndRecover.shareWithMany(
				patientConverted,
				delegatesConverted,
			)
			patient_toJs(result)
		}

		override fun initializeConfidentialSecretId(patient: PatientJs): Promise<PatientJs> =
				GlobalScope.promise {
			val patientConverted: Patient = patient_fromJs(patient)
			val result = patientApi.tryAndRecover.initializeConfidentialSecretId(
				patientConverted,
			)
			patient_toJs(result)
		}

		override fun filterPatientsBy(filter: FilterOptionsJs<PatientJs>):
				Promise<PaginatedListIteratorJs<PatientJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<Patient> = filterOptions_fromJs(filter)
			val result = patientApi.tryAndRecover.filterPatientsBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)
		}

		override fun filterPatientsBySorted(filter: SortableFilterOptionsJs<PatientJs>):
				Promise<PaginatedListIteratorJs<PatientJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<Patient> = sortableFilterOptions_fromJs(filter)
			val result = patientApi.tryAndRecover.filterPatientsBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)
		}

		override fun undeletePatient(patient: PatientJs): Promise<PatientJs> = GlobalScope.promise {
			val patientConverted: Patient = patient_fromJs(patient)
			val result = patientApi.tryAndRecover.undeletePatient(
				patientConverted,
			)
			patient_toJs(result)
		}

		override fun modifyPatient(entity: PatientJs): Promise<PatientJs> = GlobalScope.promise {
			val entityConverted: Patient = patient_fromJs(entity)
			val result = patientApi.tryAndRecover.modifyPatient(
				entityConverted,
			)
			patient_toJs(result)
		}

		override fun undeletePatientById(id: String, rev: String): Promise<PatientJs> =
				GlobalScope.promise {
			val idConverted: String = id
			val revConverted: String = rev
			val result = patientApi.tryAndRecover.undeletePatientById(
				idConverted,
				revConverted,
			)
			patient_toJs(result)
		}

		override fun undeletePatients(ids: Array<IdWithMandatoryRevJs>): Promise<Array<PatientJs>> =
				GlobalScope.promise {
			val idsConverted: List<IdWithMandatoryRev> = arrayToList(
				ids,
				"ids",
				{ x1: IdWithMandatoryRevJs ->
					idWithMandatoryRev_fromJs(x1)
				},
			)
			val result = patientApi.tryAndRecover.undeletePatients(
				idsConverted,
			)
			listToArray(
				result,
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)
		}

		override fun getPatient(entityId: String): Promise<PatientJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = patientApi.tryAndRecover.getPatient(
				entityIdConverted,
			)
			patient_toJs(result)
		}

		override fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?):
				Promise<PatientJs> = GlobalScope.promise {
			val patientIdConverted: String = patientId
			val maxMergeDepthConverted: Int? = numberToInt(maxMergeDepth, "maxMergeDepth")
			val result = patientApi.tryAndRecover.getPatientResolvingMerges(
				patientIdConverted,
				maxMergeDepthConverted,
			)
			patient_toJs(result)
		}

		override fun findPatientsByNameBirthSsinAuto(filterValue: String, options: dynamic):
				Promise<PaginatedListJs<PatientJs>> {
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
				val result = patientApi.tryAndRecover.findPatientsByNameBirthSsinAuto(
					healthcarePartyIdConverted,
					filterValueConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					sortDirectionConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun listPatientsOfHcParty(hcPartyId: String, options: dynamic):
				Promise<PaginatedListJs<PatientJs>> {
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
				val result = patientApi.tryAndRecover.listPatientsOfHcParty(
					hcPartyIdConverted,
					sortFieldConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					sortDirectionConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun listOfMergesAfter(date: Double): Promise<Array<PatientJs>> = GlobalScope.promise {
			val dateConverted: Long = numberToLong(date, "date")
			val result = patientApi.tryAndRecover.listOfMergesAfter(
				dateConverted,
			)
			listToArray(
				result,
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)
		}

		override fun findPatientsModifiedAfter(date: Double, options: dynamic):
				Promise<PaginatedListJs<PatientJs>> {
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
				val result = patientApi.tryAndRecover.findPatientsModifiedAfter(
					dateConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun listPatientsByHcParty(hcPartyId: String, options: dynamic):
				Promise<PaginatedListJs<PatientJs>> {
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
				val result = patientApi.tryAndRecover.listPatientsByHcParty(
					hcPartyIdConverted,
					sortFieldConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					sortDirectionConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun findPatientsByHealthcareParty(options: dynamic):
				Promise<PaginatedListJs<PatientJs>> {
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
				val result = patientApi.tryAndRecover.findPatientsByHealthcareParty(
					hcPartyIdConverted,
					sortFieldConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
					sortDirectionConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Patient ->
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
				val result = patientApi.tryAndRecover.findPatientsIdsByHealthcareParty(
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

		override fun getPatientByExternalId(externalId: String): Promise<PatientJs> =
				GlobalScope.promise {
			val externalIdConverted: String = externalId
			val result = patientApi.tryAndRecover.getPatientByExternalId(
				externalIdConverted,
			)
			patient_toJs(result)
		}

		override fun fuzzySearch(
			firstName: String,
			lastName: String,
			options: dynamic,
		): Promise<Array<PatientJs>> {
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
				val result = patientApi.tryAndRecover.fuzzySearch(
					firstNameConverted,
					lastNameConverted,
					dateOfBirthConverted,
				)
				listToArray(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun findDeletedPatients(startDate: Double, options: dynamic):
				Promise<PaginatedListJs<PatientJs>> {
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
				val result = patientApi.tryAndRecover.findDeletedPatients(
					startDateConverted,
					endDateConverted,
					descConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun listDeletedPatientsByName(options: dynamic): Promise<Array<PatientJs>> {
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
				val result = patientApi.tryAndRecover.listDeletedPatientsByName(
					firstNameConverted,
					lastNameConverted,
				)
				listToArray(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun getPatients(patientIds: Array<String>): Promise<Array<PatientJs>> =
				GlobalScope.promise {
			val patientIdsConverted: List<String> = arrayToList(
				patientIds,
				"patientIds",
				{ x1: String ->
					x1
				},
			)
			val result = patientApi.tryAndRecover.getPatients(
				patientIdsConverted,
			)
			listToArray(
				result,
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)
		}

		override fun getPatientByHealthcarePartyAndIdentifier(
			hcPartyId: String,
			id: String,
			options: dynamic,
		): Promise<PatientJs> {
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
				val result = patientApi.tryAndRecover.getPatientByHealthcarePartyAndIdentifier(
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
			val result = patientApi.tryAndRecover.modifyPatients(
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
				Promise<PaginatedListJs<PatientJs>> {
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
				val result = patientApi.tryAndRecover.findDuplicatesBySsin(
					hcPartyIdConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun findDuplicatesByName(hcPartyId: String, options: dynamic):
				Promise<PaginatedListJs<PatientJs>> {
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
				val result = patientApi.tryAndRecover.findDuplicatesByName(
					hcPartyIdConverted,
					startKeyConverted,
					startDocumentIdConverted,
					limitConverted,
				)
				paginatedList_toJs(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun mergePatients(from: PatientJs, mergedInto: PatientJs): Promise<PatientJs> =
				GlobalScope.promise {
			val fromConverted: Patient = patient_fromJs(from)
			val mergedIntoConverted: Patient = patient_fromJs(mergedInto)
			val result = patientApi.tryAndRecover.mergePatients(
				fromConverted,
				mergedIntoConverted,
			)
			patient_toJs(result)
		}
	}

	override fun getSecretIdsOf(patient: PatientJs): Promise<Array<String>> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.getSecretIdsOf(
			patientConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun getEncryptionKeysOf(patient: PatientJs): Promise<Array<String>> =
			GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.getEncryptionKeysOf(
			patientConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun createPatient(patient: DecryptedPatientJs): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		val patientConverted: DecryptedPatient = patient_fromJs(patient)
		val result = patientApi.createPatient(
			patientConverted,
		)
		patient_toJs(result)
	}

	override fun withEncryptionMetadata(base: DecryptedPatientJs?, options: dynamic):
			Promise<DecryptedPatientJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedPatient? = base?.let { nonNull1 ->
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
			val result = patientApi.withEncryptionMetadata(
				baseConverted,
				userConverted,
				delegatesConverted,
			)
			patient_toJs(result)
		}
	}

	override fun hasWriteAccess(patient: PatientJs): Promise<Boolean> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.hasWriteAccess(
			patientConverted,
		)
		result
	}

	override fun createDelegationDeAnonymizationMetadata(entity: PatientJs, delegates: Array<String>):
			Promise<Unit> = GlobalScope.promise {
		val entityConverted: Patient = patient_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		patientApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(patient: EncryptedPatientJs): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		val patientConverted: EncryptedPatient = patient_fromJs(patient)
		val result = patientApi.decrypt(
			patientConverted,
		)
		patient_toJs(result)
	}

	override fun tryDecrypt(patient: EncryptedPatientJs): Promise<PatientJs> = GlobalScope.promise {
		val patientConverted: EncryptedPatient = patient_fromJs(patient)
		val result = patientApi.tryDecrypt(
			patientConverted,
		)
		patient_toJs(result)
	}

	override fun createPatients(patientDtos: Array<DecryptedPatientJs>): Promise<Array<IdWithRevJs>> =
			GlobalScope.promise {
		val patientDtosConverted: List<DecryptedPatient> = arrayToList(
			patientDtos,
			"patientDtos",
			{ x1: DecryptedPatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = patientApi.createPatients(
			patientDtosConverted,
		)
		listToArray(
			result,
			{ x1: IdWithRev ->
				idWithRev_toJs(x1)
			},
		)
	}

	override fun shareAllDataOfPatient(patientId: String,
			delegatesWithShareType: Record<String, Array<String>>):
			Promise<ShareAllPatientDataOptionsJs_ResultJs> = GlobalScope.promise {
		val patientIdConverted: String = patientId
		val delegatesWithShareTypeConverted: Map<String, Set<ShareAllPatientDataOptions.Tag>> =
				objectToMap(
			delegatesWithShareType,
			"delegatesWithShareType",
			{ x1: String ->
				x1
			},
			{ x1: Array<String> ->
				arrayToSet(
					x1,
					"x1",
					{ x2: String ->
						ShareAllPatientDataOptions.Tag.valueOf(x2)
					},
				)
			},
		)
		val result = patientApi.shareAllDataOfPatient(
			patientIdConverted,
			delegatesWithShareTypeConverted,
		)
		shareAllPatientDataOptions_Result_toJs(result)
	}

	override
			fun getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfoJs<*>):
			Promise<String> = GlobalScope.promise {
		val childDocumentConverted: EntityWithTypeInfo<*> = anyEntityWithTypeInfoToKt(childDocument)
		val result = patientApi.getPatientIdOfChildDocumentForHcpAndHcpParents(
			childDocumentConverted,
		)
		result
	}

	override fun getConfidentialSecretIdsOf(patient: PatientJs): Promise<Array<String>> =
			GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.getConfidentialSecretIdsOf(
			patientConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun forceInitializeExchangeDataToNewlyInvitedPatient(patientId: String): Promise<Boolean>
			= GlobalScope.promise {
		val patientIdConverted: String = patientId
		val result = patientApi.forceInitializeExchangeDataToNewlyInvitedPatient(
			patientIdConverted,
		)
		result
	}

	override fun matchPatientsBy(filter: FilterOptionsJs<PatientJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: FilterOptions<Patient> = filterOptions_fromJs(filter)
		val result = patientApi.matchPatientsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchPatientsBySorted(filter: SortableFilterOptionsJs<PatientJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Patient> = sortableFilterOptions_fromJs(filter)
		val result = patientApi.matchPatientsBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun ensureEncryptionMetadataForSelfIsInitialized(options: dynamic):
			Promise<EncryptedPatientJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val sharingWithConverted: Map<String, AccessLevel> = convertingOptionOrDefaultNonNull(
				_options,
				"sharingWith",
				emptyMap()
			) { sharingWith: Record<String, String> ->
				objectToMap(
					sharingWith,
					"sharingWith",
					{ x1: String ->
						x1
					},
					{ x1: String ->
						AccessLevel.valueOf(x1)
					},
				)
			}
			val result = patientApi.ensureEncryptionMetadataForSelfIsInitialized(
				sharingWithConverted,
			)
			patient_toJs(result)
		}
	}

	override fun deletePatient(entityId: String): Promise<DocIdentifierJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = patientApi.deletePatient(
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
		val result = patientApi.deletePatients(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun deletePatientById(entityId: String, rev: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val revConverted: String = rev
		val result = patientApi.deletePatientById(
			entityIdConverted,
			revConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deletePatientsByIds(entityIds: Array<IdWithMandatoryRevJs>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityIdsConverted: List<IdWithMandatoryRev> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = patientApi.deletePatientsByIds(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgePatientById(id: String, rev: String): Promise<Unit> = GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		patientApi.purgePatientById(
			idConverted,
			revConverted,
		)

	}

	override fun deletePatient(patient: PatientJs): Promise<DocIdentifierJs> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.deletePatient(
			patientConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deletePatients(patients: Array<PatientJs>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val patientsConverted: List<Patient> = arrayToList(
			patients,
			"patients",
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
		val result = patientApi.deletePatients(
			patientsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun purgePatient(patient: PatientJs): Promise<Unit> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		patientApi.purgePatient(
			patientConverted,
		)

	}

	override fun getDataOwnersWithAccessTo(patient: PatientJs): Promise<EntityAccessInformationJs> =
			GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.getDataOwnersWithAccessTo(
			patientConverted,
		)
		entityAccessInformation_toJs(result)
	}

	override fun countOfPatients(hcPartyId: String): Promise<Double> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val result = patientApi.countOfPatients(
			hcPartyIdConverted,
		)
		intToNumber(result)
	}

	override fun shareWith(
		delegateId: String,
		patient: DecryptedPatientJs,
		options: dynamic,
	): Promise<DecryptedPatientJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val patientConverted: DecryptedPatient = patient_fromJs(patient)
			val optionsConverted: PatientShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: PatientShareOptionsJs? ->
				options?.let { nonNull1 ->
					patientShareOptions_fromJs(nonNull1)
				}
			}
			val result = patientApi.shareWith(
				delegateIdConverted,
				patientConverted,
				optionsConverted,
			)
			patient_toJs(result)
		}
	}

	override fun shareWithMany(patient: DecryptedPatientJs,
			delegates: Record<String, PatientShareOptionsJs>): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		val patientConverted: DecryptedPatient = patient_fromJs(patient)
		val delegatesConverted: Map<String, PatientShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: PatientShareOptionsJs ->
				patientShareOptions_fromJs(x1)
			},
		)
		val result = patientApi.shareWithMany(
			patientConverted,
			delegatesConverted,
		)
		patient_toJs(result)
	}

	override fun initializeConfidentialSecretId(patient: DecryptedPatientJs):
			Promise<DecryptedPatientJs> = GlobalScope.promise {
		val patientConverted: DecryptedPatient = patient_fromJs(patient)
		val result = patientApi.initializeConfidentialSecretId(
			patientConverted,
		)
		patient_toJs(result)
	}

	override fun filterPatientsBy(filter: FilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<DecryptedPatientJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<Patient> = filterOptions_fromJs(filter)
		val result = patientApi.filterPatientsBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun filterPatientsBySorted(filter: SortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<DecryptedPatientJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<Patient> = sortableFilterOptions_fromJs(filter)
		val result = patientApi.filterPatientsBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun undeletePatient(patient: PatientJs): Promise<PatientJs> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.undeletePatient(
			patientConverted,
		)
		patient_toJs(result)
	}

	override fun modifyPatient(entity: DecryptedPatientJs): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		val entityConverted: DecryptedPatient = patient_fromJs(entity)
		val result = patientApi.modifyPatient(
			entityConverted,
		)
		patient_toJs(result)
	}

	override fun undeletePatientById(id: String, rev: String): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		val idConverted: String = id
		val revConverted: String = rev
		val result = patientApi.undeletePatientById(
			idConverted,
			revConverted,
		)
		patient_toJs(result)
	}

	override fun undeletePatients(ids: Array<IdWithMandatoryRevJs>): Promise<Array<DecryptedPatientJs>>
			= GlobalScope.promise {
		val idsConverted: List<IdWithMandatoryRev> = arrayToList(
			ids,
			"ids",
			{ x1: IdWithMandatoryRevJs ->
				idWithMandatoryRev_fromJs(x1)
			},
		)
		val result = patientApi.undeletePatients(
			idsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun getPatient(entityId: String): Promise<DecryptedPatientJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = patientApi.getPatient(
			entityIdConverted,
		)
		patient_toJs(result)
	}

	override fun getPatientResolvingMerges(patientId: String, maxMergeDepth: Double?):
			Promise<DecryptedPatientJs> = GlobalScope.promise {
		val patientIdConverted: String = patientId
		val maxMergeDepthConverted: Int? = numberToInt(maxMergeDepth, "maxMergeDepth")
		val result = patientApi.getPatientResolvingMerges(
			patientIdConverted,
			maxMergeDepthConverted,
		)
		patient_toJs(result)
	}

	override fun findPatientsByNameBirthSsinAuto(filterValue: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>> {
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
			val result = patientApi.findPatientsByNameBirthSsinAuto(
				healthcarePartyIdConverted,
				filterValueConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				sortDirectionConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun listPatientsOfHcParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>> {
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
			val result = patientApi.listPatientsOfHcParty(
				hcPartyIdConverted,
				sortFieldConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				sortDirectionConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun listOfMergesAfter(date: Double): Promise<Array<DecryptedPatientJs>> =
			GlobalScope.promise {
		val dateConverted: Long = numberToLong(date, "date")
		val result = patientApi.listOfMergesAfter(
			dateConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun findPatientsModifiedAfter(date: Double, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>> {
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
			val result = patientApi.findPatientsModifiedAfter(
				dateConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun listPatientsByHcParty(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>> {
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
			val result = patientApi.listPatientsByHcParty(
				hcPartyIdConverted,
				sortFieldConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				sortDirectionConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun findPatientsByHealthcareParty(options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>> {
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
			val result = patientApi.findPatientsByHealthcareParty(
				hcPartyIdConverted,
				sortFieldConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
				sortDirectionConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedPatient ->
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
			val result = patientApi.findPatientsIdsByHealthcareParty(
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

	override fun getPatientByExternalId(externalId: String): Promise<DecryptedPatientJs> =
			GlobalScope.promise {
		val externalIdConverted: String = externalId
		val result = patientApi.getPatientByExternalId(
			externalIdConverted,
		)
		patient_toJs(result)
	}

	override fun fuzzySearch(
		firstName: String,
		lastName: String,
		options: dynamic,
	): Promise<Array<DecryptedPatientJs>> {
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
			val result = patientApi.fuzzySearch(
				firstNameConverted,
				lastNameConverted,
				dateOfBirthConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun findDeletedPatients(startDate: Double, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>> {
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
			val result = patientApi.findDeletedPatients(
				startDateConverted,
				endDateConverted,
				descConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun listDeletedPatientsByName(options: dynamic): Promise<Array<DecryptedPatientJs>> {
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
			val result = patientApi.listDeletedPatientsByName(
				firstNameConverted,
				lastNameConverted,
			)
			listToArray(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun getPatients(patientIds: Array<String>): Promise<Array<DecryptedPatientJs>> =
			GlobalScope.promise {
		val patientIdsConverted: List<String> = arrayToList(
			patientIds,
			"patientIds",
			{ x1: String ->
				x1
			},
		)
		val result = patientApi.getPatients(
			patientIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)
	}

	override fun getPatientByHealthcarePartyAndIdentifier(
		hcPartyId: String,
		id: String,
		options: dynamic,
	): Promise<DecryptedPatientJs> {
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
			val result = patientApi.getPatientByHealthcarePartyAndIdentifier(
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
		val result = patientApi.modifyPatients(
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
			Promise<PaginatedListJs<DecryptedPatientJs>> {
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
			val result = patientApi.findDuplicatesBySsin(
				hcPartyIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun findDuplicatesByName(hcPartyId: String, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>> {
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
			val result = patientApi.findDuplicatesByName(
				hcPartyIdConverted,
				startKeyConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun mergePatients(from: PatientJs, mergedInto: DecryptedPatientJs):
			Promise<DecryptedPatientJs> = GlobalScope.promise {
		val fromConverted: Patient = patient_fromJs(from)
		val mergedIntoConverted: DecryptedPatient = patient_fromJs(mergedInto)
		val result = patientApi.mergePatients(
			fromConverted,
			mergedIntoConverted,
		)
		patient_toJs(result)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<PatientJs>,
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
			val filterConverted: FilterOptions<Patient> = filterOptions_fromJs(filter)
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
			val result = patientApi.subscribeToEvents(
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
