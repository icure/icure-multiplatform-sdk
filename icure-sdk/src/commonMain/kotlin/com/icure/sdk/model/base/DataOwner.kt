package com.icure.sdk.model.base

import com.icure.sdk.model.PropertyStub
import kotlin.collections.Set

public interface DataOwner {
  public val properties: Set<PropertyStub>
}
