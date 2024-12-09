// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class CalendarItemBasicApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	CalendarItemBasicApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchCalendarItemsBy(BaseFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.matchCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchCalendarItemsBySorted(BaseSortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.matchCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBy(BaseFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.filterCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBySorted(BaseSortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.filterCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteCalendarItemById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.deleteCalendarItemById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteCalendarItemsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.deleteCalendarItemsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.purgeCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.deleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<List<DocIdentifier>> deleteCalendarItems(List<CalendarItem> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.deleteCalendarItems(
			_sdkId,
			calendarItems,
		);
	}

	Future<void> purgeCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.purgeCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.undeleteCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.undeleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<EncryptedCalendarItem> modifyCalendarItem(EncryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedCalendarItem> getCalendarItem(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.getCalendarItem(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedCalendarItem>> getCalendarItems(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.getCalendarItems(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedCalendarItem>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<CalendarItem> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItemBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}