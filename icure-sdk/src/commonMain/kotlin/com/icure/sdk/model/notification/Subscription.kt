package com.icure.sdk.model.notification

import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.model.specializations.AccessControlKeyString
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable
import org.taktik.icure.services.`external`.rest.v2.dto.base.IdentifiableDto

@Serializable
public data class Subscription<O : IdentifiableDto<String>>(
  public val eventTypes: List<Subscription.EventType> = emptyList(),
  public val entityClass: String,
  public val filter: FilterChain<O>? = null,
  public val accessControlKeys: List<AccessControlKeyString>? = null,
)
