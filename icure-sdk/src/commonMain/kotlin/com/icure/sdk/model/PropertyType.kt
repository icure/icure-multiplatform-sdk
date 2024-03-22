package com.icure.sdk.model

import com.icure.sdk.model.base.StoredDocument
import com.icure.sdk.model.constants.PropertyTypeScope
import com.icure.sdk.model.embed.TypedValuesType
import kotlin.Boolean
import kotlin.Long
import kotlin.String
import kotlinx.serialization.Serializable

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
data class PropertyType(
  override val id: String,
  override val rev: String? = null,
  override val deletionDate: Long? = null,
  public val identifier: String,
  public val type: TypedValuesType? = null,
  public val scope: PropertyTypeScope? = null,
  public val unique: Boolean,
  public val editor: String? = null,
  public val localized: Boolean,
) : StoredDocument {
	// region PropertyType-PropertyType
	// endregion
}