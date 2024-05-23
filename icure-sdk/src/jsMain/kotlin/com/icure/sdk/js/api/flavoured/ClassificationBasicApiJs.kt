// auto-generated file
package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.model.EncryptedClassificationJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.Promise

@JsName("ClassificationBasicApi")
public external interface ClassificationBasicApiJs {
	public fun deleteClassification(entityId: String): Promise<DocIdentifierJs>

	public fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun modifyClassification(entity: EncryptedClassificationJs):
			Promise<EncryptedClassificationJs>

	public fun getClassification(entityId: String): Promise<EncryptedClassificationJs>

	public fun getClassifications(entityIds: Array<String>): Promise<Array<EncryptedClassificationJs>>
}
