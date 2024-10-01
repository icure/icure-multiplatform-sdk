// auto-generated file
import {BaseFilterOptions, BaseSortableFilterOptions, PaginatedListIterator} from '../cardinal-sdk-ts.mjs';
import {Device} from '../model/Device.mjs';
import {IdWithMandatoryRev} from '../model/IdWithMandatoryRev.mjs';
import {IdWithRev} from '../model/IdWithRev.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';


export interface DeviceApi {

	deleteDevice(entityId: string): Promise<DocIdentifier>;

	deleteDevices(entityIds: Array<string>): Promise<Array<DocIdentifier>>;

	getDevice(deviceId: string): Promise<Device>;

	getDevices(deviceIds: Array<string>): Promise<Array<Device>>;

	createDevice(p: Device): Promise<Device>;

	modifyDevice(device: Device): Promise<Device>;

	createDevices(devices: Array<Device>): Promise<Array<IdWithRev>>;

	modifyDevices(devices: Array<Device>): Promise<Array<IdWithRev>>;

	filterDevicesBy(filter: BaseFilterOptions<Device>): Promise<PaginatedListIterator<Device>>;

	filterDevicesBySorted(filter: BaseSortableFilterOptions<Device>): Promise<PaginatedListIterator<Device>>;

	matchDevicesBy(filter: BaseFilterOptions<Device>): Promise<Array<string>>;

	matchDevicesBySorted(filter: BaseSortableFilterOptions<Device>): Promise<Array<string>>;

	deleteDeviceById(entityId: string, rev: string): Promise<DocIdentifier>;

	deleteDevicesByIds(entityIds: Array<IdWithMandatoryRev>): Promise<Array<DocIdentifier>>;

	purgeDeviceById(id: string, rev: string): Promise<void>;

	undeleteDeviceById(id: string, rev: string): Promise<Device>;

	deleteDevice(device: Device): Promise<DocIdentifier>;

	deleteDevices(devices: Array<Device>): Promise<Array<DocIdentifier>>;

	purgeDevice(device: Device): Promise<void>;

	undeleteDevice(device: Device): Promise<Device>;

	getDevicesInGroup(groupId: string,
			options?: { deviceIds?: Array<string> | undefined }): Promise<Array<Device>>;

	modifyDeviceInGroup(groupId: string, device: Device): Promise<Device>;

	createDeviceInGroup(groupId: string, device: Device): Promise<Device>;

	deleteDevicesInGroup(groupId: string, deviceIds: Array<IdWithRev>): Promise<Array<DocIdentifier>>;

}
