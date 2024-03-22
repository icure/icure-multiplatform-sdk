package com.icure.sdk.model.filter.code

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("AllCodesFilter")
@Serializable
public data class AllCodesFilter(
  override val desc: String? = null,
) : AbstractFilter<Code>, Filter.AllFilter<Code>
