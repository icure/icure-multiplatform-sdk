// auto-generated file
@file:JsQualifier("api")

package com.icure.cardinal.sdk.js.api

import com.icure.cardinal.sdk.js.filters.BaseFilterOptionsJs
import com.icure.cardinal.sdk.js.filters.BaseSortableFilterOptionsJs
import com.icure.cardinal.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.cardinal.sdk.js.model.HealthcarePartyJs
import com.icure.cardinal.sdk.js.model.PaginatedListJs
import com.icure.cardinal.sdk.js.model.PublicKeyJs
import com.icure.cardinal.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.cardinal.sdk.js.utils.pagination.PaginatedListIteratorJs
import kotlin.Array
import kotlin.String
import kotlin.js.JsName
import kotlin.js.JsQualifier
import kotlin.js.Promise

@JsName("HealthcarePartyApi")
public external interface HealthcarePartyApiJs {
	public fun getHealthcareParty(deviceId: String): Promise<HealthcarePartyJs>

	public fun createHealthcareParty(p: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun deleteHealthcareParty(deviceId: String): Promise<DocIdentifierJs>

	public fun modifyHealthcarePartyInGroup(groupId: String, device: HealthcarePartyJs):
			Promise<HealthcarePartyJs>

	public fun createHealthcarePartyInGroup(groupId: String, device: HealthcarePartyJs):
			Promise<HealthcarePartyJs>

	public fun getCurrentHealthcareParty(): Promise<HealthcarePartyJs>

	public fun findHealthcarePartiesBy(options: dynamic): Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun findHealthcarePartiesByName(options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun findHealthcarePartiesBySsinOrNihii(searchValue: String, options: dynamic):
			Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun listHealthcarePartiesByName(name: String): Promise<Array<HealthcarePartyJs>>

	public fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		options: dynamic,
	): Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun getHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<HealthcarePartyJs>>

	public fun listHealthcarePartiesByParentId(parentId: String): Promise<Array<HealthcarePartyJs>>

	public fun getPublicKey(healthcarePartyId: String): Promise<PublicKeyJs>

	public fun deleteHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<DocIdentifierJs>>

	public fun modifyHealthcareParty(healthcarePartyDto: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun matchHealthcarePartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>>

	public fun filterHealthPartiesBy(filter: BaseFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>>

	public fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<Array<String>>

	public fun filterHealthPartiesBySorted(filter: BaseSortableFilterOptionsJs<HealthcarePartyJs>):
			Promise<PaginatedListIteratorJs<HealthcarePartyJs>>

	public fun getHealthcarePartiesInGroup(groupId: String, options: dynamic):
			Promise<Array<HealthcarePartyJs>>

	public fun deleteHealthcarePartiesInGroup(groupId: String, healthcarePartyIds: Array<String>):
			Promise<Array<DocIdentifierJs>>

	public fun deleteHealthcarePartyInGroup(healthcarePartyId: String, groupId: String):
			Promise<DocIdentifierJs>

	public fun registerPatient(
		groupId: String,
		hcp: HealthcarePartyJs,
		options: dynamic,
	): Promise<DataOwnerRegistrationSuccessJs>
}
