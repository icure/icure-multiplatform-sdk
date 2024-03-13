package com.icure.sdk.model.filter.device

import com.icure.sdk.model.Device
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class AllDevicesFilter(
  override val desc: String? = null,
) : AbstractFilter<Device>, Filter.AllFilter<Device>
