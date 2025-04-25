package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.model.EntityTemplate
import com.icure.cardinal.sdk.model.StoredDocumentIdentifier
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue

interface EntityTemplateApi {
	suspend fun getEntityTemplate(documentTemplateId: String): EntityTemplate?
	suspend fun createEntityTemplate(applicationSettings: EntityTemplate): EntityTemplate
	suspend fun modifyEntityTemplate(documentTemplate: EntityTemplate): EntityTemplate
	suspend fun listEntityTemplatesBy(
		userId: String,
		type: String,
		@DefaultValue("null")
		searchString: String? = null,
		@DefaultValue("null")
		includeEntities: Boolean? = null,
    ): List<EntityTemplate>

	suspend fun listAllEntityTemplatesBy(
		type: String,
		@DefaultValue("null")
		searchString: String? = null,
		@DefaultValue("null")
		includeEntities: Boolean? = null
	): List<EntityTemplate>
	suspend fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		@DefaultValue("null")
		includeEntities: Boolean? = null,
    ): List<EntityTemplate>

	suspend fun findAllEntityTemplatesByKeyword(type: String, keyword: String, includeEntities: Boolean? = null): List<EntityTemplate>
	suspend fun getEntityTemplates(entityTemplateIds: List<String>): List<EntityTemplate>
	suspend fun modifyEntityTemplates(entityTemplates: List<EntityTemplate>): List<EntityTemplate>
	suspend fun createEntityTemplates(entityTemplates: List<EntityTemplate>): List<EntityTemplate>
	suspend fun deleteEntityTemplates(entityTemplateIds: List<StoredDocumentIdentifier>): List<DocIdentifier>
}

