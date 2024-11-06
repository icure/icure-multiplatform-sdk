// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class HealthElementBasicPlatformApi {
	MethodChannel _methodChannel;
	HealthElementBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchHealthElementsBy(String sdkId, BaseFilterOptions<HealthElement> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.matchHealthElementsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		);
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
		);
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
		);
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
		);
		if (res == null) throw AssertionError("received null result from platform method filterHealthElementsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}

	Future<DocIdentifier> deleteHealthElementById(String sdkId, String entityId, String? rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.deleteHealthElementById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElementById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteHealthElementsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.deleteHealthElementsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElementsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.purgeHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.deleteHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElement");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteHealthElements(String sdkId, List<HealthElement> healthElements) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.deleteHealthElements',
			{
				"sdkId": sdkId,
				"healthElements": jsonEncode(healthElements.map((x0) => HealthElement.encode(x0)).toList()),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeHealthElement(String sdkId, HealthElement healthElement) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.purgeHealthElement',
			{
				"sdkId": sdkId,
				"healthElement": jsonEncode(HealthElement.encode(healthElement)),
			}
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElementById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.undeleteHealthElementById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
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
		);
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
		);
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
		);
		if (res == null) throw AssertionError("received null result from platform method modifyHealthElements");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedHealthElement.fromJSON(x1) ).toList();
	}

	Future<EncryptedHealthElement> getHealthElement(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.getHealthElement',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getHealthElement");
		final parsedResJson = jsonDecode(res);
		return EncryptedHealthElement.fromJSON(parsedResJson);
	}

	Future<List<EncryptedHealthElement>> getHealthElements(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'HealthElementBasicApi.getHealthElements',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		);
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
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedHealthElement.fromJSON(x0));
	}
}