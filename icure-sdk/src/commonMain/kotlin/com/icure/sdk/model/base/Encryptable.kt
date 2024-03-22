package com.icure.sdk.model.base

import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.EntityWithDelegationTypeName
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
interface Encryptable : Versionable<String> {
  public val secretForeignKeys: Set<String>

  public val cryptedForeignKeys: Map<String, Set<Delegation>>

  public val delegations: Map<String, Set<Delegation>>

  public val encryptionKeys: Map<String, Set<Delegation>>

  public val encryptedSelf: Base64String?

  public val securityMetadata: SecurityMetadata?
	// region Encryptable-Encryptable

  fun copyWithSecurityMetadata(securityMetadata: SecurityMetadata, secretForeignKeys: Set<String>): Encryptable

  val type: EntityWithDelegationTypeName

	// endregion
}