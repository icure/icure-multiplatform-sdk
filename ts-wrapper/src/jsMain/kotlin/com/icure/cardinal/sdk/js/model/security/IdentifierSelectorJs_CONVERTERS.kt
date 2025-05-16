// auto-generated file
package com.icure.cardinal.sdk.js.model.security

import com.icure.cardinal.sdk.model.security.IdentifierSelector
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun identifierSelector_toJs(obj: IdentifierSelector): IdentifierSelectorJs {
	val assigner = obj.assigner
	val valueField = obj.valueField
	return IdentifierSelectorJs(js("{" +
		"assigner:assigner," +
		"valueField:valueField" +
	"}"))
}

public fun identifierSelector_fromJs(obj: IdentifierSelectorJs): IdentifierSelector {
	val assigner = obj.assigner
	val valueField = obj.valueField
	return IdentifierSelector(
		assigner = assigner,
		valueField = valueField,
	)
}
