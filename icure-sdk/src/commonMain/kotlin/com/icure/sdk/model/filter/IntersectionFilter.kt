package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("IntersectionFilter")
@Serializable
public data class IntersectionFilter<O : Identifiable<String>>(
  override val desc: String? = null,
  override val filters: List<AbstractFilter<O>> = emptyList(),
) : AbstractFilter<O>, Filter.IntersectionFilter<O>
