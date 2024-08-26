// auto-generated file
package com.icure.sdk.py.filters.ServiceFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.ServiceFilters
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Patient
import com.icure.sdk.model.base.Identifier
import com.icure.sdk.model.base.LinkQualification
import com.icure.sdk.py.serialization.ServiceSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Long
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
private class AllServicesForDataOwnerParams(
	public val dataOwnerId: String,
)

public fun allServicesForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AllServicesForDataOwnerParams>(params)
	ServiceFilters.allServicesForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(ServiceSerializer))

public fun allServicesForSelf(): String = kotlin.runCatching {
	ServiceFilters.allServicesForSelf()
}.toPyString(FilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByIdentifiersForDataOwnerParams(
	public val dataOwnerId: String,
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForDataOwnerParams>(params)
	ServiceFilters.byIdentifiersForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.identifiers,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByCodeAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

public fun byCodeAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByCodeAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byCodeAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByTagAndValueDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

public fun byTagAndValueDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTagAndValueDateForDataOwnerParams>(params)
	ServiceFilters.byTagAndValueDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByPatientsForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
)

public fun byPatientsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsForDataOwnerParams>(params)
	ServiceFilters.byPatientsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByPatientsSecretIdsForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
)

public fun byPatientsSecretIdsForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsSecretIdsForDataOwnerParams>(params)
	ServiceFilters.byPatientsSecretIdsForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByHealthElementIdFromSubContactForDataOwnerParams(
	public val dataOwnerId: String,
	public val healthElementIds: List<String>,
)

public fun byHealthElementIdFromSubContactForDataOwner(params: String): String =
		kotlin.runCatching {
	val decodedParams =
			json.decodeFromString<ByHealthElementIdFromSubContactForDataOwnerParams>(params)
	ServiceFilters.byHealthElementIdFromSubContactForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.healthElementIds,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByIdentifiersForSelfParams(
	public val identifiers: List<Identifier>,
)

public fun byIdentifiersForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdentifiersForSelfParams>(params)
	ServiceFilters.byIdentifiersForSelf(
		decodedParams.identifiers,
	)
}.toPyString(SortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByCodeAndValueDateForSelfParams(
	public val codeType: String,
	public val codeCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

public fun byCodeAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByCodeAndValueDateForSelfParams>(params)
	ServiceFilters.byCodeAndValueDateForSelf(
		decodedParams.codeType,
		decodedParams.codeCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(SortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByTagAndValueDateForSelfParams(
	public val tagType: String,
	public val tagCode: String? = null,
	public val startOfServiceValueDate: Long? = null,
	public val endOfServiceValueDate: Long? = null,
)

public fun byTagAndValueDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTagAndValueDateForSelfParams>(params)
	ServiceFilters.byTagAndValueDateForSelf(
		decodedParams.tagType,
		decodedParams.tagCode,
		decodedParams.startOfServiceValueDate,
		decodedParams.endOfServiceValueDate,
	)
}.toPyString(SortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByPatientsForSelfParams(
	public val patients: List<Patient>,
)

public fun byPatientsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsForSelfParams>(params)
	ServiceFilters.byPatientsForSelf(
		decodedParams.patients,
	)
}.toPyString(SortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByPatientsSecretIdsForSelfParams(
	public val secretIds: List<String>,
)

public fun byPatientsSecretIdsForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsSecretIdsForSelfParams>(params)
	ServiceFilters.byPatientsSecretIdsForSelf(
		decodedParams.secretIds,
	)
}.toPyString(SortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByHealthElementIdFromSubContactForSelfParams(
	public val healthElementIds: List<String>,
)

public fun byHealthElementIdFromSubContactForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByHealthElementIdFromSubContactForSelfParams>(params)
	ServiceFilters.byHealthElementIdFromSubContactForSelf(
		decodedParams.healthElementIds,
	)
}.toPyString(SortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByIdsParams(
	public val ids: List<String>,
)

public fun byIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByIdsParams>(params)
	ServiceFilters.byIds(
		decodedParams.ids,
	)
}.toPyString(BaseSortableFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByAssociationIdParams(
	public val associationId: String,
)

public fun byAssociationId(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByAssociationIdParams>(params)
	ServiceFilters.byAssociationId(
		decodedParams.associationId,
	)
}.toPyString(BaseFilterOptions.serializer(ServiceSerializer))

@Serializable
private class ByQualifiedLinkParams(
	public val linkValues: List<String>,
	public val linkQualification: LinkQualification? = null,
)

public fun byQualifiedLink(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByQualifiedLinkParams>(params)
	ServiceFilters.byQualifiedLink(
		decodedParams.linkValues,
		decodedParams.linkQualification,
	)
}.toPyString(BaseFilterOptions.serializer(ServiceSerializer))
