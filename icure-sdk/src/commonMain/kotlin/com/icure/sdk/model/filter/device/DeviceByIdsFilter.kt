package com.icure.sdk.model.filter.device

import com.icure.sdk.model.Device
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlin.collections.Set
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("DeviceByIdsFilter")
@Serializable
public data class DeviceByIdsFilter(
  override val ids: Set<String> = emptySet(),
  override val desc: String? = null,
) : AbstractFilter<Device>, Filter.IdsFilter<String, Device>
