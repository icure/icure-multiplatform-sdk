package com.icure.sdk.model.`data`

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import org.taktik.icure.services.`external`.rest.v1.dto.CodeDto
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public open class FormItem(
  public val label: String? = null,
  public val index: Int? = null,
  public val guid: String? = null,
  public val tags: List<CodeDto>? = null,
) : IoSerializable
