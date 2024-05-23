// auto-generated file
package com.icure.sdk.js.model.filter.healthelement

import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName

@JsName("HealthElementByHcPartySecretForeignKeysFilter")
public external class HealthElementByHcPartySecretForeignKeysFilterJs(
	partial: dynamic,
) : AbstractFilterJs<HealthElementJs> {
	override val desc: String?

	public val healthcarePartyId: String?

	public val patientSecretForeignKeys: Array<String>

	override val ktClass: String
}
