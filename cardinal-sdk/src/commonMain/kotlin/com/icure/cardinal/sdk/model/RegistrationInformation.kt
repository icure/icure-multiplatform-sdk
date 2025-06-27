package com.icure.cardinal.sdk.model

import com.icure.cardinal.sdk.utils.DefaultValue
import kotlinx.serialization.Serializable
import kotlin.String
import kotlin.collections.Set

@Serializable
public data class RegistrationInformation(
	public val firstName: String,
	public val lastName: String,
	public val emailAddress: String,
	public val userOptions: String? = null,
	@DefaultValue("emptySet()")
	public val userRoles: Set<String> = emptySet(),
	public val minimumKrakenVersion: String? = null,
	public val cluster: String? = null,
)
