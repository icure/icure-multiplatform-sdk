// auto-generated file
package com.icure.sdk.js.api

import com.icure.sdk.js.model.EntityReferenceJs
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("EntityReferenceApi")
public external interface EntityReferenceApiJs {
	public fun getLatest(prefix: String): Promise<EntityReferenceJs>

	public fun createEntityReference(entityReference: EntityReferenceJs): Promise<EntityReferenceJs>
}
