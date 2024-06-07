// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.HealthcareElementApi
import com.icure.sdk.crypto.entities.HealthElementShareOptions
import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.flavoured.HealthcareElementApiJs
import com.icure.sdk.js.api.flavoured.HealthcareElementApi_findHealthcareElementsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.HealthcareElementApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.HealthcareElementApi_subscribeToEvents_Options
import com.icure.sdk.js.api.flavoured.HealthcareElementApi_withEncryptionMetadata_Options
import com.icure.sdk.js.api.flavoured.HealthcareElementFlavouredApiJs
import com.icure.sdk.js.api.flavoured.HealthcareElementFlavouredApi_findHealthcareElementsByHcPartyPatient_Options
import com.icure.sdk.js.api.flavoured.HealthcareElementFlavouredApi_shareWith_Options
import com.icure.sdk.js.api.flavoured.HealthcareElementFlavouredApi_subscribeToEvents_Options
import com.icure.sdk.js.crypto.entities.HealthElementShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.healthElementShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.secretIdOption_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.numberToDuration
import com.icure.sdk.js.model.CheckedConverters.numberToInt
import com.icure.sdk.js.model.CheckedConverters.numberToLong
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedHealthElementJs
import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.filter.chain.filterChain_fromJs
import com.icure.sdk.js.model.healthElement_fromJs
import com.icure.sdk.js.model.healthElement_toJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.patient_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
import com.icure.sdk.model.Patient
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
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
internal class HealthcareElementApiImplJs(
	private val healthcareElementApi: HealthcareElementApi,
) : HealthcareElementApiJs {
	override val encrypted: HealthcareElementFlavouredApiJs<EncryptedHealthElementJs> = object :
			HealthcareElementFlavouredApiJs<EncryptedHealthElementJs> {
		override fun shareWith(
			delegateId: String,
			healthcareElement: EncryptedHealthElementJs,
			options: HealthcareElementFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<EncryptedHealthElementJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val healthcareElementConverted: EncryptedHealthElement = healthElement_fromJs(healthcareElement)
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
				val result = healthcareElementApi.encrypted.shareWith(
					delegateIdConverted,
					healthcareElementConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(healthElement: EncryptedHealthElementJs,
				delegates: Record<String, HealthElementShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			val healthElementConverted: EncryptedHealthElement = healthElement_fromJs(healthElement)
			val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: HealthElementShareOptionsJs ->
					healthElementShareOptions_fromJs(x1)
				},
			)
			val result = healthcareElementApi.encrypted.tryShareWithMany(
				healthElementConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun shareWithMany(healthElement: EncryptedHealthElementJs,
				delegates: Record<String, HealthElementShareOptionsJs>): Promise<EncryptedHealthElementJs> =
				GlobalScope.promise {
			val healthElementConverted: EncryptedHealthElement = healthElement_fromJs(healthElement)
			val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: HealthElementShareOptionsJs ->
					healthElementShareOptions_fromJs(x1)
				},
			)
			val result = healthcareElementApi.encrypted.shareWithMany(
				healthElementConverted,
				delegatesConverted,
			)
			healthElement_toJs(result)
		}

		override fun findHealthcareElementsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: HealthcareElementFlavouredApi_findHealthcareElementsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<EncryptedHealthElementJs>> {
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
				val result = healthcareElementApi.encrypted.findHealthcareElementsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: EncryptedHealthElement ->
						healthElement_toJs(x1)
					},
				)
			}
		}

		override fun modifyHealthcareElement(entity: EncryptedHealthElementJs):
				Promise<EncryptedHealthElementJs> = GlobalScope.promise {
			val entityConverted: EncryptedHealthElement = healthElement_fromJs(entity)
			val result = healthcareElementApi.encrypted.modifyHealthcareElement(
				entityConverted,
			)
			healthElement_toJs(result)
		}

		override fun modifyHealthcareElements(entities: Array<EncryptedHealthElementJs>):
				Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
			val entitiesConverted: List<EncryptedHealthElement> = arrayToList(
				entities,
				"entities",
				{ x1: EncryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthcareElementApi.encrypted.modifyHealthcareElements(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun getHealthcareElement(entityId: String): Promise<EncryptedHealthElementJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = healthcareElementApi.encrypted.getHealthcareElement(
				entityIdConverted,
			)
			healthElement_toJs(result)
		}

		override fun getHealthcareElements(entityIds: Array<String>):
				Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = healthcareElementApi.encrypted.getHealthcareElements(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun filterHealthcareElementsBy(
			filterChain: FilterChainJs<HealthElementJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			val filterChainConverted: FilterChain<HealthElement> = filterChain_fromJs(
				filterChain,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = healthcareElementApi.encrypted.filterHealthcareElementsBy(
				filterChainConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<EncryptedHealthElementJs>> =
				GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val result = healthcareElementApi.encrypted.findHealthcareElementsByHcPartyPatientForeignKeys(
				hcPartyIdConverted,
				secretPatientKeysConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<HealthElementJs>,
			eventFired: (EncryptedHealthElementJs) -> Promise<Unit>,
			options: HealthcareElementFlavouredApi_subscribeToEvents_Options?,
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
				val filterConverted: AbstractFilter<HealthElement> = abstractFilter_fromJs(
					filter,
					{ x1: HealthElementJs ->
						healthElement_fromJs(x1)
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
				val eventFiredConverted: suspend (EncryptedHealthElement) -> Unit = { arg0 ->
					eventFired(
						healthElement_toJs(arg0),
					).await()
				}
				val result = healthcareElementApi.encrypted.subscribeToEvents(
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

	override val tryAndRecover: HealthcareElementFlavouredApiJs<HealthElementJs> = object :
			HealthcareElementFlavouredApiJs<HealthElementJs> {
		override fun shareWith(
			delegateId: String,
			healthcareElement: HealthElementJs,
			options: HealthcareElementFlavouredApi_shareWith_Options?,
		): Promise<SimpleShareResultJs<HealthElementJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val healthcareElementConverted: HealthElement = healthElement_fromJs(healthcareElement)
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
				val result = healthcareElementApi.tryAndRecover.shareWith(
					delegateIdConverted,
					healthcareElementConverted,
					shareEncryptionKeysConverted,
					shareOwningEntityIdsConverted,
					requestedPermissionConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: HealthElement ->
						healthElement_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(healthElement: HealthElementJs,
				delegates: Record<String, HealthElementShareOptionsJs>):
				Promise<SimpleShareResultJs<HealthElementJs>> = GlobalScope.promise {
			val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
			val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: HealthElementShareOptionsJs ->
					healthElementShareOptions_fromJs(x1)
				},
			)
			val result = healthcareElementApi.tryAndRecover.tryShareWithMany(
				healthElementConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun shareWithMany(healthElement: HealthElementJs,
				delegates: Record<String, HealthElementShareOptionsJs>): Promise<HealthElementJs> =
				GlobalScope.promise {
			val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
			val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: HealthElementShareOptionsJs ->
					healthElementShareOptions_fromJs(x1)
				},
			)
			val result = healthcareElementApi.tryAndRecover.shareWithMany(
				healthElementConverted,
				delegatesConverted,
			)
			healthElement_toJs(result)
		}

		override fun findHealthcareElementsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			options: HealthcareElementFlavouredApi_findHealthcareElementsByHcPartyPatient_Options?,
		): Promise<PaginatedListIteratorJs<HealthElementJs>> {
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
				val result = healthcareElementApi.tryAndRecover.findHealthcareElementsByHcPartyPatient(
					hcPartyIdConverted,
					patientConverted,
					startDateConverted,
					endDateConverted,
					descendingConverted,
				)
				paginatedListIterator_toJs(
					result,
					{ x1: HealthElement ->
						healthElement_toJs(x1)
					},
				)
			}
		}

		override fun modifyHealthcareElement(entity: HealthElementJs): Promise<HealthElementJs> =
				GlobalScope.promise {
			val entityConverted: HealthElement = healthElement_fromJs(entity)
			val result = healthcareElementApi.tryAndRecover.modifyHealthcareElement(
				entityConverted,
			)
			healthElement_toJs(result)
		}

		override fun modifyHealthcareElements(entities: Array<HealthElementJs>):
				Promise<Array<HealthElementJs>> = GlobalScope.promise {
			val entitiesConverted: List<HealthElement> = arrayToList(
				entities,
				"entities",
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val result = healthcareElementApi.tryAndRecover.modifyHealthcareElements(
				entitiesConverted,
			)
			listToArray(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun getHealthcareElement(entityId: String): Promise<HealthElementJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = healthcareElementApi.tryAndRecover.getHealthcareElement(
				entityIdConverted,
			)
			healthElement_toJs(result)
		}

		override fun getHealthcareElements(entityIds: Array<String>): Promise<Array<HealthElementJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = healthcareElementApi.tryAndRecover.getHealthcareElements(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun filterHealthcareElementsBy(
			filterChain: FilterChainJs<HealthElementJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<HealthElementJs>> = GlobalScope.promise {
			val filterChainConverted: FilterChain<HealthElement> = filterChain_fromJs(
				filterChain,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)
			val startDocumentIdConverted: String? = startDocumentId
			val limitConverted: Int? = numberToInt(limit, "limit")
			val result = healthcareElementApi.tryAndRecover.filterHealthcareElementsBy(
				filterChainConverted,
				startDocumentIdConverted,
				limitConverted,
			)
			paginatedList_toJs(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<HealthElementJs>> = GlobalScope.promise {
			val hcPartyIdConverted: String = hcPartyId
			val secretPatientKeysConverted: List<String> = arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)
			val result =
					healthcareElementApi.tryAndRecover.findHealthcareElementsByHcPartyPatientForeignKeys(
				hcPartyIdConverted,
				secretPatientKeysConverted,
			)
			listToArray(
				result,
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)
		}

		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<HealthElementJs>,
			eventFired: (HealthElementJs) -> Promise<Unit>,
			options: HealthcareElementFlavouredApi_subscribeToEvents_Options?,
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
				val filterConverted: AbstractFilter<HealthElement> = abstractFilter_fromJs(
					filter,
					{ x1: HealthElementJs ->
						healthElement_fromJs(x1)
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
				val eventFiredConverted: suspend (HealthElement) -> Unit = { arg0 ->
					eventFired(
						healthElement_toJs(arg0),
					).await()
				}
				val result = healthcareElementApi.tryAndRecover.subscribeToEvents(
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

	override fun createHealthcareElement(entity: DecryptedHealthElementJs):
			Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		val entityConverted: DecryptedHealthElement = healthElement_fromJs(entity)
		val result = healthcareElementApi.createHealthcareElement(
			entityConverted,
		)
		healthElement_toJs(result)
	}

	override fun createHealthcareElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedHealthElement> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthcareElementApi.createHealthcareElements(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun withEncryptionMetadata(
		base: DecryptedHealthElementJs?,
		patient: PatientJs,
		options: HealthcareElementApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedHealthElementJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val baseConverted: DecryptedHealthElement? = base?.let { nonNull1 ->
				healthElement_fromJs(nonNull1)
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
			val result = healthcareElementApi.withEncryptionMetadata(
				baseConverted,
				patientConverted,
				userConverted,
				delegatesConverted,
				secretIdConverted,
			)
			healthElement_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(healthElement: HealthElementJs): Promise<Array<String>> =
			GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthcareElementApi.getEncryptionKeysOf(
			healthElementConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(healthElement: HealthElementJs): Promise<Boolean> =
			GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthcareElementApi.hasWriteAccess(
			healthElementConverted,
		)
		result
	}

	override fun decryptPatientIdOf(healthElement: HealthElementJs): Promise<Array<String>> =
			GlobalScope.promise {
		val healthElementConverted: HealthElement = healthElement_fromJs(healthElement)
		val result = healthcareElementApi.decryptPatientIdOf(
			healthElementConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: HealthElementJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: HealthElement = healthElement_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		healthcareElementApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun matchHealthcareElementsBy(filter: AbstractFilterJs<HealthElementJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: AbstractFilter<HealthElement> = abstractFilter_fromJs(
			filter,
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthcareElementApi.matchHealthcareElementsBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteHealthcareElement(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthcareElementApi.deleteHealthcareElement(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteHealthcareElements(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcareElementApi.deleteHealthcareElements(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result =
				healthcareElementApi.findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: IcureStub ->
				icureStub_toJs(x1)
			},
		)
	}

	override fun shareWith(
		delegateId: String,
		healthcareElement: DecryptedHealthElementJs,
		options: HealthcareElementApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedHealthElementJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val healthcareElementConverted: DecryptedHealthElement = healthElement_fromJs(healthcareElement)
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
			val result = healthcareElementApi.shareWith(
				delegateIdConverted,
				healthcareElementConverted,
				shareEncryptionKeysConverted,
				shareOwningEntityIdsConverted,
				requestedPermissionConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(healthElement: DecryptedHealthElementJs,
			delegates: Record<String, HealthElementShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedHealthElementJs>> = GlobalScope.promise {
		val healthElementConverted: DecryptedHealthElement = healthElement_fromJs(healthElement)
		val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: HealthElementShareOptionsJs ->
				healthElementShareOptions_fromJs(x1)
			},
		)
		val result = healthcareElementApi.tryShareWithMany(
			healthElementConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun shareWithMany(healthElement: DecryptedHealthElementJs,
			delegates: Record<String, HealthElementShareOptionsJs>): Promise<DecryptedHealthElementJs> =
			GlobalScope.promise {
		val healthElementConverted: DecryptedHealthElement = healthElement_fromJs(healthElement)
		val delegatesConverted: Map<String, HealthElementShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: HealthElementShareOptionsJs ->
				healthElementShareOptions_fromJs(x1)
			},
		)
		val result = healthcareElementApi.shareWithMany(
			healthElementConverted,
			delegatesConverted,
		)
		healthElement_toJs(result)
	}

	override fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: HealthcareElementApi_findHealthcareElementsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedHealthElementJs>> {
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
			val result = healthcareElementApi.findHealthcareElementsByHcPartyPatient(
				hcPartyIdConverted,
				patientConverted,
				startDateConverted,
				endDateConverted,
				descendingConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: DecryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)
		}
	}

	override fun modifyHealthcareElement(entity: DecryptedHealthElementJs):
			Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		val entityConverted: DecryptedHealthElement = healthElement_fromJs(entity)
		val result = healthcareElementApi.modifyHealthcareElement(
			entityConverted,
		)
		healthElement_toJs(result)
	}

	override fun modifyHealthcareElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		val entitiesConverted: List<DecryptedHealthElement> = arrayToList(
			entities,
			"entities",
			{ x1: DecryptedHealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val result = healthcareElementApi.modifyHealthcareElements(
			entitiesConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun getHealthcareElement(entityId: String): Promise<DecryptedHealthElementJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = healthcareElementApi.getHealthcareElement(
			entityIdConverted,
		)
		healthElement_toJs(result)
	}

	override fun getHealthcareElements(entityIds: Array<String>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = healthcareElementApi.getHealthcareElements(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun filterHealthcareElementsBy(
		filterChain: FilterChainJs<HealthElementJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedHealthElementJs>> = GlobalScope.promise {
		val filterChainConverted: FilterChain<HealthElement> = filterChain_fromJs(
			filterChain,
			{ x1: HealthElementJs ->
				healthElement_fromJs(x1)
			},
		)
		val startDocumentIdConverted: String? = startDocumentId
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = healthcareElementApi.filterHealthcareElementsBy(
			filterChainConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedHealthElementJs>> =
			GlobalScope.promise {
		val hcPartyIdConverted: String = hcPartyId
		val secretPatientKeysConverted: List<String> = arrayToList(
			secretPatientKeys,
			"secretPatientKeys",
			{ x1: String ->
				x1
			},
		)
		val result = healthcareElementApi.findHealthcareElementsByHcPartyPatientForeignKeys(
			hcPartyIdConverted,
			secretPatientKeysConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<HealthElementJs>,
		eventFired: (DecryptedHealthElementJs) -> Promise<Unit>,
		options: HealthcareElementApi_subscribeToEvents_Options?,
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
			val filterConverted: AbstractFilter<HealthElement> = abstractFilter_fromJs(
				filter,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
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
			val eventFiredConverted: suspend (DecryptedHealthElement) -> Unit = { arg0 ->
				eventFired(
					healthElement_toJs(arg0),
				).await()
			}
			val result = healthcareElementApi.subscribeToEvents(
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
