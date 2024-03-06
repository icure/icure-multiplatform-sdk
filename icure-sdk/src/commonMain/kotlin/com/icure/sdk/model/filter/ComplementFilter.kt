package com.icure.sdk.model.filter

import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifiableDto

@Serializable
public data class ComplementFilter<O : IdentifiableDto<String>>(
  override val desc: String? = null,
  override val superSet: AbstractFilter<O>,
  override val subSet: AbstractFilter<O>,
) : AbstractFilter<O>, Filter.ComplementFilter<O>
