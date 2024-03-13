package com.icure.sdk.model.embed.form.template

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class FormTemplateLayout(
  public val form: String,
  public val actions: List<Action> = emptyList(),
  public val sections: List<Section> = emptyList(),
  public val description: String? = null,
  public val keywords: List<String>? = null,
)
