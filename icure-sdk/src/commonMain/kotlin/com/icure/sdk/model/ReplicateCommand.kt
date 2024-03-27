package com.icure.sdk.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ReplicateCommand(
    @SerialName("source_url")
    public val sourceUrl: String,
    @SerialName("source_username")
    public val sourceUsername: String,
    @SerialName("source_password")
    public val sourcePassword: String,
    @SerialName("target_url")
    public val targetUrl: String,
    @SerialName("target_username")
    public val targetUsername: String,
    @SerialName("target_password")
    public val targetPassword: String,
    public val id: String? = null,
)
