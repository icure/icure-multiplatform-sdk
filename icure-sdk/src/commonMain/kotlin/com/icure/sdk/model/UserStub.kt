package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import kotlin.Cloneable
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.constants.Users

@Serializable
public data class UserStub(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val name: String? = null,
  public val type: Users.Type? = null,
  public val status: Users.Status? = null,
  public val login: String? = null,
  public val groupId: String? = null,
  public val healthcarePartyId: String? = null,
  public val patientId: String? = null,
  public val email: String? = null,
) : StoredDocument, Cloneable
