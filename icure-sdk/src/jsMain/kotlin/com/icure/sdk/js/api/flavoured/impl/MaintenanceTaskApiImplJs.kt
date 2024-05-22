// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.MaintenanceTaskApi
import com.icure.sdk.js.api.flavoured.MaintenanceTaskApiJs
import com.icure.sdk.js.api.flavoured.MaintenanceTaskFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.DecryptedMaintenanceTaskJs
import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.maintenanceTask_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.EncryptedMaintenanceTask
import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class MaintenanceTaskApiImplJs private constructor(
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
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: EncryptedMaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)}


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
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
						com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
						com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
				{ x1: MaintenanceTask ->
					maintenanceTask_toJs(x1)
				},
			)}


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

	}

	override fun createMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs> = GlobalScope.promise {
		maintenanceTask_toJs(maintenanceTaskApi.createMaintenanceTask(com.icure.sdk.js.model.maintenanceTask_fromJs(entity)))}


	override fun withEncryptionMetadata(
		maintenanceTask: DecryptedMaintenanceTaskJs?,
		user: UserJs?,
		delegates: dynamic,
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
		    com.icure.sdk.js.model.embed.accessLevel_fromJs(x1)
		  },
		)))}


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
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareEncryptionKeys),
					com.icure.sdk.js.crypto.entities.shareMetadataBehaviour_fromJs(shareOwningEntityIds),
					com.icure.sdk.js.model.requests.requestedPermission_fromJs(requestedPermission)),
			{ x1: DecryptedMaintenanceTask ->
				maintenanceTask_toJs(x1)
			},
		)}

}
