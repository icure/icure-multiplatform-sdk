package com.icure.cardinal.sdk.filters

import com.icure.cardinal.sdk.CardinalBaseApis
import com.icure.cardinal.sdk.crypto.EntityEncryptionService
import com.icure.cardinal.sdk.crypto.entities.withTypeInfo
import com.icure.cardinal.sdk.model.Document
import com.icure.cardinal.sdk.model.Patient
import com.icure.cardinal.sdk.model.embed.DocumentType
import com.icure.cardinal.sdk.model.filter.AbstractFilter
import com.icure.cardinal.sdk.model.filter.document.DocumentByDataOwnerPatientDateFilter
import com.icure.cardinal.sdk.model.filter.document.DocumentByTypeDataOwnerPatientFilter
import com.icure.cardinal.sdk.utils.DefaultValue
import com.icure.utils.InternalIcureApi
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

object DocumentFilters {

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsCreatedForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId a data owner id
	 * @param patients a list of patients.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	fun byPatientsCreatedForDataOwner(
		dataOwnerId: String,
		patients: List<Patient>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByPatientsCreatedForDataOwner(dataOwnerId, patients, from, to, descending)

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsCreatedForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param patients a list of patients.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	fun byPatientsCreatedForSelf(
		patients: List<Patient>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByPatientsCreatedForSelf(patients, from, to, descending)

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with a specific owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	fun byPatientSecretIdsCreatedForDataOwner(
		dataOwnerId: String,
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): BaseSortableFilterOptions<Document> = ByPatientSecretIdsCreatedForDataOwner(dataOwnerId, secretIds, from, to, descending)

	/**
	 * Options for document filtering which match all documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with one of the provided patients through one of the provided secret ids.
	 * This Options also allows to restrict the documents based on [Document.created]:
	 * - if the [from] is not null, only the documents where [Document.created] is greater than or equal to [from] will be returned.
	 * - if the [to] is not null, only the documents where [Document.created] is less than or equal to [to] will be returned.
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * These options are sortable. When sorting using these options the documents will be sorted by [Document.created] in ascending or
	 * descending order according to the value of the [descending] parameter.
	 *
	 * @param secretIds a list of patient secret ids.
	 * @param from the minimum value for [Document.created] (default: no limit).
	 * @param to the maximum value for [Document.created] (default: no limit).
	 * @param descending whether to sort the result in descending or ascending order by [Document.created] (default: ascending).
	 */
	fun byPatientSecretIdsCreatedForSelf(
		secretIds: List<String>,
		@DefaultValue("null")
		from: Instant? = null,
		@DefaultValue("null")
		to: Instant? = null,
		@DefaultValue("false")
		descending: Boolean = false
	): SortableFilterOptions<Document> = ByPatientSecretIdsCreatedForSelf(secretIds, from, to, descending)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with of the provided patients and where [Document.documentType] is equal to [documentType].
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsAndTypeForDataOwner].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param documentType the document type to search.
	 * @param patients a list of patients.
	 */
	fun byPatientsAndTypeForDataOwner(
		dataOwnerId: String,
		documentType: DocumentType,
		patients: List<Patient>
	): FilterOptions<Document> = ByPatientsTypeForDataOwner(dataOwnerId, patients, documentType)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with of the provided patients and where [Document.documentType] is equal to [documentType].
	 *
	 * When using these options the sdk will automatically extract the secret ids from the provided patients and use
	 * those for filtering.
	 * If you already have the secret ids of the patient you may instead use [byPatientSecretIdsAndTypeForSelf].
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param documentType the document type to search.
	 * @param patients a list of patients.
	 */
	fun byPatientsAndTypeForSelf(
		documentType: DocumentType,
		patients: List<Patient>
	): FilterOptions<Document> = ByPatientsTypeForSelf(patients, documentType)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with a specific data owner
	 * that are linked with of the provided patients through one of the provided secret ids and where [Document.documentType] is equal
	 * to [documentType].
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 *
	 * @param dataOwnerId the id of a data owner.
	 * @param documentType the document type to search.
	 * @param secretIds a list of patient secret ids.
	 */
	fun byPatientSecretIdsAndTypeForDataOwner(
		dataOwnerId: String,
		documentType: DocumentType,
		secretIds: List<String>
	): FilterOptions<Document> = ByPatientSecretIdsTypeForDataOwner(dataOwnerId, secretIds, documentType)

	/**
	 * Options for document filter which match all the documents shared directly (i.e. ignoring hierarchies) with the current data owner
	 * that are linked with of the provided patients through one of the provided secret ids and where [Document.documentType] is equal
	 * to [documentType].
	 *
	 * If the current data owner does not have access to any secret id of one of the provide patients the patient will
	 * simply be ignored.
	 * Note that these may not be used in methods of apis from [CardinalBaseApis].
	 *
	 * @param documentType the document type to search.
	 * @param secretIds a list of patient secret ids.
	 */
	fun byPatientSecretIdsAndTypeForSelf(
		documentType: DocumentType,
		secretIds: List<String>
	): FilterOptions<Document> = ByPatientSecretIdsTypeForSelf(secretIds, documentType)


	@Serializable
	internal class ByPatientsCreatedForDataOwner(
		val dataOwnerId: String,
		val patients: List<Patient>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Document>

	@Serializable
	internal class ByPatientsCreatedForSelf(
		val patients: List<Patient>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Document>

	@Serializable
	internal class ByPatientSecretIdsCreatedForDataOwner(
		val dataOwnerId: String,
		val secretIds: List<String>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): BaseSortableFilterOptions<Document>

	@Serializable
	internal class ByPatientSecretIdsCreatedForSelf(
		val secretIds: List<String>,
		val from: Instant?,
		val to: Instant?,
		val descending: Boolean
	): SortableFilterOptions<Document>

	@Serializable
	internal class ByPatientsTypeForDataOwner(
		val dataOwnerId: String,
		val patients: List<Patient>,
		val type: DocumentType
	): FilterOptions<Document>

	@Serializable
	internal class ByPatientsTypeForSelf(
		val patients: List<Patient>,
		val type: DocumentType
	): FilterOptions<Document>

	@Serializable
	internal class ByPatientSecretIdsTypeForDataOwner(
		val dataOwnerId: String,
		val secretIds: List<String>,
		val type: DocumentType
	): BaseFilterOptions<Document>

	@Serializable
	internal class ByPatientSecretIdsTypeForSelf(
		val secretIds: List<String>,
		val type: DocumentType
	): FilterOptions<Document>
}

@InternalIcureApi
internal suspend fun mapDocumentFilterOptions(
	filterOptions: FilterOptions<Document>,
	selfDataOwnerId: String?,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Document> = mapIfMetaFilterOptions(filterOptions) {
	mapDocumentFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is DocumentFilters.ByPatientsCreatedForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		DocumentByDataOwnerPatientDateFilter(
			dataOwnerId = filterOptions.dataOwnerId,
			secretPatientKeys = filterOptions.patients.flatMap {
				entityEncryptionService.secretIdsOf(it.withTypeInfo(), null)
			}.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is DocumentFilters.ByPatientsCreatedForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		DocumentByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwnerId,
			secretPatientKeys = filterOptions.patients.flatMap {
				entityEncryptionService.secretIdsOf(it.withTypeInfo(), null)
			}.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is DocumentFilters.ByPatientSecretIdsCreatedForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		DocumentByDataOwnerPatientDateFilter(
			dataOwnerId = selfDataOwnerId,
			secretPatientKeys = filterOptions.secretIds.toSet(),
			startDate = filterOptions.to,
			endDate = filterOptions.from,
			descending = filterOptions.descending
		)
	}
	is DocumentFilters.ByPatientSecretIdsCreatedForDataOwner -> DocumentByDataOwnerPatientDateFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		secretPatientKeys = filterOptions.secretIds.toSet(),
		startDate = filterOptions.to,
		endDate = filterOptions.from,
		descending = filterOptions.descending
	)
	is DocumentFilters.ByPatientsTypeForDataOwner -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		DocumentByTypeDataOwnerPatientFilter(
			dataOwnerId = filterOptions.dataOwnerId,
			secretPatientKeys = filterOptions.patients.flatMap {
				entityEncryptionService.secretIdsOf(it.withTypeInfo(), null)
			}.toSet(),
			documentType = filterOptions.type
		)
	}
	is DocumentFilters.ByPatientsTypeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		DocumentByTypeDataOwnerPatientFilter(
			dataOwnerId = selfDataOwnerId,
			secretPatientKeys = filterOptions.patients.flatMap {
				entityEncryptionService.secretIdsOf(it.withTypeInfo(), null)
			}.toSet(),
			documentType = filterOptions.type
		)
	}
	is DocumentFilters.ByPatientSecretIdsTypeForDataOwner -> DocumentByTypeDataOwnerPatientFilter(
		dataOwnerId = filterOptions.dataOwnerId,
		secretPatientKeys = filterOptions.secretIds.toSet(),
		documentType = filterOptions.type
	)
	is DocumentFilters.ByPatientSecretIdsTypeForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		DocumentByTypeDataOwnerPatientFilter(
			dataOwnerId = selfDataOwnerId,
			secretPatientKeys = filterOptions.secretIds.toSet(),
			documentType = filterOptions.type
		)
	}
	else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Documents")
}
