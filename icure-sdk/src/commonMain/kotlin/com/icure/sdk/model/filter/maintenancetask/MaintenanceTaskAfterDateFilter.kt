package com.icure.sdk.model.filter.maintenancetask

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.Long
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("MaintenanceTaskAfterDateFilter")
@Serializable
public data class MaintenanceTaskAfterDateFilter(
  override val desc: String? = null,
  public val healthcarePartyId: String? = null,
  public val date: Long,
) : AbstractFilter<MaintenanceTask>
