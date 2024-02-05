package com.icure.sdk.crypto

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
interface IcureKeyRecovery {
	/*TODO
	 * Currently there is no support for the recovery of signature keys. When implementing a recovery solution we should consider:
	 * - unlike decryption keys signature keys are completely useless if not verified.
	 * - we are fine losing the signature private key, but if we could recover and verify the public key it would reduce the inconveniences on user and
	 * limit the creation of new exchange data
	 * - We can't guarantee that encrypted data in iCure was put there by us... unless we put a piece of the private key as well: we can save an
	 * hash of (any verification public key + any encryption private key) in the data owner: only the owner of the private key can create this hash,
	 * so if the data owner can recreate the hash with one of his recovered and verified encryption private keys then the signature public key will
	 * for sure be safe as well.
	 */

	/**
	 * Attempt to recover private keys of a data owner using all available key recovery methods and all available private keys.
	 * The method will automatically try to use newly recovered key pairs to recover additional key pairs.
	 * @param dataOwner a data owner.
	 * @param knownKeys keys available for the data owner.
	 * @return new key pairs (exclude already known pairs) which could be recovered using the known keys.
	 */
	suspend fun recoverKeys(
		dataOwner: DataOwnerWithType,
		knownKeys: Map<KeypairFingerprintV1String, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>
	): Map<KeypairFingerprintV1String, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>

	/*TODO?
	 * Ask access back suggestion: if by getting access back to an exchange key with another data owner I may recover additional keys we could suggest
	 * to ask for access back to that data owner.
	 */
}