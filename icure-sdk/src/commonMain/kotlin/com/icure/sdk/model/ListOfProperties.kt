package com.icure.sdk.model

import kotlinx.serialization.Serializable
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class ListOfProperties(
    public val properties: Set<PropertyStub> = emptySet(),
) {
	// region ListOfProperties-ListOfProperties

	// endregion
}
