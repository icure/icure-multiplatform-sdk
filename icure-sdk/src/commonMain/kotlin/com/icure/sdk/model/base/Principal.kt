package com.icure.sdk.model.base

import com.icure.sdk.model.PropertyStub
import kotlin.String
import kotlin.collections.Set

public interface Principal : Identifiable<String>, Named {
  public val properties: Set<PropertyStub>
}
