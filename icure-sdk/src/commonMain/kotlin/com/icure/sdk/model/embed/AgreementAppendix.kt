package com.icure.sdk.model.embed

import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class AgreementAppendix(
  public val docSeq: Int? = null,
  public val verseSeq: Int? = null,
  public val documentId: String? = null,
  public val path: String? = null,
)
