// auto-generated file
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/maintenance_task_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MaintenanceTaskPlatformApi {
	String _sdkId;
	TryAndRecoverMaintenanceTaskPlatformApi tryAndRecover;
	EncryptedMaintenanceTaskPlatformApi encrypted;
	MaintenanceTaskPlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverMaintenanceTaskPlatformApi(_sdkId),
		encrypted = EncryptedMaintenanceTaskPlatformApi(_sdkId);

	Future<DecryptedMaintenanceTask> createMaintenanceTask(DecryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.createMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedMaintenanceTask> withEncryptionMetadata(DecryptedMaintenanceTask? maintenanceTask, User? user, { Map<String, AccessLevel> delegates = const {} }) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.withEncryptionMetadata(
			_sdkId,
			maintenanceTask,
			user,
			delegates,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.getEncryptionKeysOf(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<bool> hasWriteAccess(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.hasWriteAccess(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<Set<String>> decryptPatientIdOf(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.decryptPatientIdOf(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(MaintenanceTask entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedMaintenanceTask> decrypt(EncryptedMaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.decrypt(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<MaintenanceTask> tryDecrypt(EncryptedMaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryDecrypt(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<List<String>> matchMaintenanceTasksBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.matchMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchMaintenanceTasksBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.matchMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteMaintenanceTaskById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.deleteMaintenanceTaskById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasksByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.deleteMaintenanceTasksByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.purgeMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.deleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasks(List<MaintenanceTask> maintenanceTasks) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.deleteMaintenanceTasks(
			_sdkId,
			maintenanceTasks,
		);
	}

	Future<void> purgeMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.purgeMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<DecryptedMaintenanceTask> shareWith(String delegateId, DecryptedMaintenanceTask maintenanceTask, MaintenanceTaskShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.shareWith(
			_sdkId,
			delegateId,
			maintenanceTask,
			options,
		);
	}

	Future<DecryptedMaintenanceTask> shareWithMany(DecryptedMaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.shareWithMany(
			_sdkId,
			maintenanceTask,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedMaintenanceTask>> filterMaintenanceTasksBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.filterMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedMaintenanceTask>> filterMaintenanceTasksBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.filterMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.undeleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<DecryptedMaintenanceTask> undeleteMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.undeleteMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedMaintenanceTask> modifyMaintenanceTask(DecryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.modifyMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedMaintenanceTask> getMaintenanceTask(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.getMaintenanceTask(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedMaintenanceTask>> getMaintenanceTasks(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.getMaintenanceTasks(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedMaintenanceTask>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class TryAndRecoverMaintenanceTaskPlatformApi {
	String _sdkId;
	TryAndRecoverMaintenanceTaskPlatformApi(this._sdkId);

	Future<MaintenanceTask> shareWith(String delegateId, MaintenanceTask maintenanceTask, MaintenanceTaskShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			maintenanceTask,
			options,
		);
	}

	Future<MaintenanceTask> shareWithMany(MaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.shareWithMany(
			_sdkId,
			maintenanceTask,
			delegates,
		);
	}

	Future<PaginatedListIterator<MaintenanceTask>> filterMaintenanceTasksBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.filterMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<MaintenanceTask>> filterMaintenanceTasksBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.filterMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.undeleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.undeleteMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<MaintenanceTask> modifyMaintenanceTask(MaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.modifyMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<MaintenanceTask> getMaintenanceTask(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.getMaintenanceTask(
			_sdkId,
			entityId,
		);
	}

	Future<List<MaintenanceTask>> getMaintenanceTasks(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.tryAndRecover.getMaintenanceTasks(
			_sdkId,
			entityIds,
		);
	}
}

class EncryptedMaintenanceTaskPlatformApi {
	String _sdkId;
	EncryptedMaintenanceTaskPlatformApi(this._sdkId);

	Future<EncryptedMaintenanceTask> shareWith(String delegateId, EncryptedMaintenanceTask maintenanceTask, MaintenanceTaskShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.shareWith(
			_sdkId,
			delegateId,
			maintenanceTask,
			options,
		);
	}

	Future<EncryptedMaintenanceTask> shareWithMany(EncryptedMaintenanceTask maintenanceTask, Map<String, MaintenanceTaskShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.shareWithMany(
			_sdkId,
			maintenanceTask,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.filterMaintenanceTasksBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.filterMaintenanceTasksBySorted(
			_sdkId,
			filter,
		);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(MaintenanceTask maintenanceTask) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.undeleteMaintenanceTask(
			_sdkId,
			maintenanceTask,
		);
	}

	Future<EncryptedMaintenanceTask> undeleteMaintenanceTaskById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.undeleteMaintenanceTaskById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedMaintenanceTask> modifyMaintenanceTask(EncryptedMaintenanceTask entity) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.modifyMaintenanceTask(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedMaintenanceTask> getMaintenanceTask(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.getMaintenanceTask(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedMaintenanceTask>> getMaintenanceTasks(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.maintenanceTask.encrypted.getMaintenanceTasks(
			_sdkId,
			entityIds,
		);
	}
}