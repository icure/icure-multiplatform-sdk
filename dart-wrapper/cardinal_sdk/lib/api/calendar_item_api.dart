// auto-generated file
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/calendar_item_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class CalendarItemApi {
	final String _sdkId;
	final TryAndRecoverCalendarItemApi tryAndRecover;
	final EncryptedCalendarItemApi encrypted;
	CalendarItemApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverCalendarItemApi(_sdkId),
		encrypted = EncryptedCalendarItemApi(_sdkId);

	Future<DecryptedCalendarItem> createCalendarItem(DecryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.createCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedCalendarItem> withEncryptionMetadata(DecryptedCalendarItem? base, Patient patient, User? user, { Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.getEncryptionKeysOf(
			_sdkId,
			calendarItem,
		);
	}

	Future<bool> hasWriteAccess(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.hasWriteAccess(
			_sdkId,
			calendarItem,
		);
	}

	Future<Set<String>> decryptPatientIdOf(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.decryptPatientIdOf(
			_sdkId,
			calendarItem,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(CalendarItem entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedCalendarItem> decrypt(EncryptedCalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.decrypt(
			_sdkId,
			calendarItem,
		);
	}

	Future<CalendarItem> tryDecrypt(EncryptedCalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryDecrypt(
			_sdkId,
			calendarItem,
		);
	}

	Future<List<String>> matchCalendarItemsBy(FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.matchCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchCalendarItemsBySorted(SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.matchCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteCalendarItemById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.deleteCalendarItemById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteCalendarItemsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.deleteCalendarItemsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.purgeCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.deleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<List<DocIdentifier>> deleteCalendarItems(List<CalendarItem> calendarItems) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.deleteCalendarItems(
			_sdkId,
			calendarItems,
		);
	}

	Future<void> purgeCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.purgeCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<DecryptedCalendarItem> shareWith(String delegateId, DecryptedCalendarItem calendarItem, CalendarItemShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.shareWith(
			_sdkId,
			delegateId,
			calendarItem,
			options,
		);
	}

	Future<DecryptedCalendarItem> shareWithMany(DecryptedCalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<DecryptedCalendarItem> linkToPatient(CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.linkToPatient(
			_sdkId,
			calendarItem,
			patient,
			shareLinkWithDelegates,
		);
	}

	Future<PaginatedListIterator<DecryptedCalendarItem>> filterCalendarItemsBy(FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.filterCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedCalendarItem>> filterCalendarItemsBySorted(SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.filterCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedCalendarItem> undeleteCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.undeleteCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedCalendarItem> undeleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.undeleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<DecryptedCalendarItem> modifyCalendarItem(DecryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedCalendarItem> getCalendarItem(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.getCalendarItem(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedCalendarItem>> getCalendarItems(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.getCalendarItems(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedCalendarItem>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<CalendarItem> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class TryAndRecoverCalendarItemApi {
	final String _sdkId;
	TryAndRecoverCalendarItemApi(this._sdkId);

	Future<CalendarItem> shareWith(String delegateId, CalendarItem calendarItem, CalendarItemShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			calendarItem,
			options,
		);
	}

	Future<CalendarItem> shareWithMany(CalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<CalendarItem> linkToPatient(CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.linkToPatient(
			_sdkId,
			calendarItem,
			patient,
			shareLinkWithDelegates,
		);
	}

	Future<PaginatedListIterator<CalendarItem>> filterCalendarItemsBy(FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.filterCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<CalendarItem>> filterCalendarItemsBySorted(SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.filterCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<CalendarItem> undeleteCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.undeleteCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<CalendarItem> undeleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.undeleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<CalendarItem> modifyCalendarItem(CalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<CalendarItem> getCalendarItem(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.getCalendarItem(
			_sdkId,
			entityId,
		);
	}

	Future<List<CalendarItem>> getCalendarItems(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.tryAndRecover.getCalendarItems(
			_sdkId,
			entityIds,
		);
	}
}

class EncryptedCalendarItemApi {
	final String _sdkId;
	EncryptedCalendarItemApi(this._sdkId);

	Future<EncryptedCalendarItem> shareWith(String delegateId, EncryptedCalendarItem calendarItem, CalendarItemShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.shareWith(
			_sdkId,
			delegateId,
			calendarItem,
			options,
		);
	}

	Future<EncryptedCalendarItem> shareWithMany(EncryptedCalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.shareWithMany(
			_sdkId,
			calendarItem,
			delegates,
		);
	}

	Future<EncryptedCalendarItem> linkToPatient(CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.linkToPatient(
			_sdkId,
			calendarItem,
			patient,
			shareLinkWithDelegates,
		);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBy(FilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.filterCalendarItemsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBySorted(SortableFilterOptions<CalendarItem> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.filterCalendarItemsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItemById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.undeleteCalendarItemById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedCalendarItem> undeleteCalendarItem(CalendarItem calendarItem) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.undeleteCalendarItem(
			_sdkId,
			calendarItem,
		);
	}

	Future<EncryptedCalendarItem> modifyCalendarItem(EncryptedCalendarItem entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.modifyCalendarItem(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedCalendarItem> getCalendarItem(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.getCalendarItem(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedCalendarItem>> getCalendarItems(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.calendarItem.encrypted.getCalendarItems(
			_sdkId,
			entityIds,
		);
	}
}