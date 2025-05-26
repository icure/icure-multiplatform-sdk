package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.List

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ListOfIdsAndRev(
	public val ids: List<IdWithRev>,
) {
	public val dtoSerialName: String
	// region ListOfIdsAndRev-ListOfIdsAndRev

	companion object {
		operator fun invoke(ids: List<StoredDocumentIdentifier>) = ListOfIdsAndRev(ids.map { IdWithRev(it.id, it.rev) })
	}
	// endregion
}
