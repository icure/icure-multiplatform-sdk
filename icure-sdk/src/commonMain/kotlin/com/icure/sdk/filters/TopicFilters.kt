package com.icure.sdk.filters

import com.icure.sdk.model.Topic
import com.icure.sdk.utils.DefaultValue

object TopicFilters {
    /**
     * Create options for topic filtering that will match all topics shared with a specific data owner.
     * If [dataOwnerId] is null the filter will match all topics shared directly with the current data owner.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @return options for topic filtering
     */
    fun allTopicsForDataOwner(
        @DefaultValue("null")
        dataOwnerId: String? = null
    ): FilterOptions<Topic> =
        ByDataOwner(dataOwnerId)

    /**
     * Creates options for topic filtering that will match all topics where the provided data owner is an active
     * participant.
     * @param participantId a data owner id
     */
    fun byParticipant(
        participantId: String
    ): FilterOptions<Topic> = 
        ByParticipant(participantId)

    internal class ByDataOwner(
        val dataOwnerId: String?
    ) : FilterOptions<Topic>

    internal class ByParticipant(
        val participantId: String
    ) : FilterOptions<Topic>
}
