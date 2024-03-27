package com.icure.sdk.model.filter.user

import com.icure.sdk.model.User
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("UserByIdsFilter")
@Serializable
data class UserByIdsFilter(
    override val ids: Set<String> = emptySet(),
    override val desc: String? = null,
) : AbstractFilter<User>, Filter.IdsFilter<String, User> {
    // region UserByIdsFilter-UserByIdsFilter

    // endregion
}
