// auto-generated file
@file:JsQualifier("model")

package com.icure.sdk.js.model.embed

import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("SecureDelegation")
public external class SecureDelegationJs(
	partial: dynamic,
) {
	public val delegator: String?

	public val `delegate`: String?

	public val secretIds: Array<String>

	public val encryptionKeys: Array<String>

	public val owningEntityIds: Array<String>

	public val parentDelegations: Array<String>

	public val exchangeDataId: String?

	public val permissions: String
}
