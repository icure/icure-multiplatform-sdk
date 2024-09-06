// auto-generated file
package com.icure.cardinal.sdk.py.filters.ServiceFilters

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.filters.FilterOptions
import com.icure.cardinal.sdk.filters.ServiceFilters
import com.icure.cardinal.sdk.filters.SortableFilterOptions
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.base.Identifier
import com.icure.cardinal.sdk.model.base.LinkQualification
import com.icure.cardinal.sdk.model.embed.Service
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.Serializable

@Serializable
private class AllServicesForDataOwnerParams(
	public val dataOwnerId: String,
)

@OptIn(InternalIcureApi::class)
public fun allServicesForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<AllServicesForDataOwnerParams>(params)
	ServiceFilters.allServicesForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

public fun allServicesForSelf(): String = kotlin.runCatching {
	ServiceFilters.allServicesForSelf()
}.toPyString(FilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	ServiceFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodeAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodeAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byCodeAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byTagAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsForDataOwnerParams>(params)
	ServiceFilters.byPatientsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsSecretIdsForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForDataOwnerParams>(params)
	ServiceFilters.byPatientsSecretIdsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByHealthElementIdFromSubContactForDataOwnerParams(
	public val dataOwnerId: String,
	public val healthElementIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byHealthElementIdFromSubContactForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByHealthElementIdFromSubContactForDataOwnerParams>(params)
	ServiceFilters.byHealthElementIdFromSubContactForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.healthElementIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

@OptIn(InternalIcureApi::class)
public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdentifiersForSelfParams>(params)
	ServiceFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByCodeAndValueDateForSelfParams(
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byCodeAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByCodeAndValueDateForSelfParams>(params)
	ServiceFilters.byCodeAndValueDateForSelf(
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByTagAndValueDateForSelfParams(
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

@OptIn(InternalIcureApi::class)
public fun byTagAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByTagAndValueDateForSelfParams>(params)
	ServiceFilters.byTagAndValueDateForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsForSelfParams(
	public val patients: List<Patient>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsForSelfParams>(params)
	ServiceFilters.byPatientsForSelf(
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsSecretIdsForSelfParams(
	public val secretIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsSecretIdsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsSecretIdsForSelfParams>(params)
	ServiceFilters.byPatientsSecretIdsForSelf(
		decodedParams.secretIds,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByHealthElementIdFromSubContactForSelfParams(
	public val healthElementIds: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byHealthElementIdFromSubContactForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByHealthElementIdFromSubContactForSelfParams>(params)
	ServiceFilters.byHealthElementIdFromSubContactForSelf(
		decodedParams.healthElementIds,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

@OptIn(InternalIcureApi::class)
public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByIdsParams>(params)
	ServiceFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByAssociationIdParams(
	public val associationId: String,
)

@OptIn(InternalIcureApi::class)
public fun byAssociationId(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByAssociationIdParams>(params)
	ServiceFilters.byAssociationId(
		decodedParams.associationId,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByQualifiedLinkParams(
	public val linkValues: List<String>,
	public val linkQualification: LinkQualification? = null,
)

@OptIn(InternalIcureApi::class)
public fun byQualifiedLink(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByQualifiedLinkParams>(params)
	ServiceFilters.byQualifiedLink(
		decodedParams.linkValues,
		decodedParams.linkQualification,
	)
}.toPyString(BaseFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientsDateForDataOwnerParams>(params)
	ServiceFilters.byPatientsDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientsDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientsDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByPatientsDateForSelfParams>(params)
	ServiceFilters.byPatientsDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsDateForDataOwnerParams>(params)
	ServiceFilters.byPatientSecretIdsDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))

@Serializable
private class ByPatientSecretIdsDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Long? = null,
	public val to: Long? = null,
	public val descending: Boolean = false,
)

@OptIn(InternalIcureApi::class)
public fun byPatientSecretIdsDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ByPatientSecretIdsDateForSelfParams>(params)
	ServiceFilters.byPatientSecretIdsDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(PolymorphicSerializer(Service::class)))
