package com.icure.sdk.api

import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.model.DataOwnerRegistrationSuccess
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.model.PaginatedList
import com.icure.sdk.model.PublicKey


import com.icure.sdk.model.couchdb.DocIdentifier
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.chain.FilterChain
import com.icure.sdk.utils.DefaultValue
import com.icure.sdk.utils.InternalIcureApi

interface HealthcarePartyApi {
	suspend fun getHealthcareParty(deviceId: String): HealthcareParty
	suspend fun createHealthcareParty(p: HealthcareParty): HealthcareParty
	suspend fun deleteHealthcareParty(deviceId: String): DocIdentifier

	suspend fun modifyHealthcarePartyInGroup(
		groupId: String,
		device: HealthcareParty,
	): HealthcareParty

	suspend fun createHealthcarePartyInGroup(
		groupId: String,
		device: HealthcareParty,
	): HealthcareParty

	suspend fun getCurrentHealthcareParty(): HealthcareParty
	suspend fun findHealthcarePartiesBy(
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("null")
		desc: Boolean? = null,
	): PaginatedList<HealthcareParty>

	suspend fun findHealthcarePartiesByName(
		@DefaultValue("null")
		name: String? = null,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("null")
		desc: Boolean? = null,
	): PaginatedList<HealthcareParty>

	suspend fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		@DefaultValue("false")
		desc: Boolean = false,
	): PaginatedList<HealthcareParty>

	suspend fun listHealthcarePartiesByName(name: String): List<HealthcareParty>
	suspend fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		@DefaultValue("null")
		startKey: String? = null,
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
	): PaginatedList<HealthcareParty>

	suspend fun getHealthcareParties(healthcarePartyIds: List<String>): List<HealthcareParty>
	suspend fun listHealthcarePartiesByParentId(parentId: String): List<HealthcareParty>
	suspend fun getPublicKey(healthcarePartyId: String): PublicKey
	suspend fun deleteHealthcareParties(healthcarePartyIds: List<String>): List<DocIdentifier>
	suspend fun modifyHealthcareParty(healthcarePartyDto: HealthcareParty): HealthcareParty
	suspend fun matchHealthcarePartiesBy(filter: AbstractFilter<HealthcareParty>): List<String>
	suspend fun filterHealthPartiesBy(
		@DefaultValue("null")
		startDocumentId: String? = null,
		@DefaultValue("null")
		limit: Int? = null,
		filterChain: FilterChain<HealthcareParty>,
	): PaginatedList<HealthcareParty>

	suspend fun getHealthcarePartiesInGroup(
		groupId: String,
		@DefaultValue("null")
		healthcarePartyIds: List<String>? = null,
	): List<HealthcareParty>

	suspend fun deleteHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: List<String>,
	): List<DocIdentifier>

	suspend fun deleteHealthcarePartyInGroup(
		healthcarePartyId: String,
		groupId: String,
	): DocIdentifier

	suspend fun registerPatient(
		groupId: String,
		@DefaultValue("null")
		parentHcPartyId: String? = null,
		@DefaultValue("null")
		token: String? = null,
		@DefaultValue("null")
		useShortToken: Boolean? = null,
		hcp: HealthcareParty,
	): DataOwnerRegistrationSuccess

}

@InternalIcureApi
internal class HealthcarePartyApiImpl(
	private val rawApi: RawHealthcarePartyApi,
) : HealthcarePartyApi {
	override suspend fun getHealthcareParty(deviceId: String) = rawApi.getHealthcareParty(deviceId).successBody()

	override suspend fun createHealthcareParty(p: HealthcareParty) = rawApi.createHealthcareParty(p).successBody()

	override suspend fun deleteHealthcareParty(deviceId: String) = rawApi.deleteHealthcareParty(deviceId).successBody()

	override suspend fun modifyHealthcarePartyInGroup(groupId: String, device: HealthcareParty) =
		rawApi.modifyHealthcarePartyInGroup(groupId, device).successBody()

	override suspend fun createHealthcarePartyInGroup(groupId: String, device: HealthcareParty) =
		rawApi.createHealthcarePartyInGroup(groupId, device).successBody()


	override suspend fun getCurrentHealthcareParty() = rawApi.getCurrentHealthcareParty().successBody()
	override suspend fun findHealthcarePartiesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
	) = rawApi.findHealthcarePartiesBy(startKey, startDocumentId, limit, desc).successBody()

	override suspend fun findHealthcarePartiesByName(
		name: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
	) = rawApi.findHealthcarePartiesByName(name, startKey, startDocumentId, limit, desc).successBody()

	override suspend fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean,
	) = rawApi.findHealthcarePartiesBySsinOrNihii(searchValue, startKey, startDocumentId, limit, desc).successBody()

	override suspend fun listHealthcarePartiesByName(name: String) = rawApi.listHealthcarePartiesByName(name).successBody()
	override suspend fun findHealthcarePartiesBySpecialityAndPostCode(
		type: String,
		spec: String,
		firstCode: String,
		lastCode: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
	) = rawApi.findHealthcarePartiesBySpecialityAndPostCode(type, spec, firstCode, lastCode, startKey, startDocumentId, limit).successBody()

	override suspend fun getHealthcareParties(healthcarePartyIds: List<String>) =
		rawApi.getHealthcareParties(ListOfIds(healthcarePartyIds)).successBody()

	override suspend fun listHealthcarePartiesByParentId(parentId: String) = rawApi.listHealthcarePartiesByParentId(parentId).successBody()
	override suspend fun getPublicKey(healthcarePartyId: String) = rawApi.getPublicKey(healthcarePartyId).successBody()
	override suspend fun deleteHealthcareParties(healthcarePartyIds: List<String>) =
		rawApi.deleteHealthcareParties(ListOfIds(healthcarePartyIds)).successBody()

	override suspend fun modifyHealthcareParty(healthcarePartyDto: HealthcareParty) =
		rawApi.modifyHealthcareParty(healthcarePartyDto).successBody()

	override suspend fun matchHealthcarePartiesBy(filter: AbstractFilter<HealthcareParty>) =
		rawApi.matchHealthcarePartiesBy(filter).successBody()

	override suspend fun filterHealthPartiesBy(
		startDocumentId: String?,
		limit: Int?,
		filterChain: FilterChain<HealthcareParty>,
	) = rawApi.filterHealthPartiesBy(startDocumentId, limit, filterChain).successBody()

	override suspend fun getHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: List<String>?,
	) = rawApi.getHealthcarePartiesInGroup(groupId, healthcarePartyIds?.let { ListOfIds(it) }).successBody()

	override suspend fun deleteHealthcarePartiesInGroup(
		groupId: String,
		healthcarePartyIds: List<String>,
	) = rawApi.deleteHealthcarePartiesInGroup(groupId, ListOfIds(healthcarePartyIds)).successBody()

	override suspend fun deleteHealthcarePartyInGroup(
		healthcarePartyId: String,
		groupId: String,
	) = rawApi.deleteHealthcarePartyInGroup(healthcarePartyId, groupId).successBody()

	override suspend fun registerPatient(
		groupId: String,
		parentHcPartyId: String?,
		token: String?,
		useShortToken: Boolean?,
		hcp: HealthcareParty,
	) = rawApi.registerPatient(groupId, parentHcPartyId, token, useShortToken, hcp).successBody()

}

