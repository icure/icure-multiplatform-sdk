package com.icure.sdk.model.filter.healthelement

import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("HealthElementByIdsFilter")
@Serializable
public data class HealthElementByIdsFilter(
  override val ids: Set<String> = emptySet(),
  override val desc: String? = null,
) : AbstractFilter<HealthElement>, Filter.IdsFilter<String, HealthElement>
