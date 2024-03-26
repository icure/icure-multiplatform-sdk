package com.icure.sdk.model.base

import kotlin.Long
import kotlin.String

public interface StoredDocument : Versionable<String> {
  public val deletionDate: Long?
}
