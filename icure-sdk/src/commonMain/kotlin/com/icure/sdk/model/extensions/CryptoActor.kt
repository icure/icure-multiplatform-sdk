package com.icure.sdk.model.extensions

import com.icure.kryptom.crypto.RsaAlgorithm
import com.icure.sdk.model.CryptoActor
import com.icure.sdk.model.CryptoActorStub
import com.icure.sdk.model.CryptoActorStubWithType
import com.icure.sdk.model.DataOwnerWithType
import com.icure.sdk.model.SpkiHexString

/**
 * All public keys of the crypto actor to be used for OAEP with SHA1
 */
val CryptoActor.publicKeysWithSha1Spki: Set<SpkiHexString> get() =
	(aesExchangeKeys.keys + listOfNotNull(publicKey)).mapTo(mutableSetOf()) { SpkiHexString(it) }

/**
 * All public keys of the crypto actor to be used for OAEP with SHA256
 */
val CryptoActor.publicKeysWithSha256Spki: Set<SpkiHexString> get() =
	publicKeysForOaepWithSha256.mapTo(mutableSetOf()) { SpkiHexString(it) }

/**
 * All public keys of the crypto actor
 */
val CryptoActor.publicKeysSpki: Set<SpkiHexString> get() =
	(aesExchangeKeys.keys + publicKeysForOaepWithSha256 + listOfNotNull(publicKey)).mapTo(mutableSetOf()) { SpkiHexString(it) }

fun CryptoActor.algorithmOfEncryptionKey(encryptionKey: SpkiHexString) =
	when {
		publicKeysWithSha1Spki.contains(encryptionKey) -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha1
		publicKeysWithSha256Spki.contains(encryptionKey) -> RsaAlgorithm.RsaEncryptionAlgorithm.OaepWithSha256
		else -> throw IllegalArgumentException("Key $encryptionKey is not a valid encryption key of crypto actor $id")
	}

fun CryptoActor.toStub() =
	CryptoActorStub(
		id = id,
		rev = requireNotNull(rev) { "You can only convert to a stub crypto actors that are already persisted." },
		hcPartyKeys = hcPartyKeys,
		aesExchangeKeys = aesExchangeKeys,
		transferKeys = transferKeys,
		privateKeyShamirPartitions = privateKeyShamirPartitions,
		publicKey = publicKey,
		publicKeysForOaepWithSha256 = publicKeysForOaepWithSha256,
		tags = tags
	)

fun DataOwnerWithType.toStub(): CryptoActorStubWithType =
	CryptoActorStubWithType(type = type, stub = dataOwner.toStub())
