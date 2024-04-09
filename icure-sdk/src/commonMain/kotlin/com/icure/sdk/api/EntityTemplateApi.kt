package com.icure.sdk.api

import com.icure.sdk.api.raw.RawEntityTemplateApi
import com.icure.sdk.model.EntityTemplate
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.utils.InternalIcureApi

interface EntityTemplateApi {
	suspend fun getEntityTemplate(documentTemplateId: String): EntityTemplate
	suspend fun createEntityTemplate(applicationSettings: EntityTemplate): EntityTemplate
	suspend fun modifyEntityTemplate(documentTemplate: EntityTemplate): EntityTemplate
	suspend fun listEntityTemplatesBy(
		userId: String,
		type: String,
		searchString: String? = null,
		includeEntities: Boolean? = null,
    ): List<EntityTemplate>

	suspend fun listAllEntityTemplatesBy(type: String, searchString: String? = null, includeEntities: Boolean? = null): List<EntityTemplate>
	suspend fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		includeEntities: Boolean? = null,
    ): List<EntityTemplate>

	suspend fun findAllEntityTemplatesByKeyword(type: String, keyword: String, includeEntities: Boolean? = null): List<EntityTemplate>
	suspend fun getEntityTemplates(entityTemplateIds: ListOfIds): List<EntityTemplate>
	suspend fun modifyEntityTemplates(entityTemplates: List<EntityTemplate>): List<EntityTemplate>
	suspend fun createEntityTemplates(entityTemplates: List<EntityTemplate>): List<EntityTemplate>
	suspend fun deleteEntityTemplate(entityTemplateIds: ListOfIds): List<DocIdentifier>
}

@OptIn(InternalIcureApi::class)
class EntityTemplateApiImpl(
	private val rawApi: RawEntityTemplateApi,
) : EntityTemplateApi {
	override suspend fun getEntityTemplate(documentTemplateId: String) = rawApi.getEntityTemplate(documentTemplateId).successBody()

	override suspend fun createEntityTemplate(applicationSettings: EntityTemplate) =
		rawApi.createEntityTemplate(applicationSettings).successBody()

	override suspend fun modifyEntityTemplate(documentTemplate: EntityTemplate) =
		rawApi.modifyEntityTemplate(documentTemplate).successBody()

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

	override suspend fun getEntityTemplates(entityTemplateIds: ListOfIds) = rawApi.getEntityTemplates(entityTemplateIds).successBody()
	override suspend fun modifyEntityTemplates(entityTemplates: List<EntityTemplate>) =
		rawApi.modifyEntityTemplates(entityTemplates).successBody()

	override suspend fun createEntityTemplates(entityTemplates: List<EntityTemplate>) =
		rawApi.createEntityTemplates(entityTemplates).successBody()

	override suspend fun deleteEntityTemplate(entityTemplateIds: ListOfIds) = rawApi.deleteEntityTemplate(entityTemplateIds).successBody()
}

