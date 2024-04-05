package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.JsonClassDiscriminator

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("\$type")
interface AbstractFilter<O : Identifiable<String>> : Filter<O> {
	public val desc: String?
	// region AbstractFilter-AbstractFilter

	// endregion
}
