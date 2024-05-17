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
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
sealed interface Form :
	StoredDocument,
	ICureDocument<String>,
	HasEncryptionMetadata,
	Encryptable {
	public val id: String

	public val rev: String?

	public val created: Long?

	public val modified: Long?

	public val author: String?

	public val responsible: String?

	public val medicalLocationId: String?

	public val tags: Set<CodeStub>

	public val codes: Set<CodeStub>

	public val endOfLife: Long?

	public val deletionDate: Long?

	public val openingDate: Long?

	public val status: String?

	public val version: Int?

	public val logicalUuid: String?

	public val descr: String?

	public val uniqueId: String?

	public val formTemplateId: String?

	public val contactId: String?

	public val healthElementId: String?

	public val planOfActionId: String?

	public val parent: String?

	public val secretForeignKeys: Set<String>

	public val cryptedForeignKeys: Map<String, Set<Delegation>>

	public val delegations: Map<String, Set<Delegation>>

	public val encryptionKeys: Map<String, Set<Delegation>>

	public val encryptedSelf: Base64String?

	public val securityMetadata: SecurityMetadata?
	// region Form-Form

	// endregion
}

@Serializable
data class DecryptedForm(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val openingDate: Long? = null,
	override val status: String? = null,
	override val version: Int? = null,
	override val logicalUuid: String? = null,
	override val descr: String? = null,
	override val uniqueId: String? = null,
	override val formTemplateId: String? = null,
	override val contactId: String? = null,
	override val healthElementId: String? = null,
	override val planOfActionId: String? = null,
	override val parent: String? = null,
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
) : Form {
	// region Form-DecryptedForm
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): DecryptedForm =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}

@Serializable
data class EncryptedForm(
	override val id: String,
	override val rev: String? = null,
	override val created: Long? = null,
	override val modified: Long? = null,
	override val author: String? = null,
	override val responsible: String? = null,
	override val medicalLocationId: String? = null,
	@DefaultValue("emptySet()")
	override val tags: Set<CodeStub> = emptySet(),
	@DefaultValue("emptySet()")
	override val codes: Set<CodeStub> = emptySet(),
	override val endOfLife: Long? = null,
	override val deletionDate: Long? = null,
	override val openingDate: Long? = null,
	override val status: String? = null,
	override val version: Int? = null,
	override val logicalUuid: String? = null,
	override val descr: String? = null,
	override val uniqueId: String? = null,
	override val formTemplateId: String? = null,
	override val contactId: String? = null,
	override val healthElementId: String? = null,
	override val planOfActionId: String? = null,
	override val parent: String? = null,
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
) : Form {
	// region Form-EncryptedForm
override fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): EncryptedForm =
		copy(securityMetadata = securityMetadata, secretForeignKeys = secretForeignKeys)
	// endregion
}
