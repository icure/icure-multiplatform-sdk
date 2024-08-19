// auto-generated file
import {BaseFilterOptions, FilterOptions, InternalTopicFiltersObj} from '../icure-sdk-ts.mjs';
import {Topic} from '../model/Topic.mjs';


interface TopicFiltersFactory {

	allTopicsForDataOwner(dataOwnerId: string): BaseFilterOptions<Topic>;

	allTopicsForSelf(): FilterOptions<Topic>;

	byParticipant(participantId: string): FilterOptions<Topic>;

}

export const TopicFilters: TopicFiltersFactory = {
			allTopicsForDataOwner: (dataOwnerId) => InternalTopicFiltersObj.getInstance().allTopicsForDataOwner(dataOwnerId),
			allTopicsForSelf: () => InternalTopicFiltersObj.getInstance().allTopicsForSelf(),
			byParticipant: (participantId) => InternalTopicFiltersObj.getInstance().byParticipant(participantId)
		};
