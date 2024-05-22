package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.MhcSignatureType
import kotlin.String

public fun mhcSignatureType_toJs(obj: MhcSignatureType): String = obj.name

public fun mhcSignatureType_fromJs(obj: String): MhcSignatureType = when (obj) {
	"HolderEid" -> MhcSignatureType.HolderEid
	"HolderPaper" -> MhcSignatureType.HolderPaper
	"LegalrepresentativeEid" -> MhcSignatureType.LegalrepresentativeEid
	"LegalrepresentativePaper" -> MhcSignatureType.LegalrepresentativePaper
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.MhcSignatureType: $obj""")
}
