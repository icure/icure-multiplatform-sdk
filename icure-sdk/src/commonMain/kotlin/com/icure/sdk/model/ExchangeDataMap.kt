package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.KeypairFingerprintV2String
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable

@Serializable
public data class ExchangeDataMap(
  override val id: String,
  override val rev: String? = null,
  public val encryptedExchangeDataIds: Map<KeypairFingerprintV2String, Base64String> = emptyMap(),
  override val deletionDate: Long? = null,
) : StoredDocument
