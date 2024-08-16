// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, InternalDeviceFiltersObj} from '../icure-sdk-ts.mjs';
import {Device} from '../model/Device.mjs';


interface DeviceFiltersFactory {

	all(): BaseFilterOptions<Device>;

	byResponsible(responsibleId: string): BaseFilterOptions<Device>;

	byIds(ids: Array<string>): BaseSortableFilterOptions<Device>;

}

const DeviceFilters: DeviceFiltersFactory = InternalDeviceFiltersObj.getInstance();
