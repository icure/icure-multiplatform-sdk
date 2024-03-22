package com.icure.sdk.model.security

import com.icure.sdk.model.filter.predicate.Predicate
import kotlin.OptIn
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("itemType")
@Serializable
sealed interface PermissionItem {
  public val type: PermissionType

  public val predicate: Predicate
	// region PermissionItem-PermissionItem
	// endregion
}