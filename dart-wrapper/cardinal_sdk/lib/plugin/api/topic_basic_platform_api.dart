// auto-generated file
import 'package:flutter/services.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/topic.dart';
import 'dart:convert';
import 'package:cardinal_sdk/utils/internal/platform_exception_convertion.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/model/topic_role.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class TopicBasicPlatformApi {
	MethodChannel _methodChannel;
	TopicBasicPlatformApi(this._methodChannel);

	Future<List<String>> matchTopicsBy(String sdkId, BaseFilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.matchTopicsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchTopicsBy");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<List<String>> matchTopicsBySorted(String sdkId, BaseSortableFilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.matchTopicsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method matchTopicsBySorted");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => (x1 as String) ).toList();
	}

	Future<PaginatedListIterator<EncryptedTopic>> filterTopicsBy(String sdkId, BaseFilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.filterTopicsBy',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTopicsBy");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedTopic.fromJSON(x0));
	}

	Future<PaginatedListIterator<EncryptedTopic>> filterTopicsBySorted(String sdkId, BaseSortableFilterOptions<Topic> filter) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.filterTopicsBySorted',
			{
				"sdkId": sdkId,
				"filter": jsonEncode(BaseSortableFilterOptions.encode(filter)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method filterTopicsBySorted");
		final parsedResJson = jsonDecode(res);
		return PaginatedListIterator(parsedResJson, (x0) => EncryptedTopic.fromJSON(x0));
	}

	Future<DocIdentifier> deleteTopicById(String sdkId, String entityId, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.deleteTopicById',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTopicById");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteTopicsByIds(String sdkId, List<StoredDocumentIdentifier> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.deleteTopicsByIds',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => StoredDocumentIdentifier.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTopicsByIds");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeTopicById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.purgeTopicById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
	}

	Future<DocIdentifier> deleteTopic(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.deleteTopic',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTopic");
		final parsedResJson = jsonDecode(res);
		return DocIdentifier.fromJSON(parsedResJson);
	}

	Future<List<DocIdentifier>> deleteTopics(String sdkId, List<Topic> topics) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.deleteTopics',
			{
				"sdkId": sdkId,
				"topics": jsonEncode(topics.map((x0) => Topic.encode(x0)).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method deleteTopics");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => DocIdentifier.fromJSON(x1) ).toList();
	}

	Future<void> purgeTopic(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.purgeTopic',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
	}

	Future<EncryptedTopic> createTopic(String sdkId, EncryptedTopic entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.createTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedTopic.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method createTopic");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<Topic> undeleteTopic(String sdkId, Topic topic) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.undeleteTopic',
			{
				"sdkId": sdkId,
				"topic": jsonEncode(Topic.encode(topic)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTopic");
		final parsedResJson = jsonDecode(res);
		return Topic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic> modifyTopic(String sdkId, EncryptedTopic entity) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.modifyTopic',
			{
				"sdkId": sdkId,
				"entity": jsonEncode(EncryptedTopic.encode(entity)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method modifyTopic");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic> undeleteTopicById(String sdkId, String id, String rev) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.undeleteTopicById',
			{
				"sdkId": sdkId,
				"id": jsonEncode(id),
				"rev": jsonEncode(rev),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method undeleteTopicById");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic?> getTopic(String sdkId, String entityId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.getTopic',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTopic");
		final parsedResJson = jsonDecode(res);
		return parsedResJson == null ? null : EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<List<EncryptedTopic>> getTopics(String sdkId, List<String> entityIds) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.getTopics',
			{
				"sdkId": sdkId,
				"entityIds": jsonEncode(entityIds.map((x0) => x0).toList()),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method getTopics");
		final parsedResJson = jsonDecode(res);
		return (parsedResJson as List<dynamic>).map((x1) => EncryptedTopic.fromJSON(x1) ).toList();
	}

	Future<EncryptedTopic> addParticipant(String sdkId, String entityId, String dataOwnerId, TopicRole topicRole) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.addParticipant',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"dataOwnerId": jsonEncode(dataOwnerId),
				"topicRole": jsonEncode(TopicRole.encode(topicRole)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method addParticipant");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<EncryptedTopic> removeParticipant(String sdkId, String entityId, String dataOwnerId) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.removeParticipant',
			{
				"sdkId": sdkId,
				"entityId": jsonEncode(entityId),
				"dataOwnerId": jsonEncode(dataOwnerId),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method removeParticipant");
		final parsedResJson = jsonDecode(res);
		return EncryptedTopic.fromJSON(parsedResJson);
	}

	Future<EntitySubscription<EncryptedTopic>> subscribeToEvents(String sdkId, Set<SubscriptionEventType> events, BaseFilterOptions<Topic> filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		final res = await _methodChannel.invokeMethod<String>(
			'TopicBasicApi.subscribeToEvents',
			{
				"sdkId": sdkId,
				"events": jsonEncode(events.map((x0) => SubscriptionEventType.encode(x0)).toList()),
				"filter": jsonEncode(BaseFilterOptions.encode(filter)),
				"subscriptionConfig": jsonEncode(subscriptionConfig == null ? null : EntitySubscriptionConfiguration.encode(subscriptionConfig!)),
			}
		).catchError(convertPlatformException);
		if (res == null) throw AssertionError("received null result from platform method subscribeToEvents");
		final parsedResJson = jsonDecode(res);
		return EntitySubscription(parsedResJson, (x0) => EncryptedTopic.fromJSON(x0));
	}
}