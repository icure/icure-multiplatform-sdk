package com.icure.sdk.model

import com.icure.sdk.model.base.Principal
import com.icure.sdk.model.base.StoredDocument
import kotlinx.serialization.Serializable
import kotlin.Long
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class Role(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	override val name: String? = null,
	public val permissions: Set<String> = emptySet(),
) : StoredDocument, Principal {
	override val properties: Set<PropertyStub> = emptySet()
	// region Role-Role

	// endregion
}
