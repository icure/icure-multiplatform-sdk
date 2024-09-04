// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.model.embed.DatabaseSynchronization
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun databaseSynchronization_toJs(obj: DatabaseSynchronization): DatabaseSynchronizationJs {
	val source = nullToUndefined(
		obj.source
	)
	val target = nullToUndefined(
		obj.target
	)
	val filter = nullToUndefined(
		obj.filter
	)
	val localTarget = nullToUndefined(
		obj.localTarget?.let { nonNull1 ->
			nonNull1.name
		}
	)
	return DatabaseSynchronizationJs(js("{" +
		"source:source," +
		"target:target," +
		"filter:filter," +
		"localTarget:localTarget" +
	"}"))
}

public fun databaseSynchronization_fromJs(obj: DatabaseSynchronizationJs): DatabaseSynchronization {
	val source = undefinedToNull(obj.source)
	val target = undefinedToNull(obj.target)
	val filter = undefinedToNull(obj.filter)
	val localTarget = obj.localTarget?.let { nonNull1 ->
		DatabaseSynchronization.Target.valueOf(nonNull1)
	}
	return DatabaseSynchronization(
		source = source,
		target = target,
		filter = filter,
		localTarget = localTarget,
	)
}
