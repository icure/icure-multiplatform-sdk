package com.icure.sdk.model.couchdb

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class DocIdentifier(
  public val id: String? = null,
  public val rev: String? = null,
)
