package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlinx.serialization.Serializable

@Serializable
public data class Periodicity(
  public val relatedCode: CodeStub? = null,
  public val relatedPeriodicity: CodeStub? = null,
)
