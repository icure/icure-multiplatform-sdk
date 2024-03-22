package com.icure.sdk.model.base

import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

public interface Encryptable : Versionable<String> {
  public val secretForeignKeys: Set<String>

  public val cryptedForeignKeys: Map<String, Set<Delegation>>

  public val delegations: Map<String, Set<Delegation>>

  public val encryptionKeys: Map<String, Set<Delegation>>

  public val encryptedSelf: Base64String?

  public val securityMetadata: SecurityMetadata?
}
