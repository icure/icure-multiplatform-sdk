// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.EntityTemplateApi
import com.icure.sdk.js.api.DefaultParametersSupport.convertingOptionOrDefault
import com.icure.sdk.js.api.EntityTemplateApiJs
import com.icure.sdk.js.api.EntityTemplateApi_listAllEntityTemplatesBy_Options
import com.icure.sdk.js.api.EntityTemplateApi_listEntityTemplatesByKeyword_Options
import com.icure.sdk.js.api.EntityTemplateApi_listEntityTemplatesBy_Options
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
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class EntityTemplateApiImplJs(
	private val entityTemplateApi: EntityTemplateApi,
) : EntityTemplateApiJs {
	override fun getEntityTemplate(documentTemplateId: String): Promise<EntityTemplateJs> =
			GlobalScope.promise {
		val documentTemplateIdConverted: String = documentTemplateId
		val result = entityTemplateApi.getEntityTemplate(
			documentTemplateIdConverted,
		)
		entityTemplate_toJs(result)
	}

	override fun createEntityTemplate(applicationSettings: EntityTemplateJs): Promise<EntityTemplateJs>
			= GlobalScope.promise {
		val applicationSettingsConverted: EntityTemplate = entityTemplate_fromJs(applicationSettings)
		val result = entityTemplateApi.createEntityTemplate(
			applicationSettingsConverted,
		)
		entityTemplate_toJs(result)
	}

	override fun modifyEntityTemplate(documentTemplate: EntityTemplateJs): Promise<EntityTemplateJs> =
			GlobalScope.promise {
		val documentTemplateConverted: EntityTemplate = entityTemplate_fromJs(documentTemplate)
		val result = entityTemplateApi.modifyEntityTemplate(
			documentTemplateConverted,
		)
		entityTemplate_toJs(result)
	}

	override fun listEntityTemplatesBy(
		userId: String,
		type: String,
		options: EntityTemplateApi_listEntityTemplatesBy_Options?,
	): Promise<Array<EntityTemplateJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val typeConverted: String = type
			val searchStringConverted: String? = convertingOptionOrDefault(
				_options.searchString,
				null
			) { searchString ->
				searchString
			}
			val includeEntitiesConverted: Boolean? = convertingOptionOrDefault(
				_options.includeEntities,
				null
			) { includeEntities ->
				includeEntities
			}
			val result = entityTemplateApi.listEntityTemplatesBy(
				userIdConverted,
				typeConverted,
				searchStringConverted,
				includeEntitiesConverted,
			)
			listToArray(
				result,
				{ x1: EntityTemplate ->
					entityTemplate_toJs(x1)
				},
			)
		}
	}

	override fun listAllEntityTemplatesBy(type: String,
			options: EntityTemplateApi_listAllEntityTemplatesBy_Options?): Promise<Array<EntityTemplateJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val typeConverted: String = type
			val searchStringConverted: String? = convertingOptionOrDefault(
				_options.searchString,
				null
			) { searchString ->
				searchString
			}
			val includeEntitiesConverted: Boolean? = convertingOptionOrDefault(
				_options.includeEntities,
				null
			) { includeEntities ->
				includeEntities
			}
			val result = entityTemplateApi.listAllEntityTemplatesBy(
				typeConverted,
				searchStringConverted,
				includeEntitiesConverted,
			)
			listToArray(
				result,
				{ x1: EntityTemplate ->
					entityTemplate_toJs(x1)
				},
			)
		}
	}

	override fun listEntityTemplatesByKeyword(
		userId: String,
		type: String,
		keyword: String,
		options: EntityTemplateApi_listEntityTemplatesByKeyword_Options?,
	): Promise<Array<EntityTemplateJs>> {
		val _options = options ?: js("{}")
		return GlobalScope.promise {
			val userIdConverted: String = userId
			val typeConverted: String = type
			val keywordConverted: String = keyword
			val includeEntitiesConverted: Boolean? = convertingOptionOrDefault(
				_options.includeEntities,
				null
			) { includeEntities ->
				includeEntities
			}
			val result = entityTemplateApi.listEntityTemplatesByKeyword(
				userIdConverted,
				typeConverted,
				keywordConverted,
				includeEntitiesConverted,
			)
			listToArray(
				result,
				{ x1: EntityTemplate ->
					entityTemplate_toJs(x1)
				},
			)
		}
	}

	override fun findAllEntityTemplatesByKeyword(
		type: String,
		keyword: String,
		includeEntities: Boolean?,
	): Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		val typeConverted: String = type
		val keywordConverted: String = keyword
		val includeEntitiesConverted: Boolean? = includeEntities
		val result = entityTemplateApi.findAllEntityTemplatesByKeyword(
			typeConverted,
			keywordConverted,
			includeEntitiesConverted,
		)
		listToArray(
			result,
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)
	}

	override fun getEntityTemplates(entityTemplateIds: Array<String>): Promise<Array<EntityTemplateJs>>
			= GlobalScope.promise {
		val entityTemplateIdsConverted: List<String> = arrayToList(
			entityTemplateIds,
			"entityTemplateIds",
			{ x1: String ->
				x1
			},
		)
		val result = entityTemplateApi.getEntityTemplates(
			entityTemplateIdsConverted,
		)
		listToArray(
			result,
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)
	}

	override fun modifyEntityTemplates(entityTemplates: Array<EntityTemplateJs>):
			Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		val entityTemplatesConverted: List<EntityTemplate> = arrayToList(
			entityTemplates,
			"entityTemplates",
			{ x1: EntityTemplateJs ->
				entityTemplate_fromJs(x1)
			},
		)
		val result = entityTemplateApi.modifyEntityTemplates(
			entityTemplatesConverted,
		)
		listToArray(
			result,
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)
	}

	override fun createEntityTemplates(entityTemplates: Array<EntityTemplateJs>):
			Promise<Array<EntityTemplateJs>> = GlobalScope.promise {
		val entityTemplatesConverted: List<EntityTemplate> = arrayToList(
			entityTemplates,
			"entityTemplates",
			{ x1: EntityTemplateJs ->
				entityTemplate_fromJs(x1)
			},
		)
		val result = entityTemplateApi.createEntityTemplates(
			entityTemplatesConverted,
		)
		listToArray(
			result,
			{ x1: EntityTemplate ->
				entityTemplate_toJs(x1)
			},
		)
	}

	override fun deleteEntityTemplate(entityTemplateIds: Array<String>):
			Promise<Array<DocIdentifierJs>> = GlobalScope.promise {
		val entityTemplateIdsConverted: List<String> = arrayToList(
			entityTemplateIds,
			"entityTemplateIds",
			{ x1: String ->
				x1
			},
		)
		val result = entityTemplateApi.deleteEntityTemplate(
			entityTemplateIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}
}
