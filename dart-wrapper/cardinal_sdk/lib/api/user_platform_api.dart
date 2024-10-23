// auto-generated file
import 'package:cardinal_sdk/plugin/cardinal_sdk_platform_interface.dart';
import 'package:cardinal_sdk/model/user.dart';
import 'package:cardinal_sdk/model/property_stub.dart';
import 'package:cardinal_sdk/filters/filter_options.dart';
import 'package:cardinal_sdk/utils/pagination/paginated_list_iterator.dart';
import 'package:cardinal_sdk/model/user_group.dart';
import 'package:cardinal_sdk/model/list_of_ids.dart';
import 'package:cardinal_sdk/model/security/token_with_group.dart';
import 'package:cardinal_sdk/model/security/enable2fa_request.dart';
import 'package:cardinal_sdk/model/couchdb/doc_identifier.dart';
import 'package:cardinal_sdk/subscription/subscription_event_type.dart';
import 'package:cardinal_sdk/subscription/entity_subscription_configuration.dart';
import 'package:cardinal_sdk/subscription/entity_subscription.dart';


class UserPlatformApi {
	String _sdkId;
	UserPlatformApi(this._sdkId);

	Future<User> getCurrentUser() async {
		return await CardinalSdkPlatformInterface.instance.user.getCurrentUser(
			_sdkId,
		);
	}

	Future<User> createUser(User user) async {
		return await CardinalSdkPlatformInterface.instance.user.createUser(
			_sdkId,
			user,
		);
	}

	Future<User> getUser(String userId) async {
		return await CardinalSdkPlatformInterface.instance.user.getUser(
			_sdkId,
			userId,
		);
	}

	Future<List<User>> getUsers(List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.user.getUsers(
			_sdkId,
			userIds,
		);
	}

	Future<User> getUserByEmail(String email) async {
		return await CardinalSdkPlatformInterface.instance.user.getUserByEmail(
			_sdkId,
			email,
		);
	}

	Future<User> getUserByPhoneNumber(String phoneNumber) async {
		return await CardinalSdkPlatformInterface.instance.user.getUserByPhoneNumber(
			_sdkId,
			phoneNumber,
		);
	}

	Future<List<String>> findByHcpartyId(String id) async {
		return await CardinalSdkPlatformInterface.instance.user.findByHcpartyId(
			_sdkId,
			id,
		);
	}

	Future<List<String>> findByPatientId(String id) async {
		return await CardinalSdkPlatformInterface.instance.user.findByPatientId(
			_sdkId,
			id,
		);
	}

	Future<User> modifyUser(User user) async {
		return await CardinalSdkPlatformInterface.instance.user.modifyUser(
			_sdkId,
			user,
		);
	}

	Future<User> assignHealthcareParty(String healthcarePartyId) async {
		return await CardinalSdkPlatformInterface.instance.user.assignHealthcareParty(
			_sdkId,
			healthcarePartyId,
		);
	}

	Future<User> modifyProperties(String userId, List<EncryptedPropertyStub>? properties) async {
		return await CardinalSdkPlatformInterface.instance.user.modifyProperties(
			_sdkId,
			userId,
			properties,
		);
	}

	Future<String> getToken(String userId, String key, int? tokenValidity, String? token) async {
		return await CardinalSdkPlatformInterface.instance.user.getToken(
			_sdkId,
			userId,
			key,
			tokenValidity,
			token,
		);
	}

