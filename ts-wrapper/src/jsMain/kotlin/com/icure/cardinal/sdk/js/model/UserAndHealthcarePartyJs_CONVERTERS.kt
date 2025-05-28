// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.model.UserAndHealthcareParty
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun userAndHealthcareParty_toJs(obj: UserAndHealthcareParty): UserAndHealthcarePartyJs {
	val user = user_toJs(obj.user)
	val healthcareParty = healthcareParty_toJs(obj.healthcareParty)
	return UserAndHealthcarePartyJs(js("{" +
		"user:user," +
		"healthcareParty:healthcareParty" +
	"}"))
}

public fun userAndHealthcareParty_fromJs(obj: UserAndHealthcarePartyJs): UserAndHealthcareParty {
	val user = user_fromJs(obj.user)
	val healthcareParty = healthcareParty_fromJs(obj.healthcareParty)
	return UserAndHealthcareParty(
		user = user,
		healthcareParty = healthcareParty,
	)
}
