package com.icure.sdk.model.filter.service

import com.icure.sdk.model.embed.Service
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("ServiceByHcPartyFilter")
@Serializable
public data class ServiceByHcPartyFilter(
  public val hcpId: String,
  override val desc: String? = null,
) : AbstractFilter<Service>
