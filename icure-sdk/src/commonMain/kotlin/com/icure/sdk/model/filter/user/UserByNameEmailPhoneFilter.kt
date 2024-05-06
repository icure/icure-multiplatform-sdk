package com.icure.sdk.model.filter.user

import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.sdk.model.User

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("UserByNameEmailPhoneFilter")
@Serializable
data class UserByNameEmailPhoneFilter(
	public val searchString: String,
	override val desc: String? = null,
) : AbstractFilter<O> {
	// region UserByNameEmailPhoneFilter-UserByNameEmailPhoneFilter

	// endregion
}
