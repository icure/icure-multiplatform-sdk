// auto-generated file
import 'package:cardinal_sdk/cardinal_sdk.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/patient.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/embed/access_level.dart';
import 'package:cardinal_sdk/crypto/entities/secret_id_use_option.dart';
import 'package:cardinal_sdk/model/specializations/hex_string.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/crypto/entities/health_element_share_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class HealthElementApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	final TryAndRecoverHealthElementApi tryAndRecover;
	final EncryptedHealthElementApi encrypted;
	HealthElementApi(
		this._sdkId,
		this._dartSdk
		) : tryAndRecover = TryAndRecoverHealthElementApi(_sdkId),
		encrypted = EncryptedHealthElementApi(_sdkId);

	Future<DecryptedHealthElement> createHealthElement(DecryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedHealthElement>> createHealthElements(List<DecryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.createHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedHealthElement> withEncryptionMetadata(DecryptedHealthElement? base, Patient patient, { User? user, Map<String, AccessLevel> delegates = const {}, SecretIdUseOption secretId = SecretIdUseOption.UseAnySharedWithParent }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.withEncryptionMetadata(
			_sdkId,
			base,
			patient,
			user,
			delegates,
			secretId,
		);
	}

	Future<Set<HexString>> getEncryptionKeysOf(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.getEncryptionKeysOf(
			_sdkId,
			healthElement,
		);
	}

	Future<bool> hasWriteAccess(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.hasWriteAccess(
			_sdkId,
			healthElement,
		);
	}

	Future<Set<String>> decryptPatientIdOf(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.decryptPatientIdOf(
			_sdkId,
			healthElement,
		);
	}

	Future<void> createDelegationDeAnonymizationMetadata(HealthElement entity, Set<String> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.createDelegationDeAnonymizationMetadata(
			_sdkId,
			entity,
			delegates,
		);
	}

	Future<DecryptedHealthElement> decrypt(EncryptedHealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.decrypt(
			_sdkId,
			healthElement,
		);
	}

	Future<HealthElement> tryDecrypt(EncryptedHealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryDecrypt(
			_sdkId,
			healthElement,
		);
	}

	Future<List<String>> matchHealthElementsBy(FilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.matchHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchHealthElementsBySorted(SortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.matchHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteHealthElementById(String entityId, String? rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.deleteHealthElementById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteHealthElementsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.deleteHealthElementsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.purgeHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.deleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<List<DocIdentifier>> deleteHealthElements(List<HealthElement> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.deleteHealthElements(
			_sdkId,
			healthElements,
		);
	}

	Future<void> purgeHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.purgeHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<DecryptedHealthElement> shareWith(String delegateId, DecryptedHealthElement healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.shareWith(
			_sdkId,
			delegateId,
			healthElement,
			options,
		);
	}

	Future<DecryptedHealthElement> shareWithMany(DecryptedHealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<PaginatedListIterator<DecryptedHealthElement>> filterHealthElementsBy(FilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.filterHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<DecryptedHealthElement>> filterHealthElementsBySorted(SortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.filterHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DecryptedHealthElement> undeleteHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.undeleteHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DecryptedHealthElement> undeleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.undeleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<DecryptedHealthElement> modifyHealthElement(DecryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<DecryptedHealthElement>> modifyHealthElements(List<DecryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.modifyHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<DecryptedHealthElement> getHealthElement(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.getHealthElement(
			_sdkId,
			entityId,
		);
	}

	Future<List<DecryptedHealthElement>> getHealthElements(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.getHealthElements(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedHealthElement>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions<HealthElement> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class TryAndRecoverHealthElementApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	TryAndRecoverHealthElementApi(
		this._sdkId,
		this._dartSdk
		);

	Future<HealthElement> shareWith(String delegateId, HealthElement healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.shareWith(
			_sdkId,
			delegateId,
			healthElement,
			options,
		);
	}

	Future<HealthElement> shareWithMany(HealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<PaginatedListIterator<HealthElement>> filterHealthElementsBy(FilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.filterHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<HealthElement>> filterHealthElementsBySorted(SortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.filterHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<HealthElement> undeleteHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.undeleteHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<HealthElement> undeleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.undeleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<HealthElement> modifyHealthElement(HealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<HealthElement>> modifyHealthElements(List<HealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.modifyHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<HealthElement> getHealthElement(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.getHealthElement(
			_sdkId,
			entityId,
		);
	}

	Future<List<HealthElement>> getHealthElements(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.tryAndRecover.getHealthElements(
			_sdkId,
			entityIds,
		);
	}
}

class EncryptedHealthElementApi {
	final String _sdkId;
	final CardinalSdk _dartSdk;
	EncryptedHealthElementApi(
		this._sdkId,
		this._dartSdk
		);

	Future<EncryptedHealthElement> shareWith(String delegateId, EncryptedHealthElement healthElement, { HealthElementShareOptions? options }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.shareWith(
			_sdkId,
			delegateId,
			healthElement,
			options,
		);
	}

	Future<EncryptedHealthElement> shareWithMany(EncryptedHealthElement healthElement, Map<String, HealthElementShareOptions> delegates) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.shareWithMany(
			_sdkId,
			healthElement,
			delegates,
		);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBy(FilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.filterHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBySorted(SortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.filterHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.undeleteHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.undeleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<EncryptedHealthElement> modifyHealthElement(EncryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedHealthElement>> modifyHealthElements(List<EncryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.modifyHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedHealthElement> getHealthElement(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.getHealthElement(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedHealthElement>> getHealthElements(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElement.encrypted.getHealthElements(
			_sdkId,
			entityIds,
		);
	}
}