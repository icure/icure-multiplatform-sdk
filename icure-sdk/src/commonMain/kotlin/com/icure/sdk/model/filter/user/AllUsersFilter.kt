package com.icure.sdk.model.filter.user

import com.icure.sdk.model.User
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class AllUsersFilter(
  override val desc: String? = null,
) : AbstractFilter<User>, Filter.AllFilter<User>
