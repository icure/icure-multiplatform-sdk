package com.icure.sdk.model.embed

import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class IdentityDocumentReader(
  public val justificatifDocumentNumber: String? = null,
  public val supportSerialNumber: String? = null,
  public val timeReadingEIdDocument: Long? = null,
  public val eidDocumentSupportType: Int = 0,
  public val reasonManualEncoding: Int = 0,
  public val reasonUsingVignette: Int = 0,
)
