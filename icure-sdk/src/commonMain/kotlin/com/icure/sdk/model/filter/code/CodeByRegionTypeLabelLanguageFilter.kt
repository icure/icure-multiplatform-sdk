package com.icure.sdk.model.filter.code

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class CodeByRegionTypeLabelLanguageFilter(
  override val desc: String? = null,
  public val region: String? = null,
  public val type: String,
  public val language: String,
  public val label: String? = null,
) : AbstractFilter<Code>
