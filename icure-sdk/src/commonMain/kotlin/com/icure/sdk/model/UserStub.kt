package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.enums.UsersStatus
import com.icure.sdk.model.enums.UsersType
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class UserStub(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val name: String? = null,
  public val type: UsersType? = null,
  public val status: UsersStatus? = null,
  public val login: String? = null,
  public val groupId: String? = null,
  public val healthcarePartyId: String? = null,
  public val patientId: String? = null,
  public val email: String? = null,
) : StoredDocument
