// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MessageBasicPlatformApi {
	String _sdkId;
	MessageBasicPlatformApi(this._sdkId);

	Future<List<String>> matchMessagesBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.matchMessagesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchMessagesBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.matchMessagesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.filterMessagesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.filterMessagesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteMessageById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.deleteMessageById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteMessagesByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.deleteMessagesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeMessageById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.purgeMessageById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.deleteMessage(
			_sdkId,
			message,
		);
	}

	Future<List<DocIdentifier>> deleteMessages(List<Message> messages) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.deleteMessages(
			_sdkId,
			messages,
		);
	}

	Future<void> purgeMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.purgeMessage(
			_sdkId,
			message,
		);
	}

	Future<Message> undeleteMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.undeleteMessage(
			_sdkId,
			message,
		);
	}

	Future<EncryptedMessage> modifyMessage(EncryptedMessage entity) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.modifyMessage(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedMessage> undeleteMessageById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.undeleteMessageById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedMessage> getMessage(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.getMessage(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedMessage>> getMessages(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.getMessages(
			_sdkId,
			entityIds,
		);
	}

	Future<List<EncryptedMessage>> setMessagesReadStatus(List<String> entityIds, int? time, bool readStatus, String? userId) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.setMessagesReadStatus(
			_sdkId,
			entityIds,
			time,
			readStatus,
			userId,
		);
	}

	Future<EntitySubscription<EncryptedMessage>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.messageBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}