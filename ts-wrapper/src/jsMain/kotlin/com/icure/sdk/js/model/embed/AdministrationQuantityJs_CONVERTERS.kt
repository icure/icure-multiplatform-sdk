package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.embed.AdministrationQuantity

public fun administrationQuantity_toJs(obj: AdministrationQuantity): AdministrationQuantityJs {
	val quantity = obj.quantity
	val administrationUnit = obj.administrationUnit?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val unit = obj.unit
	return AdministrationQuantityJs(js("{" +
		"quantity:quantity," +
		"administrationUnit:administrationUnit," +
		"unit:unit" +
	"}"))
}

public fun administrationQuantity_fromJs(obj: AdministrationQuantityJs): AdministrationQuantity {
	val quantity = obj.quantity
	val administrationUnit = obj.administrationUnit?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val unit = obj.unit
	return AdministrationQuantity(
		quantity = quantity,
		administrationUnit = administrationUnit,
		unit = unit,
	)
}
