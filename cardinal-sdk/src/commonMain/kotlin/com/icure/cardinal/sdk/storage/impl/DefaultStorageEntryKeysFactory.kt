package com.icure.cardinal.sdk.storage.impl

import com.icure.cardinal.sdk.model.specializations.KeypairFingerprintV1String
import com.icure.cardinal.sdk.storage.StorageEntryKeysFactory

/**
 * Default implementation for {@link StorageEntryKeysFactory}, compatible with legacy local storage keys.
 */
object DefaultStorageEntryKeysFactory : StorageEntryKeysFactory {
	override fun cachedRecoveredKeypairOfDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String {
		return "org.taktik.icure.rsa.recovered.${dataOwnerId}.${publicKeyFingerprint.s}"
	}

	override fun deviceKeypairOfDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String {
		return "org.taktik.icure.rsa.device.${dataOwnerId}.${publicKeyFingerprint.s}"
	}

	override fun selfPublicKeysVerificationCacheForDataOwner(dataOwnerId: String): String {
		return "org.taktik.icure.rsa.${dataOwnerId}.verification.self"
	}

	override fun signatureKeyForDataOwner(dataOwnerId: String): String {
		return "org.taktik.icure.rsa.sign.${dataOwnerId}.self"
	}

	override fun signatureVerificationKeyForDataOwner(dataOwnerId: String, publicKeyFingerprint: KeypairFingerprintV1String): String {
		return "org.taktik.icure.rsa.sign.verify.${dataOwnerId}.${publicKeyFingerprint.s}"
	}
}
