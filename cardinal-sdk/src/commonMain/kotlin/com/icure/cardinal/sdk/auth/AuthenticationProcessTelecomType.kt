package com.icure.cardinal.sdk.auth

import kotlinx.serialization.Serializable

@Serializable
enum class AuthenticationProcessTelecomType {
	Email, MobilePhone
}