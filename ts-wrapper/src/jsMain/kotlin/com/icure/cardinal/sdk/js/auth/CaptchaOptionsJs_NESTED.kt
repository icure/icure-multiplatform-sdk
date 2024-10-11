// TODO auto-generate
@file:JsQualifier("auth.CaptchaOptions")

package com.icure.cardinal.sdk.js.auth

@JsName("Recaptcha")
public external class CaptchaOptionsJs_RecaptchaJs(
	partial: dynamic,
) : CaptchaOptionsJs {
	public val solution: String

	override val ktClass: String
}

@JsName("FriendlyCaptcha")
public external class CaptchaOptionsJs_FriendlyCaptchaJs(
	partial: dynamic,
) : CaptchaOptionsJs {
	public val solution: String

	override val ktClass: String
}

@JsName("Kerberus")
public sealed external interface CaptchaOptionsJs_KerberusJs : CaptchaOptionsJs
