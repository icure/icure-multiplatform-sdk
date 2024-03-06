package com.icure.sdk.model.embed

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class Partnership(
  public val type: PartnershipType? = null,
  public val status: PartnershipStatus? = null,
  public val partnerId: String? = null,
  public val meToOtherRelationshipDescription: String? = null,
  public val otherToMeRelationshipDescription: String? = null,
) : IoSerializable
