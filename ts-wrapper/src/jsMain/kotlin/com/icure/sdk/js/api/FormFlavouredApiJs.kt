// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.crypto.entities.FormShareOptionsJs
import com.icure.sdk.js.crypto.entities.SimpleShareResultJs
import com.icure.sdk.js.filters.FilterOptionsJs
import com.icure.sdk.js.filters.SortableFilterOptionsJs
import com.icure.sdk.js.model.FormJs
import com.icure.sdk.js.model.PatientJs
import com.icure.sdk.js.utils.Record
import com.icure.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("FormFlavouredApi")
public external interface FormFlavouredApiJs<E : FormJs> {
	public fun shareWith(
		delegateId: String,
		form: E,
		options: dynamic,
	): Promise<SimpleShareResultJs<E>>

	public fun tryShareWithMany(form: E, delegates: Record<String, FormShareOptionsJs>):
			Promise<SimpleShareResultJs<E>>

	public fun shareWithMany(form: E, delegates: Record<String, FormShareOptionsJs>): Promise<E>

	public fun findFormsByHcPartyPatient(
		hcPartyId: String,
		patient: PatientJs,
		options: dynamic,
	): Promise<PaginatedListIteratorJs<E>>

	public fun filterFormsBy(filter: FilterOptionsJs<FormJs>): Promise<PaginatedListIteratorJs<E>>

	public fun filterFormsBySorted(filter: SortableFilterOptionsJs<FormJs>):
			Promise<PaginatedListIteratorJs<E>>

	public fun modifyForm(entity: E): Promise<E>

	public fun modifyForms(entities: Array<E>): Promise<Array<E>>

	public fun getForm(entityId: String): Promise<E>

	public fun getForms(entityIds: Array<String>): Promise<Array<E>>

	public fun getLatestFormByLogicalUuid(logicalUuid: String): Promise<E>

	public fun getLatestFormByUniqueId(uniqueId: String): Promise<E>

	public fun getFormsByLogicalUuid(logicalUuid: String): Promise<Array<E>>

	public fun getFormsByUniqueId(uniqueId: String): Promise<Array<E>>

	public fun getChildrenForms(hcPartyId: String, parentId: String): Promise<Array<E>>

	public fun listFormsByHCPartyAndPatientForeignKeys(
		hcPartyId: String,
		secretFKeys: String,
		options: dynamic,
	): Promise<Array<E>>
}
