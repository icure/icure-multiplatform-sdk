// auto-generated file
package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.embed.RoleConfiguration
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun roleConfiguration_toJs(obj: RoleConfiguration): RoleConfigurationJs {
	val source = obj.source.name
	val roles = setToArray(
		obj.roles,
		{ x1: String ->
			x1
		},
	)
	return RoleConfigurationJs(js("{" +
		"source:source," +
		"roles:roles" +
	"}"))
}

public fun roleConfiguration_fromJs(obj: RoleConfigurationJs): RoleConfiguration {
	val source = RoleConfiguration.Source.valueOf(obj.source)
	val roles = arrayToSet(
		obj.roles,
		"obj.roles",
		{ x1: String ->
			x1
		},
	)
	return RoleConfiguration(
		source = source,
		roles = roles,
	)
}
