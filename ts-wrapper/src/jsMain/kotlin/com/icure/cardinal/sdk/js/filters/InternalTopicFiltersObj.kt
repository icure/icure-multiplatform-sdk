// auto-generated file
package com.icure.cardinal.sdk.js.filters

import com.icure.cardinal.sdk.filters.TopicFilters
import com.icure.cardinal.sdk.js.model.TopicJs
import kotlin.String
import kotlin.js.JsExport

@JsExport
public object InternalTopicFiltersObj {
	public fun allTopicsForDataOwner(dataOwnerId: String): BaseFilterOptionsJs<TopicJs> {
		val dataOwnerIdConverted: String = dataOwnerId
		val result = TopicFilters.allTopicsForDataOwner(
			dataOwnerIdConverted,
		)
		return BaseFilterOptionsJsImpl(result)
	}

	public fun allTopicsForSelf(): FilterOptionsJs<TopicJs> {
		val result = TopicFilters.allTopicsForSelf(
		)
		return FilterOptionsJsImpl(result)
	}

	public fun byParticipant(participantId: String): FilterOptionsJs<TopicJs> {
		val participantIdConverted: String = participantId
		val result = TopicFilters.byParticipant(
			participantIdConverted,
		)
		return FilterOptionsJsImpl(result)
	}
}
