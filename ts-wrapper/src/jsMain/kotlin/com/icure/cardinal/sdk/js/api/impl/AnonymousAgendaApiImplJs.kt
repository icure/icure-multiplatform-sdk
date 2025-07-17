// auto-generated file
package com.icure.cardinal.sdk.js.api.`impl`

import com.icure.cardinal.sdk.api.AnonymousAgendaApi
import com.icure.cardinal.sdk.js.api.AnonymousAgendaApiJs
import com.icure.cardinal.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefaultNullable
import com.icure.cardinal.sdk.js.model.CheckedConverters.listToArray
import com.icure.cardinal.sdk.js.model.CheckedConverters.longToNumber
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToInt
import com.icure.cardinal.sdk.js.model.CheckedConverters.numberToLong
import com.icure.cardinal.sdk.js.model.PublicAgendasAndCalendarItemTypesJs
import com.icure.cardinal.sdk.js.model.publicAgendasAndCalendarItemTypes_toJs
import kotlin.Array
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
internal class AnonymousAgendaApiImplJs(
	private val anonymousAgendaApi: AnonymousAgendaApi,
) : AnonymousAgendaApiJs {
	override fun listAnonymousAgendaAndAppointmentTypes(
		groupId: String,
		propertyId: String,
		propertyValue: String,
	): Promise<PublicAgendasAndCalendarItemTypesJs> = GlobalScope.promise {
		val groupIdConverted: String = groupId
		val propertyIdConverted: String = propertyId
		val propertyValueConverted: String = propertyValue
		val result = anonymousAgendaApi.listAnonymousAgendaAndAppointmentTypes(
			groupIdConverted,
			propertyIdConverted,
			propertyValueConverted,
		)
		publicAgendasAndCalendarItemTypes_toJs(result)
	}

	override fun listAnonymousAvailabilities(
		groupId: String,
		agendaId: String,
		calendarItemTypeId: String,
		startDate: Double,
		endDate: Double,
		options: dynamic,
	): Promise<Array<Double>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val groupIdConverted: String = groupId
			val agendaIdConverted: String = agendaId
			val calendarItemTypeIdConverted: String = calendarItemTypeId
			val startDateConverted: Long = numberToLong(startDate, "startDate")
			val endDateConverted: Long = numberToLong(endDate, "endDate")
			val limitConverted: Int? = convertingOptionOrDefaultNullable(
				_options,
				"limit",
				null
			) { limit: Double? ->
				numberToInt(limit, "limit")
			}
			val result = anonymousAgendaApi.listAnonymousAvailabilities(
				groupIdConverted,
				agendaIdConverted,
				calendarItemTypeIdConverted,
				startDateConverted,
				endDateConverted,
				limitConverted,
			)
			listToArray(
				result,
				{ x1: Long ->
					longToNumber(x1)
				},
			)
		}
	}
}
