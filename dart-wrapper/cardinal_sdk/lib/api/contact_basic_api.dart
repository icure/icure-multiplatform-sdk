// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';


class ContactBasicApi {
	final String _sdkId;
	final Object _dartSdk;
	ContactBasicApi(
		this._sdkId,
		this._dartSdk
		);

	Future<List<String>> matchContactsBy(BaseFilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.matchContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchServicesBy(BaseFilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.matchServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchContactsBySorted(BaseSortableFilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.matchContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchServicesBySorted(BaseSortableFilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.matchServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBy(BaseFilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.filterContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBy(BaseFilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.filterServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBySorted(BaseSortableFilterOptions<Contact> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.filterContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBySorted(BaseSortableFilterOptions<Service> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.filterServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EntitySubscription<EncryptedService>> subscribeToServiceCreateOrUpdateEvents(BaseFilterOptions<Service> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
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

	Future<List<DocIdentifier>> deleteContactsByIds(List<StoredDocumentIdentifier> entityIds) async {
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

	Future<EncryptedContact> createContact(EncryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.createContact(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedContact>> createContacts(List<EncryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.createContacts(
			_sdkId,
			entities,
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

	Future<EncryptedContact?> getContact(String entityId) async {
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

	Future<EntitySubscription<EncryptedContact>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions<Contact> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.contactBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}