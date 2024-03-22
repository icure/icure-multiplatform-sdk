package com.icure.sdk.model

/**
 * Holds only data specific for crypto actors without any additional information (from patient, hcparty, device).
 */
interface CryptoActor : Revisionable<String> {
	val hcPartyKeys: Map<String, List<HexString>>
	val aesExchangeKeys: Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>>
	val transferKeys: Map<String, Map<String, String>>
	val privateKeyShamirPartitions: Map<String, String>
	val publicKey: SpkiHexString?
	val publicKeysForOaepWithSha256: Set<SpkiHexString>
	val tags: Set<CodeStub>
}
