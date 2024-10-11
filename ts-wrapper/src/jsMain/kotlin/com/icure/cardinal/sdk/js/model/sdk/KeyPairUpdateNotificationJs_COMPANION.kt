// TODO need to auto generate - after can remove the ignore
package com.icure.cardinal.sdk.js.model.sdk

import com.icure.cardinal.sdk.js.model.DecryptedMaintenanceTaskJs
import com.icure.cardinal.sdk.js.model.maintenanceTask_fromJs
import com.icure.cardinal.sdk.model.sdk.KeyPairUpdateNotification

@JsExport
object InternalKeyPairUpdateNotificationJs_COMPANION {
	const val TASK_TYPE = KeyPairUpdateNotification.TASK_TYPE
	fun parseFromMaintenanceTask(task: DecryptedMaintenanceTaskJs): KeyPairUpdateNotificationJs =
		keyPairUpdateNotification_toJs(KeyPairUpdateNotification.parseFromMaintenanceTask(maintenanceTask_fromJs(task)))
}
