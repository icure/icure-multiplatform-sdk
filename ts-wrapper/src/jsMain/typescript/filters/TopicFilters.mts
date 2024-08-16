// auto-generated file
import {BaseFilterOptions, FilterOptions, InternalTopicFiltersObj} from '../icure-sdk-ts.mjs';
import {Topic} from '../model/Topic.mjs';


interface TopicFiltersFactory {

	allTopicsForDataOwner(dataOwnerId: string): BaseFilterOptions<Topic>;

	allTopicsForSelf(): FilterOptions<Topic>;

	byParticipant(participantId: string): FilterOptions<Topic>;

}

const TopicFilters: TopicFiltersFactory = InternalTopicFiltersObj.getInstance();
