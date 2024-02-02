package com.icure.sdk.storage.impl

import com.icure.sdk.model.KeypairFingerprintV1String
import com.icure.sdk.storage.StorageEntryKeysFactory

/**
 * Default implementation for {@link StorageEntryKeysFactory}, compatible with legacy local storage keys.
 */
object DefaultStorageEntryKeysFactory : StorageEntryKeysFactory {
	override fun cachedRecoveredKeypairOfDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String {
		return "org.taktik.icure.rsa.recovered.${dataOwnerId}.${publicKeyFingerprint}"
	}

	override fun deviceKeypairOfDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String {
		return "org.taktik.icure.rsa.device.${dataOwnerId}.${publicKeyFingerprint}"
	}

	override fun selfPublicKeysVerificationCacheForDataOwner(dataOwnerId: String): String {
		return "org.taktik.icure.rsa.${dataOwnerId}.verification.self"
	}

	override fun signatureKeyForDataOwner(dataOwnerId: String): String {
		return "org.taktik.icure.rsa.sign.${dataOwnerId}.self"
	}

	override fun signatureVerificationKeyForDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String {
		return "org.taktik.icure.rsa.sign.verify.${dataOwnerId}.${publicKeyFingerprint}"
	}
}
