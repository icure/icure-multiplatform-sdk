package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class RecoveryData(
  override val id: String,
  override val rev: String? = null,
  public val recipient: String,
  public val encryptedSelf: String,
  public val type: RecoveryData.Type,
  public val expirationInstant: Long? = null,
  override val deletionDate: Long? = null,
) : StoredDocument
