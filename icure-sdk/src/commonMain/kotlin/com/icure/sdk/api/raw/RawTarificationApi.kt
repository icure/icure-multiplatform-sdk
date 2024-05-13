package com.icure.sdk.api.raw

import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Tarification
import com.icure.sdk.utils.InternalIcureApi
import kotlin.Int
import kotlin.String
import kotlin.collections.List

// WARNING: This class is auto-generated. If you change it manually, your changes will be lost.
// If you want to change the way this class is generated, see [this repo](https://github.com/icure/sdk-codegen).
@InternalIcureApi
public interface RawTarificationApi {
	// region common endpoints

	suspend fun findTarificationsByLabel(
		region: String? = null,
		types: String? = null,
		language: String? = null,
		label: String? = null,
		startKey: String? = null,
		startDocumentId: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Tarification>>

	suspend fun findTarificationsBy(
		region: String? = null,
		type: String? = null,
		tarification: String? = null,
		version: String? = null,
		startDocumentId: String? = null,
		startKey: String? = null,
		limit: Int? = null,
	): HttpResponse<PaginatedList<Tarification>>

	suspend fun findTarificationsBy(
		region: String? = null,
		type: String? = null,
		tarification: String? = null,
		version: String? = null,
	): HttpResponse<List<Tarification>>

	suspend fun createTarification(c: Tarification): HttpResponse<Tarification>

	suspend fun getTarifications(tarificationIds: ListOfIds): HttpResponse<List<Tarification>>

	suspend fun getTarification(tarificationId: String): HttpResponse<Tarification>

	suspend fun getTarificationWithParts(
		type: String,
		tarification: String,
		version: String,
	): HttpResponse<Tarification>

	suspend fun modifyTarification(tarificationDto: Tarification): HttpResponse<Tarification>
	// endregion
}
