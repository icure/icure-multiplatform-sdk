package com.icure.sdk.model.requests.document

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

@Serializable
public data class BulkAttachmentUpdateOptions(
  public val updateAttachmentsMetadata: Map<String, AttachmentMetadata> = emptyMap(),
  public val deleteAttachments: Set<String> = emptySet(),
) {
  @Serializable
  public data class AttachmentMetadata(
    public val utis: List<String> = emptyList(),
    public val dataIsEncrypted: Boolean? = null,
  )
}
