package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.embed.RoleConfiguration
import kotlin.String

public fun roleConfiguration_toJs(obj: RoleConfiguration): RoleConfigurationJs {
	val source = roleConfiguration_Source_toJs(obj.source)
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
	val source = roleConfiguration_Source_fromJs(obj.source)
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

public fun roleConfiguration_Source_toJs(obj: RoleConfiguration.Source): String = obj.name

public fun roleConfiguration_Source_fromJs(obj: String): RoleConfiguration.Source = when (obj) {
	"Configuration" -> RoleConfiguration.Source.Configuration
	"Inherited" -> RoleConfiguration.Source.Inherited
	"Default" -> RoleConfiguration.Source.Default
	else -> throw
			IllegalArgumentException("""Unknown enum value for com.icure.sdk.model.embed.RoleConfiguration.Source: $obj""")
}
