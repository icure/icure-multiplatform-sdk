// auto-generated file
package com.icure.cardinal.sdk.js.model.embed.form.template

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.form.template.Action
import com.icure.cardinal.sdk.model.embed.form.template.Launcher
import com.icure.cardinal.sdk.model.embed.form.template.State
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun action_toJs(obj: Action): ActionJs {
	val launchers = nullToUndefined(
		listToArray(
			obj.launchers,
			{ x1: Launcher ->
				launcher_toJs(x1)
			},
		)
	)
	val expression = nullToUndefined(
		obj.expression
	)
	val states = nullToUndefined(
		listToArray(
			obj.states,
			{ x1: State ->
				state_toJs(x1)
			},
		)
	)
	return ActionJs(js("{" +
		"launchers:launchers," +
		"expression:expression," +
		"states:states" +
	"}"))
}

public fun action_fromJs(obj: ActionJs): Action {
	val launchers = arrayToList(
		obj.launchers,
		"obj.launchers",
		{ x1: LauncherJs ->
			launcher_fromJs(x1)
		},
	)
	val expression = undefinedToNull(obj.expression)
	val states = arrayToList(
		obj.states,
		"obj.states",
		{ x1: StateJs ->
			state_fromJs(x1)
		},
	)
	return Action(
		launchers = launchers,
		expression = expression,
		states = states,
	)
}
