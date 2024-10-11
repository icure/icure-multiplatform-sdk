// auto-generated file
package com.icure.cardinal.sdk.py.filters.HealthElementFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.HealthElementFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.HealthElement
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
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
private class AllHealthElementsForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allHealthElementsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<AllHealthElementsForDataOwnerParams>(params)
	HealthElementFilters.allHealthElementsForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

public fun allHealthElementsForSelf(): String = kotlin.runCatching {
	HealthElementFilters.allHealthElementsForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	HealthElementFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersForSelfParams>(params)
	HealthElementFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByCodeForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByCodeForDataOwnerParams>(params)
	HealthElementFilters.byCodeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByCodeForSelfParams(
	public val codeType: String,
	public val codeCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByCodeForSelfParams>(params)
	HealthElementFilters.byCodeForSelf(
		decodedParams.codeType,
		decodedParams.codeCode,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByTagForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTagForDataOwnerParams>(params)
	HealthElementFilters.byTagForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByTagForSelfParams(
	public val tagType: String,
	public val tagCode: String? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByTagForSelfParams>(params)
	HealthElementFilters.byTagForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByPatientsForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsForDataOwnerParams>(params)
	HealthElementFilters.byPatientsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByPatientsForSelfParams(
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsForSelfParams>(params)
	HealthElementFilters.byPatientsForSelf(
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByPatientsSecretIdsForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForDataOwnerParams>(params)
	HealthElementFilters.byPatientsSecretIdsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByPatientsSecretIdsForSelfParams(
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForSelfParams>(params)
	HealthElementFilters.byPatientsSecretIdsForSelf(
		decodedParams.secretIds,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	HealthElementFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByPatientsOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsOpeningDateForDataOwnerParams>(params)
	HealthElementFilters.byPatientsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByPatientsOpeningDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsOpeningDateForSelfParams>(params)
	HealthElementFilters.byPatientsOpeningDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByPatientSecretIdsOpeningDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsOpeningDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsOpeningDateForDataOwnerParams>(params)
	HealthElementFilters.byPatientSecretIdsOpeningDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByPatientSecretIdsOpeningDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsOpeningDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsOpeningDateForSelfParams>(params)
	HealthElementFilters.byPatientSecretIdsOpeningDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByStatusForDataOwnerParams(
	public val dataOwnerId: String,
	public val status: Int,
)

@OptIn(InternalIcureApi::class)
public fun byStatusForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByStatusForDataOwnerParams>(params)
	HealthElementFilters.byStatusForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.status,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))

@Serializable
private class ByStatusForSelfParams(
	public val status: Int,
)

@OptIn(InternalIcureApi::class)
public fun byStatusForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByStatusForSelfParams>(params)
	HealthElementFilters.byStatusForSelf(
		decodedParams.status,
	)
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(HealthElement::class)))
