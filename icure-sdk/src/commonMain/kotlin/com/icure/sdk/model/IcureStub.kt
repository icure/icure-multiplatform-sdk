package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasEncryptionMetadata
import com.icure.sdk.model.base.ICureDocument
import com.icure.sdk.model.base.Versionable
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.SecurityMetadata
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class IcureStub(
    override val id: String,
    override val rev: String? = null,
    override val created: Long? = null,
    override val modified: Long? = null,
    override val author: String? = null,
    override val responsible: String? = null,
    override val medicalLocationId: String? = null,
    override val tags: Set<CodeStub> = emptySet(),
    override val codes: Set<CodeStub> = emptySet(),
    override val endOfLife: Long? = null,
    override val secretForeignKeys: Set<String> = emptySet(),
    override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
    override val delegations: Map<String, Set<Delegation>> = emptyMap(),
    override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
    override val securityMetadata: SecurityMetadata? = null,
) : ICureDocument<String>, Versionable<String>, HasEncryptionMetadata {
	// region IcureStub-IcureStub

	// endregion
}
