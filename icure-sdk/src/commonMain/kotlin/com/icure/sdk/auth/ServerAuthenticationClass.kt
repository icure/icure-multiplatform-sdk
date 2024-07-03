package com.icure.sdk.auth

import com.icure.sdk.utils.InternalIcureApi

@InternalIcureApi
enum class ServerAuthenticationClass(val level: Int) {
	DigitalId(60),
	TwoFactorAuthentication(50),
	ShortLivedToken(40),
	ExternalAuthentication(30),
	Password(20),
	LongLivedToken(10),

}
