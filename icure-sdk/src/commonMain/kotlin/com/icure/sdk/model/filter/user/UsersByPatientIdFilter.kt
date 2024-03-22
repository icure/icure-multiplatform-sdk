package com.icure.sdk.model.filter.user

import com.icure.sdk.model.User
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("UsersByPatientIdFilter")
@Serializable
data class UsersByPatientIdFilter(
  public val patientId: String,
  override val desc: String? = null,
) : AbstractFilter<User> {
	// region UsersByPatientIdFilter-UsersByPatientIdFilter
	// endregion
}