// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/healthcare_party.dart';
import 'package:cardinal_sdk/model/public_key.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/data_owner_registration_success.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/model/id_with_mandatory_rev.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class HealthcarePartyPlatformApi {
	String _sdkId;
	HealthcarePartyPlatformApi(this._sdkId);

	Future<HealthcareParty> getHealthcareParty(String healthcarePartyId) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.getHealthcareParty(
			_sdkId,
			healthcarePartyId,
		);
	}

	Future<HealthcareParty> createHealthcareParty(HealthcareParty p) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.createHealthcareParty(
			_sdkId,
			p,
		);
	}

	Future<HealthcareParty> modifyHealthcarePartyInGroup(String groupId, HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.modifyHealthcarePartyInGroup(
			_sdkId,
			groupId,
			healthcareParty,
		);
	}

	Future<HealthcareParty> createHealthcarePartyInGroup(String groupId, HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.createHealthcarePartyInGroup(
			_sdkId,
			groupId,
			healthcareParty,
		);
	}

	Future<HealthcareParty> getCurrentHealthcareParty() async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.getCurrentHealthcareParty(
			_sdkId,
		);
	}

	Future<List<HealthcareParty>> listHealthcarePartiesByName(String name) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.listHealthcarePartiesByName(
			_sdkId,
			name,
		);
	}

	Future<List<HealthcareParty>> getHealthcareParties(List<String> healthcarePartyIds) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.getHealthcareParties(
			_sdkId,
			healthcarePartyIds,
		);
	}

	Future<List<HealthcareParty>> listHealthcarePartiesByParentId(String parentId) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.listHealthcarePartiesByParentId(
			_sdkId,
			parentId,
		);
	}

	Future<PublicKey> getPublicKey(String healthcarePartyId) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.getPublicKey(
			_sdkId,
			healthcarePartyId,
		);
	}

	Future<HealthcareParty> modifyHealthcareParty(HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.modifyHealthcareParty(
			_sdkId,
			healthcareParty,
		);
	}

	Future<List<String>> matchHealthcarePartiesBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.matchHealthcarePartiesBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<HealthcareParty>> filterHealthPartiesBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.filterHealthPartiesBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchHealthcarePartiesBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.matchHealthcarePartiesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<HealthcareParty>> filterHealthPartiesBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.filterHealthPartiesBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<HealthcareParty>> getHealthcarePartiesInGroup(String groupId, List<String>? healthcarePartyIds) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.getHealthcarePartiesInGroup(
			_sdkId,
			groupId,
			healthcarePartyIds,
		);
	}

	Future<DataOwnerRegistrationSuccess> registerPatient(String groupId, String? parentHcPartyId, String? token, bool? useShortToken, HealthcareParty hcp) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.registerPatient(
			_sdkId,
			groupId,
			parentHcPartyId,
			token,
			useShortToken,
			hcp,
		);
	}

	Future<DocIdentifier> deleteHealthcarePartyById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.deleteHealthcarePartyById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesByIds(List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.deleteHealthcarePartiesByIds(
			_sdkId,
			entityIds,
		);
	}

	Future<DocIdentifier> deleteHealthcarePartyInGroupById(String groupId, String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.deleteHealthcarePartyInGroupById(
			_sdkId,
			groupId,
			entityId,
			rev,
		);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesInGroupByIds(String groupId, List<IdWithMandatoryRev> entityIds) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.deleteHealthcarePartiesInGroupByIds(
			_sdkId,
			groupId,
			entityIds,
		);
	}

	Future<void> purgeHealthcarePartyById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.purgeHealthcarePartyById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<HealthcareParty> undeleteHealthcarePartyById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.undeleteHealthcarePartyById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteHealthcareParty(HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.deleteHealthcareParty(
			_sdkId,
			healthcareParty,
		);
	}

	Future<List<DocIdentifier>> deleteHealthcareParties(List<HealthcareParty> healthcareParties) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.deleteHealthcareParties(
			_sdkId,
			healthcareParties,
		);
	}

	Future<void> purgeHealthcareParty(HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.purgeHealthcareParty(
			_sdkId,
			healthcareParty,
		);
	}

	Future<HealthcareParty> undeleteHealthcareParty(HealthcareParty healthcareParty) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.undeleteHealthcareParty(
			_sdkId,
			healthcareParty,
		);
	}

	Future<DocIdentifier> deleteHealthcarePartyInGroup(String groupId, HealthcareParty hcp) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.deleteHealthcarePartyInGroup(
			_sdkId,
			groupId,
			hcp,
		);
	}

	Future<List<DocIdentifier>> deleteHealthcarePartiesInGroup(String groupId, List<HealthcareParty> healthcareParties) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.deleteHealthcarePartiesInGroup(
			_sdkId,
			groupId,
			healthcareParties,
		);
	}

	Future<EntitySubscription<HealthcareParty>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.healthcareParty.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}