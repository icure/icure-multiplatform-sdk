// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ClassificationBasicApi
import com.icure.sdk.js.api.flavoured.ClassificationBasicApiJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.EncryptedClassificationJs
import com.icure.sdk.js.model.classification_fromJs
import com.icure.sdk.js.model.classification_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.couchdb.DocIdentifier
import kotlin.Array
import kotlin.OptIn
import kotlin.String
import kotlin.collections.List
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ClassificationBasicApiImplJs(
	private val classificationBasicApi: ClassificationBasicApi,
) : ClassificationBasicApiJs {
	override fun deleteClassification(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = classificationBasicApi.deleteClassification(
			entityIdConverted,
		)
		docIdentifier_toJs(result)
	}

	override fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = classificationBasicApi.deleteClassifications(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: DocIdentifier ->
				docIdentifier_toJs(x1)
			},
		)
	}

	override fun modifyClassification(entity: EncryptedClassificationJs):
			Promise<EncryptedClassificationJs> = GlobalScope.promise {
		val entityConverted: EncryptedClassification = classification_fromJs(entity)
		val result = classificationBasicApi.modifyClassification(
			entityConverted,
		)
		classification_toJs(result)
	}

	override fun getClassification(entityId: String): Promise<EncryptedClassificationJs> =
			GlobalScope.promise {
		val entityIdConverted: String = entityId
		val result = classificationBasicApi.getClassification(
			entityIdConverted,
		)
		classification_toJs(result)
	}

	override fun getClassifications(entityIds: Array<String>):
			Promise<Array<EncryptedClassificationJs>> = GlobalScope.promise {
		val entityIdsConverted: List<String> = arrayToList(
			entityIds,
			"entityIds",
			{ x1: String ->
				x1
			},
		)
		val result = classificationBasicApi.getClassifications(
			entityIdsConverted,
		)
		listToArray(
			result,
			{ x1: EncryptedClassification ->
				classification_toJs(x1)
			},
		)
	}
}
