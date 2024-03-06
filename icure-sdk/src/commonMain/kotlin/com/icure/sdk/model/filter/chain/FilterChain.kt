package com.icure.sdk.model.filter.chain

import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.predicate.Predicate
import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifiableDto

@Serializable
public data class FilterChain<O : IdentifiableDto<String>>(
  public val filter: AbstractFilter<O>,
  public val predicate: Predicate? = null,
)
