package com.icure.sdk.model.base

import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public interface HasTags {
  public val tags: Set<CodeStub>
}
