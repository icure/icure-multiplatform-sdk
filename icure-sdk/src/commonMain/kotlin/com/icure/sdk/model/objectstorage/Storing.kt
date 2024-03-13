package com.icure.sdk.model.objectstorage

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Storing(
  public val nextByte: Long,
  public val md5HashHexString: String? = null,
) : StoredObjectInformation
