package com.icure.cardinal.sdk.model.security

import kotlinx.serialization.Serializable
import kotlin.String

@Serializable
public data class ExternalJwtSelector(
	public val id: String? = null,
	public val emailField: String? = null,
	public val loginField: String? = null,
	public val mobilePhoneField: String? = null,
)
