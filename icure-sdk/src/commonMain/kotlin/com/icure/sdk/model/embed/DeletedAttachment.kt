package com.icure.sdk.model.embed

import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DeletedAttachment(
    public val couchDbAttachmentId: String? = null,
    public val objectStoreAttachmentId: String? = null,
    public val key: String? = null,
    public val deletionTime: Long? = null,
) {
    // region DeletedAttachment-DeletedAttachment

    // endregion
}
