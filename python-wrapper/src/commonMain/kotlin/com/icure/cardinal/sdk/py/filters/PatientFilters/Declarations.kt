// auto-generated file
package com.icure.cardinal.sdk.py.filters.PatientFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.PatientFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.embed.Gender
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class AllPatientsForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AllPatientsForDataOwnerParams>(params)
	PatientFilters.allPatientsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

public fun allPatientsForSelf(): String = kotlin.runCatching {
	PatientFilters.allPatientsForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	PatientFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	PatientFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class BySsinsForDataOwnerParams(
	public val dataOwnerId: String,
	public val ssins: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun bySsinsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<BySsinsForDataOwnerParams>(params)
	PatientFilters.bySsinsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.ssins,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByDateOfBirthBetweenForDataOwnerParams(
	public val dataOwnerId: String,
	public val fromDate: Int,
	public val toDate: Int,
)

@OptIn(InternalIcureApi::class)
public fun byDateOfBirthBetweenForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByDateOfBirthBetweenForDataOwnerParams>(params)
	PatientFilters.byDateOfBirthBetweenForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.fromDate,
		decodedParams.toDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByFuzzyNameForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byFuzzyNameForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByFuzzyNameForDataOwnerParams>(params)
	PatientFilters.byFuzzyNameForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByGenderEducationProfessionForDataOwnerParams(
	public val dataOwnerId: String,
	public val gender: Gender,
	public val education: String? = null,
	public val profession: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byGenderEducationProfessionForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByGenderEducationProfessionForDataOwnerParams>(params)
	PatientFilters.byGenderEducationProfessionForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.gender,
		decodedParams.education,
		decodedParams.profession,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByActiveForDataOwnerParams(
	public val dataOwnerId: String,
	public val active: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun byActiveForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByActiveForDataOwnerParams>(params)
	PatientFilters.byActiveForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.active,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByTelecomForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byTelecomForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTelecomForDataOwnerParams>(params)
	PatientFilters.byTelecomForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressPostalCodeHouseNumberForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
	public val postalCode: String,
	public val houseNumber: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byAddressPostalCodeHouseNumberForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByAddressPostalCodeHouseNumberForDataOwnerParams>(params)
	PatientFilters.byAddressPostalCodeHouseNumberForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
		decodedParams.postalCode,
		decodedParams.houseNumber,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressForDataOwnerParams(
	public val dataOwnerId: String,
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byAddressForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByAddressForDataOwnerParams>(params)
	PatientFilters.byAddressForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.searchString,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByExternalIdForDataOwnerParams(
	public val dataOwnerId: String,
	public val externalIdPrefix: String,
)

@OptIn(InternalIcureApi::class)
public fun byExternalIdForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByExternalIdForDataOwnerParams>(params)
	PatientFilters.byExternalIdForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.externalIdPrefix,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersForSelfParams>(params)
	PatientFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class BySsinsForSelfParams(
	public val ssins: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun bySsinsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<BySsinsForSelfParams>(params)
	PatientFilters.bySsinsForSelf(
		decodedParams.ssins,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByDateOfBirthBetweenForSelfParams(
	public val fromDate: Int,
	public val toDate: Int,
)

@OptIn(InternalIcureApi::class)
public fun byDateOfBirthBetweenForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByDateOfBirthBetweenForSelfParams>(params)
	PatientFilters.byDateOfBirthBetweenForSelf(
		decodedParams.fromDate,
		decodedParams.toDate,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByNameForSelfParams(
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byNameForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByNameForSelfParams>(params)
	PatientFilters.byNameForSelf(
		decodedParams.searchString,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByGenderEducationProfessionForSelfParams(
	public val gender: Gender,
	public val education: String? = null,
	public val profession: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byGenderEducationProfessionForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByGenderEducationProfessionForSelfParams>(params)
	PatientFilters.byGenderEducationProfessionForSelf(
		decodedParams.gender,
		decodedParams.education,
		decodedParams.profession,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByActiveForSelfParams(
	public val active: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun byActiveForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByActiveForSelfParams>(params)
	PatientFilters.byActiveForSelf(
		decodedParams.active,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByTelecomForSelfParams(
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byTelecomForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTelecomForSelfParams>(params)
	PatientFilters.byTelecomForSelf(
		decodedParams.searchString,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressPostalCodeHouseNumberForSelfParams(
	public val searchString: String,
	public val postalCode: String,
	public val houseNumber: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byAddressPostalCodeHouseNumberForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByAddressPostalCodeHouseNumberForSelfParams>(params)
	PatientFilters.byAddressPostalCodeHouseNumberForSelf(
		decodedParams.searchString,
		decodedParams.postalCode,
		decodedParams.houseNumber,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByAddressForSelfParams(
	public val searchString: String,
)

@OptIn(InternalIcureApi::class)
public fun byAddressForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByAddressForSelfParams>(params)
	PatientFilters.byAddressForSelf(
		decodedParams.searchString,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByExternalIdForSelfParams(
	public val externalIdPrefix: String,
)

@OptIn(InternalIcureApi::class)
public fun byExternalIdForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByExternalIdForSelfParams>(params)
	PatientFilters.byExternalIdForSelf(
		decodedParams.externalIdPrefix,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByModificationDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byModificationDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByModificationDateForDataOwnerParams>(params)
	PatientFilters.byModificationDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))

@Serializable
private class ByModificationDateForSelfParams(
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byModificationDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByModificationDateForSelfParams>(params)
	PatientFilters.byModificationDateForSelf(
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Patient::class)))
