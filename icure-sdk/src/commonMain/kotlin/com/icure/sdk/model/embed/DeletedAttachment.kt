package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class DeletedAttachment(
  public val couchDbAttachmentId: String? = null,
  public val objectStoreAttachmentId: String? = null,
  public val key: String? = null,
  public val deletionTime: Long? = null,
) : IoSerializable
