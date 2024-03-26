package com.icure.sdk.model

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class PublicKey(
  public val hcPartyId: String? = null,
  public val hexString: String? = null,
)
