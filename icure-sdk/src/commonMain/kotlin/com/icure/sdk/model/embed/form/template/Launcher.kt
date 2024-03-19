package com.icure.sdk.model.embed.form.template

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v1.dto.embed.form.template.Trigger

// WARNING: This file is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).

@Serializable
class Launcher(
  public val name: String,
  public val triggerer: Trigger,
  public val shouldPassValue: Boolean,
) {
	// region Launcher-Launcher
	// endregion
}