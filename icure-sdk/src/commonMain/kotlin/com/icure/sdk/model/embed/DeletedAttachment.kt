package com.icure.sdk.model.embed

import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class DeletedAttachment(
  public val couchDbAttachmentId: String? = null,
  public val objectStoreAttachmentId: String? = null,
  public val key: String? = null,
  public val deletionTime: Long? = null,
)
