package com.icure.sdk.model.gui.type.primitive

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class Label(
  override val `value`: String? = null,
) : PrimitiveString
