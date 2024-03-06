package com.icure.sdk.model.base

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public interface Versionable<T> : Identifiable<T> {
  public val rev: String?
}
