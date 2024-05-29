// auto-generated file
package com.icure.sdk.js.api.flavoured.`impl`

import com.icure.sdk.api.flavoured.HealthcareElementApi
import com.icure.sdk.js.api.flavoured.HealthcareElementApiJs
import com.icure.sdk.js.api.flavoured.HealthcareElementFlavouredApiJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.crypto.entities.simpleShareResult_toJs
import com.icure.sdk.js.model.CheckedConverters.arrayToList
import com.icure.sdk.js.model.CheckedConverters.arrayToSet
import com.icure.sdk.js.model.CheckedConverters.listToArray
import com.icure.sdk.js.model.CheckedConverters.setToArray
import com.icure.sdk.js.model.DecryptedHealthElementJs
import com.icure.sdk.js.model.EncryptedHealthElementJs
import com.icure.sdk.js.model.HealthElementJs
import com.icure.sdk.js.model.IcureStubJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.couchdb.docIdentifier_toJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.abstractFilter_fromJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import com.icure.sdk.js.model.healthElement_fromJs
import com.icure.sdk.js.model.healthElement_toJs
import com.icure.sdk.js.model.icureStub_toJs
import com.icure.sdk.js.model.paginatedList_toJs
import com.icure.sdk.js.model.specializations.hexString_toJs
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import com.icure.sdk.js.utils.pagination.paginatedListIterator_toJs
import com.icure.sdk.model.DecryptedHealthElement
import com.icure.sdk.model.EncryptedHealthElement
import com.icure.sdk.model.HealthElement
import com.icure.sdk.model.IcureStub
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
internal class HealthcareElementApiImplJs(
	private val healthcareElementApi: HealthcareElementApi,
) : HealthcareElementApiJs {
	override val encrypted: HealthcareElementFlavouredApiJs<EncryptedHealthElementJs> = object :
			HealthcareElementFlavouredApiJs<EncryptedHealthElementJs> {
		override fun shareWith(
			delegateId: String,
			healthcareElement: EncryptedHealthElementJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				healthcareElementApi.encrypted.shareWith(delegateId,
						com.icure.sdk.js.model.healthElement_fromJs(healthcareElement),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun tryShareWithMany(healthElement: EncryptedHealthElementJs, delegates: dynamic):
				Promise<SimpleShareResultJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				healthcareElementApi.encrypted.tryShareWithMany(com.icure.sdk.js.model.healthElement_fromJs(healthElement),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.HealthElementShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.healthElementShareOptions_fromJs(x1)
				  },
				)),
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun shareWithMany(healthElement: EncryptedHealthElementJs, delegates: dynamic):
				Promise<EncryptedHealthElementJs> = GlobalScope.promise {
			healthElement_toJs(healthcareElementApi.encrypted.shareWithMany(com.icure.sdk.js.model.healthElement_fromJs(healthElement),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.HealthElementShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.healthElementShareOptions_fromJs(x1)
			  },
			)))}


		override fun findHealthcareElementsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				healthcareElementApi.encrypted.findHealthcareElementsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun modifyHealthcareElement(entity: EncryptedHealthElementJs):
				Promise<EncryptedHealthElementJs> = GlobalScope.promise {
			healthElement_toJs(healthcareElementApi.encrypted.modifyHealthcareElement(com.icure.sdk.js.model.healthElement_fromJs(entity)))}


		override fun modifyHealthcareElements(entities: Array<EncryptedHealthElementJs>):
				Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
			listToArray(
				healthcareElementApi.encrypted.modifyHealthcareElements(arrayToList(
					entities,
					"entities",
					{ x1: EncryptedHealthElementJs ->
						healthElement_fromJs(x1)
					},
				)),
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun getHealthcareElement(entityId: String): Promise<EncryptedHealthElementJs> =
				GlobalScope.promise {
			healthElement_toJs(healthcareElementApi.encrypted.getHealthcareElement(entityId))}


		override fun getHealthcareElements(entityIds: Array<String>):
				Promise<Array<EncryptedHealthElementJs>> = GlobalScope.promise {
			listToArray(
				healthcareElementApi.encrypted.getHealthcareElements(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun filterHealthcareElementsBy(
			filterChain: FilterChainJs<HealthElementJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<EncryptedHealthElementJs>> = GlobalScope.promise {
			paginatedList_toJs(
				healthcareElementApi.encrypted.filterHealthcareElementsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.HealthElementJs ->
				    com.icure.sdk.js.model.healthElement_fromJs(x1)
				  },
				), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<EncryptedHealthElementJs>> =
				GlobalScope.promise {
			listToArray(
				healthcareElementApi.encrypted.findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId,
						arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: EncryptedHealthElement ->
					healthElement_toJs(x1)
				},
			)}

	}

	override val tryAndRecover: HealthcareElementFlavouredApiJs<HealthElementJs> = object :
			HealthcareElementFlavouredApiJs<HealthElementJs> {
		override fun shareWith(
			delegateId: String,
			healthcareElement: HealthElementJs,
			shareEncryptionKeys: String,
			shareOwningEntityIds: String,
			requestedPermission: String,
		): Promise<SimpleShareResultJs<HealthElementJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				healthcareElementApi.tryAndRecover.shareWith(delegateId,
						com.icure.sdk.js.model.healthElement_fromJs(healthcareElement),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
						com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
						com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun tryShareWithMany(healthElement: HealthElementJs, delegates: dynamic):
				Promise<SimpleShareResultJs<HealthElementJs>> = GlobalScope.promise {
			simpleShareResult_toJs(
				healthcareElementApi.tryAndRecover.tryShareWithMany(com.icure.sdk.js.model.healthElement_fromJs(healthElement),
						com.icure.sdk.js.model.CheckedConverters.objectToMap(
				  delegates,
				  "delegates",
				  { x1: kotlin.String ->
				    x1
				  },
				  { x1: com.icure.sdk.js.crypto.entities.HealthElementShareOptionsJs ->
				    com.icure.sdk.js.crypto.entities.healthElementShareOptions_fromJs(x1)
				  },
				)),
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun shareWithMany(healthElement: HealthElementJs, delegates: dynamic):
				Promise<HealthElementJs> = GlobalScope.promise {
			healthElement_toJs(healthcareElementApi.tryAndRecover.shareWithMany(com.icure.sdk.js.model.healthElement_fromJs(healthElement),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.HealthElementShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.healthElementShareOptions_fromJs(x1)
			  },
			)))}


		override fun findHealthcareElementsByHcPartyPatient(
			hcPartyId: String,
			patient: PatientJs,
			startDate: Double?,
			endDate: Double?,
			descending: Boolean?,
		): Promise<PaginatedListIteratorJs<HealthElementJs>> = GlobalScope.promise {
			paginatedListIterator_toJs(
				healthcareElementApi.tryAndRecover.findHealthcareElementsByHcPartyPatient(hcPartyId,
						com.icure.sdk.js.model.patient_fromJs(patient),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
						com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun modifyHealthcareElement(entity: HealthElementJs): Promise<HealthElementJs> =
				GlobalScope.promise {
			healthElement_toJs(healthcareElementApi.tryAndRecover.modifyHealthcareElement(com.icure.sdk.js.model.healthElement_fromJs(entity)))}


		override fun modifyHealthcareElements(entities: Array<HealthElementJs>):
				Promise<Array<HealthElementJs>> = GlobalScope.promise {
			listToArray(
				healthcareElementApi.tryAndRecover.modifyHealthcareElements(arrayToList(
					entities,
					"entities",
					{ x1: HealthElementJs ->
						healthElement_fromJs(x1)
					},
				)),
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun getHealthcareElement(entityId: String): Promise<HealthElementJs> =
				GlobalScope.promise {
			healthElement_toJs(healthcareElementApi.tryAndRecover.getHealthcareElement(entityId))}


		override fun getHealthcareElements(entityIds: Array<String>): Promise<Array<HealthElementJs>> =
				GlobalScope.promise {
			listToArray(
				healthcareElementApi.tryAndRecover.getHealthcareElements(arrayToList(
					entityIds,
					"entityIds",
					{ x1: String ->
						x1
					},
				)),
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun filterHealthcareElementsBy(
			filterChain: FilterChainJs<HealthElementJs>,
			startDocumentId: String?,
			limit: Double?,
		): Promise<PaginatedListJs<HealthElementJs>> = GlobalScope.promise {
			paginatedList_toJs(
				healthcareElementApi.tryAndRecover.filterHealthcareElementsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
				  filterChain,
				  { x1: com.icure.sdk.js.model.HealthElementJs ->
				    com.icure.sdk.js.model.healthElement_fromJs(x1)
				  },
				), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)}


		override fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
				secretPatientKeys: Array<String>): Promise<Array<HealthElementJs>> = GlobalScope.promise {
			listToArray(
				healthcareElementApi.tryAndRecover.findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId,
						arrayToList(
					secretPatientKeys,
					"secretPatientKeys",
					{ x1: String ->
						x1
					},
				)),
				{ x1: HealthElement ->
					healthElement_toJs(x1)
				},
			)}

	}

	override fun createHealthcareElement(entity: DecryptedHealthElementJs):
			Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		healthElement_toJs(healthcareElementApi.createHealthcareElement(com.icure.sdk.js.model.healthElement_fromJs(entity)))}


	override fun createHealthcareElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		listToArray(
			healthcareElementApi.createHealthcareElements(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)),
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun withEncryptionMetadata(
		base: DecryptedHealthElementJs?,
		patient: PatientJs,
		user: UserJs?,
		delegates: dynamic,
		secretId: SecretIdOptionJs,
	): Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		healthElement_toJs(healthcareElementApi.withEncryptionMetadata(base?.let { nonNull1 ->
		  com.icure.sdk.js.model.healthElement_fromJs(nonNull1)
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


	override fun getEncryptionKeysOf(healthElement: HealthElementJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			healthcareElementApi.getEncryptionKeysOf(healthElement_fromJs(healthElement)),
			{ x1: HexString ->
				hexString_toJs(x1)
			},
		)}


	override fun hasWriteAccess(healthElement: HealthElementJs): Promise<Boolean> =
			GlobalScope.promise {
		healthcareElementApi.hasWriteAccess(healthElement_fromJs(healthElement))}


	override fun decryptPatientIdOf(healthElement: HealthElementJs): Promise<Array<String>> =
			GlobalScope.promise {
		setToArray(
			healthcareElementApi.decryptPatientIdOf(healthElement_fromJs(healthElement)),
			{ x1: String ->
				x1
			},
		)}


	override fun createDelegationDeAnonymizationMetadata(entity: HealthElementJs,
			delegates: Array<String>): Promise<Unit> = GlobalScope.promise {
		healthcareElementApi.createDelegationDeAnonymizationMetadata(healthElement_fromJs(entity),
				arrayToSet(
			delegates,
			"delegates",
			{ x1: String ->
				x1
			},
		))}


	override fun matchHealthcareElementsBy(filter: AbstractFilterJs<HealthElementJs>):
			Promise<Array<String>> = GlobalScope.promise {
		listToArray(
			healthcareElementApi.matchHealthcareElementsBy(abstractFilter_fromJs(
				filter,
				{ x1: HealthElementJs ->
					healthElement_fromJs(x1)
				},
			)),
			{ x1: String ->
				x1
			},
		)}


	override fun deleteHealthcareElement(entityId: String): Promise<DocIdentifierJs> =
			GlobalScope.promise {
		docIdentifier_toJs(healthcareElementApi.deleteHealthcareElement(entityId))}


	override fun deleteHealthcareElements(entityIds: Array<String>): Promise<Array<DocIdentifierJs>> =
			GlobalScope.promise {
		listToArray(
			healthcareElementApi.deleteHealthcareElements(arrayToList(
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


	override fun findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<IcureStubJs>> = GlobalScope.promise {
		listToArray(
			healthcareElementApi.findHealthcareElementsDelegationsStubsByHcPartyPatientForeignKeys(hcPartyId,
					arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: IcureStub ->
				icureStub_toJs(x1)
			},
		)}


	override fun shareWith(
		delegateId: String,
		healthcareElement: DecryptedHealthElementJs,
		shareEncryptionKeys: String,
		shareOwningEntityIds: String,
		requestedPermission: String,
	): Promise<SimpleShareResultJs<DecryptedHealthElementJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			healthcareElementApi.shareWith(delegateId,
					com.icure.sdk.js.model.healthElement_fromJs(healthcareElement),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareEncryptionKeys),
					com.icure.sdk.crypto.entities.ShareMetadataBehaviour.valueOf(shareOwningEntityIds),
					com.icure.sdk.model.requests.RequestedPermission.valueOf(requestedPermission)),
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun tryShareWithMany(healthElement: DecryptedHealthElementJs, delegates: dynamic):
			Promise<SimpleShareResultJs<DecryptedHealthElementJs>> = GlobalScope.promise {
		simpleShareResult_toJs(
			healthcareElementApi.tryShareWithMany(com.icure.sdk.js.model.healthElement_fromJs(healthElement),
					com.icure.sdk.js.model.CheckedConverters.objectToMap(
			  delegates,
			  "delegates",
			  { x1: kotlin.String ->
			    x1
			  },
			  { x1: com.icure.sdk.js.crypto.entities.HealthElementShareOptionsJs ->
			    com.icure.sdk.js.crypto.entities.healthElementShareOptions_fromJs(x1)
			  },
			)),
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun shareWithMany(healthElement: DecryptedHealthElementJs, delegates: dynamic):
			Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		healthElement_toJs(healthcareElementApi.shareWithMany(com.icure.sdk.js.model.healthElement_fromJs(healthElement),
				com.icure.sdk.js.model.CheckedConverters.objectToMap(
		  delegates,
		  "delegates",
		  { x1: kotlin.String ->
		    x1
		  },
		  { x1: com.icure.sdk.js.crypto.entities.HealthElementShareOptionsJs ->
		    com.icure.sdk.js.crypto.entities.healthElementShareOptions_fromJs(x1)
		  },
		)))}


	override fun findHealthcareElementsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		startDate: Double?,
		endDate: Double?,
		descending: Boolean?,
	): Promise<PaginatedListIteratorJs<DecryptedHealthElementJs>> = GlobalScope.promise {
		paginatedListIterator_toJs(
			healthcareElementApi.findHealthcareElementsByHcPartyPatient(hcPartyId,
					com.icure.sdk.js.model.patient_fromJs(patient),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(startDate, "startDate"),
					com.icure.sdk.js.model.CheckedConverters.numberToLong(endDate, "endDate"), descending),
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun modifyHealthcareElement(entity: DecryptedHealthElementJs):
			Promise<DecryptedHealthElementJs> = GlobalScope.promise {
		healthElement_toJs(healthcareElementApi.modifyHealthcareElement(com.icure.sdk.js.model.healthElement_fromJs(entity)))}


	override fun modifyHealthcareElements(entities: Array<DecryptedHealthElementJs>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		listToArray(
			healthcareElementApi.modifyHealthcareElements(arrayToList(
				entities,
				"entities",
				{ x1: DecryptedHealthElementJs ->
					healthElement_fromJs(x1)
				},
			)),
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun getHealthcareElement(entityId: String): Promise<DecryptedHealthElementJs> =
			GlobalScope.promise {
		healthElement_toJs(healthcareElementApi.getHealthcareElement(entityId))}


	override fun getHealthcareElements(entityIds: Array<String>):
			Promise<Array<DecryptedHealthElementJs>> = GlobalScope.promise {
		listToArray(
			healthcareElementApi.getHealthcareElements(arrayToList(
				entityIds,
				"entityIds",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun filterHealthcareElementsBy(
		filterChain: FilterChainJs<HealthElementJs>,
		startDocumentId: String?,
		limit: Double?,
	): Promise<PaginatedListJs<DecryptedHealthElementJs>> = GlobalScope.promise {
		paginatedList_toJs(
			healthcareElementApi.filterHealthcareElementsBy(com.icure.sdk.js.model.filter.chain.filterChain_fromJs(
			  filterChain,
			  { x1: com.icure.sdk.js.model.HealthElementJs ->
			    com.icure.sdk.js.model.healthElement_fromJs(x1)
			  },
			), startDocumentId, com.icure.sdk.js.model.CheckedConverters.numberToInt(limit, "limit")),
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}


	override fun findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId: String,
			secretPatientKeys: Array<String>): Promise<Array<DecryptedHealthElementJs>> =
			GlobalScope.promise {
		listToArray(
			healthcareElementApi.findHealthcareElementsByHcPartyPatientForeignKeys(hcPartyId, arrayToList(
				secretPatientKeys,
				"secretPatientKeys",
				{ x1: String ->
					x1
				},
			)),
			{ x1: DecryptedHealthElement ->
				healthElement_toJs(x1)
			},
		)}

}
