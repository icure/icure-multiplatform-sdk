// auto-generated file
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/health_element.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class HealthElementBasicPlatformApi {
	String _sdkId;
	HealthElementBasicPlatformApi(this._sdkId);

	Future<List<String>> matchHealthElementsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.matchHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchHealthElementsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.matchHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.filterHealthElementsBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<EncryptedHealthElement>> filterHealthElementsBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.filterHealthElementsBySorted(
			_sdkId,
			filter,
		);
	}

	Future<DocIdentifier> deleteHealthElementById(String entityId, String? rev) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.deleteHealthElementById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteHealthElementsByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.deleteHealthElementsByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<void> purgeHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.purgeHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.deleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<List<DocIdentifier>> deleteHealthElements(List<HealthElement> healthElements) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.deleteHealthElements(
			_sdkId,
			healthElements,
		);
	}

	Future<void> purgeHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.purgeHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElementById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.undeleteHealthElementById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<EncryptedHealthElement> undeleteHealthElement(HealthElement healthElement) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.undeleteHealthElement(
			_sdkId,
			healthElement,
		);
	}

	Future<EncryptedHealthElement> modifyHealthElement(EncryptedHealthElement entity) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.modifyHealthElement(
			_sdkId,
			entity,
		);
	}

	Future<List<EncryptedHealthElement>> modifyHealthElements(List<EncryptedHealthElement> entities) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.modifyHealthElements(
			_sdkId,
			entities,
		);
	}

	Future<EncryptedHealthElement> getHealthElement(String entityId) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.getHealthElement(
			_sdkId,
			entityId,
		);
	}

	Future<List<EncryptedHealthElement>> getHealthElements(List<String> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.getHealthElements(
			_sdkId,
			entityIds,
		);
	}

	Future<EntitySubscription<EncryptedHealthElement>> subscribeToEvents(Set<SubscriptionEventType> events, BaseFilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.healthElementBasic.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}