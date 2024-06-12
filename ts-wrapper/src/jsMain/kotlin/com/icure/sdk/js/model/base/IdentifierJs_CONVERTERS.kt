package com.icure.sdk.js.model.base

import com.icure.sdk.model.base.Identifier

public fun identifier_toJs(obj: Identifier): IdentifierJs {
	val id = obj.id
	val assigner = obj.assigner
	val start = obj.start
	val end = obj.end
	val system = obj.system
	val type = obj.type?.let { nonNull1 ->
		codeStub_toJs(nonNull1)
	}
	val use = obj.use
	val value = obj.value
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
