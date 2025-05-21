// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/stored_document_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';
import 'package:cardinal_sdk/model/group_scoped.dart';


class HealthElementBasicApi {
	final String _sdkId;
	final Object _dartSdk;
	final HealthElementBasicInGroupApi inGroup;
	HealthElementBasicApi(
		this._sdkId,
		this._dartSdk
		) : inGroup = HealthElementBasicInGroupApi(_sdkId, _dartSdk);

	Future<List<String>> matchHealthElementsBy(BaseFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.matchHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchHealthElementsBySorted(BaseSortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.matchHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBy(BaseFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.filterHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBySorted(BaseSortableFilterOptions<HealthElement> filter) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.filterHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<StoredDocumentIdentifier> deleteHealthElementById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.deleteHealthElementById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteHealthElementsByIds(List<StoredDocumentIdentifier> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.deleteHealthElementsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.purgeHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<StoredDocumentIdentifier> deleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.deleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<List<StoredDocumentIdentifier>> deleteHealthElements(List<HealthElement> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.deleteHealthElements(
			_sdkId,
			healthElements,
		);
	}

	Future<void> purgeHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.purgeHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<EncryptedHealthElement> createHealthElement(EncryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedHealthElement>> createHealthElements(List<EncryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.createHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.undeleteHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.undeleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<EncryptedHealthElement> modifyHealthElement(EncryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedHealthElement>> modifyHealthElements(List<EncryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.modifyHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedHealthElement?> getHealthElement(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.getHealthElement(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedHealthElement>> getHealthElements(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.getHealthElements(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedHealthElement>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions<HealthElement> filter, { EntitySubscriptionConfiguration? subscriptionConfig }) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}

class HealthElementBasicInGroupApi {
	final String _sdkId;
	final Object _dartSdk;
	HealthElementBasicInGroupApi(
		this._sdkId,
		this._dartSdk
		);

	Future<GroupScoped<EncryptedHealthElement>> createHealthElement(GroupScoped<EncryptedHealthElement> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.inGroup.createHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedHealthElement>> modifyHealthElement(GroupScoped<EncryptedHealthElement> entity) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.inGroup.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<GroupScoped<EncryptedHealthElement>?> getHealthElement(String groupId, String entityId) async {
		return await CardinalSdkPlatformInterface.instance.apis.healthElementBasic.inGroup.getHealthElement(
			_sdkId,
			groupId,
			entityId,
		);
	}
}