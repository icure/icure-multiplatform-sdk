package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
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
sealed interface Topic :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	public val id: String

	public val rev: String?

	public val created: Long?

	public val modified: Long?

	public val healthElementId: String?

	public val contactId: String?

	public val description: String?

	public val codes: Set<CodeStub>

	public val tags: Set<CodeStub>

	public val author: String?

	public val responsible: String?

	public val medicalLocationId: String?

	public val endOfLife: Long?

	public val deletionDate: Long?

	public val activeParticipants: Map<String, TopicRole>

	public val securityMetadata: SecurityMetadata?

	public val secretForeignKeys: Set<String>

	public val cryptedForeignKeys: Map<String, Set<Delegation>>

	public val delegations: Map<String, Set<Delegation>>

	public val encryptionKeys: Map<String, Set<Delegation>>

	public val encryptedSelf: Base64String?

	public val linkedHealthElements: Set<String>

	public val linkedServices: Set<String>
	// region Topic-Topic

	// endregion
}

@Serializable
data class DecryptedTopic(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val healthElementId: String? = null,
	override val contactId: String? = null,
	override val description: String? = null,
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	@DefaultValue("emptyMap()")
	override val activeParticipants: Map<String, TopicRole> = emptyMap(),
	override val securityMetadata: SecurityMetadata? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	@DefaultValue("emptySet()")
	override val linkedHealthElements: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	override val linkedServices: Set<String> = emptySet(),
) : Topic {
	// region Topic-DecryptedTopic
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedTopic =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedTopic(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val healthElementId: String? = null,
	override val contactId: String? = null,
	override val description: String? = null,
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	@DefaultValue("emptyMap()")
	override val activeParticipants: Map<String, TopicRole> = emptyMap(),
	override val securityMetadata: SecurityMetadata? = null,
	@DefaultValue("emptySet()")
	override val secretForeignKeys: Set<String> = emptySet(),
	@DefaultValue("emptyMap()")
	override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val delegations: Map<String, Set<Delegation>> = emptyMap(),
	@DefaultValue("emptyMap()")
	override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
	override val encryptedSelf: Base64String? = null,
	@DefaultValue("emptySet()")
	override val linkedHealthElements: Set<String> = emptySet(),
	@DefaultValue("emptySet()")
	override val linkedServices: Set<String> = emptySet(),
) : Topic {
	// region Topic-EncryptedTopic
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedTopic =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
