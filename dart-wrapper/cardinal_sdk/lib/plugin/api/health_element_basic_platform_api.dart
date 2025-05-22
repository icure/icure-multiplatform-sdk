// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class HealthElementBasicPlatformApi {
	MethodChannel _methodChannel;
	HealthElementBasicInGroupPlatformApi inGroup;
	HealthElementBasicPlatformApi(
		this._methodChannel
		) : inGroup = HealthElementBasicInGroupPlatformApi(_methodChannel);

	Future<List<String>> matchHealthElementsBy(String sdkId, BaseFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.matchHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchHealthElementsBySorted(String sdkId, BaseSortableFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.matchHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBy(String sdkId, BaseFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.filterHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBySorted(String sdkId, BaseSortableFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.filterHealthElementsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}

	Future<StoredDocumentIdentifier> deleteHealthElementById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.deleteHealthElementById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deleteHealthElementsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.deleteHealthElementsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElementsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.purgeHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<StoredDocumentIdentifier> deleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.deleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return StoredDocumentIdentifier.fromJSON(parsedResJson);
	}

	Future<List<StoredDocumentIdentifier>> deleteHealthElements(String sdkId, List<HealthElement> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.deleteHealthElements',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => HealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => StoredDocumentIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.purgeHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
	}

	Future<EncryptedHealthElement> createHealthElement(String sdkId, EncryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedHealthElement.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> createHealthElements(String sdkId, List<EncryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.createHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedHealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EncryptedHealthElement> undeleteHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.undeleteHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<EncryptedHealthElement> undeleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.undeleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<EncryptedHealthElement> modifyHealthElement(String sdkId, EncryptedHealthElement entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedHealthElement.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> modifyHealthElements(String sdkId, List<EncryptedHealthElement> entities) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.modifyHealthElements',
			{
				"sdkId": sdkId,
				"entities": jsonEncode(entities.map((x0) => EncryptedHealthElement.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EncryptedHealthElement?> getHealthElement(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.getHealthElement',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> getHealthElements(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.getHealthElements',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedHealthElement>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, BaseFilterOptions<HealthElement> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}
}

class HealthElementBasicInGroupPlatformApi {
	MethodChannel _methodChannel;
	HealthElementBasicInGroupPlatformApi(this._methodChannel);

	Future<GroupScoped<EncryptedHealthElement>> createHealthElement(String sdkId, GroupScoped<EncryptedHealthElement> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.inGroup.createHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return EncryptedHealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createHealthElement");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedHealthElement>> modifyHealthElement(String sdkId, GroupScoped<EncryptedHealthElement> entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.inGroup.modifyHealthElement',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(GroupScoped.encode(
					entity,
					(x0) {
						return EncryptedHealthElement.encode(x0);
					},
				)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElement");
		final parsedResJson = jsonDecode(res);
		return GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedHealthElement.fromJSON(x1);
			},
		);
	}

	Future<GroupScoped<EncryptedHealthElement>?> getHealthElement(String sdkId, String groupId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.inGroup.getHealthElement',
			{
				"sdkId": sdkId,
				"groupId": jsonEncode(groupId),
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : GroupScoped.fromJSON(
			parsedResJson,
			(x1) {
				return EncryptedHealthElement.fromJSON(x1);
			},
		);
	}
}