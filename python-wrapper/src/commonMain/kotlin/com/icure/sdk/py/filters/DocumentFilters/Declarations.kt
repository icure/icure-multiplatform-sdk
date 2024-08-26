// auto-generated file
package com.icure.sdk.py.filters.DocumentFilters

import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.DocumentFilters
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Patient
import com.icure.sdk.model.embed.DocumentType
import com.icure.sdk.py.serialization.DocumentSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
private class ByPatientsCreatedForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientsCreatedForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsCreatedForDataOwnerParams>(params)
	DocumentFilters.byPatientsCreatedForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(DocumentSerializer))

@Serializable
private class ByPatientsCreatedForSelfParams(
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientsCreatedForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsCreatedForSelfParams>(params)
	DocumentFilters.byPatientsCreatedForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(DocumentSerializer))

@Serializable
private class ByPatientSecretIdsCreatedForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsCreatedForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsCreatedForDataOwnerParams>(params)
	DocumentFilters.byPatientSecretIdsCreatedForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(DocumentSerializer))

@Serializable
private class ByPatientSecretIdsCreatedForSelfParams(
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsCreatedForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsCreatedForSelfParams>(params)
	DocumentFilters.byPatientSecretIdsCreatedForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(DocumentSerializer))

@Serializable
private class ByPatientsAndTypeForDataOwnerParams(
	public val dataOwnerId: String,
	public val documentType: DocumentType,
	public val patients: List<Patient>,
)

public fun byPatientsAndTypeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsAndTypeForDataOwnerParams>(params)
	DocumentFilters.byPatientsAndTypeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.documentType,
		decodedParams.patients,
	)
}.toPyString(FilterOptions.serializer(DocumentSerializer))

@Serializable
private class ByPatientsAndTypeForSelfParams(
	public val documentType: DocumentType,
	public val patients: List<Patient>,
)

public fun byPatientsAndTypeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsAndTypeForSelfParams>(params)
	DocumentFilters.byPatientsAndTypeForSelf(
		decodedParams.documentType,
		decodedParams.patients,
	)
}.toPyString(FilterOptions.serializer(DocumentSerializer))

@Serializable
private class ByPatientSecretIdsAndTypeForDataOwnerParams(
	public val dataOwnerId: String,
	public val documentType: DocumentType,
	public val secretIds: List<String>,
)

public fun byPatientSecretIdsAndTypeForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsAndTypeForDataOwnerParams>(params)
	DocumentFilters.byPatientSecretIdsAndTypeForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.documentType,
		decodedParams.secretIds,
	)
}.toPyString(FilterOptions.serializer(DocumentSerializer))

@Serializable
private class ByPatientSecretIdsAndTypeForSelfParams(
	public val documentType: DocumentType,
	public val secretIds: List<String>,
)

public fun byPatientSecretIdsAndTypeForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsAndTypeForSelfParams>(params)
	DocumentFilters.byPatientSecretIdsAndTypeForSelf(
		decodedParams.documentType,
		decodedParams.secretIds,
	)
}.toPyString(FilterOptions.serializer(DocumentSerializer))
