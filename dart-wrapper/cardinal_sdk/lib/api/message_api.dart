// auto-generated file
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/message_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MessageApi {
	final String _sdkId;
	final TryAndRecoverMessageApi tryAndRecover;
	final EncryptedMessageApi encrypted;
	MessageApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverMessageApi(_sdkId),
		encrypted = EncryptedMessageApi(_sdkId);

	Future<DecryptedMessage> createMessage(DecryptedMessage entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.createMessage(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedMessage> createMessageInTopic(DecryptedMessage entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.createMessageInTopic(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedMessage> withEncryptionMetadata(DecryptedMessage? base, Patient? patient, User? user, { Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.getEncryptionKeysOf(
			_sdkId,
			message,
		);
	}

	Future<bool> hasWriteAccess(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.hasWriteAccess(
			_sdkId,
			message,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.decryptPatientIdOf(
			_sdkId,
			message,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Message entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedMessage> decrypt(EncryptedMessage message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.decrypt(
			_sdkId,
			message,
		);
	}

	Future<Message> tryDecrypt(EncryptedMessage message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryDecrypt(
			_sdkId,
			message,
		);
	}

	Future<List<String>> matchMessagesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.matchMessagesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchMessagesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.matchMessagesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteMessageById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.deleteMessageById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteMessagesByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.deleteMessagesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeMessageById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.purgeMessageById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.deleteMessage(
			_sdkId,
			message,
		);
	}

	Future<List<DocIdentifier>> deleteMessages(List<Message> messages) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.deleteMessages(
			_sdkId,
			messages,
		);
	}

	Future<void> purgeMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.purgeMessage(
			_sdkId,
			message,
		);
	}

	Future<DecryptedMessage> shareWith(String delegateId, DecryptedMessage message, MessageShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.shareWith(
			_sdkId,
			delegateId,
			message,
			options,
		);
	}

	Future<DecryptedMessage> shareWithMany(DecryptedMessage message, Map<String, MessageShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.shareWithMany(
			_sdkId,
			message,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedMessage>> filterMessagesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.filterMessagesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedMessage>> filterMessagesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.filterMessagesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Message> undeleteMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.undeleteMessage(
			_sdkId,
			message,
		);
	}

	Future<DecryptedMessage> modifyMessage(DecryptedMessage entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.modifyMessage(
			_sdkId,
			entity,
		);
	}

	Future<DecryptedMessage> undeleteMessageById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.undeleteMessageById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedMessage> getMessage(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.getMessage(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedMessage>> getMessages(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.getMessages(
			_sdkId,
			entityIds,
		);
	}

	Future<List<DecryptedMessage>> setMessagesReadStatus(List<String> entityIds, int? time, bool readStatus, String? userId) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.setMessagesReadStatus(
			_sdkId,
			entityIds,
			time,
			readStatus,
			userId,
		);
	}

	Future<EntitySubscription<EncryptedMessage>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class TryAndRecoverMessageApi {
	final String _sdkId;
	TryAndRecoverMessageApi(this._sdkId);

	Future<Message> shareWith(String delegateId, Message message, MessageShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			message,
			options,
		);
	}

	Future<Message> shareWithMany(Message message, Map<String, MessageShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.shareWithMany(
			_sdkId,
			message,
			delegates,
		);
	}

	Future<PaginatedListIterator<Message>> filterMessagesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.filterMessagesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Message>> filterMessagesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.filterMessagesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Message> undeleteMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.undeleteMessage(
			_sdkId,
			message,
		);
	}

	Future<Message> modifyMessage(Message entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.modifyMessage(
			_sdkId,
			entity,
		);
	}

	Future<Message> undeleteMessageById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.undeleteMessageById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Message> getMessage(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.getMessage(
			_sdkId,
			entityId,
		);
	}

	Future<List<Message>> getMessages(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.getMessages(
			_sdkId,
			entityIds,
		);
	}

	Future<List<Message>> setMessagesReadStatus(List<String> entityIds, int? time, bool readStatus, String? userId) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.tryAndRecover.setMessagesReadStatus(
			_sdkId,
			entityIds,
			time,
			readStatus,
			userId,
		);
	}
}

class EncryptedMessageApi {
	final String _sdkId;
	EncryptedMessageApi(this._sdkId);

	Future<EncryptedMessage> shareWith(String delegateId, EncryptedMessage message, MessageShareOptions? options) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.shareWith(
			_sdkId,
			delegateId,
			message,
			options,
		);
	}

	Future<EncryptedMessage> shareWithMany(EncryptedMessage message, Map<String, MessageShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.shareWithMany(
			_sdkId,
			message,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.filterMessagesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.filterMessagesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Message> undeleteMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.undeleteMessage(
			_sdkId,
			message,
		);
	}

	Future<EncryptedMessage> modifyMessage(EncryptedMessage entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.modifyMessage(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedMessage> undeleteMessageById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.undeleteMessageById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedMessage> getMessage(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.getMessage(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedMessage>> getMessages(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.getMessages(
			_sdkId,
			entityIds,
		);
	}

	Future<List<EncryptedMessage>> setMessagesReadStatus(List<String> entityIds, int? time, bool readStatus, String? userId) async {
		return await CardinalSdkPlatformInterface.instance.apis.message.encrypted.setMessagesReadStatus(
			_sdkId,
			entityIds,
			time,
			readStatus,
			userId,
		);
	}
}