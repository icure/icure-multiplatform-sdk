package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
enum class DeactivationReason() {
  @SerialName("deceased")
  Deceased,
  @SerialName("moved")
  Moved,
  @SerialName("other_doctor")
  OtherDoctor,
  @SerialName("retired")
  Retired,
  @SerialName("no_contact")
  NoContact,
  @SerialName("unknown")
  Unknown,
  @SerialName("none")
  None,

}