package com.icure.sdk.model.filter.healthelement

import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class HealthElementByHcPartyTagCodeFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val codeType: String? = null,
  public val codeCode: String? = null,
  public val tagType: String? = null,
  public val tagCode: String? = null,
  public val status: Int? = null,
) : AbstractFilter<HealthElement>
