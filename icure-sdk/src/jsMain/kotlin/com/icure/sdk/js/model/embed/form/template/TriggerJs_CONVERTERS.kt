package com.icure.sdk.js.model.embed.form.template

import com.icure.sdk.model.embed.form.template.Trigger
import kotlin.String

public fun trigger_toJs(obj: Trigger): String = obj.name

public fun trigger_fromJs(obj: String): Trigger = when (obj) {
	"Init" -> Trigger.Init
	"Change" -> Trigger.Change
	"Click" -> Trigger.Click
	"Visible" -> Trigger.Visible
	"Error" -> Trigger.Error
	"Valid" -> Trigger.Valid
	"Event" -> Trigger.Event
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.form.template.Trigger: $obj""")
}
