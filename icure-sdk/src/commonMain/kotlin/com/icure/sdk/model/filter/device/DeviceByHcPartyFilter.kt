package com.icure.sdk.model.filter.device

import com.icure.sdk.model.Device
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class DeviceByHcPartyFilter(
  override val desc: String? = null,
  public val responsibleId: String? = null,
) : AbstractFilter<Device>
