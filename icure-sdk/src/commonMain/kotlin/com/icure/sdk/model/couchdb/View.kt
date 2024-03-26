package com.icure.sdk.model.couchdb

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class View(
  public val map: String,
  public val reduce: String? = null,
)
