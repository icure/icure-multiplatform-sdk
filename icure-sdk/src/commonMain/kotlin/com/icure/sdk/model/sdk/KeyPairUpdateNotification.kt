package com.icure.sdk.model.sdk

import com.icure.sdk.model.DecryptedMaintenanceTask
import com.icure.sdk.model.extensions.tryFindStringProperty
import com.icure.sdk.model.specializations.SpkiHexString
import kotlinx.serialization.Serializable

/**
 * Notification that a new key was created by a data owner (usually due to a loss of a previous key) and that the data
 * owner is requesting to be given access to existing aes exchange keys and exchange data with the provided key.
 */
@Serializable
data class KeyPairUpdateNotification(
	/**
	 * New public key of the data owner, in hex-encoded spki format.
	 */
	val newPublicKey: SpkiHexString,
	/**
	 * Id of the data owner which created a new key pair and wants to regain access to his exchange keys.
	 */
	val concernedDataOwnerId: String
) {
	companion object {
		/**
		 * Type for maintenance tasks that are key pair update notifications.
		 */
		internal const val TASK_TYPE = "KEY_PAIR_UPDATE"
		/**
		 * Id of the property containing the [KeyPairUpdateNotification.concernedDataOwnerId]
		 */
		internal const val OWNER_ID_PROPERTY_ID = "dataOwnerConcernedId"
		/**
		 * Id of the property containing the [KeyPairUpdateNotification.newPublicKey]
		 */
		internal const val OWNER_PUBLIC_KEY_PROPERTY_ID = "dataOwnerConcernedPubKey"

		/**
		 * Extracts thea new key pair update notification from a maintenance task.
		 * @param task a maintenance task representing a key pair update notification.
		 * @throws IllegalArgumentException if the task does not represent a key pair update notification.
		 * @return the key pair update notification associated to [task].
		 */
		fun parseFromMaintenanceTask(task: DecryptedMaintenanceTask): KeyPairUpdateNotification {
			require (task.taskType == TASK_TYPE) {
				"Type of task ${task.id} is not a key pair update notification."
			}
			val concernedDataOwnerId = requireNotNull(task.tryFindStringProperty(OWNER_ID_PROPERTY_ID)) {
				"Task ${task.id} does not contain a valid property for data owner id."
			}
			val newPublicKey = requireNotNull(task.tryFindStringProperty(OWNER_PUBLIC_KEY_PROPERTY_ID)) {
				"Task ${task.id} does not contain a valid property for new public key."
			}
			return KeyPairUpdateNotification(
				newPublicKey = SpkiHexString(newPublicKey),
				concernedDataOwnerId = concernedDataOwnerId
			)
		}
	}
}