package com.icure.sdk.model.filter

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.utils.ExternalFilterKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ExternalViewFilter")
@Serializable
data class ExternalViewFilter(
	override val desc: String? = null,
	public val view: String,
	public val partition: String,
	public val entityQualifiedName: String,
	public val startKey: ExternalFilterKey<*>?,
	public val endKey: ExternalFilterKey<*>?,
) : AbstractFilter<Identifiable<String>> {
	// region ExternalViewFilter-ExternalViewFilter

	// endregion
}
