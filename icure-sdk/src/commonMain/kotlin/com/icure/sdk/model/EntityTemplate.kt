package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.serialization.EntityTemplateSerializer
import kotlinx.serialization.Serializable
import kotlin.Any
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable(with = EntityTemplateSerializer::class)
data class EntityTemplate(
	override val id: String,
	override val rev: String? = null,
	override val deletionDate: Long? = null,
	public val userId: String? = null,
	public val descr: String? = null,
	public val keywords: Set<String>? = null,
	public val entityType: String? = null,
	public val subType: String? = null,
	public val defaultTemplate: Boolean? = null,
	public val entity: List<Map<String, Any>> = emptyList(),
) : StoredDocument {
	// region EntityTemplate-EntityTemplate

	// endregion
}
