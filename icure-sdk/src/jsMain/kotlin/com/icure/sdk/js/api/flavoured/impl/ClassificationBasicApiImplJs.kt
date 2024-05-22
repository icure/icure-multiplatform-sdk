// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ClassificationBasicApi
import com.icure.sdk.js.api.flavoured.ClassificationBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedClassificationJs
import com.icure.sdk.js.model.classification_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
public class ClassificationBasicApiImplJs private constructor(
	private val classificationBasicApi: ClassificationBasicApi,
) : ClassificationBasicApiJs {
	override fun deleteClassification(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(classificationBasicApi.deleteClassification(entityId))}


	override fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			classificationBasicApi.deleteClassifications(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)}


	override fun modifyClassification(entity: EncryptedClassificationJs):
			Promise<EncryptedClassificationJs> = GlobalScope.promise {
		classification_toJs(classificationBasicApi.modifyClassification(com.icure.sdk.js.model.classification_fromJs(entity)))}


	override fun getClassification(entityId: String): Promise<EncryptedClassificationJs> =
			GlobalScope.promise {
		classification_toJs(classificationBasicApi.getClassification(entityId))}


	override fun getClassifications(entityIds: Array<String>):
			Promise<Array<EncryptedClassificationJs>> = GlobalScope.promise {
		listToArray(
			classificationBasicApi.getClassifications(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: EncryptedClassification ->
				classification_toJs(x1)
			},
		)}

}
