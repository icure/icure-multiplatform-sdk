package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.Tarification
import com.icure.cardinal.sdk.utils.DefaultValue

interface TarificationApi {
	suspend fun getTarification(tarificationId: String): Tarification
	suspend fun createTarification(tarification: Tarification): Tarification
	suspend fun getTarifications(tarificationIds: List<String>): List<Tarification>
	suspend fun modifyTarification(tarification: Tarification): Tarification
	@Deprecated("Will be replaced by filters")
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
	@Deprecated("Will be replaced by filters")
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

