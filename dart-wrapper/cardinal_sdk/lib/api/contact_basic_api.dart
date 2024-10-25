// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';


class ContactBasicApi {
	final String _sdkId;
	ContactBasicApi(this._sdkId);

	Future<List<String>> matchContactsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.matchContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchServicesBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.matchServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchContactsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.matchContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchServicesBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.matchServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.filterContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.filterServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.filterContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.filterServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EntitySubscription<EncryptedService>> subscribeToServiceCreateOrUpdateEvents(BaseFilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.subscribeToServiceCreateOrUpdateEvents(
			_sdkId,
			filter,
			subscriptionConfig,
		);
	}

	Future<DocIdentifier> deleteContactById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.deleteContactById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteContactsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.deleteContactsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.purgeContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.deleteContact(
			_sdkId,
			contact,
		);
	}

	Future<List<DocIdentifier>> deleteContacts(List<Contact> contacts) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.deleteContacts(
			_sdkId,
			contacts,
		);
	}

	Future<void> purgeContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.purgeContact(
			_sdkId,
			contact,
		);
	}

	Future<List<LabelledOccurence>> getServiceCodesOccurrences(String codeType, int minOccurrences) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.getServiceCodesOccurrences(
			_sdkId,
			codeType,
			minOccurrences,
		);
	}

	Future<EncryptedContact> undeleteContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.undeleteContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedContact> undeleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.undeleteContact(
			_sdkId,
			contact,
		);
	}

	Future<EncryptedContact> modifyContact(EncryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.modifyContact(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedContact>> modifyContacts(List<EncryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.modifyContacts(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedContact> getContact(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.getContact(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedContact>> getContacts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.getContacts(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedService> getService(String serviceId) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.getService(
			_sdkId,
			serviceId,
		);
	}

	Future<List<EncryptedService>> getServices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.getServices(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedContact>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}