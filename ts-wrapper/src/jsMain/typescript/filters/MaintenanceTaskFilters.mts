// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, FilterOptions, InternalMaintenanceTaskFiltersObj, SortableFilterOptions} from '../icure-sdk-ts.mjs';
import {MaintenanceTask} from '../model/MaintenanceTask.mjs';
import {Identifier} from '../model/base/Identifier.mjs';


interface MaintenanceTaskFiltersFactory {

	byIds(ids: Array<string>): BaseSortableFilterOptions<MaintenanceTask>;

	byIdentifiersForDataOwner(dataOwnerId: string,
			identifiers: Array<Identifier>): BaseSortableFilterOptions<MaintenanceTask>;

	byIdentifiersForSelf(identifiers: Array<Identifier>): SortableFilterOptions<MaintenanceTask>;

	byTypeForDataOwner(dataOwnerId: string, type: string): BaseFilterOptions<MaintenanceTask>;

	byTypeForSelf(type: string): FilterOptions<MaintenanceTask>;

	afterDateForDataOwner(dataOwnerId: string,
			date: number): BaseSortableFilterOptions<MaintenanceTask>;

	afterDateForSelf(date: number): SortableFilterOptions<MaintenanceTask>;

}

export const MaintenanceTaskFilters: MaintenanceTaskFiltersFactory = {
			byIds: (ids) => InternalMaintenanceTaskFiltersObj.getInstance().byIds(ids),
			byIdentifiersForDataOwner: (dataOwnerId, identifiers) => InternalMaintenanceTaskFiltersObj.getInstance().byIdentifiersForDataOwner(dataOwnerId, identifiers),
			byIdentifiersForSelf: (identifiers) => InternalMaintenanceTaskFiltersObj.getInstance().byIdentifiersForSelf(identifiers),
			byTypeForDataOwner: (dataOwnerId, type) => InternalMaintenanceTaskFiltersObj.getInstance().byTypeForDataOwner(dataOwnerId, type),
			byTypeForSelf: (type) => InternalMaintenanceTaskFiltersObj.getInstance().byTypeForSelf(type),
			afterDateForDataOwner: (dataOwnerId, date) => InternalMaintenanceTaskFiltersObj.getInstance().afterDateForDataOwner(dataOwnerId, date),
			afterDateForSelf: (date) => InternalMaintenanceTaskFiltersObj.getInstance().afterDateForSelf(date)
		};
