package com.icure.sdk.js.model.base

import com.icure.sdk.js.model.CheckedConverters.nullToUndefined
import com.icure.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.sdk.model.base.Identifier
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun identifier_toJs(obj: Identifier): IdentifierJs {
	val id = nullToUndefined(
		obj.id
	)
	val assigner = nullToUndefined(
		obj.assigner
	)
	val start = nullToUndefined(
		obj.start
	)
	val end = nullToUndefined(
		obj.end
	)
	val system = nullToUndefined(
		obj.system
	)
	val type = nullToUndefined(
		obj.type?.let { nonNull1 ->
			codeStub_toJs(nonNull1)
		}
	)
	val use = nullToUndefined(
		obj.use
	)
	val value = nullToUndefined(
		obj.value
	)
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
	val id = undefinedToNull(obj.id)
	val assigner = undefinedToNull(obj.assigner)
	val start = undefinedToNull(obj.start)
	val end = undefinedToNull(obj.end)
	val system = undefinedToNull(obj.system)
	val type = obj.type?.let { nonNull1 ->
		codeStub_fromJs(nonNull1)
	}
	val use = undefinedToNull(obj.use)
	val value = undefinedToNull(obj.value)
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
