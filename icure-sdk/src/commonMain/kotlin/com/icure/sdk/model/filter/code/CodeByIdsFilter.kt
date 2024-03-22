package com.icure.sdk.model.filter.code

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("CodeByIdsFilter")
@Serializable
public data class CodeByIdsFilter(
  override val ids: Set<String> = emptySet(),
  override val desc: String? = null,
) : AbstractFilter<Code>, Filter.IdsFilter<String, Code>
