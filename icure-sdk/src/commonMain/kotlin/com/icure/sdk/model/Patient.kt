package com.icure.sdk.model

import kotlinx.serialization.Serializable

@Serializable
data class Patient(
	override val id: String,
	override val rev: String? = null,
	val created: Long? = null,
	val modified: Long? = null,
	val deletionDate: Long? = null,
	val name: String? = null,
	val lastName: String? = null,
	val firstName: String? = null,
	val note: String? = null,
	override val hcPartyKeys: Map<String, List<HexString>> = emptyMap(),
	override val aesExchangeKeys: Map<SpkiHexString, Map<String, Map<AesExchangeKeyEncryptionKeypairIdentifier, HexString>>> = emptyMap(),
	override val transferKeys: Map<String, Map<String, String>> = emptyMap(),
	override val privateKeyShamirPartitions: Map<String, String> = emptyMap(), //Format is hcpId of key that has been partitionned : "threshold⎮partition in hex"
	override val publicKey: SpkiHexString? = null,
	override val publicKeysForOaepWithSha256: Set<SpkiHexString> = emptySet(),
	override val securityMetadata: SecurityMetadata? = null,
	override val secretForeignKeys: Set<String> = emptySet(),
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val tags: Set<CodeStub> = emptySet()
): Revisionable<String>, CryptoActor, Encryptable {
	override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): Patient =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)

	override val type: EntityWithDelegationTypeName get() = EntityWithDelegationTypeName.Patient
}