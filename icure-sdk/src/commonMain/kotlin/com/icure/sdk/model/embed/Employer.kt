package com.icure.sdk.model.embed

import com.icure.sdk.model.base.Named
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Employer(
  override val name: String? = null,
  public val addresse: Address? = null,
) : Named
