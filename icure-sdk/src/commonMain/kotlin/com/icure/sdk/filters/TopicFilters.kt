package com.icure.sdk.filters

import com.icure.sdk.crypto.EntityEncryptionService
import com.icure.sdk.model.Topic
import com.icure.sdk.model.filter.AbstractFilter
import com.icure.sdk.model.filter.topic.TopicByHcPartyFilter
import com.icure.sdk.model.filter.topic.TopicByParticipantFilter
import com.icure.sdk.utils.InternalIcureApi
import kotlinx.serialization.Serializable

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

    @Serializable
    internal class AllForDataOwner(
        val dataOwnerId: String
    ) : BaseFilterOptions<Topic>

    @Serializable
    internal data object AllForSelf : FilterOptions<Topic>

    @Serializable
    internal class ByParticipant(
        val participantId: String
    ) : BaseFilterOptions<Topic>
}

@InternalIcureApi
internal suspend fun mapTopicFilterOptions(
    filterOptions: FilterOptions<Topic>,
    selfDataOwnerId: String?,
    entityEncryptionService: EntityEncryptionService?
): AbstractFilter<Topic> = mapIfMetaFilterOptions(filterOptions) {
    mapTopicFilterOptions(it, selfDataOwnerId, entityEncryptionService)
} ?: when (filterOptions) {
    is TopicFilters.AllForDataOwner -> {
        TopicByHcPartyFilter(hcpId = filterOptions.dataOwnerId)
    }
    TopicFilters.AllForSelf -> {
        filterOptions.ensureNonBaseEnvironment(selfDataOwnerId, entityEncryptionService)
        TopicByHcPartyFilter(hcpId = selfDataOwnerId)
    }
    is TopicFilters.ByParticipant -> {
        TopicByParticipantFilter(participantId = filterOptions.participantId)
    }
    else -> {
        throw IllegalArgumentException("Filter options ${filterOptions::class.simpleName} are not valid for filtering Topics")
    }
}