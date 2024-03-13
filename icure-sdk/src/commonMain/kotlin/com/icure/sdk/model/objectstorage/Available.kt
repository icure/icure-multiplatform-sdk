package com.icure.sdk.model.objectstorage

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class Available(
  public val md5HashHexString: String,
) : StoredObjectInformation
