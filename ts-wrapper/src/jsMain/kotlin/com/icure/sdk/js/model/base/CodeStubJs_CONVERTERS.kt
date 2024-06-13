package com.icure.sdk.js.model.base

import com.icure.sdk.js.model.CheckedConverters.mapToObject
import com.icure.sdk.js.model.CheckedConverters.objectToMapNullsafe
import com.icure.sdk.model.base.CodeStub
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun codeStub_toJs(obj: CodeStub): CodeStubJs {
	val id = obj.id
	val context = obj.context
	val type = obj.type
	val code = obj.code
	val version = obj.version
	val contextLabel = obj.contextLabel
	val label = mapToObject(
		obj.label,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return CodeStubJs(js("{" +
		"id:id," +
		"context:context," +
		"type:type," +
		"code:code," +
		"version:version," +
		"contextLabel:contextLabel," +
		"label:label" +
	"}"))
}

public fun codeStub_fromJs(obj: CodeStubJs): CodeStub {
	val id = obj.id
	val context = obj.context
	val type = obj.type
	val code = obj.code
	val version = obj.version
	val contextLabel = obj.contextLabel
	val label = objectToMapNullsafe(
		obj.label,
		"obj.label",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return CodeStub(
		id = id,
		context = context,
		type = type,
		code = code,
		version = version,
		contextLabel = contextLabel,
		label = label,
	)
}
