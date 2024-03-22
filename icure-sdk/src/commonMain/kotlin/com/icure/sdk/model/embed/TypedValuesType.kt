package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class TypedValuesType() {
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