	Future<PaginatedListIterator<User>> filterUsersBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.user.filterUsersBy(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchUsersBy(BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.user.matchUsersBy(
			_sdkId,
			filter,
		);
	}

	Future<PaginatedListIterator<User>> filterUsersBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.user.filterUsersBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<String>> matchUsersBySorted(BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.user.matchUsersBySorted(
			_sdkId,
			filter,
		);
	}

	Future<List<UserGroup>> getMatchingUsers() async {
		return await CardinalSdkPlatformInterface.instance.user.getMatchingUsers(
			_sdkId,
		);
	}

	Future<List<User>> getUsersInGroup(String groupId, List<String> userIds) async {
		return await CardinalSdkPlatformInterface.instance.user.getUsersInGroup(
			_sdkId,
			groupId,
			userIds,
		);
	}

	Future<User> createUserInGroup(String groupId, User user) async {
		return await CardinalSdkPlatformInterface.instance.user.createUserInGroup(
			_sdkId,
			groupId,
			user,
		);
	}

	Future<User> modifyUserInGroup(String groupId, User user) async {
		return await CardinalSdkPlatformInterface.instance.user.modifyUserInGroup(
			_sdkId,
			groupId,
			user,
		);
	}

	Future<User> setUserRoles(String userId, ListOfIds rolesId) async {
		return await CardinalSdkPlatformInterface.instance.user.setUserRoles(
			_sdkId,
			userId,
			rolesId,
		);
	}

	Future<User> setUserRolesInGroup(String userId, String groupId, ListOfIds rolesId) async {
		return await CardinalSdkPlatformInterface.instance.user.setUserRolesInGroup(
			_sdkId,
			userId,
			groupId,
			rolesId,
		);
	}

	Future<User> resetUserRoles(String userId) async {
		return await CardinalSdkPlatformInterface.instance.user.resetUserRoles(
			_sdkId,
			userId,
		);
	}

	Future<User> resetUserRolesInGroup(String userId, String groupId) async {
		return await CardinalSdkPlatformInterface.instance.user.resetUserRolesInGroup(
			_sdkId,
			userId,
			groupId,
		);
	}

	Future<String> getTokenInGroup(String groupId, String userId, String key, String? token, int? tokenValidity) async {
		return await CardinalSdkPlatformInterface.instance.user.getTokenInGroup(
			_sdkId,
			groupId,
			userId,
			key,
			token,
			tokenValidity,
		);
	}

	Future<List<TokenWithGroup>> getTokenInAllGroups(String userIdentifier, String key, String? token, int? tokenValidity) async {
		return await CardinalSdkPlatformInterface.instance.user.getTokenInAllGroups(
			_sdkId,
			userIdentifier,
			key,
			token,
			tokenValidity,
		);
	}

	Future<PaginatedListIterator<User>> filterUsersInGroupBy(String groupId, BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.user.filterUsersInGroupBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<List<String>> matchUsersInGroupBy(String groupId, BaseFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.user.matchUsersInGroupBy(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<PaginatedListIterator<User>> filterUsersInGroupBySorted(String groupId, BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.user.filterUsersInGroupBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<List<String>> matchUsersInGroupBySorted(String groupId, BaseSortableFilterOptions filter) async {
		return await CardinalSdkPlatformInterface.instance.user.matchUsersInGroupBySorted(
			_sdkId,
			groupId,
			filter,
		);
	}

	Future<void> enable2faForUserWithGroup(String userId, String groupId, Enable2faRequest request) async {
		return await CardinalSdkPlatformInterface.instance.user.enable2faForUserWithGroup(
			_sdkId,
			userId,
			groupId,
			request,
		);
	}

	Future<void> enable2faForUser(String userId, Enable2faRequest request) async {
		return await CardinalSdkPlatformInterface.instance.user.enable2faForUser(
			_sdkId,
			userId,
			request,
		);
	}

	Future<void> disable2faForUserWithGroup(String userId, String groupId) async {
		return await CardinalSdkPlatformInterface.instance.user.disable2faForUserWithGroup(
			_sdkId,
			userId,
			groupId,
		);
	}

	Future<void> disable2faForUser(String userId) async {
		return await CardinalSdkPlatformInterface.instance.user.disable2faForUser(
			_sdkId,
			userId,
		);
	}

	Future<User> createAdminUser(User user) async {
		return await CardinalSdkPlatformInterface.instance.user.createAdminUser(
			_sdkId,
			user,
		);
	}

	Future<User> createAdminUserInGroup(String groupId, User user) async {
		return await CardinalSdkPlatformInterface.instance.user.createAdminUserInGroup(
			_sdkId,
			groupId,
			user,
		);
	}

	Future<DocIdentifier> deleteUserById(String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.user.deleteUserById(
			_sdkId,
			entityId,
			rev,
		);
	}

	Future<DocIdentifier> deleteUserInGroupById(String groupId, String entityId, String rev) async {
		return await CardinalSdkPlatformInterface.instance.user.deleteUserInGroupById(
			_sdkId,
			groupId,
			entityId,
			rev,
		);
	}

	Future<void> purgeUserById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.user.purgeUserById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<User> undeleteUserById(String id, String rev) async {
		return await CardinalSdkPlatformInterface.instance.user.undeleteUserById(
			_sdkId,
			id,
			rev,
		);
	}

	Future<DocIdentifier> deleteUser(User user) async {
		return await CardinalSdkPlatformInterface.instance.user.deleteUser(
			_sdkId,
			user,
		);
	}

	Future<DocIdentifier> deleteUserInGroup(String groupId, User user) async {
		return await CardinalSdkPlatformInterface.instance.user.deleteUserInGroup(
			_sdkId,
			groupId,
			user,
		);
	}

	Future<void> purgeUser(User user) async {
		return await CardinalSdkPlatformInterface.instance.user.purgeUser(
			_sdkId,
			user,
		);
	}

	Future<User> undeleteUser(User user) async {
		return await CardinalSdkPlatformInterface.instance.user.undeleteUser(
			_sdkId,
			user,
		);
	}

	Future<EntitySubscription<User>> subscribeToEvents(Set<SubscriptionEventType> events, FilterOptions filter, EntitySubscriptionConfiguration? subscriptionConfig) async {
		return await CardinalSdkPlatformInterface.instance.user.subscribeToEvents(
			_sdkId,
			events,
			filter,
			subscriptionConfig,
		);
	}
}