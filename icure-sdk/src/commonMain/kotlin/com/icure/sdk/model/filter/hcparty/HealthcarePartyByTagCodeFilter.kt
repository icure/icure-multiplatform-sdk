package com.icure.sdk.model.filter.hcparty

import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("HealthcarePartyByTagCodeFilter")
@Serializable
public data class HealthcarePartyByTagCodeFilter(
  public val tagType: String? = null,
  public val tagCode: String? = null,
  public val codeType: String? = null,
  public val codeCode: String? = null,
  override val desc: String? = null,
) : AbstractFilter<HealthcareParty>
