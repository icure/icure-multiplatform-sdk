package com.icure.sdk.model.gui

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class Formula(
  public val `value`: String? = null,
  public val lifecycle: FormLifecycle? = null,
)
