package com.icure.sdk.auth

import com.icure.sdk.model.embed.AuthenticationClass

internal val AuthenticationClass.level: Int get() = when (this) {
	AuthenticationClass.DigitalId -> 60
	AuthenticationClass.TwoFactorAuthentication -> 50
	AuthenticationClass.ShortLivedToken -> 40
	AuthenticationClass.ExternalAuthentication -> 30
	AuthenticationClass.Password -> 20
	AuthenticationClass.LongLivedToken -> 10
}

internal fun minAuthClassForLevel(level: Int): AuthenticationClass =
	AuthenticationClass.entries.sortedBy { it.level }.firstOrNull { it.level >= level }
		?: throw IllegalArgumentException("Invalid server authentication level: $level")
