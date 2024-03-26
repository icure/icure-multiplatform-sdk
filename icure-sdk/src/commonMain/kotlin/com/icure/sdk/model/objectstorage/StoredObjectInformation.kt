package com.icure.sdk.model.objectstorage

import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public sealed interface StoredObjectInformation {
  @Serializable
  @SerialName("Available")
  public data class Available(
    public val md5HashHexString: String,
  ) : StoredObjectInformation

  @Serializable
  @SerialName("Storing")
  public data class Storing(
    public val nextByte: Long,
    public val md5HashHexString: String? = null,
  ) : StoredObjectInformation

  @Serializable
  @SerialName("NotStored")
  public data object NotStored : StoredObjectInformation
}
