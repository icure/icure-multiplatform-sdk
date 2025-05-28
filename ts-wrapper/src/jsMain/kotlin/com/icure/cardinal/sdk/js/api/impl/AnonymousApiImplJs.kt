// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AnonymousApi
import com.icure.cardinal.sdk.js.api.AnonymousApiJs
import com.icure.cardinal.sdk.js.model.AnonymousMedicalLocationJs
import com.icure.cardinal.sdk.js.model.AppointmentTypeAndPlaceJs
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.CheckedConverters.undefinedToNull
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.UserAndHealthcarePartyJs
import com.icure.cardinal.sdk.js.model.anonymousMedicalLocation_toJs
import com.icure.cardinal.sdk.js.model.appointmentTypeAndPlace_toJs
import com.icure.cardinal.sdk.js.model.paginatedList_toJs
import com.icure.cardinal.sdk.js.model.userAndHealthcareParty_toJs
import com.icure.cardinal.sdk.model.AnonymousMedicalLocation
import com.icure.cardinal.sdk.model.AppointmentTypeAndPlace
import com.icure.cardinal.sdk.model.UserAndHealthcareParty
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class AnonymousApiImplJs(
	private val anonymousApi: AnonymousApi,
) : AnonymousApiJs {
	override fun listAppointmentTypesForUser(
		groupId: String,
		userId: String,
		startDate: Double,
		endDate: Double,
	): Promise<Array<AppointmentTypeAndPlaceJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userIdConverted: String = userId
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val result = anonymousApi.listAppointmentTypesForUser(
			groupIdConverted,
			userIdConverted,
			startDateConverted,
			endDateConverted,
		)
		listToArray(
			result,
			{ x1: AppointmentTypeAndPlace ->
				appointmentTypeAndPlace_toJs(x1)
			},
		)
	}

	override fun getAvailabilitiesByPeriodAndCalendarItemTypeId(
		groupId: String,
		userId: String,
		calendarItemTypeId: String,
		startDate: Double,
		endDate: Double,
		isNewPatient: Boolean,
		placeId: String?,
		limit: Double?,
	): Promise<Array<Double>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val userIdConverted: String = userId
		val calendarItemTypeIdConverted: String = calendarItemTypeId
		val startDateConverted: Long = numberToLong(startDate, "startDate")
		val endDateConverted: Long = numberToLong(endDate, "endDate")
		val isNewPatientConverted: Boolean = isNewPatient
		val placeIdConverted: String? = undefinedToNull(placeId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = anonymousApi.getAvailabilitiesByPeriodAndCalendarItemTypeId(
			groupIdConverted,
			userIdConverted,
			calendarItemTypeIdConverted,
			startDateConverted,
			endDateConverted,
			isNewPatientConverted,
			placeIdConverted,
			limitConverted,
		)
		listToArray(
			result,
			{ x1: Long ->
				longToNumber(x1)
			},
		)
	}

	override fun listHealthcarePartiesInGroup(groupId: String):
			Promise<Array<UserAndHealthcarePartyJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val result = anonymousApi.listHealthcarePartiesInGroup(
			groupIdConverted,
		)
		listToArray(
			result,
			{ x1: UserAndHealthcareParty ->
				userAndHealthcareParty_toJs(x1)
			},
		)
	}

	override fun getPublicMedicalLocationsByGroupId(
		groupId: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<AnonymousMedicalLocationJs>> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val startKeyConverted: String? = undefinedToNull(startKey)
		val startDocumentIdConverted: String? = undefinedToNull(startDocumentId)
		val limitConverted: Int? = numberToInt(limit, "limit")
		val result = anonymousApi.getPublicMedicalLocationsByGroupId(
			groupIdConverted,
			startKeyConverted,
			startDocumentIdConverted,
			limitConverted,
		)
		paginatedList_toJs(
			result,
			{ x1: AnonymousMedicalLocation ->
				anonymousMedicalLocation_toJs(x1)
			},
		)
	}
}
