package com.icure.sdk.js.model.embed.form.template

import com.icure.sdk.model.embed.form.template.StateToUpdate
import kotlin.String

public fun stateToUpdate_toJs(obj: StateToUpdate): String = obj.name

public fun stateToUpdate_fromJs(obj: String): StateToUpdate = when (obj) {
	"Value" -> StateToUpdate.Value
	"Visible" -> StateToUpdate.Visible
	"Readonly" -> StateToUpdate.Readonly
	"Clazz" -> StateToUpdate.Clazz
	"Required" -> StateToUpdate.Required
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.form.template.StateToUpdate: $obj""")
}
