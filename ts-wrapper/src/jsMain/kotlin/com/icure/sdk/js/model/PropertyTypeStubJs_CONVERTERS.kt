package com.icure.sdk.js.model

import com.icure.sdk.model.PropertyTypeStub
import com.icure.sdk.model.embed.TypedValuesType

public fun propertyTypeStub_toJs(obj: PropertyTypeStub): PropertyTypeStubJs {
	val identifier = obj.identifier
	val type = obj.type?.let { nonNull1 ->
		obj.type?.name
	}
	return PropertyTypeStubJs(js("{" +
		"identifier:identifier," +
		"type:type" +
	"}"))
}

public fun propertyTypeStub_fromJs(obj: PropertyTypeStubJs): PropertyTypeStub {
	val identifier = obj.identifier
	val type = obj.type?.let { nonNull1 ->
		TypedValuesType.valueOf(nonNull1)
	}
	return PropertyTypeStub(
		identifier = identifier,
		type = type,
	)
}
