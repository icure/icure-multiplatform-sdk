package com.icure.sdk.crypto

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.kryptom.crypto.RsaKeypair
import com.icure.sdk.crypto.entities.RecoveryResult
import com.icure.sdk.model.SpkiHexString

/**
 * Allows to recover user keypairs using builtin recovery mechanisms.
 * This interface includes recovery methods that require some input from your application (e.g. a recovery key created from a different device).
 * Other recovery methods (such as transfer keys) are used automatically by the sdk when available and don't require any input from your application.
 */
interface KeyPairRecoverer {
	/**
	 * Recover a keypair using a recovery key created in the past using the {@link IccRecoveryXApi.createRecoveryInfoForAvailableKeyPairs} method.
	 * @param recoveryKey the result of a past call to {@link IccRecoveryXApi.createRecoveryInfoForAvailableKeyPairs}.
	 * @param autoDelete if true, the recovery data will be deleted from the server after it could be used successfully.
	 * This will prevent the recovery key from being used again.
	 * @return a recovery result, which, if successful, contains a map dataOwnerId -> publicKeySpki -> keyPair, where:
	 * - The `dataOwnerId` keys are the ids of the data owner which created the recovery data and his parents, if the recovery data contains also the
	 *   parents keys
	 * - The `publicKeySpki` keys are all recovered public key pairs for the data owner, in hex-encoded spki format (full, no fingerprint). Usually
	 *   these are all the keys if the recovery data was created after the latest key for the user.
	 * - The `keyPair` is the imported privateKey + publicKey.
	 */
	suspend fun recoverWithRecoveryKey(
		recoveryKey: String,
		autoDelete: Boolean
	): RecoveryResult<Map<String, Map<SpkiHexString, RsaKeypair<RsaAlgorithm.RsaEncryptionAlgorithm>>>>
}