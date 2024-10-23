// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/model/calendar_item.dart';
import 'dart:convert';
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
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class CalendarItemPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverCalendarItemPlatformApi tryAndRecover;
	EncryptedCalendarItemPlatformApi encrypted;
	CalendarItemPlatformApi(
		this._methodChannel
		) : tryAndRecover = TryAndRecoverCalendarItemPlatformApi(_methodChannel),
		encrypted = EncryptedCalendarItemPlatformApi(_methodChannel);

	Future<DecryptedCalendarItem> createCalendarItem(String sdkId, DecryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.createCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedCalendarItem.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method createCalendarItem");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> withEncryptionMetadata(String sdkId, DecryptedCalendarItem? base, Patient patient, User? user, Map<String, AccessLevel> delegates, SecretIdUseOption secretId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.withEncryptionMetadata',
			{
				"sdkId": sdkId,
				"base": jsonEncode(base == null ? null : DecryptedCalendarItem.encode(base!)),
				"patient": jsonEncode(Patient.encode(patient)),
				"user": jsonEncode(user == null ? null : User.encode(user!)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, AccessLevel.encode(v0)))),
				"secretId": jsonEncode(SecretIdUseOption.encode(secretId)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method withEncryptionMetadata");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<Set<HexString>> getEncryptionKeysOf(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.getEncryptionKeysOf',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getEncryptionKeysOf");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<bool> hasWriteAccess(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.hasWriteAccess',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method hasWriteAccess");
		final parsedResJson = jsonDecode(res);
		return parsedResJson;
	}

	Future<Set<String>> decryptPatientIdOf(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.decryptPatientIdOf',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decryptPatientIdOf");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<void> createDelegationDeAnonymizationMetadata(String sdkId, CalendarItem entity, Set<String> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.createDelegationDeAnonymizationMetadata',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(CalendarItem.encode(entity)),
				"delegates": jsonEncode(delegates.map((x0) => x0)),
			}
		);
	}

	Future<DecryptedCalendarItem> decrypt(String sdkId, EncryptedCalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.decrypt',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(EncryptedCalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method decrypt");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> tryDecrypt(String sdkId, EncryptedCalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryDecrypt',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(EncryptedCalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method tryDecrypt");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<List<String>> matchCalendarItemsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.matchCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<List<String>> matchCalendarItemsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.matchCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method matchCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => x1 );
	}

	Future<DocIdentifier> deleteCalendarItemById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.deleteCalendarItemById',
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
			'CalendarItemApi.deleteCalendarItemsByIds',
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
			'CalendarItemApi.purgeCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
	}

	Future<DocIdentifier> deleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.deleteCalendarItem',
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
			'CalendarItemApi.deleteCalendarItems',
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
			'CalendarItemApi.purgeCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
	}

	Future<DecryptedCalendarItem> shareWith(String sdkId, String delegateId, DecryptedCalendarItem calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"calendarItem": jsonEncode(DecryptedCalendarItem.encode(calendarItem)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> shareWithMany(String sdkId, DecryptedCalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(DecryptedCalendarItem.encode(calendarItem)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, CalendarItemShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> linkToPatient(String sdkId, CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.linkToPatient',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"patient": jsonEncode(Patient.encode(patient)),
				"shareLinkWithDelegates": jsonEncode(shareLinkWithDelegates.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method linkToPatient");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<DecryptedCalendarItem>> filterCalendarItemsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedCalendarItem.fromJSON(x0));
	}

	Future<PaginatedListIterator<DecryptedCalendarItem>> filterCalendarItemsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => DecryptedCalendarItem.fromJSON(x0));
	}

	Future<DecryptedCalendarItem> undeleteCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.undeleteCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> undeleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.undeleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> modifyCalendarItem(String sdkId, DecryptedCalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(DecryptedCalendarItem.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<DecryptedCalendarItem> getCalendarItem(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.getCalendarItem',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return DecryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<List<DecryptedCalendarItem>> getCalendarItems(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.getCalendarItems',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => DecryptedCalendarItem.fromJSON(x1) );
	}

	Future<EntitySubscription<EncryptedCalendarItem>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.subscribeToEvents',
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

class TryAndRecoverCalendarItemPlatformApi {
	MethodChannel _methodChannel;
	TryAndRecoverCalendarItemPlatformApi(this._methodChannel);

	Future<CalendarItem> shareWith(String sdkId, String delegateId, CalendarItem calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> shareWithMany(String sdkId, CalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, CalendarItemShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> linkToPatient(String sdkId, CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.linkToPatient',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"patient": jsonEncode(Patient.encode(patient)),
				"shareLinkWithDelegates": jsonEncode(shareLinkWithDelegates.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method linkToPatient");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<CalendarItem>> filterCalendarItemsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => CalendarItem.fromJSON(x0));
	}

	Future<PaginatedListIterator<CalendarItem>> filterCalendarItemsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => CalendarItem.fromJSON(x0));
	}

	Future<CalendarItem> undeleteCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.undeleteCalendarItemById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItemById");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> undeleteCalendarItem(String sdkId, CalendarItem calendarItem) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.undeleteCalendarItem',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method undeleteCalendarItem");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> modifyCalendarItem(String sdkId, CalendarItem entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.modifyCalendarItem',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(CalendarItem.encode(entity)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method modifyCalendarItem");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<CalendarItem> getCalendarItem(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.getCalendarItem',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItem");
		final parsedResJson = jsonDecode(res);
		return CalendarItem.fromJSON(parsedResJson);
	}

	Future<List<CalendarItem>> getCalendarItems(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.tryAndRecover.getCalendarItems',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => CalendarItem.fromJSON(x1) );
	}
}

class EncryptedCalendarItemPlatformApi {
	MethodChannel _methodChannel;
	EncryptedCalendarItemPlatformApi(this._methodChannel);

	Future<EncryptedCalendarItem> shareWith(String sdkId, String delegateId, EncryptedCalendarItem calendarItem, CalendarItemShareOptions? options) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.shareWith',
			{
				"sdkId": sdkId,
				"delegateId": jsonEncode(delegateId),
				"calendarItem": jsonEncode(EncryptedCalendarItem.encode(calendarItem)),
				"options": jsonEncode(options == null ? null : CalendarItemShareOptions.encode(options!)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWith");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> shareWithMany(String sdkId, EncryptedCalendarItem calendarItem, Map<String, CalendarItemShareOptions> delegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.shareWithMany',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(EncryptedCalendarItem.encode(calendarItem)),
				"delegates": jsonEncode(delegates.map((k0, v0) => MapEntry(k0, CalendarItemShareOptions.encode(v0)))),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method shareWithMany");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<EncryptedCalendarItem> linkToPatient(String sdkId, CalendarItem calendarItem, Patient patient, Set<String> shareLinkWithDelegates) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.linkToPatient',
			{
				"sdkId": sdkId,
				"calendarItem": jsonEncode(CalendarItem.encode(calendarItem)),
				"patient": jsonEncode(Patient.encode(patient)),
				"shareLinkWithDelegates": jsonEncode(shareLinkWithDelegates.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method linkToPatient");
		final parsedResJson = jsonDecode(res);
		return EncryptedCalendarItem.fromJSON(parsedResJson);
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBy(String sdkId, FilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.filterCalendarItemsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedCalendarItem>> filterCalendarItemsBySorted(String sdkId, SortableFilterOptions filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.filterCalendarItemsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(filter.json),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method filterCalendarItemsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedCalendarItem.fromJSON(x0));
	}

	Future<EncryptedCalendarItem> undeleteCalendarItemById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'CalendarItemApi.encrypted.undeleteCalendarItemById',
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
			'CalendarItemApi.encrypted.undeleteCalendarItem',
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
			'CalendarItemApi.encrypted.modifyCalendarItem',
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
			'CalendarItemApi.encrypted.getCalendarItem',
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
			'CalendarItemApi.encrypted.getCalendarItems',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0)),
			}
		);
		if (res == null) throw AssertionError("received null result from platform method getCalendarItems");
		final parsedResJson = jsonDecode(res);
		return parsedResJson.map((x1) => EncryptedCalendarItem.fromJSON(x1) );
	}
}