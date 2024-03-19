package com.icure.sdk.model.embed.form.template

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).

@Serializable
data class Action(
  public val launchers: List<Launcher>? = null,
  public val expression: String? = null,
  public val states: List<State>? = null,
) {
	// region Action-Action
	// endregion
}