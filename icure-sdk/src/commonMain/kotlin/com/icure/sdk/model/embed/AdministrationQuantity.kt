package com.icure.sdk.model.embed

import com.icure.sdk.model.base.CodeStub
import kotlin.Double
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class AdministrationQuantity(
  public val quantity: Double? = null,
  public val administrationUnit: CodeStub? = null,
  public val unit: String? = null,
)
