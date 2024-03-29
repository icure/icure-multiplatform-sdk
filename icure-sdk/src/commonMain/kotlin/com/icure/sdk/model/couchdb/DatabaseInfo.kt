package com.icure.sdk.model.couchdb

import kotlinx.serialization.Serializable
import kotlin.Int
import kotlin.Long
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class DatabaseInfo(
	public val id: String,
	public val updateSeq: String?,
	public val fileSize: Long?,
	public val externalSize: Long?,
	public val activeSize: Long?,
	public val docs: Long?,
	public val q: Int?,
	public val n: Int?,
	public val w: Int?,
	public val r: Int?,
) {
	// region DatabaseInfo-DatabaseInfo

	// endregion
}
