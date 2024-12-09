// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MaintenanceTaskBasicApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	MaintenanceTaskBasicApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchMaintenanceTasksBy(BaseFilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.matchMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchMaintenanceTasksBySorted(BaseSortableFilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.matchMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBy(BaseFilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.filterMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBySorted(BaseSortableFilterOptions<MaintenanceTask> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.filterMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteMaintenanceTaskById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.deleteMaintenanceTaskById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasksByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.deleteMaintenanceTasksByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.purgeMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.deleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasks(List<MaintenanceTask> maintenanceTasks) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.deleteMaintenanceTasks(
			_sdkId,
			maintenanceTasks,
		);
	}

	Future<void> purgeMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.purgeMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.undeleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<EncryptedMaintenanceTask> undeleteMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.undeleteMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedMaintenanceTask> modifyMaintenanceTask(EncryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.modifyMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedMaintenanceTask> getMaintenanceTask(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.getMaintenanceTask(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedMaintenanceTask>> getMaintenanceTasks(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.getMaintenanceTasks(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedMaintenanceTask>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions<MaintenanceTask> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.maintenanceTaskBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}