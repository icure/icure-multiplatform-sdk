package com.icure.sdk.model

import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.Encryptable
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface SecureDelegationKeyMap : StoredDocument, HasEncryptionMetadata, Encryptable {
	public val id: String

	public val rev: String?

	public val delegationKey: String

	public val delegator: String?

	public val `delegate`: String?

	public val secretForeignKeys: Set<String>

	public val cryptedForeignKeys: Map<String, Set<Delegation>>

	public val delegations: Map<String, Set<Delegation>>

	public val encryptionKeys: Map<String, Set<Delegation>>

	public val encryptedSelf: Base64String?

	public val securityMetadata: SecurityMetadata?

	public val deletionDate: Long?
	// region SecureDelegationKeyMap-SecureDelegationKeyMap

	// endregion
}

@Serializable
data class DecryptedSecureDelegationKeyMap(
	override val id: String,
	override val rev: String? = null,
	override val delegationKey: String,
	override val delegator: String? = null,
	override val `delegate`: String? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val deletionDate: Long? = null,
) : SecureDelegationKeyMap {
	// region SecureDelegationKeyMap-DecryptedSecureDelegationKeyMap
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedSecureDelegationKeyMap =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedSecureDelegationKeyMap(
	override val id: String,
	override val rev: String? = null,
	override val delegationKey: String,
	override val delegator: String? = null,
	override val `delegate`: String? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	override val securityMetadata: SecurityMetadata? = null,
	override val deletionDate: Long? = null,
) : SecureDelegationKeyMap {
	// region SecureDelegationKeyMap-EncryptedSecureDelegationKeyMap
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedSecureDelegationKeyMap =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
