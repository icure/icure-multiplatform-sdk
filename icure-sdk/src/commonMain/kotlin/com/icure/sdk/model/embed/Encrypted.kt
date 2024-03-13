package com.icure.sdk.model.embed

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public interface Encrypted {
  public val encryptedSelf: String?
}
