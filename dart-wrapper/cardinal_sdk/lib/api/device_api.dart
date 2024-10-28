// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/device.dart';
import 'package:cardinal_sdk/model/id_with_rev.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class DeviceApi {
	final String _sdkId;
	DeviceApi(this._sdkId);

	Future<Device> getDevice(String deviceId) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.getDevice(
			_sdkId,
			deviceId,
		);
	}

	Future<List<Device>> getDevices(List<String> deviceIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.getDevices(
			_sdkId,
			deviceIds,
		);
	}

	Future<Device> createDevice(Device p) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.createDevice(
			_sdkId,
			p,
		);
	}

	Future<Device> modifyDevice(Device device) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.modifyDevice(
			_sdkId,
			device,
		);
	}

	Future<List<IdWithRev>> createDevices(List<Device> devices) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.createDevices(
			_sdkId,
			devices,
		);
	}

	Future<List<IdWithRev>> modifyDevices(List<Device> devices) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.modifyDevices(
			_sdkId,
			devices,
		);
	}

	Future<PaginatedListIterator<Device>> filterDevicesBy(BaseFilterOptions<Device> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.filterDevicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Device>> filterDevicesBySorted(BaseSortableFilterOptions<Device> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.filterDevicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchDevicesBy(BaseFilterOptions<Device> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.matchDevicesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchDevicesBySorted(BaseSortableFilterOptions<Device> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.matchDevicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteDeviceById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.deleteDeviceById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteDevicesByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.deleteDevicesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeDeviceById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.purgeDeviceById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Device> undeleteDeviceById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.undeleteDeviceById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteDevice(Device device) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.deleteDevice(
			_sdkId,
			device,
		);
	}

	Future<List<DocIdentifier>> deleteDevices(List<Device> devices) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.deleteDevices(
			_sdkId,
			devices,
		);
	}

	Future<void> purgeDevice(Device device) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.purgeDevice(
			_sdkId,
			device,
		);
	}

	Future<Device> undeleteDevice(Device device) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.undeleteDevice(
			_sdkId,
			device,
		);
	}

	Future<List<Device>> getDevicesInGroup(String groupId, List<String>? deviceIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.getDevicesInGroup(
			_sdkId,
			groupId,
			deviceIds,
		);
	}

	Future<Device> modifyDeviceInGroup(String groupId, Device device) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.modifyDeviceInGroup(
			_sdkId,
			groupId,
			device,
		);
	}

	Future<Device> createDeviceInGroup(String groupId, Device device) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.createDeviceInGroup(
			_sdkId,
			groupId,
			device,
		);
	}

	Future<List<DocIdentifier>> deleteDevicesInGroup(String groupId, List<IdWithRev> deviceIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.deleteDevicesInGroup(
			_sdkId,
			groupId,
			deviceIds,
		);
	}

	Future<EntitySubscription<Device>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<Device> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.apis.device.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}