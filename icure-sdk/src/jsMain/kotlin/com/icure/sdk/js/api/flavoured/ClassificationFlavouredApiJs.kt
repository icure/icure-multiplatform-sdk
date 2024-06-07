// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api.flavoured

import com.icure.sdk.js.crypto.entities.ClassificationShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.model.ClassificationJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("ClassificationFlavouredApi")
public external interface ClassificationFlavouredApiJs<E : ClassificationJs> {
	public fun shareWith(
		delegateId: String,
		classification: E,
		options: ClassificationFlavouredApi_shareWith_Options?,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(classification: E,
			delegates: Record<String, ClassificationShareOptionsJs>): Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(classification: E,
			delegates: Record<String, ClassificationShareOptionsJs>): Promise<E>

	public fun findClassificationsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: ClassificationFlavouredApi_findClassificationsByHcPartyPatient_Options?,
	): Promise<PaginatedListIteratorJs<E>>

	public fun modifyClassification(entity: E): Promise<E>

	public fun getClassification(entityId: String): Promise<E>

	public fun getClassifications(entityIds: Array<String>): Promise<Array<E>>
}

public external interface ClassificationFlavouredApi_shareWith_Options {
	public val shareEncryptionKeys: String

	public val shareOwningEntityIds: String

	public val requestedPermission: String
}

public external interface ClassificationFlavouredApi_findClassificationsByHcPartyPatient_Options {
	public val startDate: Double?

	public val endDate: Double?

	public val descending: Boolean?
}
