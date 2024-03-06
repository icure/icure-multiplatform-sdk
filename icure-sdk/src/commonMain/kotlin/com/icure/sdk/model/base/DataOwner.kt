package com.icure.sdk.model.base

import com.icure.sdk.model.PropertyStub
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public interface DataOwner {
  public val properties: Set<PropertyStub>
}
