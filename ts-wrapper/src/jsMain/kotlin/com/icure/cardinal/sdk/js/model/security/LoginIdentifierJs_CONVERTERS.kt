// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.model.security.LoginIdentifier
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun loginIdentifier_toJs(obj: LoginIdentifier): LoginIdentifierJs {
	val assigner = obj.assigner
	val value = obj.value
	return LoginIdentifierJs(js("{" +
		"assigner:assigner," +
		"value:value" +
	"}"))
}

public fun loginIdentifier_fromJs(obj: LoginIdentifierJs): LoginIdentifier {
	val assigner = obj.assigner
	val value = obj.value
	return LoginIdentifier(
		assigner = assigner,
		value = value,
	)
}
