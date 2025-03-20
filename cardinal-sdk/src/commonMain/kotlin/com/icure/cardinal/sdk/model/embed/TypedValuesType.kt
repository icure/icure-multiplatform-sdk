package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class TypedValuesType() {
	@SerialName("BOOLEAN")
	Boolean,

	@SerialName("INTEGER")
	Integer,

	@SerialName("DOUBLE")
	Double,

	@SerialName("STRING")
	String,

	@SerialName("DATE")
	Date,

	@SerialName("CLOB")
	Clob,

	@SerialName("JSON")
	Json,
}
