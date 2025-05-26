package com.icure.cardinal.sdk.model.filter.form

import com.icure.cardinal.sdk.model.Form
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("FormByDataOwnerParentIdFilter")
@Serializable
data class FormByDataOwnerParentIdFilter(
	public val dataOwnerId: String,
	public val parentId: String,
	override val desc: String? = null,
) : AbstractFilter<Form> {
	public val dtoSerialName: String
	// region FormByDataOwnerParentIdFilter-FormByDataOwnerParentIdFilter

	// endregion
}
