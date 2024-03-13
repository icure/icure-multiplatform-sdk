package com.icure.sdk.model.requests.document

import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class BulkAttachmentUpdateOptions(
  public val updateAttachmentsMetadata: Map<String, BulkAttachmentUpdateOptions.AttachmentMetadata>
      = emptyMap(),
  public val deleteAttachments: Set<String> = emptySet(),
)
