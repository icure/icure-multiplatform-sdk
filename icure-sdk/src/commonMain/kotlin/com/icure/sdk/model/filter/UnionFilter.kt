package com.icure.sdk.model.filter

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifiableDto

@Serializable
public data class UnionFilter<O : IdentifiableDto<String>>(
  override val desc: String? = null,
  override val filters: List<AbstractFilter<O>> = emptyList(),
) : AbstractFilter<O>, Filter.UnionFilter<O>
