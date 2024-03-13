package com.icure.sdk.model

import com.icure.sdk.model.base.CryptoActor
import kotlinx.serialization.Serializable

@Serializable
public interface DataOwnerWithType {
  public val dataOwner: CryptoActor
}
