
package com.icure.cardinal.sdk.auth

import com.icure.keberus.Solution
import io.ktor.utils.io.InternalAPI

/**
 * Captcha options for authentication.
 */
sealed interface CaptchaOptions {
	@InternalAPI
	val msgGwIdentifier: String

	/**
	 * Google reCAPTCHA.
	 *
	 * @param solution the token obtained by solving the reCAPTCHA. (https://developers.google.com/recaptcha/docs/v3)
	 */
	@OptIn(InternalAPI::class)
	data class Recaptcha(val solution: String): CaptchaOptions {
		override val msgGwIdentifier: String
			get() = "g-recaptcha-response"
	}

	/**
	 * FriendlyCaptcha.
	 *
	 * @param solution the token obtained by solving the FriendlyCaptcha. (https://developer.friendlycaptcha.com/docs/v2/getting-started/install)
	 */
	@OptIn(InternalAPI::class)
	data class FriendlyCaptcha(val solution: String) : CaptchaOptions {
		override val msgGwIdentifier: String
			get() = "friendly-captcha-response"
	}

	/**
	 * Kerberus is a proof of work captcha multiplatform library.
	 *
	 * [Documentation](https://github.com/icure/kerberus)
	 */
	@OptIn(InternalAPI::class)
	sealed interface Kerberus : CaptchaOptions {
		override val msgGwIdentifier: String
			get() = "kerberus-response"
		/**
		 * It means that the solution is already computed and ready to be used. Made for cases where the solution is computed alongside
		 * the user inputs to smooth the user experience.
		 *
		 * @param solution the solution to the Kerberus challenge.
		 */
		data class Computed(
			val solution: Solution
		) : Kerberus

		/**
		 * It means the solution will be computed automatically by the client. Before doing the call to the API, the client will ask the
		 * server for a challenge, solve it and then send the solution to the server alongside the other data.
		 * You can also provide a progress callback to be notified of the progress of the computation.
		 *
		 * @param onProgress a callback to be notified of the progress of the computation.
		 */
		data class Delegated(
			val onProgress: ((Double) -> Unit)? = null
		) : Kerberus
	}
}
