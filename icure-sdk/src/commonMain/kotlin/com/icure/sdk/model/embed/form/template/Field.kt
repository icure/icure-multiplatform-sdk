package com.icure.sdk.model.embed.form.template

import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public open class Field(
  public val `field`: String,
  public val shortLabel: String? = null,
  public val rows: Int? = null,
  public val columns: Int? = null,
  public val grows: Boolean? = null,
  public val schema: String? = null,
  public val tags: List<String>? = null,
  public val codifications: List<String>? = null,
  public val options: Map<String, Any?>? = null,
  public val hideCondition: String? = null,
  public val required: Boolean? = null,
  public val multiline: Boolean? = null,
  public val `value`: String? = null,
  public val labels: Map<String, Any?>? = null,
  public val unit: String? = null,
  public val now: Boolean? = null,
  public val translate: Boolean? = null,
) : StructureElement
