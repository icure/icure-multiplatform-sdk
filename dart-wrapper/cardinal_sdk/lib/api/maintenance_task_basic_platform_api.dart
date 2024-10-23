// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MaintenanceTaskBasicPlatformApi {
	String _sdkId;
	MaintenanceTaskBasicPlatformApi(this._sdkId);

	Future<List<String>> matchMaintenanceTasksBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.matchMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchMaintenanceTasksBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.matchMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.filterMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.filterMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteMaintenanceTaskById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.deleteMaintenanceTaskById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasksByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.deleteMaintenanceTasksByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.purgeMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.deleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasks(List<MaintenanceTask> maintenanceTasks) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.deleteMaintenanceTasks(
			_sdkId,
			maintenanceTasks,
		);
	}

	Future<void> purgeMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.purgeMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.undeleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<EncryptedMaintenanceTask> undeleteMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.undeleteMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedMaintenanceTask> modifyMaintenanceTask(EncryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.modifyMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedMaintenanceTask> getMaintenanceTask(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.getMaintenanceTask(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedMaintenanceTask>> getMaintenanceTasks(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.getMaintenanceTasks(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedMaintenanceTask>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTaskBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}