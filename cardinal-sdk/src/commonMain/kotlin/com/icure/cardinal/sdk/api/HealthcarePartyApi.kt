package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.DataOwnerRegistrationSuccess
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.PublicKey
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface HealthcarePartyApi {
	suspend fun getHealthcareParty(healthcarePartyId: String): HealthcareParty
	suspend fun createHealthcareParty(p: HealthcareParty): HealthcareParty
	suspend fun deleteHealthcareParty(healthcarePartyId: String): DocIdentifier

	suspend fun modifyHealthcarePartyInGroup(
		groupId: String,
		healthcareParty: HealthcareParty,
	): HealthcareParty

	suspend fun createHealthcarePartyInGroup(
		groupId: String,
		healthcareParty: HealthcareParty,
	): HealthcareParty

	suspend fun getCurrentHealthcareParty(): HealthcareParty

	@Deprecated(
		"Find methods are deprecated",
		ReplaceWith(
			expression = "filterHealthPartiesBy(AllHealthcarePartiesFilter())",
			imports = arrayOf("com.icure.cardinal.sdk.model.filter.hcparty.AllHealthcarePartiesFilter")
		)
	)
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

	@Deprecated(
		"Find methods are deprecated",
		ReplaceWith(
			expression = "filterHealthPartiesBy(HealthcarePartyByNameFilter(name = name, descending = desc)",
			imports = arrayOf("com.icure.cardinal.sdk.model.filter.hcparty.HealthcarePartyByNameFilter")
		)
	)
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

	// TODO: implement filter for this one
	@Deprecated("Find methods are deprecated", ReplaceWith("filterHealthPartiesBy(filter)"))
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

	// TODO: implement filter for this one
	@Deprecated("Find methods are deprecated", ReplaceWith("filterHealthPartiesBy(filter)"))
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
	suspend fun modifyHealthcareParty(healthcareParty: HealthcareParty): HealthcareParty
	suspend fun matchHealthcarePartiesBy(filter: BaseFilterOptions<HealthcareParty>): List<String>

	suspend fun filterHealthPartiesBy(
		filter: BaseFilterOptions<HealthcareParty>,
	): PaginatedListIterator<HealthcareParty>

	suspend fun matchHealthcarePartiesBySorted(filter: BaseSortableFilterOptions<HealthcareParty>): List<String>

	suspend fun filterHealthPartiesBySorted(
		filter: BaseSortableFilterOptions<HealthcareParty>,
	): PaginatedListIterator<HealthcareParty>

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

