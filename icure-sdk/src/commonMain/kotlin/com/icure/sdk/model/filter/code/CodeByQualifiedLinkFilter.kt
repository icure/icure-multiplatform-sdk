package com.icure.sdk.model.filter.code

import com.icure.sdk.model.Code
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("CodeByQualifiedLinkFilter")
@Serializable
data class CodeByQualifiedLinkFilter(
	public val linkType: String,
	public val linkedId: String? = null,
	override val desc: String? = null,
) : AbstractFilter<Code> {
	// region CodeByQualifiedLinkFilter-CodeByQualifiedLinkFilter
	// endregion
}
