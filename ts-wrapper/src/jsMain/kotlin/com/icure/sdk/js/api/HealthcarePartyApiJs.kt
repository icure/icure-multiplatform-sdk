// auto-generated file
@file:JsQualifier("api")

package com.icure.sdk.js.api

import com.icure.sdk.js.model.DataOwnerRegistrationSuccessJs
import com.icure.sdk.js.model.HealthcarePartyJs
import com.icure.sdk.js.model.PaginatedListJs
import com.icure.sdk.js.model.PublicKeyJs
import com.icure.sdk.js.model.couchdb.DocIdentifierJs
import com.icure.sdk.js.model.filter.AbstractFilterJs
import com.icure.sdk.js.model.filter.chain.FilterChainJs
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
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

	public fun findHealthcarePartiesBy(options: HealthcarePartyApi_findHealthcarePartiesBy_Options?):
			Promise<PaginatedListJs<HealthcarePartyJs>>

	public
			fun findHealthcarePartiesByName(options: HealthcarePartyApi_findHealthcarePartiesByName_Options?):
			Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun findHealthcarePartiesBySsinOrNihii(searchValue: String,
			options: HealthcarePartyApi_findHealthcarePartiesBySsinOrNihii_Options?):
			Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun listHealthcarePartiesByName(name: String): Promise<Array<HealthcarePartyJs>>

	public fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		options: HealthcarePartyApi_findHealthcarePartiesBySpecialityAndPostCode_Options?,
	): Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun getHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<HealthcarePartyJs>>

	public fun listHealthcarePartiesByParentId(parentId: String): Promise<Array<HealthcarePartyJs>>

	public fun getPublicKey(healthcarePartyId: String): Promise<PublicKeyJs>

	public fun deleteHealthcareParties(healthcarePartyIds: Array<String>):
			Promise<Array<DocIdentifierJs>>

	public fun modifyHealthcareParty(healthcarePartyDto: HealthcarePartyJs): Promise<HealthcarePartyJs>

	public fun matchHealthcarePartiesBy(filter: AbstractFilterJs<HealthcarePartyJs>):
			Promise<Array<String>>

	public fun filterHealthPartiesBy(filterChain: FilterChainJs<HealthcarePartyJs>,
			options: HealthcarePartyApi_filterHealthPartiesBy_Options?):
			Promise<PaginatedListJs<HealthcarePartyJs>>

	public fun getHealthcarePartiesInGroup(groupId: String,
			options: HealthcarePartyApi_getHealthcarePartiesInGroup_Options?):
			Promise<Array<HealthcarePartyJs>>

	public fun deleteHealthcarePartiesInGroup(groupId: String, healthcarePartyIds: Array<String>):
			Promise<Array<DocIdentifierJs>>

	public fun deleteHealthcarePartyInGroup(healthcarePartyId: String, groupId: String):
			Promise<DocIdentifierJs>

	public fun registerPatient(
		groupId: String,
		hcp: HealthcarePartyJs,
		options: HealthcarePartyApi_registerPatient_Options?,
	): Promise<DataOwnerRegistrationSuccessJs>
}

public external interface HealthcarePartyApi_findHealthcarePartiesBy_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val desc: Boolean?
}

public external interface HealthcarePartyApi_findHealthcarePartiesByName_Options {
	public val name: String?

	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val desc: Boolean?
}

public external interface HealthcarePartyApi_findHealthcarePartiesBySsinOrNihii_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?

	public val desc: Boolean
}

public external interface HealthcarePartyApi_findHealthcarePartiesBySpecialityAndPostCode_Options {
	public val startKey: String?

	public val startDocumentId: String?

	public val limit: Double?
}

public external interface HealthcarePartyApi_filterHealthPartiesBy_Options {
	public val startDocumentId: String?

	public val limit: Double?
}

public external interface HealthcarePartyApi_getHealthcarePartiesInGroup_Options {
	public val healthcarePartyIds: Array<String>?
}

public external interface HealthcarePartyApi_registerPatient_Options {
	public val parentHcPartyId: String?

	public val token: String?

	public val useShortToken: Boolean?
}
