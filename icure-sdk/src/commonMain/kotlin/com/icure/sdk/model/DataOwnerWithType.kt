package com.icure.sdk.model

import com.icure.sdk.model.base.CryptoActor
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public interface DataOwnerWithType : IoSerializable {
  public val dataOwner: CryptoActor
}
