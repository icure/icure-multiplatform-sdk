package com.icure.sdk.model.filter.maintenancetask

import com.icure.sdk.model.MaintenanceTask
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("MaintenanceTaskByHcPartyAndTypeFilter")
@Serializable
data class MaintenanceTaskByHcPartyAndTypeFilter(
	override val desc: String? = null,
	@SerialName("filterType")
	public val type: String,
	public val healthcarePartyId: String? = null,
) : AbstractFilter<MaintenanceTask> {
	// region MaintenanceTaskByHcPartyAndTypeFilter-MaintenanceTaskByHcPartyAndTypeFilter

	// endregion
}
