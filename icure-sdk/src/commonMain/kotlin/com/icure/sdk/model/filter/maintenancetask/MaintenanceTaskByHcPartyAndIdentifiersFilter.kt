package com.icure.sdk.model.filter.maintenancetask

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.filter.AbstractFilter
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("MaintenanceTaskByHcPartyAndIdentifiersFilter")
@Serializable
public data class MaintenanceTaskByHcPartyAndIdentifiersFilter(
  public val healthcarePartyId: String? = null,
  public val identifiers: List<Identifier> = emptyList(),
  override val desc: String? = null,
) : AbstractFilter<MaintenanceTask>
