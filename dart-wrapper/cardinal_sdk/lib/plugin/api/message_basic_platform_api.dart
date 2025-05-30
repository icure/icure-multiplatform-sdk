// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MessageBasicPlatformApi {
	MethodChannel _methodChannel;
	MessageBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchMessagesBy(String sdkId, BaseFilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.matchMessagesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchMessagesBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchMessagesBySorted(String sdkId, BaseSortableFilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.matchMessagesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchMessagesBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBy(String sdkId, BaseFilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.filterMessagesBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMessagesBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedMessage.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBySorted(String sdkId, BaseSortableFilterOptions<Message> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.filterMessagesBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterMessagesBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedMessage.fromJSON(x0));
	}

	Future<DocIdentifier> deleteMessageById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.deleteMessageById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMessageById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMessagesByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.deleteMessagesByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMessagesByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeMessageById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.purgeMessageById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteMessage(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.deleteMessage',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMessage");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteMessages(String sdkId, List<Message> messages) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.deleteMessages',
			{
				"sdkId": sdkId,
				"messages": jsonEncode(messages.map((x0) => Message.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteMessages");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeMessage(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.purgeMessage',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
	}

	Future<EncryptedMessage> createMessage(String sdkId, EncryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.createMessage',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMessage");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage> createMessageInTopic(String sdkId, EncryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.createMessageInTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createMessageInTopic");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<Message> undeleteMessage(String sdkId, Message message) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.undeleteMessage',
			{
				"sdkId": sdkId,
				"message": jsonEncode(Message.encode(message)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMessage");
		final parsedResJson = jsonDecode(res);
		return Message.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage> modifyMessage(String sdkId, EncryptedMessage entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.modifyMessage',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedMessage.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyMessage");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage> undeleteMessageById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.undeleteMessageById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteMessageById");
		final parsedResJson = jsonDecode(res);
		return EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<EncryptedMessage?> getMessage(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.getMessage',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMessage");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedMessage.fromJSON(parsedResJson);
	}

	Future<List<EncryptedMessage>> getMessages(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.getMessages',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getMessages");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedMessage.fromJSON(x1) ).toList();
	}

	Future<List<EncryptedMessage>> setMessagesReadStatus(String sdkId, List<String> entityIds, int? time, bool readStatus, String? userId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.setMessagesReadStatus',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
				"time": jsonEncode(time),
				"readStatus": jsonEncode(readStatus),
				"userId": jsonEncode(userId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method setMessagesReadStatus");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedMessage.fromJSON(x1) ).toList();
	}

	Future<EntitySubscription<EncryptedMessage>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, BaseFilterOptions<Message> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'MessageBasicApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedMessage.fromJSON(x0));
	}
}