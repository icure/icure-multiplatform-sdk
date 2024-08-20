// auto-generated file
package com.icure.sdk.py.filters.ContactFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.ContactFilters
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.py.serialization.ContactSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
private class AllContactsForDataOwnerParams(
	public val dataOwnerId: String,
)

public fun allContactsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AllContactsForDataOwnerParams>(params)
	ContactFilters.allContactsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(ContactSerializer))

public fun allContactsForSelf(): String = kotlin.runCatching {
	ContactFilters.allContactsForSelf()
}.toPyString(FilterOptions.serializer(ContactSerializer))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForSelfParams>(params)
	ContactFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	ContactFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByCodeAndOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

public fun byCodeAndOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByCodeAndOpeningDateForDataOwnerParams>(params)
	ContactFilters.byCodeAndOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByCodeAndOpeningDateForSelfParams(
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

public fun byCodeAndOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByCodeAndOpeningDateForSelfParams>(params)
	ContactFilters.byCodeAndOpeningDateForSelf(
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(SortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByTagAndOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

public fun byTagAndOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTagAndOpeningDateForDataOwnerParams>(params)
	ContactFilters.byTagAndOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByTagAndOpeningDateForSelfParams(
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfContactOpeningDate: Long? = null,
	public val endOfContactOpeningDate: Long? = null,
)

public fun byTagAndOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTagAndOpeningDateForSelfParams>(params)
	ContactFilters.byTagAndOpeningDateForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfContactOpeningDate,
		decodedParams.endOfContactOpeningDate,
	)
}.toPyString(SortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByPatientsForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
)

public fun byPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsForDataOwnerParams>(params)
	ContactFilters.byPatientsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByPatientsForSelfParams(
	public val patients: List<Patient>,
)

public fun byPatientsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsForSelfParams>(params)
	ContactFilters.byPatientsForSelf(
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByPatientsSecretIdsForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
)

public fun byPatientsSecretIdsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsSecretIdsForDataOwnerParams>(params)
	ContactFilters.byPatientsSecretIdsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByPatientsSecretIdsForSelfParams(
	public val secretIds: List<String>,
)

public fun byPatientsSecretIdsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsSecretIdsForSelfParams>(params)
	ContactFilters.byPatientsSecretIdsForSelf(
		decodedParams.secretIds,
	)
}.toPyString(SortableFilterOptions.serializer(ContactSerializer))

@Serializable
private class ByServiceIdsParams(
	public val serviceIds: List<String>,
)

public fun byServiceIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByServiceIdsParams>(params)
	ContactFilters.byServiceIds(
		decodedParams.serviceIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ContactSerializer))
