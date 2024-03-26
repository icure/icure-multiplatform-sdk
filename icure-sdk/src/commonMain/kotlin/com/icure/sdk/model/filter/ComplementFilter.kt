package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class ComplementFilter<O : Identifiable<String>>(
  override val desc: String? = null,
  override val superSet: AbstractFilter<O>,
  override val subSet: AbstractFilter<O>,
) : AbstractFilter<O>, Filter.ComplementFilter<O>
