package com.icure.sdk.model

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class UserGroup(
  public val groupId: String? = null,
  public val groupName: String? = null,
  public val groupsHierarchy: List<Group> = emptyList(),
  public val userId: String? = null,
  public val login: String? = null,
  public val name: String? = null,
  public val email: String? = null,
  public val phone: String? = null,
  public val patientId: String? = null,
  public val healthcarePartyId: String? = null,
  public val deviceId: String? = null,
  public val nameOfParentOfTopmostGroupInHierarchy: String? = null,
)
