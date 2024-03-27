package com.icure.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Map

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DesignDocument(
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
