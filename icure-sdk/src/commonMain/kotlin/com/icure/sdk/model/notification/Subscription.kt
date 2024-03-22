package com.icure.sdk.model.notification

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.specializations.AccessControlKeyString
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class Subscription<O : Identifiable<String>>(
  public val eventTypes: List<Subscription.EventType> = emptyList(),
  public val entityClass: String,
  public val filter: FilterChain<O>? = null,
  public val accessControlKeys: List<AccessControlKeyString>? = null,
)
