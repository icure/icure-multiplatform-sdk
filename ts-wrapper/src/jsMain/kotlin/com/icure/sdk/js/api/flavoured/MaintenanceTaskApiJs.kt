// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.MaintenanceTaskShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.DecryptedMaintenanceTaskJs
import com.icure.sdk.js.model.EncryptedMaintenanceTaskJs
import com.icure.sdk.js.model.MaintenanceTaskJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.websocket.ConnectionJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("MaintenanceTaskApi")
public external interface MaintenanceTaskApiJs {
	public val encrypted: MaintenanceTaskFlavouredApiJs<EncryptedMaintenanceTaskJs>

	public val tryAndRecover: MaintenanceTaskFlavouredApiJs<MaintenanceTaskJs>

	public fun createMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs>

	public fun withEncryptionMetadata(maintenanceTask: DecryptedMaintenanceTaskJs?,
			options: MaintenanceTaskApi_withEncryptionMetadata_Options?): Promise<DecryptedMaintenanceTaskJs>

	public fun getEncryptionKeysOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>>

	public fun hasWriteAccess(maintenanceTask: MaintenanceTaskJs): Promise<Boolean>

	public fun decryptPatientIdOf(maintenanceTask: MaintenanceTaskJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: MaintenanceTaskJs,
			delegates: Array<String>): Promise<Unit>

	public fun deleteMaintenanceTask(entityId: String): Promise<DocIdentifierJs>

	public fun deleteMaintenanceTasks(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		maintenanceTask: DecryptedMaintenanceTaskJs,
		options: MaintenanceTaskApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>>

	public fun tryShareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>>

	public fun shareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<DecryptedMaintenanceTaskJs>

	public fun modifyMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs>

	public fun getMaintenanceTask(entityId: String): Promise<DecryptedMaintenanceTaskJs>

	public fun filterMaintenanceTasksBy(filterChain: FilterChainJs<MaintenanceTaskJs>,
			options: MaintenanceTaskApi_filterMaintenanceTasksBy_Options?):
			Promise<PaginatedListJs<DecryptedMaintenanceTaskJs>>

	public fun subscribeToEvents(
		events: Array<String>,
		filter: AbstractFilterJs<MaintenanceTaskJs>,
		eventFired: (DecryptedMaintenanceTaskJs) -> Promise<Unit>,
		options: MaintenanceTaskApi_subscribeToEvents_Options?,
	): Promise<ConnectionJs>
}

public external interface MaintenanceTaskApi_withEncryptionMetadata_Options {
	public val user: UserJs?

	public val delegates: Record<String, String>
}

public external interface MaintenanceTaskApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface MaintenanceTaskApi_filterMaintenanceTasksBy_Options {
	public val startDocumentId: String?

	public val limit: Double?
}

public external interface MaintenanceTaskApi_subscribeToEvents_Options {
	public val onConnected: () -> Promise<Unit>

	public val channelCapacity: Double

	public val retryDelay: Double

	public val retryDelayExponentFactor: Double

	public val maxRetries: Double
}
