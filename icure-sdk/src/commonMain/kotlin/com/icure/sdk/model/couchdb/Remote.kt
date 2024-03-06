package com.icure.sdk.model.couchdb

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Remote(
  public val url: String,
  public val auth: RemoteAuthentication? = null,
)
