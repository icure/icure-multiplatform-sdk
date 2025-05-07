package com.icure.cardinal.sdk.api.impl

import com.icure.cardinal.sdk.api.EntityTemplateApi
import com.icure.cardinal.sdk.api.raw.RawEntityTemplateApi
import com.icure.cardinal.sdk.api.raw.successBodyOrNull404
import com.icure.cardinal.sdk.api.raw.successBodyOrThrowRevisionConflict
import com.icure.cardinal.sdk.model.EntityTemplate
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.ListOfIds
import com.icure.cardinal.sdk.model.ListOfIdsAndRev
import com.icure.utils.InternalIcureApi

@InternalIcureApi
internal class EntityTemplateApiImpl(
	private val rawApi: RawEntityTemplateApi,
) : EntityTemplateApi {
	override suspend fun getEntityTemplate(documentTemplateId: String) =
		rawApi.getEntityTemplate(documentTemplateId).successBodyOrNull404()

	override suspend fun createEntityTemplate(applicationSettings: EntityTemplate) =
		rawApi.createEntityTemplate(applicationSettings).successBody()

	override suspend fun modifyEntityTemplate(documentTemplate: EntityTemplate) =
		rawApi.modifyEntityTemplate(documentTemplate).successBodyOrThrowRevisionConflict()

	override suspend fun listEntityTemplatesBy(
		userId: String,
		type: String,
		searchString: String?,
		includeEntities: Boolean?,
	) = rawApi.listEntityTemplatesBy(userId, type, searchString, includeEntities).successBody()

	override suspend fun listAllEntityTemplatesBy(
		type: String,
		searchString: String?,
		includeEntities: Boolean?,
	) = rawApi.listAllEntityTemplatesBy(type, searchString, includeEntities).successBody()

	override suspend fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	) = rawApi.listEntityTemplatesByKeyword(userId, type, keyword, includeEntities).successBody()

	override suspend fun findAllEntityTemplatesByKeyword(
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	) = rawApi.findAllEntityTemplatesByKeyword(type, keyword, includeEntities).successBody()

	override suspend fun getEntityTemplates(entityTemplateIds: List<String>) = rawApi.getEntityTemplates(
		ListOfIds(entityTemplateIds)
	).successBody()
	override suspend fun modifyEntityTemplates(entityTemplates: List<EntityTemplate>) =
		rawApi.modifyEntityTemplates(entityTemplates).successBody()

	override suspend fun createEntityTemplates(entityTemplates: List<EntityTemplate>) =
		rawApi.createEntityTemplates(entityTemplates).successBody()

	override suspend fun deleteEntityTemplates(entityTemplateIds: List<StoredDocumentIdentifier>) = rawApi.deleteEntityTemplatesWithRev(
		ListOfIdsAndRev(entityTemplateIds)
	).successBody()
}
