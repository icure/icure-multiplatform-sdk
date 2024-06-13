package com.icure.sdk.js.model.base

import com.icure.sdk.model.base.Identifier
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun identifier_toJs(obj: Identifier): IdentifierJs {
	val id = obj.id ?: undefined
	val assigner = obj.assigner ?: undefined
	val start = obj.start ?: undefined
	val end = obj.end ?: undefined
	val system = obj.system ?: undefined
	val type = obj.type?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	} ?: undefined
	val use = obj.use ?: undefined
	val value = obj.value ?: undefined
	return IdentifierJs(js("{" +
		"id:id," +
		"assigner:assigner," +
		"start:start," +
		"end:end," +
		"system:system," +
		"type:type," +
		"use:use," +
		"value:value" +
	"}"))
}

public fun identifier_fromJs(obj: IdentifierJs): Identifier {
	val id = obj.id
	val assigner = obj.assigner
	val start = obj.start
	val end = obj.end
	val system = obj.system
	val type = obj.type?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val use = obj.use
	val value = obj.value
	return Identifier(
		id = id,
		assigner = assigner,
		start = start,
		end = end,
		system = system,
		type = type,
		use = use,
		value = value,
	)
}
