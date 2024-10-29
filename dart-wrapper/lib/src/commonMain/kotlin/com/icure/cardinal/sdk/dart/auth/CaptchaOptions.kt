package com.icure.cardinal.sdk.dart.auth

import com.icure.kerberus.Solution
import kotlinx.serialization.Serializable

@Serializable
sealed interface CaptchaOptions {

	fun toKt(): com.icure.cardinal.sdk.auth.CaptchaOptions

	@Serializable
	data class Recaptcha(val solution: String) : CaptchaOptions {
		override fun toKt() =
			com.icure.cardinal.sdk.auth.CaptchaOptions.Recaptcha(solution)
	}

	@Serializable
	data class FriendlyCaptcha(val solution: String) : CaptchaOptions {
		override fun toKt() =
			com.icure.cardinal.sdk.auth.CaptchaOptions.FriendlyCaptcha(solution)
	}

	@Serializable
	sealed interface Kerberus : CaptchaOptions {

		@Serializable
		data class Computed(val solution: Solution) : Kerberus {
			override fun toKt() =
				com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus.Computed(solution)
		}

		@Serializable
		data object Delegated : Kerberus {
			override fun toKt() =
				com.icure.cardinal.sdk.auth.CaptchaOptions.Kerberus.Delegated()
		}

	}
}