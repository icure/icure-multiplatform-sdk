package com.icure.sdk.model.embed.form.template

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v1.dto.embed.form.template.StateToUpdate

@Serializable
public class State(
  public val name: String,
  public val stateToUpdate: StateToUpdate,
  public val canLaunchLauncher: Boolean,
)
