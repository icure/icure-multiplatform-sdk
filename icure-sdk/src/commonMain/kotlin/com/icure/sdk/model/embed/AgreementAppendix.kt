package com.icure.sdk.model.embed

import kotlin.Int
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class AgreementAppendix(
  public val docSeq: Int? = null,
  public val verseSeq: Int? = null,
  public val documentId: String? = null,
  public val path: String? = null,
) : IoSerializable
