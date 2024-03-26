package com.icure.sdk.model.embed.form.template

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class Launcher(
  public val name: String,
  public val triggerer: Trigger,
  public val shouldPassValue: Boolean,
)
