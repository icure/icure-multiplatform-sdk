package com.icure.sdk.model.gui.type.primitive

import com.icure.sdk.model.gui.type.Data
import java.util.Date
import kotlinx.serialization.Serializable

@Serializable
public class PrimitiveDate(
  public val `value`: Date? = null,
) : Data, Primitive
