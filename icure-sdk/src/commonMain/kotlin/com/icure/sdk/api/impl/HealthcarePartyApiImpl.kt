package com.icure.sdk.api.impl

import com.icure.sdk.api.HealthcarePartyApi
import com.icure.sdk.api.raw.RawHealthcarePartyApi
import com.icure.sdk.filters.BaseFilterOptions
import com.icure.sdk.filters.BaseSortableFilterOptions
import com.icure.sdk.filters.mapHealthcarePartyFilterOptions
import com.icure.sdk.model.HealthcareParty
import com.icure.sdk.model.ListOfIds
import com.icure.sdk.utils.InternalIcureApi
import com.icure.sdk.utils.pagination.IdsPageIterator
import com.icure.sdk.utils.pagination.PaginatedListIterator

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

	@Deprecated(
		"Find methods are deprecated",
		ReplaceWith(
			expression = "filterHealthPartiesBy(AllHealthcarePartiesFilter())",
			imports = arrayOf("com.icure.sdk.model.filter.hcparty.AllHealthcarePartiesFilter")
		)
	)
	override suspend fun findHealthcarePartiesBy(
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
	) = rawApi.findHealthcarePartiesBy(startKey, startDocumentId, limit, desc).successBody()

	@Deprecated(
		"Find methods are deprecated",
		ReplaceWith(
			expression = "filterHealthPartiesBy(HealthcarePartyByNameFilter(name = name, descending = desc)",
			imports = arrayOf("com.icure.sdk.model.filter.hcparty.HealthcarePartyByNameFilter")
		)
	)
	override suspend fun findHealthcarePartiesByName(
		name: String?,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean?,
	) = rawApi.findHealthcarePartiesByName(name, startKey, startDocumentId, limit, desc).successBody()

	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterHealthPartiesBy(filter)"))
	override suspend fun findHealthcarePartiesBySsinOrNihii(
		searchValue: String,
		startKey: String?,
		startDocumentId: String?,
		limit: Int?,
		desc: Boolean,
	) = rawApi.findHealthcarePartiesBySsinOrNihii(searchValue, startKey, startDocumentId, limit, desc).successBody()

	override suspend fun listHealthcarePartiesByName(name: String) = rawApi.listHealthcarePartiesByName(name).successBody()
	@Deprecated("Find methods are deprecated", replaceWith = ReplaceWith("filterHealthPartiesBy(filter)"))
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

	override suspend fun matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>) =
		rawApi.matchHealthcarePartiesBy(mapHealthcarePartyFilterOptions(filter)).successBody()

	override suspend fun filterHealthPartiesBy(filter: BaseFilterOptions<HealthcareParty>): PaginatedListIterator<HealthcareParty> =
		IdsPageIterator(matchHealthcarePartiesBy(filter), this::getHealthcareParties)

	override suspend fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>) =
		matchHealthcarePartiesBy(filter)

	override suspend fun filterHealthPartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): PaginatedListIterator<HealthcareParty> =
		filterHealthPartiesBy(filter)

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