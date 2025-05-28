// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.AnonymousMedicalLocationJs
import com.icure.cardinal.sdk.js.model.AppointmentTypeAndPlaceJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.UserAndHealthcarePartyJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("AnonymousApi")
public external interface AnonymousApiJs {
	public fun listAppointmentTypesForUser(
		groupId: String,
		userId: String,
		startDate: Double,
		endDate: Double,
	): Promise<Array<AppointmentTypeAndPlaceJs>>

	public fun getAvailabilitiesByPeriodAndCalendarItemTypeId(
		groupId: String,
		userId: String,
		calendarItemTypeId: String,
		startDate: Double,
		endDate: Double,
		isNewPatient: Boolean,
		placeId: String?,
		limit: Double?,
	): Promise<Array<Double>>

	public fun listHealthcarePartiesInGroup(groupId: String): Promise<Array<UserAndHealthcarePartyJs>>

	public fun getPublicMedicalLocationsByGroupId(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<AnonymousMedicalLocationJs>>
}
