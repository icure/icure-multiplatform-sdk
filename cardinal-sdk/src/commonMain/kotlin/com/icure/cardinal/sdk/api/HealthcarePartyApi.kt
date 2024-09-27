package com.icure.cardinal.sdk.api

import com.icure.cardinal.sdk.exceptions.RevisionConflictException
import com.icure.cardinal.sdk.filters.BaseFilterOptions
import com.icure.cardinal.sdk.filters.BaseSortableFilterOptions
import com.icure.cardinal.sdk.model.DataOwnerRegistrationSuccess
import com.icure.cardinal.sdk.model.HealthcareParty
import com.icure.cardinal.sdk.model.IdWithMandatoryRev
import com.icure.cardinal.sdk.model.PaginatedList
import com.icure.cardinal.sdk.model.PublicKey
import com.icure.cardinal.sdk.model.couchdb.DocIdentifier
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.cardinal.sdk.utils.pagination.PaginatedListIterator

interface HealthcarePartyApi {
	suspend fun getHealthcareParty(healthcarePartyId: String): HealthcareParty
	suspend fun createHealthcareParty(p: HealthcareParty): HealthcareParty

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

	/**
	 * Deletes a healthcareParty. If you don't have write access to the healthcareParty the method will fail.
	 * @param entityId id of the healthcareParty.
	 * @param rev the latest known rev of the healthcareParty to delete
	 * @return the id and revision of the deleted healthcareParty.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteHealthcareParty(entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many healthcareParties. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the healthcareParties to delete.
	 * @return the id and revision of the deleted healthcareParties. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteHealthcareParties(entityIds: List<IdWithMandatoryRev>): List<DocIdentifier>

	/**
	 * Deletes a healthcareParty from a specific group. If you don't have write access to the healthcareParty the method will fail.
	 * @param entityId id of the healthcareParty.
	 * @param rev the latest known rev of the healthcareParty to delete
	 * @param groupId the group of the healtchare party
	 * @return the id and revision of the deleted healthcareParty.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun deleteHealthcarePartyInGroup(groupId: String, entityId: String, rev: String): DocIdentifier

	/**
	 * Deletes many healthcareParties from a specific group. Ids that do not correspond to an entity, or that correspond to an entity for which
	 * you don't have write access will be ignored.
	 * @param entityIds ids and revisions of the healthcareParties to delete.
	 * @param groupId the group of the healtchare parties
	 * @return the id and revision of the deleted healthcareParties. If some entities could not be deleted (for example
	 * because you had no write access to them) they will not be included in this list.
	 */
	suspend fun deleteHealthcarePartiesInGroup(groupId: String, entityIds: List<IdWithMandatoryRev>): List<DocIdentifier>

	/**
	 * Permanently deletes a healthcareParty.
	 * @param id id of the healthcareParty to purge
	 * @param rev latest revision of the healthcareParty
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun purgeHealthcareParty(id: String, rev: String)

	/**
	 * Restores a healthcareParty that was marked as deleted.
	 * @param id the id of the entity
	 * @param rev the latest revision of the entity.
	 * @return the restored entity.
	 * @throws RevisionConflictException if the provided revision doesn't match the latest known revision
	 */
	suspend fun undeleteHealthcareParty(id: String, rev: String): HealthcareParty
}

