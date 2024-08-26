// auto-generated file
package com.icure.sdk.py.filters.MessageFilters

import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.FilterOptions
import com.icure.sdk.filters.MessageFilters
import com.icure.sdk.filters.SortableFilterOptions
import com.icure.sdk.model.Patient
import com.icure.sdk.py.serialization.MessageSerializer
import com.icure.sdk.py.utils.toPyString
import com.icure.sdk.utils.Serialization.json
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Set
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
private class AllMessagesForDataOwnerParams(
	public val dataOwnerId: String,
)

public fun allMessagesForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<AllMessagesForDataOwnerParams>(params)
	MessageFilters.allMessagesForDataOwner(
		decodedParams.dataOwnerId,
	)
}.toPyString(BaseFilterOptions.serializer(MessageSerializer))

public fun allMessagesForSelf(): String = kotlin.runCatching {
	MessageFilters.allMessagesForSelf()
}.toPyString(FilterOptions.serializer(MessageSerializer))

@Serializable
private class ByTransportGuidForDataOwnerParams(
	public val dataOwnerId: String,
	public val transportGuid: String,
)

public fun byTransportGuidForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTransportGuidForDataOwnerParams>(params)
	MessageFilters.byTransportGuidForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.transportGuid,
	)
}.toPyString(BaseSortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class ByTransportGuidForSelfParams(
	public val transportGuid: String,
)

public fun byTransportGuidForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTransportGuidForSelfParams>(params)
	MessageFilters.byTransportGuidForSelf(
		decodedParams.transportGuid,
	)
}.toPyString(SortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class FromAddressForDataOwnerParams(
	public val dataOwnerId: String,
	public val address: String,
)

public fun fromAddressForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FromAddressForDataOwnerParams>(params)
	MessageFilters.fromAddressForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.address,
	)
}.toPyString(BaseFilterOptions.serializer(MessageSerializer))

@Serializable
private class FromAddressForSelfParams(
	public val address: String,
)

public fun fromAddressForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<FromAddressForSelfParams>(params)
	MessageFilters.fromAddressForSelf(
		decodedParams.address,
	)
}.toPyString(FilterOptions.serializer(MessageSerializer))

@Serializable
private class ByPatientsSentDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientsSentDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsSentDateForDataOwnerParams>(params)
	MessageFilters.byPatientsSentDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class ByPatientsSentDateForSelfParams(
	public val patients: List<Patient>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientsSentDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientsSentDateForSelfParams>(params)
	MessageFilters.byPatientsSentDateForSelf(
		decodedParams.patients,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class ByPatientSecretIdsSentDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsSentDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsSentDateForDataOwnerParams>(params)
	MessageFilters.byPatientSecretIdsSentDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class ByPatientSecretIdsSentDateForSelfParams(
	public val secretIds: List<String>,
	public val from: Instant? = null,
	public val to: Instant? = null,
	public val descending: Boolean = false,
)

public fun byPatientSecretIdsSentDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByPatientSecretIdsSentDateForSelfParams>(params)
	MessageFilters.byPatientSecretIdsSentDateForSelf(
		decodedParams.secretIds,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class ToAddressForDataOwnerParams(
	public val dataOwnerId: String,
	public val address: String,
)

public fun toAddressForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ToAddressForDataOwnerParams>(params)
	MessageFilters.toAddressForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.address,
	)
}.toPyString(BaseFilterOptions.serializer(MessageSerializer))

@Serializable
private class ToAddressForSelfParams(
	public val address: String,
)

public fun toAddressForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ToAddressForSelfParams>(params)
	MessageFilters.toAddressForSelf(
		decodedParams.address,
	)
}.toPyString(FilterOptions.serializer(MessageSerializer))

@Serializable
private class ByTransportGuidSentDateForDataOwnerParams(
	public val dataOwnerId: String,
	public val transportGuid: String,
	public val from: Instant,
	public val to: Instant,
	public val descending: Boolean = false,
)

public fun byTransportGuidSentDateForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTransportGuidSentDateForDataOwnerParams>(params)
	MessageFilters.byTransportGuidSentDateForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.transportGuid,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(BaseSortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class ByTransportGuidSentDateForSelfParams(
	public val transportGuid: String,
	public val from: Instant,
	public val to: Instant,
	public val descending: Boolean = false,
)

public fun byTransportGuidSentDateForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByTransportGuidSentDateForSelfParams>(params)
	MessageFilters.byTransportGuidSentDateForSelf(
		decodedParams.transportGuid,
		decodedParams.from,
		decodedParams.to,
		decodedParams.descending,
	)
}.toPyString(SortableFilterOptions.serializer(MessageSerializer))

@Serializable
private class LatestByTransportGuidForDataOwnerParams(
	public val dataOwnerId: String,
	public val transportGuid: String,
)

public fun latestByTransportGuidForDataOwner(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<LatestByTransportGuidForDataOwnerParams>(params)
	MessageFilters.latestByTransportGuidForDataOwner(
		decodedParams.dataOwnerId,
		decodedParams.transportGuid,
	)
}.toPyString(BaseFilterOptions.serializer(MessageSerializer))

@Serializable
private class LatestByTransportGuidForSelfParams(
	public val transportGuid: String,
)

public fun latestByTransportGuidForSelf(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<LatestByTransportGuidForSelfParams>(params)
	MessageFilters.latestByTransportGuidForSelf(
		decodedParams.transportGuid,
	)
}.toPyString(FilterOptions.serializer(MessageSerializer))

@Serializable
private class ByInvoiceIdsParams(
	public val invoiceIds: Set<String>,
)

public fun byInvoiceIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByInvoiceIdsParams>(params)
	MessageFilters.byInvoiceIds(
		decodedParams.invoiceIds,
	)
}.toPyString(BaseFilterOptions.serializer(MessageSerializer))

@Serializable
private class ByParentIdsParams(
	public val parentIds: List<String>,
)

public fun byParentIds(params: String): String = kotlin.runCatching {
	val decodedParams = json.decodeFromString<ByParentIdsParams>(params)
	MessageFilters.byParentIds(
		decodedParams.parentIds,
	)
}.toPyString(BaseFilterOptions.serializer(MessageSerializer))
