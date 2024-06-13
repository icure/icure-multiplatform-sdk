package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.embed.AdministrationQuantity
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun administrationQuantity_toJs(obj: AdministrationQuantity): AdministrationQuantityJs {
	val quantity = nullToUndefined(
		obj.quantity
	)
	val administrationUnit = nullToUndefined(
		obj.administrationUnit?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val unit = nullToUndefined(
		obj.unit
	)
	return AdministrationQuantityJs(js("{" +
		"quantity:quantity," +
		"administrationUnit:administrationUnit," +
		"unit:unit" +
	"}"))
}

public fun administrationQuantity_fromJs(obj: AdministrationQuantityJs): AdministrationQuantity {
	val quantity = undefinedToNull(obj.quantity)
	val administrationUnit = obj.administrationUnit?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val unit = undefinedToNull(obj.unit)
	return AdministrationQuantity(
		quantity = quantity,
		administrationUnit = administrationUnit,
		unit = unit,
	)
}
