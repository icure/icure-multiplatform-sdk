package com.icure.sdk.model.embed

import kotlinx.serialization.SerialName
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public enum class TelecomType() : IoSerializable {
  @SerialName("mobile")
  Mobile,
  @SerialName("phone")
  Phone,
  @SerialName("email")
  Email,
  @SerialName("fax")
  Fax,
  @SerialName("skype")
  Skype,
  @SerialName("im")
  Im,
  @SerialName("medibridge")
  Medibridge,
  @SerialName("ehealthbox")
  Ehealthbox,
  @SerialName("apicrypt")
  Apicrypt,
  @SerialName("web")
  Web,
  @SerialName("print")
  Print,
  @SerialName("disk")
  Disk,
  @SerialName("other")
  Other,
  @SerialName("pager")
  Pager,
}
