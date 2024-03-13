package com.icure.sdk.model.filter

import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifiableDto

@Serializable
public data class IdsFilter<O : IdentifiableDto<String>>(
  override val desc: String? = null,
  override val ids: Set<String> = emptySet(),
) : AbstractFilter<O>, Filter.IdsFilter<String, O>
