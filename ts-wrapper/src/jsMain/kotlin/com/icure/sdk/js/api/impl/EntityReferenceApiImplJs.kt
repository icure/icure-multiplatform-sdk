// auto-generated file
package com.icure.sdk.js.api.`impl`

import com.icure.sdk.api.EntityReferenceApi
import com.icure.sdk.js.api.EntityReferenceApiJs
import com.icure.sdk.js.model.EntityReferenceJs
import com.icure.sdk.js.model.entityReference_fromJs
import com.icure.sdk.js.model.entityReference_toJs
import com.icure.sdk.model.EntityReference
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class EntityReferenceApiImplJs(
	private val entityReferenceApi: EntityReferenceApi,
) : EntityReferenceApiJs {
	override fun getLatest(prefix: String): Promise<EntityReferenceJs> = GlobalScope.promise {
		val prefixConverted: String = prefix
		val result = entityReferenceApi.getLatest(
			prefixConverted,
		)
		entityReference_toJs(result)
	}

	override fun createEntityReference(entityReference: EntityReferenceJs): Promise<EntityReferenceJs>
			= GlobalScope.promise {
		val entityReferenceConverted: EntityReference = entityReference_fromJs(entityReference)
		val result = entityReferenceApi.createEntityReference(
			entityReferenceConverted,
		)
		entityReference_toJs(result)
	}
}