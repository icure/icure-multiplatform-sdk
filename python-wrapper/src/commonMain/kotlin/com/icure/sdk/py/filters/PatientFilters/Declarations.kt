// auto-generated file
package com.icure.sdk.py.filters.PatientFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.PatientFilters
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.embed.Gender
import com.icure.sdk.py.serialization.PatientSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
private class AllPatientsForDataOwnerParams(
	public val dataOwnerId: String,
)

public fun allPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AllPatientsForDataOwnerParams>(params)
	PatientFilters.allPatientsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PatientSerializer))

public fun allPatientsForSelf(): String = kotlin.runCatching {
	PatientFilters.allPatientsForSelf()
}.toPyString(FilterOptions.serializer(PatientSerializer))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdsParams>(params)
	PatientFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	PatientFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class BySsinsForDataOwnerParams(
	public val dataOwnerId: String,
	public val ssins: List<String>,
)

public fun bySsinsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<BySsinsForDataOwnerParams>(params)
	PatientFilters.bySsinsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.ssins,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByDateOfBirthBetweenForDataOwnerParams(
	public val dataOwnerId: String,
	public val fromDate: Int,
	public val toDate: Int,
)

public fun byDateOfBirthBetweenForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByDateOfBirthBetweenForDataOwnerParams>(params)
	PatientFilters.byDateOfBirthBetweenForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.fromDate,
		decodedParams.toDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByFuzzyNameForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

public fun byFuzzyNameForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByFuzzyNameForDataOwnerParams>(params)
	PatientFilters.byFuzzyNameForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByGenderEducationProfessionForDataOwnerParams(
	public val dataOwnerId: String,
	public val gender: Gender,
	public val education: String? = null,
	public val profession: String? = null,
)

public fun byGenderEducationProfessionForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByGenderEducationProfessionForDataOwnerParams>(params)
	PatientFilters.byGenderEducationProfessionForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.gender,
		decodedParams.education,
		decodedParams.profession,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByActiveForDataOwnerParams(
	public val dataOwnerId: String,
	public val active: Boolean,
)

public fun byActiveForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByActiveForDataOwnerParams>(params)
	PatientFilters.byActiveForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.active,
	)
}.toPyString(BaseFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByTelecomForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

public fun byTelecomForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTelecomForDataOwnerParams>(params)
	PatientFilters.byTelecomForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByAddressPostalCodeHouseNumberForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
	public val postalCode: String,
	public val houseNumber: String? = null,
)

public fun byAddressPostalCodeHouseNumberForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByAddressPostalCodeHouseNumberForDataOwnerParams>(params)
	PatientFilters.byAddressPostalCodeHouseNumberForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
		decodedParams.postalCode,
		decodedParams.houseNumber,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByAddressForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

public fun byAddressForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByAddressForDataOwnerParams>(params)
	PatientFilters.byAddressForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByExternalIdForDataOwnerParams(
	public val dataOwnerId: String,
	public val externalIdPrefix: String,
)

public fun byExternalIdForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByExternalIdForDataOwnerParams>(params)
	PatientFilters.byExternalIdForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.externalIdPrefix,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForSelfParams>(params)
	PatientFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class BySsinsForSelfParams(
	public val ssins: List<String>,
)

public fun bySsinsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<BySsinsForSelfParams>(params)
	PatientFilters.bySsinsForSelf(
		decodedParams.ssins,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByDateOfBirthBetweenForSelfParams(
	public val fromDate: Int,
	public val toDate: Int,
)

public fun byDateOfBirthBetweenForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByDateOfBirthBetweenForSelfParams>(params)
	PatientFilters.byDateOfBirthBetweenForSelf(
		decodedParams.fromDate,
		decodedParams.toDate,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByFuzzyNameForSelfParams(
	public val searchString: String,
)

public fun byFuzzyNameForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByFuzzyNameForSelfParams>(params)
	PatientFilters.byFuzzyNameForSelf(
		decodedParams.searchString,
	)
}.toPyString(FilterOptions.serializer(PatientSerializer))

@Serializable
private class ByGenderEducationProfessionForSelfParams(
	public val gender: Gender,
	public val education: String? = null,
	public val profession: String? = null,
)

public fun byGenderEducationProfessionForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByGenderEducationProfessionForSelfParams>(params)
	PatientFilters.byGenderEducationProfessionForSelf(
		decodedParams.gender,
		decodedParams.education,
		decodedParams.profession,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByActiveForSelfParams(
	public val active: Boolean,
)

public fun byActiveForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByActiveForSelfParams>(params)
	PatientFilters.byActiveForSelf(
		decodedParams.active,
	)
}.toPyString(FilterOptions.serializer(PatientSerializer))

@Serializable
private class ByTelecomForSelfParams(
	public val searchString: String,
)

public fun byTelecomForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTelecomForSelfParams>(params)
	PatientFilters.byTelecomForSelf(
		decodedParams.searchString,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByAddressPostalCodeHouseNumberForSelfParams(
	public val searchString: String,
	public val postalCode: String,
	public val houseNumber: String? = null,
)

public fun byAddressPostalCodeHouseNumberForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByAddressPostalCodeHouseNumberForSelfParams>(params)
	PatientFilters.byAddressPostalCodeHouseNumberForSelf(
		decodedParams.searchString,
		decodedParams.postalCode,
		decodedParams.houseNumber,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByAddressForSelfParams(
	public val searchString: String,
)

public fun byAddressForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByAddressForSelfParams>(params)
	PatientFilters.byAddressForSelf(
		decodedParams.searchString,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))

@Serializable
private class ByExternalIdForSelfParams(
	public val externalIdPrefix: String,
)

public fun byExternalIdForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByExternalIdForSelfParams>(params)
	PatientFilters.byExternalIdForSelf(
		decodedParams.externalIdPrefix,
	)
}.toPyString(SortableFilterOptions.serializer(PatientSerializer))
