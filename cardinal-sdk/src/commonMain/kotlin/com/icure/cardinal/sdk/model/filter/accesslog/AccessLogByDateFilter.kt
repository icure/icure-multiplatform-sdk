package com.icure.cardinal.sdk.model.filter.accesslog

import com.icure.cardinal.sdk.model.AccessLog
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.sdk.serialization.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Boolean
import kotlin.String
import com.icure.cardinal.sdk.serialization.InstantSerializer

// WARNING: This file is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).

@SerialName("AccessLogByDateFilter")
@Serializable
data class AccessLogByDateFilter(
	override val desc: String? = null,
	@Serializable(with = InstantSerializer::class)
	public val startDate: Instant?,
	@Serializable(with = InstantSerializer::class)
	public val endDate: Instant?,
	public val descending: Boolean?,
) : AbstractFilter<AccessLog> {
	// region AccessLogByDateFilter-AccessLogByDateFilter

	// endregion
}
