package com.icure.cardinal.sdk.model.base

import org.taktik.icure.services.`external`.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.SecurityMetadataDto
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import com.icure.cardinal.sdk.model.embed.Delegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import org.taktik.icure.services.`external`.rest.v2.dto.embed.DelegationDto
import org.taktik.icure.services.`external`.rest.v2.dto.embed.SecurityMetadataDto
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface HasEncryptionMetadata : Versionable<String> {
	public val secretForeignKeys: Set<String>

	public val cryptedForeignKeys: Map<String, Set<DelegationDto>>

	public val delegations: Map<String, Set<DelegationDto>>

	public val encryptionKeys: Map<String, Set<DelegationDto>>

	public val securityMetadata: SecurityMetadataDto?
	// region HasEncryptionMetadata-HasEncryptionMetadata
fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): HasEncryptionMetadata
	// endregion
}
