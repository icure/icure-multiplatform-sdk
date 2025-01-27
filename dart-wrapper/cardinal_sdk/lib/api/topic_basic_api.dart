// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/topic.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/topic_role.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class TopicBasicApi {
	final String _sdkId;
	final Object _dartSdk;
	TopicBasicApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchTopicsBy(BaseFilterOptions<Topic> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.matchTopicsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchTopicsBySorted(BaseSortableFilterOptions<Topic> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.matchTopicsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedTopic>> filterTopicsBy(BaseFilterOptions<Topic> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.filterTopicsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedTopic>> filterTopicsBySorted(BaseSortableFilterOptions<Topic> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.filterTopicsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteTopicById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.deleteTopicById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteTopicsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.deleteTopicsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeTopicById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.purgeTopicById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteTopic(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.deleteTopic(
			_sdkId,
			topic,
		);
	}

	Future<List<DocIdentifier>> deleteTopics(List<Topic> topics) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.deleteTopics(
			_sdkId,
			topics,
		);
	}

	Future<void> purgeTopic(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.purgeTopic(
			_sdkId,
			topic,
		);
	}

	Future<Topic> undeleteTopic(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.undeleteTopic(
			_sdkId,
			topic,
		);
	}

	Future<EncryptedTopic> modifyTopic(EncryptedTopic entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.modifyTopic(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedTopic> undeleteTopicById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.undeleteTopicById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedTopic> getTopic(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.getTopic(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedTopic>> getTopics(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.getTopics(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedTopic> addParticipant(String entityId, String dataOwnerId, TopicRole topicRole) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.addParticipant(
			_sdkId,
			entityId,
			dataOwnerId,
			topicRole,
		);
	}

	Future<EncryptedTopic> removeParticipant(String entityId, String dataOwnerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.removeParticipant(
			_sdkId,
			entityId,
			dataOwnerId,
		);
	}

	Future<EntitySubscription<EncryptedTopic>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions<Topic> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.topicBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}