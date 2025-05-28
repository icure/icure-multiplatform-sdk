// auto-generated file
package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.CheckedConverters.mapToObject
import com.icure.cardinal.sdk.js.model.CheckedConverters.objectToMap
import com.icure.cardinal.sdk.model.AnonymousMedicalLocation
import kotlin.String
import kotlin.Suppress

@Suppress("UNUSED_VARIABLE")
public fun anonymousMedicalLocation_toJs(obj: AnonymousMedicalLocation):
		AnonymousMedicalLocationJs {
	val id = obj.id
	val publicInformations = mapToObject(
		obj.publicInformations,
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return AnonymousMedicalLocationJs(js("{" +
		"id:id," +
		"publicInformations:publicInformations" +
	"}"))
}

public fun anonymousMedicalLocation_fromJs(obj: AnonymousMedicalLocationJs):
		AnonymousMedicalLocation {
	val id = obj.id
	val publicInformations = objectToMap(
		obj.publicInformations,
		"obj.publicInformations",
		{ x1: String ->
			x1
		},
		{ x1: String ->
			x1
		},
	)
	return AnonymousMedicalLocation(
		id = id,
		publicInformations = publicInformations,
	)
}
