package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Double
import kotlinx.serialization.Serializable

@Serializable
public data class Duration(
  public val `value`: Double? = null,
  public val unit: CodeStub? = null,
)
