// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.js.model.specializations.secureDelegationKeyString_fromJs
import com.icure.cardinal.sdk.js.model.specializations.secureDelegationKeyString_toJs
import com.icure.cardinal.sdk.model.embed.SecureDelegation
import com.icure.cardinal.sdk.model.embed.SecurityMetadata
import com.icure.cardinal.sdk.model.specializations.SecureDelegationKeyString
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
	return SecurityMetadataJs(js("{" +
		"secureDelegations:secureDelegations" +
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
	return SecurityMetadata(
		secureDelegations = secureDelegations,
	)
}
