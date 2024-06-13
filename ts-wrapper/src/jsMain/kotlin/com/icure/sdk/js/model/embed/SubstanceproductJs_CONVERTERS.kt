package com.icure.sdk.js.model.embed

import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.base.CodeStubJs
import com.icure.sdk.js.model.base.codeStub_fromJs
import com.icure.sdk.js.model.base.codeStub_toJs
import com.icure.sdk.model.base.CodeStub
import com.icure.sdk.model.embed.Substanceproduct
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun substanceproduct_toJs(obj: Substanceproduct): SubstanceproductJs {
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
	val intendedname = obj.intendedname ?: undefined
	val deliveredname = obj.deliveredname ?: undefined
	val productId = obj.productId ?: undefined
	return SubstanceproductJs(js("{" +
		"intendedcds:intendedcds," +
		"deliveredcds:deliveredcds," +
		"intendedname:intendedname," +
		"deliveredname:deliveredname," +
		"productId:productId" +
	"}"))
}

public fun substanceproduct_fromJs(obj: SubstanceproductJs): Substanceproduct {
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
	return Substanceproduct(
		intendedcds = intendedcds,
		deliveredcds = deliveredcds,
		intendedname = intendedname,
		deliveredname = deliveredname,
		productId = productId,
	)
}
