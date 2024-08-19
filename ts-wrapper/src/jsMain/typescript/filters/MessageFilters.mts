// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalMessageFiltersObj, SortableFilterOptions} from '../icure-sdk-ts.mjs';
import {Message} from '../model/Message.mjs';


interface MessageFiltersFactory {

	allMessagesForDataOwner(dataOwnerId: string): BaseFilterOptions<Message>;

	allMessagesForSelf(): FilterOptions<Message>;

	byTransportGuidDateForDataOwner(dataOwnerId: string,
			transportGuid: string): BaseSortableFilterOptions<Message>;

	byTransportGuidDate(transportGuid: string): SortableFilterOptions<Message>;

}

export const MessageFilters: MessageFiltersFactory = {
			allMessagesForDataOwner: (dataOwnerId) => InternalMessageFiltersObj.getInstance().allMessagesForDataOwner(dataOwnerId),
			allMessagesForSelf: () => InternalMessageFiltersObj.getInstance().allMessagesForSelf(),
			byTransportGuidDateForDataOwner: (dataOwnerId, transportGuid) => InternalMessageFiltersObj.getInstance().byTransportGuidDateForDataOwner(dataOwnerId, transportGuid),
			byTransportGuidDate: (transportGuid) => InternalMessageFiltersObj.getInstance().byTransportGuidDate(transportGuid)
		};
