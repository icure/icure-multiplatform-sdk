package com.icure.sdk.model.security

import com.icure.sdk.model.filter.predicate.Predicate
import kotlin.OptIn
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonClassDiscriminator

@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("itemType")
@Serializable
public sealed interface PermissionItem {
  public val type: PermissionType

  public val predicate: Predicate
}
