package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.Employer
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun employer_toJs(obj: Employer): EmployerJs {
	val name = obj.name
	val addresse = obj.addresse?.let { nonNull1 ->
		address_toJs(nonNull1)
	}
	return EmployerJs(js("{" +
		"name:name," +
		"addresse:addresse" +
	"}"))
}

public fun employer_fromJs(obj: EmployerJs): Employer {
	val name = obj.name
	val addresse = obj.addresse?.let { nonNull1 ->
		address_fromJs(nonNull1)
	}
	return Employer(
		name = name,
		addresse = addresse,
	)
}
