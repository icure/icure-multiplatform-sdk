// auto-generated file
package com.icure.sdk.py.filters.UserFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.UserFilters
import com.icure.sdk.model.User
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	UserFilters.all()
}.toPyString(BaseFilterOptions.serializer(User.serializer()))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdsParams>(params)
	UserFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(User.serializer()))

@Serializable
private class ByPatientIdParams(
	public val patientId: String,
)

public fun byPatientId(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientIdParams>(params)
	UserFilters.byPatientId(
		decodedParams.patientId,
	)
}.toPyString(BaseFilterOptions.serializer(User.serializer()))

@Serializable
private class ByHealthcarePartyIdParams(
	public val healthcarePartyId: String,
)

public fun byHealthcarePartyId(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByHealthcarePartyIdParams>(params)
	UserFilters.byHealthcarePartyId(
		decodedParams.healthcarePartyId,
	)
}.toPyString(BaseFilterOptions.serializer(User.serializer()))

@Serializable
private class ByNameEmailOrPhoneParams(
	public val searchString: String,
)

public fun byNameEmailOrPhone(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByNameEmailOrPhoneParams>(params)
	UserFilters.byNameEmailOrPhone(
		decodedParams.searchString,
	)
}.toPyString(BaseFilterOptions.serializer(User.serializer()))
