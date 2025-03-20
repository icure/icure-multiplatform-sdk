package com.icure.cardinal.sdk.model.filter.predicate

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public enum class Operator(
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
