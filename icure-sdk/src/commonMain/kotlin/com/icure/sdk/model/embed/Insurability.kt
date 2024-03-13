package com.icure.sdk.model.embed

import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class Insurability(
  public val parameters: Map<String, String> = emptyMap(),
  public val hospitalisation: Boolean? = null,
  public val ambulatory: Boolean? = null,
  public val dental: Boolean? = null,
  public val identificationNumber: String? = null,
  public val insuranceId: String? = null,
  public val startDate: Long? = null,
  public val endDate: Long? = null,
  public val titularyId: String? = null,
  override val encryptedSelf: String? = null,
) : Encrypted
