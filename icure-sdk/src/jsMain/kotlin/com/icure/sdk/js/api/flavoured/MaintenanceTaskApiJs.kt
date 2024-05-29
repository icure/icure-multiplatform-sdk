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
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.utils.Record
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

	public fun withEncryptionMetadata(
		maintenanceTask: DecryptedMaintenanceTaskJs?,
		user: UserJs?,
		delegates: Record<String, String>,
	): Promise<DecryptedMaintenanceTaskJs>

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
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>>

	public fun tryShareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedMaintenanceTaskJs>>

	public fun shareWithMany(maintenanceTask: DecryptedMaintenanceTaskJs,
			delegates: Record<String, MaintenanceTaskShareOptionsJs>): Promise<DecryptedMaintenanceTaskJs>

	public fun modifyMaintenanceTask(entity: DecryptedMaintenanceTaskJs):
			Promise<DecryptedMaintenanceTaskJs>

	public fun getMaintenanceTask(entityId: String): Promise<DecryptedMaintenanceTaskJs>

	public fun filterMaintenanceTasksBy(
		startDocumentId: String?,
		limit: Double?,
		filterChain: FilterChainJs<MaintenanceTaskJs>,
	): Promise<PaginatedListJs<DecryptedMaintenanceTaskJs>>
}
