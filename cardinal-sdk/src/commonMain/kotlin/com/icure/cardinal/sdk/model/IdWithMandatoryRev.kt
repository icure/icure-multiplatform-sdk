package com.icure.cardinal.sdk.model

import kotlinx.serialization.Serializable


@Serializable
data class IdWithMandatoryRev(
	public val id: String,
	public val rev: String
)
