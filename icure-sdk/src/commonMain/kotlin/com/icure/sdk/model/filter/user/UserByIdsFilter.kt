package com.icure.sdk.model.filter.user

import com.icure.sdk.model.User
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("UserByIdsFilter")
@Serializable
public data class UserByIdsFilter(
  override val ids: Set<String> = emptySet(),
  override val desc: String? = null,
) : AbstractFilter<User>, Filter.IdsFilter<String, User>
