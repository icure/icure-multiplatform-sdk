package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.DatabaseSynchronization
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun databaseSynchronization_toJs(obj: DatabaseSynchronization): DatabaseSynchronizationJs {
	val source = obj.source
	val target = obj.target
	val filter = obj.filter
	val localTarget = obj.localTarget?.let { nonNull1 ->
		nonNull1.name
	}
	return DatabaseSynchronizationJs(js("{" +
		"source:source," +
		"target:target," +
		"filter:filter," +
		"localTarget:localTarget" +
	"}"))
}

public fun databaseSynchronization_fromJs(obj: DatabaseSynchronizationJs): DatabaseSynchronization {
	val source = obj.source
	val target = obj.target
	val filter = obj.filter
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
