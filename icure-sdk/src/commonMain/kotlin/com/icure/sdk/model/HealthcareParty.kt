package com.icure.sdk.model

import kotlinx.serialization.Serializable

@Serializable
data class HealthcareParty(
	override val id: String,
	override val rev: String? = null,
	val created: Long? = null,
	val modified: Long? = null,
	val deletionDate: Long? = null,
	val name: String? = null,
	val lastName: String? = null,
	val firstName: String? = null,
	val parentId: String? = null,
	override val hcPartyKeys: Map<String, List<String>> = emptyMap(),
	override val aesExchangeKeys: Map<String, Map<String, Map<String, String>>> = emptyMap(),
	override val transferKeys: Map<String, Map<String, String>> = emptyMap(),
	override val privateKeyShamirPartitions: Map<String, String> = emptyMap(), //Format is hcpId of key that has been partitionned : "threshold⎮partition in hex"
	override val publicKey: String? = null,
	override val publicKeysForOaepWithSha256: Set<String> = emptySet()
): Revisionable<String>, CryptoActor