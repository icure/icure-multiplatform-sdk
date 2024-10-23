// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class CalendarItemBasicPlatformApi {
	MethodChannel _methodChannel;
	CalendarItemBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchCalendarItemsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.matchCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchCalendarItemsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.matchCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBy(String sdkId, BaseFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBySorted(String sdkId, BaseSortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}

	Future<DocIdentifier> deleteCalendarItemById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.deleteCalendarItemById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteCalendarItemsByIds(String sdkId, List<IdWithMandatoryRev> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.deleteCalendarItemsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => IdWithMandatoryRev.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItemsByIds");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.purgeCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.deleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteCalendarItems(String sdkId, List<CalendarItem> calendarItems) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.deleteCalendarItems',
			{
				"sdkId": sdkId,
				"calendarItems": jsonEncode(calendarItems.map((x0) => CalendarItem.encode(x0))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method deleteCalendarItems");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DocIdentifier.fromJSON(x1) );
	}

	Future<void> purgeCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.purgeCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.undeleteCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.undeleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> modifyCalendarItem(String sdkId, EncryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedCalendarItem.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> getCalendarItem(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.getCalendarItem',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<List<EncryptedCalendarItem>> getCalendarItems(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.getCalendarItems',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedCalendarItem.fromJSON(x1) );
	}

	Future<EntitySubscription<EncryptedCalendarItem>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemBasicApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0))),
				"filter": jsonEncode(filter.json),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}
}