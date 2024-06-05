// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MaintenanceTaskApi
import com.icure.sdk.js.api.flavoured.MaintenanceTaskApiJs
import com.icure.sdk.js.api.flavoured.MaintenanceTaskFlavouredApiJs
import com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedMaintenanceTaskJs
import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.maintenanceTask_fromJs
import com.icure.sdk.js.model.maintenanceTask_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import com.icure.sdk.js.websocket.connection_toJs
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
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
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				maintenanceTaskApi.encrypted.shareWith(delegateId,
						com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)}


		override fun tryShareWithMany(maintenanceTask: EncryptedMaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>):
				Promise<SimpleShareResultJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				maintenanceTaskApi.encrypted.tryShareWithMany(com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.maintenanceTaskShareOptions_fromJs(x1)
				  },
				)),
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)}


		override fun shareWithMany(maintenanceTask: EncryptedMaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<EncryptedMaintenanceTaskJs> =
				GlobalScope.promise {
			maintenanceTask_toJs(maintenanceTaskApi.encrypted.shareWithMany(com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.maintenanceTaskShareOptions_fromJs(x1)
			  },
			)))}


		override fun modifyMaintenanceTask(entity: EncryptedMaintenanceTaskJs):
				Promise<EncryptedMaintenanceTaskJs> = GlobalScope.promise {
			maintenanceTask_toJs(maintenanceTaskApi.encrypted.modifyMaintenanceTask(com.icure.sdk.js.model.maintenanceTask_fromJs(entity)))}


		override fun getMaintenanceTask(entityId: String): Promise<EncryptedMaintenanceTaskJs> =
				GlobalScope.promise {
			maintenanceTask_toJs(maintenanceTaskApi.encrypted.getMaintenanceTask(entityId))}


		override fun filterMaintenanceTasksBy(
			startDocumentId: String?,
			limit: Double?,
			filterChain: FilterChainJs<MaintenanceTaskJs>,
		): Promise<PaginatedListJs<EncryptedMaintenanceTaskJs>> = GlobalScope.promise {
			paginatedList_toJs(
				maintenanceTaskApi.encrypted.filterMaintenanceTasksBy(startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.MaintenanceTaskJs ->
				    com.icure.sdk.js.model.maintenanceTask_fromJs(x1)
				  },
				)),
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)}


		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<MaintenanceTaskJs>,
			onConnected: () -> Promise<Unit>,
			channelCapacity: Double,
			retryDelay: Double,
			retryDelayExponentFactor: Double,
			maxRetries: Double,
			eventFired: (EncryptedMaintenanceTaskJs) -> Promise<Unit>,
		): Promise<ConnectionJs> = GlobalScope.promise {
			val onConnectedConverted: suspend () -> Unit = {  ->
				onConnected(
				).await()
			}
			val eventFiredConverted: suspend (EncryptedMaintenanceTask) -> Unit = { arg0 ->
				eventFired(
					maintenanceTask_toJs(arg0)).await()
			}
			connection_toJs(maintenanceTaskApi.encrypted.subscribeToEvents(com.icure.sdk.js.model.CheckedConverters.arrayToSet(
			  events,
			  "events",
			  { x1: kotlin.String ->
			    com.icure.sdk.model.notification.SubscriptionEventType.valueOf(x1)
			  },
			), com.icure.sdk.js.model.filter.abstractFilter_fromJs(
			  filter,
			  { x1: com.icure.sdk.js.model.MaintenanceTaskJs ->
			    com.icure.sdk.js.model.maintenanceTask_fromJs(x1)
			  },
			), onConnectedConverted, com.icure.sdk.js.model.CheckedConverters.numberToInt(channelCapacity,
					"channelCapacity"), com.icure.sdk.js.model.CheckedConverters.numberToDuration(retryDelay,
					"retryDelay"), retryDelayExponentFactor,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(maxRetries, "maxRetries"),
					eventFiredConverted))}

	}

	override val tryAndRecover: MaintenanceTaskFlavouredApiJs<MaintenanceTaskJs> = object :
			MaintenanceTaskFlavouredApiJs<MaintenanceTaskJs> {
		override fun shareWith(
			delegateId: String,
			maintenanceTask: MaintenanceTaskJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<MaintenanceTaskJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				maintenanceTaskApi.tryAndRecover.shareWith(delegateId,
						com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)}


		override fun tryShareWithMany(maintenanceTask: MaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>):
				Promise<SimpleShareResultJs<MaintenanceTaskJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				maintenanceTaskApi.tryAndRecover.tryShareWithMany(com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.maintenanceTaskShareOptions_fromJs(x1)
				  },
				)),
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)}


		override fun shareWithMany(maintenanceTask: MaintenanceTaskJs,
				delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			maintenanceTask_toJs(maintenanceTaskApi.tryAndRecover.shareWithMany(com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.maintenanceTaskShareOptions_fromJs(x1)
			  },
			)))}


		override fun modifyMaintenanceTask(entity: MaintenanceTaskJs): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			maintenanceTask_toJs(maintenanceTaskApi.tryAndRecover.modifyMaintenanceTask(com.icure.sdk.js.model.maintenanceTask_fromJs(entity)))}


		override fun getMaintenanceTask(entityId: String): Promise<MaintenanceTaskJs> =
				GlobalScope.promise {
			maintenanceTask_toJs(maintenanceTaskApi.tryAndRecover.getMaintenanceTask(entityId))}


		override fun filterMaintenanceTasksBy(
			startDocumentId: String?,
			limit: Double?,
			filterChain: FilterChainJs<MaintenanceTaskJs>,
		): Promise<PaginatedListJs<MaintenanceTaskJs>> = GlobalScope.promise {
			paginatedList_toJs(
				maintenanceTaskApi.tryAndRecover.filterMaintenanceTasksBy(startDocumentId,
						com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
						com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.MaintenanceTaskJs ->
				    com.icure.sdk.js.model.maintenanceTask_fromJs(x1)
				  },
				)),
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)}


		override fun subscribeToEvents(
			events: Array<String>,
			filter: AbstractFilterJs<MaintenanceTaskJs>,
			onConnected: () -> Promise<Unit>,
			channelCapacity: Double,
			retryDelay: Double,
			retryDelayExponentFactor: Double,
			maxRetries: Double,
			eventFired: (MaintenanceTaskJs) -> Promise<Unit>,
		): Promise<ConnectionJs> = GlobalScope.promise {
			val onConnectedConverted: suspend () -> Unit = {  ->
				onConnected(
				).await()
			}
			val eventFiredConverted: suspend (MaintenanceTask) -> Unit = { arg0 ->
				eventFired(
					maintenanceTask_toJs(arg0)).await()
			}
			connection_toJs(maintenanceTaskApi.tryAndRecover.subscribeToEvents(com.icure.sdk.js.model.CheckedConverters.arrayToSet(
			  events,
			  "events",
			  { x1: kotlin.String ->
			    com.icure.sdk.model.notification.SubscriptionEventType.valueOf(x1)
			  },
			), com.icure.sdk.js.model.filter.abstractFilter_fromJs(
			  filter,
			  { x1: com.icure.sdk.js.model.MaintenanceTaskJs ->
			    com.icure.sdk.js.model.maintenanceTask_fromJs(x1)
			  },
			), onConnectedConverted, com.icure.sdk.js.model.CheckedConverters.numberToInt(channelCapacity,
					"channelCapacity"), com.icure.sdk.js.model.CheckedConverters.numberToDuration(retryDelay,
					"retryDelay"), retryDelayExponentFactor,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(maxRetries, "maxRetries"),
					eventFiredConverted))}

	}

	override fun createMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		maintenanceTask_toJs(maintenanceTaskApi.createMaintenanceTask(com.icure.sdk.js.model.maintenanceTask_fromJs(entity)))}


	override fun withEncryptionMetadata(
		maintenanceTask: DecryptedMaintenanceTaskJs?,
		user: UserJs?,
		delegates: Record<String, String>,
	): Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		maintenanceTask_toJs(maintenanceTaskApi.withEncryptionMetadata(maintenanceTask?.let { nonNull1 ->
		  com.icure.sdk.js.model.maintenanceTask_fromJs(nonNull1)
		}, user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.model.embed.AccessLevel.valueOf(x1)
		  },
		)))}


	override fun getEncryptionKeysOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			maintenanceTaskApi.getEncryptionKeysOf(maintenanceTask_fromJs(maintenanceTask)),
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)}


	override fun hasWriteAccess(maintenanceTask: MaintenanceTaskJs): Promise<Boolean> =
			GlobalScope.promise {
		maintenanceTaskApi.hasWriteAccess(maintenanceTask_fromJs(maintenanceTask))}


	override fun decryptPatientIdOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			maintenanceTaskApi.decryptPatientIdOf(maintenanceTask_fromJs(maintenanceTask)),
			{ x1: String ->
				x1
			},
		)}


	override fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTaskJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		maintenanceTaskApi.createDelegationDeAnonymizationMetadata(maintenanceTask_fromJs(entity),
				arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		))}


	override fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(maintenanceTaskApi.deleteMaintenanceTask(entityId))}


	override fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			maintenanceTaskApi.deleteMaintenanceTasks(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun shareWith(
		delegateId: String,
		maintenanceTask: DecryptedMaintenanceTaskJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			maintenanceTaskApi.shareWith(delegateId,
					com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
					com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)}


	override fun tryShareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			maintenanceTaskApi.tryShareWithMany(com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.maintenanceTaskShareOptions_fromJs(x1)
			  },
			)),
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)}


	override fun shareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<DecryptedMaintenanceTaskJs> =
			GlobalScope.promise {
		maintenanceTask_toJs(maintenanceTaskApi.shareWithMany(com.icure.sdk.js.model.maintenanceTask_fromJs(maintenanceTask),
				com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs ->
		    com.icure.sdk.js.crypto.entities.maintenanceTaskShareOptions_fromJs(x1)
		  },
		)))}


	override fun modifyMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		maintenanceTask_toJs(maintenanceTaskApi.modifyMaintenanceTask(com.icure.sdk.js.model.maintenanceTask_fromJs(entity)))}


	override fun getMaintenanceTask(entityId: String): Promise<DecryptedMaintenanceTaskJs> =
			GlobalScope.promise {
		maintenanceTask_toJs(maintenanceTaskApi.getMaintenanceTask(entityId))}


	override fun filterMaintenanceTasksBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<MaintenanceTaskJs>,
	): Promise<PaginatedListJs<DecryptedMaintenanceTaskJs>> = GlobalScope.promise {
		paginatedList_toJs(
			maintenanceTaskApi.filterMaintenanceTasksBy(startDocumentId,
					com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit"),
					com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.MaintenanceTaskJs ->
			    com.icure.sdk.js.model.maintenanceTask_fromJs(x1)
			  },
			)),
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)}


	override fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MaintenanceTaskJs>,
		onConnected: () -> Promise<Unit>,
		channelCapacity: Double,
		retryDelay: Double,
		retryDelayExponentFactor: Double,
		maxRetries: Double,
		eventFired: (DecryptedMaintenanceTaskJs) -> Promise<Unit>,
	): Promise<ConnectionJs> = GlobalScope.promise {
		val onConnectedConverted: suspend () -> Unit = {  ->
			onConnected(
			).await()
		}
		val eventFiredConverted: suspend (DecryptedMaintenanceTask) -> Unit = { arg0 ->
			eventFired(
				maintenanceTask_toJs(arg0)).await()
		}
		connection_toJs(maintenanceTaskApi.subscribeToEvents(com.icure.sdk.js.model.CheckedConverters.arrayToSet(
		  events,
		  "events",
		  { x1: kotlin.String ->
		    com.icure.sdk.model.notification.SubscriptionEventType.valueOf(x1)
		  },
		), com.icure.sdk.js.model.filter.abstractFilter_fromJs(
		  filter,
		  { x1: com.icure.sdk.js.model.MaintenanceTaskJs ->
		    com.icure.sdk.js.model.maintenanceTask_fromJs(x1)
		  },
		), onConnectedConverted, com.icure.sdk.js.model.CheckedConverters.numberToInt(channelCapacity,
				"channelCapacity"), com.icure.sdk.js.model.CheckedConverters.numberToDuration(retryDelay,
				"retryDelay"), retryDelayExponentFactor,
				com.icure.sdk.js.model.CheckedConverters.numberToInt(maxRetries, "maxRetries"),
				eventFiredConverted))}

}
