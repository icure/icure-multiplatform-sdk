package com.icure.sdk.filters

import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.model.Message
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.message.LatestMessageByHcPartyTransportGuidFilter
import com.icure.sdk.model.filter.message.MessageByHcPartyFilter
import com.icure.sdk.utils.InternalIcureApi

object MessageFilters {
	/**
	 * Create options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner.
	 * @param dataOwnerId a data owner id
	 * @return options for message filtering
	 */
	fun allMessagesForDataOwner(
		dataOwnerId: String
	): BaseFilterOptions<Message> =
		AllForDataOwner(dataOwnerId)

	/**
	 * Create options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner.
	 * @return options for message filtering
	 */
	fun allMessagesForSelf(): FilterOptions<Message> =
		AllForSelf

	/**
	 * Creates options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with a specific data owner that have the
	 * provided transportGuid.
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.created].
	 *
	 * @param dataOwnerId a data owner id
	 * @param transportGuid a message transport guid
	 */
	fun byTransportGuidDateForDataOwner(
		dataOwnerId: String,
		transportGuid: String
	): BaseSortableFilterOptions<Message> =
		ByTransportGuidDateForDataOwner(transportGuid, dataOwnerId)

	internal class AllForDataOwner(
		val dataOwnerId: String
	) : BaseFilterOptions<Message>

	internal data object AllForSelf : FilterOptions<Message>


	internal class ByTransportGuidDateForDataOwner(
		val transportGuid: String,
		val dataOwnerId: String
	) : BaseSortableFilterOptions<Message>

	/**
	 * Creates options for message filtering that will match all messages shared directly (i.e. ignoring hierarchies) with the current data owner that have the
	 * provided transportGuid.
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.created].
	 *
	 * @param transportGuid a message transport guid
	 */
	fun byTransportGuidDate(
		transportGuid: String,
	): SortableFilterOptions<Message> =
		ByTransportGuidDateForSelf(transportGuid)

	internal class ByTransportGuidDateForSelf(
		val transportGuid: String
	) : BaseSortableFilterOptions<Message>
}

@InternalIcureApi
internal suspend fun mapMessageFilterOptions(
	filterOptions: FilterOptions<Message>,
	selfDataOwnerId: String?,
	entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Message> = mapIfMetaFilterOptions(filterOptions) {
	mapMessageFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
	is MessageFilters.AllForDataOwner -> {
		MessageByHcPartyFilter(hcpId = filterOptions.dataOwnerId)
	}
	MessageFilters.AllForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		MessageByHcPartyFilter(hcpId = selfDataOwnerId)
	}
	is MessageFilters.ByTransportGuidDateForDataOwner -> {
		LatestMessageByHcPartyTransportGuidFilter(
			transportGuid = filterOptions.transportGuid,
			healthcarePartyId = filterOptions.dataOwnerId
		)
	}
	is MessageFilters.ByTransportGuidDateForSelf -> {
		filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
		LatestMessageByHcPartyTransportGuidFilter(
			transportGuid = filterOptions.transportGuid,
			healthcarePartyId = selfDataOwnerId
		)
	}
	else -> {
		throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Messages")
	}
}