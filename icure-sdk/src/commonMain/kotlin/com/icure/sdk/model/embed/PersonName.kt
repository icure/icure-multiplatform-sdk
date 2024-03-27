package com.icure.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class PersonName(
    public val lastName: String? = null,
    public val firstNames: List<String> = emptyList(),
    public val start: Long? = null,
    public val end: Long? = null,
    public val prefix: List<String> = emptyList(),
    public val suffix: List<String> = emptyList(),
    public val text: String? = null,
    public val use: PersonNameUse? = null,
)
