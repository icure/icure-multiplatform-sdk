package com.icure.sdk.api

import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.Tarification
import com.icure.sdk.utils.DefaultValue

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

