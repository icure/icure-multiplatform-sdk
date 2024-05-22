// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.EntityTemplateApi
import com.icure.sdk.js.api.EntityTemplateApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EntityTemplateJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.entityTemplate_fromJs
import com.icure.sdk.js.model.entityTemplate_toJs
import com.icure.sdk.model.EntityTemplate
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.Boolean
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class EntityTemplateApiImplJs private constructor(
	private val entityTemplateApi: EntityTemplateApi,
) : EntityTemplateApiJs {
	override fun getEntityTemplate(documentTemplateId: String): Promise<EntityTemplateJs> =
			GlobalScope.promise {
		entityTemplate_toJs(entityTemplateApi.getEntityTemplate(documentTemplateId))}


	override fun createEntityTemplate(applicationSettings: EntityTemplateJs): Promise<EntityTemplateJs>
			= GlobalScope.promise {
		entityTemplate_toJs(entityTemplateApi.createEntityTemplate(com.icure.sdk.js.model.entityTemplate_fromJs(applicationSettings)))}


	override fun modifyEntityTemplate(documentTemplate: EntityTemplateJs): Promise<EntityTemplateJs> =
			GlobalScope.promise {
		entityTemplate_toJs(entityTemplateApi.modifyEntityTemplate(com.icure.sdk.js.model.entityTemplate_fromJs(documentTemplate)))}


	override fun listEntityTemplatesBy(
		userId: String,
		type: String,
		searchString: String?,
		includeEntities: Boolean?,
	): Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		listToArray(
			entityTemplateApi.listEntityTemplatesBy(userId, type, searchString, includeEntities),
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)}


	override fun listAllEntityTemplatesBy(
		type: String,
		searchString: String?,
		includeEntities: Boolean?,
	): Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		listToArray(
			entityTemplateApi.listAllEntityTemplatesBy(type, searchString, includeEntities),
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)}


	override fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	): Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		listToArray(
			entityTemplateApi.listEntityTemplatesByKeyword(userId, type, keyword, includeEntities),
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)}


	override fun findAllEntityTemplatesByKeyword(
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	): Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		listToArray(
			entityTemplateApi.findAllEntityTemplatesByKeyword(type, keyword, includeEntities),
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)}


	override fun getEntityTemplates(entityTemplateIds: Array<String>): Promise<Array<EntityTemplateJs>>
			= GlobalScope.promise {
		listToArray(
			entityTemplateApi.getEntityTemplates(arrayToList(
				entityTemplateIds,
				"entityTemplateIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)}


	override fun modifyEntityTemplates(entityTemplates: Array<EntityTemplateJs>):
			Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		listToArray(
			entityTemplateApi.modifyEntityTemplates(arrayToList(
				entityTemplates,
				"entityTemplates",
				{ x1: EntityTemplateJs ->
					entityTemplate_fromJs(x1)
				},
			)),
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)}


	override fun createEntityTemplates(entityTemplates: Array<EntityTemplateJs>):
			Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		listToArray(
			entityTemplateApi.createEntityTemplates(arrayToList(
				entityTemplates,
				"entityTemplates",
				{ x1: EntityTemplateJs ->
					entityTemplate_fromJs(x1)
				},
			)),
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)}


	override fun deleteEntityTemplate(entityTemplateIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		listToArray(
			entityTemplateApi.deleteEntityTemplate(arrayToList(
				entityTemplateIds,
				"entityTemplateIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}

}
