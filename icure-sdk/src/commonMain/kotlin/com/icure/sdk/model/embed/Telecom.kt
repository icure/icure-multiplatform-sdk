package com.icure.sdk.model.embed

import kotlin.Comparable
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Telecom(
  public val telecomType: TelecomType? = null,
  public val telecomNumber: String? = null,
  public val telecomDescription: String? = null,
  override val encryptedSelf: String? = null,
) : Encrypted, Comparable<Telecom>
