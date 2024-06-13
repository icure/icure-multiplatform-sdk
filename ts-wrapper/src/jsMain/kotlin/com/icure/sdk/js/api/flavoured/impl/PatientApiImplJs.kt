// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.PatientApi
import com.icure.sdk.crypto.entities.EntityWithTypeInfo
import com.icure.sdk.crypto.entities.PatientShareOptions
import com.icure.sdk.crypto.entities.ShareAllPatientDataOptions
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.PatientApiJs
import com.icure.sdk.js.api.flavoured.PatientFlavouredApiJs
import com.icure.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.sdk.js.crypto.entities.EntityWithTypeInfoJs
import com.icure.sdk.js.crypto.entities.PatientShareOptionsJs
import com.icure.sdk.js.crypto.entities.ShareAllPatientDataOptionsJs_ResultJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.entityAccessInformation_toJs
import com.icure.sdk.js.crypto.entities.patientShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.shareAllPatientDataOptions_Result_toJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.anyEntityWithTypeInfoToKt
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.numberToDuration
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.sdk.js.model.DecryptedPatientJs
import com.icure.sdk.js.model.EncryptedPatientJs
import com.icure.sdk.js.model.IdWithRevJs
import com.icure.sdk.js.model.ListOfIdsJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.dataOwnerRegistrationSuccess_toJs
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
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.DecryptedPatient
import com.icure.sdk.model.EncryptedPatient
import com.icure.sdk.model.IdWithRev
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.couchdb.SortDirection
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.notification.SubscriptionEventType
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
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
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
			shareSecretIds: Array<String>,
			options: dynamic,
		): Promise<SimpleShareResultJs<EncryptedPatientJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val patientConverted: EncryptedPatient = patient_fromJs(patient)
				val shareSecretIdsConverted: Set<String> = arrayToSet(
					shareSecretIds,
					"shareSecretIds",
					{ x1: String ->
						x1
					},
				)
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
				val result = patientApi.encrypted.shareWith(
					delegateIdConverted,
					patientConverted,
					shareSecretIdsConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedPatient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(patient: EncryptedPatientJs,
				delegates: Record<String, PatientShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedPatientJs>> = GlobalScope.promise {
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
			val result = patientApi.encrypted.tryShareWithMany(
				patientConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedPatient ->
					patient_toJs(x1)
				},
			)
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

		override fun initialiseConfidentialSecretId(patient: EncryptedPatientJs):
				Promise<EncryptedPatientJs> = GlobalScope.promise {
			val patientConverted: EncryptedPatient = patient_fromJs(patient)
			val result = patientApi.encrypted.initialiseConfidentialSecretId(
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

		override fun getPatient(entityId: String): Promise<EncryptedPatientJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = patientApi.encrypted.getPatient(
				entityIdConverted,
			)
			patient_toJs(result)
		}

		override fun filterPatientsBy(filterChain: FilterChainJs<PatientJs>, options: dynamic):
				Promise<PaginatedListJs<EncryptedPatientJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val filterChainConverted: FilterChain<Patient> = filterChain_fromJs(
					filterChain,
					{ x1: PatientJs ->
						patient_fromJs(x1)
					},
				)
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
				val skipConverted: Int? = convertingOptionOrDefaultNullable(
					_options,
					"skip",
					null
				) { skip: Double? ->
					numberToInt(skip, "skip")
				}
				val sortConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"sort",
					null
				) { sort: String? ->
					undefinedToNull(sort)
				}
				val descConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"desc",
					null
				) { desc: Boolean? ->
					undefinedToNull(desc)
				}
				val result = patientApi.encrypted.filterPatientsBy(
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
					com.icure.sdk.model.couchdb.SortDirection.Asc
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
					com.icure.sdk.model.couchdb.SortDirection.Asc
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
					com.icure.sdk.model.couchdb.SortDirection.Asc
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

		override fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<Record<String, String>>
				= GlobalScope.promise {
			val patientIdConverted: String = patientId
			val result = patientApi.encrypted.getPatientHcPartyKeysForDelegate(
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
			val result = patientApi.encrypted.countOfPatients(
				hcPartyIdConverted,
			)
			content_toJs(result)
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
					com.icure.sdk.model.couchdb.SortDirection.Asc
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

		override fun getPatients(patientIds: ListOfIdsJs): Promise<Array<EncryptedPatientJs>> =
				GlobalScope.promise {
			val patientIdsConverted: ListOfIds = listOfIds_fromJs(patientIds)
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

		override fun modifyPatientReferral(
			patientId: String,
			referralId: String,
			options: dynamic,
		): Promise<EncryptedPatientJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val patientIdConverted: String = patientId
				val referralIdConverted: String = referralId
				val startConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"start",
					null
				) { start: Double? ->
					numberToLong(start, "start")
				}
				val endConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"end",
					null
				) { end: Double? ->
					numberToLong(end, "end")
				}
				val result = patientApi.encrypted.modifyPatientReferral(
					patientIdConverted,
					referralIdConverted,
					startConverted,
					endConverted,
				)
				patient_toJs(result)
			}
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
			val result = patientApi.encrypted.mergePatients(
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
			options: dynamic,
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
				val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefaultNonNull(
					_options,
					"onConnected",
					{}
				) { onConnected: () -> Promise<Unit> ->
					{  ->
						onConnected().await()
					}
				}
				val channelCapacityConverted: Int = convertingOptionOrDefaultNonNull(
					_options,
					"channelCapacity",
					kotlinx.coroutines.channels.Channel.BUFFERED
				) { channelCapacity: Double ->
					numberToInt(channelCapacity, "channelCapacity")
				}
				val retryDelayConverted: Duration = convertingOptionOrDefaultNonNull(
					_options,
					"retryDelay",
					2.seconds
				) { retryDelay: Double ->
					numberToDuration(retryDelay, "retryDelay")
				}
				val retryDelayExponentFactorConverted: Double = convertingOptionOrDefaultNonNull(
					_options,
					"retryDelayExponentFactor",
					2.0
				) { retryDelayExponentFactor: Double ->
					retryDelayExponentFactor
				}
				val maxRetriesConverted: Int = convertingOptionOrDefaultNonNull(
					_options,
					"maxRetries",
					5
				) { maxRetries: Double ->
					numberToInt(maxRetries, "maxRetries")
				}
				val eventFiredConverted: suspend (EncryptedPatient) -> Unit = { arg0 ->
					eventFired(
						patient_toJs(arg0),
					).await()
				}
				val result = patientApi.encrypted.subscribeToEvents(
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

	override val tryAndRecover: PatientFlavouredApiJs<PatientJs> = object :
			PatientFlavouredApiJs<PatientJs> {
		override fun shareWith(
			delegateId: String,
			patient: PatientJs,
			shareSecretIds: Array<String>,
			options: dynamic,
		): Promise<SimpleShareResultJs<PatientJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val patientConverted: Patient = patient_fromJs(patient)
				val shareSecretIdsConverted: Set<String> = arrayToSet(
					shareSecretIds,
					"shareSecretIds",
					{ x1: String ->
						x1
					},
				)
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
				val result = patientApi.tryAndRecover.shareWith(
					delegateIdConverted,
					patientConverted,
					shareSecretIdsConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(patient: PatientJs,
				delegates: Record<String, PatientShareOptionsJs>): Promise<SimpleShareResultJs<PatientJs>> =
				GlobalScope.promise {
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
			val result = patientApi.tryAndRecover.tryShareWithMany(
				patientConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: Patient ->
					patient_toJs(x1)
				},
			)
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

		override fun initialiseConfidentialSecretId(patient: PatientJs): Promise<PatientJs> =
				GlobalScope.promise {
			val patientConverted: Patient = patient_fromJs(patient)
			val result = patientApi.tryAndRecover.initialiseConfidentialSecretId(
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

		override fun getPatient(entityId: String): Promise<PatientJs> = GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = patientApi.tryAndRecover.getPatient(
				entityIdConverted,
			)
			patient_toJs(result)
		}

		override fun filterPatientsBy(filterChain: FilterChainJs<PatientJs>, options: dynamic):
				Promise<PaginatedListJs<PatientJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val filterChainConverted: FilterChain<Patient> = filterChain_fromJs(
					filterChain,
					{ x1: PatientJs ->
						patient_fromJs(x1)
					},
				)
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
				val skipConverted: Int? = convertingOptionOrDefaultNullable(
					_options,
					"skip",
					null
				) { skip: Double? ->
					numberToInt(skip, "skip")
				}
				val sortConverted: String? = convertingOptionOrDefaultNullable(
					_options,
					"sort",
					null
				) { sort: String? ->
					undefinedToNull(sort)
				}
				val descConverted: Boolean? = convertingOptionOrDefaultNullable(
					_options,
					"desc",
					null
				) { desc: Boolean? ->
					undefinedToNull(desc)
				}
				val result = patientApi.tryAndRecover.filterPatientsBy(
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
					{ x1: Patient ->
						patient_toJs(x1)
					},
				)
			}
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
					com.icure.sdk.model.couchdb.SortDirection.Asc
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
					com.icure.sdk.model.couchdb.SortDirection.Asc
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
					com.icure.sdk.model.couchdb.SortDirection.Asc
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

		override fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<Record<String, String>>
				= GlobalScope.promise {
			val patientIdConverted: String = patientId
			val result = patientApi.tryAndRecover.getPatientHcPartyKeysForDelegate(
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
			val result = patientApi.tryAndRecover.countOfPatients(
				hcPartyIdConverted,
			)
			content_toJs(result)
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
					com.icure.sdk.model.couchdb.SortDirection.Asc
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

		override fun getPatients(patientIds: ListOfIdsJs): Promise<Array<PatientJs>> =
				GlobalScope.promise {
			val patientIdsConverted: ListOfIds = listOfIds_fromJs(patientIds)
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

		override fun modifyPatientReferral(
			patientId: String,
			referralId: String,
			options: dynamic,
		): Promise<PatientJs> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val patientIdConverted: String = patientId
				val referralIdConverted: String = referralId
				val startConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"start",
					null
				) { start: Double? ->
					numberToLong(start, "start")
				}
				val endConverted: Long? = convertingOptionOrDefaultNullable(
					_options,
					"end",
					null
				) { end: Double? ->
					numberToLong(end, "end")
				}
				val result = patientApi.tryAndRecover.modifyPatientReferral(
					patientIdConverted,
					referralIdConverted,
					startConverted,
					endConverted,
				)
				patient_toJs(result)
			}
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

		override fun mergePatients(
			intoId: String,
			fromId: String,
			expectedFromRev: String,
			updatedInto: EncryptedPatientJs,
		): Promise<PatientJs> = GlobalScope.promise {
			val intoIdConverted: String = intoId
			val fromIdConverted: String = fromId
			val expectedFromRevConverted: String = expectedFromRev
			val updatedIntoConverted: EncryptedPatient = patient_fromJs(updatedInto)
			val result = patientApi.tryAndRecover.mergePatients(
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
			eventFired: (PatientJs) -> Promise<Unit>,
			options: dynamic,
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
				val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefaultNonNull(
					_options,
					"onConnected",
					{}
				) { onConnected: () -> Promise<Unit> ->
					{  ->
						onConnected().await()
					}
				}
				val channelCapacityConverted: Int = convertingOptionOrDefaultNonNull(
					_options,
					"channelCapacity",
					kotlinx.coroutines.channels.Channel.BUFFERED
				) { channelCapacity: Double ->
					numberToInt(channelCapacity, "channelCapacity")
				}
				val retryDelayConverted: Duration = convertingOptionOrDefaultNonNull(
					_options,
					"retryDelay",
					2.seconds
				) { retryDelay: Double ->
					numberToDuration(retryDelay, "retryDelay")
				}
				val retryDelayExponentFactorConverted: Double = convertingOptionOrDefaultNonNull(
					_options,
					"retryDelayExponentFactor",
					2.0
				) { retryDelayExponentFactor: Double ->
					retryDelayExponentFactor
				}
				val maxRetriesConverted: Int = convertingOptionOrDefaultNonNull(
					_options,
					"maxRetries",
					5
				) { maxRetries: Double ->
					numberToInt(maxRetries, "maxRetries")
				}
				val eventFiredConverted: suspend (Patient) -> Unit = { arg0 ->
					eventFired(
						patient_toJs(arg0),
					).await()
				}
				val result = patientApi.tryAndRecover.subscribeToEvents(
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

	override fun createDelegationsDeAnonymizationMetadata(patient: PatientJs,
			dataOwnerIds: Array<String>): Promise<Unit> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val dataOwnerIdsConverted: Set<String> = arrayToSet(
			dataOwnerIds,
			"dataOwnerIds",
			{ x1: String ->
				x1
			},
		)
		patientApi.createDelegationsDeAnonymizationMetadata(
			patientConverted,
			dataOwnerIdsConverted,
		)

	}

	override fun hasWriteAccess(patient: PatientJs): Promise<Boolean> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.hasWriteAccess(
			patientConverted,
		)
		result
	}

	override fun decryptPatientIdOf(patient: PatientJs): Promise<Array<String>> = GlobalScope.promise {
		val patientConverted: Patient = patient_fromJs(patient)
		val result = patientApi.decryptPatientIdOf(
			patientConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
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

	override fun registerPatient(
		hcPartyId: String,
		groupId: String,
		token: String?,
		useShortToken: Boolean?,
		createAutoDelegation: Boolean,
		patient: DecryptedPatientJs,
	): Promise<DataOwnerRegistrationSuccessJs> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val groupIdConverted: String = groupId
		val tokenConverted: String? = undefinedToNull(token)
		val useShortTokenConverted: Boolean? = undefinedToNull(useShortToken)
		val createAutoDelegationConverted: Boolean = createAutoDelegation
		val patientConverted: DecryptedPatient = patient_fromJs(patient)
		val result = patientApi.registerPatient(
			hcPartyIdConverted,
			groupIdConverted,
			tokenConverted,
			useShortTokenConverted,
			createAutoDelegationConverted,
			patientConverted,
		)
		dataOwnerRegistrationSuccess_toJs(result)
	}

	override fun shareAllDataOfPatient(
		user: UserJs,
		patientId: String,
		dataOwnerId: String,
		delegatesWithShareType: Record<String, Array<String>>,
	): Promise<ShareAllPatientDataOptionsJs_ResultJs> = GlobalScope.promise {
		val userConverted: User = user_fromJs(user)
		val patientIdConverted: String = patientId
		val dataOwnerIdConverted: String = dataOwnerId
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
			userConverted,
			patientIdConverted,
			dataOwnerIdConverted,
			delegatesWithShareTypeConverted,
		)
		shareAllPatientDataOptions_Result_toJs(result)
	}

	override fun getPatientIdOfChildDocumentForHcpAndHcpParents(childDocument: EntityWithTypeInfoJs<*>,
			healthcarePartyId: String): Promise<String> = GlobalScope.promise {
		val childDocumentConverted: EntityWithTypeInfo<*> = anyEntityWithTypeInfoToKt(childDocument)
		val healthcarePartyIdConverted: String = healthcarePartyId
		val result = patientApi.getPatientIdOfChildDocumentForHcpAndHcpParents(
			childDocumentConverted,
			healthcarePartyIdConverted,
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

	override fun forceInitialiseExchangeDataToNewlyInvitedPatient(patientId: String): Promise<Boolean>
			= GlobalScope.promise {
		val patientIdConverted: String = patientId
		val result = patientApi.forceInitialiseExchangeDataToNewlyInvitedPatient(
			patientIdConverted,
		)
		result
	}

	override fun matchPatientsBy(filter: AbstractFilterJs<PatientJs>): Promise<Array<String>> =
			GlobalScope.promise {
		val filterConverted: AbstractFilter<Patient> = abstractFilter_fromJs(
			filter,
			{ x1: PatientJs ->
				patient_fromJs(x1)
			},
		)
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

	override fun undeletePatient(patientIds: String): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val patientIdsConverted: String = patientIds
		val result = patientApi.undeletePatient(
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
		val result = patientApi.getDataOwnersWithAccessTo(
			patientConverted,
		)
		entityAccessInformation_toJs(result)
	}

	override fun shareWith(
		delegateId: String,
		patient: DecryptedPatientJs,
		shareSecretIds: Array<String>,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val patientConverted: DecryptedPatient = patient_fromJs(patient)
			val shareSecretIdsConverted: Set<String> = arrayToSet(
				shareSecretIds,
				"shareSecretIds",
				{ x1: String ->
					x1
				},
			)
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
			val result = patientApi.shareWith(
				delegateIdConverted,
				patientConverted,
				shareSecretIdsConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(patient: DecryptedPatientJs,
			delegates: Record<String, PatientShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedPatientJs>> = GlobalScope.promise {
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
		val result = patientApi.tryShareWithMany(
			patientConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedPatient ->
				patient_toJs(x1)
			},
		)
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

	override fun initialiseConfidentialSecretId(patient: DecryptedPatientJs):
			Promise<DecryptedPatientJs> = GlobalScope.promise {
		val patientConverted: DecryptedPatient = patient_fromJs(patient)
		val result = patientApi.initialiseConfidentialSecretId(
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

	override fun getPatient(entityId: String): Promise<DecryptedPatientJs> = GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = patientApi.getPatient(
			entityIdConverted,
		)
		patient_toJs(result)
	}

	override fun filterPatientsBy(filterChain: FilterChainJs<PatientJs>, options: dynamic):
			Promise<PaginatedListJs<DecryptedPatientJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val filterChainConverted: FilterChain<Patient> = filterChain_fromJs(
				filterChain,
				{ x1: PatientJs ->
					patient_fromJs(x1)
				},
			)
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
			val skipConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"skip",
				null
			) { skip: Double? ->
				numberToInt(skip, "skip")
			}
			val sortConverted: String? = convertingOptionOrDefaultNullable(
				_options,
				"sort",
				null
			) { sort: String? ->
				undefinedToNull(sort)
			}
			val descConverted: Boolean? = convertingOptionOrDefaultNullable(
				_options,
				"desc",
				null
			) { desc: Boolean? ->
				undefinedToNull(desc)
			}
			val result = patientApi.filterPatientsBy(
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
				{ x1: DecryptedPatient ->
					patient_toJs(x1)
				},
			)
		}
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
				com.icure.sdk.model.couchdb.SortDirection.Asc
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
				com.icure.sdk.model.couchdb.SortDirection.Asc
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
				com.icure.sdk.model.couchdb.SortDirection.Asc
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

	override fun getPatientHcPartyKeysForDelegate(patientId: String): Promise<Record<String, String>> =
			GlobalScope.promise {
		val patientIdConverted: String = patientId
		val result = patientApi.getPatientHcPartyKeysForDelegate(
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
		val result = patientApi.countOfPatients(
			hcPartyIdConverted,
		)
		content_toJs(result)
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
				com.icure.sdk.model.couchdb.SortDirection.Asc
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

	override fun getPatients(patientIds: ListOfIdsJs): Promise<Array<DecryptedPatientJs>> =
			GlobalScope.promise {
		val patientIdsConverted: ListOfIds = listOfIds_fromJs(patientIds)
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

	override fun modifyPatientReferral(
		patientId: String,
		referralId: String,
		options: dynamic,
	): Promise<DecryptedPatientJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val patientIdConverted: String = patientId
			val referralIdConverted: String = referralId
			val startConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"start",
				null
			) { start: Double? ->
				numberToLong(start, "start")
			}
			val endConverted: Long? = convertingOptionOrDefaultNullable(
				_options,
				"end",
				null
			) { end: Double? ->
				numberToLong(end, "end")
			}
			val result = patientApi.modifyPatientReferral(
				patientIdConverted,
				referralIdConverted,
				startConverted,
				endConverted,
			)
			patient_toJs(result)
		}
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

	override fun mergePatients(
		intoId: String,
		fromId: String,
		expectedFromRev: String,
		updatedInto: EncryptedPatientJs,
	): Promise<DecryptedPatientJs> = GlobalScope.promise {
		val intoIdConverted: String = intoId
		val fromIdConverted: String = fromId
		val expectedFromRevConverted: String = expectedFromRev
		val updatedIntoConverted: EncryptedPatient = patient_fromJs(updatedInto)
		val result = patientApi.mergePatients(
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
		eventFired: (DecryptedPatientJs) -> Promise<Unit>,
		options: dynamic,
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
			val onConnectedConverted: suspend () -> Unit = convertingOptionOrDefaultNonNull(
				_options,
				"onConnected",
				{}
			) { onConnected: () -> Promise<Unit> ->
				{  ->
					onConnected().await()
				}
			}
			val channelCapacityConverted: Int = convertingOptionOrDefaultNonNull(
				_options,
				"channelCapacity",
				kotlinx.coroutines.channels.Channel.BUFFERED
			) { channelCapacity: Double ->
				numberToInt(channelCapacity, "channelCapacity")
			}
			val retryDelayConverted: Duration = convertingOptionOrDefaultNonNull(
				_options,
				"retryDelay",
				2.seconds
			) { retryDelay: Double ->
				numberToDuration(retryDelay, "retryDelay")
			}
			val retryDelayExponentFactorConverted: Double = convertingOptionOrDefaultNonNull(
				_options,
				"retryDelayExponentFactor",
				2.0
			) { retryDelayExponentFactor: Double ->
				retryDelayExponentFactor
			}
			val maxRetriesConverted: Int = convertingOptionOrDefaultNonNull(
				_options,
				"maxRetries",
				5
			) { maxRetries: Double ->
				numberToInt(maxRetries, "maxRetries")
			}
			val eventFiredConverted: suspend (DecryptedPatient) -> Unit = { arg0 ->
				eventFired(
					patient_toJs(arg0),
				).await()
			}
			val result = patientApi.subscribeToEvents(
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
