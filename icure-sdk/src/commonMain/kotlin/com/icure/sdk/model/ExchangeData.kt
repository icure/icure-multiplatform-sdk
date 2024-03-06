package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.specializations.KeypairFingerprintV2String
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlinx.serialization.Serializable
import com.icure.sdk.model.specializations.Base64String as SpecializationsBase64String
import org.taktik.icure.entities.utils.Base64String as UtilsBase64String

@Serializable
public data class ExchangeData(
  override val id: String,
  override val rev: String? = null,
  public val delegator: String,
  public val `delegate`: String,
  public val exchangeKey: Map<KeypairFingerprintV2String, SpecializationsBase64String> = emptyMap(),
  public val accessControlSecret: Map<KeypairFingerprintV2String, SpecializationsBase64String> =
      emptyMap(),
  public val delegatorSignature: Map<KeypairFingerprintV2String, SpecializationsBase64String> =
      emptyMap(),
  public val sharedSignatureKey: Map<KeypairFingerprintV2String, SpecializationsBase64String> =
      emptyMap(),
  public val sharedSignature: UtilsBase64String,
  override val deletionDate: Long? = null,
) : StoredDocument
