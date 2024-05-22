package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.HealthcarePartyStatus
import kotlin.String

public fun healthcarePartyStatus_toJs(obj: HealthcarePartyStatus): String = obj.name

public fun healthcarePartyStatus_fromJs(obj: String): HealthcarePartyStatus = when (obj) {
	"Trainee" -> HealthcarePartyStatus.Trainee
	"Withconvention" -> HealthcarePartyStatus.Withconvention
	"Accreditated" -> HealthcarePartyStatus.Accreditated
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.HealthcarePartyStatus: $obj""")
}
