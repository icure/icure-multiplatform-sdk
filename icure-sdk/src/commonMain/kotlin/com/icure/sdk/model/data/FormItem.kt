package com.icure.sdk.model.`data`

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v1.dto.CodeDto

@Serializable
public open class FormItem(
  public val label: String? = null,
  public val index: Int? = null,
  public val guid: String? = null,
  public val tags: List<CodeDto>? = null,
)
