package com.icure.sdk.model.notification

import com.icure.sdk.model.base.Identifiable
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.specializations.AccessControlKeyHexString
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class Subscription<O : Identifiable<String>>(
  public val eventTypes: List<SubscriptionEventType> = emptyList(),
  public val entityClass: String,
  public val filter: FilterChain<O>? = null,
  public val accessControlKeys: List<AccessControlKeyHexString>? = null,
)
