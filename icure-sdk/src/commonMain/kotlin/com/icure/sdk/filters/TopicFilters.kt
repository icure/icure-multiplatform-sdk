package com.icure.sdk.filters

import com.icure.sdk.model.Topic
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.topic.TopicByHcPartyFilter
import com.icure.sdk.model.filter.topic.TopicByParticipantFilter

object TopicFilters {
    /**
     * Create options for topic filtering that will match all topics shared directly (i.e. ignoring hierarchies) with a specific data owner.
     * @param dataOwnerId a data owner id or null to use the current data owner id
     * @return options for topic filtering
     */
    fun allTopicsForDataOwner(
        dataOwnerId: String
    ): BaseFilterOptions<Topic> =
        AllForDataOwner(dataOwnerId)

    /**
     * Create options for topic filtering that will match all topics shared directly (i.e. ignoring hierarchies) with the current data owner.
     * @return options for topic filtering
     */
    fun allTopicsForSelf(): FilterOptions<Topic> =
        AllForSelf

    /**
     * Creates options for topic filtering that will match all topics where the provided data owner is an active
     * participant.
     * @param participantId a data owner id
     */
    fun byParticipant(
        participantId: String
    ): FilterOptions<Topic> = 
        ByParticipant(participantId)

    internal class AllForDataOwner(
        val dataOwnerId: String
    ) : BaseFilterOptions<Topic>

    internal data object AllForSelf : FilterOptions<Topic>

    internal class ByParticipant(
        val participantId: String
    ) : BaseFilterOptions<Topic>
}

internal suspend fun mapTopicFilterOptions(
    filterOptions: FilterOptions<Topic>,
    selfDataOwnerId: String
): AbstractFilter<Topic> = mapIfMetaFilterOptions(filterOptions) {
    mapTopicFilterOptions(it, selfDataOwnerId)
} ?: when (filterOptions) {
    is TopicFilters.AllForDataOwner -> TopicByHcPartyFilter(hcpId = filterOptions.dataOwnerId)
    TopicFilters.AllForSelf -> TopicByHcPartyFilter(hcpId = selfDataOwnerId)
    is TopicFilters.ByParticipant -> TopicByParticipantFilter(participantId = filterOptions.participantId)
    else -> throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Topics")
}