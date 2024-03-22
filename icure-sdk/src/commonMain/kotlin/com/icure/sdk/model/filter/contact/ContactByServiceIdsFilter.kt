package com.icure.sdk.model.filter.contact

import com.icure.sdk.model.Contact
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("ContactByServiceIdsFilter")
@Serializable
data class ContactByServiceIdsFilter(
  override val desc: String? = null,
  public val ids: List<String>? = null,
) : AbstractFilter<Contact> {
	// region ContactByServiceIdsFilter-ContactByServiceIdsFilter
	// endregion
}