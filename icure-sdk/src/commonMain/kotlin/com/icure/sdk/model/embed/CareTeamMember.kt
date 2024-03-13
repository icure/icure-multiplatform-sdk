package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifiable
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class CareTeamMember(
  override val id: String,
  public val careTeamMemberType: CareTeamMemberType? = null,
  public val healthcarePartyId: String? = null,
  public val quality: CodeStub? = null,
  override val encryptedSelf: String? = null,
) : Encrypted, Identifiable<String>
