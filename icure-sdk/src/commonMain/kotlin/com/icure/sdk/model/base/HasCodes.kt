package com.icure.sdk.model.base

import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public interface HasCodes {
  public val codes: Set<CodeStub>
}
