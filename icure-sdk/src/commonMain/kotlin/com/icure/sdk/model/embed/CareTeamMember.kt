package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.base.Identifiable
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public sealed interface CareTeamMember : Encrypted, Identifiable<String> {
  override val id: String

  public val careTeamMemberType: CareTeamMemberType?

  public val healthcarePartyId: String?

  public val quality: CodeStub?

  override val encryptedSelf: String?
}

public data class DecryptedCareTeamMember(
  override val id: String,
  override val careTeamMemberType: CareTeamMemberType? = null,
  override val healthcarePartyId: String? = null,
  override val quality: CodeStub? = null,
  override val encryptedSelf: String? = null,
) : CareTeamMember

public data class EncryptedCareTeamMember(
  override val id: String,
  override val careTeamMemberType: CareTeamMemberType? = null,
  override val healthcarePartyId: String? = null,
  override val quality: CodeStub? = null,
  override val encryptedSelf: String? = null,
) : CareTeamMember

public fun CareTeamMember.copy(
  id: String = this.id,
  careTeamMemberType: CareTeamMemberType? = this.careTeamMemberType,
  healthcarePartyId: String? = this.healthcarePartyId,
  quality: CodeStub? = this.quality,
  encryptedSelf: String? = this.encryptedSelf,
): CareTeamMember {
                                      return when(this) {
                                          is DecryptedCareTeamMember -> copy(id = id,
          careTeamMemberType = careTeamMemberType, healthcarePartyId = healthcarePartyId, quality =
          quality, encryptedSelf = encryptedSelf)
      is EncryptedCareTeamMember -> copy(id = id, careTeamMemberType = careTeamMemberType,
          healthcarePartyId = healthcarePartyId, quality = quality, encryptedSelf = encryptedSelf)
                                          }
}
