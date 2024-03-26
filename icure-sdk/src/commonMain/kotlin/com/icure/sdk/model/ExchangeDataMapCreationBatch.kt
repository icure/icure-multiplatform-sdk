package com.icure.sdk.model

import com.icure.sdk.model.specializations.AccessControlKeyHexString
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.KeypairFingerprintV2String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class ExchangeDataMapCreationBatch(
  public val batch: Map<AccessControlKeyHexString, Map<KeypairFingerprintV2String, Base64String>> =
      emptyMap(),
)
