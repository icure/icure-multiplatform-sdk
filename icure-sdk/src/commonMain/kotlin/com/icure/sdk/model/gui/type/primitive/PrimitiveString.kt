package com.icure.sdk.model.gui.type.primitive

import com.icure.sdk.model.gui.type.Data
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public open class PrimitiveString(
  public val `value`: String? = null,
) : Data, Primitive
