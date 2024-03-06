package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public enum class AddressType() : IoSerializable {
  @SerialName("home")
  Home,
  @SerialName("work")
  Work,
  @SerialName("vacation")
  Vacation,
  @SerialName("hospital")
  Hospital,
  @SerialName("clinic")
  Clinic,
  @SerialName("hq")
  Hq,
  @SerialName("other")
  Other,
  @SerialName("temporary")
  Temporary,
  @SerialName("postal")
  Postal,
  @SerialName("diplomatic")
  Diplomatic,
  @SerialName("reference")
  Reference,
  @SerialName("careaddress")
  Careaddress,
}
