package com.icure.sdk.model

/**
 * Holds only data specific for crypto actors without any additional information (from patient, hcparty, device).
 */
interface CryptoActor {
	val hcPartyKeys: Map<String, List<String>>
	val aesExchangeKeys: Map<String, Map<String, Map<String, String>>>
	val transferKeys: Map<String, Map<String, String>>
	val privateKeyShamirPartitions: Map<String, String>
	val publicKey: String?
	val publicKeysForOaepWithSha256: Set<String>
}
