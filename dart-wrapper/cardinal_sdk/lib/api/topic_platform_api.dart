// auto-generated file
import 'package:cardinal_sdk/model/topic.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/topic_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/topic_role.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class TopicPlatformApi {
	String _sdkId;
	TryAndRecoverTopicPlatformApi tryAndRecover;
	EncryptedTopicPlatformApi encrypted;
	TopicPlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverTopicPlatformApi(_sdkId),
		encrypted = EncryptedTopicPlatformApi(_sdkId);

	Future<DecryptedTopic> createTopic(DecryptedTopic entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.createTopic(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedTopic> withEncryptionMetadata(DecryptedTopic? base, Patient? patient, User? user, { Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.getEncryptionKeysOf(
			_sdkId,
			topic,
		);
	}

	Future<bool> hasWriteAccess(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.hasWriteAccess(
			_sdkId,
			topic,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.decryptPatientIdOf(
			_sdkId,
			topic,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Topic entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedTopic> decrypt(EncryptedTopic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.decrypt(
			_sdkId,
			topic,
		);
	}

	Future<Topic> tryDecrypt(EncryptedTopic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryDecrypt(
			_sdkId,
			topic,
		);
	}

	Future<List<String>> matchTopicsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.matchTopicsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchTopicsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.matchTopicsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteTopicById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.deleteTopicById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteTopicsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.deleteTopicsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeTopicById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.purgeTopicById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteTopic(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.deleteTopic(
			_sdkId,
			topic,
		);
	}

	Future<List<DocIdentifier>> deleteTopics(List<Topic> topics) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.deleteTopics(
			_sdkId,
			topics,
		);
	}

	Future<void> purgeTopic(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.purgeTopic(
			_sdkId,
			topic,
		);
	}

	Future<DecryptedTopic> shareWith(String delegateId, DecryptedTopic topic, TopicShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.shareWith(
			_sdkId,
			delegateId,
			topic,
			options,
		);
	}

	Future<DecryptedTopic> shareWithMany(DecryptedTopic topic, Map<String, TopicShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.shareWithMany(
			_sdkId,
			topic,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedTopic>> filterTopicsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.filterTopicsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedTopic>> filterTopicsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.filterTopicsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Topic> undeleteTopic(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.undeleteTopic(
			_sdkId,
			topic,
		);
	}

	Future<DecryptedTopic> modifyTopic(DecryptedTopic entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.modifyTopic(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedTopic> undeleteTopicById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.undeleteTopicById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedTopic> getTopic(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.getTopic(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedTopic>> getTopics(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.getTopics(
			_sdkId,
			entityIds,
		);
	}

	Future<DecryptedTopic> addParticipant(String entityId, String dataOwnerId, TopicRole topicRole) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.addParticipant(
			_sdkId,
			entityId,
			dataOwnerId,
			topicRole,
		);
	}

	Future<DecryptedTopic> removeParticipant(String entityId, String dataOwnerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.removeParticipant(
			_sdkId,
			entityId,
			dataOwnerId,
		);
	}

	Future<EntitySubscription<EncryptedTopic>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class TryAndRecoverTopicPlatformApi {
	String _sdkId;
	TryAndRecoverTopicPlatformApi(this._sdkId);

	Future<Topic> shareWith(String delegateId, Topic topic, TopicShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			topic,
			options,
		);
	}

	Future<Topic> shareWithMany(Topic topic, Map<String, TopicShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.shareWithMany(
			_sdkId,
			topic,
			delegates,
		);
	}

	Future<PaginatedListIterator<Topic>> filterTopicsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.filterTopicsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Topic>> filterTopicsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.filterTopicsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Topic> undeleteTopic(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.undeleteTopic(
			_sdkId,
			topic,
		);
	}

	Future<Topic> modifyTopic(Topic entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.modifyTopic(
			_sdkId,
			entity,
		);
	}

	Future<Topic> undeleteTopicById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.undeleteTopicById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Topic> getTopic(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.getTopic(
			_sdkId,
			entityId,
		);
	}

	Future<List<Topic>> getTopics(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.getTopics(
			_sdkId,
			entityIds,
		);
	}

	Future<Topic> addParticipant(String entityId, String dataOwnerId, TopicRole topicRole) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.addParticipant(
			_sdkId,
			entityId,
			dataOwnerId,
			topicRole,
		);
	}

	Future<Topic> removeParticipant(String entityId, String dataOwnerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.tryAndRecover.removeParticipant(
			_sdkId,
			entityId,
			dataOwnerId,
		);
	}
}

class EncryptedTopicPlatformApi {
	String _sdkId;
	EncryptedTopicPlatformApi(this._sdkId);

	Future<EncryptedTopic> shareWith(String delegateId, EncryptedTopic topic, TopicShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.shareWith(
			_sdkId,
			delegateId,
			topic,
			options,
		);
	}

	Future<EncryptedTopic> shareWithMany(EncryptedTopic topic, Map<String, TopicShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.shareWithMany(
			_sdkId,
			topic,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedTopic>> filterTopicsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.filterTopicsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedTopic>> filterTopicsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.filterTopicsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Topic> undeleteTopic(Topic topic) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.undeleteTopic(
			_sdkId,
			topic,
		);
	}

	Future<EncryptedTopic> modifyTopic(EncryptedTopic entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.modifyTopic(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedTopic> undeleteTopicById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.undeleteTopicById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedTopic> getTopic(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.getTopic(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedTopic>> getTopics(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.getTopics(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedTopic> addParticipant(String entityId, String dataOwnerId, TopicRole topicRole) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.addParticipant(
			_sdkId,
			entityId,
			dataOwnerId,
			topicRole,
		);
	}

	Future<EncryptedTopic> removeParticipant(String entityId, String dataOwnerId) async {
		return await CardinalSdkPlatformInterface.instance.apis.topic.encrypted.removeParticipant(
			_sdkId,
			entityId,
			dataOwnerId,
		);
	}
}