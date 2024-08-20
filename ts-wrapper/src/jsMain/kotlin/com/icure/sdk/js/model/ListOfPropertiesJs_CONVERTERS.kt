// auto-generated file
package com.icure.sdk.js.model

import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.model.DecryptedPropertyStub
import com.icure.sdk.model.ListOfProperties
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun listOfProperties_toJs(obj: ListOfProperties): ListOfPropertiesJs {
	val properties = setToArray(
		obj.properties,
		{ x1: DecryptedPropertyStub ->
			propertyStub_toJs(x1)
		},
	)
	return ListOfPropertiesJs(js("{" +
		"properties:properties" +
	"}"))
}

public fun listOfProperties_fromJs(obj: ListOfPropertiesJs): ListOfProperties {
	val properties = arrayToSet(
		obj.properties,
		"obj.properties",
		{ x1: DecryptedPropertyStubJs ->
			propertyStub_fromJs(x1)
		},
	)
	return ListOfProperties(
		properties = properties,
	)
}
