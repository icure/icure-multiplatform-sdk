@file:JsQualifier("sdk.IcureSdk")
package com.icure.cardinal.sdk.js.externalsdk

import kotlin.js.Promise

@JsName("AuthenticationWithProcessStep")
external interface AuthenticationWithProcessStepJs {
	fun completeAuthentication(validationCode: String): Promise<IcureSdkJs>
}