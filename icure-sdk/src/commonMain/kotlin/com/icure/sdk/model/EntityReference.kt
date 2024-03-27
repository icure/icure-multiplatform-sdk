package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class EntityReference(
    override val id: String,
    override val rev: String? = null,
    override val deletionDate: Long? = null,
    public val docId: String? = null,
) : StoredDocument {
	// region EntityReference-EntityReference

	// endregion
}
