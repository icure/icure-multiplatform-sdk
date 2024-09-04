// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Device} from '../model/Device.mjs';
import {IdWithRev} from '../model/IdWithRev.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface DeviceApi {

	getDevice(deviceId: string): Promise<Device>;

	getDevices(deviceIds: Array<string>): Promise<Array<Device>>;

	createDevice(p: Device): Promise<Device>;

	updateDevice(device: Device): Promise<Device>;

	createDevices(devices: Array<Device>): Promise<Array<IdWithRev>>;

	updateDevices(devices: Array<Device>): Promise<Array<IdWithRev>>;

	filterDevicesBy(filter: BaseFilterOptions<Device>): Promise<PaginatedListIterator<Device>>;

	filterDevicesBySorted(filter: BaseSortableFilterOptions<Device>): Promise<PaginatedListIterator<Device>>;

	matchDevicesBy(filter: BaseFilterOptions<Device>): Promise<Array<string>>;

	matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>): Promise<Array<string>>;

	deleteDevice(deviceId: string): Promise<DocIdentifier>;

	deleteDevices(deviceIds: Array<string>): Promise<Array<DocIdentifier>>;

	getDevicesInGroup(groupId: string,
			options?: { deviceIds?: Array<string> | undefined }): Promise<Array<Device>>;

	modifyDeviceInGroup(groupId: string, device: Device): Promise<Device>;

	createDeviceInGroup(groupId: string, device: Device): Promise<Device>;

	deleteDevicesInGroup(groupId: string, deviceIds: string): Promise<Array<DocIdentifier>>;

}
