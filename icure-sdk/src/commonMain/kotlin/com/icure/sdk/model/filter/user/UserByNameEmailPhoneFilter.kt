package com.icure.sdk.model.filter.user

import com.icure.sdk.model.User
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("UserByNameEmailPhoneFilter")
@Serializable
public data class UserByNameEmailPhoneFilter(
  public val searchString: String,
  override val desc: String? = null,
) : AbstractFilter<User>
