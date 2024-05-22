package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.ContractChangeType
import kotlin.String

public fun contractChangeType_toJs(obj: ContractChangeType): String = obj.name

public fun contractChangeType_fromJs(obj: String): ContractChangeType = when (obj) {
	"InscriptionStart" -> ContractChangeType.InscriptionStart
	"InscriptionEnd" -> ContractChangeType.InscriptionEnd
	"Suspension" -> ContractChangeType.Suspension
	"CoverageChange" -> ContractChangeType.CoverageChange
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.ContractChangeType: $obj""")
}
