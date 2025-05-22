// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.crypto.entities.EntityAccessInformationJs
import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.EncryptedPatientJs
import com.icure.cardinal.sdk.js.model.GroupScopedJs
import com.icure.cardinal.sdk.js.model.PatientJs
import com.icure.cardinal.sdk.js.model.StoredDocumentIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("PatientBasicInGroupApi")
public external interface PatientBasicInGroupApiJs {
	public fun matchPatientsBy(groupId: String, filter: BaseFilterOptionsJs<PatientJs>):
			Promise<Array<String>>

	public fun matchPatientsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<PatientJs>):
			Promise<Array<String>>

	public fun filterPatientsBy(groupId: String, filter: BaseFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedPatientJs>>>

	public fun filterPatientsBySorted(groupId: String, filter: BaseSortableFilterOptionsJs<PatientJs>):
			Promise<PaginatedListIteratorJs<GroupScopedJs<EncryptedPatientJs>>>

	public fun getDataOwnersWithAccessTo(patient: GroupScopedJs<PatientJs>):
			Promise<EntityAccessInformationJs>

	public fun createPatient(patient: GroupScopedJs<EncryptedPatientJs>):
			Promise<GroupScopedJs<EncryptedPatientJs>>

	public fun createPatientsMinimal(patients: Array<GroupScopedJs<EncryptedPatientJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun createPatients(patients: Array<GroupScopedJs<EncryptedPatientJs>>):
			Promise<Array<GroupScopedJs<EncryptedPatientJs>>>

	public fun getPatient(groupId: String, entityId: String):
			Promise<GroupScopedJs<EncryptedPatientJs>?>

	public fun getPatientResolvingMerges(
		groupId: String,
		patientId: String,
		maxMergeDepth: Double?,
	): Promise<GroupScopedJs<EncryptedPatientJs>>

	public fun getPatients(groupId: String, patientIds: Array<String>):
			Promise<Array<GroupScopedJs<EncryptedPatientJs>>>

	public fun modifyPatientsMinimal(patients: Array<GroupScopedJs<EncryptedPatientJs>>):
			Promise<Array<GroupScopedJs<StoredDocumentIdentifierJs>>>

	public fun modifyPatients(patients: Array<GroupScopedJs<EncryptedPatientJs>>):
			Promise<Array<GroupScopedJs<EncryptedPatientJs>>>
}
