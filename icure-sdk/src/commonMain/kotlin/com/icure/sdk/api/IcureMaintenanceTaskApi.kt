package com.icure.sdk.api

import com.icure.sdk.model.DataOwnerType
import com.icure.sdk.model.sdk.KeyPairUpdateNotification
import com.icure.sdk.model.specializations.SpkiHexString
import com.icure.sdk.utils.DefaultValue

/**
 * Api for creating and interpreting iCure's standard maintenance tasks
 */
interface IcureMaintenanceTaskApi {
	/**
	 * Applies a key pair update request between another data owner and the current data owner to allow the other data owner to access existing exchange
	 * keys shared with the current data owner. IMPORTANT: it is your responsibility to verify the authenticity of the public key / update request
	 * before calling this method: this method assumes the new public key for the concerned data owner is authentic.
	 * @param updateRequest a keypair update request to the current data owner.
	 */
	suspend fun applyKeyPairUpdate(updateRequest: KeyPairUpdateNotification)

	/**
	 * Creates the necessary maintenance tasks to request access through the keypair corresponding to [key] to ALL existing exchange keys between the
	 * current user and other data owners of the types specified in [requestToOwnerTypes].
	 * If [requestToOwnerTypes] is null the set of data owners will be automatically chosen depending on the type of the current data owner:
	 * - [[DataOwnerType.Hcp]] for healthcare parties
	 * - [[DataOwnerType.Patient], [DataOwnerType.Hcp]] for patients
	 * @param key a public key of the current user.
	 * @param requestToOwnerTypes limit request creations only to data owners of these types.
	 */
	suspend fun createKeyPairUpdateNotificationsToAllDelegationCounterparts(
		key: SpkiHexString,
		@DefaultValue("null")
		requestToOwnerTypes: Set<DataOwnerType>? = null
	)

	/**
	 * Creates a maintenance tasks to request access through the keypair corresponding to [key] to ALL existing exchange keys between the
	 * current data owner and [dataOwnerId].
	 */
	suspend fun createKeyPairUpdateNotificationTo(
		dataOwnerId: String,
		key: SpkiHexString
	)
}

