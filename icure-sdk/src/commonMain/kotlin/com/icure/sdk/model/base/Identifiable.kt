package com.icure.sdk.model.base

import kotlinx.serialization.Serializable

@Serializable
public interface Identifiable<T> {
  public val id: T
}
