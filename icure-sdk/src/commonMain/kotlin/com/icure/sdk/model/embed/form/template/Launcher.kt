package com.icure.sdk.model.embed.form.template

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v1.dto.embed.form.template.Trigger

@Serializable
public class Launcher(
  public val name: String,
  public val triggerer: Trigger,
  public val shouldPassValue: Boolean,
)
