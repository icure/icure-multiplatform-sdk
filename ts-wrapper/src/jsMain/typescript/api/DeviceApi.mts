// auto-generated file
import {Device} from '../model/Device.mjs';
import {IdWithRev} from '../model/IdWithRev.mjs';
import {PaginatedList} from '../model/PaginatedList.mjs';
import {DocIdentifier} from '../model/couchdb/DocIdentifier.mjs';
import {AbstractFilter} from '../model/filter/AbstractFilter.mjs';
import {FilterChain} from '../model/filter/chain/FilterChain.mjs';


export interface DeviceApi {

	getDevice(deviceId: string): Promise<Device>;

	getDevices(deviceIds: Array<string>): Promise<Array<Device>>;

	createDevice(p: Device): Promise<Device>;

	updateDevice(device: Device): Promise<Device>;

	createDevices(devices: Array<Device>): Promise<Array<IdWithRev>>;

	updateDevices(devices: Array<Device>): Promise<Array<IdWithRev>>;

	filterDevicesBy(filterChain: FilterChain<Device>,
			options?: { startDocumentId?: string | undefined, limit?: number | undefined }): Promise<PaginatedList<Device>>;

	matchDevicesBy(filter: AbstractFilter<Device>): Promise<Array<string>>;

	deleteDevice(deviceId: string): Promise<DocIdentifier>;

	deleteDevices(deviceIds: Array<string>): Promise<Array<DocIdentifier>>;

	getDevicesInGroup(groupId: string,
			options?: { deviceIds?: Array<string> | undefined }): Promise<Array<Device>>;

	modifyDeviceInGroup(groupId: string, device: Device): Promise<Device>;

	createDeviceInGroup(groupId: string, device: Device): Promise<Device>;

	deleteDevicesInGroup(groupId: string, deviceIds: string): Promise<Array<DocIdentifier>>;

}
