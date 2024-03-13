package com.icure.sdk.model.gui

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public class Suggest(
  public val filterKey: String? = null,
  public val filterValue: String? = null,
  public val entityClass: String? = null,
  public val fieldValue: String? = null,
  public val fieldDisplay: String? = null,
)
