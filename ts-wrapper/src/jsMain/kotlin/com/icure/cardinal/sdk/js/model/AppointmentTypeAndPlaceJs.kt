// auto-generated file
@file:JsQualifier("model")

package com.icure.cardinal.sdk.js.model

import com.icure.cardinal.sdk.js.model.embed.DecryptedAddressJs
import com.icure.cardinal.sdk.js.utils.Record
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier

@JsName("AppointmentTypeAndPlace")
public external class AppointmentTypeAndPlaceJs(
	partial: dynamic,
) {
	public val calendarItemTypeId: String

	public val name: String?

	public val color: String?

	public val duration: Double

	public val subjectByLanguage: Record<String, String>?

	public val placeId: String?

	public val address: DecryptedAddressJs?

	public val acceptsNewPatients: Boolean
}
