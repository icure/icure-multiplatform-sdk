package com.icure.sdk.model.filter.group

import com.icure.sdk.model.Group
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("GroupWithContentFilter")
@Serializable
data class GroupWithContentFilter(
	public val superGroupId: String,
	public val searchString: String,
	override val desc: String? = null,
) : AbstractFilter<Group> {
	// region GroupWithContentFilter-GroupWithContentFilter

	// endregion
}
