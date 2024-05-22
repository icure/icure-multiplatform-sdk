package com.icure.sdk.js.model.embed.form.template

import com.icure.sdk.model.embed.form.template.Launcher

public fun launcher_toJs(obj: Launcher): LauncherJs {
	val name = obj.name
	val triggerer = trigger_toJs(obj.triggerer)
	val shouldPassValue = obj.shouldPassValue
	return LauncherJs(js("{" +
		"name:name," +
		"triggerer:triggerer," +
		"shouldPassValue:shouldPassValue" +
	"}"))
}

public fun launcher_fromJs(obj: LauncherJs): Launcher {
	val name = obj.name
	val triggerer = trigger_fromJs(obj.triggerer)
	val shouldPassValue = obj.shouldPassValue
	return Launcher(
		name = name,
		triggerer = triggerer,
		shouldPassValue = shouldPassValue,
	)
}
