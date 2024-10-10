package com.icure.cardinal.sdk.auth

import com.icure.keberus.Solution

sealed interface Captcha {
	data class Recaptcha(val solution: String) : Captcha
	data class FriendlyCaptcha(val solution: String) : Captcha
	sealed interface Kerberus : Captcha {
		data class Computed(
			val solution: Solution
		) : Kerberus
		data class Delegated(
			val onProgress: ((Double) -> Unit)? = null
		) : Kerberus
	}
}
