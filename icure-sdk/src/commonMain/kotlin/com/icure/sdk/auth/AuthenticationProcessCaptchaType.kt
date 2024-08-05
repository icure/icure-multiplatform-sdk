package com.icure.sdk.auth

enum class AuthenticationProcessCaptchaType(internal val identifier: String) {
	Recaptcha("recaptcha"),
	FriendlyCaptcha("friendly-captcha")
}