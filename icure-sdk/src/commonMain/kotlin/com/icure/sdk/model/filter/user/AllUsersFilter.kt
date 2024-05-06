package com.icure.sdk.model.filter.user

import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import com.icure.sdk.model.User

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AllUsersFilter")
@Serializable
data class AllUsersFilter(
	override val desc: String? = null,
) : AbstractFilter<O>, Filter.AllFilter<O> {
	// region AllUsersFilter-AllUsersFilter

	// endregion
}
