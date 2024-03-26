package com.icure.sdk.model.filter.maintenancetask

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("MaintenanceTaskByHcPartyAndTypeFilter")
@Serializable
public data class MaintenanceTaskByHcPartyAndTypeFilter(
  override val desc: String? = null,
  public val type: String,
  public val healthcarePartyId: String? = null,
) : AbstractFilter<MaintenanceTask>
