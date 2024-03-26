package com.icure.sdk.model.embed.form.template

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class Section(
  public val section: String,
  public val fields: List<StructureElement> = emptyList(),
  public val description: String? = null,
  public val keywords: List<String>? = null,
)
