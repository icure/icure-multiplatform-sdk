package com.icure.sdk.model.embed.form.template

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class State(
  public val name: String,
  public val stateToUpdate: StateToUpdate,
  public val canLaunchLauncher: Boolean,
)
