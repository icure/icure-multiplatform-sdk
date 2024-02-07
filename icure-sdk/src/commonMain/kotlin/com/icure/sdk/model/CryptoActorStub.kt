package com.icure.sdk.model

import kotlinx.serialization.Serializable

/**
 * Holds only data specific for crypto actors without any additional information (from patient, hcparty, device).
 */
@Serializable
data class CryptoActorStub(
	override val id: String,
	override val rev: String, // Stubs can't be created, but only updated or retrieved: rev is never null.
	override val hcPartyKeys: Map<String, List<String>> = emptyMap(),
	override val aesExchangeKeys: Map<String, Map<String, Map<String, String>>> = emptyMap(),
	override val transferKeys: Map<String, Map<String, String>> = emptyMap(),
	override val privateKeyShamirPartitions: Map<String, String> = emptyMap(),
	override val publicKey: String? = null,
	override val publicKeysForOaepWithSha256: Set<String> = emptySet(),
	val revHistory: Map<String, String>? = null,
	val tags: Set<CodeStub> = emptySet(),
) : Revisionable<String>, CryptoActor