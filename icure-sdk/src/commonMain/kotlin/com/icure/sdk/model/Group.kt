package com.icure.sdk.model

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.HasTags
import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.embed.AuthenticationClass
import com.icure.sdk.model.embed.UserType
import com.icure.sdk.model.security.OperationToken
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class Group(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  override val tags: Set<CodeStub> = emptySet(),
  public val name: String? = null,
  public val password: String? = null,
  public val servers: List<String>? = null,
  public val superAdmin: Boolean,
  public val properties: Set<PropertyStub> = emptySet(),
  public val defaultUserRoles: Map<UserType, Set<String>> = emptyMap(),
  public val operationTokens: Map<String, OperationToken> = emptyMap(),
  public val sharedEntities: Map<String, String> = emptyMap(),
  public val minimumKrakenVersion: String? = null,
  public val minimumAuthenticationClassForElevatedPrivileges: AuthenticationClass,
  public val superGroup: String? = null,
) : StoredDocument, HasTags
