// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MaintenanceTaskApi
import com.icure.sdk.crypto.entities.MaintenanceTaskShareOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNonNull
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.sdk.js.api.flavoured.MaintenanceTaskApiJs
import com.icure.sdk.js.api.flavoured.MaintenanceTaskFlavouredApiJs
import com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.maintenanceTaskShareOptions_fromJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.filters.FilterOptionsJs
import com.icure.sdk.js.filters.SortableFilterOptionsJs
import com.icure.sdk.js.filters.filterOptions_fromJs
import com.icure.sdk.js.filters.sortableFilterOptions_fromJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedMaintenanceTaskJs
import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.maintenanceTask_fromJs
import com.icure.sdk.js.model.maintenanceTask_toJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.model.user_fromJs
import com.icure.sdk.js.subscription.EntitySubscriptionConfigurationJs
import com.icure.sdk.js.subscription.EntitySubscriptionJs
import com.icure.sdk.js.subscription.entitySubscriptionConfiguration_fromJs
import com.icure.sdk.js.subscription.entitySubscription_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.User
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.specializations.HexString
import com.icure.sdk.subscription.EntitySubscriptionConfiguration
import com.icure.sdk.subscription.SubscriptionEventType
import kotlin.Array
import kotlin.Boolean
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
internal class MaintenanceTaskApiImplJs(
	private val maintenanceTaskApi: MaintenanceTaskApi,
) : MaintenanceTaskApiJs {
	override val encrypted: MaintenanceTaskFlavouredApiJs<EncryptedMaintenanceTaskJs> = object :
			MaintenanceTaskFlavouredApiJs<EncryptedMaintenanceTaskJs> {
		override fun shareWith(
			delegateId: String,
			maintenanceTask: EncryptedMaintenanceTaskJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<EncryptedMaintenanceTaskJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
				val optionsConverted: MaintenanceTaskShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MaintenanceTaskShareOptionsJs? ->
					options?.let { nonNull1 ->
						maintenanceTaskShareOptions_fromJs(nonNull1)
					}
				}
				val result = maintenanceTaskApi.encrypted.shareWith(
					delegateIdConverted,
					maintenanceTaskConverted,
					optionsConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: EncryptedMaintenanceTask ->
						maintenanceTask_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(maintenanceTask: EncryptedMaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MaintenanceTaskShareOptionsJs ->
					maintenanceTaskShareOptions_fromJs(x1)
				},
			)
			val result = maintenanceTaskApi.encrypted.tryShareWithMany(
				maintenanceTaskConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun shareWithMany(maintenanceTask: EncryptedMaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<EncryptedMaintenanceTaskJs> =
				GlobalScope.promise {
			val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MaintenanceTaskShareOptionsJs ->
					maintenanceTaskShareOptions_fromJs(x1)
				},
			)
			val result = maintenanceTaskApi.encrypted.shareWithMany(
				maintenanceTaskConverted,
				delegatesConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
				Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
			val result = maintenanceTaskApi.encrypted.filterMaintenanceTasksBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
				Promise<PaginatedListIteratorJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<MaintenanceTask> =
					sortableFilterOptions_fromJs(filter)
			val result = maintenanceTaskApi.encrypted.filterMaintenanceTasksBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
				Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
			val entityConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(entity)
			val result = maintenanceTaskApi.encrypted.modifyMaintenanceTask(
				entityConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = maintenanceTaskApi.encrypted.getMaintenanceTask(
				entityIdConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun getMaintenanceTasks(entityIds: Array<String>):
				Promise<Array<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = maintenanceTaskApi.encrypted.getMaintenanceTasks(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}

	override val tryAndRecover: MaintenanceTaskFlavouredApiJs<MaintenanceTaskJs> = object :
			MaintenanceTaskFlavouredApiJs<MaintenanceTaskJs> {
		override fun shareWith(
			delegateId: String,
			maintenanceTask: MaintenanceTaskJs,
			options: dynamic,
		): Promise<SimpleShareResultJs<MaintenanceTaskJs>> {
			val _options = options ?: js("{}")
			return GlobalScope.promise {
				val delegateIdConverted: String = delegateId
				val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
				val optionsConverted: MaintenanceTaskShareOptions? = convertingOptionOrDefaultNullable(
					_options,
					"options",
					null
				) { options: MaintenanceTaskShareOptionsJs? ->
					options?.let { nonNull1 ->
						maintenanceTaskShareOptions_fromJs(nonNull1)
					}
				}
				val result = maintenanceTaskApi.tryAndRecover.shareWith(
					delegateIdConverted,
					maintenanceTaskConverted,
					optionsConverted,
				)
				simpleShareResult_toJs(
					result,
					{ x1: MaintenanceTask ->
						maintenanceTask_toJs(x1)
					},
				)
			}
		}

		override fun tryShareWithMany(maintenanceTask: MaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>):
				Promise<SimpleShareResultJs<MaintenanceTaskJs>> = GlobalScope.promise {
			val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MaintenanceTaskShareOptionsJs ->
					maintenanceTaskShareOptions_fromJs(x1)
				},
			)
			val result = maintenanceTaskApi.tryAndRecover.tryShareWithMany(
				maintenanceTaskConverted,
				delegatesConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun shareWithMany(maintenanceTask: MaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
				delegates,
				"delegates",
				{ x1: String ->
					x1
				},
				{ x1: MaintenanceTaskShareOptionsJs ->
					maintenanceTaskShareOptions_fromJs(x1)
				},
			)
			val result = maintenanceTaskApi.tryAndRecover.shareWithMany(
				maintenanceTaskConverted,
				delegatesConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
				Promise<PaginatedListIteratorJs<MaintenanceTaskJs>> = GlobalScope.promise {
			val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
			val result = maintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBy(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
				Promise<PaginatedListIteratorJs<MaintenanceTaskJs>> = GlobalScope.promise {
			val filterConverted: SortableFilterOptions<MaintenanceTask> =
					sortableFilterOptions_fromJs(filter)
			val result = maintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBySorted(
				filterConverted,
			)
			paginatedListIterator_toJs(
				result,
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}

		override fun modifyMaintenanceTask(entity: MaintenanceTaskJs): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			val entityConverted: MaintenanceTask = maintenanceTask_fromJs(entity)
			val result = maintenanceTaskApi.tryAndRecover.modifyMaintenanceTask(
				entityConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun getMaintenanceTask(entityId: String): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			val entityIdConverted: String = entityId
			val result = maintenanceTaskApi.tryAndRecover.getMaintenanceTask(
				entityIdConverted,
			)
			maintenanceTask_toJs(result)
		}

		override fun getMaintenanceTasks(entityIds: Array<String>): Promise<Array<MaintenanceTaskJs>> =
				GlobalScope.promise {
			val entityIdsConverted: List<String> = arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)
			val result = maintenanceTaskApi.tryAndRecover.getMaintenanceTasks(
				entityIdsConverted,
			)
			listToArray(
				result,
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}

	override fun createMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		val entityConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(entity)
		val result = maintenanceTaskApi.createMaintenanceTask(
			entityConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTaskJs?,
			options: dynamic): Promise<DecryptedMaintenanceTaskJs> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val maintenanceTaskConverted: DecryptedMaintenanceTask? = maintenanceTask?.let { nonNull1 ->
				maintenanceTask_fromJs(nonNull1)
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
			val result = maintenanceTaskApi.withEncryptionMetadata(
				maintenanceTaskConverted,
				userConverted,
				delegatesConverted,
			)
			maintenanceTask_toJs(result)
		}
	}

	override fun getEncryptionKeysOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>> =
			GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.getEncryptionKeysOf(
			maintenanceTaskConverted,
		)
		setToArray(
			result,
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)
	}

	override fun hasWriteAccess(maintenanceTask: MaintenanceTaskJs): Promise<Boolean> =
			GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.hasWriteAccess(
			maintenanceTaskConverted,
		)
		result
	}

	override fun decryptPatientIdOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>> =
			GlobalScope.promise {
		val maintenanceTaskConverted: MaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.decryptPatientIdOf(
			maintenanceTaskConverted,
		)
		setToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTaskJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		val entityConverted: MaintenanceTask = maintenanceTask_fromJs(entity)
		val delegatesConverted: Set<String> = arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		)
		maintenanceTaskApi.createDelegationDeAnonymizationMetadata(
			entityConverted,
			delegatesConverted,
		)

	}

	override fun decrypt(maintenanceTask: EncryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.decrypt(
			maintenanceTaskConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun tryDecrypt(maintenanceTask: EncryptedMaintenanceTaskJs): Promise<MaintenanceTaskJs> =
			GlobalScope.promise {
		val maintenanceTaskConverted: EncryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val result = maintenanceTaskApi.tryDecrypt(
			maintenanceTaskConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun matchMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
		val result = maintenanceTaskApi.matchMaintenanceTasksBy(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun matchMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<Array<String>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<MaintenanceTask> = sortableFilterOptions_fromJs(filter)
		val result = maintenanceTaskApi.matchMaintenanceTasksBySorted(
			filterConverted,
		)
		listToArray(
			result,
			{ x1: String ->
				x1
			},
		)
	}

	override fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = maintenanceTaskApi.deleteMaintenanceTask(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = maintenanceTaskApi.deleteMaintenanceTasks(
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
		maintenanceTask: DecryptedMaintenanceTaskJs,
		options: dynamic,
	): Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val delegateIdConverted: String = delegateId
			val maintenanceTaskConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
			val optionsConverted: MaintenanceTaskShareOptions? = convertingOptionOrDefaultNullable(
				_options,
				"options",
				null
			) { options: MaintenanceTaskShareOptionsJs? ->
				options?.let { nonNull1 ->
					maintenanceTaskShareOptions_fromJs(nonNull1)
				}
			}
			val result = maintenanceTaskApi.shareWith(
				delegateIdConverted,
				maintenanceTaskConverted,
				optionsConverted,
			)
			simpleShareResult_toJs(
				result,
				{ x1: DecryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}

	override fun tryShareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val maintenanceTaskConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: MaintenanceTaskShareOptionsJs ->
				maintenanceTaskShareOptions_fromJs(x1)
			},
		)
		val result = maintenanceTaskApi.tryShareWithMany(
			maintenanceTaskConverted,
			delegatesConverted,
		)
		simpleShareResult_toJs(
			result,
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun shareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<DecryptedMaintenanceTaskJs> =
			GlobalScope.promise {
		val maintenanceTaskConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(maintenanceTask)
		val delegatesConverted: Map<String, MaintenanceTaskShareOptions> = objectToMap(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
			{ x1: MaintenanceTaskShareOptionsJs ->
				maintenanceTaskShareOptions_fromJs(x1)
			},
		)
		val result = maintenanceTaskApi.shareWithMany(
			maintenanceTaskConverted,
			delegatesConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun filterMaintenanceTasksBy(filter: FilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
		val result = maintenanceTaskApi.filterMaintenanceTasksBy(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun filterMaintenanceTasksBySorted(filter: SortableFilterOptionsJs<MaintenanceTaskJs>):
			Promise<PaginatedListIteratorJs<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val filterConverted: SortableFilterOptions<MaintenanceTask> = sortableFilterOptions_fromJs(filter)
		val result = maintenanceTaskApi.filterMaintenanceTasksBySorted(
			filterConverted,
		)
		paginatedListIterator_toJs(
			result,
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun modifyMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		val entityConverted: DecryptedMaintenanceTask = maintenanceTask_fromJs(entity)
		val result = maintenanceTaskApi.modifyMaintenanceTask(
			entityConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun getMaintenanceTask(entityId: String): Promise<DecryptedMaintenanceTaskJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = maintenanceTaskApi.getMaintenanceTask(
			entityIdConverted,
		)
		maintenanceTask_toJs(result)
	}

	override fun getMaintenanceTasks(entityIds: Array<String>):
			Promise<Array<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = maintenanceTaskApi.getMaintenanceTasks(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)
	}

	override fun subscribeToEvents(
		events: Array<String>,
		filter: FilterOptionsJs<MaintenanceTaskJs>,
		options: dynamic,
	): Promise<EntitySubscriptionJs<EncryptedMaintenanceTaskJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val eventsConverted: Set<SubscriptionEventType> = arrayToSet(
				events,
				"events",
				{ x1: String ->
					SubscriptionEventType.valueOf(x1)
				},
			)
			val filterConverted: FilterOptions<MaintenanceTask> = filterOptions_fromJs(filter)
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
			val result = maintenanceTaskApi.subscribeToEvents(
				eventsConverted,
				filterConverted,
				subscriptionConfigConverted,
			)
			entitySubscription_toJs(
				result,
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)
		}
	}
}
