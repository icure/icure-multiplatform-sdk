package com.icure.sdk.filters

import com.icure.sdk.model.Message
import com.icure.sdk.utils.DefaultValue

object MessageFilters {
	/**
	 * Create options for message filtering that will match all messages shared with a specific data owner.
	 * If [dataOwnerId] is null the filter will match all messages shared directly with the current data owner.
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 * @return options for message filtering
	 */
	fun allMessagesForDataOwner(
		@DefaultValue("null")
		dataOwnerId: String? = null
	): FilterOptions<Message> =
		ByDataOwner(dataOwnerId)

	/**
	 * Creates options for message filtering that will match all messages shared with a specific data owner that have the
	 * provided transportGuid.
	 *
	 * These options are sortable. When sorting using these options the messages will be sorted by [Message.created].
	 *
	 * @param transportGuid a message transport guid
	 * @param dataOwnerId a data owner id or null to use the current data owner id
	 */
	fun byTransportGuidDate(
		transportGuid: String,
		@DefaultValue("null")
		dataOwnerId: String? = null
	): SortableFilterOptions<Message> =
		ByTransportGuidDate(transportGuid, dataOwnerId)

	internal class ByDataOwner(
		val dataOwnerId: String?
	) : FilterOptions<Message>

	internal class ByTransportGuidDate(
		val transportGuid: String,
		val dataOwnerId: String?
	) : SortableFilterOptions<Message>
}
