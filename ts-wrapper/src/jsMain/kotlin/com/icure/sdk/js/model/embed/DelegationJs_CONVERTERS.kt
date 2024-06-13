package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.specializations.hexString_fromJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.model.embed.Delegation
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun delegation_toJs(obj: Delegation): DelegationJs {
	val owner = obj.owner
	val delegatedTo = obj.delegatedTo
	val key = obj.key?.let { nonNull1 ->
		hexString_toJs(nonNull1)
	}
	val tags = listToArray(
		obj.tags,
		{ x1: String ->
			x1
		},
	)
	return DelegationJs(js("{" +
		"owner:owner," +
		"delegatedTo:delegatedTo," +
		"key:key," +
		"tags:tags" +
	"}"))
}

public fun delegation_fromJs(obj: DelegationJs): Delegation {
	val owner = obj.owner
	val delegatedTo = obj.delegatedTo
	val key = obj.key?.let { nonNull1 ->
		hexString_fromJs(nonNull1)
	}
	val tags = arrayToList(
		obj.tags,
		"obj.tags",
		{ x1: String ->
			x1
		},
	)
	return Delegation(
		owner = owner,
		delegatedTo = delegatedTo,
		key = key,
		tags = tags,
	)
}
