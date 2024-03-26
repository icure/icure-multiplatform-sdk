package com.icure.sdk.model

import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.Principal
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.DelegationTag
import com.icure.sdk.model.enums.UsersStatus
import com.icure.sdk.model.enums.UsersType
import com.icure.sdk.model.security.AuthenticationToken
import com.icure.sdk.model.security.Permission
import com.icure.sdk.serialization.InstantSerializer
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
public data class User(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val created: Long? = null,
  public val identifier: List<Identifier> = emptyList(),
  override val name: String? = null,
  override val properties: Set<PropertyStub> = emptySet(),
  public val permissions: Set<Permission> = emptySet(),
  public val roles: Set<String> = emptySet(),
  public val type: UsersType? = null,
  public val status: UsersStatus? = null,
  public val login: String? = null,
  public val passwordHash: String? = null,
  public val groupId: String? = null,
  public val healthcarePartyId: String? = null,
  public val patientId: String? = null,
  public val deviceId: String? = null,
  public val autoDelegations: Map<DelegationTag, Set<String>> = emptyMap(),
  @Serializable(with = InstantSerializer::class)
  public val createdDate: Instant? = null,
  @Serializable(with = InstantSerializer::class)
  public val termsOfUseDate: Instant? = null,
  public val email: String? = null,
  public val mobilePhone: String? = null,
  public val applicationTokens: Map<String, String> = emptyMap(),
  public val authenticationTokens: Map<String, AuthenticationToken> = emptyMap(),
  public val systemMetadata: SystemMetadata? = null,
) : StoredDocument, Principal {
  @Serializable
  public data class SystemMetadata(
    public val roles: Set<String> = emptySet(),
    public val isAdmin: Boolean,
    public val inheritsRoles: Boolean,
  )
}
