package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.collections.Map
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class CalendarItemType(
    override val id: String,
    override val rev: String? = null,
    override val deletionDate: Long? = null,
    public val name: String? = null,
    public val color: String? = null,
    public val duration: Int = 0,
    public val externalRef: String? = null,
    public val mikronoId: String? = null,
    public val docIds: Set<String> = emptySet(),
    public val otherInfos: Map<String, String> = emptyMap(),
    public val subjectByLanguage: Map<String, String> = emptyMap(),
) : StoredDocument {
	// region CalendarItemType-CalendarItemType

	// endregion
}
