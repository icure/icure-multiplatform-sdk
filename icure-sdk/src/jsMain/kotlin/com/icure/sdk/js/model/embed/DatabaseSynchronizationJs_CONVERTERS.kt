package com.icure.sdk.js.model.embed

import com.icure.sdk.model.embed.DatabaseSynchronization
import kotlin.String

public fun databaseSynchronization_toJs(obj: DatabaseSynchronization): DatabaseSynchronizationJs {
	val source = obj.source
	val target = obj.target
	val filter = obj.filter
	val localTarget = obj.localTarget?.let { nonNull1 ->
		databaseSynchronization_Target_toJs(nonNull1)
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
		databaseSynchronization_Target_fromJs(nonNull1)
	}
	return DatabaseSynchronization(
		source = source,
		target = target,
		filter = filter,
		localTarget = localTarget,
	)
}

public fun databaseSynchronization_Target_toJs(obj: DatabaseSynchronization.Target): String =
		obj.name

public fun databaseSynchronization_Target_fromJs(obj: String): DatabaseSynchronization.Target = when
		(obj) {
	"Base" -> DatabaseSynchronization.Target.Base
	"Healthdata" -> DatabaseSynchronization.Target.Healthdata
	"Patient" -> DatabaseSynchronization.Target.Patient
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.DatabaseSynchronization.Target: $obj""")
}
