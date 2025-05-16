// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.specializations.base64String_fromJs
import com.icure.cardinal.sdk.js.model.specializations.base64String_toJs
import com.icure.cardinal.sdk.model.security.ExternalJwtConfig
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun externalJwtConfig_toJs(obj: ExternalJwtConfig): ExternalJwtConfigJs {
	val publicKey = base64String_toJs(obj.publicKey)
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
	val identifierField = nullToUndefined(
		obj.identifierField?.let { nonNull1 ->
			identifierSelector_toJs(nonNull1)
		}
	)
	return ExternalJwtConfigJs(js("{" +
		"publicKey:publicKey," +
		"id:id," +
		"emailField:emailField," +
		"loginField:loginField," +
		"mobilePhoneField:mobilePhoneField," +
		"identifierField:identifierField" +
	"}"))
}

public fun externalJwtConfig_fromJs(obj: ExternalJwtConfigJs): ExternalJwtConfig {
	val publicKey = base64String_fromJs(obj.publicKey)
	val id = undefinedToNull(obj.id)
	val emailField = undefinedToNull(obj.emailField)
	val loginField = undefinedToNull(obj.loginField)
	val mobilePhoneField = undefinedToNull(obj.mobilePhoneField)
	val identifierField = obj.identifierField?.let { nonNull1 ->
		identifierSelector_fromJs(nonNull1)
	}
	return ExternalJwtConfig(
		publicKey = publicKey,
		id = id,
		emailField = emailField,
		loginField = loginField,
		mobilePhoneField = mobilePhoneField,
		identifierField = identifierField,
	)
}
