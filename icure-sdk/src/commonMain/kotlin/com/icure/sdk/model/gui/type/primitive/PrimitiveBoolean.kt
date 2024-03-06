package com.icure.sdk.model.gui.type.primitive

import com.icure.sdk.model.gui.type.Data
import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public class PrimitiveBoolean(
  public val `value`: Boolean? = null,
) : Data, Primitive
