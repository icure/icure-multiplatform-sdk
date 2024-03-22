package com.icure.sdk.model

import com.icure.sdk.model.base.Encryptable
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.Delegation
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.Base64String
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public sealed interface SecureDelegationKeyMap : StoredDocument, Encryptable {
  override val id: String

  override val rev: String?

  public val delegationKey: String

  public val delegator: String?

  public val `delegate`: String?

  override val secretForeignKeys: Set<String>

  override val cryptedForeignKeys: Map<String, Set<Delegation>>

  override val delegations: Map<String, Set<Delegation>>

  override val encryptionKeys: Map<String, Set<Delegation>>

  override val encryptedSelf: Base64String?

  override val securityMetadata: SecurityMetadata?

  override val deletionDate: Long?
}

public data class DecryptedSecureDelegationKeyMap(
  override val id: String,
  override val rev: String? = null,
  override val delegationKey: String,
  override val delegator: String? = null,
  override val `delegate`: String? = null,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
  override val deletionDate: Long? = null,
) : SecureDelegationKeyMap

public data class EncryptedSecureDelegationKeyMap(
  override val id: String,
  override val rev: String? = null,
  override val delegationKey: String,
  override val delegator: String? = null,
  override val `delegate`: String? = null,
  override val secretForeignKeys: Set<String> = emptySet(),
  override val cryptedForeignKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val delegations: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptionKeys: Map<String, Set<Delegation>> = emptyMap(),
  override val encryptedSelf: Base64String? = null,
  override val securityMetadata: SecurityMetadata? = null,
  override val deletionDate: Long? = null,
) : SecureDelegationKeyMap

public fun SecureDelegationKeyMap.copy(
  id: String = this.id,
  rev: String? = this.rev,
  delegationKey: String = this.delegationKey,
  delegator: String? = this.delegator,
  `delegate`: String? = this.delegate,
  secretForeignKeys: Set<String> = this.secretForeignKeys,
  cryptedForeignKeys: Map<String, Set<Delegation>> = this.cryptedForeignKeys,
  delegations: Map<String, Set<Delegation>> = this.delegations,
  encryptionKeys: Map<String, Set<Delegation>> = this.encryptionKeys,
  encryptedSelf: Base64String? = this.encryptedSelf,
  securityMetadata: SecurityMetadata? = this.securityMetadata,
  deletionDate: Long? = this.deletionDate,
): SecureDelegationKeyMap {
                                      return when(this) {
                                          is DecryptedSecureDelegationKeyMap -> copy(id = id, rev =
          rev, delegationKey = delegationKey, delegator = delegator, delegate = delegate,
          secretForeignKeys = secretForeignKeys, cryptedForeignKeys = cryptedForeignKeys,
          delegations = delegations, encryptionKeys = encryptionKeys, encryptedSelf = encryptedSelf,
          securityMetadata = securityMetadata, deletionDate = deletionDate)
      is EncryptedSecureDelegationKeyMap -> copy(id = id, rev = rev, delegationKey = delegationKey,
          delegator = delegator, delegate = delegate, secretForeignKeys = secretForeignKeys,
          cryptedForeignKeys = cryptedForeignKeys, delegations = delegations, encryptionKeys =
          encryptionKeys, encryptedSelf = encryptedSelf, securityMetadata = securityMetadata,
          deletionDate = deletionDate)
                                          }
}
