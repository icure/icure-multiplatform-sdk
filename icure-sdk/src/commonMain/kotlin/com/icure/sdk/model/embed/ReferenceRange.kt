package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ReferenceRange(
  public val low: Double? = null,
  public val high: Double? = null,
  public val stringValue: String? = null,
  public val tags: List<CodeStub> = emptyList(),
  public val codes: List<CodeStub> = emptyList(),
  public val notes: List<Annotation> = emptyList(),
  public val age: Range? = null,
)
