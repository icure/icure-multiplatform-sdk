package com.icure.sdk.js.model

import com.icure.sdk.model.DataOwnerType
import kotlin.String

public fun dataOwnerType_toJs(obj: DataOwnerType): String = obj.name

public fun dataOwnerType_fromJs(obj: String): DataOwnerType = when (obj) {
	"Hcp" -> DataOwnerType.Hcp
	"Device" -> DataOwnerType.Device
	"Patient" -> DataOwnerType.Patient
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.DataOwnerType: $obj""")
}
