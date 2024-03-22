package com.icure.sdk.model.embed.form.template

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class Action(
  public val launchers: List<Launcher>? = null,
  public val expression: String? = null,
  public val states: List<State>? = null,
)
