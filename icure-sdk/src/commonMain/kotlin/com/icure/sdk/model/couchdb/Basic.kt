package com.icure.sdk.model.couchdb

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Basic(
  public val username: String,
  public val password: String,
)
