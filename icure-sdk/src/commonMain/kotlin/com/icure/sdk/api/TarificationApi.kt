package com.icure.sdk.api

import com.icure.sdk.api.raw.RawTarificationApi
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Tarification
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi

interface TarificationApi {
	suspend fun getTarification(tarificationId: String): Tarification
	suspend fun createTarification(tarification: Tarification): Tarification
	suspend fun getTarifications(tarificationIds: List<String>): List<Tarification>
	suspend fun modifyTarification(tarification: Tarification): Tarification
	suspend fun findTarificationsByLabel(
		@DefaultValue("null")
		region: String? = null,
		@DefaultValue("null")
		types: String? = null,
		@DefaultValue("null")
		language: String? = null,
		@DefaultValue("null")
		label: String? = null,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null
	): PaginatedList<Tarification>

	suspend fun findTarificationsBy(
		@DefaultValue("null")
		region: String? = null,
		@DefaultValue("null")
		type: String? = null,
		@DefaultValue("null")
		tarification: String? = null,
		@DefaultValue("null")
		version: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		limit: Int? = null
	): PaginatedList<Tarification>

	suspend fun getTarificationWithParts(type: String, tarification: String, version: String): Tarification
}

@InternalIcureApi
internal class TarificationApiImpl(
	private val rawApi: RawTarificationApi,
) : TarificationApi {
	override suspend fun getTarification(tarificationId: String) = rawApi.getTarification(tarificationId).successBody()

	override suspend fun createTarification(tarification: Tarification) =
		rawApi.createTarification(tarification).successBody()

	override suspend fun getTarifications(tarificationIds: List<String>) = rawApi.getTarifications(ListOfIds(tarificationIds)).successBody()

	override suspend fun modifyTarification(tarification: Tarification) = rawApi.modifyTarification(tarification).successBody()

	override suspend fun findTarificationsByLabel(
		region: String?,
		types: String?,
		language: String?,
		label: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findTarificationsByLabel(region, types, language, label, startKey, startDocumentId, limit).successBody()

	override suspend fun findTarificationsBy(
		region: String?,
		type: String?,
		tarification: String?,
		version: String?,
		startDocumentId: String?,
		startKey: String?,
		limit: Int?,
	) = rawApi.findTarificationsBy(region, type, tarification, version, startDocumentId, startKey, limit).successBody()

	override suspend fun getTarificationWithParts(
		type: String,
		tarification: String,
		version: String,
	) = rawApi.getTarificationWithParts(type, tarification, version).successBody()
}

