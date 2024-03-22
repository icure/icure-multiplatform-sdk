package com.icure.sdk.model.embed.form.template

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, you changes will be lost.
// If you want to change the way this class is generated, see [this repo](TODO: URL HERE).

@Serializable
enum class StateToUpdate() {
  @SerialName("VALUE")
  Value,
  @SerialName("VISIBLE")
  Visible,
  @SerialName("READONLY")
  Readonly,
  @SerialName("CLAZZ")
  Clazz,
  @SerialName("REQUIRED")
  Required,

}