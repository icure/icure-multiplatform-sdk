// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs
import com.icure.sdk.js.crypto.entities.SecretIdOptionJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.ClassificationJs
import com.icure.sdk.js.model.DecryptedClassificationJs
import com.icure.sdk.js.model.EncryptedClassificationJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.model.UserJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ClassificationApi")
public external interface ClassificationApiJs {
	public val encrypted: ClassificationFlavouredApiJs<EncryptedClassificationJs>

	public val tryAndRecover: ClassificationFlavouredApiJs<ClassificationJs>

	public fun createClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs>

	public fun withEncryptionMetadata(
		base: DecryptedClassificationJs?,
		patient: PatientJs,
		options: ClassificationApi_withEncryptionMetadata_Options?,
	): Promise<DecryptedClassificationJs>

	public fun getEncryptionKeysOf(classification: ClassificationJs): Promise<Array<String>>

	public fun hasWriteAccess(classification: ClassificationJs): Promise<Boolean>

	public fun decryptPatientIdOf(classification: ClassificationJs): Promise<Array<String>>

	public fun createDelegationDeAnonymizationMetadata(entity: ClassificationJs,
			delegates: Array<String>): Promise<Unit>

	public fun deleteClassification(entityId: String): Promise<DocIdentifierJs>

	public fun deleteClassifications(entityIds: Array<String>): Promise<Array<DocIdentifierJs>>

	public fun shareWith(
		delegateId: String,
		classification: DecryptedClassificationJs,
		options: ClassificationApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<DecryptedClassificationJs>>

	public fun tryShareWithMany(classification: DecryptedClassificationJs,
			delegates: Record<String, ClassificationShareOptionsJs>):
			Promise<SimpleShareResultJs<DecryptedClassificationJs>>

	public fun shareWithMany(classification: DecryptedClassificationJs,
			delegates: Record<String, ClassificationShareOptionsJs>): Promise<DecryptedClassificationJs>

	public fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: ClassificationApi_findClassificationsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<DecryptedClassificationJs>>

	public fun modifyClassification(entity: DecryptedClassificationJs):
			Promise<DecryptedClassificationJs>

	public fun getClassification(entityId: String): Promise<DecryptedClassificationJs>

	public fun getClassifications(entityIds: Array<String>): Promise<Array<DecryptedClassificationJs>>
}

public external interface ClassificationApi_withEncryptionMetadata_Options {
	public val user: UserJs?

	public val delegates: Record<String, String>

	public val secretId: SecretIdOptionJs
}

public external interface ClassificationApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface ClassificationApi_findClassificationsByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}
