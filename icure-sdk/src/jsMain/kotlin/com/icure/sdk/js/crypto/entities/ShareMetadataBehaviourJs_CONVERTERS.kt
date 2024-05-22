package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.ShareMetadataBehaviour
import kotlin.String

public fun shareMetadataBehaviour_toJs(obj: ShareMetadataBehaviour): String = obj.name

public fun shareMetadataBehaviour_fromJs(obj: String): ShareMetadataBehaviour = when (obj) {
	"Required" -> ShareMetadataBehaviour.Required
	"IfAvailable" -> ShareMetadataBehaviour.IfAvailable
	"Never" -> ShareMetadataBehaviour.Never
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.crypto.entities.ShareMetadataBehaviour: $obj""")
}
