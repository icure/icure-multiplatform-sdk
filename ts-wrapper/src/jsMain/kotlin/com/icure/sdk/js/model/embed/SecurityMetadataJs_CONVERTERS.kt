// auto-generated file
package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.objectToMap
import com.icure.sdk.js.model.specializations.secureDelegationKeyString_fromJs
import com.icure.sdk.js.model.specializations.secureDelegationKeyString_toJs
import com.icure.sdk.js.model.specializations.sha256HexString_fromJs
import com.icure.sdk.js.model.specializations.sha256HexString_toJs
import com.icure.sdk.model.embed.SecureDelegation
import com.icure.sdk.model.embed.SecurityMetadata
import com.icure.sdk.model.specializations.SecureDelegationKeyString
import com.icure.sdk.model.specializations.Sha256HexString
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun securityMetadata_toJs(obj: SecurityMetadata): SecurityMetadataJs {
	val secureDelegations = mapToObject(
		obj.secureDelegations,
		{ x1: SecureDelegationKeyString ->
			secureDelegationKeyString_toJs(x1)
		},
		{ x1: SecureDelegation ->
			secureDelegation_toJs(x1)
		},
	)
	val keysEquivalences = mapToObject(
		obj.keysEquivalences,
		{ x1: Sha256HexString ->
			sha256HexString_toJs(x1)
		},
		{ x1: Sha256HexString ->
			sha256HexString_toJs(x1)
		},
	)
	return SecurityMetadataJs(js("{" +
		"secureDelegations:secureDelegations," +
		"keysEquivalences:keysEquivalences" +
	"}"))
}

public fun securityMetadata_fromJs(obj: SecurityMetadataJs): SecurityMetadata {
	val secureDelegations = objectToMap(
		obj.secureDelegations,
		"obj.secureDelegations",
		{ x1: String ->
			secureDelegationKeyString_fromJs(x1)
		},
		{ x1: SecureDelegationJs ->
			secureDelegation_fromJs(x1)
		},
	)
	val keysEquivalences = objectToMap(
		obj.keysEquivalences,
		"obj.keysEquivalences",
		{ x1: String ->
			sha256HexString_fromJs(x1)
		},
		{ x1: String ->
			sha256HexString_fromJs(x1)
		},
	)
	return SecurityMetadata(
		secureDelegations = secureDelegations,
		keysEquivalences = keysEquivalences,
	)
}
