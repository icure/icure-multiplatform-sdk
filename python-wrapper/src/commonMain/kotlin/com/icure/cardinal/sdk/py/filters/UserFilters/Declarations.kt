// auto-generated file
package com.icure.cardinal.sdk.py.filters.UserFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.UserFilters
import com.icure.cardinal.sdk.model.User
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.OptIn
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

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	UserFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(User.serializer()))

@Serializable
private class ByPatientIdParams(
	public val patientId: String,
)

@OptIn(InternalIcureApi::class)
public fun byPatientId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientIdParams>(params)
	UserFilters.byPatientId(
		decodedParams.patientId,
	)
}.toPyString(BaseFilterOptions.serializer(User.serializer()))

@Serializable
private class ByHealthcarePartyIdParams(
	public val healthcarePartyId: String,
)

@OptIn(InternalIcureApi::class)
public fun byHealthcarePartyId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByHealthcarePartyIdParams>(params)
	UserFilters.byHealthcarePartyId(
		decodedParams.healthcarePartyId,
	)
}.toPyString(BaseFilterOptions.serializer(User.serializer()))

@Serializable
private class ByNameEmailOrPhoneParams(
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byNameEmailOrPhone(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByNameEmailOrPhoneParams>(params)
	UserFilters.byNameEmailOrPhone(
		decodedParams.searchString,
	)
}.toPyString(BaseFilterOptions.serializer(User.serializer()))
