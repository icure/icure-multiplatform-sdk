package com.icure.sdk.model.filter.device

import com.icure.sdk.model.Device
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.Filter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("DeviceByIdsFilter")
@Serializable
data class DeviceByIdsFilter(
    override val ids: Set<String> = emptySet(),
    override val desc: String? = null,
) : AbstractFilter<Device>, Filter.IdsFilter<String, Device>
