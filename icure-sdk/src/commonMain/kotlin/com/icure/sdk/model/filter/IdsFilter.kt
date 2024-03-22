package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("IdsFilter")
@Serializable
public data class IdsFilter<O : Identifiable<String>>(
  override val desc: String? = null,
  override val ids: Set<String> = emptySet(),
) : AbstractFilter<O>, Filter.IdsFilter<String, O>
