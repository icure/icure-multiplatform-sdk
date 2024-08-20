// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalDeviceFiltersObj} from '../icure-sdk-ts.mjs';
import {Device} from '../model/Device.mjs';


interface DeviceFiltersFactory {

	all(): BaseFilterOptions<Device>;

	byResponsible(responsibleId: string): BaseFilterOptions<Device>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<Device>;

}

export const DeviceFilters: DeviceFiltersFactory = {
			all: () => InternalDeviceFiltersObj.getInstance().all(),
			byResponsible: (responsibleId) => InternalDeviceFiltersObj.getInstance().byResponsible(responsibleId),
			byIds: (ids) => InternalDeviceFiltersObj.getInstance().byIds(ids)
		};
