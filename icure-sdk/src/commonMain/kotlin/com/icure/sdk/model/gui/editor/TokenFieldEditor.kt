package com.icure.sdk.model.gui.editor

import com.icure.sdk.model.gui.Editor
import kotlin.Boolean
import kotlinx.serialization.Serializable

@Serializable
public class TokenFieldEditor(
  public val preventautopanel: Boolean? = null,
  public val preventvaluedate: Boolean? = null,
) : Editor
