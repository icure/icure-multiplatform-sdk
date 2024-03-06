package com.icure.sdk.model.embed.form.template

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class Group(
  public val group: String,
  public val fields: List<StructureElement>? = null,
) : StructureElement
