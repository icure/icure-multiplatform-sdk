package com.icure.sdk.model.requests.document

import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import java.io.Serializable as IoSerializable
import kotlinx.serialization.Serializable as SerializationSerializable

@SerializationSerializable
public data class BulkAttachmentUpdateOptions(
  public val updateAttachmentsMetadata: Map<String, BulkAttachmentUpdateOptions.AttachmentMetadata>
      = emptyMap(),
  public val deleteAttachments: Set<String> = emptySet(),
) : IoSerializable
