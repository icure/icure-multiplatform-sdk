// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.model.EntityTemplateJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("EntityTemplateApi")
public external interface EntityTemplateApiJs {
	public fun getEntityTemplate(documentTemplateId: String): Promise<EntityTemplateJs?>

	public fun createEntityTemplate(applicationSettings: EntityTemplateJs): Promise<EntityTemplateJs>

	public fun modifyEntityTemplate(documentTemplate: EntityTemplateJs): Promise<EntityTemplateJs>

	public fun listEntityTemplatesBy(
		userId: String,
		type: String,
		options: dynamic,
	): Promise<Array<EntityTemplateJs>>

	public fun listAllEntityTemplatesBy(type: String, options: dynamic):
			Promise<Array<EntityTemplateJs>>

	public fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		options: dynamic,
	): Promise<Array<EntityTemplateJs>>

	public fun findAllEntityTemplatesByKeyword(
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	): Promise<Array<EntityTemplateJs>>

	public fun getEntityTemplates(entityTemplateIds: Array<String>): Promise<Array<EntityTemplateJs>>

	public fun modifyEntityTemplates(entityTemplates: Array<EntityTemplateJs>):
			Promise<Array<EntityTemplateJs>>

	public fun createEntityTemplates(entityTemplates: Array<EntityTemplateJs>):
			Promise<Array<EntityTemplateJs>>

	public fun deleteEntityTemplates(entityTemplateIds: Array<StoredDocumentIdentifierJs>):
			Promise<Array<DocIdentifierJs>>
}
