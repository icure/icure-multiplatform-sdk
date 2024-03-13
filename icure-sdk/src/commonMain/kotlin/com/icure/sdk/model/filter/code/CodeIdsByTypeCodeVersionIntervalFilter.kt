package com.icure.sdk.model.filter.code

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class CodeIdsByTypeCodeVersionIntervalFilter(
  override val desc: String? = null,
  public val startType: String? = null,
  public val startCode: String? = null,
  public val startVersion: String? = null,
  public val endType: String? = null,
  public val endCode: String? = null,
  public val endVersion: String? = null,
) : AbstractFilter<Code>
