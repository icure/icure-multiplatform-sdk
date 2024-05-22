package com.icure.sdk.js.model

import com.icure.sdk.js.model.embed.typedValuesType_fromJs
import com.icure.sdk.js.model.embed.typedValuesType_toJs
import com.icure.sdk.model.PropertyTypeStub

public fun propertyTypeStub_toJs(obj: PropertyTypeStub): PropertyTypeStubJs {
	val identifier = obj.identifier
	val type = obj.type?.let { nonNull1 ->
		typedValuesType_toJs(nonNull1)
	}
	return PropertyTypeStubJs(js("{" +
		"identifier:identifier," +
		"type:type" +
	"}"))
}

public fun propertyTypeStub_fromJs(obj: PropertyTypeStubJs): PropertyTypeStub {
	val identifier = obj.identifier
	val type = obj.type?.let { nonNull1 ->
		typedValuesType_fromJs(nonNull1)
	}
	return PropertyTypeStub(
		identifier = identifier,
		type = type,
	)
}
