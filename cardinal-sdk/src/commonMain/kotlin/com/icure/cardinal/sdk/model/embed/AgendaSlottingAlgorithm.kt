package com.icure.cardinal.sdk.model.embed

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Int

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@Serializable
sealed interface AgendaSlottingAlgorithm {
	@Serializable
	@SerialName("FixedIntervals")
	public data class FixedIntervals(
		public val intervalMinutes: Int,
	) : AgendaSlottingAlgorithm
	// region AgendaSlottingAlgorithm-AgendaSlottingAlgorithm
	// endregion
}
