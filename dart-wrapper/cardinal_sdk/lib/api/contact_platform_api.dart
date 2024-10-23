// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/contact.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/model/embed/service.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/model/data/labelled_occurence.dart';
import 'package:cardinal_sdk/crypto/entities/contact_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';


class ContactPlatformApi {
	String _sdkId;
	TryAndRecoverContactPlatformApi tryAndRecover;
	EncryptedContactPlatformApi encrypted;
	ContactPlatformApi(
		this._sdkId
		) : tryAndRecover = TryAndRecoverContactPlatformApi(_sdkId),
		encrypted = EncryptedContactPlatformApi(_sdkId);

	Future<List<String>> matchContactsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.matchContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchServicesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.matchServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchContactsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.matchContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchServicesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.matchServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedContact> createContact(DecryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.contact.createContact(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedContact>> createContacts(List<DecryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.contact.createContacts(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedContact> withEncryptionMetadata(DecryptedContact? base, Patient patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.contact.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.getEncryptionKeysOf(
			_sdkId,
			contact,
		);
	}

	Future<bool> hasWriteAccess(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.hasWriteAccess(
			_sdkId,
			contact,
		);
	}

	Future<Set<String>> decryptPatientIdOf(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.decryptPatientIdOf(
			_sdkId,
			contact,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(Contact entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.contact.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedContact> decrypt(EncryptedContact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.decrypt(
			_sdkId,
			contact,
		);
	}

	Future<Contact> tryDecrypt(EncryptedContact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryDecrypt(
			_sdkId,
			contact,
		);
	}

	Future<DecryptedService> decryptService(EncryptedService service) async {
		return await CardinalSdkPlatformInterface.instance.contact.decryptService(
			_sdkId,
			service,
		);
	}

	Future<Service> tryDecryptService(EncryptedService service) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryDecryptService(
			_sdkId,
			service,
		);
	}

	Future<EntitySubscription<EncryptedService>> subscribeToServiceCreateOrUpdateEvents(FilterOptions filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.contact.subscribeToServiceCreateOrUpdateEvents(
			_sdkId,
			filter,
			subscriptionConfig,
		);
	}

	Future<DocIdentifier> deleteContactById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.contact.deleteContactById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteContactsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.contact.deleteContactsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.contact.purgeContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.deleteContact(
			_sdkId,
			contact,
		);
	}

	Future<List<DocIdentifier>> deleteContacts(List<Contact> contacts) async {
		return await CardinalSdkPlatformInterface.instance.contact.deleteContacts(
			_sdkId,
			contacts,
		);
	}

	Future<void> purgeContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.purgeContact(
			_sdkId,
			contact,
		);
	}

	Future<List<LabelledOccurence>> getServiceCodesOccurrences(String codeType, int minOccurrences) async {
		return await CardinalSdkPlatformInterface.instance.contact.getServiceCodesOccurrences(
			_sdkId,
			codeType,
			minOccurrences,
		);
	}

	Future<DecryptedContact> shareWith(String delegateId, DecryptedContact contact, { ContactShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.contact.shareWith(
			_sdkId,
			delegateId,
			contact,
			options,
		);
	}

	Future<DecryptedContact> shareWithMany(DecryptedContact contact, Map<String, ContactShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.contact.shareWithMany(
			_sdkId,
			contact,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedContact>> filterContactsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.filterContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedService>> filterServicesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.filterServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedContact>> filterContactsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.filterContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedService>> filterServicesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.filterServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedContact> undeleteContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.contact.undeleteContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedContact> undeleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.undeleteContact(
			_sdkId,
			contact,
		);
	}

	Future<DecryptedContact> modifyContact(DecryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.contact.modifyContact(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedContact>> modifyContacts(List<DecryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.contact.modifyContacts(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedContact> getContact(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.contact.getContact(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedContact>> getContacts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.contact.getContacts(
			_sdkId,
			entityIds,
		);
	}

	Future<DecryptedService> getService(String serviceId) async {
		return await CardinalSdkPlatformInterface.instance.contact.getService(
			_sdkId,
			serviceId,
		);
	}

	Future<List<DecryptedService>> getServices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.contact.getServices(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedContact>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.contact.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class TryAndRecoverContactPlatformApi {
	String _sdkId;
	TryAndRecoverContactPlatformApi(this._sdkId);

	Future<Contact> shareWith(String delegateId, Contact contact, { ContactShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			contact,
			options,
		);
	}

	Future<Contact> shareWithMany(Contact contact, Map<String, ContactShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.shareWithMany(
			_sdkId,
			contact,
			delegates,
		);
	}

	Future<PaginatedListIterator<Contact>> filterContactsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.filterContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Service>> filterServicesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.filterServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Contact>> filterContactsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.filterContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<Service>> filterServicesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.filterServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<Contact> undeleteContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.undeleteContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<Contact> undeleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.undeleteContact(
			_sdkId,
			contact,
		);
	}

	Future<Contact> modifyContact(Contact entity) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.modifyContact(
			_sdkId,
			entity,
		);
	}

	Future<List<Contact>> modifyContacts(List<Contact> entities) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.modifyContacts(
			_sdkId,
			entities,
		);
	}

	Future<Contact> getContact(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.getContact(
			_sdkId,
			entityId,
		);
	}

	Future<List<Contact>> getContacts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.getContacts(
			_sdkId,
			entityIds,
		);
	}

	Future<Service> getService(String serviceId) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.getService(
			_sdkId,
			serviceId,
		);
	}

	Future<List<Service>> getServices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.contact.tryAndRecover.getServices(
			_sdkId,
			entityIds,
		);
	}
}

class EncryptedContactPlatformApi {
	String _sdkId;
	EncryptedContactPlatformApi(this._sdkId);

	Future<EncryptedContact> shareWith(String delegateId, EncryptedContact contact, { ContactShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.shareWith(
			_sdkId,
			delegateId,
			contact,
			options,
		);
	}

	Future<EncryptedContact> shareWithMany(EncryptedContact contact, Map<String, ContactShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.shareWithMany(
			_sdkId,
			contact,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.filterContactsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBy(FilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.filterServicesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedContact>> filterContactsBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.filterContactsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedService>> filterServicesBySorted(SortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.filterServicesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedContact> undeleteContactById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.undeleteContactById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedContact> undeleteContact(Contact contact) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.undeleteContact(
			_sdkId,
			contact,
		);
	}

	Future<EncryptedContact> modifyContact(EncryptedContact entity) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.modifyContact(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedContact>> modifyContacts(List<EncryptedContact> entities) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.modifyContacts(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedContact> getContact(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.getContact(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedContact>> getContacts(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.getContacts(
			_sdkId,
			entityIds,
		);
	}

	Future<EncryptedService> getService(String serviceId) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.getService(
			_sdkId,
			serviceId,
		);
	}

	Future<List<EncryptedService>> getServices(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.contact.encrypted.getServices(
			_sdkId,
			entityIds,
		);
	}
}