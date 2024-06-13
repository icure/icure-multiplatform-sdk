package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.specializations.base64String_fromJs
import com.icure.sdk.js.model.specializations.base64String_toJs
import com.icure.sdk.js.model.specializations.secureDelegationKeyString_fromJs
import com.icure.sdk.js.model.specializations.secureDelegationKeyString_toJs
import com.icure.sdk.model.embed.AccessLevel
import com.icure.sdk.model.embed.SecureDelegation
import com.icure.sdk.model.specializations.Base64String
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun secureDelegation_toJs(obj: SecureDelegation): SecureDelegationJs {
	val delegator = obj.delegator
	val delegate = obj.delegate
	val secretIds = setToArray(
		obj.secretIds,
		{ x1: Base64String ->
			base64String_toJs(x1)
		},
	)
	val encryptionKeys = setToArray(
		obj.encryptionKeys,
		{ x1: Base64String ->
			base64String_toJs(x1)
		},
	)
	val owningEntityIds = setToArray(
		obj.owningEntityIds,
		{ x1: Base64String ->
			base64String_toJs(x1)
		},
	)
	val parentDelegations = setToArray(
		obj.parentDelegations,
		{ x1: SecureDelegationKeyString ->
			secureDelegationKeyString_toJs(x1)
		},
	)
	val exchangeDataId = obj.exchangeDataId
	val permissions = obj.permissions.name
	return SecureDelegationJs(js("{" +
		"delegator:delegator," +
		"delegate:delegate," +
		"secretIds:secretIds," +
		"encryptionKeys:encryptionKeys," +
		"owningEntityIds:owningEntityIds," +
		"parentDelegations:parentDelegations," +
		"exchangeDataId:exchangeDataId," +
		"permissions:permissions" +
	"}"))
}

public fun secureDelegation_fromJs(obj: SecureDelegationJs): SecureDelegation {
	val delegator = obj.delegator
	val delegate = obj.delegate
	val secretIds = arrayToSet(
		obj.secretIds,
		"obj.secretIds",
		{ x1: String ->
			base64String_fromJs(x1)
		},
	)
	val encryptionKeys = arrayToSet(
		obj.encryptionKeys,
		"obj.encryptionKeys",
		{ x1: String ->
			base64String_fromJs(x1)
		},
	)
	val owningEntityIds = arrayToSet(
		obj.owningEntityIds,
		"obj.owningEntityIds",
		{ x1: String ->
			base64String_fromJs(x1)
		},
	)
	val parentDelegations = arrayToSet(
		obj.parentDelegations,
		"obj.parentDelegations",
		{ x1: String ->
			secureDelegationKeyString_fromJs(x1)
		},
	)
	val exchangeDataId = obj.exchangeDataId
	val permissions = AccessLevel.valueOf(obj.permissions)
	return SecureDelegation(
		delegator = delegator,
		delegate = delegate,
		secretIds = secretIds,
		encryptionKeys = encryptionKeys,
		owningEntityIds = owningEntityIds,
		parentDelegations = parentDelegations,
		exchangeDataId = exchangeDataId,
		permissions = permissions,
	)
}
