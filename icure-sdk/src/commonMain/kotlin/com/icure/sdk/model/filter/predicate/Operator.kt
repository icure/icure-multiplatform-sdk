package com.icure.sdk.model.filter.predicate

import com.icure.sdk.utils.DefaultValue
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
	@DefaultValue("==")
	Equal("=="),

	@SerialName("NOTEQUAL")
	@DefaultValue("!=")
	Notequal("!="),

	@SerialName("GREATERTHAN")
	@DefaultValue(">")
	Greaterthan(">"),

	@SerialName("SMALLERTHAN")
	@DefaultValue("<")
	Smallerthan("<"),

	@SerialName("GREATERTHANOREQUAL")
	@DefaultValue(">=")
	Greaterthanorequal(">="),

	@SerialName("SMALLERTHANOREQUAL")
	@DefaultValue("<=")
	Smallerthanorequal("<="),

	@SerialName("LIKE")
	@DefaultValue("%=")
	Like("%="),

	@SerialName("ILIKE")
	@DefaultValue("%%=")
	Ilike("%%="),
}
