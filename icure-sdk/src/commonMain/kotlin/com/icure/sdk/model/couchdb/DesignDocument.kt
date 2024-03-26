package com.icure.sdk.model.couchdb

import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class DesignDocument(
  public val id: String,
  public val rev: String? = null,
  public val revHistory: Map<String, String> = emptyMap(),
  public val language: String? = null,
  public val views: Map<String, View> = emptyMap(),
  public val lists: Map<String, String> = emptyMap(),
  public val shows: Map<String, String> = emptyMap(),
  public val updateHandlers: Map<String, String>? = null,
  public val filters: Map<String, String> = emptyMap(),
)
