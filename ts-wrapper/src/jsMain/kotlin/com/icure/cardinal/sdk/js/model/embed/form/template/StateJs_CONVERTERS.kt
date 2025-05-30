// auto-generated file
package com.icure.cardinal.sdk.js.model.embed.form.template

import com.icure.cardinal.sdk.model.embed.form.template.State
import com.icure.cardinal.sdk.model.embed.form.template.StateToUpdate
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun state_toJs(obj: State): StateJs {
	val name = obj.name
	val stateToUpdate = obj.stateToUpdate.name
	val canLaunchLauncher = obj.canLaunchLauncher
	return StateJs(js("{" +
		"name:name," +
		"stateToUpdate:stateToUpdate," +
		"canLaunchLauncher:canLaunchLauncher" +
	"}"))
}

public fun state_fromJs(obj: StateJs): State {
	val name = obj.name
	val stateToUpdate = StateToUpdate.valueOf(obj.stateToUpdate)
	val canLaunchLauncher = obj.canLaunchLauncher
	return State(
		name = name,
		stateToUpdate = stateToUpdate,
		canLaunchLauncher = canLaunchLauncher,
	)
}
