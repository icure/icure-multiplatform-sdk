// auto-generated file
package com.icure.cardinal.sdk.js.model.embed.form.template

import com.icure.cardinal.sdk.model.embed.form.template.Launcher
import com.icure.cardinal.sdk.model.embed.form.template.Trigger
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun launcher_toJs(obj: Launcher): LauncherJs {
	val name = obj.name
	val triggerer = obj.triggerer.name
	val shouldPassValue = obj.shouldPassValue
	return LauncherJs(js("{" +
		"name:name," +
		"triggerer:triggerer," +
		"shouldPassValue:shouldPassValue" +
	"}"))
}

public fun launcher_fromJs(obj: LauncherJs): Launcher {
	val name = obj.name
	val triggerer = Trigger.valueOf(obj.triggerer)
	val shouldPassValue = obj.shouldPassValue
	return Launcher(
		name = name,
		triggerer = triggerer,
		shouldPassValue = shouldPassValue,
	)
}
