package com.icure.sdk.model.embed

import com.icure.sdk.model.specializations.Base64String

public interface Encryptable {
  public val encryptedSelf: Base64String?
}
