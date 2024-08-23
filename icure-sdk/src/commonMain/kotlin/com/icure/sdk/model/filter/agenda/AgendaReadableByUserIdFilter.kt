package com.icure.sdk.model.filter.agenda

import com.icure.sdk.model.Agenda
import com.icure.sdk.model.filter.AbstractFilter
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.String

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AgendaReadableByUserIdFilter")
@Serializable
data class AgendaReadableByUserIdFilter(
	public val userId: String,
	override val desc: String?,
) : AbstractFilter<Agenda> {
	// region AgendaReadableByUserIdFilter-AgendaReadableByUserIdFilter

	// endregion
}
