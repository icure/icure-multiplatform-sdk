// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.ClassificationApi
import com.icure.sdk.js.api.flavoured.ClassificationApiJs
import com.icure.sdk.js.api.flavoured.ClassificationFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.ClassificationJs
import com.icure.sdk.js.model.DecryptedClassificationJs
import com.icure.sdk.js.model.EncryptedClassificationJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.classification_fromJs
import com.icure.sdk.js.model.classification_toJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.Classification
import com.icure.sdk.model.DecryptedClassification
import com.icure.sdk.model.EncryptedClassification
import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.specializations.HexString
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.OptIn
import kotlin.String
import kotlin.Unit
import kotlin.js.Promise
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.promise

@OptIn(DelicateCoroutinesApi::class)
internal class ClassificationApiImplJs(
	private val classificationApi: ClassificationApi,
) : ClassificationApiJs {
	override val encrypted: ClassificationFlavouredApiJs<EncryptedClassificationJs> = object :
			ClassificationFlavouredApiJs<EncryptedClassificationJs> {
		override fun shareWith(
			delegateId: String,
			classification: EncryptedClassificationJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedClassificationJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				classificationApi.encrypted.shareWith(delegateId,
						com.icure.sdk.js.model.classification_fromJs(classification),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: EncryptedClassification ->
					classification_toJs(x1)
				},
			)}


		override fun tryShareWithMany(classification: EncryptedClassificationJs, delegates: dynamic):
				Promise<SimpleShareResultJs<EncryptedClassificationJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				classificationApi.encrypted.tryShareWithMany(com.icure.sdk.js.model.classification_fromJs(classification),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.classificationShareOptions_fromJs(x1)
				  },
				)),
				{ x1: EncryptedClassification ->
					classification_toJs(x1)
				},
			)}


		override fun shareWithMany(classification: EncryptedClassificationJs, delegates: dynamic):
				Promise<EncryptedClassificationJs> = GlobalScope.promise {
			classification_toJs(classificationApi.encrypted.shareWithMany(com.icure.sdk.js.model.classification_fromJs(classification),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.classificationShareOptions_fromJs(x1)
			  },
			)))}


		override fun findClassificationsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedClassificationJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				classificationApi.encrypted.findClassificationsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedClassification ->
					classification_toJs(x1)
				},
			)}


		override fun modifyClassification(entity: EncryptedClassificationJs):
				Promise<EncryptedClassificationJs> = GlobalScope.promise {
			classification_toJs(classificationApi.encrypted.modifyClassification(com.icure.sdk.js.model.classification_fromJs(entity)))}


		override fun getClassification(entityId: String): Promise<EncryptedClassificationJs> =
				GlobalScope.promise {
			classification_toJs(classificationApi.encrypted.getClassification(entityId))}


		override fun getClassifications(entityIds: Array<String>):
				Promise<Array<EncryptedClassificationJs>> = GlobalScope.promise {
			listToArray(
				classificationApi.encrypted.getClassifications(arrayToList(
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

	override val tryAndRecover: ClassificationFlavouredApiJs<ClassificationJs> = object :
			ClassificationFlavouredApiJs<ClassificationJs> {
		override fun shareWith(
			delegateId: String,
			classification: ClassificationJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<ClassificationJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				classificationApi.tryAndRecover.shareWith(delegateId,
						com.icure.sdk.js.model.classification_fromJs(classification),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)}


		override fun tryShareWithMany(classification: ClassificationJs, delegates: dynamic):
				Promise<SimpleShareResultJs<ClassificationJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				classificationApi.tryAndRecover.tryShareWithMany(com.icure.sdk.js.model.classification_fromJs(classification),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.classificationShareOptions_fromJs(x1)
				  },
				)),
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)}


		override fun shareWithMany(classification: ClassificationJs, delegates: dynamic):
				Promise<ClassificationJs> = GlobalScope.promise {
			classification_toJs(classificationApi.tryAndRecover.shareWithMany(com.icure.sdk.js.model.classification_fromJs(classification),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.classificationShareOptions_fromJs(x1)
			  },
			)))}


		override fun findClassificationsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<ClassificationJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				classificationApi.tryAndRecover.findClassificationsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)}


		override fun modifyClassification(entity: ClassificationJs): Promise<ClassificationJs> =
				GlobalScope.promise {
			classification_toJs(classificationApi.tryAndRecover.modifyClassification(com.icure.sdk.js.model.classification_fromJs(entity)))}


		override fun getClassification(entityId: String): Promise<ClassificationJs> =
				GlobalScope.promise {
			classification_toJs(classificationApi.tryAndRecover.getClassification(entityId))}


		override fun getClassifications(entityIds: Array<String>): Promise<Array<ClassificationJs>> =
				GlobalScope.promise {
			listToArray(
				classificationApi.tryAndRecover.getClassifications(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: Classification ->
					classification_toJs(x1)
				},
			)}

	}

	override fun createClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs> = GlobalScope.promise {
		classification_toJs(classificationApi.createClassification(com.icure.sdk.js.model.classification_fromJs(entity)))}


	override fun withEncryptionMetadata(
		base: DecryptedClassificationJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedClassificationJs> = GlobalScope.promise {
		classification_toJs(classificationApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.classification_fromJs(nonNull1)
		}, com.icure.sdk.js.model.patient_fromJs(patient), user?.let { nonNull1 ->
		  com.icure.sdk.js.model.user_fromJs(nonNull1)
		}, com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: kotlin.String ->
		    com.icure.sdk.model.embed.AccessLevel.valueOf(x1)
		  },
		), com.icure.sdk.js.crypto.entities.secretIdOption_fromJs(secretId)))}


	override fun getEncryptionKeysOf(classification: ClassificationJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			classificationApi.getEncryptionKeysOf(classification_fromJs(classification)),
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)}


	override fun hasWriteAccess(classification: ClassificationJs): Promise<Boolean> =
			GlobalScope.promise {
		classificationApi.hasWriteAccess(classification_fromJs(classification))}


	override fun decryptPatientIdOf(classification: ClassificationJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			classificationApi.decryptPatientIdOf(classification_fromJs(classification)),
			{ x1: String ->
				x1
			},
		)}


	override fun createDelegationDeAnonymizationMetadata(entity: ClassificationJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		classificationApi.createDelegationDeAnonymizationMetadata(classification_fromJs(entity),
				arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		))}


	override fun deleteClassification(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(classificationApi.deleteClassification(entityId))}


	override fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			classificationApi.deleteClassifications(arrayToList(
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


	override fun shareWith(
		delegateId: String,
		classification: DecryptedClassificationJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedClassificationJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			classificationApi.shareWith(delegateId,
					com.icure.sdk.js.model.classification_fromJs(classification),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
					com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)}


	override fun tryShareWithMany(classification: DecryptedClassificationJs, delegates: dynamic):
			Promise<SimpleShareResultJs<DecryptedClassificationJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			classificationApi.tryShareWithMany(com.icure.sdk.js.model.classification_fromJs(classification),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.classificationShareOptions_fromJs(x1)
			  },
			)),
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)}


	override fun shareWithMany(classification: DecryptedClassificationJs, delegates: dynamic):
			Promise<DecryptedClassificationJs> = GlobalScope.promise {
		classification_toJs(classificationApi.shareWithMany(com.icure.sdk.js.model.classification_fromJs(classification),
				com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs ->
		    com.icure.sdk.js.crypto.entities.classificationShareOptions_fromJs(x1)
		  },
		)))}


	override fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedClassificationJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			classificationApi.findClassificationsByHcPartyPatient(hcPartyId,
					com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)}


	override fun modifyClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs> = GlobalScope.promise {
		classification_toJs(classificationApi.modifyClassification(com.icure.sdk.js.model.classification_fromJs(entity)))}


	override fun getClassification(entityId: String): Promise<DecryptedClassificationJs> =
			GlobalScope.promise {
		classification_toJs(classificationApi.getClassification(entityId))}


	override fun getClassifications(entityIds: Array<String>):
			Promise<Array<DecryptedClassificationJs>> = GlobalScope.promise {
		listToArray(
			classificationApi.getClassifications(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedClassification ->
				classification_toJs(x1)
			},
		)}

}
