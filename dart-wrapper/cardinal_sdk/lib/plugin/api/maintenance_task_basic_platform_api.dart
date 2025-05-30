// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/maintenance_task.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MaintenanceTaskBasicPlatformApi {
	MethodChannel _methodChannel;
	MaintenanceTaskBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchMaintenanceTasksBy(String sdkId, BaseFilterOptions<MaintenanceTask> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.matchMaintenanceTasksBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchMaintenanceTasksBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchMaintenanceTasksBySorted(String sdkId, BaseSortableFilterOptions<MaintenanceTask> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.matchMaintenanceTasksBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchMaintenanceTasksBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBy(String sdkId, BaseFilterOptions<MaintenanceTask> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.filterMaintenanceTasksBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMaintenanceTasksBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedMaintenanceTask.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedMaintenanceTask>> filterMaintenanceTasksBySorted(String sdkId, BaseSortableFilterOptions<MaintenanceTask> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.filterMaintenanceTasksBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMaintenanceTasksBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedMaintenanceTask.fromJSON(x0));
	}

	Future<DocIdentifier> deleteMaintenanceTaskById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.deleteMaintenanceTaskById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMaintenanceTaskById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasksByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.deleteMaintenanceTasksByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMaintenanceTasksByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeMaintenanceTaskById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.purgeMaintenanceTaskById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteMaintenanceTask(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.deleteMaintenanceTask',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMaintenanceTasks(String sdkId, List<MaintenanceTask> maintenanceTasks) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.deleteMaintenanceTasks',
			{
				"sdkId": sdkId,
				"maintenanceTasks": jsonEncode(maintenanceTasks.map((x0) => MaintenanceTask.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMaintenanceTasks");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeMaintenanceTask(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.purgeMaintenanceTask',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		).catchError(convertPlatformException);
	}

	Future<EncryptedMaintenanceTask> createMaintenanceTask(String sdkId, EncryptedMaintenanceTask entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.createMaintenanceTask',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMaintenanceTask.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<MaintenanceTask> undeleteMaintenanceTask(String sdkId, MaintenanceTask maintenanceTask) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.undeleteMaintenanceTask',
			{
				"sdkId": sdkId,
				"maintenanceTask": jsonEncode(MaintenanceTask.encode(maintenanceTask)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return MaintenanceTask.fromJSON(parsedResJson);
	}

	Future<EncryptedMaintenanceTask> undeleteMaintenanceTaskById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.undeleteMaintenanceTaskById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMaintenanceTaskById");
		final parsedResJson = jsonDecode(res);
		return EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<EncryptedMaintenanceTask> modifyMaintenanceTask(String sdkId, EncryptedMaintenanceTask entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.modifyMaintenanceTask',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMaintenanceTask.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<EncryptedMaintenanceTask?> getMaintenanceTask(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.getMaintenanceTask',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMaintenanceTask");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedMaintenanceTask.fromJSON(parsedResJson);
	}

	Future<List<EncryptedMaintenanceTask>> getMaintenanceTasks(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.getMaintenanceTasks',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMaintenanceTasks");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedMaintenanceTask.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedMaintenanceTask>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, BaseFilterOptions<MaintenanceTask> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MaintenanceTaskBasicApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedMaintenanceTask.fromJSON(x0));
	}
}