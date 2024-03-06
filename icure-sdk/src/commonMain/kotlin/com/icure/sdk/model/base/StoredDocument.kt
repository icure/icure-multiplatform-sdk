package com.icure.sdk.model.base

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public interface StoredDocument : Versionable<String> {
  public val deletionDate: Long?
}
