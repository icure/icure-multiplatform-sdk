// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/device.dart';
import 'dart:convert';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class DevicePlatformApi {
	MethodChannel _methodChannel;
	DevicePlatformApi(this._methodChannel);

	Future<Device> getDevice(String sdkId, String deviceId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.getDevice',
			{
				"sdkId": sdkId,
				"deviceId": jsonEncode(deviceId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDevice");
		final parsedResJson = jsonDecode(res);
		return Device.fromJSON(parsedResJson);
	}

	Future<List<Device>> getDevices(String sdkId, List<String> deviceIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.getDevices',
			{
				"sdkId": sdkId,
				"deviceIds": jsonEncode(deviceIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDevices");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Device.fromJSON(x1) );
	}

	Future<Device> createDevice(String sdkId, Device p) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.createDevice',
			{
				"sdkId": sdkId,
				"p": jsonEncode(Device.encode(p)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createDevice");
		final parsedResJson = jsonDecode(res);
		return Device.fromJSON(parsedResJson);
	}

	Future<Device> modifyDevice(String sdkId, Device device) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.modifyDevice',
			{
				"sdkId": sdkId,
				"device": jsonEncode(Device.encode(device)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDevice");
		final parsedResJson = jsonDecode(res);
		return Device.fromJSON(parsedResJson);
	}

	Future<List<IdWithRev>> createDevices(String sdkId, List<Device> devices) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.createDevices',
			{
				"sdkId": sdkId,
				"devices": jsonEncode(devices.map((x0) => Device.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createDevices");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => IdWithRev.fromJSON(x1) );
	}

	Future<List<IdWithRev>> modifyDevices(String sdkId, List<Device> devices) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.modifyDevices',
			{
				"sdkId": sdkId,
				"devices": jsonEncode(devices.map((x0) => Device.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDevices");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => IdWithRev.fromJSON(x1) );
	}

	Future<PaginatedListIterator<Device>> filterDevicesBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.filterDevicesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterDevicesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Device.fromJSON(x0));
	}

	Future<PaginatedListIterator<Device>> filterDevicesBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.filterDevicesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterDevicesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => Device.fromJSON(x0));
	}

	Future<List<String>> matchDevicesBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.matchDevicesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchDevicesBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchDevicesBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.matchDevicesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchDevicesBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<DocIdentifier> deleteDeviceById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.deleteDeviceById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDeviceById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDevicesByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.deleteDevicesByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDevicesByIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeDeviceById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.purgeDeviceById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<Device> undeleteDeviceById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.undeleteDeviceById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteDeviceById");
		final parsedResJson = jsonDecode(res);
		return Device.fromJSON(parsedResJson);
	}

	Future<DocIdentifier> deleteDevice(String sdkId, Device device) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.deleteDevice',
			{
				"sdkId": sdkId,
				"device": jsonEncode(Device.encode(device)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDevice");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDevices(String sdkId, List<Device> devices) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.deleteDevices',
			{
				"sdkId": sdkId,
				"devices": jsonEncode(devices.map((x0) => Device.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDevices");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeDevice(String sdkId, Device device) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.purgeDevice',
			{
				"sdkId": sdkId,
				"device": jsonEncode(Device.encode(device)),
			}
		);
	}

	Future<Device> undeleteDevice(String sdkId, Device device) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.undeleteDevice',
			{
				"sdkId": sdkId,
				"device": jsonEncode(Device.encode(device)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteDevice");
		final parsedResJson = jsonDecode(res);
		return Device.fromJSON(parsedResJson);
	}

	Future<List<Device>> getDevicesInGroup(String sdkId, String groupId, List<String>? deviceIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.getDevicesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"deviceIds": jsonEncode(deviceIds?.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getDevicesInGroup");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => Device.fromJSON(x1) );
	}

	Future<Device> modifyDeviceInGroup(String sdkId, String groupId, Device device) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.modifyDeviceInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"device": jsonEncode(Device.encode(device)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyDeviceInGroup");
		final parsedResJson = jsonDecode(res);
		return Device.fromJSON(parsedResJson);
	}

	Future<Device> createDeviceInGroup(String sdkId, String groupId, Device device) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.createDeviceInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"device": jsonEncode(Device.encode(device)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createDeviceInGroup");
		final parsedResJson = jsonDecode(res);
		return Device.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteDevicesInGroup(String sdkId, String groupId, List<IdWithRev> deviceIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.deleteDevicesInGroup',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"deviceIds": jsonEncode(deviceIds.map((x0) => IdWithRev.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteDevicesInGroup");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<EntitySubscription<Device>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'DeviceApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0))),
				"filter": jsonEncode(FilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => Device.fromJSON(x0));
	}
}