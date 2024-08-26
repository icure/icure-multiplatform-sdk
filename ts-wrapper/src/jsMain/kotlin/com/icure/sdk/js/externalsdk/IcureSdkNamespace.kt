@file:JsQualifier("sdk.IcureSdk")
package com.icure.sdk.js.externalsdk

import kotlin.js.Promise

@JsName("AuthenticationWithProcessStep")
external interface AuthenticationWithProcessStepJs {
	fun completeAuthentication(validationCode: String): Promise<IcureSdkJs>
}