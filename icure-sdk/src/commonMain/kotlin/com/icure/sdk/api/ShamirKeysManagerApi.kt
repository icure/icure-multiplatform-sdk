package com.icure.sdk.api

import com.icure.sdk.crypto.entities.ShamirUpdateRequest
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.base.CryptoActor
import com.icure.sdk.model.specializations.KeypairFingerprintV1String

/**
 * Allows to create or update shamir split keys.
 */
interface ShamirKeysManagerApi {
	/**
	 * Get information on existing private keys splits for the provided data owner. For each private key of the provided data owner which has been
	 * split using the Shamir sharing algorithm gives the list of the notaries (other data owners) which hold a copy of the key part.
	 * @param dataOwner a data owner
	 * @return the existing splits for the current data owner as a publicKeyFingerprint -> notariesIds object
	 */
	fun getExistingSplitsInfo(dataOwner: CryptoActor): Map<KeypairFingerprintV1String, Set<String>>

	/**
	 * Creates, updates or deletes shamir splits for keys of the current data owner. Any request to update the splits for a specific key will completely
	 * replace any existing data on that split (all previous notaries will be ignored).
	 * Note: currently you can only split the legacy key pair.
	 * @param keySplitsToUpdate the fingerprints of key pairs which will have updated/new splits and the details on how to create the updated splits.
	 * @param keySplitsToDelete the fingerprints or hex-encoded spki public keys which will not be shared anymore.
	 * @throws IllegalArgumentException if the parameters refer to non-existing or unavailable keys, have split creation details, or if they request
	 * to delete a non-existing split.
	 */
	suspend fun updateSelfSplits(
		keySplitsToUpdate: Map<KeypairFingerprintV1String, ShamirUpdateRequest>,
		keySplitsToDelete: Set<KeypairFingerprintV1String>
	): CryptoActorStubWithType
}

