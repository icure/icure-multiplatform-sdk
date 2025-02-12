// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.security.ExternalJwtSelector
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun externalJwtSelector_toJs(obj: ExternalJwtSelector): ExternalJwtSelectorJs {
	val id = nullToUndefined(
		obj.id
	)
	val emailField = nullToUndefined(
		obj.emailField
	)
	val loginField = nullToUndefined(
		obj.loginField
	)
	val mobilePhoneField = nullToUndefined(
		obj.mobilePhoneField
	)
	return ExternalJwtSelectorJs(js("{" +
		"id:id," +
		"emailField:emailField," +
		"loginField:loginField," +
		"mobilePhoneField:mobilePhoneField" +
	"}"))
}

public fun externalJwtSelector_fromJs(obj: ExternalJwtSelectorJs): ExternalJwtSelector {
	val id = undefinedToNull(obj.id)
	val emailField = undefinedToNull(obj.emailField)
	val loginField = undefinedToNull(obj.loginField)
	val mobilePhoneField = undefinedToNull(obj.mobilePhoneField)
	return ExternalJwtSelector(
		id = id,
		emailField = emailField,
		loginField = loginField,
		mobilePhoneField = mobilePhoneField,
	)
}
