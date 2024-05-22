package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Medicinalproduct

public fun medicinalproduct_toJs(obj: Medicinalproduct): MedicinalproductJs {
	val intendedcds = listToArray(
		obj.intendedcds,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val deliveredcds = listToArray(
		obj.deliveredcds,
		{ x1: CodeStub ->
			codeStub_toJs(x1)
		},
	)
	val intendedname = obj.intendedname
	val deliveredname = obj.deliveredname
	val productId = obj.productId
	return MedicinalproductJs(js("{" +
		"intendedcds:intendedcds," +
		"deliveredcds:deliveredcds," +
		"intendedname:intendedname," +
		"deliveredname:deliveredname," +
		"productId:productId" +
	"}"))
}

public fun medicinalproduct_fromJs(obj: MedicinalproductJs): Medicinalproduct {
	val intendedcds = arrayToList(
		obj.intendedcds,
		"obj.intendedcds",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val deliveredcds = arrayToList(
		obj.deliveredcds,
		"obj.deliveredcds",
		{ x1: CodeStubJs ->
			codeStub_fromJs(x1)
		},
	)
	val intendedname = obj.intendedname
	val deliveredname = obj.deliveredname
	val productId = obj.productId
	return Medicinalproduct(
		intendedcds = intendedcds,
		deliveredcds = deliveredcds,
		intendedname = intendedname,
		deliveredname = deliveredname,
		productId = productId,
	)
}
