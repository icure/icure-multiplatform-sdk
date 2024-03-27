package com.icure.sdk.model.filter.predicate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class Operator(
    public val code: String,
) {
    @SerialName("EQUAL")
    Equal("=="),

    @SerialName("NOTEQUAL")
    Notequal("!="),

    @SerialName("GREATERTHAN")
    Greaterthan(">"),

    @SerialName("SMALLERTHAN")
    Smallerthan("<"),

    @SerialName("GREATERTHANOREQUAL")
    Greaterthanorequal(">="),

    @SerialName("SMALLERTHANOREQUAL")
    Smallerthanorequal("<="),

    @SerialName("LIKE")
    Like("%="),

    @SerialName("ILIKE")
    Ilike("%%="),
}
