package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.TarificationApi
import com.icure.cardinal.sdk.api.raw.RawTarificationApi
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.Tarification
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class TarificationApiImpl(
	private val rawApi: RawTarificationApi,
) : TarificationApi {
	override suspend fun getTarification(tarificationId: String) = rawApi.getTarification(tarificationId).successBody()

	override suspend fun createTarification(tarification: Tarification) =
		rawApi.createTarification(tarification).successBody()

	override suspend fun getTarifications(tarificationIds: List<String>) = rawApi.getTarifications(
		ListOfIds(
			tarificationIds
		)
	).successBody()

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