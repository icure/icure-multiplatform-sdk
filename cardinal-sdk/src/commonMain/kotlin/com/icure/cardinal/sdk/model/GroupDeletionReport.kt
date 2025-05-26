package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class GroupDeletionReport(
	public val type: String,
	public val id: String,
	public val server: String,
	internal val dtoSerialName: String,
) {
	// region GroupDeletionReport-GroupDeletionReport

	// endregion
}
