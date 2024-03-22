package com.icure.sdk.model.requests.document

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class BulkAttachmentUpdateOptions(
  public val updateAttachmentsMetadata: Map<String, AttachmentMetadata> = emptyMap(),
  public val deleteAttachments: Set<String> = emptySet(),
) {
  @Serializable
  public data class AttachmentMetadata(
    public val utis: List<String> = emptyList(),
    public val dataIsEncrypted: Boolean? = null,
  )
	// region BulkAttachmentUpdateOptions-BulkAttachmentUpdateOptions
	// endregion
}