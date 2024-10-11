// auto-generated file
package com.icure.cardinal.sdk.js.crypto.entities

import com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption
import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.cardinal.sdk.js.model.CheckedConverters.setToArray
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun secretIdUseOption_toJs(obj: SecretIdUseOption): SecretIdUseOptionJs = when (obj) {
	is SecretIdUseOption.UseAnyConfidential -> secretIdUseOption_UseAnyConfidential_toJs(obj)
	is SecretIdUseOption.UseAnySharedWithParent -> secretIdUseOption_UseAnySharedWithParent_toJs(obj)
	is SecretIdUseOption.Use -> secretIdUseOption_Use_toJs(obj)
}

public fun secretIdUseOption_fromJs(obj: SecretIdUseOptionJs): SecretIdUseOption = when {
	obj is SecretIdUseOptionJs_UseAnyConfidentialJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnyConfidential" ->secretIdUseOption_UseAnyConfidential_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs_UseAnyConfidentialJs)
	obj is SecretIdUseOptionJs_UseAnySharedWithParentJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.UseAnySharedWithParent" ->secretIdUseOption_UseAnySharedWithParent_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs_UseAnySharedWithParentJs)
	obj is SecretIdUseOptionJs_UseJs || obj.ktClass ==
			"com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption.Use" ->secretIdUseOption_Use_fromJs(obj
			as com.icure.cardinal.sdk.js.crypto.entities.SecretIdUseOptionJs_UseJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.cardinal.sdk.crypto.entities.SecretIdUseOption: $obj""")
}

@Suppress("UNUSED_VARIABLE")
public fun secretIdUseOption_UseAnyConfidential_toJs(obj: SecretIdUseOption.UseAnyConfidential):
		SecretIdUseOptionJs_UseAnyConfidentialJs = SecretIdUseOptionJs_UseAnyConfidentialJs

public
		fun secretIdUseOption_UseAnyConfidential_fromJs(obj: SecretIdUseOptionJs_UseAnyConfidentialJs):
		SecretIdUseOption.UseAnyConfidential = SecretIdUseOption.UseAnyConfidential

@Suppress("UNUSED_VARIABLE")
public
		fun secretIdUseOption_UseAnySharedWithParent_toJs(obj: SecretIdUseOption.UseAnySharedWithParent):
		SecretIdUseOptionJs_UseAnySharedWithParentJs = SecretIdUseOptionJs_UseAnySharedWithParentJs

public
		fun secretIdUseOption_UseAnySharedWithParent_fromJs(obj: SecretIdUseOptionJs_UseAnySharedWithParentJs):
		SecretIdUseOption.UseAnySharedWithParent = SecretIdUseOption.UseAnySharedWithParent

@Suppress("UNUSED_VARIABLE")
public fun secretIdUseOption_Use_toJs(obj: SecretIdUseOption.Use): SecretIdUseOptionJs_UseJs {
	val secretIds = setToArray(
		obj.secretIds,
		{ x1: String ->
			x1
		},
	)
	return SecretIdUseOptionJs_UseJs(js("{" +
		"secretIds:secretIds" +
	"}"))
}

public fun secretIdUseOption_Use_fromJs(obj: SecretIdUseOptionJs_UseJs): SecretIdUseOption.Use {
	val secretIds = arrayToSet(
		obj.secretIds,
		"obj.secretIds",
		{ x1: String ->
			x1
		},
	)
	return SecretIdUseOption.Use(
		secretIds = secretIds,
	)
}
