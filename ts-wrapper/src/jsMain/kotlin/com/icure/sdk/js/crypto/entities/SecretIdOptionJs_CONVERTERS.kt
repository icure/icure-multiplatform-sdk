package com.icure.sdk.js.crypto.entities

import com.icure.sdk.crypto.entities.SecretIdOption
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import kotlin.String

public fun secretIdOption_toJs(obj: SecretIdOption): SecretIdOptionJs = when (obj) {
	is SecretIdOption.UseAnyConfidential -> secretIdOption_UseAnyConfidential_toJs(obj)
	is SecretIdOption.UseAnySharedWithParent -> secretIdOption_UseAnySharedWithParent_toJs(obj)
	is SecretIdOption.Use -> secretIdOption_Use_toJs(obj)
}

public fun secretIdOption_fromJs(obj: SecretIdOptionJs): SecretIdOption = when {
	obj is SecretIdOptionJs_UseAnyConfidentialJs || obj.ktClass ==
			"com.icure.sdk.crypto.entities.SecretIdOption.UseAnyConfidential" ->secretIdOption_UseAnyConfidential_fromJs(obj
			as com.icure.sdk.js.crypto.entities.SecretIdOptionJs_UseAnyConfidentialJs)
	obj is SecretIdOptionJs_UseAnySharedWithParentJs || obj.ktClass ==
			"com.icure.sdk.crypto.entities.SecretIdOption.UseAnySharedWithParent" ->secretIdOption_UseAnySharedWithParent_fromJs(obj
			as com.icure.sdk.js.crypto.entities.SecretIdOptionJs_UseAnySharedWithParentJs)
	obj is SecretIdOptionJs_UseJs || obj.ktClass ==
			"com.icure.sdk.crypto.entities.SecretIdOption.Use" ->secretIdOption_Use_fromJs(obj as
			com.icure.sdk.js.crypto.entities.SecretIdOptionJs_UseJs)
	else -> throw
			IllegalArgumentException("""Unknown concrete implementation for com.icure.sdk.crypto.entities.SecretIdOption: $obj""")
}

public fun secretIdOption_UseAnyConfidential_toJs(obj: SecretIdOption.UseAnyConfidential):
		SecretIdOptionJs_UseAnyConfidentialJs = SecretIdOptionJs_UseAnyConfidentialJs

public fun secretIdOption_UseAnyConfidential_fromJs(obj: SecretIdOptionJs_UseAnyConfidentialJs):
		SecretIdOption.UseAnyConfidential = SecretIdOption.UseAnyConfidential

public fun secretIdOption_UseAnySharedWithParent_toJs(obj: SecretIdOption.UseAnySharedWithParent):
		SecretIdOptionJs_UseAnySharedWithParentJs = SecretIdOptionJs_UseAnySharedWithParentJs

public
		fun secretIdOption_UseAnySharedWithParent_fromJs(obj: SecretIdOptionJs_UseAnySharedWithParentJs):
		SecretIdOption.UseAnySharedWithParent = SecretIdOption.UseAnySharedWithParent

public fun secretIdOption_Use_toJs(obj: SecretIdOption.Use): SecretIdOptionJs_UseJs {
	val secretIds = setToArray(
		obj.secretIds,
		{ x1: String ->
			x1
		},
	)
	return SecretIdOptionJs_UseJs(js("{" +
		"secretIds:secretIds" +
	"}"))
}

public fun secretIdOption_Use_fromJs(obj: SecretIdOptionJs_UseJs): SecretIdOption.Use {
	val secretIds = arrayToSet(
		obj.secretIds,
		"obj.secretIds",
		{ x1: String ->
			x1
		},
	)
	return SecretIdOption.Use(
		secretIds = secretIds,
	)
}
