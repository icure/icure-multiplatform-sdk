// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/message.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class MessageBasicApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	MessageBasicApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchMessagesBy(BaseFilterOptions<Message> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.matchMessagesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchMessagesBySorted(BaseSortableFilterOptions<Message> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.matchMessagesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBy(BaseFilterOptions<Message> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.filterMessagesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedMessage>> filterMessagesBySorted(BaseSortableFilterOptions<Message> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.filterMessagesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteMessageById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.deleteMessageById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteMessagesByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.deleteMessagesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeMessageById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.purgeMessageById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.deleteMessage(
			_sdkId,
			message,
		);
	}

	Future<List<DocIdentifier>> deleteMessages(List<Message> messages) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.deleteMessages(
			_sdkId,
			messages,
		);
	}

	Future<void> purgeMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.purgeMessage(
			_sdkId,
			message,
		);
	}

	Future<Message> undeleteMessage(Message message) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.undeleteMessage(
			_sdkId,
			message,
		);
	}

	Future<EncryptedMessage> modifyMessage(EncryptedMessage entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.modifyMessage(
			_sdkId,
			entity,
		);
	}

	Future<EncryptedMessage> undeleteMessageById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.undeleteMessageById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedMessage> getMessage(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.getMessage(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedMessage>> getMessages(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.getMessages(
			_sdkId,
			entityIds,
		);
	}

	Future<List<EncryptedMessage>> setMessagesReadStatus(List<String> entityIds, int? time, bool readStatus, String? userId) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.setMessagesReadStatus(
			_sdkId,
			entityIds,
			time,
			readStatus,
			userId,
		);
	}

	Future<EntitySubscription<EncryptedMessage>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions<Message> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.messageBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}