// auto-generated file
package com.icure.cardinal.sdk.js.model.embed

import com.icure.cardinal.sdk.js.model.CheckedConverters.arrayToList
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.base.CodeStubJs
import com.icure.cardinal.sdk.js.model.base.codeStub_fromJs
import com.icure.cardinal.sdk.js.model.base.codeStub_toJs
import com.icure.cardinal.sdk.model.base.CodeStub
import com.icure.cardinal.sdk.model.embed.Substanceproduct
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
	val intendedname = nullToUndefined(
		obj.intendedname
	)
	val deliveredname = nullToUndefined(
		obj.deliveredname
	)
	val productId = nullToUndefined(
		obj.productId
	)
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
	val intendedname = undefinedToNull(obj.intendedname)
	val deliveredname = undefinedToNull(obj.deliveredname)
	val productId = undefinedToNull(obj.productId)
	return Substanceproduct(
		intendedcds = intendedcds,
		deliveredcds = deliveredcds,
		intendedname = intendedname,
		deliveredname = deliveredname,
		productId = productId,
	)
}
