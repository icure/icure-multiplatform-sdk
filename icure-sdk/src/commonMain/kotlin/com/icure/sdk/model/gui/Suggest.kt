package com.icure.sdk.model.gui

import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public class Suggest(
  public val filterKey: String? = null,
  public val filterValue: String? = null,
  public val entityClass: String? = null,
  public val fieldValue: String? = null,
  public val fieldDisplay: String? = null,
) : IoSerializable
