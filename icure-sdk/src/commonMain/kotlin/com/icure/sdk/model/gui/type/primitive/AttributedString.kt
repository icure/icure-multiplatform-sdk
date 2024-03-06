package com.icure.sdk.model.gui.type.primitive

import com.icure.sdk.model.gui.type.Data
import kotlin.ByteArray
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class AttributedString(
  public val rtfString: String? = null,
  public val rtfData: ByteArray? = null,
) : Data, Primitive
