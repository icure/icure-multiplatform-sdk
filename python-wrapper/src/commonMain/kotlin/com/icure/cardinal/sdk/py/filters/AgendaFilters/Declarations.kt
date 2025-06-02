// auto-generated file
package com.icure.cardinal.sdk.py.filters.AgendaFilters

import com.icure.cardinal.sdk.filters.AgendaFilters
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.model.Agenda
import com.icure.cardinal.sdk.model.EntityReferenceInGroup
import com.icure.cardinal.sdk.py.utils.toPyString
import com.icure.cardinal.sdk.utils.Serialization.fullLanguageInteropJson
import com.icure.utils.InternalIcureApi
import kotlin.Boolean
import kotlin.Double
import kotlin.Long
import kotlin.OptIn
import kotlin.String
import kotlinx.serialization.Serializable

public fun all(): String = kotlin.runCatching {
	AgendaFilters.all()
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ByUserParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun byUser(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByUserParams>(params)
	AgendaFilters.byUser(
		decodedParams.userId,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ByUserInGroupParams(
	public val userReference: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun byUserInGroup(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByUserInGroupParams>(params)
	AgendaFilters.byUserInGroup(
		decodedParams.userReference,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ReadableByUserParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun readableByUser(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ReadableByUserParams>(params)
	AgendaFilters.readableByUser(
		decodedParams.userId,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ReadableByUserInGroupParams(
	public val userReference: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun readableByUserInGroup(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ReadableByUserInGroupParams>(params)
	AgendaFilters.readableByUserInGroup(
		decodedParams.userReference,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ReadableByUserRightsParams(
	public val userId: String,
)

@OptIn(InternalIcureApi::class)
public fun readableByUserRights(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ReadableByUserRightsParams>(params)
	AgendaFilters.readableByUserRights(
		decodedParams.userId,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ReadableByUserRightsInGroupParams(
	public val userReference: EntityReferenceInGroup,
)

@OptIn(InternalIcureApi::class)
public fun readableByUserRightsInGroup(params: String): String = kotlin.runCatching {
	val decodedParams =
			fullLanguageInteropJson.decodeFromString<ReadableByUserRightsInGroupParams>(params)
	AgendaFilters.readableByUserRightsInGroup(
		decodedParams.userReference,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ByStringPropertyParams(
	public val propertyId: String,
	public val propertyValue: String,
)

@OptIn(InternalIcureApi::class)
public fun byStringProperty(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByStringPropertyParams>(params)
	AgendaFilters.byStringProperty(
		decodedParams.propertyId,
		decodedParams.propertyValue,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ByBooleanPropertyParams(
	public val propertyId: String,
	public val propertyValue: Boolean,
)

@OptIn(InternalIcureApi::class)
public fun byBooleanProperty(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByBooleanPropertyParams>(params)
	AgendaFilters.byBooleanProperty(
		decodedParams.propertyId,
		decodedParams.propertyValue,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ByLongPropertyParams(
	public val propertyId: String,
	public val propertyValue: Long,
)

@OptIn(InternalIcureApi::class)
public fun byLongProperty(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByLongPropertyParams>(params)
	AgendaFilters.byLongProperty(
		decodedParams.propertyId,
		decodedParams.propertyValue,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class ByDoublePropertyParams(
	public val propertyId: String,
	public val propertyValue: Double,
)

@OptIn(InternalIcureApi::class)
public fun byDoubleProperty(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<ByDoublePropertyParams>(params)
	AgendaFilters.byDoubleProperty(
		decodedParams.propertyId,
		decodedParams.propertyValue,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))

@Serializable
private class WithPropertyParams(
	public val propertyId: String,
)

@OptIn(InternalIcureApi::class)
public fun withProperty(params: String): String = kotlin.runCatching {
	val decodedParams = fullLanguageInteropJson.decodeFromString<WithPropertyParams>(params)
	AgendaFilters.withProperty(
		decodedParams.propertyId,
	)
}.toPyString(BaseFilterOptions.serializer(Agenda.serializer()))
